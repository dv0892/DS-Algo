package test.app.string;

public class IsSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IsSubSequence().isSubsequence("X", "ahbbgcd",8));
	}
	
	public boolean isSubsequence(String s, String t) {
	    
        int l=0,r=s.length()-1;
        int st=0,end=t.length()-1;
        while(l < r) {

            while(st  < end && s.charAt(l) != t.charAt(st))
                    st++;
                
            while(end > st  && s.charAt(r) != t.charAt(end))
                    end--;
                
            if((st+1) > end)
                return false;
            else{
               st++;
               end--;
            }
            
            l++;r--;
        
        }
        
       if(l == r) {
        while(st  <= end ){
            if(s.charAt(l) == t.charAt(st))
                return true;
            
            st++;
        }
        
        return false;
        
       } else 
    	   return true;
        
    }

	
	public boolean isSubsequence(String s, String t,int x) {
        int ptr1 = 0;
        int ptr2 = 0;
        
        while(ptr1 < s.length() && ptr2 < t.length()){
            if(s.charAt(ptr1) != t.charAt(ptr2)){
                ptr2++;
            }else{
                ptr1++;
                ptr2++;
            }
        }
        
        return ptr1 == s.length() && ptr2 <= t.length();
    }
}
