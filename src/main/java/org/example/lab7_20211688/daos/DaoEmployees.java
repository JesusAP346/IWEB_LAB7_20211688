package org.example.lab7_20211688.daos;

import org.example.lab7_20211688.beans.EmployeesB;

import java.sql.*;
import java.util.ArrayList;

public class DaoEmployees {
    public ArrayList<EmployeesB> listarEmployees() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "SELECT employee_id, CONCAT(first_name, ' ', last_name) AS full_name, email, hire_date, job_id FROM employees";

        ArrayList<EmployeesB> listaEmployees = new ArrayList<EmployeesB>();


        try(Connection conn = DriverManager.getConnection(url,username,password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {//usamos try con recursos

            while(rs.next()){
                EmployeesB employeesB = new EmployeesB();
                employeesB.setEmployee_id(rs.getInt(1));
                employeesB.setFullNameEmployee(rs.getString(2));
                employeesB.setEmail(rs.getString(3));
                employeesB.setHireDate(rs.getString(4));
                employeesB.setJobId(rs.getString(5));
                listaEmployees.add(employeesB);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEmployees;
    }


    public EmployeesB buscarPorId(String idEmployee) {
        EmployeesB employeesB = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";


        String sql = "SELECT employee_id, CONCAT(first_name, ' ', last_name) , email, hire_date,job_id FROM employees where employee_id = ?";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,idEmployee);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    employeesB = new EmployeesB();
                    employeesB.setEmployee_id(rs.getInt(1));
                    employeesB.setFullNameEmployee(rs.getString(2));
                    employeesB.setEmail(rs.getString(3));
                    employeesB.setHireDate(rs.getString(4));
                    employeesB.setJobId(rs.getString(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeesB;
    }

    public void actualizarEmployee( EmployeesB employeesB) {

        //EmployeesB employeesB =  buscarPorId(Integer.toString(idEmployee));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "update employees set first_name = ?, last_name = ?, email = ?, hire_date = ?, job_id = ? where employee_id = ?";
        try(Connection conn = DriverManager.getConnection(url,username,password); PreparedStatement pstmt = conn.prepareStatement(sql);) { // usando try con recursos

            String nombreyApellido = employeesB.getFullNameEmployee();
            String[] palabras = nombreyApellido.split(" ");

            pstmt.setString(1,palabras[0]);
            pstmt.setString(2,palabras[1]);
            pstmt.setString(3,employeesB.getEmail());
            pstmt.setString(4,employeesB.getHireDate());
            pstmt.setString(5,employeesB.getJobId());
            pstmt.setInt(6,employeesB.getEmployee_id());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void crearEmployee(EmployeesB employeesB ){
        //EmployeesB employeesB = buscarPorId(Integer.toString(id));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "insert into employees (employee_id,first_name,last_name,email,hire_date,job_id) values (?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(url,username,password); PreparedStatement pstmt = conn.prepareStatement(sql);) { // usando try con recursos


            pstmt.setInt(1,employeesB.getEmployee_id());

            String nombreyApellido = employeesB.getFullNameEmployee();
            String[] palabras = nombreyApellido.split(" ");

            pstmt.setString(2,palabras[0]);
            pstmt.setString(3,palabras[1]);
            pstmt.setString(4,employeesB.getEmail());
            pstmt.setString(5,employeesB.getHireDate());
            pstmt.setString(6,employeesB.getJobId());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void borrar(String idEmployee) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "delete from employees where employee_id = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,idEmployee);
            pstmt.executeUpdate();

        }
    }


}
