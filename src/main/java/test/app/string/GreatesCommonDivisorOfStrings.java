package test.app.string;

public class GreatesCommonDivisorOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new GreatesCommonDivisorOfStrings().gcdOfStrings("LEET", "CODE"));
	}
	
	
	public String gcdOfStrings(String str1, String str2) {
        String largestString = "";
        for(int i=1;i<=str1.length();i++){
            String x = str1.substring(0,i);
            if( ifDivides(str1,x) && ifDivides(str2,x) ){
                largestString = x;
            }
        }

        return largestString;
    }

    public boolean ifDivides( String str , String x ){
        int len = x.length();
        while( len <= str.length() && x.equals(str.substring(0,len)) ){
           str = str.substring(len);
        }

        return str.isEmpty();
    }

}
