package test.app.hash;

import java.util.ArrayList;
import java.util.List;

public class JewelsAndStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findStonesThatAreJewels("z","zZ"));

	}
	
	public static int findStonesThatAreJewels(String j, String s) {
		int cnt = 0;
		
		List<Character> listOfJewels = new ArrayList<>();
		for(char jewel : j.toCharArray()) {
			listOfJewels.add(jewel);
		}
		
		for(char stone : s.toCharArray()) {
			if(listOfJewels.contains(stone))
				cnt++;
		}
		
		return cnt;
	}

}
