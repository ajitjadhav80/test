package com.example.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Entity.Student;
import com.example.Service.IStudentServices;
@Controller
@RequestMapping("studentservice")
public class StudentController {

	@Autowired
	IStudentServices service;

	@GetMapping("student")
	public ResponseEntity<List<Student>> getStudent(){
		
		List<Student> student = service.getStudents();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Integer id){
		Student student = service.getStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PostMapping("books")
	public ResponseEntity<Student> createBook(@RequestBody Student student){
		Student b = service.createStudent(student);
		return new ResponseEntity<Student>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
		
		Student b = service.updateStudent(id, student);
		return new ResponseEntity<Student>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
		boolean isDeleted = service.deleteStudent(id);
		if(isDeleted){
			String responseContent = "Book has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting book from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
