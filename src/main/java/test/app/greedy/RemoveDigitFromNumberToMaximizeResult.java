package test.app.greedy;

public class RemoveDigitFromNumberToMaximizeResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String removeDigit(String number, char digit) {
        
        int i = -1;
        for( int j=0;j<number.length();j++)     {
            if( number.charAt(j) == digit ) {
                i = j;
                
                if( ( (j+1)<number.length() ) &&  digit<number.charAt(j+1) )
                    break;
            }
        }
        
        return number.substring(0,i) + number.substring(i+1);
    }

}
