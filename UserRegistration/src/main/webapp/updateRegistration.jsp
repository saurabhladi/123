<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Registration</title>
</head>
<body>
    <h1>Update Registration</h1>
    <form action="UpdateRegistrationServlet" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
    