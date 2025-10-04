package com.studentApp;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;//instance variables, instant variables are always going to be marked as private
	
	private int age;
	private String studentId;
	private List<String> courses;

		public Student(String name, int age, String studentId) {
		super();
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses = new ArrayList<>();
	}
	public void enrollCourse(String course) {
		courses.add(course);
		System.out.println("student enrolled" +course+ "successfully");
	}
	public void printStudentInfo() {
		System.out.println("=========Student information==========");
		System.out.println("Student Name: "+name);
		System.out.println("Student Age: "+age);
		System.out.println("Student studentId: "+studentId);
		System.out.println("Enrolled for: "+courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

}
