package test.app.string;

public class RemovePalindromicSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removePalindromeSub(String s) {
        int i=0,j=s.length()-1;
     
     while(i<j){
         if(s.charAt(i)==s.charAt(j)){
             i++;j--;
         } else
             return 2;
     }
     
     return 1;
    }

}
