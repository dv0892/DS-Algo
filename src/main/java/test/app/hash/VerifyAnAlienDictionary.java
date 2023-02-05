package test.app.hash;

import java.util.HashMap;
import java.util.Map;

public class VerifyAnAlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character,Integer> map = new HashMap<>();
        map.put('*',-1);
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            map.put(ch,i);
        }

        for(int w=0;w<words.length-1;w++){
        	
            if( isOrderCorrect(words[w],words[w+1],map) )
                continue;
            return false;
        }

        return true;
    }

    public boolean isOrderCorrect( String s1, String s2 , Map<Character,Integer> map ){
        for( int i=0;i<s1.length();i++) {
             char ch1 =   s1.charAt(i); 
             char ch2 = (i<s2.length())? s2.charAt(i) : '*' ;
             if( map.get(ch1) >  map.get(ch2) )
                return false;
             else if ( map.get(ch1) < map.get(ch2) ) 
                return true;
             else
                continue;
        }

        return true;
    }
	

}
