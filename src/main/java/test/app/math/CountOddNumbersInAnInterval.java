package test.app.math;

public class CountOddNumbersInAnInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int countOdds(int low, int high) {
        int count = high - low + 1;

        if( count == 1 )
            return low%2;

        if( count%2 == 0 ){
            return count/2; 
        } else {
            int half1  = (count/2);
            int half2  = half1+1;
            return low%2 == 0 ? half1 : half2 ;
        }

    }

}
