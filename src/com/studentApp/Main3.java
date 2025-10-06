package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	public static List<Student> studentlist = new ArrayList<Student>();
	private static Scanner scanner;
		
		public static void main(String[] args) {
			System.out.println("***********Student Management System***********");
			System.out.println("********Welcome**********");
			//Read input from the terminal
			scanner = new Scanner(System.in);
			System.out.println("enter your name");
			String name = scanner.next();
			System.out.println("you have entered "+name);
			System.out.println("1.Register a student");
			System.out.println("2.find a student with studentid");
			System.out.println("3.List all student information");
			System.out.println("1.List student information in sorted order");
			int option = scanner.nextInt();
			switch(option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentsById(scanner);
				break;
			case 3:
				printAllstudents(scanner);
				break;
			case 4: 
				sortByName();
				break;
			case 5:
				exit();
				break;
			default : System.out.println("Invalid Option selected");
			
			}
			
			
			
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
		private static void exit() {
			// TODO Auto-generated method stub
			
		}
		private static void findStudentsById(Scanner scanner2) {
			// TODO Auto-generated method stub
			
		}
		private static void printAllstudents(Scanner scanner2) {
			// TODO Auto-generated method stub
			if(studentlist.size()>0) {
				
			
			System.out.println("============print all student data==============");
			for(Student student : studentlist) {
				student.printStudentInfo();
			}
			}
			else {
				System.out.println("student list is empty!!!--------");
			}
			
		}
		private static void enrollStudent(Scanner scanner2) {
			// TODO Auto-generated method stub
			System.out.println("enter the student name");
			String studentName = scanner2.next();
			System.out.println("enter the student age");
			int studentAge = scanner2.nextInt();
			System.out.println("enter the student id");
			String studentId = scanner2.next();
			
			Student newStudent = new Student(studentName, studentAge, studentId);
			studentlist.add(newStudent);
			while(true) {
			System.out.println("enter courses to be enrolled");
			String courseName = scanner2.next();
			if(courseName.equalsIgnoreCase("done")) {
			break;
			}
			newStudent.enrollCourse(courseName);
			}
			newStudent.printStudentInfo();
			
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
