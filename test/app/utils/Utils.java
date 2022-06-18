package test.app.utils;

import java.util.ArrayList;


public class Utils {

	public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
	
	public static void swap(char[] arr, int i, int j){
        char t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

	public static Pair findTwoLargest(ArrayList<Integer> a, int j) {
		// TODO Auto-generated method stub
		if(j < 0 || j > (a.size()-1))
			return null;
		
		int max1 , max2 ;
		max1 = max2 = a.get(j);
		
		for( ; j<a.size() ; j++) {
			if( a.get(j) > max2 ) {
				max1 = max2;
			    max2 = a.get(j);
			} else if(a.get(j) > max1) {
				max1 = a.get(j);
			}
		}
		
		return new Pair(max1,max2);
	}
	
	public static Pair findTwoLargestWithOrder(ArrayList<Integer> a, int j) {
		// TODO Auto-generated method stub
		if(j < 0 || j > (a.size()-1))
			return null;
		
		int max1 , max2 ; 
		max1 = max2 = a.get(j);
		
		for( ; j<a.size() ; j++) {
			if( a.get(j) > max2  ) {
				max1 = max2;
			    max2 = a.get(j);
			} 
		}
		
		return new Pair(max1,max2);
	}
	
	public static class Pair{
    	public int i,j;
    	public Pair(int i,int j){
    		this.i= i;
    		this.j= j;
    	}
    	
    	public String toString() {
    		return this.i + " " + this.j;
    	}
    }

	public static void swap(int[][] points, int i, int j) {
		int[] t   = points[i];
		points[i] = points[j];
		points[j] = t;
	}
	
}
