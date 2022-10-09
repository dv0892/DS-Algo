package test.app.graph;

import java.util.List;

public class KeysAndRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] unlocked = new boolean[rooms.size()];
        dfs(0,rooms,unlocked);
        
        for( boolean room : unlocked ){
            if( !room )
                return false;
        }
        
        return true;
    }
    
    
    public void dfs(int room, List<List<Integer>> rooms , boolean[] unlocked ) {
        if( unlocked[room] )
            return;
        
        unlocked[room] = true;
        
        for( int neigh : rooms.get(room) ) 
            dfs( neigh, rooms, unlocked);
    }

}
