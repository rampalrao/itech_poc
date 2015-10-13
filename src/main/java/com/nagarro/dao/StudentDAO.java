package com.nagarro.dao;

import java.util.List;

import com.nagarro.entity.StudentEntity;

public interface StudentDAO {
	public void addStudent(StudentEntity student);
    public List<StudentEntity> getAllStudents();
    public void deleteStudent(Long studentId);
}
