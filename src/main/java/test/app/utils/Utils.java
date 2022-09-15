package test.app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;


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
	
	public static int[][] readLeetInput( String file ) {
		
		int[][] result = new int[1][];
		
		
		try (Scanner s = new Scanner(new File(file))) {
			String data = s.nextLine();
			String[] rows = data.split("}");
			result = new int[rows.length][];
			
			int row=0;
			for ( String r : rows ) {
				String[] cols = (r.substring(r.lastIndexOf("{")+1)).split(",");
				int[] arr = new int[cols.length];int i=0;
				for( String val : cols ) {
					arr[i++] = Integer.parseInt(val);
				}
				result[row++] = arr;
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return result;
		
	}
	
	public static int[] readLeetInput1( String file ) {
		
		int[] arr = new int[0];
		try (Scanner s = new Scanner(new File(file))) {
			String data = s.nextLine();
			String[] rows = data.split("]");
			
			    String r = rows[0];
				String[] cols = (r.substring(r.indexOf("[")+1)).split(",");
				arr = new int[cols.length];int i=0;
				for( String val : cols ) {
					arr[i++] = Integer.parseInt(val);
				}
				
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return arr;
		
	}
	
	
}
