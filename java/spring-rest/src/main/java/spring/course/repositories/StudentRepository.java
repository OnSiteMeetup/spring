package spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.course.configuration.MerticLogger;
import spring.course.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


	Student findByFirstName(String name);

}
