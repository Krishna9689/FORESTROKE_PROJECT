package fms.Handler;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cancel
 */
@WebServlet("/cancelslot")
public class cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancel() {
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

		try
		{
			final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
			final String DB_URL="jdbc:mysql://localhost:9689/gms";
			final String USER="root";
			final String PASS="Krishna@9689";
			response.setContentType("text/html");
			
			 PrintWriter out= response.getWriter();
			
			System.out.println("Hi");
			
			Class.forName(JDBC_DRIVER);
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			Statement st2=con.createStatement();
			String nm=request.getParameter("cc1");
			String phn=request.getParameter("cc2");
			System.out.println("Hi:"+nm);
			System.out.println("Hi:"+phn);
			ResultSet rs=st.executeQuery("select * from slot_booking where mno="+phn);
			//System.out.println("select * from slot_booking where cname="+nm+" and mno='"+phn+"'");
			
			if(rs.next())
			{
				try
				{
					st2.executeUpdate("delete from slot_booking where phn="+phn);
				}
				catch(Exception e){ System.out.println(e);}
			//	st.executeUpdate("delete from daccount where Ac="+acno);
				System.out.println("record deleted");
				
		        out.println("<HTML><CENTER><BODY><BR><BR><H2> Slot Cancellation Succesfully Done...</H2></BODY></CENTER</HTML>");
			}
			else
			{
		        out.println("<HTML><CENTER><BODY><BR><BR><H2> Record Not Found...</H2></BODY></CENTER</HTML>");

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
