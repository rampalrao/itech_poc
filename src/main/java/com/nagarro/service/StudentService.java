package com.nagarro.service;
import java.util.List;

import com.nagarro.entity.StudentEntity;


public interface StudentService {
	public void addStudent(StudentEntity student);
    public List<StudentEntity> getAllStudents();
    public void deleteStudent(Long studentId);
}
