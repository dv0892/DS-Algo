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
		
		System.out.println( Arrays.toString(arr) );
		Arrays.sort(arr);
		System.out.println( Arrays.toString(arr) );
		int k = 9;
		System.out.println(new KthSmallest().kthSmallest(arr, 0, arr.length-1, k-1));
	}
	
	public int kthSmallest(int[] arr, int  p, int q, int i) {
		
		if(p == q)
			return arr[p];
		
		int  k = parition(arr,p,q);
		
		if( k == i )
			return arr[k];
		
		if( i < k )
			return kthSmallest(arr, p, k-1, i );
		else
			return kthSmallest(arr, k+1, q, k-i );
		
	}
	
	public int parition(int[] arr, int p, int q) {
		
		int i=p-1;
		int j=p;
		
		//int pivotIndex = ThreadLocalRandom.current().nextInt(p, q+1);
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

}
