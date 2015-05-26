
import SRV154DIV2.*;

public class Program {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		String s1 = "bcbccabcccbcbbbcbbacaaccccacbaccabaccbabccbabcaabbbccbbbaa", s2 = "ccbccaaccabacaabccaaccbabcbbaacacaccaacbacbbccccbac";
		String s3 = "bccbcccabbccaccaccacbacbacbabbcbccbaaccbbaacbcbaacbacbaccaaccabcaccacaacbacbacccbbabcccccbababcaabcbbcccbbbaa", s4 = "aadbbbaccc";
		
		System.out.println(s.isInterleave(s1, s2, s3));
	}
}
