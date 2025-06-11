package cleanCode.concurrency.threadAPI.implementRunnable;


public class Main {
	public static void main(String[] args) {
		A obj1 = new A();
		B obj2 = new B();
		
		new Thread(obj1).start();
		new Thread(obj2).start();
	}
}

class A implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++)
			System.out.println("Hi");
	}
}

class B implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++ )
			System.out.println("Hello");
	}
}