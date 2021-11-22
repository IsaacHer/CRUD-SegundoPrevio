<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elecciones Electronicas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
 crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="#" class="mavbar-brand">Gestión de Candidatos</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Candidatos</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<c:if test="${candidato != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${candidato == null}">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${usuario != null}">
							Editar Candidato
						</c:if>
						<c:if test="${usuario == null}">
							Agregar Nuevo Candidato
						</c:if>
					</h2>
				</caption>
				
				<c:if test="${candidato != null}">
					<input type="hidden" name="id" value="<c:out value='${candidato.id}'/>"/>
				</c:if>
				
				<fieldset class="form-group">
					<label>Documento del candidato</label> <input type="text" value="<c:out value='${candidato.documento}'/>" class="form-control" name="documento" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre del candidato</label> <input type="text" value="<c:out value='${candidato.nombre}'/>" class="form-control" name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Apellido del candidato</label> <input type="text" value="<c:out value='${candidato.apellido}'/>" class="form-control" name="apellido" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Eleccion</label> <input type="text" value="<c:out value='${candidato.eleccion}'/>" class="form-control" name="eleccion" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Numero del candidato</label> <input type="text" value="<c:out value='${candidato.numero}'/>" class="form-control" name="numerp" required="required">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Guardar</button>
				
			
			</div>
		</div>
	</div>
</body>
</html>