package test.app.greedy;

public class MinimumMovesToConvertString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MinimumMovesToConvertString().minimumMoves("OOXXOXXX"));
	}
	
	public int minimumMoves(String word) {
	    
		// Quite Bad Code
		
		       int moves = 0,left=0,right=0,middle=0,n = word.length();
		       char[] s = word.toCharArray();
		       for( int i=0; i<s.length; i++ ){
		           if( s[i] == 'O')
		               continue;
		           
		           left = right = middle = 0;
		           if( i == 0 || i == 1)
		                left = 0;
		           else
		                left  = 1 + ((s[i-1] == 'X') ? 1 : 0) + ((s[i-2] == 'X') ? 1 : 0) ;
		           
		           if( i==(n-1) || i==(n-2) )
		               right = 0;
		           else
		               right = 1 + ( (s[i+1] == 'X') ? 1 : 0) + ((s[i+2] == 'X') ? 1 : 0) ;
		           
		           if( i ==0 || i==(n-1) )
		               middle = 0;
		           else
		               middle = 1 +  ((s[i-1] == 'X') ? 1 : 0) + ((s[i+1] == 'X') ? 1 : 0) ;
		           
		           
		           
		           if( middle > 0 && middle >= right && middle >= left ) {
		               s[i] = s[i-1] = s[i+1] = 'O';
		               moves++;
		           } else if ( left > 0 && left >= right && left >= middle ) {
		               s[i] = s[i-1] = s[i-2] = 'O';
		               moves++;
		           } else if ( right > 0 && right >= left && right >= middle ) {
		               s[i] = s[i+1] = s[i+2] = 'O';
		               moves++;
		           }
		           
		           
		       }
		        
		       return moves;
	    }

}
