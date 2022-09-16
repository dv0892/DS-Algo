package tes.app.bitmanipulation;

public class RightCyclicShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new RightCyclicShift().solution(9736));
	}

	
	int solution(int N) {
        int largest = 0;
        int shift = 0;
        int temp = N;
        for (int i = 1 ; i < 30; ++i ) {
            int index = (N & (int)(Math.pow(2,i)-1));
            temp = ( (N >> i) | (index << (29)) );
            if (temp > largest) {
                largest = temp;
                shift = i;
            }
        }
        return shift;
    }
}
