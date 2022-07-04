package test.app.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        
		if( p == null && q == null )
			return true;
		
		if( p == null || q == null )
			return false;
		
		Deque<TreeNode> q1 = new ArrayDeque<>();
		Deque<TreeNode> q2 = new ArrayDeque<>();
		
		q1.add(p); q2.add(q);
		
		while ( !q1.isEmpty() && !q2.isEmpty() ) {
			int size1  = q1.size();
			int size2  = q2.size();
			
			if( size1 != size2 )
				return false;
			
			while ( size1-- > 0 && size2-- > 0 ) {
				
				TreeNode t1 = q1.remove();
				TreeNode t2 = q2.remove();
				
				if( t1.val != t2.val )
					return false;
				

                
				if( Objects.nonNull(t1.left) && Objects.nonNull(t2.left) ) {
                     q1.add( t1.left );
                     q2.add( t2.left );
                } else {
                    if( !(Objects.isNull(t1.left) && Objects.isNull(t2.left)) )
                        return false;
                }
                
                
                if( Objects.nonNull(t1.right) && Objects.nonNull(t2.right) ) {
                     q1.add( t1.right );
                     q2.add( t2.right );
                } else {
                    if( !(Objects.isNull(t1.right) && Objects.isNull(t2.right)) )
                        return false;
                }
				
			}
		}
		
		return true;
 				
    }


public boolean isSameTreeUsingDFS(TreeNode p, TreeNode q) {
        
		if( p == null && q == null )
			return true;
		
		if( p == null || q == null )
			return false;
		
		if( p.val != q.val)
			return false;
		
		return isSameTreeUsingDFS(p.left, q.left) && isSameTreeUsingDFS(p.right, q.right);
		
		 				
    }

	
}
