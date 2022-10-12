package test.app.graph;

import test.app.utils.DisJointSet;

public class RegionsCutBySlashes {

	public static void main(String[] args) {

		String[] grid = {"\\ "," \\"};
		System.out.println( new RegionsCutBySlashes().regionsBySlashes(grid));
	}
	
	public int regionsBySlashes(String[] grid) {

		int N = grid.length;
		
		//4  nodes for each 1x1 square inside Grid
		DisJointSet ds = new DisJointSet(4*N*N);
		
		for( int r=0 ; r<N; r++) {
			for( int c=0; c<N; c++) {
				int root = 4*(r*N + c);
				char ch = grid[r].charAt(c);
				
				if( ch == ' ') {
					ds.union(root+0, root+1);
					ds.union(root+1, root+2);
					ds.union(root+2, root+3);
				} else if( ch =='/' ) {
					ds.union(root+0, root+1);
					ds.union(root+2, root+3);
				} else {
					ds.union(root+0, root+2);
					ds.union(root+1, root+3);
				}
				
				// union of north and south of upper cell
				if( r-1 >= 0)
					ds.union(root+0, (root-(4*N)) + 3);
				
				// union of south and north of lower cell
				if( r+1 < N)
					ds.union(root+3, (root+(4*N))+0);
			
				
				// union of west and east of left cell
				if( c-1 >= 0)
					ds.union(root+1, (root-4)+2);
				
				// union of east and west of right cell
				if( c+1 < N)
					ds.union(root+2, (root+4)+1);
			
			}
			
			
		}
		
		
		return ds.sets();
    }

}
