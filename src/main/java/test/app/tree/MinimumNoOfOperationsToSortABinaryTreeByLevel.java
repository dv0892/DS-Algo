package test.app.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinimumNoOfOperationsToSortABinaryTreeByLevel {

	public static void main(String[] args) {
		
		
				
		TreeNode node4 = new TreeNode(417);
		TreeNode node5 = new TreeNode(150);
		TreeNode node6 = new TreeNode(409);
		TreeNode node7 = new TreeNode(41);
				
		TreeNode node2 = new TreeNode(463,node4,node5);
		TreeNode node3 = new TreeNode(103,node6,node7);		
	    
		TreeNode node1 = new TreeNode(332,node2,node3);	
		
		System.out.println( new MinimumNoOfOperationsToSortABinaryTreeByLevel().minimumOperations(node1));

	}
	
public int minimumOperations(TreeNode root) {
        
        int ans = 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty() ){
            List<Integer> level = new ArrayList<>();
            TreeMap<Integer,Integer> orderedMap = new TreeMap<>() ;
            
            int sz = q.size();
            while( sz-- > 0 ){
                TreeNode node = q.remove();
                
                level.add(node.val);
                orderedMap.put(node.val,level.size()-1);
                
                if( node.left != null )
                    q.add(node.left);
                
                if( node.right != null )
                    q.add(node.right);
            }
            
            for(int i=0;i<level.size();i++) {
            	Entry<Integer, Integer> sortedEl = orderedMap.pollFirstEntry();
            	if( sortedEl.getKey().intValue() == level.get(i).intValue() )
            		continue;
            	
            	// If you are here , it means level.get(i) is at wrong position
            	// move it to the position where sortedEl original position's in the array
            	ans++;
            	orderedMap.put(level.get(i), sortedEl.getValue());
            	level.set( sortedEl.getValue(),  level.get(i)  );
            	level.set( i,  sortedEl.getKey() );
            }
            
            /*O(n^2)
             * for( int i=0 ;i<level.size(); i++){
                
                int min = level.get(i),min_j = -1;
                for( int j=i+1 ;j<level.size(); j++) {
                   if( level.get(j) < min ){
                       min_j = j;
                       min = level.get(j);
                   }     
                }
                
                if( min != level.get(i) ){
                    ans++;
                    swap(i,min_j,level);
                }
                    
            }*/
            
        }
        
        return ans;
    }
    
    public void swap( int i, int j , List<Integer> level ){
        int t = level.get(i);
        level.set(i,level.get(j));
        level.set(j,t);
    }

}
