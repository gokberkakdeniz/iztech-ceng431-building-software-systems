package tr.edu.iztech.orp.utils;

public class StringUtils {
	public static boolean isValid(String string) {
		return string.length() > 0 && string.charAt(0) != ' ' && string.charAt(string.length() - 1) != ' ';
	}
}
