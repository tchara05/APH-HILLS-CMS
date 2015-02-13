package extras;

import java.sql.*;

public class DatabaseConnection {
	
	
	private static String databaseName="aphroditehills";
	private static String password="guYa5Ah!";
	private static String username="aphroditehills";
	private  static  Connection conn; 	
	private static Statement statement;
	
	
	public DatabaseConnection() throws ClassNotFoundException, SQLException{
		
		
		String urlConnection  = "jdbc:sqlserver://APOLLO;" +
	
				"databaseName="+databaseName+";user="+username+";password="+password+";";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(urlConnection);
		if (conn==null){
			System.out.println("No Connection");	
			
		}else{
			System.out.println("Succesfull");
		}
		
		statement = conn.createStatement();
		
	}
	
	
	
	public Statement getStatement(){
		return statement;
	}
	
	public Connection getDatabaseConnection(){
		return conn;
	}

	public static void main(String args[]) throws Throwable{
		
		new DatabaseConnection();
		
	}
	

}
