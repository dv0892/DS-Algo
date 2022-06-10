package test.app.tree;

public class TreeUtils {
	
	TreeNode root ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TreeUtils utils = new TreeUtils();
		
		/*TreeNode leafNode1 = new TreeNode(2);
		TreeNode leafNode2 = new TreeNode(9);
		TreeNode node1 = new TreeNode(5,leafNode1,leafNode2,null);
		leafNode1.parent = node1;
		leafNode2.parent = node1;
		
		TreeNode leafNode3 = new TreeNode(17);
		TreeNode node2 = new TreeNode(15,null,leafNode3,null);
		leafNode2.parent = node2;
		
		TreeNode leafNode4 = new TreeNode(19);
		TreeNode node3 = new TreeNode(18,node2,leafNode4,null);
		leafNode4.parent = node3;
		node2.parent = node3;*/
		
		
		TreeNode root = new TreeNode(12,null,null,null);
		utils.root = root;
		
		//node1.parent = root;
		//node3.parent = root;
		
		utils.insert(root, 18);
		utils.insert(root, 5);
		
		utils.insert(root, 15);
		utils.insert(root, 19);
		utils.insert(root, 17);
		
		utils.insert(root, 2);
		utils.insert(root, 9);
		
		
		
		utils.inorderTraversal(utils.root);
		//utils.preorderTraversal(root);
		//utils.postorderTraversal(root);
		
		/*System.out.println( utils.max(root) );
		
		System.out.println( utils.successor(root,15) );*/
		
		utils.delete( utils.search(root, 12));
		
		utils.inorderTraversal(utils.root);
	}
	
	public void inorderTraversal( TreeNode node ) {
		if( node == null )
			return ;
		
		inorderTraversal(node.left);
		System.out.print( " " + node.val );
		inorderTraversal(node.right);
	}
	
	
	public void preorderTraversal( TreeNode node ) {
		if( node == null )
			return ;
		
		System.out.print( " " + node.val );
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	
	public void postorderTraversal( TreeNode node ) {
		if( node == null )
			return ;
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print( " " + node.val );
	}
	
	public TreeNode search( TreeNode node , int x ) {
		
		if( node == null )
			return node;
		
		if( node.val == x)
			return node;
		else if ( x < node.val )
			return search(node.left, x);
		else
			return search(node.right, x);
	}
	
	public TreeNode min( TreeNode node  ) {
		
		TreeNode min = node;
		
		while ( node != null ) {
			min = node;
			node = node.left;
		}
		
		return min;
	}
	
	
	public TreeNode max( TreeNode node  ) {
		
		TreeNode max = node;
		
		while ( node != null ) {
			max = node;
			node = node.right;
		}
		
		return max;
	}
	
	
	public TreeNode successor ( TreeNode node , int x ) {
		
		TreeNode val =  search(node, x);
		
		if( val.right != null )
			return min(val.right);
		
		TreeNode parent =  val.parent;
		
		while ( parent != null && parent.right == val ) {
			val = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	
	public TreeNode predeccessor ( TreeNode node , int x ) {
		
		TreeNode val =  search(node, x);
		
		if( val.left != null )
			return max(val.left);
		
		TreeNode parent =  val.parent;
		
		while ( parent != null && parent.left == val ) {
			val = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	
	public void insert ( TreeNode root , int x ) {
		
		TreeNode newNode = new TreeNode(x);

		TreeNode parent = null;
		while ( root != null ) {
			parent = root;
			if( newNode.val > root.val )
				root = root.right;
			else
				root = root.left;
		
		}
		
		newNode.parent = parent;
		
		if( parent == null) {
			// new Node  becomes root of tree;
			// return
		}
		
		if( newNode.val > parent.val )
			parent.right = newNode;
		else
			parent.left = newNode;
		
	}
	
	
	public void delete ( TreeNode del ){
		/*
		 * Here there are four cases about the node to be
		 * delete :
		 * 1. It can be leaf node
		 * 2. It is having left child only.
		 * 3. It is having right child only.
		 * 4. It is having both right as well as left child.
		 */
		
		// Case 1
		if( del.left == null && del.right == null ) {
			transplant(del,null);
			return ;
		}
			
	    // case 2
		if( del.left == null ) {
			/*
			 * Since the node to be delete only has right subtree 
			 * and this should be attached to del's parent.
			 * 
			 * For this above task we will write a function called transplant Since the same will
			 * be require while handling case 3.
			 */
			transplant(del,del.right);
			return ; 
		}
		
		 // case 3
		if( del.right == null ) {
			transplant(del,del.left);
			return ;
		}
		
		//case 4
		/*
		 * Now we need replace this node with another node so that left and right subtree's
		 * hold the binary search tree condition.
		 * What could be that node ?
		 * The best possibile is node that is just greater than this del node and that can be found in this node's 
		 * right subtree. So basically we need to find a successor and that can be foudd in right subtree.
		 * 
		 * 
		 */
		
		// Here we can use min function on right subtree or right chil also to find successor for del node
		TreeNode successor = min(del.right);
		
		// If this is not the immediate right child of del node
		if( successor.parent != del ) {

			transplant(successor, successor.right);
			successor.right = del.right ;
			successor.right.parent = successor;
		
		}
		
		transplant(del, successor);
		successor.left = del.left ;
		successor.left.parent = successor;
	} 
	
	public void transplant( TreeNode s , TreeNode t ) {
		
		if( s.parent == null)
			this.root = t;
		else {
			if(s == s.parent.left) {
				s.parent.left = t; 
			} else {
				s.parent.right = t; 
			}
		}
		if( t != null )
			t.parent = s.parent;
	}
		
		
		
		
	
	

}
