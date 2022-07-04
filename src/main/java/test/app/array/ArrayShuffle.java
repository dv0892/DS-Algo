package test.app.array;

public class ArrayShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(shuffle_InSameArray(4,1,3,5,7,2,4,6,8));
	}
	
	public static int[] shuffle(int n,int... arr) {
		int[] res = new int[arr.length];
		
		for(int i=0,j=0;i<n;i++) {
			res[j++] = arr[i];
			res[j++] = arr[i+n];
		}
		
		
		return res;
	}
	
	public static int[] shuffle_InSameArray(int n,int... arr) {
		
		
		int max = 1001;
		
		for(int i=n;i<arr.length;i++) {
			arr[i] = arr[i]*max + arr[i-n];
		}
		
		int index=0;
		for(int i=n;i<arr.length;i++) {
			arr[index] = arr[i]%max;
			arr[index+1] = arr[i]/max;
			
			index += 2;
		}
		
		return arr;
	}
	
	public static void  display(int[] arr) {
		for(int el : arr) {
			System.out.print(el+" ");
		}
	}

}
