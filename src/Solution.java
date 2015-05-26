import java.util.*;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (isNE(s1)) {
    		return s2 == s3;
    	}
    	
    	if (isNE(s2)) {
    		return s1 == s3;
    	}
    	
    	if (isNE(s1) && isNE(s2) && isNE(s3))
    		return true;
    	
    	if (isNE(s3)) {
    		return false;
    	}
    	
    	int[] ila = {1};
    	check(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, ila);
    	
    	return ila[0] == 1;
    }
    
    private void check(char[] s1, char[] s2, char[] s3, int p1, int p2, int p3, int[] ila) { 
    	
    	if (s1.length + s2.length != s3.length) {
    		ila[0] = 0; return;
    	}
    	
    	if (p1 >= s1.length) {
    		String tmp2 = String.valueOf(s2).substring(p2);
    		String tmp3 = String.valueOf(s3).substring(p3);
    		ila[0] = tmp2.equals(tmp3) ? 1 : 0;
    		return;
    	}
    	
    	if (p2 >= s2.length) {
    		String tmp1 = String.valueOf(s1).substring(p1);
    		String tmp3 = String.valueOf(s3).substring(p3);
    		ila[0] = tmp1.equals(tmp3) ? 1 : 0;
    		return;
    	}
    	
    	if (s1[p1] == s3[p3] && s2[p2] == s3[p3]) {
    		check(s1, s2, s3, p1 + 1, p2, p3 + 1, ila);
    		if (ila[0] != 1) {
    			check(s1, s2, s3, p1, p2 + 1, p3 + 1, ila);
    		}
    	}
    	else if (s1[p1] == s3[p3]) {
    		check(s1, s2, s3, p1 + 1, p2, p3 + 1, ila);
    	}
    	else if (s2[p2] == s3[p3]) {
    		check(s1, s2, s3, p1, p2 + 1, p3 + 1, ila);
    	}
    	else {
    		ila[0] = 0;
    		return;
    	}
    }
    
    private boolean isNE(String s) {
    	return !(s != null && !s.isEmpty());
    }
}
