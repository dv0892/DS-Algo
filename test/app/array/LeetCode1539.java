class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> missing  = new ArrayList<>();
        int st;
		for(int i=0; i<arr.length; i++) {
			if(i==0) 
				st = 1;
			else 
				st = arr[i-1]+1;
			
			for( ; st < arr[i]; st++) {
				missing.add(st);
			}
		}
		
		if(k > missing.size())
			return arr[arr.length-1]+k;
		
		return missing.get(k-1);
    }
}
