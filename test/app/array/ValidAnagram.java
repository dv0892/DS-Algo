package test.app.array;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new ValidAnagram().isAnagram("abc", "cab"));
	}
	
	public boolean isAnagram(String s, String t) {
        
        int[] count = new int[26];
            
        for( char c : s.toCharArray() ){
            count[(c+0)-97]++;
        }
        
        for( char c : t.toCharArray() ){
            count[(c+0)-97]--;
        }
        
        for(int i : count){
            if( i!=0 )
                return false;
        }
        
        return true;
        
    }

}
