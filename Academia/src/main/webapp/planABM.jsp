<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABM de plan</title>
</head>
<body>
	<c:if test="${param.opcion != null }">
		<c:choose>
			<c:when test="${param.opcion == 1 }">
				<header>
        			<h1>Alta de plan</h1>
    			</header>
    			<form action="ControlaPlan" method="POST">
        			<input type="text" name="idPlan" id="idPlanTextBox" disabled="true" placeholder="Id de plan">
       				<br/>
        			<br/>
        			<input type="text" name="descripcion" id="descripcionTextBox" required="true" placeholder="Descripción">
        			<br/>
        			<br/>
        			<input type="hidden" name="tipoABM" value="alta">
        			<input type="submit" name="btnEnviar" id="btnEnviar" value="Enviar">
    			</form>
			</c:when>
			
			<c:when test="${param.opcion == 2 }">
				<header>
        			<h1>Modificación de plan</h1>
    			</header>
    			    <form action="ControlaPlan" method="POST">
        			<input type="text" name="idPlan" id="idPlanTextBox" required="true" placeholder="Ingrese el id del plan">
        			<input type="hidden" name="tipoABM" value="modificacion">
        			<br/>
        			<br/>
        			<input type="submit" name="btnEnviar" id="btnEnviar" value="Enviar">
        			
			</c:when>
			
			<c:otherwise>
				<header>
        			<h1>Baja de plan</h1>
        				<form action="ControlaPlan" method="POST">
        					<input type="text" name="idPlan" id="idPlanTextBox" required="true" placeholder="Ingrese el id del plan">
        					<br/>
        					<br/>        			
        					<input type="hidden" name="tipoABM" value="baja">
        					<input type="submit" name="btnEnviar" id="btnEnviar" value="Enviar">
    			</header>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>