package test.app.search;

import java.util.Arrays;

public class CompareStringsByFrequencyOfSmallestCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] queries    = {"b","cd"};
		String[] words  	= {"a","aa","aaa","aaaa"};
		
		System.out.println( Arrays.toString(new CompareStringsByFrequencyOfSmallestCharacter().numSmallerByFrequency(queries, words) ) );
	}
	
	
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
		int[] t = new int[words.length];
		int i=0;
		for( String str : words ) {
			t[i++] = findSmallestCharAndItFreq(str);
		}
		Arrays.sort(t);
		
		int[] res = new int[queries.length];
		i=0;
		for(String q : queries ) {
			int fs = findSmallestCharAndItFreq(q);
			res[i++] = words.length - binarySearch(t,fs);
		}
		
		return res;
		
	}
	
	private int binarySearch(int[] t, int fs) {
		int s = 0, e = t.length-1;
		while( s <= e ) {
			int mid = s + (e-s)/2;
			
			if( t[mid] <= fs )
				s = mid + 1;
			else
				e = mid - 1;
		}
		
		return s;
		
	}


	public int findSmallestCharAndItFreq(String str) {
		
		char res = 122;
		for(int i=0;i<str.length();i++) {
			if( str.charAt(i) < res ) 
				res = str.charAt(i);
		}
		
		int ct = 0;
		for(int i=0;i<str.length();i++) {
			if( str.charAt(i) == res ) 
				ct++;
		}
		
		return ct;
	}
	
	

}
