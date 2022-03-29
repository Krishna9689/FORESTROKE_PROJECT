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

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;



/**
 * Servlet implementation class pdfgenser
 */
@WebServlet("/CustReport")
public class custR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public custR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str="pdf";
	System.out.print("pdfffff");	
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int cnt=0;
		
		try{
		     com.lowagie.text.Document document=new Document();
			if(str.equals("pdf"))
			{
				response.setContentType("application/pdf");
				PdfWriter.getInstance(document,response.getOutputStream());
			}
			conn=DBConnector.getConnection();
			String query="select * from slot_booking";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			document.open();
			
			document.add(new Paragraph("------------Customer Reports------------"));
			document.addCreationDate();
		
			document.add(new Paragraph(" "));	document.add(new Paragraph(" "));
		
			
			
			while(rs.next())
			{
				//fetch and write record...
				document.add(new Paragraph("\t Customer Name:"+rs.getString(1)+"\t Mobile No:"+rs.getString(6)));
				document.add(new Paragraph(" "));
				
				}
			//document.add(new Paragraph(".................Page No:"+document.getPageNumber()));
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
