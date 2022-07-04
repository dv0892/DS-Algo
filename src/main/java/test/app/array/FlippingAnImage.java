package test.app.array;

import java.util.Arrays;

public class FlippingAnImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
		
		for(int[] r : new FlippingAnImage().flipAndInvertImage(image)) {
			System.out.println(Arrays.toString(r));
		}
	}
	
	 public int[][] flipAndInvertImage(int[][] image) {
	        
		 	int r = 0, c = 0;
	        for( ; r < image.length ; r++ ) {
	            int i = 0, j = image[r].length - 1;
	            while(i <=  j){
	                 if(image[r][i] == image[r][j]){
	                    image[r][i] = image[r][j] = image[r][j] == 1 ? 0 : 1;
	                }
	                i++;j--;
	            }
	        }
	        
	        return image;
	        
	    }

}
