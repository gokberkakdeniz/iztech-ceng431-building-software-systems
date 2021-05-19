package tr.edu.iztech.lol.utils;

import java.util.Random;

public class RandomUtils {
    private static Random rand = new Random();
	
	public static int getInteger(int from, int to) {
		return from + rand.nextInt(to);
	}
	
	public static double getDouble() {
		return rand.nextDouble();
	}
}
