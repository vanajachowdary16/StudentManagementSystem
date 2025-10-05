package com.studentApp;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	public static List<Student> studentlist = new ArrayList<Student>();
	public static void main(String[] args) {
		System.out.println("***********Student Management System***********");
		System.out.println("********Welcome**********");
		Student s1;
		
		s1=new Student("kajal", 22, "S-1");
		s1.enrollCourse("java");
		s1.enrollCourse("java");
		s1.enrollCourse("sql");
		System.out.println(s1);
		
		Student s2 = new Student("uday", 33, "S-2");
		
		Student s3= new Student("chinnu", 24, "S-3");
		s3.enrollCourse("Dsa");
		studentlist.add(s1);
		studentlist.add(s2);
		studentlist.add(s3);
		
	}
	public static  void findStudentById(String studentId) {
		studentlist.stream().filter(x->x.validateAge(0))
		
	}

}
