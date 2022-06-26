package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println( new BinaryWatch().readBinaryWatch(9) );
	}
	
	public List<String> readBinaryWatch(int turnedOn) {
        return readBinaryWatch(turnedOn, "" ,true);
    }
    
    public List<String> readBinaryWatch( int turnedOn, String time , boolean isHour ){
        
        if( turnedOn < 0 ){
           
              if( time.isEmpty() ) 
              time = getString(0,true) + getString(0,false);   
            
            List<String> ans = new ArrayList<>();
            ans.add(time);
            
            return ans;
                
        }
        
        int min = isHour ? 0 : turnedOn;
        int max = turnedOn;
        
        List<String> ans = new ArrayList<>();
        
        while( min <= max ){
            int choice = min++;
            int clockSt = 0 ; 
            int clockEnd = isHour ? 12 : 60;
            while ( clockSt < clockEnd ){
                if( choice == Integer.bitCount(clockSt) ){
                    String newtime = getString(clockSt , isHour);
                    ans.addAll( readBinaryWatch( isHour ? (turnedOn-choice) : -1 , time + newtime, !isHour ) );
                }
                clockSt++;
            }
        }
        
        return ans;
    }
    
    public String getString( int time , boolean isHour ){
        return isHour ? time+":" : ( time < 10 ? "0"+time : ""+time);
    }

}
