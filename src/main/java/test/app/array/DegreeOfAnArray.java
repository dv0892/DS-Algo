package test.app.array;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

public class DegreeOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,1};
		System.out.println( new DegreeOfAnArray().findShortestSubArray(nums) );
	}
	
	public int findShortestSubArray(int[] nums) {
		

		Map<Integer,Info> map = new HashMap<>();

		for(int i=0; i<nums.length ; i++) {
			map.merge( nums[i], new Info(1, i, i), (oldV,newV)-> {
				oldV.f++;
				oldV.end = newV.end;
				return oldV;
					});
		}

		System.out.println( map.toString() );
		java.util.Optional<Info> t = map.values().stream().max((o1,o2) ->  o1.f - o2.f );
		
		int res = Integer.MAX_VALUE;
		for (Info obj : map.values() ) {
			if(obj.f == t.get().f) {
				res = Math.min(res, obj.end - obj.st + 1);
			}
		}


	    return res;
    }
	
	class Info {
		int f;
		int st;
		int end;
		
		Info( int f , int st, int end){
			this.f   = f;
			this.st  = st;
			this.end = end ;
		}
		
		public String toString() {
			return this.f + " " + this.st +" " + this.end;
		}
	}

}
