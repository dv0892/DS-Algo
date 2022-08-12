package test.app.greedy;

public class PartitionArrayIntoThreePartsWithEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
		
		System.out.println( new PartitionArrayIntoThreePartsWithEqualSum().canThreePartsEqualSumEfficient(arr));
	}

public boolean canThreePartsEqualSum(int[] arr) {
        
        int p1 = 0,p2=0,p3=0,n=arr.length;
        for( int i=0;i<n-2;i++){
            p1 += arr[i];
            p2 = 0;
            for( int j=i+1;j<n-1;j++){
                p2 += arr[j];
                if( p1 == p2 ){
                    p3 = 0;
                    for( int k=j+1;k<n;k++){
                        p3 += arr[k];
                    }
                    
                    if( p3 == p2 )
                            return true;
                }
            }
        }
        
        return false;
        
    }

public boolean canThreePartsEqualSumEfficient(int[] arr) {
    
    int n = arr.length, sum = 0;
	for( int i=0;i<n;i++){
        sum += arr[i];
    }
	
	if( sum%3 != 0 )
		return false;
	
	int partSum = sum / 3;
	int p = 1;	
	sum = 0;
    for( int i=0;i<n;i++){
    	sum += arr[i];
    	
    	if( p > 3 )
    		continue;
    	
    	if( partSum == sum ) {
    		p++;
    		sum = 0;
    	}
    }
    
    return p == 4 && sum == 0;
    }

	public boolean canThreePartsEqualSumOptimized(int[] arr) {
    
	int n = arr.length;
    int[] pre = new int[n];
    int[] suf = new int[n];
    
    pre[0] = arr[0];
    suf[n-1] = arr[n-1];
    
    for( int i=1,j=n-2; j>=0 && i<n; i++,j--){
    	pre[i] = pre[i-1] + arr[i];
    	suf[j] = suf[j+1] + arr[j];
    }
		
    for( int i=0;i<n-2;i++){
        for( int j=i+2;j<n;j++) {
        
        	if( pre[i] == suf[j] && ( pre[i] == (pre[j] - pre[i] -arr[j]) ) )
        		return true;
        }
    }
    
    return false;
    
}
	
	
	
}
