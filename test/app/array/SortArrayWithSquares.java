package test.app.array;

import java.util.Arrays;

import test.app.utils.Utils;

public class SortArrayWithSquares {
	
	public static void main(String... args) {
		
		int[] arr = {-5,-4,-2,0,1};
		arr = new SortArrayWithSquares().solve(arr);
		
		System.out.print(Arrays.toString(arr));
	}
	
    public int[] solve(int[] A) {

        int countOfNeg =  0;
        for(int el :  A){
            if(el < 0)
                countOfNeg++;
        }
        
        
         if(countOfNeg == A.length)
            reverse(A);
         else if(countOfNeg != 0)
         	A = insertNegativesAtCurrentPosition(A, countOfNeg);
        
	
        square(A);
        
        return A;
    }

    private void reverse(int[] a) {
    	for(int i=0;i<a.length/2;i++) {
			Utils.swap(a, i, a.length-1-i);
		}		
	}

	private void square(int[] a) {
		for(int i=0;i<a.length;i++) {
			a[i] = Math.abs(a[i]);
			a[i] *= a[i];
		}
	}

	public int[] insertNegativesAtCurrentPosition(int[] a,int countOfNeg){

	    int countOfPos = a.length - countOfNeg;  
	    
	    int l   = 0;
	    int m   = a.length - countOfPos ;        
	    int r   = a.length - 1;
	
	    int[] res = new int[a.length];
	    
	    //copies the positive elements into result array.
	    System.arraycopy(a, m, res, 0, r-m+1);
	    
	    //copy the negative elements into the result one by one
		while(l < m) {
			int el = -a[l++];
			
			int j = countOfPos -1;
			while(j>=0 && res[j] > el) {
			    res[j+1] = res[j];
			    j --;
			}
			
			res[j+1] = el;
			countOfPos++;
		} 
	    
	    return res;

    }
}
