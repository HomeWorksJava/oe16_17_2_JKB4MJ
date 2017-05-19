<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Reservation Manager</title>
</head>
<body>

	<h2>Reserve a table</h2>
	<form action="ReservationServlet" method="POST">
		<table>
			<tr>
				
				<td>From:</td>
				<td><input type="datetime-local" name="from" /></td>
				<td>To:</td>
				<td><input type="datetime-local" name="to" /></td>
			</tr>
			<tr>
				<td>Table number:</td>
				<td>
					<select name="tableNumber">
						<c:forEach items="${numbers}" var="n">
							<option value="${n}">
								${n}	
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Reserve" /></td>
			</tr>
		</table>
	</form>
	${resultOfReservation}
	


		
		

	</ul>
	
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