package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(  new RestoreIPAddresses().restoreIpAddresses("00000"));
	}
	
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(s,res,0,1,"");
        return res;        
    }

    public void restoreIpAddresses ( String s , List<String> res , int i , int part , String ip){
        if( part > 4 ){
            if( i >= s.length() )
                res.add(ip);
            
            return;
        }

       
        if( (i+1) <= s.length() ) 
        		restoreIpAddresses ( s , res , i+1, part+1 , ip + (part == 1 ? "" : ".") + s.substring(i,i+1) );

        if( (i+2) <= s.length() && isValidInt(s.substring(i,i+2)) )
            restoreIpAddresses ( s , res , i+2, part+1 , ip + (part == 1 ? "" : ".") + s.substring(i,i+2) );

        if( (i+3) <= s.length() && isValidInt(s.substring(i,i+3)) )
            restoreIpAddresses ( s , res , i+3, part+1 , ip + (part == 1 ? "" : ".") + s.substring(i,i+3) );
    }

    public boolean isValidInt( String n ){
        if( n.length() == 2 && n.charAt(0) == '0'){
            return false;
        } else if( n.length() == 3  )   {
            if(  (n.charAt(0) == '0') )
                return false;
            
            return Integer.parseInt(n) <= 255;
        }

        return true;
    }

}
