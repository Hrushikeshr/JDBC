package com.practice;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Student managment app");
		while(true) {
			System.out.println("Enter 1 to add student");
			System.out.println("Enter 2 to delet student");
			System.out.println("Enter 3 to display student");
			System.out.println("Enter 4 to Exit app");
			int option = scanner.nextInt();
			if (option ==1){
				//Add Student
				System.out.println("Enter user name: ");
				String name = scanner.next();
				
				System.out.println("Enter user Phone: ");
				String phone = scanner.next();
				
				System.out.println("Enter user City: ");
				String city = scanner.next();
				
				//Create Student object to store student details.
				Student st = new Student(name, phone, city);
			  boolean answer = StudentDao.insertStudentToDb(st);
			  if (answer) {
				System.out.println("Sucessfully Added student");
			}
			  else {
				System.out.println("Something went wrong try again...");
			}
			  
			  System.out.println(st);
				
			}
			else if (option == 2) {
				// Delete Student
				System.out.println("Enter student id to delete: ");
				int userId= scanner.nextInt();
				boolean answer = StudentDao.deleteStudent(userId);
				
				if (answer) {
					System.out.println("Sucessfully Deleted student");
				}
				  else {
					System.out.println("Something went wrong try again...");
				}
			}
			else if (option == 3) {
				// Display Student
			}
			else if (option == 4) {
				//Exit Student
				break;
			}
			else {
				
			}
			
		}
		System.out.println("Thanks For using my application...");
		System.out.println("See You Soon..");
		scanner.close();	
	}

}
