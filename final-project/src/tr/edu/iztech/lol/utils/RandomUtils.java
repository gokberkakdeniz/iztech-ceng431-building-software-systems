package tr.edu.iztech.lol.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import tr.edu.iztech.lol.hero.*;
import tr.edu.iztech.lol.origin.*;

public class RandomUtils {
    private static Random rand = new Random();

	
	public static int getInteger(int from, int to) {
		return from + rand.nextInt(to);
	}
	
	public static double getDouble() {
		return rand.nextDouble();
	}
}
