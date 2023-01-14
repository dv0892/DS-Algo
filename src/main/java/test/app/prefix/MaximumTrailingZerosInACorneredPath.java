package test.app.prefix;

import java.util.Arrays;

public class MaximumTrailingZerosInACorneredPath {

	public static void main(String[] args) {
		int[][] grid = {{824,709,193,413,701,836,727},{135,844,599,211,140,933,205},{329,68,285,282,301,387,231},{293,210,478,352,946,902,137},{806,900,290,636,589,522,611},{450,568,990,592,992,128,92},{780,653,795,457,980,942,927},{849,901,604,906,912,866,688}} ;
		
		System.out.println( new MaximumTrailingZerosInACorneredPath().maxTrailingZeros(grid));
	}


    public int maxTrailingZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] prefix = new int[rows][cols][2];
        int[][][] suffix = new int[rows][cols][2];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                prefix[r][c] = findTwosFives(grid[r][c]);
                if( c > 0 ) {
                    prefix[r][c][0] +=   prefix[r][c-1][0];
                    prefix[r][c][1] +=   prefix[r][c-1][1];
                }
                System.out.print(Arrays.toString(prefix[r][c]));
            }
            System.out.println();
        }

         System.out.println(" ===== ");
        for(int r=0;r<rows;r++){
            for(int c=cols-1;c>=0;c-- ){
                suffix[r][c] = findTwosFives(grid[r][c]);
                if( c < (cols-1) ) {
                    suffix[r][c][0] +=   suffix[r][c+1][0];
                    suffix[r][c][1] +=   suffix[r][c+1][1];
                }
            }
            for( int c=0;c<cols;c++)
                System.out.print(Arrays.toString(suffix[r][c]));
                
            System.out.println();
        }

        int res = 0;

        //Top left 
        for(int c=0;c<cols;c++) {
            int[] count = new int[2];
            for(int r=0;r<rows;r++){
                // check in suffix array 
                int[] suff = suffix[r][c];
                res = Math.max(res , Math.min( suff[0] + count[0] , suff[1] + count[1]) );

                // check in prefix array 
                int[] pre = prefix[r][c];
                res = Math.max(res , Math.min( pre[0] + count[0] , pre[1] + count[1]) );

                int[] temp = findTwosFives(grid[r][c]);
                count[0] += temp[0]; 
                count[1] += temp[1];                
            }
        }

        //Top right 
        for(int c=0;c<cols;c++) {
            int[] count = new int[2];
            for(int r=rows-1;r>=0;r--){
            	int[] suff = suffix[r][c];
                res = Math.max(res , Math.min( suff[0] + count[0] , suff[1] + count[1]) );

                // check in prefix array 
                int[] pre = prefix[r][c];
                res = Math.max(res , Math.min( pre[0] + count[0] , pre[1] + count[1]) );

                

                int[] temp = findTwosFives(grid[r][c]);
                count[0] += temp[0]; 
                count[1] += temp[1];                
            }
        }


        

        return res;
    }

    public int[] findTwosFives( int n ){
        int twos=0;
        int fives=0 ;

        int n1 = n;
        while( n1%2 == 0 ){
            n1 /= 2;
            twos++;
        }

        while( n%5 == 0 ){
            n /= 5;
            fives++;
        }    

        return new int[]{twos,fives};
    }
    
}