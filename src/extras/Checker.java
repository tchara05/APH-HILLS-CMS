package extras;

public class Checker {

	public static boolean checkString(String t) {

		char[] chars = t.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c) && (c != ' ')) {
				return false;
			}
		}

		return true;

	}

	public static boolean checkNumber(String s) {

		if (s.matches("[0-9]+")) {
			return true;
		}
		return false;

	}

	public static boolean checkEmailAddress(String s) {
		String epatern = "^.+@.+";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(epatern);
		java.util.regex.Matcher m = p.matcher(s);
		return m.matches();
	}

	public static String clearString(String str) {

		boolean change = false;
		String nStr = "";
		if (str.startsWith(" ")) {
			int i = 0;
			while (str.charAt(i) == ' ' && i < str.length()) {
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
			while (nStr.charAt(i) == ' ' && i >= 0) {
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

	public static String removeStringID(String s) {

		int i = 0;
		while (i < s.length() && s.charAt(i) != ' ') {
			i++;
		}

		return s.substring(i + 1);

	}



}
