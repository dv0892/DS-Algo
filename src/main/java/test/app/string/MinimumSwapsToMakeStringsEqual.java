package test.app.string;

public class MinimumSwapsToMakeStringsEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumSwap(String s1, String s2) {
        int diffXY = 0;
        int diffYX = 0;

        for(int i=0;i<s1.length();i++){
            int ch1 = s1.charAt(i);
            int ch2 = s2.charAt(i);
            if( ch1 == ch2 ){
                continue ;
            } else if( ch1 == 'x' ){
                diffXY++;
            } else{
                diffYX++;
            }
        }

        if( diffXY%2 == 0 && diffYX%2 == 0 ){
            return (diffXY/2) + (diffYX/2) ;
        } else if ( diffXY%2 == 1 && diffYX%2 == 1 ){
            return (diffXY/2) + (diffYX/2) + 2;
        } else
            return -1;
    }

}
