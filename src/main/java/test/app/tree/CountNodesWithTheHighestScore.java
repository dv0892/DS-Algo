package test.app.tree;

import java.util.Arrays;

import test.app.utils.Utils;

public class CountNodesWithTheHighestScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] parents = Utils.readLeetInput1("leetinput");
		
		System.out.println( new CountNodesWithTheHighestScore().countHighestScoreNodes(parents));
	}
	
    public int countHighestScoreNodes(int[] parents) {
        // initialize left and right of each node ( from 0 to n-1 )
        int N = parents.length;
        int[] left = new int[N];
        int[] right = new int[N];

        Arrays.fill(right,-1);
        Arrays.fill(left,-1);

        for( int i=1;i<N;i++){
            int p = parents[i];
            if( left[p] == -1 )
                left[p] = i;
            else
                right[p] = i;
        }

        // initialize count arrays 
        long[] count = new long[N];
        // calling a recursive funciton to populate this for entire tree
        count(0,left,right,count);
        
        System.out.println( Arrays.toString(count));

        long maxScore = -1 ;int nodesWithHighestScore = 1;
        for( int i=0;i<N;i++){
            long t1=1,t2=1,t3=1;
            if( parents[i] > -1) t1 = N - count[i];
            if( left[i] > -1 )  t2 = count[left[i]];
            if( right[i] > -1 ) t3 = count[right[i]];
            
            long score = t1*t2*t3;
            if( score > maxScore ) {
                maxScore = score;
                nodesWithHighestScore=1;
            } else if( score == maxScore ){
                nodesWithHighestScore++;
            }

        }

        return nodesWithHighestScore;
    }

    public long  count( int n, int[] left , int[] right , long[] count){

        count[n]++;

        if( left[n] > -1 ) count[n] += count(left[n],left,right,count);
        if( right[n] > -1 ) count[n] +=	count(right[n],left,right,count);
        	
        return count[n];
    }

}
