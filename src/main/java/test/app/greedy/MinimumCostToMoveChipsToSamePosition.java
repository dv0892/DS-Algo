package test.app.greedy;

public class MinimumCostToMoveChipsToSamePosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int minCostToMoveChips(int[] positions) {
        
        int o=0,e=0;
        for( int position : positions ){
            if( ( position & 1 )  == 1 )
                o++;
            else
                e++;
        }
        
        return Math.min(o,e);
    }

}
