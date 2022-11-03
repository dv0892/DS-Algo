package test.app.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindromeByConcatenatingTwoLetterWords {

	public static void main(String[] args) {
		String[] words = {"em","pe","mp","ee","pp","me","ep","em","em","me"};
		System.out.println( new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(words));
	}
	
	public int longestPalindrome(String[] words) {
        
        Map<String,Integer> map = new HashMap<>();
        for( String w : words ) {
                map.put(w, map.getOrDefault(w,0)+1);
        }
        
        System.out.println( map);
        
        
        boolean notCounted = true;
        int len = 0;
        
        
        // This throws Concurrent Modification Exception
        /*for( String key : map.keySet() ) {
        	Integer val = map.get(key);		
        	
        	if( key.charAt(0) == key.charAt(1) ) {
        		if( val.intValue() > 1 ) {
        			len += (val.intValue()*2);
        			map.remove(key);
        		} else {
        			if( notCounted ) {
        				len += 2;
        				notCounted = false;
        			}
        		}
        	} else {
        		String revKey = new String(new char[] {key.charAt(1),key.charAt(0)});
        		
        		if( !map.containsKey(revKey) ) {
        			map.remove(key);
        			continue;
        		}
        		
        		Integer revKeyVal = map.get(revKey)	;
        		
        		if( val.intValue() == revKeyVal.intValue() ) {
        			len += (val.intValue()*4);map.remove(revKey);map.remove(key);
        		} else if( val.intValue() < revKeyVal.intValue() ) {
        			len += (val.intValue()*4);
        			map.put(revKey, revKeyVal.intValue() - val.intValue() );
        			map.remove(key);
        		} else {
        			len += (revKeyVal.intValue()*4);
        			map.put(key,val.intValue() - revKeyVal.intValue() );
        			map.remove(revKey);
        		}
        	}
        }*/
        
        Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
        while( iterator.hasNext() ) {
        	Entry<String, Integer> entry = iterator.next();
        	String key = entry.getKey();
        	Integer val = entry.getValue();		
        	
        	if( key.charAt(0) == key.charAt(1) ) {
        		if( val.intValue() > 1 ) {
        			
        			//even
        			if( (val.intValue()&1) == 0 ) {
        				len += (val.intValue()*2);
        				iterator.remove();
        			} else {
        				len += ( (val.intValue()-1) * 2);
        				
        				if( notCounted ) {
            				len += 2;
            				notCounted = false;
            				iterator.remove();
            			} else {
            				entry.setValue(1);
            			}
        			}
        			
        		} else {
        			if( notCounted ) {
        				len += 2;
        				notCounted = false;
        				iterator.remove();
        			}
        		}
        	} else {
        		
        		String revKey = new String(new char[] {key.charAt(1),key.charAt(0)});
        		
        		if( !map.containsKey(revKey) ) {
        			iterator.remove();
        			continue;
        		}
        		
        		Integer revKeyVal = map.get(revKey)	;
        		if( val.intValue() > revKeyVal.intValue() ) {
        			len += (revKeyVal.intValue()*4);
        		} else {
        			len += (val.intValue()*4);
        		}
        		
        		
        		iterator.remove();
        		
        	}
        	
        }
        
        return len ;
    }

}
