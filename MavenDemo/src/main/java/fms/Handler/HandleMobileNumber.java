package fms.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleMobileNumber
 */
@WebServlet("/HandleMobileNumber")
public class HandleMobileNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleMobileNumber() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	    String ph=request.getParameter("phno");
	    String c1=request.getParameter("cname");
	    String c2=request.getParameter("vnumber");
	    String c3=request.getParameter("vmodel");
	    String c4=request.getParameter("pdate");
	    String c5=request.getParameter("ptime");
	    
	    System.out.println(""+c1);
	    System.out.println(""+c2);
	    System.out.println(""+c3);
	    System.out.println(""+c4);
	    System.out.println(""+c5);
	    
	    String page;
	    
		int no=0;
		String otp="3621";
		String message="Your OTP For Slot Booking Confirmation Is:"+otp;
		String number=request.getParameter("phno");
	    //important step encode message
		try {
			String apikey="iskHXpv71l5wG6TyBDb9ozMNcaSJLVZRCAf4FE0QnUgO3YuWdPUxmzP3EdYaTsFIGKZ9fewSrQkR1bDV";
			String send_id="FastSM";
			message=URLEncoder.encode(message,"UTF-8");
			
			String language="english";
			String route="v3";
		
			String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+send_id+"&message="+message+"&route="+route+"&numbers="+number+"";
			
			//Sending get request
			URL url=new URL(myUrl);
			
	HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			
			con.setRequestProperty("User-Agent","Chrome");
			con.setRequestProperty("cache-control", "no-cache");
			int code=con.getResponseCode();
			System.out.println("Response code:"+code);
			no=code;
			StringBuffer response =new StringBuffer();
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(true)
			{
				String line=br.readLine();
				if(line==null)
				{
					break;
				}
				response.append(line);
			}	
			System.out.println(response);
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			page="clickhere.jsp?q=Error in sending OTP";
		}
		 System.out.println(ph);
		 
		String url="clickhere.jsp";
		if(no==200)    
		{ 
		    request.getSession().setAttribute("q",ph);
		    request.getSession().setAttribute("p", otp);
		    request.getSession().setAttribute("c1",c1);
		    request.getSession().setAttribute("c2",c2);
		    request.getSession().setAttribute("c3",c3);
		    request.getSession().setAttribute("c4",c4);
		    request.getSession().setAttribute("c5",c5);
		//	request.setAttribute("q", ""+ph);
			//request.setAttribute("p", ""+otp);
			//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			//dispatcher.forward(request, res);
		   res.sendRedirect( "clickhere.jsp?q="+ph);
		}
		else
		{
			  PrintWriter out=res.getWriter();
			out.print("Error while sending OTP"); 
		}
	}

}
