package fms.Handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCust
 */
@WebServlet("/CreateCust")
public class CreateCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("hiiiiiiii");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			stmt=conn.prepareStatement("select * from signup");
			System.out.println("Connected");
			stmt=conn.prepareStatement("insert into signup values(?,?,?)");
			stmt.setString(1, request.getParameter("user"));
			stmt.setString(2, request.getParameter("pass"));
			stmt.setString(3, request.getParameter("phno"));
			stmt.executeUpdate();
			
		    System.out.println("Record Inserted Successfully...");
			response.sendRedirect( "login.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
