package spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.course.configuration.MerticLogger;
import spring.course.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {


	Animal findByAvgAge(String name);

}
