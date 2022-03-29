package fms.Handler;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;


public class SendSMS
{
	public static void sendSms(String message,String number ) throws 
IOException
	{
		//System.out.println(mssage+number);
		int no=0;
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
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("hii");
		int k=9689;
		SendSMS.sendSms(""+k,"");
		
		
	}

}
