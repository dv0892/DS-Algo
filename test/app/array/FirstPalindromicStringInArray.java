package test.app.array;

public class FirstPalindromicStringInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FirstPalindromicStringInArray().firstPalindrome( new String[] {"abc","car","ada","racecar","cool"} ) );
	}
	
	public String firstPalindrome(String[] words) {
        
        for(String w : words){
            if(isPalindrome(w))
                return w;
        }       
        
        return "";
    }
    
    private boolean isPalindrome(String str){
        int l = 0, r = str.length()-1;
        while(l < r){
            if(str.charAt(l) != str.charAt(r))
                return false;
            
            l++; r--;
        }
        
        return true;
    }

}
