package com.example.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Student;

@Transactional
@Repository
public class StudentDAO implements IStudentDAO{
	@PersistenceContext
	private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")


	/**
	 * This method is responsible to get a particular Student detail by given Student id 
	 */
	@Override
	public Student getStudent(int studentId) {
		
		return entityManager.find(Student.class, studentId);
	}

	/**
	 * This method is responsible to create new Student in database
	 */
	@Override
	public Student createStudent(Student student) {
		entityManager.persist(student);
		Student b = getLastInsertedStudent();
		return b;
	}

	/**
	 * This method is responsible to update Student detail in database
	 */
	@Override
	public Student updateStudent(int studentId, Student student) {
		
		//First We are taking Student detail from database by given Student id and 
		// then updating detail with provided Student object
		Student StudentFromDB = getStudent(studentId);
		StudentFromDB.setFname(student.getFname());
		StudentFromDB.setLname(student.getLname());
		StudentFromDB.setContact(student.getContact());
		entityManager.flush();
		
		//again i am taking updated result of Student and returning the Student object
		Student updatedStudent = getStudent(studentId);
		
		return updatedStudent;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteStudent(int studentId) {
		Student student = getStudent(studentId);
		entityManager.remove(student);
		
		//we are checking here that whether entityManager contains earlier deleted Student or not
		// if contains then Student is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(student);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Student class
	 * @return Student
	 */
	private Student getLastInsertedStudent(){
		String hql = "from Student order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Student student = (Student)query.getSingleResult();
		return student;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}
}
