package fms.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyOTP
 */
@WebServlet("/VerifyOTP")
public class VerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOTP() {
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
	String uotp=request.getParameter("otp");
    System.out.println(uotp);
    
    String op=(String) request.getSession().getAttribute("p");
    String c6=(String) request.getSession().getAttribute("q");
    String c1=(String) request.getSession().getAttribute("c1");
    String c2=(String) request.getSession().getAttribute("c2");
    String c3=(String) request.getSession().getAttribute("c3");
    String c4=(String) request.getSession().getAttribute("c4");
    String c5=(String) request.getSession().getAttribute("c5");
    
    System.out.println("f "+c1);
    System.out.println("f "+c2);
    System.out.println("f "+c3);
    System.out.println("f "+c4);
    System.out.println("f "+c5);
    System.out.println("f "+c6);
    System.out.println(op);
    PrintWriter out=response.getWriter();
    if(op.equals(uotp))
    {	
    	response.sendRedirect( "otpverification.jsp?msg=Congratulations...Your Slot Booking Done...");
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
			stmt=conn.prepareStatement("select * from slot_booking");
			System.out.println("Connected");
			stmt=conn.prepareStatement("insert into slot_booking values(?,?,?,?,?,?)");
			stmt.setString(1,c1);
			stmt.setString(2,c2);
			stmt.setString(3,c3);
			stmt.setString(4,c4);
			stmt.setString(5,c5);
			stmt.setString(6,c6);
			
			stmt.executeUpdate();
			
		    System.out.println("Mechanic Record Inserted Successfully...");
		    
		   
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    else
    {
    	response.sendRedirect( "otpverification.jsp?msg=Incorrect Otp...");
    }
	
	//out.print("Slot Booking Successfully...");
	
	out.close();
	}

}
