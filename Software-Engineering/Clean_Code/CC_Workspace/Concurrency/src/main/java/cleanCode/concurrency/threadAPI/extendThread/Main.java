package cleanCode.concurrency.threadAPI.extendThread;

public class Main {
	public static void main(String[] args) {
		A obj1 = new A();
		B obj2 = new B();
		
		obj1.start(); //referee main signals all threads to start
		obj2.start();
	}
}

class A extends Thread{
	public void run() { //threads start running
		for(int i = 0; i < 100; i++)
			System.out.println("Hi");
	}
}

class B extends Thread{
	public void run() {
		for(int i = 0; i < 100; i++ )
			System.out.println("Hello");
	}
}