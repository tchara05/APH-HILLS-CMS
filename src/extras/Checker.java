package extras;

import javax.swing.JOptionPane;

/**
 * 
 * This class is used for checking any fields given 
 * into the forms. 
 * 
 * @author TeamD
 *
 */
public class Checker {
	
	/**
	 * 
	 * This method is used for checking if the given text
	 * is a string without numbers or spaces.
	 *
	 */
	public static boolean checkString(String t) {

		char[] chars = t.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c) && (c != ' ')) {
				return false;
			}
		}

		return true;

	}

	
	/**
	 * 
	 * This method is used for checking if the given text
	 * is a number.
	 *
	 */
	public static boolean checkNumber(String s) {

		if (!s.matches("[0-9]+")) {
			return false;
		}
		return true;

	}

	
	/**
	 * 
	 * This method is used for checking if the given text
	 * is not empty.
	 *
	 */
	public static boolean checkEmpty(String text){
		if(text.equals(""))
			return false;
		return true;
	}
	
	
	/**
	 * 
	 * This method is used for checking if the given text
	 * is an email.
	 *
	 */
	public static boolean checkEmailAddress(String s) {
		String epatern = "^.+@.+";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(epatern);
		java.util.regex.Matcher m = p.matcher(s);
		return m.matches();
	}

	
	/**
	 * 
	 * This method is used for clearing the string from
	 * any white spaces.
	 *
	 */
	public static String clearString(String str) {

		boolean change = false;
		String nStr = "";
		if (str.startsWith(" ")) {
			int i = 0;
			while (i < str.length() && str.charAt(i) == ' ') {
				i++;
			}

			for (int j = i; j < str.length(); j++) {
				nStr = nStr + str.charAt(j);
			}
			change = true;
		}

		String fStr = "";
		if (nStr.endsWith(" ")) {
			int i = nStr.length() - 1;
			while ( i >= 0 && nStr.charAt(i) == ' ' ) {
				i--;
			}

			for (int j = 0; j <= i; j++) {
				fStr = fStr + nStr.charAt(j);
			}

			change = true;
		}

		if (change)
			return fStr;
		else
			return str;
	}

	
	/**
	 * 
	 * This method is used for removing the first number
	 * that is appeared in the string.
	 *
	 */
	public static String removeStringID(String s) {

		int i = 0;
		while (i < s.length() && s.charAt(i) != ' ') {
			i++;
		}

		return s.substring(i + 1);

	}
	
	public static void showMessage() {
		JOptionPane.showMessageDialog(null, "Input Error! Please check the Fields!",
				"Information Message", JOptionPane.INFORMATION_MESSAGE);
	}



}
