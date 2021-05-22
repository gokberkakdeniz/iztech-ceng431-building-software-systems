package tr.edu.iztech.lol.view.screen;

import java.awt.event.ActionListener;

public interface ILoginPanel {
	String getFirstUsername();
	String getSecondUsername();
	
	void showError(String message);
	void hideError();

	void addLoginButtonListener(ActionListener listener);
}
