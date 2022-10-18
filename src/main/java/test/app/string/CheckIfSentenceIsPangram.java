package test.app.string;

public class CheckIfSentenceIsPangram {

	
	public boolean checkIfPangram(String sentence) {
        
        int[] freq = new int[26];
        for( int i=0;i<sentence.length();i++ ){
            freq[sentence.charAt(i)-'a']++;
        }
        
        for( int f : freq ){
            if( f == 0 )
                return false;
        }
        
        return true;
        
        
    }
	
	
	public boolean checkIfPangramUsingBit(String sentence) {

		// We will use each bit as an indication for each character a-z for 26 characters
        int tsb = 0;
        for( int i=0;i<sentence.length();i++ ){
            int t = 1 << (sentence.charAt(i)-'a');
            tsb |= t;
        }

        // If all the 26 bits are set, then answer is true otherwise false.
        /* How to check if all bits are set ?
         * 1. Check bit by bit or
         * 2. 2^3 = 8 ( in binary 1000 ) and if 3 bits are set value is 0111 = 7 ( 2^3 - 1 )
         */
        return tsb == (1<<26)-1;
        
        
    }
}
