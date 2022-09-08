package test.app.graph;

public class FindTownJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findJudge(int n, int[][] trust) {
        
        int[][] peopleAttr = new int[n][2];
        for( int i=0;i<trust.length;i++) {
            peopleAttr[trust[i][0]-1][0]++;
            peopleAttr[trust[i][1]-1][1]++;
        }
        
        int judge = -1,i=1;
        for( int[] person : peopleAttr ) {
            if( person[0] == 0 && (person[1]==(n-1)) ) {
                if ( judge == -1 )
                     judge = i; 
                else
                     return -1;
            }
            i++;
        }

        return judge;
    }

}
