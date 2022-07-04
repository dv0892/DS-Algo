package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new MinimumAbsoluteDifference().minimumAbsDifference( new int[]{ 1,4,7,8 }));
		
	}
	
	 public List<List<Integer>> minimumAbsDifference(int[] arr) {
	        Arrays.sort(arr);
	        
	        List<List<Integer>> res = new ArrayList<>();
	        for(int i=0;i<arr.length-1;i++){
	            if(res.size() == 0){
	                res.add( new ArrayList<Integer>( Arrays.asList(arr[i],arr[i+1]) )); 
	            } else {
	               List<Integer> list = res.get(res.size()-1);
	               if( (arr[i+1] - arr[i]) < list.get(1) - list.get(0) ) {
	            	   res.clear();
	            	   res.add( new ArrayList<Integer>( Arrays.asList(arr[i],arr[i+1]) )); 
	            	   
	               } else if (   (arr[i+1] - arr[i]) == ( list.get(1) - list.get(0) ) ){
	            	   res.add( new ArrayList<Integer>( Arrays.asList(arr[i],arr[i+1]) )); 
	               }
	            }
	        }
	        
	        return res;
	    }

}
