package test.app.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import test.app.array.PickFromBothSides;
import test.app.utils.Utils;

public class MaximumSumTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(3603, 24351, 10292, 30837, 9375,
														     11021, 4597 , 24022, 27349, 23200, 
														     19669, 24485, 8282 , 4735 , 54, 
														     2000 , 26419, 27939, 6901 , 3789, 
														     18128, 468  , 3729 , 14894, 24649,
														     22484, 17808, 2422 , 14311, 6618, 
														     22814));
		
		
		//ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(9,3,5,1,2,7,8));
		
		//System.out.println(Utils.findTwoLargest(A, 1));
		System.out.print(new MaximumSumTriplet().solve(A));
	}
	
	public int solve(ArrayList<Integer> a) {

        /*int max_Sum = 0;
        for(int i=0;i<A.size()-2;i++){
        	 
        	  This is a brute force approach 
        	  which will fail with larger inputs.
        	  
        	  for(int j=i+1;j<A.size();j++) {
                   if(A.get(j) <= A.get(i))
                    	continue;

	               for(int k=j+1;k<A.size();k++) {
	                    if(A.get(k) <= A.get(j))
	                        continue;    
	
	                    int sum = A.get(i) + A.get(j) + A.get(k);
	                    
	                    System.out.println( A.get(i) + " " + A.get(j) + " " +A.get(k) + " = " + sum);
	
	                    if( max_Sum < sum ) max_Sum = sum;
	               }
               
               }  
               
            	
                OR
                *
                * Find the two largest elements in range j , A.size()-1	
                *  
                * This approach is WRONG, it should be improvised to contain 
                * not  the two largest elements. Lets suppose pivot = a[i];
                * But two element a[j]  and a[k] , which would lie in the range
                * i+1 to  A.size()-1. And satisfy the below conditions :
                * 
                * --->  j < k
                * --->  PIVOT(i.e. a[i]) < a[j]  < a[k]
                * --->  a[j]  and a[k] should be selected such that they bring max sum possible in this range.
                *
                *  
                
            	
            	Utils.Pair pair = Utils.findTwoLargestWithOrder(A,i+1);
            	
            	int sum = A.get(i) + pair.i +  pair.j;
            	
            	System.out.println( ( A.get(i) < pair.i && pair.i < pair.j ) + " " + A.get(i) + " " + pair.i + " " +pair.j + " = " + sum);
            	
            	if ( A.get(i) < pair.i && pair.i < pair.j) {
            		
            		if( max_Sum <  sum )
            			max_Sum = sum;
            	}
            	
            	TreeSet<Integer> mm ;
        }*/
        
        
        int n=a.size(),i,ans;
        int max[]=new int[n],small[]=new int[n];
        max[n-1]=0;
        
        for(i=n-2;i>=0;i--)
            max[i]=Math.max(max[i+1],a.get(i+1));

        TreeSet<Integer> mm = new TreeSet<>();
        small[0]=0;

        for(i=1;i<n;i++)
        {
            mm.add(a.get(i-1));
            Integer p=mm.lower(a.get(i));
            
            if(p==null)
                small[i]=0;
            else
                small[i]=p;
        }

        ans=0;
        for(i=0;i<n;i++) {
        	
            if(small[i]==0||max[i]<=a.get(i))
                continue;
            ans=Math.max(ans,a.get(i)+max[i]+small[i]);
            // System.out.println(a.get(i)+" "+max[i]+" "+small[i]);
        }

        return ans;
    }
}
