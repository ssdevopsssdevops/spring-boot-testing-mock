package com.example.demo.mockmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mockmvc.constant.URIConstant;
import com.example.demo.mockmvc.model.Student;
import com.example.demo.mockmvc.service.StudentService;



@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(URIConstant.GET_MAPPING)
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping(URIConstant.POST_MAPPING)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		student = studentService.saveStudent(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PutMapping(URIConstant.PUT_MAPPING)
	public ResponseEntity<Student> putExample(@RequestBody Student student) {
		student = studentService.updateStudent(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping(URIConstant.DELETE_MAPPING)
	public ResponseEntity<String> deleteExample(@RequestParam("student-id") String studentId) {
		String response = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
