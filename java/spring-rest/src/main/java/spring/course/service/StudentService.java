package spring.course.service;


import java.util.List;

import spring.course.model.Student;

public interface StudentService {
	
	Student findById(Long id);

	Student findByFirstName(String name);

	void saveStudent(Student student);

	void updateStudent(Student student);

	void deleteStudentById(Long id);

	void deleteAllStudents();

	List<Student> findAllStudents();

	boolean isStudentExist(Student student);
}