package tr.edu.iztech.orp.views;

public enum MenuModel {
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
}
