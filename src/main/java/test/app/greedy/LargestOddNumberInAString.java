package test.app.greedy;

public class LargestOddNumberInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String largestOddNumber(String num) {
        
        for (int i=num.length()-1;i>=0;i--){
            int d = Character.getNumericValue( num.charAt(i) );
            
            if( (d & 1) == 1 )
                return num.substring(0,i+1);
        }
        
        return "";
    }

}
