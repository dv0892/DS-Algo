package test.app.codility;

public class NationalCodingWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(String S) {
        char[] str = S.toCharArray();
        int N = str.length;
        for(int i=0;i<N; ){
            if( str[i]=='a' && (i+2)<N && 
                str[i+1]=='b' && str[i+2]=='b' ){
                str[i]='b';
                str[i+1]= str[i+2]= 'a';
                i = Math.max(0,i-2);
            } else
                i++;
        }

        return new String(str);
    }

}
