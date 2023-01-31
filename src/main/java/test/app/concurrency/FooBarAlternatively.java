package test.app.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarAlternatively {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FooBar fooBarObj = new FooBar(5);
		ExecutorService threadService = Executors.newFixedThreadPool(2);
		
		Runnable fooPrint =  () -> System.out.print("Foo");;
		Runnable barPrint =  () -> System.out.println("Bar");;
		
		threadService.execute(() -> {
			try {
				fooBarObj.foo(fooPrint );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		threadService.execute(() -> {
			try {
				fooBarObj.bar(barPrint );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
	}

}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    ReentrantLock lock = new ReentrantLock();
    Condition barWaiting = lock.newCondition();
    Condition fooWaiting = lock.newCondition();

    volatile boolean  fooDisplayed = false;
    volatile boolean  barDisplayed = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	lock.tryLock();
                while( !barDisplayed && fooDisplayed )
                    fooWaiting.await();
        	    printFoo.run();
                barDisplayed = false;
                fooDisplayed = true;
                barWaiting.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) { 
            lock.tryLock();
                while( !fooDisplayed && barDisplayed)
                    barWaiting.await();            
                printBar.run();
                barDisplayed = true;
                fooDisplayed = false;
                fooWaiting.signal();
            lock.unlock();
        	
        }
    }
}
