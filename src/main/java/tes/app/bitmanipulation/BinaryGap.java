package tes.app.bitmanipulation;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(1041));
		System.out.println( new BinaryGap().solution(1041));
	}

	
	public int solution(int N) {
		
       int i=32,gap=0;
       while( i>0 && ((N&1)==0)){
           N = N>>1;
           i--;
       }  
       
       int ct=0;
       while( i>0 ){
           if( (N&1)==1 ){
               gap = Math.max(ct,gap);
               ct=0;
           } else{
               ct++;
           }
           N = N>>1;i--;
       }

       return gap;
	}
}


