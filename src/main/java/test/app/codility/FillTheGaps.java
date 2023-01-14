package test.app.codility;

import java.util.Arrays;

public class FillTheGaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new FillTheGaps().solutionSubmission("a?b"));
	}
	
public int solutionSubmission(String S) {
		
		if( S.length() == 1)
			return 1;
		
		// Step 1 create suffix array
		int size = S.length();
		int max = Integer.MIN_VALUE;
		int[] suffix = new int[size];
		
		int preCount = S.charAt(size-1) == '?' ? 0 : 1;
		for( int i=size-2;i>=0;i--) {
			if( S.charAt(i) == '?' ) {
				suffix[i] = preCount;
				max = Math.max(max, preCount);
				preCount = 0;
				continue ;
			} 
			
			if( S.charAt(i) == S.charAt(i+1) ) {
				preCount++;
			    continue;
			} else {
				max = Math.max(max, preCount);
				preCount = 1;
			}
		}
		max = Math.max(max, preCount);
		// suffix array creation done.
		
		// check fragments of question marks
		preCount = S.charAt(0) == '?' ? 0 : 1;
		
		for( int i=1;i<size;i++) {
			if( S.charAt(i) == '?' ) {
				int j = i+1;
				while( j < size && S.charAt(j) == '?' ) {
					j++;
				}
				
				if( j == size ) 
					return  Math.max(max,1);
				
				if( (i-1) == 0 && S.charAt(0) == '?') { // check only in suffix array
					max = Math.max(max, 1);
					i = j;
					preCount = 1;
					continue;
				}
				
				int len=j-i;
				if( S.charAt(i-1) == S.charAt(j) ) {
					max = Math.max(max, 2);
				} else {
					if( len == 1 ) {
						if(  suffix[j-1] < preCount ) {
							max = Math.max(max,  suffix[j-1] + 1);
							i = j;
							preCount = 2;
							continue;
						} 
						max = Math.max(max, Math.min(preCount, suffix[j-1]) + 1);
					} else if( (len&1) == 1 ) {
						max = Math.max(max, 2);
					}
				}	
				
				i = j;
				preCount = 1;
				continue;
			}
			
			if( S.charAt(i) == S.charAt(i-1) ) {
				preCount++;
			    continue;
			} else {
				preCount = 1;
			}
		}
		
		
		System.out.println( Arrays.toString(suffix) );
		System.out.println( "Max Fragment  : " + max );
		
		return  max;
	}
	
	public int solution(String S) {
		
		// Step 1 
		
		int max = Integer.MIN_VALUE;
		int count = S.charAt(0) == '?' ? 0 : 1;
		
		for( int i=1;i<S.length();i++) {
			if( S.charAt(i) == '?' ) {
				max = Math.max(max, count);
				count = 0;
				continue ;
			} 
			
			
			if( S.charAt(i) == S.charAt(i-1) ) {
				count++;
			    continue;
			} else {
				max = Math.max(max, count);
				count = 1;
			}
			
		}
		
		return max = Math.max(max, count);
	}

}
