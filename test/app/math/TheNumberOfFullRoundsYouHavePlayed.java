package test.app.math;

public class TheNumberOfFullRoundsYouHavePlayed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new TheNumberOfFullRoundsYouHavePlayed().numberOfRounds("21:30", "03:00"));
	}
	
	public int numberOfRounds(String loginTime, String logoutTime) {
        
		int sh = Integer.parseInt(loginTime.substring(0,loginTime.indexOf(':')));
        int eh = Integer.parseInt(logoutTime.substring(0,logoutTime.indexOf(':')));
        
        if ( sh < eh ) {
        	return numberOfRounds1(loginTime,logoutTime);
        } else {
        	return numberOfRounds1(loginTime,"00:00") + numberOfRounds1("00:00",logoutTime) - 1;
        }
        
        
    }
	
	public int numberOfRounds1(String loginTime, String logoutTime) {
        int sh = Integer.parseInt(loginTime.substring(0,loginTime.indexOf(':')));
        int sm = Integer.parseInt(loginTime.substring(loginTime.indexOf(':')+1));
        
        
        int eh = Integer.parseInt(logoutTime.substring(0,logoutTime.indexOf(':')));
        int em = Integer.parseInt(logoutTime.substring(logoutTime.indexOf(':')+1));
        
        int count = 0;
        if ( sm % 15 != 0 ) {
        	int rem = sm % 15;
        	sm =  sm + 15 - rem;
        	if ( sm == 60 ) {
        		sm = 0; sh=(sh+1)%12;
        	}
        }
        
        while ( canExecute(sh,sm,eh,em) ) {
        	count++;
        	sm += 15;
        	if ( sm == 60 ) {
        		sm = 0; sh=(sh+1)%12;
        	}
        }
        
        return count;
    }
	
	public boolean canExecute ( int sh , int sm , int eh , int em ) {
		
		sm += 15;
    	if ( sm == 60 ) {
    		sm = 0; sh=(sh+1)%12;
    	}
		
		return isTimeLess(sh,sm,eh,em) ;
	}
	
	public boolean isTimeLess ( int sh , int sm , int eh , int em ) {
		
		return sh < eh ? true : ( sh > eh ? false : ( sm <= em ? true : false) ) ;
	}
}
