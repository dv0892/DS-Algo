package test.app.search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3};
		
		System.out.println(new BinarySearch().search(a, 0));
	}
	
	public int  search(int[] a, int x) {
		
		int st = 0, end = a.length-1 ;
		
		while(st <=  end) {
			
			int mid = st + (end - st)/2;
			
			if(a[mid] == x)
				return mid;
			
			if(x > a[mid])
				st = mid + 1;
			else
				end = mid - 1;
		}
		
		return -1;
	}

}
