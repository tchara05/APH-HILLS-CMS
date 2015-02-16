package extras;



public class Checker extends Thread {

	
	public static boolean checkString(String t){
			
		 char[] chars = t.toCharArray();

		    for (char c : chars) {
		        if(!Character.isLetter(c)&&(c!=' ')) {
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
		 String epatern = "^.+@.+";
         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(epatern);
         java.util.regex.Matcher m = p.matcher(s);
         return m.matches();
	 }
	 public static String clearString(String str){
		 
		 
		 boolean change = false;
		 String nStr ="";
		 	if (str.startsWith(" ")){
		 		int i=0;
				while (str.charAt(i)==' '&& i<str.length()){
					i++;
				}
				
				for (int j =i; j<str.length(); j++){
					nStr=nStr+str.charAt(j);
				}
				change=true;
		 		
		 	}
		 
		 
		 
		 	String fStr="";
			if (nStr.endsWith(" ")){
				int i=nStr.length()-1;
				while (nStr.charAt(i)==' '&& i>=0){
					i--;
				}
				
				for (int j =0; j<=i; j++){
					fStr=fStr+nStr.charAt(j);
				}
				
				change = true;
			}
			
			
			if (change)
				return fStr;
			else
				return str;
	 }
	 
	 
	 public static void main(String args[]){
		 
		 System.out.println("            Theodoros Charalambous        ");
		 System.out.println(clearString("          Theodoros Charalambous        "));
		 System.out.println(clearString("Theodoros Charalambous"));
		 
		 String customer ="1 Koutalas";
		 customer = customer.substring(2);
		 
		 
	 }







}
