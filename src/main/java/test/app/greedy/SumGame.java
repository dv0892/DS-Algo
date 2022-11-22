package test.app.greedy;

public class SumGame {

	public static void main(String[] args) {
		System.out.println( new SumGame().sumGameClean("?3295???"));
	}
	
	public boolean sumGameClean(String num) { 
		
		 int len = num.length(),leftSum=0,rightSum=0,leftMoves=0,rightMoves=0;
	        
			for(int i=0; i < len;i++){
				if ( i < len/2 ){
					if( num.charAt(i) == '?' ){
						leftMoves++;
					} else{
						leftSum += (num.charAt(i)-'0');
					}
				} else {
					if( num.charAt(i) == '?' ){
						rightMoves++;
					} else{
						rightSum += (num.charAt(i)-'0');
					}
				}
			}
			
			if( leftMoves == rightMoves ) {
				return leftSum == rightSum ? false : true;
			}
			
			// Alice always wins
			if( (leftMoves + rightMoves)%2 == 1 ) {
				return true;
			}
			
			if( leftMoves > rightMoves ) {
				leftMoves -= rightMoves; 
				if( leftSum > rightSum ) return true; // Alice Surely wins becasue the left side is already heavier and we can't make it lighter
				else if( 9*(leftMoves/2) == (rightSum-leftSum) ) return false; // bob surely wins only if diff is multiple of 9 of no of bob's question marks
			} else {
				rightMoves -= leftMoves;
				if( rightSum > leftSum ) return true ;// Alice Surely wins becasue the right side is already heavier and we can't make it lighter
				else if( 9*(rightMoves/2) == (leftSum-rightSum) ) return false; // bob surely wins only if diff is multiple of 9 of no of bob's question marks
			}
			
			return true;
	}

	    public boolean sumGame(String num) {
	        int len = num.length(),leftSum=0,rightSum=0,leftMoves=0,rightMoves=0;
	        
			for(int i=0; i < len;i++){
				if ( i < len/2 ){
					if( num.charAt(i) == '?' ){
						leftMoves++;
					} else{
						leftSum += (num.charAt(i)-'0');
					}
				} else {
					if( num.charAt(i) == '?' ){
						rightMoves++;
					} else{
						rightSum += (num.charAt(i)-'0');
					}
				}
			}
	        
	        // Start playing
	        boolean alicesTurn = true ;
	        int largerSum = leftSum , smallerSum = rightSum;
            int largMoves = leftMoves , smallMoves = rightMoves;
            
            if( rightSum > leftSum ){
                largerSum = rightSum;
                smallerSum = leftSum;

                largMoves = rightMoves ;
                smallMoves = leftMoves ;
            }
            
	        while( largMoves>0 || smallMoves>0 ){

				if( largerSum == smallerSum ) { 
					if( largMoves > 0 ){
						largerSum += ( alicesTurn ? 9 : 0);
						largMoves--;
					} else{
						smallerSum += ( alicesTurn ? 9 : 0);
						smallMoves--;
					}
					alicesTurn = !alicesTurn;
					continue;
				}

				int diff = largerSum - smallerSum;

	            // Alice turn
	            if( alicesTurn ){

					// Alice wins
	                if ( (largMoves == 0 && diff<=8) || smallMoves == 0 || largMoves == 0)
						return true;

					if( rightSum > leftSum ){
						rightSum += 9;
						rightMoves--;
					} else{
						leftSum += 9;
						leftMoves--;
					}
				
							
					
	            }  // Bob turn 
	            else {
					
					// Alice wins
	                if ( smallMoves == 0 )
						return true; 
					
					// bob wins
					if( (largMoves == 0 && diff<=9) || diff<=9)
						return false ;
					
					if( rightSum < leftSum ){
					    rightSum += Math.min( diff - 9 , 9 );
						rightMoves--;
					} else{
						leftSum += Math.min( diff - 9 , 9 );;
						leftMoves--;
					}

	            }

	            alicesTurn = !alicesTurn;
	        }

	        return leftSum == rightSum ? false : true;
	    }

	

}
