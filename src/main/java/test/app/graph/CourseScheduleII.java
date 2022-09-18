package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int courses = 2;
		int[][] edges = { { 1,0}};
		
		System.out.println( Arrays.toString( new CourseScheduleII().findOrder(courses, edges)));
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
    
		// Step -1  : To check if there is cycle in graph
		int[][] mat = new int[numCourses][numCourses] ;
		for( int[] req : prerequisites )
			mat[req[0]][req[1]] = 1;
		
		List<Integer> order = new ArrayList<>();
		boolean[] visited = new boolean[numCourses];
		for( int v = 0; v < numCourses ;v++) {
			if( !visited[v] )
				if( isCycle( v , mat , visited , new boolean[numCourses] , order) )
					return new int[0];
				
		}
		
		
		return order.stream().mapToInt(i -> i.intValue() ).toArray();
	}
	
	public int[] topologicalSort( int[][] mat ) {
		
		int n = mat.length;
		int[] order = new int[n];
		int index = 0;
		
		boolean[] visited = new boolean[n];
		for ( int v =0 ;v<n;v++) {
			if( !visited[v] ) {
				index = visit( v , mat , order ,  visited, index );
			}
		}
		
		
		return order;
	}
	
	private int visit(int v, int[][] mat, int[] order, boolean[] visited, int index) {
		if( visited[v] )
			return index;
		
		visited[v] = true;
		
		int c = 0;
		for( int edge : mat[v]) {
			if( edge == 1) {
				index = visit( c , mat, order , visited, index); 
			}
			c++;
		}
	
		order[index++] = v; 
		return index;
	}

	private boolean isCycle(int v, int[][] mat, boolean[] visited, boolean[] visiting, List<Integer> order ) {
		
		if( visiting[v] )
			return true;
		
		visiting[v] = true;
		
		int course = 0;
		for( int edge : mat[v] ) {
			if( edge == 1) 
				if(  !visited[course] && isCycle( course , mat , visited , visiting,order ) ) 
					return true;
				
			course++;
		}
		
		visiting[v] = false;
		visited[v] = true;
		
		order.add(v);

		return false;
	}

}
