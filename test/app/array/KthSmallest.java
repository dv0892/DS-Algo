package test.app.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import test.app.utils.Utils;
import test.app.utils.Utils.Pair;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for(int i=0; i<arr.length; i++) {
    		arr[i] =  ThreadLocalRandom.current().nextInt(100);;
    	}
		
		System.out.println(Arrays.toString(arr));
		
		/*
		Here we have taken the task of  finding the
		and even randomized k also.
		The k will lie in the range of indices of length of array
		*/
		int k = ThreadLocalRandom.current().nextInt(0,arr.length);
		
		System.out.println(k );
		System.out.println(new KthSmallest().kthSmallest(arr, 0, arr.length-1, k-1));
	}
	
	public int kthSmallest(int[] arr, int  p, int q, int i) {
		
		if(p == q)
			return arr[p];
		
		/*
		 * 
		 * 
		 * This algo can be further optimized to contain
		 * the case when there are duplicate elements
		 * and our i lies in that range
		 * 
		 * int  k = parition(arr,p,q);

		if( k == i )
			return arr[k];

		if( i < k )
			return kthSmallest(arr, p, k-1, i );
		else
			return kthSmallest(arr, k+1, q, i );*/
		
		
		/*
		 * This is a classic application of partition routine of
		 * quick sort.
		 */
		Pair  pair = quickPartition_faster_randomized(arr,p,q);
		
		if( (i >= pair.i+1) && ( i <= (pair.j-1)) )
			return arr[pair.i + (i-pair.i)];
		
		if( i <= pair.i )
			return kthSmallest(arr, p, pair.i, i );
		else
			return kthSmallest(arr, pair.j, q, i );
		
	}
	
	public int parition(int[] arr, int p, int q) {
		
		int i=p-1;
		int j=p;
		
		int pivot = arr[q];
		
		while( j < q) {
			if(arr[j] < pivot) {
				Utils.swap(arr, ++i, j);
			} 
			j++;
		}
		
		Utils.swap(arr, ++i, j);
		
		return i;
	}
	
	public static Pair  quickPartition_faster_randomized(int[] a, int l, int r) {
    	
    	int i = l-1; 
    	int j = l;
    	int k = r+1;
    	
    	int pIndex = ThreadLocalRandom.current().nextInt(l,r+1);
    	int pivot = a[pIndex];
    	
    	
    	while (j < k) {
    		if(a[j] == pivot) {
    			j++;
    		} else if (a[j] < pivot)
    			Utils.swap(a, ++i, j++);
    		else
    			Utils.swap(a, --k, j);
    	}
    	
    	return new Pair(i,k);
    }

}
