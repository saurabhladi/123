<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Registration</title>
</head>
<body>
    <h1>Delete Registration</h1>
    <form action="DeleteRegistrationServlet" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br>
        <input type="submit" value="Delete">
    </form>
</body>
</html>
    