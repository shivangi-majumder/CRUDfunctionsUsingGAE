<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.datastore.Entity"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo App with CRUD Functionality</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<jsp:include page="titleBar.html" />
	<h1>Demo App with CRUD Functionality</h1>
	Function :
	<a href="add.jsp">Add Customer</a>
	<hr />

	<h2>All Customers</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Age</th>
			<th>Created Date</th>
			<th>Action</th>
		</tr>
		<%
			List<Entity> customerList = (List<Entity>) request.getAttribute("customerList");
		for (Entity e : customerList) {
		%>
		<tr>
			<td id="name"><%=e.getProperty("name")%></td>
			<td id="uname"><%=e.getProperty("uname")%></td>
			<td id="email"><%=e.getProperty("email")%></td>
			<td id="address"><%=e.getProperty("address")%></td>
			<td id="phno"><%=e.getProperty("phno")%></td>
			<td id="age"><%=e.getProperty("age")%></td>
			<td><a
				href="update?action=update&&value=<%=e.getProperty("name")%>">Update
			</a></td>
			<td><a
				href="delete?action=delete&&value=<%=e.getProperty("name")%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>