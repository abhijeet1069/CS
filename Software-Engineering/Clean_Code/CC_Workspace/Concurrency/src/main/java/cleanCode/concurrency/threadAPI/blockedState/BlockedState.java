package cleanCode.concurrency.threadAPI.blockedState;

/**
 * Output
 * T1 state = RUNNABLE
	T2 state = BLOCKED
 * */

public class BlockedState {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new DemoBlockedRunnable());
		Thread t2 = new Thread(new DemoBlockedRunnable());
		
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		
		System.out.println("T1 state = "+t1.getState());
		System.out.println("T2 state = "+t2.getState());
		
		System.exit(0);
	}
}

class DemoBlockedRunnable implements Runnable{
	
	public void run() {
		commonResource();
	}
	
	public static synchronized void commonResource() {
		//mimic infinte wait
		while(true);
	}
}
