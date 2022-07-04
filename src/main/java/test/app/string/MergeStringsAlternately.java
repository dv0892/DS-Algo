package test.app.string;

public class MergeStringsAlternately {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public String mergeAlternately(String word1, String word2) {
	        
	        char[] res = new char[word1.length()+word2.length()];
	        
	        int p1=0,p2=0,i=0;
	        
	        while(p1<word1.length() && p2<word2.length()){
	            res[i++] = word1.charAt(p1++);
	            res[i++] = word2.charAt(p2++);
	        }
	        
	        while(p1<word1.length()){
	            res[i++] = word1.charAt(p1++);
	        }
	        
	        while(p2<word2.length()){
	            res[i++] = word2.charAt(p2++);
	        }
	            
	        return new String(res);
	        
	        
	    }

}
