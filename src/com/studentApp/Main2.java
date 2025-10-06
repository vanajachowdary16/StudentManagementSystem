package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static List<Student> studentlist = new ArrayList<Student>();
	private static Scanner scanner;
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
		Student s4 = new Student("rithu", 25, "S-4");
		s3.enrollCourse("Dsa");
		studentlist.add(s1);
		studentlist.add(s2);
		studentlist.add(s3);
		studentlist.add(s4);
		
		
		Student result =findStudentById("S-1");
		System.out.println("Results: "+result);
		sortByName();
	}
	
	public static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2)-> o1.getName().compareTo(o2.getName());
		/*
		 * @Override
			public int compare(Student o1, Student o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		 */
		
		Collections.sort(studentlist, studentNameComparator);
		System.out.println(studentlist);
	}
	
	public static  Student findStudentById(String studentId) {
		
		Student result = null;
		
		try{
			result= studentlist.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId))
		
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No Data found !!!!"));
		
		
		}catch(RuntimeException e) {
			
			System.err.println("Student with ID "+studentId + "not found!!!");
			
		}
		return result;
		
	}

}
