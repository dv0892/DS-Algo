package test.app.array;

import java.util.ArrayList;
import java.util.Arrays;

public class SortOrderMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		
		a.add(new ArrayList<Integer>( Arrays.asList(1,2,3) ));
		a.add(new ArrayList<Integer>( Arrays.asList(4,5,6) ));
		a.add(new ArrayList<Integer>( Arrays.asList(7,8,9) ));
		
		new SortOrderMatrix().rotate(a);
		
		System.out.println(a);
		
	}
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	
		int n = a.size();
        for(int level=0;level<n/2;level++) {
            for(int y=level; y< n-level-1;y++) {
                int temp = a.get(level).get(y);
                a.get(level).set(y, a.get(n-1-y).get(level));
                a.get(n-1-y).set(level, a.get(n-1-level).get(n-1-y));
                a.get(n-1-level).set(n-1-y, a.get(y).get(n-1-level));
                a.get(y).set(n-1-level, temp);
            }
        }
		
		/*int left  = 0;
		int right = a.size()-1;
		
		while(left < right) {
			int top    = left;
			int bottom = right;
			
			for (int i = left ; i < right ; i++) {
				
				int topleft = a.get(top).get(left + i);
				
				//move bottom left into top left
				a.get(top).set(left + i, a.get(bottom - i).get(left) );
				
				//move bottom right into top right
				a.get(bottom - i).set(left , a.get(bottom).get(right - i)) ;
				
				//move top right into bottom right
				a.get(bottom).set(right - i , a.get(top + i).get(right));
				
				//move already top left element into top right
				a.get(top + i).set(right , topleft );
				
			}
			
			left++;
			right--;
		}*/
	
	}

}
