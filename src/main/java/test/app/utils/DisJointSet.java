package test.app.utils;

import java.util.Arrays;

public class DisJointSet {

	int[] parent ;
	int[] size ;
	
	public DisJointSet(int n ) {
		parent = new int[n] ;
		size = new int[n];
		
		for(int i=0;i<parent.length;i++) {
			make(i);
		}
	} 
	
	public DisJointSet(int n , boolean withoutMake) {
		parent = new int[n] ;
		size = new int[n];
		Arrays.fill(size, -1);
	}
	
	
	public void make( int n ) {
		
		//means it is already made
		if( size[n] > 0 ) 
			return ;
		
		parent[n] = n;
		size[n] = 1;
	}
	
	public int find ( int n ) {
		if( n == parent[n] )
			return n;
		
		int p = find(parent[n]);
		parent[n] = p;// Path Compression;
	
	    return p;
				
	}
	
	public int sets ( ) {
		int count = 0;
		for(int i=0;i<parent.length;i++) {
			if( i == parent[i] )
				count++;
		}
				
		return count;
	}
	
	
	public void union ( int u, int v ) {
		int p1 = find(u);
		int p2 = find(v);
		
		if( p1 != p2 ) {
			if( size[p1] > size[p2] ) {
				parent[p2] = p1;
				size[p1] += size[p2];
			} else {
				parent[p1] = p2;
				size[p2] += size[p1];
			}
		}
	}
	
	public int size( int i ) {
		return size[find(i)];
	}
	
	public static void main( String[] args ) {
		DisJointSet ds = new DisJointSet(6);
		
		ds.make(0);
		ds.make(1);
		ds.make(2);
		ds.make(3);
		
		System.out.println( ds.find(0) );
		System.out.println( ds.find(1) );
		System.out.println( ds.find(2) );
		System.out.println( ds.find(3) );
		
		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(1, 4);
		
		
		System.out.println( ds.find(1) );
		System.out.println( ds.find(2) );
		System.out.println( ds.find(3) );
		System.out.println( ds.find(4) );
	}

}
