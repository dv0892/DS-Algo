package test.app.array;

import java.util.Arrays;

public class ReplaceElementsWithGreatestOnRightSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {17,18,5,4,6,1};
		System.out.println( Arrays.toString( new ReplaceElementsWithGreatestOnRightSide().replaceElements(arr)));
	}
	
	public int[] replaceElements(int[] arr) {
        // This requires O(n) space and time
        /*int[] res = new int[arr.length];
        int j = res.length - 1;
        res[j--] = -1;
        
        for( ; j >= 0; j-- ){
            res[j] = Math.max( arr[j+1], res[j+1] );
        }
        
        return res;*/
		
		//This requires O(1) space and O(n) time
		int  j = arr.length - 1;
		int  maxSoFar = arr[j];
		arr[j--] = -1;
		
		for(  ; j >=0 ; j--) {
			int t = maxSoFar;
			maxSoFar = Math.max(maxSoFar, arr[j]);
			arr[j] = t;
		}
		
		return arr;
    }

}
