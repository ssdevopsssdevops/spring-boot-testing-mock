package com.example.demo.mockmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mockmvc.model.Student;


@Service
public class StudentService {

	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		students.add(student);
		return students;
	}

	public Student saveStudent(Student student) {
		student.setId(1);
		student.setName("Mike");
		return student;
	}

	public Student updateStudent(Student student) {
		student.setId(2);
		student.setName("John");
		return student;
	}

	public String deleteStudent(String studentId) {
		return "Student is deleted";
	}
}
