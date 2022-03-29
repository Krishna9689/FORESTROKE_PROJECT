package com.razorpayExample;


import java.io.IOException;

 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import com.razorpay.*;

/**
 * Servlet implementation class OrderCreation
 */
@WebServlet("/ordercreation") 
public class OrderCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Order Creation
		System.out.print("HelloGet");
		RazorpayClient client=null;
		String orderId=null;
		
		try{
			client=new RazorpayClient("rzp_live_dWf2eNRMls5hcR","9nRE2eadiqqzjFDw3Pc37UQB");
			
			JSONObject options=new JSONObject();
			options.put("amount","100");
			options.put("currency","INR");
			options.put("receipt","zxr456");
			options.put("payment_capture",true);
			Order order=client.Orders.create(options);
			orderId=order.get("id");
			
		}catch(RazorpayException e)
		{
			e.printStackTrace();
		}
		response.getWriter().append(orderId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Signature Verification

		System.out.print("HelloPost");
		RazorpayClient client=null;
		try {
			client=new RazorpayClient("rzp_live_dWf2eNRMls5hcR","9nRE2eadiqqzjFDw3Pc37UQB");
			
			JSONObject options=new JSONObject();
			options.put("razorpay_payment_id",request.getParameter("razorpay_payment_id"));
			options.put("razorpay_order_id",request.getParameter("razorpay_order_id"));
			options.put("razorpay_signature",request.getParameter("razorpay_signature"));
			boolean SigRes=Utils.verifyPaymentSignature(options, "9nRE2eadiqqzjFDw3Pc37UQB");
			if(SigRes)
			{ 

				response.getWriter().append("Payment Succesfully Done....");
				
			}
			else
			{
				response.getWriter().append("Payment Failed...");
			}
		}catch(RazorpayException e)
		{
			e.printStackTrace();
		}
	}

}
