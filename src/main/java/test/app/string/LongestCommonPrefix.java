package test.app.string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String longestCommonPrefix(String[] strs) {
        if ( strs.length == 1 )
            return strs[0];
        
        String prefix = prefix(strs[0] , strs[1] );
        
        for( int i=2 ; i<strs.length;i++){
            prefix = prefix( prefix, strs[i] );
        }
        
        return prefix;
    }
    
    public String prefix ( String s1 , String s2 ){
        int i=0,len = Math.min( s1.length() , s2.length() );
        
        while( i < len && s1.charAt(i) == s2.charAt(i) )
            i++;
        
        return s1.substring(0,i);
    }

}
