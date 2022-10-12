package test.app.graph;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import test.app.utils.DisJointSet;

public class MostStonesRemovedWithSameRowOrColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] stones = { {0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
       
       System.out.println( new MostStonesRemovedWithSameRowOrColumn().removeStones(stones));
	}
	
	
	public int removeStones(int[][] stones) {
        
        
		DisJointSet ds = new DisJointSet(stones.length);
		
		for( int i=0;i<stones.length;i++) {
			int[] eater = stones[i];
			for( int j=0;j<stones.length;j++) {
				if( eater[0] == stones[j][0] || eater[1] == stones[j][1] )
					ds.union(i+1, j+1);
			}
		}
        

		return stones.length - ds.sets();
		
        
    }
    
    public int dfs( Map<Integer,Set<Integer>> rows, Map<Integer,Set<Integer>> cols ,int row , int col ){
        
    	
        return  1;
    }

}
