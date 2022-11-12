package test.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class GetWatchedVideosByYourFriends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> watchedVideos = new ArrayList<>();
		watchedVideos.add(Arrays.asList("bjwtssmu"));
		watchedVideos.add(Arrays.asList("aygr","mqls"));
		watchedVideos.add(Arrays.asList("vrtxa","zxqzeqy","nbpl","qnpl"));
		watchedVideos.add(Arrays.asList("r","otazhu","rsf"));
		watchedVideos.add(Arrays.asList("bvcca","ayyihidz","ljc","fiq","viu"));
		
		int[][] friends = {{1,2,3,4},{0,4},{0,4},{0,4},{0,1,2,3}};
		
		System.out.println( new GetWatchedVideosByYourFriends().watchedVideosByFriends(watchedVideos, friends, 3, 1));
	}
	
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		
		List<List<Integer>> graph = new ArrayList<>();
		int n = friends.length;
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<>());
			
			for( int f : friends[i] ) {
				graph.get(i).add(f);
			}
		}
		
		boolean[] visited = new boolean[n];
		Deque<Integer> q = new LinkedList<>();
		q.add(id);
		visited[id] = true;
		
		while( level-- > 0 && !q.isEmpty() ) {
			int size = q.size();
			while( size-- > 0) {
				int node = q.remove();
				for( int ne : graph.get(node) ) {
					if( !visited[ne] ) {
						visited[ne] = true;
						q.add(ne);
					}
				}
			}
		}
		
		if( level > 0) 
			return new ArrayList<>();
		
		Map<String,Integer> vf = new HashMap<>();
		for( int fv : q ) {
			for( String v : watchedVideos.get(fv) ) {
				vf.put(v , vf.getOrDefault(v, 0) + 1 );
			}
		}
		
		
		List<String> res = vf.entrySet().stream()
        .sorted( (s1,s2) -> s1.getValue() == s2.getValue() ?  s1.getKey().compareTo(s2.getKey()) : s1.getValue() - s2.getValue())
        .map(v -> v.getKey())
        .collect(Collectors.toList());
		

		return res;
    }

}
