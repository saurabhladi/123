import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost/temp";
            String dbUsername = "root";
            String dbPassword = "Sanjay@1507";
            conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // Prepare the SQL statement
            String sql = "INSERT INTO registration(name, email, password) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            // Execute the query
            stmt.executeUpdate();

            // Redirect to a success page
            response.sendRedirect("registration_success.jsp");
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
            response.sendRedirect("registration_error.jsp");
        } finally {
            // Close connections
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


