package com.spring.student.repository;

import com.spring.student.model.students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class StudentJDBC {
    private static String url = "jdbc:postgresql://localhost:5432/project_spring";
    private static String user = "postgres";
    private static String password = "ashleon01";

    public static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Pilote not found");
        }
    }

    public List<students> findAll(){
        List<students> results = new ArrayList<>();
        try {
            Connection dataB = DriverManager.getConnection(url,user,password);
            PreparedStatement stm = dataB
                    .prepareStatement("select * from students");

            ResultSet myRs = stm.executeQuery();

            while(myRs.next()){
                System.out.println("id : " + myRs.getString("id_student"));
                System.out.println("nom : " + myRs.getString("name"));
                System.out.println("Group : " + myRs.getString("student_group"));
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    public List<students> findwherenamelike(){
        List<students> result = new ArrayList<>();
        try {
            //
            Scanner newObj = new Scanner(System.in);
            String giveName = newObj.nextLine();
            //
            Connection dataB = DriverManager.getConnection(url,user,password);
            PreparedStatement stm = dataB
                    .prepareStatement("select * from students where name like ?");
            stm.setString(1,giveName);

            ResultSet myRs = stm.executeQuery();

            while(myRs.next()){
                System.out.println("id : " + myRs.getString("id_student"));
                System.out.println("nom : " + myRs.getString("name"));
                System.out.println("Group : " + myRs.getString("student_group"));
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<students> findbyid(){
        List<students> result = new ArrayList<>();
        try {
            //
            Scanner newObj = new Scanner(System.in);
            Long giveId = Long.valueOf(newObj.nextLine());
            //
            Connection dataB = DriverManager.getConnection(url,user,password);
            PreparedStatement stm = dataB
                    .prepareStatement("select * from students where id_student == ?");
            stm.setLong(1,giveId);

            ResultSet myRs = stm.executeQuery();

            while(myRs.next()){
                System.out.println("id : " + myRs.getString("id_student"));
                System.out.println("nom : " + myRs.getString("name"));
                System.out.println("Group : " + myRs.getString("student_group"));
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void deletebyid(){
        try {
            //
            Scanner newObj = new Scanner(System.in);
            Long giveId = Long.valueOf(newObj.nextLine());
            //
            Connection dataB = DriverManager.getConnection(url,user,password);
            PreparedStatement stm = dataB
                    .prepareStatement("delete * from students where id_student == ? ");
            stm.setLong(1,giveId);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){
        try {
            //
            Scanner newObj = new Scanner(System.in);
            String giveName = newObj.nextLine();
            Long giveId = newObj.nextLong();
            String giveGName = newObj.nextLine();
            //
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stm;
            stm = conn.prepareStatement("insert into students values(?,?;?) ");
            stm.setLong(1, giveId);
            stm.setString(2,giveGName);
            stm.setString(3,giveName);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
