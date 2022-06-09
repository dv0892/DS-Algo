package test.app.linkedlist;

public class ConvertBinaryInALinkedListToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node5 = new ListNode(1);
		ListNode node4 = new ListNode(0, node5);
		
		//list A
		ListNode node3 = new ListNode(1, node4);
		ListNode node2 = new ListNode(0, node3);
		ListNode node1 = new ListNode(1, node2);
		
		System.out.println( new ConvertBinaryInALinkedListToInteger().getDecimalValueOptimized(node1));
	}
	
	public int getDecimalValueOptimized(ListNode head) {
		
		/*
		 * Since we getting the binary number from in form of LinkedList
		 * The MSB is received and then the LSB is last node .
		 * 
		 * If LSB is first node, then solution is simple for each ith node if( i.val == 1 ) do 2^i and add it to answer.
		 * 
		 * But here we are receiving MSB , So possible solutions are :
		 * 1. Reverse the entire list, then do the above defined operation.
		 * 
		 * Another soln 
		 * 
		 * 2. First the "size" of entire list 
		 * and then initialize i = size-1 , then do the above operations.
		 * 
		 * Another soln 
		 * 
		 * 3. Use the Doubling method to calculate the decimal starting from MSB.
		 * e.g 100
		 * 
		 * First we get 1
		 * the ans = 1;
		 * Second we get 0
		 * then double prev ans and add this node val
		 * ans = 2*ans + node.val;
		 * 
		 * ans = 2;
		 * 
		 * Third we get 0
		 * then double prev ans and add this node val
		 * ans = 2*ans + node.val;
		 * 
		 * ans = 4;
		 * 
		 * So Final Answer is 4
		 * 
		 *  
		 */
		
        int num = 0;
        while( head != null ) {
        	num = (num << 1) + head.val;
        	head = head.next;
        }
        
        return num;
    }
	
	public int getDecimalValue(ListNode head) {
        
        int size = size(head);
        return getValue(head,size-1);
    }
    
     public int getValue( ListNode head , int size ) {
        
         if( head == null )
             return 0;
         
         return  head.val == 0 ? getValue(head.next,size-1) : (int)Math.pow(2 , size) + getValue(head.next,size-1) ;
	}
    
    public int size( ListNode head ) {
		int size=0;
		while( head != null) {
			head = head.next;
			size++;
		}
		
		return size;
	}

}
