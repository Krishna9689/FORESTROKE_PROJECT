package fms.Handler;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCust
 */
@WebServlet("/LoginCust")
public class LoginCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
			final String DB_URL="jdbc:mysql://localhost:9689/gms";
			final String USER="root";
			final String PASS="Krishna@9689";
			response.setContentType("text/html");
			
			System.out.println("Hi");
			
			Connection conn=null;
			PreparedStatement stmt=null;
			
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			 String sql = "SELECT * FROM signup  WHERE username = ? "
				  		+ "and password = ?";
				  PreparedStatement statement = conn.prepareStatement(sql);
				  statement.setString(1,  request.getParameter("user"));
				  statement.setString(2,  request.getParameter("pass"));

				  ResultSet result = statement.executeQuery();

		            String destPage="login.jsp";
				  if (result.next()) {
					     destPage = "slotbooking.html";
				  }
		            RequestDispatcher dispatcher = 
		            		request.getRequestDispatcher(destPage);
		            dispatcher.forward(request, response);
		            System.out.println(""+destPage);
				  conn.close();

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
