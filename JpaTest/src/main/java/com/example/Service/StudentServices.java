package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.IStudentDAO;
import com.example.Entity.Student;

@Service
public class StudentServices implements IStudentServices{

	
	@Autowired
	IStudentDAO dao;
	
	@Override
	public List<Student> getStudents() {
		return dao.getStudents();
	}

	@Override
	public Student createStudent(Student student) {
		return dao.createStudent(student);
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		return dao.updateStudent(studentId, student);
	}

	@Override
	public Student getStudent(int studentId) {
		return dao.getStudent(studentId);
	}

	@Override
	public boolean deleteStudent(int StudentId) {
		return dao.deleteStudent(StudentId);
	}


}
