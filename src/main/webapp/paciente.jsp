<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Informacion del Paciente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-success ">
	  <div class="container-fluid">
	    <span class="navbar-brand mb-0 h1 text-light">Gestión de Pacientes</span>
	  </div>
	</nav>
	
	<div class="container col-md-5 mt-5">
	    <div class="card">
	        <div class="card-body">
	
				 <c:if test="${paciente != null}">
	              <form action="actualizarPaciente" method="get" >
	            </c:if>
	            <c:if test="${paciente == null}">
	              <form action="createPaciente" method="get" >
	            </c:if>
	            
	            	<c:if test="${paciente != null }">
	            		<h2>Editar Paciente</h2>
	            	</c:if>
	            	<c:if test="${paciente == null }">
	            		<h2>Agregar Paciente</h2>
	            	</c:if>
	            	
	            	<c:if test="${paciente == null && showInfo}">
	            		<h2>Información del paciente</h2>
	            	</c:if>
	            	
	            	<c:if test="${paciente != null }">
	            		<div class="form-floating mb-3">
						 	 <input type="text" class="form-control" id="id"  name="id"  value="<c:out value="${paciente.id }" />" >
						  	 <label for="id">Id del paciente</label>
						</div>
	            	</c:if>
	            
		            <div class="form-floating mb-3">
					  <input type="text" class="form-control" id="documento" name="documento" required value="<c:out value="${paciente.documento }" />" >
					  <label for="nombre">Documento</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="nombre"  name="nombre" required step="any" value="<c:out value="${paciente.nombre }" />" >
					  <label for="nota1">Nombre</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="apellido"  name="apellido" required step="any" value="<c:out value="${paciente.apellido }" />" >
					  <label for="nota1">Apellido </label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="email" class="form-control" id="email"  name="email" required step="any" value="<c:out value="${paciente.email }" />" >
					  <label for="nota1">Email</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="genero"  name="genero" required step="any" value="<c:out value="${paciente.genero }" />" >
					  <label for="nota1">Genero</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="date" class="form-control" id="fechaNacimiento"  name="fechaNacimiento" required step="any" value="<c:out value="${paciente.fechaNacimiento }" />" >
					  <label for="nota1">Fecha de Nacimiento</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="telefono"  name="telefono" required step="any" value="<c:out value="${paciente.telefono }" />" >
					  <label for="nota1">Telefono</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="direccion"  name="direccion" required step="any" value="<c:out value="${paciente.direccion }" />" >
					  <label for="nota1">Direccion</label>
					</div>
					
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="peso"  name="peso" required step="any" value="<c:out value="${paciente.peso }" />" >
					  <label for="nota1">Peso</label>
					</div>
										
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" id="estatura"  name="estatura" required step="any" value="<c:out value="${paciente.estatura }" />" >
					  <label for="nota1">Estatura</label>
					</div>
					<c:if test="${showInfo }"> 					
						<div class="form-floating mb-3">
						  <input type="text" class="form-control" id="nombre"  name="nota1" required step="any" value="<c:out value="${paciente.imc }" />" >
						  <label for="nota1">I.M.C</label>
						</div>
						<div class="form-floating mb-3">
						  <input type="text" class="form-control" id="nombre"  name="nota1" required step="any" value="<c:out value="${paciente.imc }" />" >
						  <label for="nota1">Indicador de Estado</label>
						</div>
					</c:if>
					
					
					<c:if test="${showInfo }"> 
						<a class="btn btn-primary" href="list" role="button">Regresar</a>				
					</c:if>
					<c:if test="${! showInfo }"> 
						<button class="btn btn-primary" type="submit" role="button">Enviar</button>
					</c:if>				
	            </form>
	           
	        </div>
	    </div>
	</div>
	
	
		
</body>
</html>