package test.app.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if( root == null )
            return res;
        
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
            
        while ( !q.isEmpty() ) {
            int size = q.size();
            
            List<Integer> level = new ArrayList<>();
            while( size-- > 0 ) {
                root = q.remove();
                
                if( Objects.nonNull(root.left) )
                    q.add( root.left );
                
                if( Objects.nonNull(root.right) )
                    q.add( root.right );
                
                level.add(root.val);
            }
            
            res.add(level);
        }
        
        return res;
    }

}
