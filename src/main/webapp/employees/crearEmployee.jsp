<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 6/06/2024
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Crear nuevo employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1 class="mt-2">Crear nuevo employee</h1>
    <!--
        Para que se envíe el formulario debemos de tener en cuenta 4 cosas:
            método http: get/post (en este caso post)
            a donde va : a servlet -> jobServlet
            ¿qué voy a mandar? : deben tener un nombre "name" para identificarlo
            boton con type submit para que se pueda enviar
    -->
    <form class="mt-4" method="post" action="<%=request.getContextPath()%>/home"><!--form no aplica a nada visual, solo se usa para que se pueda enviar info -->
        <div class="mb-3"> <!--cuando mando, no importa el id, solo el name -->
            <label class="form-label">Employee ID</label>
            <input type="text" class="form-control" name="employeeId">
        </div>
        <div class="mb-3">
            <label class="form-label">Nombre y Apellido</label>
            <input type="text" class="form-control" name="nombreYapellido">
        </div>

        <div class="mb-3">
            <label class="form-label">correo</label>
            <input type="text" class="form-control" name="correo">
        </div>
        <div class="mb-3">
            <label class="form-label">Fecha de contrato</label>
            <input type="text" class="form-control" name="hire_date">
        </div>
        <div class="mb-3">
            <label class="form-label">Job Id</label>
            <input type="text" class="form-control" name="jobId">
        </div>
        <a href="<%=request.getContextPath()%>/home" class="btn btn-danger">Regresar</a>
        <button class="btn btn-warning" type="submit">Submit</button>
    </form>
</div>
</body>
</html>