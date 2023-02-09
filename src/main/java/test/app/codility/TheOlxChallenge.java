package test.app.codility;

import java.util.Arrays;
import java.util.Collections;




 class TheOLXGroup2020A2  {
	int checkIndex(int[] sortedJuice, int[] juice, int[] capacity, int N, int i) {
		int j = juice[i], c = capacity[i];
		boolean notskip = true;
		int remain = c - j;
		int max = 1;
		for (int k = 0; k < N && remain > 0; k++) {
			int sj = sortedJuice[k];
			if (sj == j && notskip) {
				notskip = false;
				continue;
			}
			remain -= sj;
			if (remain >= 0)
				max++;
		}

		return max;
	}

	public int solution(int[] juice, int[] capacity) {
		int N = juice.length;

		int[] sortedJuice = juice.clone();
		Arrays.sort(sortedJuice);
		int minJuice = sortedJuice[0];

		int maxCapacity = 0;
		int maxCapacityIndex = 0;
		int maxEmpty = 0;
		int maxEmptyIndex = 0;

		for (int i = 0; i < N; i++) {
			int j = juice[i], c = capacity[i];
			if (c - j > maxEmpty) {
				maxEmpty = c - j;
				maxEmptyIndex = i;
			}
			if (c > maxCapacity && c - j >= minJuice) {
				maxCapacityIndex = i;
				maxCapacity = c;
			}
		}
		int max1 = checkIndex(sortedJuice, juice, capacity, N, maxEmptyIndex);

		int max2 = 1;
		if (maxCapacityIndex != maxEmptyIndex)
			max2 = checkIndex(sortedJuice, juice, capacity, N, maxCapacityIndex);

		return Math.max(max1, max2);
	}
}

public class TheOlxChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] juice = new int[]    { 10,10,10,20,90 };
		int[] capacity = new int[] { 70,70,70,70,100};
		
		System.out.println( new TheOlxChallenge().solution(juice , capacity));
		System.out.println( new TheOLXGroup2020A2().solution(juice , capacity));
	}

    public int solution(int[] juice, int[] capacity) {
    	
    	// Failing only one case in which 4 is expected instead of 3.
    	// Otherwise passing all performance and correctness cases
    	
    	int n = juice.length;
 		long[][] arr  = new long[n][2];
 		
 		for( int j=0;j<n;j++) {
 			arr[j][0] = juice[j] ;
 		}
 		
 		Arrays.sort(arr,(j1,j2) -> Long.compare(j1[0],j2[0]) );
 		
 		arr[0][1] = arr[0][0];
 		for( int j=1;j<n;j++) {
 			arr[j][1] = arr[j-1][1] + arr[j][0];
 		}		
 		
 		int max = 1 ;
 		for( int j=0;j<n;j++) {
 			long req = (capacity[j] - juice[j]) ;            
 			if( req > 0) {
 				int count = 1;
                 int limit = binarySearch(arr,req);
                 if( limit == n )
                	 return n;
                               
                 long availJuice =  arr[limit][1];
                 if( juice[j] <= arr[limit][0] ) {
                 	availJuice -= juice[j];
                 	count = 0;
                 } else {
                	 count += (limit+1);
                 }
                 
                 if( req >= availJuice ) {
                 	count += (limit+1);
                 } else {
                 	availJuice -= req;
                 	int exact = findExact(arr,availJuice , limit);
             		if(  exact == -1 ) {
             			count += (limit);
             		} else {
             			count += (limit-exact);
             		}
                 }
                 
                 max = Math.max(max, count);
 			}		
 		}
 		
 		return max;
    }
    
    public int findExact( long[][] arr , long availJuice , int e) {
		int s=0;
		while( s<=e ) {
			int m = s + (e-s)/2;
			
			if( arr[m][1] == availJuice )
				return m;
			
			if( arr[m][1] < availJuice ) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		
		return -1;
	}

    public int binarySearch( long[][] arr , long req ) {
		int s=0,e=arr.length-1;
		while( s<=e ) {
			int m = s + (e-s)/2;
			
			if( arr[m][1] <= req ) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		
		return s;
	}
}
