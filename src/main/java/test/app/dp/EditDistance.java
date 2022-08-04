package test.app.dp;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new EditDistance().minDistanceBottomUp( "dinitrophenylhydrazine",
				"acetylphenylhydrazine"));
	}
	
	
	
	public int minDistance(String word1, String word2) {
        return minDistance(word1,word2,0,0);
    }



	private int minDistance(String word1, String word2, int i, int j) {
		if( word1.equals(word2) )
			return 0;
		
		if( i == word1.length())
			return word2.length()-j;
		
		if( j == word2.length())
			return word1.length()-i;
		
		if( word1.charAt(i) == word2.charAt(j) )
			return minDistance(word1, word2,i+1,j+1);
		
		//We can either Replace, Insert or delete the element in case of mismatch
		return 1 + Math.min( minDistance(word1, word2,i+1,j+1),// R
				   Math.min( minDistance(word1, word2,i,j+1) , // I
						   	 minDistance(word1, word2,i+1,j)   // D
						   )
				           );
	}
	
	
	public int minDistanceBottomUp(String w1, String w2) {
		int l1 = w1.length();
		int l2 = w2.length();
		
        int[][] dp = new int[l1+1][l2+1];
        dp[l1][l2] = 0;
        
        int r = l1;
        int c = l2-1;
        while( c >= 0) {
        	dp[r][c] = dp[r][c+1]+1;
            c--;
        }
        
        r = l1-1;
        c = l2;
        while( r >= 0) {
        	dp[r][c] = dp[r+1][c]+1;
        	r--;
        }
        
        r = l1-1;
        while( r >= 0) {
        	c = l2-1;
        	while( c >= 0) {
        		dp[r][c] = w1.charAt(r) == w2.charAt(c) ? dp[r+1][c+1] : 1 + Math.min( dp[r+1][c+1], Math.min( dp[r][c+1] ,dp[r+1][c] ) );
        		c--;
        	}
        	r--;
        }
        
        
        return dp[0][0];
    }

}
