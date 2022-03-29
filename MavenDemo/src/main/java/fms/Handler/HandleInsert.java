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
 * Servlet implementation class HandleInsert
 */
@WebServlet("/insMechanic")
public class HandleInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleInsert() {
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
	
			
			Connection conn=null;
			PreparedStatement stmt=null;
			
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.prepareStatement("select * from mechanic");
			System.out.println("Connected");
			stmt=conn.prepareStatement("insert into mechanic_details values(?,?,?,?,?,?)");
			stmt.setInt(1, Integer.parseInt(request.getParameter("mid")));
			stmt.setString(2, request.getParameter("mnm"));
			stmt.setString(3, request.getParameter("mno"));
			stmt.setString(4, request.getParameter("maddress"));
			stmt.setString(5, request.getParameter("mdoj"));
			stmt.setString(6, request.getParameter("mspm"));
			stmt.executeUpdate();
			
		    System.out.println("Mechanic Record Inserted Successfully...");
		    
		    response.sendRedirect( "insertmechanic.jsp?msg=Record Inserted Successfully..." );
		    request.getRequestDispatcher("insertmechanic.jsp").forward(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
