package com.nagarro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.AddressEntity;
import com.nagarro.entity.Student;
import com.nagarro.entity.StudentEntity;
import com.nagarro.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String sayHello(){
		return "hello";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public @ResponseBody String addStudent(@RequestBody Student student)
    {
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setFirstname(student.getFirstname());
		studentEntity.setLastname(student.getLastname());
		studentEntity.setEmail(student.getEmail());
		studentEntity.setTelephone(student.getTelephone());
		
		AddressEntity addressEntity=new AddressEntity();
		addressEntity.setCity("GGN");
		addressEntity.setCountry("INDIA");
		addressEntity.setState("HR");
		addressEntity.setStreet("SEC-5");
		addressEntity.setStudentEntity(studentEntity);
		studentEntity.setAddressEntity(addressEntity);
    	studentService.addStudent(studentEntity);
        return "Student Added Successfully.";
    }
	
    @RequestMapping(value="/deleteStudent/{studentId}" , method = RequestMethod.GET)
    public @ResponseBody String deleteStudent(@PathVariable Long studentId)
    {
    	studentService.deleteStudent(studentId);
        return "Delete Successfull.";
    }
   
}
