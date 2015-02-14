package extras;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class readFile {
	
	
	
	
	public static void main(String args[]) throws FileNotFoundException{
		
		DatabaseConnection c = new DatabaseConnection();
		Statement st = c.getStatement();
		Scanner read = new Scanner(new File("Countries.txt"));
		
		while (read.hasNext()){
			String t = read.nextLine();
			try {
				st.executeUpdate("INSERT INTO Country values ('"+t+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
