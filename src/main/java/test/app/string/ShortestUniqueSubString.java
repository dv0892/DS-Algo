package test.app.string;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniqueSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ShortestUniqueSubString().solution("zyzyzyz"));
	}
	
	public int solution(String S) {
        
        Map<String,Integer> freq = new HashMap<>();
        int len = 1;
        while( len < S.length() ){
            for( int i=0 ;i<=(S.length()-len);i++){
                    String sub = S.substring(i,i+len);                    
                    freq.put(sub,freq.getOrDefault(sub,0)+1);
            }

            for ( String key : freq.keySet()){
                if( freq.get(key) == 1 ){
                    return key.length();
                }
            }
            
            freq.clear();

            len++;
        }

        return S.length();
         
    }

}
