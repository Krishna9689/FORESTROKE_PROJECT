package fms.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnector {
	
	public static String url="jdbc:mysql://localhost:9689/gms";
	public static String userName="root";
	public static String password="Krishna@9689";
	
	public static Connection getConnection()
	{
		Connection connection=null;
		if(connection != null)
		{
			return connection;
		}
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}

}
