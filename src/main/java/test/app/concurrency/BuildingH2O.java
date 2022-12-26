package test.app.concurrency;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BuildingH2O {

	public static void main(String[] args) throws Exception {
		
		String water = "HHHHOO";
		ExecutorService service = Executors.newFixedThreadPool(water.length());
		
		Runnable releaseHydrogen = () -> System.out.print("H");
		Runnable releaseOxygen   = () -> System.out.print("O");
		
		H2O obj = new H2O();
		
		for( int len=0;len<water.length();len++) {
			if('H' == water.charAt(len)) {
				service.execute(()->{
					try { obj.hydrogen(releaseHydrogen); }
					catch (InterruptedException e) {	e.printStackTrace(); }
				});
			} else
				service.execute(()->{
					try { obj.oxygen(releaseOxygen); }
				    catch (InterruptedException e) { e.printStackTrace(); } 
				});
		}
		
		//Thread.sleep(1000);
		
		//System.out.println(Arrays.toString( ManagementFactory.getThreadMXBean().dumpAllThreads(true, true)) );
		
		//System.out.println( obj.hCount);

	}

}

class H2O {

    ReentrantLock lock = new ReentrantLock();
    Condition hydroCondition = lock.newCondition();
    Condition oxyCondition = lock.newCondition();
    volatile int hCount ;
    public H2O() {
    	hCount = 2;
    	//System.out.println(hydroCondition);
    	//System.out.println(oxyCondition);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        lock.lock();
        	//System.out.println( "Locked Hydrogen");
            while( hCount == 0 ) {
                hydroCondition.await();
            }
            
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            --this.hCount;
            //System.out.println(this.hCount);
            // wake up oxygen threads
            if(this.hCount == 0 )
                oxyCondition.signal();

        lock.unlock();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        lock.lock();
            while( hCount > 0 )
                oxyCondition.await();

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            //System.out.println(Arrays.toString( ManagementFactory.getThreadMXBean().dumpAllThreads(true, true)) );
            //System.out.println(this.hCount);
            // wake up hydrogen threads
            hCount = 2;
            hydroCondition.signalAll();

        lock.unlock();
    }
    
    
}
