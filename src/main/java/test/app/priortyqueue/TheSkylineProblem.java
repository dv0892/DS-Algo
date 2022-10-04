package test.app.priortyqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = {{5,12,11},{5,12,10}};
		System.out.println( new TheSkylineProblem().getSkyline(buildings));
		
		
	}
	
	
	public List<List<Integer>> getSkyline(int[][] buildings) {
        
		int[][] newBuildings = new int[buildings.length*2][];
		
		int i=0;
		for( int[] building : buildings ) {
			newBuildings[i++] = new int[] {building[0],-building[2]};
			newBuildings[i++] = new int[] {building[1], building[2]};
		}
		Arrays.sort(newBuildings, (b1,b2) -> (b1[0]==b2[0]) ? (b1[1]-b2[1]):(b1[0]-b2[0]));
		PriorityQueue<Integer> heighPq = new PriorityQueue<>((h1,h2) -> h2 - h1);
		heighPq.add(0);
		
		List<List<Integer>> res = new ArrayList<>();
		int prev=0;
		for( int[] build : newBuildings ) {
			if( build[1] < 0 )
				heighPq.add(-build[1]);
			else
				heighPq.remove(build[1]);
			
			int curr = heighPq.peek();
			
			if( curr != prev ) {
				res.add( Arrays.asList(build[0],curr) );
				prev = curr;
			}
			
			
		}
		
		return res;
    }

}
