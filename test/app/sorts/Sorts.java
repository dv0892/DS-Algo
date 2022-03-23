package test.app.sorts;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import test.app.utils.Utils;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] arr = new int[1000000];
		for(int i=0; i<arr.length; i++) {
    		arr[i] =  ThreadLocalRandom.current().nextInt(1000000);;
    	}
		
		//int[] arr = {3,1,2,2,2,2,5};
		
		//System.out.println("Array Sorted "+ " : "+ isSorted(arr) + " : "+ Arrays.toString(arr));
		
		long st  = System.currentTimeMillis();
		//bubbleSort(arr);
		//selectionSort(arr);
		//insertionSort(arr);
		//shellSort(arr);
		//mergeSort(arr, 0, arr.length-1);
		quickSort(arr,0,arr.length-1);
		
		long ed  = System.currentTimeMillis();
		
		System.out.println("Array Sorted "+ " : "+ isSorted(arr) + " : "+ /*(ed-st)/1000*/  Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] a) {
		
		/*
		 * Worst Case : O(n^2)
		 * 
		 * Stable Sort : NO
		 */
		
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

		/*
		 * Worst Case : O(n^2)
		 * 
		 * Stable Sort : NO
		 */
		
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
		
		/*
		 * Worst Case : O(n^2)
		 * 
		 * Stable Sort : YES
		 * 
		 */
		
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
		
		/*
		 * Worst Case : falls somewhere near O( n^(3/2) ) 
		 * but it is never O(n^2).
		 * 
		 * Stable Sort : NO
		 * 
		 * 
		 */
		
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
		 *  First will perform insertion sort on 13 interval,
		 *  then 4-interval and 1-interval.
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

    public static void mergeSort(int[] a, int s, int e) {
    	
    	/*
    	 * if array is of size 1 , this means it is already sorted.
    	 * This is where we stop going further down in the recursion tree.
    	 * And the merge the two - sorted arrays each of size 1 by 
    	 * calling @combine function
    	 */
    	
    	if(s >= e )
    		return ;
    	
    	int mid = s + (e-s)/2;
    	mergeSort(a,s,mid);
    	mergeSort(a,mid+1,e);
    	
    	combine(a,s,mid,e);
    }

	private static void combine(int[] a, int s, int mid, int e) {
	
		int[] left = Arrays.copyOfRange(a, s,mid+1);
		int[] right = Arrays.copyOfRange(a, mid+1,e+1);
		
		int i=0,j=0,k=s;
		for( ; i<left.length && j<right.length;) {
			if(left[i] <= right[j])
				a[s++] = left[i++];
			else 
				a[s++] = right[j++];
		}
		
		
	    while( i<left.length ) {
	    	a[s++] = left[i++];
	    }
	    
	    while( j<right.length ) {
	    	a[s++] = right[j++];
	    }
	}
    
    public static boolean isSorted(int[] a) {
    	int prev = a[0];
    	for(int i=1; i<a.length; i++) {
    		if(!(a[i] >= prev))
    			return false;
    	}
    	
    	return true;
    }

    static void quickSort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        //int pivotIndex = quickPartition(nums, low, hi);
        
        Pair pair = quickPartition_faster(nums, low, hi);

        //System.out.println(Arrays.toString(nums));
        // now my pivot is at correct index, please sort two halves now
        quickSort(nums, low, pair.i);
        quickSort(nums, pair.j,  hi );
    }
    
    public static int  quickPartition(int[] a, int l, int r) {
    	// This partition algo can further optimized to cover 
    	// the case where we have multiple elements that are equal to
    	// pivot. They all can clubbed together to make
    	// three sections in array
    	//   elements less than pivot , elements equal to pivot, elements greater than pivot
    	//   Then further quick sort needs to be run only on 1st and 3rd section
    	
    	int pivot = a[r];
    	int j = l;
    	int i = l-1;
    	
    	while(j < r) {
    		if(a[j] <= pivot)
    			Utils.swap(a, ++i, j);
    		
    		j++;
    	}
    	
    	Utils.swap(a, j, i+1);
    	
    	return i+1;
    	
    	
    }
    
    public static Pair  quickPartition_faster(int[] a, int l, int r) {
    	// This partition algo can further optimized to cover 
    	// the case where we have multiple elements that are equal to
    	// pivot. They all can clubbed together to make
    	// three sections in array
    	//   elements less than pivot , elements equal to pivot, elements greater than pivot
    	//   Then further quick sort needs to be run only on 1st and 3rd section
    	
    	int pivot = a[r];
    	int k = l,i,j;
    	i = j = l-1;
    	
    	while(k <= r) {
    		if(a[k] < pivot) {
    			if(j > i) {
    			  //Since we are maitiaing two regions,
    			  // so we have to do two swaps.
    			  int t = a[k];
    			  Utils.swap(a, ++j, k);
    			  Utils.swap(a, ++i, j);
    			  a[i] = t;
    			} else
    				Utils.swap(a, ++i, k);
    		} else if(a[k] == pivot) {
    			if(j < i) {
    				// This case covers when we have found smaller elements already but this is
    				// the first equal(to pivot) element found.
    				Utils.swap(a, i+1, k);
    				j = i+1;
    			} else
    				Utils.swap(a, ++j, k);
    			
    		}
    		
    		k++;
    	}
    	
    	return new Pair(i,j+1);
    	
    	
    }
    
    static class Pair{
    	int i,j;
    	Pair(int i,int j){
    		this.i= i;
    		this.j= j;
    	}
    }
}
