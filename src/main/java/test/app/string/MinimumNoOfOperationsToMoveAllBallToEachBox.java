package test.app.string;

public class MinimumNoOfOperationsToMoveAllBallToEachBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] minOperations(String boxes) {
        
        int[] ans = new int[boxes.length()];
        
        for( int i=0;i<boxes.length();i++){
          int moves = 0;
          for( int j=0;j<boxes.length();j++){
            moves +=  ( boxes.charAt(j) == '1' ? Math.abs(i-j) : 0 );
          } 
          ans[i] = moves;
        }
        
        return ans;
    }

}
