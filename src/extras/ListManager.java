package extras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ListManager {


	public static void setUpThreeList(JComboBox<String> list, String query) {

		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		list.removeAll();
		ResultSet rst = null;
		try {
			rst = st.executeQuery(query);
			while (rst.next() && rst.getString(1) != null) {
				list.addItem(rst.getString(1) + " " + rst.getString(2) + " "
						+ rst.getString(3));
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
		}finally{
			database.closeDatabaseConnection();
		}

	}
	public static void UpdateList(String id, String str1, String str2,
			JComboBox<String> list) {

		int length = list.getItemCount();
		String value = str1 + " " + str2;
		int i = 0;
		String testing = (String) list.getItemAt(i);
		while (i < length
				&& String.CASE_INSENSITIVE_ORDER.compare(value,
						Checker.removeStringID(testing)) > 0) {
			i++;
			testing = (String) list.getItemAt(i);
		}
		testing = (String) list.getItemAt(i);
		while (i < length
				&& String.CASE_INSENSITIVE_ORDER.compare(value,
						Checker.removeStringID(testing)) == 0) {
			i++;
			testing = (String) list.getItemAt(i);
		}
		
		String finalValue = id + " " + value;
	
		list.insertItemAt(finalValue, i);
		try {
			list.setSelectedIndex(0);
		} catch (Exception e) {

			System.out.println("Empty  List");
			e.printStackTrace();
		}
	}

	public static void UpdateList(String id, String str1, String str2,DefaultListModel<String> list) {

		int length = list.getSize();
		String value = str1 + " " + str2;

		int i = 0;
		String testing = "";

		while (i < length) {
			testing = (String) list.get(i);
			if (String.CASE_INSENSITIVE_ORDER.compare(value,
					Checker.removeStringID(testing)) < 0) {
				break;
			}
			i++;
		}
		while (i < length) {
			testing = (String) list.get(i);
			if (String.CASE_INSENSITIVE_ORDER.compare(value,
					Checker.removeStringID(testing)) != 0) {
				break;
			}
			i++;
		}

		String finalValue = id + " " + value;
		list.add(i, finalValue);

	}
	


	public static void setUpTwoColumnsList(JComboBox<String> list, String query) {

		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		ResultSet rst = null;

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
		}finally{
			database.closeDatabaseConnection();
		}
	}

	public static String DeleteFromList(JComboBox<String> list) {

		if (list.getItemCount() > 0) {
			String s = (String)list.getSelectedItem();
			list.removeItemAt((list.getSelectedIndex()));
			return s;
		}else{
			return "";
		}
	}
	public static void DeleteFromList(DefaultListModel<String> list,String s){
		if (list.getSize()>0){
			list.removeElement(s);
		}
	}
	public static String[] SplitThreeItem(String item) {

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

		String[] customer = new String[3];

		customer[0] = Checker.clearString(id);
		customer[1] = Checker.clearString(Fname);
		customer[2] = Checker.clearString(Lname);

		return customer;
	}
	public static String[] SplitTwoItem(String item) {
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
		
		while((i<item.length())){
			Fname=Fname +item.charAt(i);
			i++;
		}

		String[] customer = new String[2];

		customer[0] = id;
		customer[1] = Fname;

		return customer;
	}
	public static void SetUpThreeList(DefaultListModel<String> list,
			String query) {
		
		list.clear();
		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		
		try {
			ResultSet rst = st.executeQuery(query);
			while (rst.next() && rst.getString(1) != null) {
				list.addElement(rst.getString(1) + " " + rst.getString(2) + " "
						+ rst.getString(3));
			}

		} catch (SQLException e) {
			System.out.println("From Set Up Three List Query");
			e.printStackTrace();
		}

	}
	public static String[] removeShare(String item) {

		int i = item.length() - 1;
		String[] newItem = { "", "" };
		while (i > -1 && item.charAt(i) != ' ') {
			i--;
		}
		for (int j = 0; j < i; j++) {
			newItem[1] = newItem[1] + item.charAt(j);
		}

		for (int j = i + 1; j < item.length(); j++) {
			newItem[0] = newItem[0] + item.charAt(j);
		}

		return newItem;

	}
	public static String SplitOneItem(String s) {
		String result = "";
		int i = 0;
		while (i < s.length() && s.charAt(i) != ' ') {
			result = result + s.charAt(i);
			i++;
		}
		return result;

	}
	public static boolean checkPercentage(int prc) {

		if (prc != 100) {
			JOptionPane.showMessageDialog(null, "Percentage is " + prc
					+ ". It must be 100%", "Input warning",
					JOptionPane.WARNING_MESSAGE);
			return false;

		} else {

			return true;
		}

	}
	
	
	

}
