<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h1>Registration Form</h1>
    <form action="RegistrationServlet" method="post">
        <label for="name">Name	:	</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email	:	</label>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password	:	</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
