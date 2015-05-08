package extras;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 * 
 * Class that represents the database connection.
 * 
 * We can get a statement and execute queries.
 * with this class.
 * 
 * @author TeamD
 *
 */


public class DatabaseConnection {

	private static String databaseName = "aphroditehills";
	private static String password = "guYa5Ah!";
	private static String username = "aphroditehills";
	private static Connection conn;
	private static Statement statement;
	
	
	/**
	 * Constructor that creates a basic statement and connects to a database
	 * to retrieve data.
	 * 
	 */
	
	public DatabaseConnection() {

		String urlConnection = "jdbc:sqlserver://APOLLO;" +

		"databaseName=" + databaseName + ";user=" + username + ";password="
				+ password + ";";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not found, The library is missing");
			JOptionPane.showMessageDialog(null,
					"SQL Library Support is missing", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
		try {
			conn = DriverManager.getConnection(urlConnection);
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out
					.println("The database is not Accesible, please check your internet connection\n"
							+ "or Database's username  and password");
			
				Messages.showErrorMessage("The database is not Accesible, please check your internet connection\n"
							+ "or Database's username  and password");
				e.printStackTrace();
		}
	}
	
	/**
	 * This method return the statement of database
	 * 
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * Getter for connection
	 *
	 * @return Connection
	 */
	
	public Connection getDatabaseConnection() {
		return conn;
	}
	
	
	/***
	 * Creates and returns a back and forward statement and 
	 * return it to user.
	 * 
	 * 
	 * 
	 * @return Statement
	 * @throws SQLException
	 */
	
	
	public Statement createBackForwardStateMent() throws SQLException{
		return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	}

	
	
	/**
	 * Method that close the statement and the database connection
	 * 
	 */
	public void closeDatabaseConnection(){
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method main just for test.
	 * 
	 * 
	 * 
	 * @param Strings[]
	 * @throws Throwable
	 */
	public static void main(String args[]) throws Throwable {
		new DatabaseConnection();
	}
	
	

}
