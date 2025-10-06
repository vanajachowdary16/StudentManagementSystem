package com.studentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;//instance variables, instant variables are always going to be marked as private
	
	private int age;
	private String studentId;
	private List<String> courses;

		public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age)&&validateName(name) && validateStudentId(studentId)) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses = new ArrayList<>();
	}
		}
	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$";
		Pattern studentIdPattern =Pattern.compile(studentIdRegex);
		Matcher studentIdmatcher = studentIdPattern.matcher(studentId);
		if(studentIdmatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid student id---use format s-123");
			return false;
		}
		}
	public void enrollCourse(String course) {
		if(courses.contains(course) && validateCourseName(course)) {
			System.err.println("course is already enrolled!!! " +course);
		}else {
		courses.add(course);
		System.out.println("student enrolled " +course+ " successfully");
		}
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
	public boolean validateAge(int age) {
		if(age>=19 && age<=35) {
			return true;
		}
		else {
			System.err.println("Invalid age!!! student age should be between 19 and 35");
			return false;
		}
	}
	
	public boolean validateName(String name) {
		
		String nameRegex ="^[a-zA-Z\\s]+$";
		Pattern namePattern=Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if(nameMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid Name!!! Please enter alphabets only");
			return false;
		}
	}
	
	public boolean validateCourseName(String course) {
		if(course.equalsIgnoreCase("java") && course.equalsIgnoreCase("Dsa")&& course.equalsIgnoreCase("sql")) {
			return true;
		}else {
			System.err.println("Invalid courses!!! please select courses from the list");
					return false;
		}
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getStudentId() {
		return studentId;
	}
	public List<String> getCourses() {
		return courses;
	}
	
	
	
	
	
	
	

}
