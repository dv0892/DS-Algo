package test.app.array;

public class BackSpaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean backspaceCompare(String s, String t) {

        int hashCnt1=0, hashCnt2=0;
        int i=s.length()-1,j=t.length()-1;
        
        while(true){
        
          while(true){
            
            if( i < 0 )
                break;
             
            if(s.charAt(i) == '#'){
                hashCnt1++;i--;
            } else {
                if(hashCnt1 == 0)
                    break;
                else{
                    hashCnt1--;i--;
                }
            }
          }
            
          while(true){
            if(j < 0)
                break;
              
            if(t.charAt(j) == '#'){
                hashCnt2++;j--;
            } else{
                if(hashCnt2 == 0)
                    break;
                else{
                    hashCnt2--;j--;
                }        
            }
          }
          
          if(i<0 && j<0)
              break;
            
          if(i<0 || j<0)
              return false;
            
          if( t.charAt(j) != s.charAt(i) )
              return false;
            
            
            i--;j--;
        }
        
        return true;
    }

}
