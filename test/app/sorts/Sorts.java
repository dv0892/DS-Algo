package test.app.sorts;

import java.util.Arrays;
import test.app.Utils;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2,6,6,1,9};
		
		//bubbleSort(arr);
		selectionSort(arr);
		
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
	
	public static void selectionSort(int[] a) {
		int n = a.length;
		
		/*
		 * In selection sort, we can follow two strategies :
		 * 1. Pick the largest element and place it at the end
		 * 2. Or Pick the smallest element and place it at the start.
		 */
		
		// Implementation for Point 1
		/*for( int i = 0; i < (n); i++) {
			int max_i = 0;
			for( int j = 0; j < (n-i); j++) {
				if(a[j] > a[max_i])
					max_i = j;
			}
			Utils.swap(a, max_i, n-1-i);
		} */
		
		// Implementation for Point 2
		for( int i = 0; i < (n); i++) {
			int min_i = i;
			for( int j = min_i+1; j < (n); j++) {
				if(a[j] < a[min_i])
					min_i = j;
			}
			Utils.swap(a, min_i, i);
		}
	}

}
