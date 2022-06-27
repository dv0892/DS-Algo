package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IteratorForCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	

}


class CombinationIterator {

    List<String> list ;
    int itr;
    
    public CombinationIterator(String characters, int combinationLength) {
        
        list = findCombinations( "" ,characters, 0 ,combinationLength);
        
    }
    
    public List<String> findCombinations(String path , String characters, int index , int combinationLength) {
        
        
        if ( path.length() == combinationLength ){
            List<String> res = new ArrayList<>();
            res.add(path);
            
            return res;
        }
        
        List<String> res = new ArrayList<>();
        
        for ( int i=index;i<characters.length() ; i++ ){
            res.addAll( findCombinations ( path + characters.charAt(i) , characters, i + 1, combinationLength ) );
        }

        return res;
        
    }
    
    public String next() {
        return list.get(itr++);
    }
    
    public boolean hasNext() {
        return itr < list.size();
    }
}
