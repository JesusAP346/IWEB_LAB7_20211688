package org.example.lab7_20211688.daos;

import org.example.lab7_20211688.beans.JobB;

import java.sql.*;
import java.util.ArrayList;

public class DaoJobs {
    public ArrayList<JobB> listarJobs(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "select * from jobs";
        ArrayList<JobB> listaJobs = new ArrayList<JobB>();


        try(Connection conn = DriverManager.getConnection(url,username,password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {//usamos try con recursos

            while(rs.next()){
                JobB job = new JobB();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
                listaJobs.add(job);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaJobs;
    }

    public void crearTrabajo(String jobId,String jobTitle,int minSalary,int maxSalary){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "insert into jobs (job_id,job_title,min_salary,max_salary) values (?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(url,username,password); PreparedStatement pstmt = conn.prepareStatement(sql);) { // usando try con recursos

            pstmt.setString(1,jobId);
            pstmt.setString(2,jobTitle);
            pstmt.setInt(3,minSalary);
            pstmt.setInt(4,maxSalary);

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JobB buscarPorId(String id) {
        JobB job = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "select * from jobs where job_id = ?";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    job = new JobB();
                    job.setJobId(rs.getString(1));
                    job.setJobTitle(rs.getString(2));
                    job.setMinSalary(rs.getInt(3));
                    job.setMaxSalary(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return job;
    }

}
