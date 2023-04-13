<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body {
  background: rgb(141,194,111);

  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

h2 {
  margin-top: 50px;
  margin-bottom: 30px;
  text-align: center;
}

form {
  margin: 0 auto;
  max-width: 400px;
  padding: 20px;
  border: 1px solid black;
  border-radius: 5px;
  background:white;
}

label {
  font-weight: bold;
}

input[type="text"],
input[type="email"],
input[type="number"],
input[type="password"] {
  width: 95%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

input[type="submit"] {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 20px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #3e8e41;
}

p {
  text-align: center;
  margin-top: 20px;
}

a {
  color: #4CAF50;
}
</style>
</head>
<body>
<h2>Registration Form</h2>
	<form name="myForm" action="registerServlet" method="post">
		<label for="name">Name:</label><br>
		<input type="text" id="name" name="name" required><br>

		<label for="email">Email:</label><br>
		<input type="text" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"required><br>

		<label for="phone">Phone:</label><br>
		<input type="number" id="phone" name="phone" pattern="[0-9]{10}"required><br>

		<label for="password">Password:</label><br>
		<input type="text" id="password" name="pass" required><br>
		
		

		<input type="submit" value="Register">
	</form>

	<p>Already registered? <a href="login.jsp">Login here</a></p>
</body>
</html>