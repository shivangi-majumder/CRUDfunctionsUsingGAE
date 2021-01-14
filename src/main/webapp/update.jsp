<%@ page import="com.google.appengine.api.datastore.Entity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.datastore.Entity"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="titleBar.html" />
	<h1>Update Customer</h1>

	<%
		Entity customer = (Entity) request.getAttribute("nameList");
	%>

	<form method="post" action="update?action=updatedata">
		<input type="hidden" name="originalName" id="originalName"
			value="<%=customer.getProperty("name")%>" />
		<table>
			<tr>
				<td>Name :</td>
				<td><input style="width: 185px;" maxlength="30" type="text"
					name="name" id="name" value="<%=customer.getProperty("name")%>" />
				</td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" style="width: 185px;" maxlength="30"
					name="uname" id="uname" value="<%=customer.getProperty("uname")%>" />
				</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" style="width: 185px;" maxlength="30"
					name="email" id="email" value="<%=customer.getProperty("email")%>" />
				</td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" style="width: 185px;" maxlength="30"
					name="address" id="address"
					value="<%=customer.getProperty("address")%>" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="text" style="width: 185px;" maxlength="30"
					name="phno" id="phno" value="<%=customer.getProperty("phno")%>" />
				</td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><input type="text" style="width: 185px;" maxlength="30"
					name="age" id="age" value="<%=customer.getProperty("age")%>" /></td>
			</tr>
		</table>
		<input type="submit" class="update" title="Update" value="Update" />
	</form>
</body>
</html>