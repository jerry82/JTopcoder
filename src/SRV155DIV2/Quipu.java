package SRV155DIV2;

import java.util.Arrays;

public class Quipu {
	
	public Quipu() {}
	
	public int readKnots(String knots) {
		String ans = "";
		knots += "$";
		String[] result = knots.split("-");
		System.out.println("size: " + result.length);
		for (String x : result) {
			if (!x.equals("$")) {
				ans += x.length();
			}
		}
		
		System.out.println(Arrays.toString(knots.split("-")));
		
		return Integer.parseInt(ans);
	}
}
