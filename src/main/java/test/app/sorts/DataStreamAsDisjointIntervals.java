package test.app.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DataStreamAsDisjointIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class SummaryRanges {

    public int last ;
    Set<Integer> nums ;
    public SummaryRanges() {
        last = -2;
        nums = new TreeSet<>();
    }
    
    public void addNum(int value) {
        nums.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> ans = new ArrayList<>();
        for( int e : nums ) {
            if( (e-last) > 1 )  {
                ans.add( new int[]{e,e} );
            } else {
                ans.get(ans.size()-1)[1] = e;
            }
            last = e;
        }
        
        int[][] ret = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++) {
        	ret[i] = ans.get(i);
        }
        return ret;
    }
}
