package test.app.greedy;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxArea(int[] height) {
        
        int maxArea = Integer.MIN_VALUE,l=0,r=height.length-1;
        while( l < r ){
            maxArea = Math.max( Math.min(height[l],height[r]) * ( r-l ) , maxArea );
            if( height[l] < height[r] )
                l++;
            else
                r--;
        }
        
        return maxArea;
    }

}
