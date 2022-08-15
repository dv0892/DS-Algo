package test.app.greedy;

public class MinimumNumberOfOperationsToConvertTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int convertTime(String current, String correct) {
        
        String[] t1 = current.split(":");
        String h1 = t1[0], m1 = t1[1] ;
        
        String[] t2 = correct.split(":");
        String h2 = t2[0], m2 = t2[1] ;
        
        int diff = ( Integer.parseInt(h2)*60 + Integer.parseInt(m2) ) - ( Integer.parseInt(h1)*60 + Integer.parseInt(m1) );
         
        int count = 0;
        while( diff > 0 ){
            if( diff/60 > 0 ){
                count += (diff/60); diff %= 60;
            } else if( diff/15 > 0){
                count += (diff/15); diff %= 15;
            } else if( diff/5 > 0){
                count += (diff/5); diff %= 5;
            } else{
                count += diff ;
                diff = 0;
            }
        }
        
        return count;
    }

}
