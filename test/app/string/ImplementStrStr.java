package test.app.string;

public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ImplementStrStr().strStr("hello", "ll"));
	}
	
	public int strStr(String haystack, String needle) {
        
        if(needle==null || needle.length()==0)
            return 0;
        
        for(int i=0;i<haystack.length();i++){
            
            if( ( haystack.length()-i ) < needle.length() ) 
                break;
        
            
            if( checkIfEqual(haystack,i,needle) )
                return i;
        }
        
        return -1;
        
    }
    
    public boolean checkIfEqual( String haystack,int i, String needle){
        
        int j = 0;
        while(j<needle.length()){
            if( (needle.charAt(j++) != haystack.charAt(i++)) )
             return false;
        }
        
        return true;
    }

}
