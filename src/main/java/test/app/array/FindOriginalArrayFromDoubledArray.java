package test.app.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import test.app.utils.Utils;

public class FindOriginalArrayFromDoubledArray {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		int[] changed = Utils.readLeetInput1("leetinput");
		 
		System.out.println(Arrays.toString( new FindOriginalArrayFromDoubledArray().findOriginalArrayClean_Cleaned(changed) ));
		
		
	}
	
	
public int[] findOriginalArrayClean_Cleaned(int[] changed) throws FileNotFoundException {
        
        int n = changed.length ;
        if( changed.length % 2 == 1 )
            return new int[0];
        /* We are sorting to eliminate the case : 
         * When we are checking element using frequencies ,
         * All the halfs of element should be checked earlier before their double is checked.
        
        */
        Arrays.sort(changed);
               
        int[] original = new int[n/2];
        Map<Integer,Integer> map = new HashMap<>();
        
        for( int i=0;i<n;i++){
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1 );
        }
        
        
        for( int i=0,k=0;i<n;i++){
        	
        	if(  changed[i] == 0 && map.getOrDefault(0,0) > 1 ) {
        		map.put(0, map.get(changed[i])-2);
        		map.remove(0, 0);
        		
        		original[k++] = changed[i];
        		
        	} else if ( changed[i] != 0 && map.getOrDefault(changed[i],0) > 0 && map.getOrDefault(changed[i]*2,0) > 0 ) {
        		map.put(changed[i], map.get(changed[i])-1);
        		map.remove(changed[i], 0);
        		
        		map.put(changed[i]*2, map.get(changed[i]*2)-1);
        		map.remove(changed[i]*2, 0);
        		
        		original[k++] = changed[i];
        	}
        }
        
        
        /*for( int i=0,k=0;i<n;i++){
            int half = changed[i]/2;
			if( ( ( changed[i] & 1) == 0) && map.getOrDefault(half, 0) > 0 ) {
            	map.put(half, map.get(half)-1);
            	map.remove(half, 0);
            	original[k++] = half;
            } else
            	map.put(changed[i], map.getOrDefault(changed[i], 0) + 1 );
        }*/
        
        return map.size() == 0 ? original : new int[0] ;
    }
	
public int[] findOriginalArrayClean(int[] changed) throws FileNotFoundException {
        
        int n = changed.length ;
        if( n%2 == 1 )
            return new int[0];
        
        Arrays.sort(changed);
        System.setOut( new PrintStream("leetdebug") );
        System.out.print( Arrays.toString(changed));
        
        int i=-1,k=0;
        while( i < (n-1) && changed[++i] == 0 )
        	
        if( i == (n-1) )
        	 return new int[n/2];;
        
        if( (i-1) % 2 == 0 )
        	 return  new int[0] ;
        
        k = ( i/2 );
        
        int[] original = new int[n/2];
        Map<Integer,Integer> map = new HashMap<>();
        
        for( ;i<n;i++){
            int half = changed[i]/2;
			if( ( ( changed[i] & 1) == 0) && map.getOrDefault(half, 0) > 0 ) {
            	map.put(half, map.get(half)-1);
            	map.remove(half, 0);
            	original[k++] = half;
            } else
            	map.put(changed[i], map.getOrDefault(changed[i], 0) + 1 );
        }
        
        
        System.setOut( new PrintStream("leetout") );
        
        System.out.print( Arrays.toString(original));
        
        return map.size() == 0 ? original : new int[0] ;
    }
	
    public int[] findOriginalArray(int[] changed) throws FileNotFoundException {
        
        int n = changed.length ;
        
        if( n%2 == 1 )
            return new int[0];
        
        Arrays.sort(changed);
        
        
        
        System.setOut( new PrintStream("leetdebug") );
        
        System.out.print( Arrays.toString(changed));
        
        boolean[] covered = new boolean[n];
        int[] original = new int[n/2];
        for( int i=0,k=0;i<n;i++){
            if( !covered[i] ){
              
              int j = i+1;
              while( j < n &&  ( changed[i]*2 >= changed[j] ) ){
                  if( !covered[j] && changed[i]*2 == changed[j] ){
                      covered[i] = covered[j] = true;
                      original[k++] = changed[i];
                      break;
                  }
                  j++;
              }
                
              if( !covered[i] )
                  return new int[0];
                
            }
        }
        
        
        System.setOut( new PrintStream("leetout") );
        
        System.out.print( Arrays.toString(original));
        
        return original;
    }

}
