package test.app.string;

public class ReversePrefixOfWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReversePrefixOfWord().reversePrefix("abbbbz", 'z'));
	}
	
	
public String reversePrefix(String word, char ch) {
        
        int i=0;
        for(;i<word.length();i++){
            if(ch==word.charAt(i))
                break;
        }
        
        if(i==word.length())
            return word;
        
        
        char[] arr = word.toCharArray();
        int h=0;
        while(h<i){
         swap(arr,h++,i--);
        }
        
        return new String(arr);
    }
    
    public static void swap(char[] arr, int i, int j){
        char t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

}
