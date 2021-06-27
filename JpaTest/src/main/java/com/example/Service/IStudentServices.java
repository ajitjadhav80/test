package com.example.Service;
import java.util.List;
import com.example.Entity.Student;
public interface IStudentServices {
	List<Student> getStudents();
	Student createStudent(Student student);
	Student updateStudent(int studentId, Student student);
	Student getStudent(int studentId);
	boolean deleteStudent(int studentId);
}
