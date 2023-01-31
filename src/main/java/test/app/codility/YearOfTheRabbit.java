package test.app.codility;

public class YearOfTheRabbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[] A, int[] B) {
        int k = 0, N = A.length;
        while( k < N ){
            int i = 0;
            while( i < N ) {
                int newPosOfi = i-k;
                if( newPosOfi < 0 )
                    newPosOfi += N;

                if( A[i] == B[newPosOfi] ){
                    break;
                }
                i++;
            }

            if( i == N )
                return k;
            
            k++;
        }
        return -1;
    }

}
