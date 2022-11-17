package test.app.math;

public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if( ax1>=bx2 || bx1>=ax2 || by2<=ay1 || ay2<=by1 )
           return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1);
        else
           return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - ( (Math.min(ax2,bx2)-Math.max(ax1,bx1))*(Math.min(ay2,by2)-Math.max(ay1,by1)) ) ;
    }

}
