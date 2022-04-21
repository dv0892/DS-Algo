package test.app.array;

public class LongestNiceSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'Z';
		c += 32;
		
		
		System.out.println(new LongestNiceSubString().longestNiceSubstring("YazaAay"));
	}
	
	public String longestNiceSubstring(String s) {
    
	 if(s.length() < 2)
		 return "";
	 
	 int n = s.length();
	 int st=0,end = 0;
	 
     for(int w = 2 ; w <= n; w++) {
    	 int[][] map = new int[2][26];
    	 //pre-processing for window of size w
    	 for(int i=0;i<w;i++) {
    		 add(map, s.charAt(i));
    	 }
    	 // Till here
    	 
    	 //Start checking windows of size w
    	 for(int j=0; j<=(n-w) ;j++) {
    		 
    		 if(j!=0) {
    			 remove(map, s.charAt(j-1));
    			 add(map, s.charAt(j+w-1));
    		 }
    		 
    		 
    		 boolean nice = true;
    		 for(int k=j;k<(j+w);k++) {
    			 if(!exists(map, s.charAt(k)) ){
    				 nice = false;
    				 break;
    			 }
    		 }
    		 
    		 if(nice == true) {
    			 st = j;
    			 end = j+w;
    			 break;
    		 }
    	 }
     }
     
     return s.substring(st,end);
	
		
    }
	
	public void remove(int[][] map, char c) {
		
		if( c >= 97 && map[0][c-97] > 0)
			map[0][c-97]--;
		else {
			if( map[1][c-65] > 0)
			map[1][c-65]--;
		}
	}
	
	public void add(int[][] map, char c) {
		
		if( c >= 97 )
			 map[0][c-97]++;
		 else
			 map[1][c-65]++;
	}
	
	
	public boolean exists(int[][] map, char c) {
		if( c >= 97 )
			 return map[1][c-32-65] > 0 ? true : false;
		 else
			 return map[0][c+32-97] > 0 ? true : false;
	}
	

}
