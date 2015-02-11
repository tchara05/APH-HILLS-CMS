package propertyFormButtons;

public class Checker {

	
	public static boolean checkString(String s ){
		
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
	
	public static void main (String arg[]){
		
		String s="1";
		boolean t ;
		
		t=checkNumber(s);
		System.out.print(t);
		
		
		
	}
}
