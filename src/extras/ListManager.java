package extras;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class ListManager  {
	
	
	
	public static void setUpThreeList(JComboBox<String> list,String query) {

		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		/*************************/

		// Statement st = LogIn.database.getStatement();
		ResultSet rst = null;
		try {
			rst = st.executeQuery(query);
			while (rst.next() && rst.getString(1) != null) {
				list.addItem(rst.getString(1) + " " + rst.getString(2)
						+ " " + rst.getString(3));
			}

		} catch (SQLException e1) {
			System.out.println("Set up list exception");
			e1.printStackTrace();
		}	

		try {
			list.setSelectedIndex(0);
		} catch (Exception e) {
			System.out.println("Empty List");
			e.printStackTrace();
		}

	}

	public static void UpdateList(String id,String str1, String str2,JComboBox<String> list) {

		int length = list.getItemCount();
		String value = str1 + " " + str2;
		int i = 0;
		String testing= (String) list.getItemAt(i);
		while (i < length
				&& String.CASE_INSENSITIVE_ORDER.compare(value,Checker.removeStringID(testing)) >0) {
			i++;
			testing= (String) list.getItemAt(i);
		}
		testing= (String) list.getItemAt(i);
		while (i < length
				&& String.CASE_INSENSITIVE_ORDER.compare(value,Checker.removeStringID(testing)) == 0) {
			i++;
			testing= (String) list.getItemAt(i);
		}
		
		String finalValue =id+" " + value;
		list.insertItemAt( finalValue, i);
		try {
			list.setSelectedIndex(0);
		} catch (Exception e) {

			System.out.println("Empty  List");
			e.printStackTrace();
		}
	}
	
	public static void setUpTwoColumnsList(JComboBox<String> list,String query){
		
		
		
		
		
		/** Remove in the finish **/
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		ResultSet rst = null;
		/*************************/

		// Statement st = LogIn.database.getStatement();
		
		try {
			rst = st.executeQuery(query);
			while (rst.next() && rst.getString(1) != null) {
				list.addItem(rst.getString(1) + " " + rst.getString(2));
			}

		} catch (SQLException e1) {
			System.out.println("Set up list exception");
			e1.printStackTrace();
		}	

		try {
			list.setSelectedIndex(0);
		} catch (Exception e) {
			System.out.println("Empty List");
			e.printStackTrace();
		}
	}

	public static void DeleteFromList(JComboBox<String> list) {

		if (list.getItemCount() > 0) {
			list.removeItemAt((list.getSelectedIndex()));
		}

	}
	
	public static String[] SplitThreeItem(String item){
		
		
		
		String Fname = "";
		String Lname = "";
		String id = "";
		int i = 0;
		while (i < item.length() && item.charAt(i) != ' ') {
			id = id + item.charAt(i);
			i++;
		}
		i++;
		while ((i < item.length() && item.charAt(i) != ' ')) {
			Fname = Fname + item.charAt(i);
			i++;
		}
		i++;
		while (i < item.length()) {
			Lname = Lname + item.charAt(i);
			i++;
		}
		
		
		String[] customer =new String[3];
		
		customer[0]=id;
		customer[1]=Fname;
		customer[2]=Lname;
		
		
		return customer;
	}
	
	public static String[] SplitTwoItem(String item){
		
		
		
		String Fname = "";
		String id = "";
		int i = 0;
		while (i < item.length() && item.charAt(i) != ' ') {
			id = id + item.charAt(i);
			i++;
		}
		i++;
		while ((i < item.length() && item.charAt(i) != ' ')) {
			Fname = Fname + item.charAt(i);
			i++;
		}

		
		String[] customer =new String[3];
		
		customer[0]=id;
		customer[1]=Fname;
		
		
		return customer;
	}



}
