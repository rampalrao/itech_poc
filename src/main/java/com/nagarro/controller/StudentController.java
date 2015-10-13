package com.nagarro.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.entity.AddressEntity;
import com.nagarro.entity.CarEntity;
import com.nagarro.entity.StudentEntity;
import com.nagarro.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listStudents(ModelMap map) {
		map.addAttribute("student", new StudentEntity());
		map.addAttribute("studentList", studentService.getAllStudents());
		return "editStudentList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute(value = "student") StudentEntity student) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity("GGN");
		addressEntity.setCountry("INDIA");
		addressEntity.setState("HR");
		addressEntity.setStreet("SEC-5");
		addressEntity.setStudentEntity(student);
		student.setAddressEntity(addressEntity);
		
		Set<CarEntity> carEntities=new HashSet<CarEntity>();
		CarEntity carEntity1=new CarEntity();
		carEntity1.setCarbrand("MARUTI");
		carEntity1.setCarcolor("RED");
		carEntity1.setCarname("ALTO");
		carEntity1.setStudentEntity(student);
		
		CarEntity carEntity2=new CarEntity();
		carEntity2.setCarbrand("HONDA");
		carEntity2.setCarcolor("WHITE");
		carEntity2.setCarname("AMAZE");
		carEntity2.setStudentEntity(student);
		
		carEntities.add(carEntity1);
		carEntities.add(carEntity2);
		
		student.setCars(carEntities);
		studentService.addStudent(student);
		return "redirect:/";
	}

	@RequestMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/";
	}

}
