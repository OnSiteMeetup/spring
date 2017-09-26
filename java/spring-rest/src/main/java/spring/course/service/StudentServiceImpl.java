package spring.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.course.configuration.MerticLogger;
import spring.course.model.Student;
import spring.course.repositories.StudentRepository;



@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	public Student findById(Long id) {
		return studentRepository.findOne(id);
	}

	
	public Student findByFirstName(String name) {
		return studentRepository.findByFirstName(name);
	}

	@MerticLogger
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	public void updateStudent(Student student){
		saveStudent(student);
	}

	public void deleteStudentById(Long id){
		studentRepository.delete(id);
	}

	public void deleteAllStudents(){
		studentRepository.deleteAll();
	}

	@MerticLogger
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}

	public boolean isStudentExist(Student student) {
		return findByFirstName(student.getFirstName()) != null;
	}

}
