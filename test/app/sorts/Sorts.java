package test.app.sorts;

import java.util.Arrays;

import test.app.utils.Utils;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,8,7,6,5,4,3,2,1,-1};
		
		//bubbleSort(arr);
		//selectionSort(arr);
		//insertionSort(arr);
		//shellSort(arr);
		
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
		 * 
		 * and keep on doing this for rest of the elements.
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

	public static void insertionSort(int[] a) {
		int n = a.length;
		for( int i = 1; i < (n); i++) {
			/*
			 * This sort assumes one part is sorted 
			 * and other is unsorted. Starts picking element from unsorted part
			 * and puts them in sorted part at its correct position 
			 * one by one.
			 */
			
			int pivotEl = a[i];
			int j = i-1;
			while(j >= 0 && pivotEl < a[j]) {  
				a[j+1] =  a[j];
				j--;
				
			}
			a[j+1] = pivotEl;
		} 
	}
	
	public static void shellSort(int[] a) {
		int n = a.length;
		/* 
		* Most important step is determining the interval to 
		* subsequent h-interval insertion sorts. 
		*/
		int h = 1;
		
		while(h < n/3) h = 3*h + 1;
		
		/*
		 *  There are many techniques to compute h.
		 *  Above is just one of many.
		 * 
		 *  'h' has been computed
		 *  For n = 10, h will be 1,4
		 *  n = 20, h will be 1,4,13 
		 *  
		 *  Sorts will be performed in the reverse order.
		 */
		
		while(h >= 1) {
			/*
			* h- interval based sorting
			* This is just a generic version of insertion sort
			* based on h.
			*/
			for(int i = h; i < n; i++) {
				 int pivotEl = a[i];
				 int j = i-h;
				 while(j >= 0 && pivotEl < a[j]) {  
						a[j+h] =  a[j];
						j -= h;
				 }
				 a[j+h] = pivotEl;
			}	
			h /= 3;
		}
	}
}
