class LongestCommonSubSequence {

public static int lcs_length(String a, String b, int i, int j){
		if(a.length() == i || b.length() == j) {
				return 0;
		} else if(a.charAt(i) == b.charAt(j)) {
			return 1 + lcs_length(a,b,i+1,j+1);
		} else {
			return Math.max(lcs_length(a,b,i+1,j),lcs_length(a,b,i,j+1));
		}
		
	}

}
