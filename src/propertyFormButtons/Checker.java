package propertyFormButtons;

import javax.swing.JTextField;

public class Checker {

	
	public static boolean checkString(JTextField t){
		
		String s=t.getText();
				
		 char[] chars = s.toCharArray();

		    for (char c : chars) {
		        if(!Character.isLetter(c)) {
		            return false;
		        }
		    }

		    return true;
		
		}
	
	public static boolean checkNumber (String s) {
		
		if (s.matches("[0-9]+") ){
			return true;
		}
		return false;
		
	}
//	
//	public static void main (String arg[]){
//		
//		String s="1";
//		boolean t ;
//		
//		t=checkString(s);
//		System.out.print(t);
//		
//		
//		
//	}
}
