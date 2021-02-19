<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All contacts</title>
</head>
<body>

	
	<br>
	<br>
	<a href="/showContactPage">+Add New Contact</a>   <h2>All Contacts</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE NUMBER</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td><c:out value="${contact.id}"></c:out></td>
				<td><c:out value="${contact.name}"></c:out></td>
				<td><c:out value="${contact.email}"></c:out></td>
				<td><c:out value="${contact.phoneNumber}"></c:out></td>
				<td><a href="/editContact/${contact.id}">edit</a> <a href="/deleteContact/${contact.id}">delete</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>