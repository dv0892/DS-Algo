package test.app.dp;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

	public static void main(String[] args) {
		
		System.out.println( new BestTeamWithNoConflicts().bestTeamScore( new int[] {596,277,897,622,500,299,34,536,797,32,264,948,645,537,83,589,770} ,
																		 new int[] {18,52,60,79,72,28,81,33,96,15,18,5,17,96,57,72,72 } ) );;

	}

	public int bestTeamScore(int[] score, int[] ages) {
        int players = score.length;
        int[][] data = new int[players][2];
        for( int p=0;p<players;p++){
            data[p] = new int[]{ages[p],score[p]};
        }

        Arrays.sort(data,(d1,d2) -> Integer.compare(d1[0],d2[0]) == 0 ? Integer.compare(d1[1],d2[1]) : Integer.compare(d1[0],d2[0]) );
        
        for( int[] d : data )
        	System.out.println( Arrays.toString(d));
        
        int highestScore = Integer.MIN_VALUE;
        int[] scores = new int[players];
        for( int p=players-1;p>=0;p--){
             scores[p] = data[p][1];
             
             int j = p+1;
             while( j < players ) {
                 if( data[p][0] == data[j][0] ) {
                    scores[p] = Math.max(scores[p],data[p][1]+scores[j]);
                 } else if( data[p][1] <= data[j][1] ) {
                    scores[p] = Math.max(scores[p],data[p][1]+scores[j]);
                 } 
                 
                 j++;
             }
              
                  
             highestScore = Math.max(highestScore,scores[p]);
        }
        
        System.out.println( Arrays.toString(scores));
        
        return highestScore;
    }
}
