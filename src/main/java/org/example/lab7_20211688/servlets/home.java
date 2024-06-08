package org.example.lab7_20211688.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab7_20211688.beans.EmployeesB;
import org.example.lab7_20211688.daos.DaoEmployees;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "home", value = "/home")
public class home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //primero obtengo la lista del Dao
        DaoEmployees employeesDao = new DaoEmployees();
        ArrayList<EmployeesB> listaEmployees= employeesDao.listarEmployees();

        String action = request.getParameter("action")==null?"lista":request.getParameter("action");
        switch (action) {
            case "new":
                request.getRequestDispatcher("employees/crearEmployee.jsp").forward(request,response);
                break;
            case "lista":

                String vista = "employees/listaEmployees.jsp";
                request.setAttribute("lista",listaEmployees);
                RequestDispatcher rd = request.getRequestDispatcher(vista);//le pongo la información
                rd.forward(request,response);//vista comienza  a correr
                break;
            case "edit":
                String idEmployee = request.getParameter("idEmployee");
                EmployeesB employeesB = employeesDao.buscarPorId(idEmployee);
                if(employeesB != null){
                    request.setAttribute("employee",employeesB);
                    request.getRequestDispatcher("employees/editarEmployee.jsp").forward(request,response);
                }
                else{
                    response.sendRedirect(request.getContextPath() + "/home");
                }

                break;
            case "delete":
                String idEmployeeDelete = request.getParameter("idEmployee");
                EmployeesB employeeDelete = employeesDao.buscarPorId(idEmployeeDelete);

                if(employeeDelete != null){
                    try {
                        employeesDao.borrar(idEmployeeDelete);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/home");
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        DaoEmployees employeesDao = new DaoEmployees();
        String action = request.getParameter("action")==null?"crear":request.getParameter("action");

        //ahora creamos el trabajo
        String id = request.getParameter("employeeId");
        String nombreyApellido = request.getParameter("nombreYapellido");
        String correo = request.getParameter("correo");
        String h_date = request.getParameter("hire_date");
        String idJob = request.getParameter("jobId");
        EmployeesB employee = new EmployeesB(correo,Integer.parseInt(id),nombreyApellido,h_date,idJob);

        switch(action){
            case "crear":
                employeesDao.crearEmployee(employee);
                break;
            case "editar":
                employeesDao.actualizarEmployee(employee);
                break;

        }

        response.sendRedirect(request.getContextPath() + "/home");

    }
}
