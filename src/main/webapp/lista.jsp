<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- Boostrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	
	<nav class="navbar bg-success ">
	  <div class="container-fluid">
	    <span class="navbar-brand mb-0 h1 text-light">Gestión de Pacientes</span>
	  </div>
	</nav>
	
	<table class="table table-striped table-hover">
	  <thead>
		    <tr>
		    <th scope="col">ID</th>
		      <th scope="col">Documento</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">Email</th>
		      <th scope="col">Genero</th>
		      <th scope="col">Fecha nacimiento</th>
		      <th scope="col">Telefono</th>
		      <th scope="col">Dirección</th>
		      <th scope="col">Peso</th>
		      <th scope="col">Estatura</th>
		      <th scope="col">I.M.C</th>
		    </tr>
	  </thead>
	  <tbody>
	   <c:forEach var="patient" items="${listPatient}">
		    <tr>
		      <th scope="row"> 
		      	<c:out value="${patient.id}"></c:out>
		      </th>
		      <td>
		      	<c:out value="${patient.documento }"></c:out>
		      </td>
		      <td>
		      	<c:out value="${patient.nombre}"></c:out>
		      </td>
		      <td>
		      	<c:out value="${patient.apellido}"></c:out>
		      </td>
		      <td>
		      	<c:out value="${patient.email}"></c:out>
		      </td>
			  <td>
		      	<c:out value="${patient.genero}"></c:out>
		      </td>
		       <td>
		      	<c:out value="${patient.fechaNacimiento}"></c:out>
		      </td>
		       <td>
		      	<c:out value="${patient.telefono}"></c:out>
		      </td>
		       <td>
		      	<c:out value="${patient.direccion}"></c:out>
		      </td>
		       <td>
		      	<c:out value="${patient.peso}"></c:out>
		      </td>
		       <td>
		      	<c:out value="${patient.estatura}"></c:out>
		      </td>
		       <td>
		      	<c:out value="${patient.imc}"></c:out>
		      </td>
		      <td> 
		      	<a class="btn btn-primary" href="mostrarPaciente?id=<c:out value="${patient.id}" /> " role="button">Ver información</a>
		      	<a class="btn btn-secondary" href="actualizarPaciente?id=<c:out value="${patient.id}" /> " role="button">Editar</a>
		      	<a class="btn btn-danger" href="eliminarPaciente?id=<c:out value="${patient.id}" /> " role="button">Eliminar</a>
		      </td>
		    </tr>
		</c:forEach>
	  </tbody>
	</table>
	<a href="<%= request.getContextPath()%>/createPaciente" class="btn btn-primary">Agregar nuevo paciente</a>
</body>
</html>