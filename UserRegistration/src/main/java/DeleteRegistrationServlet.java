
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteRegistrationServlet")
public class DeleteRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost/temp?useSSL=false";
            String dbUsername = "root";
            String dbPassword = "Sanjay@1507";
            conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            String checkSql = "SELECT * FROM registration WHERE id=?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, id);
            if (!checkStmt.executeQuery().next()) {
                // ID not found, redirect to error page
                response.sendRedirect("delete_error.jsp");
                return;
            }
            
            else {	
            
            // Prepare the SQL statement
            String sql = "DELETE FROM registration WHERE id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            // Execute the query
            stmt.executeUpdate();

            // Redirect to a success page
            response.sendRedirect("delete_success.jsp");
        } 
        }catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
            response.sendRedirect("delete_error.jsp");
        } 
        finally {
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
