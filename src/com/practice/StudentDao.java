package com.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.*;  


public class StudentDao {
	public static boolean insertStudentToDb(Student st) {
		boolean flag = false;
		Connection con = ConnectionProvider.createConnection();	
		try {
			//jdbc code
			String querry = "insert into student(sname, sphone, scity) values(?,?,?)";
			//prepared statement...
		    PreparedStatement	pStatement = con.prepareStatement(querry);
		    //set the values of parameters.
		    pStatement.setString(1, st.getStudentName());
		    pStatement.setString(2, st.getStudentPhone());
		    pStatement.setString(3, st.getStudentCity());
		    
		    //Execute
		    pStatement.executeUpdate();
		    flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		Connection con = ConnectionProvider.createConnection();	
		try {
			//jdbc code
			String querry = "delete from student where sid=?";
			//prepared statement...
		    PreparedStatement	pStatement = con.prepareStatement(querry);
		    //set the values of parameters.
		    pStatement.setInt(1, userId);
		   
		    //Execute
		    pStatement.executeUpdate();
		    flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
		
	}

	public static void showAllStudent() {
		Connection con = ConnectionProvider.createConnection();	
		try {
			//jdbc code
			String querry = "select * from student;";
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(querry);
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phone = resultSet.getString(3);
				String city = resultSet.getString("scity");
				
				System.out.println("Id : "+ id);
				System.out.println("Name : "+ name);
				System.out.println("Phone : "+ phone);
				System.out.println("City : "+ city);
				
				System.out.println("----------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
