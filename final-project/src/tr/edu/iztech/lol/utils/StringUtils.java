package tr.edu.iztech.lol.utils;

public class StringUtils {
	/**
	 * 
	 * Source: https://stackoverflow.com/a/2560017
	 * 
	 * @param text 
	 * @return
	 */
	public static String humanizeCamelCase(String text) {
		   return text.replaceAll(
				      String.format("%s|%s|%s",
				         "(?<=[A-Z])(?=[A-Z][a-z])",
				         "(?<=[^A-Z])(?=[A-Z])",
				         "(?<=[A-Za-z])(?=[^A-Za-z])"
				      ),
				      " "
				   );
	}
}
