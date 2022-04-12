package test.app.string;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void reverseString(char[] s) {
        
        int l=0,r=s.length-1;
        while( l < r ) {
            swap(s,l++,r--);
        }
       
    }
    
    public void reverseString(char[] s,int l, int r) {
        if( l < r ) {
            swap(s,l,r);
            reverseString(s,l+1,r-1);
        }
    }
    
    public static void swap(char[] arr, int i, int j){
        char t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

}
