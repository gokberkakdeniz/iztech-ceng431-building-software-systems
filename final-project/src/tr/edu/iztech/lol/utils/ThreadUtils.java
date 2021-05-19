package tr.edu.iztech.lol.utils;

public class ThreadUtils {
	public static void wait(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
	}
	
}
