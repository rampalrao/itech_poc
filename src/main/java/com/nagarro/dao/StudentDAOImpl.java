package com.nagarro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.StudentEntity;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void addStudent(StudentEntity student) {
		this.sessionFactory.getCurrentSession().save(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentEntity> getAllStudents() {
		return this.sessionFactory.getCurrentSession().createQuery("from StudentEntity").list();
	}

	@Override
	public void deleteStudent(Long studentId) {
		StudentEntity entity=(StudentEntity) this.sessionFactory.getCurrentSession().get(StudentEntity.class, studentId);
		if(null!=entity){
			this.sessionFactory.getCurrentSession().delete(entity);
		}
	}

}
