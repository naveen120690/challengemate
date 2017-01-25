package com.smartkart.challengemate.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartkart.challengemate.dao.StudentDAO;
import com.smartkart.challengemate.model.Student;

@Service("studentService")
public class StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Transactional
	public Student addStudent(Student student){
		return studentDAO.addStudent(student);
	}
}
