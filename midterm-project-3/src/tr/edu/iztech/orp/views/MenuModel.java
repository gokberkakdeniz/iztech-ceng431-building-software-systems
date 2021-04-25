package tr.edu.iztech.orp.views;

import java.util.Arrays;

public enum MenuModel {
	LOGIN("private_Login"),
	HOME("Home"),
	COLLECTIONS("Collections"),
	SUBSCRIBED_USERS("Subscribed Users");
	
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
