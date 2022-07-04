package test.app.string;

import test.app.utils.Utils;

public class ReverseOnlyLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ReverseOnlyLetters().reverseOnlyLetters("ab-cd"));
	}
	
	public String reverseOnlyLetters(String s) {
        
        char[] arr = s.toCharArray();
        int l=0,r=arr.length-1;
        while(true){
            
            while( l<arr.length && !Character.isAlphabetic(arr[l]) ){
                l++;
            }
            
            while( r>=0 && !Character.isAlphabetic(arr[r]) ){
                r--;
            }
            
            if( l > r)
                break;
            
            Utils.swap(arr,l++,r--);
            
        }
        
        return new String(arr);
    }

}
