package spring.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import spring.course.model.Animal;
import spring.course.service.AnimalService;

@RestController
@RequestMapping("/endpoint")
public class EndPointAnimal {

	@Autowired
	AnimalService animalService;

	@RequestMapping(value = "/animal/", method = RequestMethod.GET)
	public ResponseEntity<List<Animal>> getAllAnimal() {
		List<Animal> animals = animalService.findAllAnimals();
		if (null == animals || animals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Animal>>(animals, HttpStatus.OK);
	}

	@RequestMapping(value = "/animal/{aniName}", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> getAnimal(@PathVariable("aniName") String aniName) {
		Animal animal = animalService.findByAniName(aniName);
		if (animal == null) {
			return new ResponseEntity(new RestResponse("NOT_FOUND", "Animal with aniName " + aniName + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RestResponse>(new RestResponse("SUCCESS", animal), HttpStatus.OK);
	}

	@RequestMapping(value = "/animal/", method = RequestMethod.POST)
	public ResponseEntity<?> createAnimal(@RequestBody Animal animal, UriComponentsBuilder ucBuilder) {

		if (animalService.isAnimalExist(animal)) {
			return new ResponseEntity(
					new RestResponse(
							"Unable to create. A Animal with name " + animal.getAvgAge() + " already exist."),
					HttpStatus.CONFLICT);
		}
		animalService.saveAnimal(animal);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/endpoint/animal/{aniName}").buildAndExpand(animal.getAniName()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/animal/{aniName}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAnimal(@PathVariable("aniName") String aniName, @RequestBody Animal animal) {
		Animal resultAnimal = animalService.findByAniName(aniName);

		if (resultAnimal == null) {
			return new ResponseEntity(new RestResponse("Unable to upate. Animal with aniName " + aniName + " not found."),
					HttpStatus.NOT_FOUND);
		}

		resultAnimal.setAvgAge(animal.getAvgAge());
		resultAnimal.setHeight(animal.getHeight());

		resultAnimal.setWeight(animal.getWeight());
		resultAnimal.setFoodStyle(animal.getFoodStyle());

		resultAnimal.setExtinctingSpecies(animal.getExtinctingSpecies());

		animalService.updateAnimal(resultAnimal);
		return new ResponseEntity<Animal>(resultAnimal, HttpStatus.OK);
	}

	@RequestMapping(value = "/animal/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAnimal(@PathVariable("aniName") String aniName) {

		Animal animal = animalService.findByAniName(aniName);
		if (animal == null) {
			return new ResponseEntity(new RestResponse("Unable to delete. Animal with aniName " + aniName + " not found."),
					HttpStatus.NOT_FOUND);
		}
		animalService.deleteAnimalByAniName(aniName);
		return new ResponseEntity<Animal>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/animal/", method = RequestMethod.DELETE)
	public ResponseEntity<Animal> deleteAllAnimals() {
		animalService.deleteAllAnimals();
		return new ResponseEntity<Animal>(HttpStatus.NO_CONTENT);
	}
}