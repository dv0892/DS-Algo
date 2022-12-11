package test.app.linkedlist;

public class OddEvenLinkedList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Test test = new Test();
		new Thread(() -> {
			try {
				test.method1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} ).start();
		new Thread(() -> {
			try {
				test.method2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} ).start();
	}
	
	public ListNode oddEvenList(ListNode head) {

        if( head == null || head.next == null )
            return head;


        ListNode curr , oddList , evenList , evenHead ;
        curr = oddList = head;
        evenHead = evenList = head.next;
        curr = curr.next.next;

        while( curr!= null && curr.next!=null ){
            ListNode next = curr.next.next;
            // For odd List
            oddList.next = curr;
            oddList = curr;

            // For even List
            evenList.next = curr.next;
            evenList = curr.next;
                               
            curr = next;
        }

        // In case list size is odd, attaching last odd element
        if( curr != null ) {
            oddList.next = curr;
            oddList = curr;
        }
        evenList.next = null;        
       
        // Attaching even to odd
        oddList.next = evenHead;

        return head;
        
    }

}


class Test {
	public synchronized void method1() throws InterruptedException {
		System.out.println("A");
		Thread.sleep(10000);
		System.out.println("A1");
	}
	
	public synchronized void method2() throws InterruptedException {
		System.out.println("b");
		Thread.sleep(10000);
		System.out.println("b1");
	}
}



