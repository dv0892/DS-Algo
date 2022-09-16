package test.app.string;

public class OCRSoftware {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println( new OCRSoftware().solution("3x2x", "8"));
	}
	public boolean solution(String S, String T) {
        
        int lenS = findLen(S);
        int lenT = findLen(T);

        System.out.println(lenS);
        System.out.println(lenT);
        // if lengths aren't equal
        if( lenS != lenT )
            return false;

        return true;
    }

    public int findLen( String S  ) {
        int lenS = 0 ;

        int digitLen = 0;
        for( int i=0;i<S.length();i++ ){  
            if( Character.isAlphabetic(S.charAt(i)) ) {
                lenS++;
                if( digitLen > 0 ){
                    lenS += ( Integer.parseInt(S.substring(i-digitLen, i)));
                } 
                digitLen = 0;
            } else {
                digitLen++;
            }
        }  

        if( digitLen > 0 ){
            lenS += ( Integer.parseInt(S.substring(S.length()-digitLen )));
        }

        return lenS;     
    }
}


