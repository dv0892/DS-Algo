package test.app.concurrency;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// Testing Callable : It can be submitted only with executors.
		Callable<Integer> c1 = () -> {
			System.out.println("Thread R1 started ... ");
			Thread.interrupted();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				return -1;
			}
			
			System.out.println("Thread R1 Completed... ");
			return 1;
		} ;
		
		/*Thread t1 = new Thread(c1); Won't work with callable
		t1.start();;
		Thread.sleep(3000);
		t1.interrupt();*/
		
		/*Future<Integer> res = Executors.newFixedThreadPool(1).submit(c1);
		System.out.print(res.isDone());
		Thread.sleep(10000);
		System.out.print(res.get());
		*/
		
		
		// Semaphore:
		Semaphore sc = new Semaphore(5);
		
		ExecutorService service = Executors.newFixedThreadPool(1000) ;
		for( int i=1 ;i<=10 ;i++) {
			service.execute(() -> {
				try {
					if( sc.tryAcquire(1,TimeUnit.SECONDS) ) {
						Thread.sleep(5000);
						sc.release();
						System.out.println( Thread.currentThread().getName() + " released permit ");
					} else {
						System.out.println( Thread.currentThread().getName() + " couldn't accquire permit ");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} ) ;
		}
		
		// Read Write Lock
		ReadWriteLock rw ;
		CountDownLatch latch;
		
		
		
		
	}
	
	

}
