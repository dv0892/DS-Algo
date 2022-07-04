package test.app.trie;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> lexicalOrder(int n) {
        return lexicalOrder(0,n);
    }
    
    public List<Integer> lexicalOrder(int i , int limit){
        if ( i > limit )
            return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
                                      
        int j = 0;
        while( j < 10){
            int n = i*10 + j++;
            if ( n > 0 && n <= limit ){
                res.add(n);
                res.addAll(lexicalOrder(n,limit));
            }
        }
        
        return res;
    }

}
