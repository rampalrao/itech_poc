package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.dao.StudentDAO;
import com.nagarro.entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public void addStudent(StudentEntity student) {
		studentDAO.addStudent(student);
	}

	@Override
	@Transactional
	public List<StudentEntity> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	@Transactional
	public void deleteStudent(Long studentId) {
		studentDAO.deleteStudent(studentId);
	}

}
