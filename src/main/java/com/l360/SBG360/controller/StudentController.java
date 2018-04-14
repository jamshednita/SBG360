package com.l360.SBG360.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.l360.SBG360.bo.Student;
import com.l360.SBG360.exception.BusinessException;
import com.l360.SBG360.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/get/{id:[\\d]+}", method=RequestMethod.GET)
	public ResponseEntity<? extends Object> getStudent(@PathVariable("id") Integer id) {
		//RegEx is defined to accept only numeric digits in the URI for this handler method.
		
		System.out.println("Id of the student requested :: " +id);
		Student ret=null;
		try {
			ret = studentService.getUniqueStudent(id);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Student>(ret, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Integer id = studentService.saveStudent(student);
		System.out.println("Student profile created :: ID :: "+id);
		//return student; // Default status is always HttpStatus.OK for all successful operation. but we can customise this with the help of ResponseEntity<T> like below.
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		try {
			studentService.updateStudent(student);
		} catch (BusinessException e) {
			e.printStackTrace();
			new ResponseEntity<String>("Student Update Unsuccessfull for ID "+student.getId(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("Student info updated for ID "+student.getId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE, params="id")
	public ResponseEntity<String> deleteStudent(@RequestParam(required = false, defaultValue = "0", value = "id") Integer id) {
		try {
			studentService.deleteStudent(id);
		} catch (BusinessException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Student not found with ID "+id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("Delete Successfull !!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/patch", method=RequestMethod.PATCH)
	public void patchStudent(@RequestBody Student patchedStudent) {
		
	}
}
