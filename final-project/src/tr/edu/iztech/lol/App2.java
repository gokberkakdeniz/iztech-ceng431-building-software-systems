package tr.edu.iztech.lol;

import java.awt.EventQueue;

import tr.edu.iztech.lol.data.*;
import tr.edu.iztech.lol.factory.*;
import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.view.IScreenManager;
import tr.edu.iztech.lol.view.MainWindow;
import tr.edu.iztech.lol.view.ScreenManager;

public class App2 {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					IScreenManager screenManager = new ScreenManager(window);
					screenManager.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
