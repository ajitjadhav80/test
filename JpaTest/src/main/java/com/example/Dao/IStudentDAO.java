package com.example.Dao;

import java.util.List;

import com.example.Entity.Student;


public interface IStudentDAO {
	List<Student> getStudents();
	Student getStudent(int studentId);
	Student createStudent(Student student);
	Student updateStudent(int studentId,Student student);
	boolean deleteStudent(int studentId);

}
