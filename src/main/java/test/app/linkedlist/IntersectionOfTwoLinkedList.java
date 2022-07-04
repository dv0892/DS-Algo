package test.app.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node5 = new ListNode(4);
		ListNode node4 = new ListNode(2, node5);
		
		//list A
		ListNode node3 = new ListNode(1, node4);
		ListNode node2 = new ListNode(9, node3);
		ListNode node1 = new ListNode(1, node2);
		
		//list B
		ListNode node1B = new ListNode(3, node4);		
		
		
		System.out.println( new IntersectionOfTwoLinkedList().getIntersectionNodeOptimized(node1, node1B));
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode> set = new HashSet<>();
        
        while( headA != null ){
            set.add(headA);
            headA = headA.next;
        }
        
        while( headB != null ){
            if( set.contains(headB) ){
                return headB;
            }
            headB = headB.next;
        }
        
        return null;
    }
	
	
	public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        
		int sizeA = size(headA);
		int sizeB = size(headB);
		
		ListNode larger, smaller;
		int diff; 
		
		if( sizeB > sizeA ) {
			larger  = headB;  smaller = headA;
			diff = sizeB - sizeA;
		} else {
			smaller = headB;   larger = headA;
			diff = sizeA - sizeB;
		}
		
		while ( diff-- > 0 && larger != null) {
			larger = larger.next; 
		}
		
		while ( smaller != null && larger != null) {
		
			if( smaller == larger )
				return larger;
			
			smaller = smaller.next;
			larger = larger.next; 
		}
		
		return null;
		
        
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
