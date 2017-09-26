package spring.course.service;


import java.util.List;

import spring.course.model.Animal;
import spring.course.model.Student;

public interface AnimalService {
	
	Student findByAniname(String aniname);

	Student findByavgAge(Long avgAge);

	void saveAnimal(Animal animal);

	void updateAnimal(Animal animal);

	void deleteAnimalByAniName(Long aniname);

	void deleteAllAnimals();

	List<Animal> findAllAnimals();

	boolean isAnimalExist(Animal animal);

	Animal findByAniName(String aniName);

	void deleteAnimalByAniName(String aniName);
}