package test.app.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import test.app.utils.Utils;
import test.app.utils.Utils.Pair;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
    		arr[i] =  ThreadLocalRandom.current().nextInt(10);;
    	}*/
		
		int[] arr = {0, 0, 4, 4, 5, 5, 6, 9, 9, 9};
		System.out.println( Arrays.toString(arr) );
		Arrays.sort(arr);
		System.out.println( Arrays.toString(arr) );
		
		System.out.println(new KthSmallest().kthSmallest(arr, 0, arr.length-1, 4));
	}
	
	public int kthSmallest(int[] arr, int  p, int q, int k) {
		
		if(p == q)
			return arr[p];
		
		Pair pair = parition_randomized(arr,p,q);
		
		if( k > pair.i && k < pair.j)
			return arr[k];
		
		if(k < pair.i)
			return kthSmallest(arr, p, pair.i, k);
		else
			return kthSmallest(arr, pair.j, q, k - pair.j);
		
	}
	
	public Pair parition_randomized(int[] arr, int p, int q) {
		
		int i,j,k;
		i=p-1;
		j=p;
		k=q+1;
		
		int pivotIndex = ThreadLocalRandom.current().nextInt(p, q+1);
		int pivot = arr[pivotIndex];
		
		while( j < k) {
			if(arr[j] == pivot) {
				j++;
			} else if(arr[j] < pivot) {
				Utils.swap(arr, ++i, j++);
			} else {
				Utils.swap(arr, --k, j);
			}
		}
		
		return new Pair(i,k);
	}

}
