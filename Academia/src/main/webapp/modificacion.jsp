<%@ page import="entities.Plan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<% 	
	Plan pl = (Plan)request.getAttribute("plan");
%>


</head>
<body>
	<h1>Datos del plan</h1>
	<br/>
	<br/>
	<table>
		
		<tr>
			<th>Id de plan</th>
			<td><%=pl.getIdPlan()%></td>
		</tr>
		<tr>
			<th>Descripción del plan</th>
			<td><%=pl.getDescripcion()%></td>
		</tr>
	</table>
	
	    	<form action="ControlaPlan" method="POST">
        		<input type="text" name="idPlan" id="idPlanTextBox" disabled="true" placeholder="<%=pl.getIdPlan()%>">
       			<br/>
        		<br/>
        		<input type="text" name="descripcionTextBox" id="descripcionTextBox" required="true" placeholder="<%=pl.getDescripcion()%>">
        		<br/>
        		<br/>
        		<input type="submit" name="btnEnviar" id="btnEnviar" value="Enviar">
    		</form>
    		
</body>
</html>