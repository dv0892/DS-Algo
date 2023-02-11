package test.app.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NamingACompany {

	public static void main(String[] args) {
		String[] ideas  = {"coffee","donuts","time","toffee"};
		
		System.out.println( new NamingACompany().distinctNames_Ver1(ideas));
	}
	
	public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);

        int missing = -1;
        for( int i=0;i<A.length;i++){
            if( A[i] <= 0 )
                continue;

            if( (i-1)>=0){
                if( A[i-1] <= 0 ){
                    if( A[i] > 1 ) {
                        missing = 1; 
                        break; 
                    }
                } else if( (A[i] - A[i-1]) > 1){
                    missing = A[i-1]+1;
                    break;
                }
            }
        }

        return missing;
    }
	
	public long distinctNames_Ver1(String[] ideas) {
        long count = 0;
        int len = ideas.length;
        Map<Character,Set<String>> map = new HashMap<>();
        
        for( int i=0;i<len;i++){
             map.computeIfAbsent(ideas[i].charAt(0),x -> new HashSet<>()).add(ideas[i].substring(1));
        }

        for( int c1=97;c1<=122;c1++){
            for( int c2=c1+1;c2<=122;c2++){
                Set<String> s1 = map.getOrDefault((char)c1,new HashSet<>());
                Set<String> s2 = map.getOrDefault((char)c2,new HashSet<>());

                int l1 = s1.size(), l2 = s2.size();
                for( String s : s1 ){
                    if( s2.contains(s) ){
                        l1--;l2--;
                    }
                }

                count += ( 2*l1*l2);

            }
        }

        System.out.println(map);
        
        return count;
    }
	
	public long distinctNames(String[] ideas) {
        long count = 0;
        int len = ideas.length;
        Set<String> set = new HashSet<>();
        
        for( int i=0;i<len;i++){
             set.add(ideas[i]);
        }

        StringBuilder firstName = new StringBuilder();
        StringBuilder secName = new StringBuilder();
        for( int i=0;i<len;i++){
        	firstName.delete(0, firstName.length());
        	firstName.append(ideas[i]);
        	char ch = ideas[i].charAt(0);
            for( int j=i+1;j<len;j++){
                if( ch == ideas[j].charAt(0) )
                    continue;
                firstName.setCharAt(0, ideas[j].charAt(0));
                
                secName.delete(0, secName.length());
                secName.append(ideas[j]);
                secName.setCharAt(0, ch);
                
                
                if( set.contains(firstName.toString()) || set.contains(secName.toString()) )
                	continue;
                
                count+=2;
            }
        }
        
        return count;
    }

}
