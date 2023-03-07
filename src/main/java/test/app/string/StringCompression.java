package test.app.string;

import java.util.Arrays;

public class StringCompression {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = new char[] {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b','b','c','c','c'};
		System.out.println(new StringCompression().compress(input));
		System.out.println( Arrays.toString(input));
	}
	
	public int compress(char[] chars) {
        int count = 0;
        int len = 1;
        char prev  = chars[0];
        int indexToReplace = 0;

        for( int i=1;i<chars.length;i++){
            if( prev == chars[i] ) {
                len++;
            } else {
            	int digitLen = groupSize(len,indexToReplace,chars,prev);
                count += digitLen;
                indexToReplace += digitLen;
                len = 1;
                prev = chars[i];
            }
        }

        return  count += groupSize(len,indexToReplace,chars,prev);
    }

    public int groupSize ( int len , int index , char[] input , char ch ) {

    	input[index] = ch;
        
    	if( len == 1) {
        	return len;
        } 
        
        int res = 1;
        if( len >= 1000) {
        	input[index+4] = (char) (48 + (len%10)); 
        	len /= 10;
        	res++;
        }
        
        if( len >= 100) {
        	input[index+3] = (char) (48 + (len%10)); 
        	len /= 10;
        	res++;
        }
        
        if( len >= 10) {
        	input[index+2] = (char) (48 + (len%10)); 
        	len /= 10;
        	res++;
        }
        
        if( len > 0) {
        	input[index+1] = (char) (48 + (len%10)); 
        	len /= 10;
        	res++;
        }
        
        
        return res;

    }
}
