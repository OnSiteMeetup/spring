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

import spring.course.model.Student;
import spring.course.service.StudentService;

@RestController
@RequestMapping("/sendpoint")
public class EndPointStudent {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/student/", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> students = studentService.findAllStudents();
		if (null == students || students.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<RestResponse> getStudent(@PathVariable("id") long id) {
		Student student = studentService.findById(id);
		if (student == null) {
			return new ResponseEntity(new RestResponse("NOT_FOUND", "Student with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RestResponse>(new RestResponse("SUCCESS", student), HttpStatus.OK);
	}

	@RequestMapping(value = "/student/", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {

		if (studentService.isStudentExist(student)) {
			return new ResponseEntity(
					new RestResponse(
							"Unable to create. A Student with name " + student.getFirstName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/endpoint/student/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		Student resultStudent = studentService.findById(id);

		if (resultStudent == null) {
			return new ResponseEntity(new RestResponse("Unable to upate. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		resultStudent.setFirstName(student.getFirstName());
		resultStudent.setLastName(student.getLastName());

		resultStudent.setEmail(student.getEmail());
		resultStudent.setDateOfBirth(student.getDateOfBirth());

		resultStudent.setYearOfExp(student.getYearOfExp());

		studentService.updateStudent(resultStudent);
		return new ResponseEntity<Student>(resultStudent, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {

		Student student = studentService.findById(id);
		if (student == null) {
			return new ResponseEntity(new RestResponse("Unable to delete. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/student/", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudents() {
		studentService.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

}