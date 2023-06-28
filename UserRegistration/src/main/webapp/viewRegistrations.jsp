<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Registrations</title>
</head>
<body>
    <h1>Registered Users</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <% 
        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost/temp?useSSL=false";
            String dbUsername = "root";
            String dbPassword = "Sanjay@1507";
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            
            // Execute the query to retrieve registrations
            String sql = "SELECT * FROM registration";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            // Iterate over the result set and display data
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
        %>
                <tr>
                    <td><%= id %></td>
                    <td><%= name %></td>
                    <td><%= email %></td>
                </tr>
        <%  
            }
            
            // Close connections
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </table>
</body>
</html>

    