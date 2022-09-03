package test.app.greedy;

public class EqualSumArraysWithMinimumNoOfOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new EqualSumArraysWithMinimumNoOfOperations().minOperations(
				/*new int[] {1,2,3,4,5,6} , new int[] {1,1,2,2,2,2}*/
				/*new int[] {6,6} , new int[] {1}*/
				/*new int[] { 2,1,6,4,6,2,1,5,2,3,1,4,5,1,1,1,2,5,1,5,4,5,2,5,6,2,4,3,5,1,5,5,1,6,1,1,2,6,6,2,4,2,4,2,6,1,1,5,4,5,6,2,1,1,6,4,3,4,5,2,3,3,3,6,1,6,3,2,4,6,2,2,2,1,3,6,3,1,6,4,4,2,3,2,1,6,2,2,4,6,4,1,6,5,4,2,5,1,1,1,5,5,3,5,4,1,1,4,6,1,5,2,2,2,6,4,1,5,4,6,3,1,5,2,5,6,1,5 },
				new int[] {	6,6,3,3,1,3,1,3,5,2,2,4,2,5,4,1,6,3} */
				
				new int[] { 5,6,4,3,1,2},
				new int[] {6,3,3,1,4,5,3,4,1,3,4}
				));
	}
	
	public int minOperations(int[] nums1, int[] nums2) {
        //create hash tables
        int[] hash1 = new int[7];
        int[] hash2 = new int[7];
        
        int sum1 = 0, sum2 = 0;
        
        for( int n : nums1 ) {
        	hash1[n]++;
        	sum1 += n;
        }
        
        for( int n : nums2 ) {
        	hash2[n]++;
        	sum2 += n;
        }
        
        int count = getMinNoOfOperations_Greedy( hash1, hash2 , sum1 , sum2 );
        
        return count;
    }
	
	

	
	private int getMinNoOfOperations_Greedy(int[] hash1, int[] hash2, int sum1, int sum2) {
		// TODO Auto-generated method stub
		int diff = sum1 - sum2;
		
		if(  diff == 0 ) 
			return 0;
		
		if( diff > 0 ) {
			
			int decreasePoss = decreasePossible(hash1, diff) ;
			int increasePoss = increasePossible(hash2, diff) ;
			
			if ( decreasePoss == 0 && increasePoss == 0)
				return -1;
			
			if ( increasePoss > decreasePoss ) {
				increase(hash2, sum2, diff);
				sum2+=increasePoss;
			} else {
				decrease(hash1, sum1, diff);
				sum1-=increasePoss;
			}
			
		} else {
			diff = Math.abs(diff);
			int decreasePoss = decreasePossible(hash2, diff) ;
			int increasePoss = increasePossible(hash1, diff) ;
			
			if ( decreasePoss == 0 && increasePoss == 0)
				return -1;
			
			if ( increasePoss > decreasePoss ) {
				increase(hash1, sum2, diff);
				sum2-=increasePoss;
			} else {
				decrease(hash2, sum1, diff);
				sum1+=decreasePoss;
			}
		 
		}
		
		int count = getMinNoOfOperations_Greedy(hash1, hash2, sum1, sum2);
		
	    return count == -1 ? count : 1 + count; 
	}
	
	
	private int decreasePossible( int[] hash, int diff ) {
		diff = Math.min(5, diff);
		
		int val = 6 , min_diff = 5;
		while( val > 1  && hash[val] == 0 ) {
			val--; --min_diff;
		}
		
		if( val == 1 )
			return 0;

		
		return  Math.min(diff, min_diff);
	}
	
	private int increasePossible( int[] hash, int diff ) {
		diff = Math.min(5, diff);
		
		int val = 1, min_diff = 5;
		
		while( val < 6  && hash[val] == 0 ) {
			val++; --min_diff;
		}
		if( val == 6 )
			return 0;
		
		return Math.min(diff, min_diff);
	}
	
	private int getMinNoOfOperations(int[] hash1, int[] hash2, int sum1, int sum2) {
		// TODO Auto-generated method stub
		int diff = sum1 - sum2;
		
		if(  diff == 0 ) 
			return 0;
		
		int minCount  = -1;
		int[] h1Clone = hash1.clone();
		int[] h2Clone = hash2.clone();
		
		
		if( diff > 0 ) {
			
			int decreasedSum = decrease(hash1, sum1, diff) ;
			
			int count1 = -1 ;
			if ( (decreasedSum != sum1 ) ) {
				count1 = getMinNoOfOperations( hash1, hash2 , decreasedSum , sum2 );
			} 
			int increasedSum = increase(h2Clone, sum2, diff) ;
		
			int count2 = -1;
			if ( (increasedSum != sum2 ) ) 
				count2 = getMinNoOfOperations( h1Clone, h2Clone , sum1 , increasedSum );
			
			
			if( count1 == -1 && count2 == -1 ) {
				return -1 ;
			} else if( count1 == -1 ) {
				minCount = 1 + count2;
			} else if ( count2 == -1 )
				minCount = 1 + count1;
			else			
			   minCount = 1 + Math.min(count1, count2);
		} else {
			// decrease num2 & increase num1 
			diff = Math.abs(diff);
			
			int decreasedSum = decrease(hash2, sum2, diff) ;
			
			int count2 = -1;
			if ( (decreasedSum != sum2) ) 
				count2 = getMinNoOfOperations(hash1, hash2, sum1, decreasedSum) ;
			
			int increasedSum = increase(h1Clone, sum1, diff) ;
			
			int count1 = -1;
			if ( (increasedSum != sum1 ) ) 
				count1 = getMinNoOfOperations( h1Clone, h2Clone , increasedSum , sum2 );
			
			if( count1 == -1 && count2 == -1 ) {
				return -1 ;
			} else if( count1 == -1 ) {
				minCount = 1 + count2;
			} else if ( count2 == -1 )
				minCount = 1 + count1;
			else			
			   minCount = 1 + Math.min(count1, count2);
		 
		}
		
		return minCount;
	}
	
	
	
	
	
	private int decrease( int[] hash, int sum, int diff ) {
		diff = Math.min(5, diff);
		
		int val = 6 , min_diff = 5;
		while( val > 1  && hash[val] == 0 ) {
			val--; --min_diff;
		}
		
		if( val == 1 )
			return sum;

		diff = Math.min(diff, min_diff);
		
		hash[val]--;
		hash[val-diff]++;
		
		sum -= diff;
		
		return sum;
	}
	
	private int increase( int[] hash, int sum, int diff ) {
		diff = Math.min(5, diff);
		
		int val = 1, min_diff = 5;
		
		while( val < 6  && hash[val] == 0 ) {
			val++; --min_diff;
		}
		if( val == 6 )
			return sum;
		
		diff = Math.min(diff, min_diff);
		
		hash[val]--;
		hash[val+diff]++;
		
		sum += diff;
		
		return sum;
	}

}
