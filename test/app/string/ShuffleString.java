package test.app.string;

public class ShuffleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] indices = {1,0,2};
		System.out.println(restoreString("art",indices));

		
	}
	
	public static String restoreString(String s, int[] indices) {
        char[] input_arr = s.toCharArray();
        char[] res = new char[input_arr.length];
        
        int i=0;
        for(char ch  : input_arr) {
        	res[indices[i++]] = ch;
        }
        
        return (new String(res));
    }
	
	
	

}
