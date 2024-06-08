<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 6/06/2024
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.lab7_20211688.beans.EmployeesB" %>
<jsp:useBean id="employee" scope="request" type="org.example.lab7_20211688.beans.EmployeesB"/>


<html>
<head>
    <title>editar employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1 class="mt-2">Editar employee</h1>

    <form class="mt-4" method="post" action="<%=request.getContextPath()%>/home?action=editar"><!--form no aplica a nada visual, solo se usa para que se pueda enviar info -->
        <div class="mb-3"> <!--cuando mando, no importa el id, solo el name -->

            <input type="hidden" class="form-control" name="employeeId" value="<%=employee.getEmployee_id()%>">
        </div>
        <div class="mb-3">
            <label  class="form-label">Nombre y Apellido</label>
            <input type="text" class="form-control"  name="nombreYapellido" value="<%=employee.getFullNameEmployee()%>">
        </div>
        <div class="mb-3">
            <label  class="form-label">correo</label>
            <input type="text" class="form-control"  name="correo" value="<%=employee.getEmail()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Fecha de contrato</label>
            <input type="text" class="form-control"  name="hire_date" value="<%=employee.getHireDate()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Job Id</label>
            <input type="text" class="form-control" name="jobId" value="<%=employee.getJobId()%>">
        </div>

        <a href="<%=request.getContextPath()%>/home" class="btn btn-danger">Regresar</a>
        <button class="btn btn-warning" type="submit">Submit</button>
    </form>
</div>
</body>
</html>