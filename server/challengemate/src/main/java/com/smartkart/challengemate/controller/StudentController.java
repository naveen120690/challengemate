package com.smartkart.challengemate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartkart.challengemate.model.Student;
import com.smartkart.challengemate.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/demo", method=RequestMethod.GET)
	public String demo(){
		
		Student student=new Student(1, "naveen","Karnal");
		studentService.addStudent(student);
		
		return "Hello World";
	}
}
