package fms.Handler;

import java.io.IOException;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;



/**
 * Servlet implementation class pdfgenser
 */
@WebServlet("/pdfgenser")
public class pdfgenser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdfgenser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str="pdf";
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
		     com.lowagie.text.Document document=new Document();
			if(str.equals("pdf"))
			{
				response.setContentType("application/pdf");
				PdfWriter.getInstance(document,response.getOutputStream());
			}
			conn=DBConnector.getConnection();
			String query="select * from tt1";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			document.open();
			
			document.add(new Paragraph("------------Report Created By Krishna Sinnarkar------------"));
			document.addCreationDate();
			
			while(rs.next())
			{
				//fetch and write record...
				document.add(new Paragraph("ID:"+rs.getInt(1)+"\n User Name:"+rs.getString(2)+"\n"));
			}
			document.add(new Paragraph(".................Page No:"+document.getPageNumber()));
			document.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
