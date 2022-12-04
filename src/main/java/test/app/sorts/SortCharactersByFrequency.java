package test.app.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new SortCharactersByFrequency().frequencySort("cccaaa"));
	}
	
	
	public String frequencySort(String s) {
        
		Map<Character,Integer> map = new HashMap<>();
		for( int i=0;i<s.length();i++) {
			map.merge(s.charAt(i), 1, (v1,v2) -> v1+v2);
		}
		
		List<Map.Entry<Character,Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());
		Collections.sort(list, (e1,e2) ->Integer.compare( e2.getValue(),e1.getValue()));
		
		StringBuilder sb = new StringBuilder();
		for( Map.Entry<Character,Integer> eSet : list ) {
			for( int i=1 ;i<=eSet.getValue().intValue();i++) {
				sb.append(eSet.getKey());
			}
		}
		
		return sb.toString();

    }

}
