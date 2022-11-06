package test.app.string;

import java.util.Arrays;

public class OrderlyQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new OrderlyQueue().orderlyQueue("xmvzi", 3));
		
		//imvxz
	}
	
	
	public String orderlyQueue(String s, int k) {
        
		char[] str = s.toCharArray();
		
		if( str.length==1 || k==str.length ) {
			Arrays.sort(str);
			return new  String(str);
		}
		
		// Place the smallest k elements at the front 
		for( int i=0;i<k;i++) {
			picksmallestAndRearrange(i,str);
		}
		
		char el = str[k-1];
		int j = str.length-1;
		while( j!=k-1 && str[j] == el )
			j--;
		

		if( j==k-1 || j+1==str.length )
			return new  String(str); 
		
		j++;
		int n = str.length;
		int size = n - j;
		char[] temp = Arrays.copyOfRange(str,j,n);
		
		
		for( int l=j-1; l>=(k); l--) {
			
			// shift all the elements to right by a factor of size from k to j-1 
			int shift = size ;
			int m = l;
			while( shift-- > 0 ) {
				str[m+1] = str[m];
				m++;
			}
		}

		// copy all the elements from temp back to str array
		for( int m=0,f=k ; m<temp.length; f++,m++ ) {
			str[f] = temp[m];
		} 
		
		return new  String(str);
    }


	private void picksmallestAndRearrange( int i, char[] str ) {
		
		int n = str.length;
		char el = str[i];
		int res = i;
		for( int j=i+1;j<n;j++) {
			if ( str[j] < el ) {
				el = str[j];
				res = j;
			}
		}
		
		if( res == i )
			return ;
		
		int size = res - i;
		char[] temp = Arrays.copyOfRange(str,i,res);
		
		
		for( int k=res; k<n; k++) {
			
			// shift all the elements to left by a factor of size from res to n-1 
			int shift = size ;
			int l = k;
			while( shift-- > 0 ) {
				str[l-1] = str[l];
				l--;
			}
		}

		// copy all the elements from temp back to str array
		for( int k = n-size , m=0; k<n && m<temp.length; k++,m++ ) {
			str[k] = temp[m];
		}
			
	}

}
