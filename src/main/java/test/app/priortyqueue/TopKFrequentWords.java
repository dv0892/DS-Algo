package test.app.priortyqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TopKFrequentWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
public List<String> topKFrequent(String[] words, int k) {
        
        //Space : O(2n) -> O(n)
        //Time  : O( n + nlogn + klogn)
        //Time  : O( n + nlogk + k)
        
        Map<String,Pair> map = new HashMap<>();
        for( String w : words ){
            if( map.containsKey(w) ){
                map.get(w).freq++;
            } else{
                map.put(w,new Pair(w,1));
            }
        }
        
        TreeSet<Pair> set = new TreeSet<>((p1,p2)->{ if ( (p2.freq-p1.freq)!= 0 ) {
                                                         return  (p2.freq-p1.freq) ;
                                                    } else
                                                        return p1.word.compareTo(p2.word) ;
                                                  });
        
        
        List<String> res = new ArrayList<>();
        
        for( Pair p : map.values() ){
            if( set.size() == k ) {
                 Pair t = set.last();
                 if( p.freq > t.freq || (p.freq == t.freq && (p.word.compareTo(t.word))<0) ){
                     set.pollLast();
                     set.add(p);
                 } 
            } else
                set.add(p);
        }
        
        while( k-- > 0 ){
          res.add(set.pollFirst().word);
        }
        
        return res;
    }
}

class Pair {
    String word;
    int freq;
    
    Pair(String word, int f){
        this.word = word;
        this.freq = f;
    }
    
    public String toString() {
        return this.word +" -- " + this.freq;
    }
    
    public boolean equals( Pair p ){
        return this.word.equals(p.word);
    }
    
    public int hashCode( ){
        return this.word.hashCode() + this.freq;
    }
}
