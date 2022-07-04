package test.app.array;

public class TimeNeededToBuyTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int timeRequiredToBuy(int[] tickets, int k) {
        
        int mine = tickets[k];
        
        int totalWaiting = mine;
        
        for(int i=0;i<tickets.length;i++){
            if(i == k)
                continue;
            
            if( i > k)
                totalWaiting += Math.min(mine-1,tickets[i]);
            else
                totalWaiting += Math.min(mine,tickets[i]);
        }
        
        return totalWaiting;
    }

}


