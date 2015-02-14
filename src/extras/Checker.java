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
	 public static boolean checkEmailAddress(String s) {
         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(s);
         return m.matches();
	 }

}
