package test.app.linkedList;

public class LeetCode147 {
	
	public static void main(String... args) {
		
		ListNode l5  = new ListNode(0,null);
		ListNode l4  = new ListNode(4,l5);
		ListNode l3  = new ListNode(3,l4);
		ListNode l2  = new ListNode(5,l3);
		ListNode l1  = new ListNode(-1,l2);
		
		LeetCode147 sol = new LeetCode147();
		Solution.iterate(l1);
		System.out.println("Insertion Sort..");
		Solution.iterate(sol.insertionSort(l1));;
	}

	public ListNode insertionSort(ListNode key){
        
        if(key.next == null){
            return key;
        }
        
        ListNode sortedList =  insertionSort(key.next);
        ListNode curr = sortedList;
        ListNode prev = null;
        
        while(curr != null && key.val > curr.val ){
            prev = curr;
            curr = curr.next;
        }
        
        if(prev == null) {
        	key.next = curr;
        	return key;
        } else {
        	prev.next = key;
        	key.next  = curr;
        	
        	return sortedList;
        }
        
    }
}
