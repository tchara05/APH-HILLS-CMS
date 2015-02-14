package extras;



public class Checker extends Thread {

	
	public static boolean checkString(String t){
		
				
		 char[] chars = t.toCharArray();

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

}
