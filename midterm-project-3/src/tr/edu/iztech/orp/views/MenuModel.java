package tr.edu.iztech.orp.views;

import java.util.Arrays;

/**
 * This model is for Navigation Menu (in header).
 * Note: All instances except ones starts with "private_" show up in Navigation Menu. 
 */
public enum MenuModel {
	LOGIN("private_Login"),
	HOME("Home"),
	COLLECTIONS("Collections"),
	FOLLOWED_USERS("Followed Users"),
	STATISTICS("Statistics");

	
    private final String text;

    MenuModel(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
	}
    
    public static MenuModel getDefault() {
    	return HOME;
    }
    
    public static MenuModel[] publicValues() {
    	return Arrays.stream(values()).filter(e -> !e.toString().startsWith("private_")).toArray(MenuModel[]::new);
    }
}
