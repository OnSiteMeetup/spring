package spring.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.course.model.Animal;
import spring.course.model.Student;
import spring.course.repositories.AnimalRepository;



@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService{

	@Autowired
	private AnimalRepository animalRepository;

	public Animal findById(Long id) {
		return animalRepository.findOne(id);
	}

	
	public Animal findByAvgAge(String name) {
		return animalRepository.findByAvgAge(name);
	}

	public void saveAnimal(Animal animal) {
		animalRepository.save(animal);
	}

	public void updateAnimal(Animal animal){
		saveAnimal(animal);
	}

	public void deleteAnimalById(Long id){
		animalRepository.delete(id);
	}

	public void deleteAllAnimals(){
		animalRepository.deleteAll();
	}

	
	public List<Animal> findAllAnimals(){
		return animalRepository.findAll();
	}

	public boolean isAnimalExist(Animal animal) {
		return findByavgAge(animal.getAvgAge()) != null;
	}


	@Override
	public Student findByAniname(String aniname) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Student findByavgAge(Long avgAge) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAnimalByAniName(Long aniname) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Animal findByAniName(String aniName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAnimalByAniName(String aniName) {
		// TODO Auto-generated method stub
		
	}

}