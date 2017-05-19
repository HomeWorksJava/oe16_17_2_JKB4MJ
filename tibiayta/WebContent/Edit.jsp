<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EditServlet" method="POST">
		<table>
			<tr>
				<td>From:</td>
				<td><input type="datetime-local" name="from" value="${from}" /></td>
			</tr>
			<tr>
				<td>To:</td>
				<td><input type="datetime-local" name="to"  value="${to}"/></td>
				<td><input type="hidden" name="reservationId" value="${id}" /></td>
				<td><input type="hidden" name="clientName" value="${clientName}" /></td>
				<td><input type="hidden" name="tableNumber" value="${tableNumber}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>

		</table>
	</form>

</body>
</html>