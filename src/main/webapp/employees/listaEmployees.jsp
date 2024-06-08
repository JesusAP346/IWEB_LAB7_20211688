<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 6/06/2024
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.lab7_20211688.beans.EmployeesB" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="lista" scope="request" type="ArrayList<EmployeesB>"/>


<html>
<head>
    <title>Lista de empleados</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<h1>Lista de employees</h1>


<a href="<%=request.getContextPath()%>/home?action=new" class="btn btn-success mt-2">Crear nuevo employee</a>


<table class="table table-striped table-hover mt-3">
    <tr class="table-info">
        <th>Employee ID</th>
        <th>Nombre y apellido</th>
        <th>Email</th>
        <th>Fecha de contrato</th>
        <th>Job ID</th>
        <th></th>
        <th></th>
        <th></th>

    </tr>
    <%for(EmployeesB employeesB : lista){%>
    <tr>
        <td><%=employeesB.getEmployee_id() %></td>
        <td><%=employeesB.getFullNameEmployee() %></td>
        <td><%=employeesB.getEmail() %></td>
        <td><%=employeesB.getHireDate() %></td>
        <td><%=employeesB.getJobId() %></td>
        <td><a href="<%=request.getContextPath()%>/home?action=edit&idEmployee=<%=employeesB.getEmployee_id()%>" class="btn btn-warning">EDITAR</a></td>
        <td><a onclick="return confirm('¿Esta seguro de borrar?')" href="<%=request.getContextPath()%>/home?action=delete&idEmployee=<%=employeesB.getEmployee_id()%>" class="btn btn-warning">BORRAR</a></td>
    </tr>
    <% } %>

</table>

</body>
</html>
