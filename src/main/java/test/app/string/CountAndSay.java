package test.app.string;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String countAndSay(int n) {
        
        StringBuilder ans = new StringBuilder("1");
        for( int i=1;i<n;i++) {
            
            String last = ans.toString();
            int    len  = last.length();
            
            ans.delete(0,ans.length());
            
            for(int j=0;j<len;) {
                
                int ct = j;
                while(++j<len && last.charAt(j-1)==last.charAt(j));
                
                ans.append(j-ct).append(last.charAt(j-1));
            }
        }
        
        return ans.toString();
    }

}
