package test.app.array;

public class TwoFurthestHousesWithDifferentColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] colors = {1,1,1,6,1,1,7};
		System.out.println( new TwoFurthestHousesWithDifferentColors().maxDistance(colors));
	}
	
	public int maxDistance(int[] colors) {
		
        /*return maxDistance(colors,0,colors.length-1);*/
		
		/*
		 * the other efficient solution could be 
		 * Since we know the we can find the furthest always from 
		 * two extremes of array.
		 * So the idea is to fix one end  of array(for both ends) and check non-matching element.
		 * Then take the maximum difference.
		 * 
		 */
		
		
		int  l = 0 , r = colors.length-1;
		
		while (colors[0] == colors[r]) r--;
		while (colors[l] == colors[colors.length-1]) l++;
		
		return  Math.max( colors.length-1 - l, r );
    }
    
	/*
	 * The problem with this solution is the recursion tree
	 * gets really big with bigger inputs.
	 */
    public int maxDistance(int[] colors,int st, int end) {
        if((end-st) < 2)
            return colors[st] != colors[end] ? 1 : 0;
        
        return colors[st] != colors[end] ? (end-st) :
                            Math.max( maxDistance(colors,st,end-1) , maxDistance(colors,st+1,end) );
    
    }

}
