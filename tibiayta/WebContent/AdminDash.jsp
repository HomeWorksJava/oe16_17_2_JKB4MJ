<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Reservations</h3>
	<ul>
	<c:forEach items="${reservations}" var="res">
		<li>Table # ${res.tableNumber} is reserved by ${res.name}. For ${res.reservedFrom} - To ${res.reservedTo}</li>
		<form action="EditServlet"><input type="submit"  value="Edit" /><input type="hidden" name="reservationId" value="${res.id}"></input></form>
		<form action="DeleteServlet"><input type="submit"  value="Delete" /><input type="hidden" name="reservationId" value="${res.id}"></input></form>
		
	</c:forEach>
	</ul>
</body>
</html>