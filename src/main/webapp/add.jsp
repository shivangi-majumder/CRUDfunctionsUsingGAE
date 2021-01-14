<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user</title>
<style>
input[type=text] {
	width: 30%;
	padding: 4px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #375fa8;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 19.5%;
	background-color: #4CAF50;
	color: white;
	padding: 4px 10px;
	margin: 3px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 0px;
	background-color: #f2f2f2;
	padding: 5px;
}

h3 {
	padding-left: 1.4em;
	font-family: "Segoe UI", Arial, sans-serif;
}
</style>
</head>
<body>
	<jsp:include page="titleBar.html" />
	<div class="container">
		<div class="add">
			<h3>Add Customer</h3>
			<form method="post" action="addUser">
				<table>
					<tr>
						<td><input type="text" style="width: 185px;" maxlength="30"
							name="name" id="name" placeholder="Type your name" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width: 185px;" maxlength="30"
							name="uname" id="uname" placeholder="Type your username" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width: 185px;" maxlength="30"
							name="email" id="email" placeholder="Type your email" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width: 185px;" maxlength="30"
							name="address" id="address" placeholder="Type your address" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width: 185px;" maxlength="30"
							name="phno" id="phno" placeholder="Type your phone number" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width: 185px;" maxlength="30"
							name="age" id="age" placeholder="Type your age" /></td>
					</tr>
				</table>
				<p class="save">
					<input type="submit" class="save" title="Save" value="Save" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>