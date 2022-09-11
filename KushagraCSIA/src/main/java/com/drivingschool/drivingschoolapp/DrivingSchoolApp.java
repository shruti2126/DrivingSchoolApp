/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.drivingschool.drivingschoolapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sssha
 */
public class DrivingSchoolApp {

     static Connection conn = null;
     static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
     static final String DB_URL = "jdbc:mysql://localhost/3306/driving_school";
     
     //Database credentials
     static final String USERNAME = "root";
     static final String PASSWORD = "root";
     
     public static void main(String[] args) throws ClassNotFoundException {
       DrivingSchoolApp drivingSchool = new DrivingSchoolApp();
       drivingSchool.getUserInfo();
    }
     
     private void getUserInfo() {
         
         Statement stmt = null;
         try { 
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Creating statement...");
            
            System.out.println("..................................");
            
            stmt = conn.createStatement();
            String sql = "Select name, email from Users";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.close();
            stmt.close();
            conn.close();
            
         } catch(SQLException se) {
             se.printStackTrace();
         } catch(ClassNotFoundException e) {
             e.printStackTrace();
         } finally {
             try {
                if(stmt != null) {
                    stmt.close();
                }
             } catch(SQLException sqlException) {
                sqlException.printStackTrace();
             }
             try {
                 if(conn != null) {
                     conn.close();
                 }
             } catch(SQLException  sqlException) {
                sqlException.printStackTrace();
             } 
         }
     }
}
