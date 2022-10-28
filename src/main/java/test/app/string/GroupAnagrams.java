package test.app.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println( new GroupAnagrams().groupAnagrams(str));
		
		Map<Test,String > map = new HashMap<>();
		map.put( new Test(), "GH");
		map.put( new Test(), "GH1");
		

		System.out.println( map.get(new Test()));
	}
	
	static class Test{
		
		public boolean equals( Object o ) {
			return true;
		}
		
		public int hashCode() {
			return 9;
		}
	}
	
	 public List<List<String>> groupAnagrams(String[] strs) {
	        
	       
	        
	        
	        Map<AnaTest,List<String>> map1 = new HashMap<>();
	        for( String s1 : strs ){
	        	 AnaTest obj = new AnaTest(s1);
				 List<String> list = map1.get(obj);
	             if( list == null ){
	            	 list = new ArrayList<>();
	                 map1.put(obj,list);
	            }
	            
	            list.add(s1);
	        }
	        
	        return new ArrayList(map1.values());
	    }
	    
	    
	 class AnaTest {
		
		 String str ;
		 
		 public AnaTest( String s ) {
			 this.str = s;
		 }
		 
			public boolean equals( Object o ) {
				
				String str1 = ((AnaTest)o).str;
				
				if( str1.length() != str.length() ) 
					return false;
				
				int[] count = new int[26];
				for( int i=0;i<str1.length();i++) {
					count[str1.charAt(i)-'a']++;
				}	
				
				for( int i=0;i<str.length();i++) {
					count[str.charAt(i)-'a']--;
				}
				
				for ( int c : count ) {
					if ( c > 0 )
						return false;
				}
				
				return true;
			}
			
			public int hashCode() {
				
				if( str.length() == 0 )
					return 0;
				
				int h = 0;
				for( int i=0;i<str.length();i++ ) {
					h += (int)str.charAt(i);
				}
				
				
				return h;
			}
		}

}
