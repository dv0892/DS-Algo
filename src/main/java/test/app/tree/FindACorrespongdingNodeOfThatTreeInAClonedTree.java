package test.app.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class FindACorrespongdingNodeOfThatTreeInAClonedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
		/*
		 * The solution to this problem is simple.
		 * traverse the two simultaneously and check whether we have reached the target node.
		 * If yes return the node cloned tree.
		 * 
		 * Now we are left with choice whether to choose DFS Recursive or DFS Iterative or BFS.
		 */
		
        /*getTargetCopy1(original , cloned, target);
        return clonedTarget;*/
		
		 Deque<TreeNode> stackOriginal = new ArrayDeque<>();
			Deque<TreeNode> stackCloned = new ArrayDeque<>();
			
			stackOriginal.add(original);
	        stackCloned.add(cloned);
			
			while ( !stackOriginal.isEmpty() ) {
				if ( stackOriginal.peek().equals(target) )
					return stackCloned.peek();
				
				TreeNode ori = stackOriginal.pop();
				if( Objects.nonNull(ori.right) ) stackOriginal.push(ori.right);
				if( Objects.nonNull(ori.left) )  stackOriginal.push(ori.left);
				
				TreeNode clone = stackCloned.pop();
				if( Objects.nonNull(clone.right) ) stackCloned.push(clone.right);
				if( Objects.nonNull(clone.left) )  stackCloned.push(clone.left);
				
			}
			
			return null;
		
       
   }
   
   TreeNode clonedTarget ;
   
   public final void getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
   
       if( original == null )
           return ;
       
       if( original == target ){
           clonedTarget = cloned;
           return ;
       }
           
       
       getTargetCopy1(original.left ,cloned.left,target);
       getTargetCopy1(original.right,cloned.right,target);
       
   }

}
