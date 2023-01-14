package test.app.unionfind;

public class LexicographicallySmallesEquivalentString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] hash = new int[26];
        for(int i=0;i<26;i++)
            hash[i] = i;

        int len = s1.length();
        while(--len >= 0 ){
            if( s1.charAt(len) == s2.charAt(len) )
                continue;
            merge(hash,s1.charAt(len)-'a',s2.charAt(len)-'a') ;
        }   

        char[]  res = new char[baseStr.length()];
        for(int i=0;i<res.length;i++){
            res[i] = (char)('a' + get(hash, baseStr.charAt(i)-'a'));
        }
            
        return new String(res); 
    }

    public void merge( int[] hash , int i1 , int i2 ){
        int p1 = get(hash,i1);
        int p2 = get(hash,i2);

        hash[p1] = hash[p2] = Math.min(p1,p2);   
    }

    public int get( int[] hash , int index ){
        if( hash[index] == index){
            return  index;
        }

        return hash[index] = get(hash,hash[index]);
    }
	

}
