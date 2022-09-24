package test.app.string;

public class ReverseWordsInAStringIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseWords(String s) {
        String[] wordArr = s.split(" ");
        
        StringBuilder ans = new StringBuilder();
        reverseWords( wordArr, 0, ans );
        
        return ans.toString();
    }
    
    public void reverseWords(String[] wordArr , int w , StringBuilder sb ) {
        if( w == wordArr.length )
            return ;
        
        char[] word =  wordArr[w].toCharArray();
        reverseString( word , 0, word.length-1) ;
        
        reverseWords(wordArr, w+1, sb.length() == 0 ? sb.append( new String(word) ) : sb.append(" ").append( new String(word) ) );
    }
    
    public void reverseString(char[] s,int l, int r) {
        if( l < r ) {
            swap(s,l,r);
            reverseString(s,l+1,r-1);
        }
        
    }
    
                     
    public void swap(char[] arr, int i, int j){
        int t =arr[i];
        arr[i]=arr[j];
        arr[j]=(char)t;
    }
}
