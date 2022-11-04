package test.app.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseVowels(String S) {
        int s ,e , n = S.length();
        s = 0 ; e = n-1;

        Set<Character> vowels = new HashSet<>();
        addVowels(vowels);

        char[] str = S.toCharArray();
        while ( s < e ){
            //Stop at the first vowel from left 
            while( s < e && !vowels.contains(str[s]) )
                s++;

            while( s < e && !vowels.contains(str[e]) )
                e--;

            swap(str,s++,e--);
            
        }

        return new String(str);
    }

    private void addVowels( Set<Character> vowels ){
     
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

    }

    private void swap( char[] str , int s , int e ){
         if ( s < e ){
             char t = str[s];
             str[s] = str[e];
             str[e] = t;
         }
    }

}
