package test.app.math;

public class TheNumberOfFullRoundsYouHavePlayed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new TheNumberOfFullRoundsYouHavePlayed().numberOfRounds1("00:47","00:57"));
	}
	
	public int numberOfRounds1(String loginTime, String logoutTime) {
        String[] t1 = loginTime.split(":");
        int h1 = Integer.parseInt(t1[0]);
        int m1 = Integer.parseInt(t1[1]);
        
        t1 = logoutTime.split(":");
        int h2 = Integer.parseInt(t1[0]);
        int m2 = Integer.parseInt(t1[1]);
        
        if(h1 == h2 && m2 - m1 < 15 && m2 - m1 >= 0)
            return 0;
        if(m1 > 0 && m1 <= 14)
        	m1 = 15;
        else if(m1 > 15 && m1 < 30)
        	m1 = 30;
        else if(m1 > 30 && m1 < 45)
        	m1 = 45;
        else if(m1 > 45 && m1 <= 59) {
        	m1 = 0;
        	h1++;
        }
        
        if(m2 > 0 && m2 <= 14)
        	m2 = 0;
        else if(m2 > 15 && m2 < 30)
        	m2 = 15;
        else if(m2 > 30 && m2 < 45)
        	m2 = 30;
        else if(m2 > 45 && m2 <= 59) {
        	m2 = 45;
        }
        
        int x = h1 * 60 + m1;
        int y = h2 * 60 + m2;
        
        if(y >= x)
        	return (y - x) / 15;
        else
        	return (((24 * 60) - x) + y) / 15;
    }
	
	public int numberOfRounds(String loginTime, String logoutTime) {
        int sh = Integer.parseInt(loginTime.substring(0,loginTime.indexOf(':')));
        int sm = Integer.parseInt(loginTime.substring(loginTime.indexOf(':')+1));
        
        
        int eh = Integer.parseInt(logoutTime.substring(0,logoutTime.indexOf(':')));
        int em = Integer.parseInt(logoutTime.substring(logoutTime.indexOf(':')+1));
        
        if ( sm % 15 != 0 ) {
        	int rem = sm % 15;
        	sm =  sm + 15 - rem;
        	if ( sm == 60 ) {
        		sm = 0; sh=(sh+1)%24;
        	}
        }
        
        
        if ( em % 15 != 0 ) {
        	int rem = sm % 15;
        	sm =  sm - rem;
        }
        
        int x = sh * 60 + sm;
        int y = eh * 60 + em;
        		
        if ( ( y - x) >= 0  ) {
        	return (y-x)/15;
        } else {
        	return ( ( ( 24*60 - x ) + y  ) / 15 );
        }
	
	}
	
}
