package test.app.greedy;

public class LemonadeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bills = {5,5,20,5,5,10,5,10,5,20};
		
		System.out.println( new LemonadeChange().lemonadeChange(bills) );
	}
	
	public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill : bills){
            if( bill == 5 ) { 
            	five++; 
            }else if( bill == 10) { 
            	ten++; 
            
            	if( five == 0 )
            		return false;
            
            	five--;
            } else {
            	if( five < 1 || ( ten == 0 && five < 3 )  )
                    return false;
            	
            	five--; 
            	
            	if( ten == 0 )
            		five -= 2;
            	else 
            		ten--;
            }
        }
        
        return true;
    }

}
