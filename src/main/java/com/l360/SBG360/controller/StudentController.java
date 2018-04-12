package com.l360.SBG360.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.l360.SBG360.bo.Student;
import com.l360.SBG360.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable("id") Integer id) {
		// Make call to service layer to perform required business logic
		System.out.println("Id of the student requested :: " +id);
		Student ret = studentService.getUniqueStudent(id);
		
		return ret;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		Integer id = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}