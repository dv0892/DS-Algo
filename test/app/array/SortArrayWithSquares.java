package test.app.array;

public class SortArrayWithSquares {
	
	public static void main(String... args) {
		
	}
	
    public int[] solve(int[] A) {

        int countOfNeg =  0;
        for(int el :  A){
            if(el < 0)
                countOfNeg++;
        }
        
        return insertNegativesAtCurrentPosition(A, countOfNeg);
    }

    public int[] insertNegativesAtCurrentPosition(int[] a,int countOfNeg){

    int countOfPos = a.length - countOfNeg;  
    int st  = a.length - countOfPos ;        
    int end = a.length - 1;

    return new int[2];

    }
}
