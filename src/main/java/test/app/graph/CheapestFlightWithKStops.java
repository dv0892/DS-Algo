package test.app.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CheapestFlightWithKStops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        Map<Integer,Map<Integer,Integer>> cities = new HashMap<>();
        for( int[] flight : flights ){
            int s = flight[0];
            int d = flight[1];
            int c = flight[2];
            
            cities.computeIfAbsent(s, x -> new HashMap<>() ).put(d,c);
        }
        
        Deque<Pair> q = new LinkedList<>();
        dist[src] = 0;
        q.add( new Pair(src,dist[src]));
        
        while( !q.isEmpty() && k-- >= 0) {
            int sz = q.size();
            while( sz-- > 0 ){
                Pair p = q.remove();
                int city = p.city;
                int currDist =p.dist;
                
                for( int neigh : cities.computeIfAbsent(city, x -> new HashMap<>()).keySet() ){
                    int cost = cities.get(city).getOrDefault(neigh,0);
                    
                    
					if( dist[neigh] > (currDist + cost)){
                        dist[neigh] = (currDist + cost);
                        q.add(new Pair(neigh,dist[neigh]));
                    }
                }
            }
        }   
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
	
	class  Pair {
		int city , dist;
		Pair( int city , int dist ){
			this.city =  city;
			this.dist = dist;
		}
	}

}
