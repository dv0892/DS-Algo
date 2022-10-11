package test.app.tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DeepestLeavesSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		TreeNode node4 = new TreeNode(4,node7,null);
		TreeNode node34 = new TreeNode(34,null,null);
		TreeNode node6 = new TreeNode(6,null,node34);
		
		TreeNode node98 = new TreeNode(98,null,null);
		TreeNode node54 = new TreeNode(54,node98,node6);
		TreeNode node50 = new TreeNode(50,null,node54);
		
		new DeepestLeavesSum().deepestLeavesSumDFS(node50, 0);
	}
	
	static Map<Integer, Integer > map = new HashMap<>();
	
	public void deepestLeavesSumDFS(TreeNode root , int d) {
		
	   if( root == null )
		   return ;
        
       if( root.left == null && root.right == null ) {
    	   if( map.isEmpty() )
    		   map.put(d, root.val);
    	   else {
    		   Integer key = map.keySet().iterator().next();
    		   if( d > key.intValue()) {
    			   map.clear();
    			   map.put(d, root.val);
    		   } else if( d == key.intValue() )
    			   map.put(d, map.get(key) + root.val);
    	   }
       } else {
    	   deepestLeavesSumDFS(root.left, d+1);
       	   deepestLeavesSumDFS(root.right, d+1);
       }
    	   
    }
	
	
	public int deepestLeavesSum(TreeNode root) {
        
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int sum = 0;
        
        while( !q.isEmpty() ){
            int sz = q.size();
            sum = 0;
            while(sz-- > 0) {
                TreeNode node = q.remove();
                
                sum += node.val;
                
                if( node.left != null )
                    q.add(node.left);
                
                if( node.right != null )
                    q.add(node.right);
            }
        }
        
        return sum;
    }

}
