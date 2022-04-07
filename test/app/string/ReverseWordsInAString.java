package test.app.string;

import test.app.utils.Utils;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ReverseWordsInAString().reverseWords("Let's take LeetCode contest"));
	}
	
	public String reverseWords(String s) {
	       
        char[] ch = s.toCharArray();
        int st = 0, end = ch.length-1;
        
        for( int i = 0 ; i < ch.length; i++) {
            
            if( ch[i] == 32 ){
                reverse(ch,st,i-1);
                st = i+1;
            } else if ( i == end)
                reverse(ch,st,i);
        }
        
        return new String(ch);
    }
    
    public void reverse(char[] s, int i, int j){
        while(i < j){
            Utils.swap(s,i++,j--);
        }
    }
    
}
