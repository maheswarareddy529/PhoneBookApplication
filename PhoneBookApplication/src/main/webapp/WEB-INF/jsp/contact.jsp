<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Contact Registration: </h1>
	<form action="saveContact" modelAttribute="contact" method="post">
		<pre>
			ID : <input type="text" name="id" />
			NAME : <input type="text" name="name">
			EMAIL : <input type="text" name="email">
			Phone Number : <input type="text" name="phoneNumber">
		
							<input type="submit" value="submit">
		</pre>
	</form>
	
	<a href="/viewContacts">View All Contacts</a>
</body>
</html>