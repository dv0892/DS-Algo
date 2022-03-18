package test.app.sorts;

import java.util.Arrays;
import test.app.Utils;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2,6,3,1,9};
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] a) {
		int n = a.length;
		for( int i = 0; i < (n-1); i++) {
			/*
			 * These two variations of inner loop are valid
			 * Either we can compare with previous element or
			 * with next one.
			 */

			/*
			 * for( int j = 1; j < (n-i); j++) {
				if(a[j] < a[j-1])
					Utils.swap(a, j-1, j);
			}*/
			
			for( int j = 0; j < (n-i-1); j++) {
				if(a[j] > a[j+1])
					Utils.swap(a, j+1, j);
			}
			
		} 
	}

}
