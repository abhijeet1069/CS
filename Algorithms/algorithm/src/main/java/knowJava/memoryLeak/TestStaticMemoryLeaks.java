package knowJava.memoryLeak;

import java.util.ArrayList;
import java.util.List;

public class TestStaticMemoryLeaks {
	
	//making this static caused a severe memory leak
	public List<Double> list = new ArrayList<>();
	
	public void populateList() {
		for(int i = 0; i < 100000000;i++) {
			list.add(Math.random());
		}
		System.out.println("Check Point 2");
	}
	
	public static void main(String[] args) {
		System.out.println("Check Point 1");
		new TestStaticMemoryLeaks().populateList();
		System.out.println("Check Point 3");
	}
}
