
public class LargestTriangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     int[][] points = {{-35,19},{40,19},{27,-20},{35,-3},{44,20},{22,-21},{35,33},{-19,42},{11,47},{11,37}};
	     
	     System.out.println( new LargestTriangleArea().largestTriangleArea(points));
 	}
	
	
	public double largestTriangleArea(int[][] points) {
        
		double max_area = Double.MIN_VALUE;
		for (int i=0;i<points.length;i++) {
			for (int j=i+1;j<points.length;j++) {
				for (int k=j+1;k<points.length;k++) {
					
					max_area = Math.max(max_area , area( points[i] , points[j] , points[k]) );
				}
			}
		}
		
		return max_area ;
    }
	
	public double sideLength( int[] x , int[] y ) {
		
		return Math.sqrt( (x[0] - y[0])*(x[0] - y[0]) + (x[1] - y[1])*(x[1] - y[1]) );
	}
	
	
	public double area ( int[] a, int[] b ,int[] c ) {
		
		double side1 = sideLength(a,b);
		double side2 = sideLength(b,c);
		double side3 = sideLength(a,c);
		
		double s = ( side1+side2+side3)/2.0d;
		
		//return Math.sqrt( s*(s-side1)*(s-side2)*(s-side3));
		return (0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1]- b[0] * a[1] - c[0] * b[1] - a[0] * c[1]));
	}

	private double getArea(int[] p1, int[] p2, int[] p3) {
        return Math.abs((p2[0] - p1[0]) * (p3[1] - p1[1]) - 
                       0.5 * (p2[0] - p1[0]) * (p2[1] - p1[1]) - 
                       0.5 * (p3[0] - p1[0]) * (p3[1] - p1[1]) -
                       0.5 * (p2[0] - p3[0]) * (p3[1] - p2[1]));
    }
	

}
