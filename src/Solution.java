import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
    	
    	if (k == 0) return "";
    	
    	StringBuilder sb = new StringBuilder();
    	ArrayList<String> chars = new ArrayList<String>();
    	chars.add("0");

    	for (int i = 1; i <= n; i++) {
    		chars.add(String.valueOf(i));
    	}
    	
    	n = n - 1;
    	int head = 0;
    	
    	while (n >= 1){
    		int permuteVal = getPermuteVal(n);
    		
    		if (k % permuteVal == 0) 
    			head = k / permuteVal;
    		else 
    			head = k / permuteVal + 1;
    		
    		sb.append(Integer.parseInt(chars.get(head)));    	
    		chars.remove(chars.get(head));

    		k -= (head - 1) * permuteVal;    		
    		n--;
    	}
    	
    	sb.append(chars.get(1));
    	
    	return sb.toString();
    }
    
    public int getPermuteVal(int n) {
    	int val = 1;
    	for (int i = 1; i <= n; i++) 
    		val *= i;
    	
    	return val;
    }
}