package lambda;

import java.util.function.Function;

public class UseLambda {
	public static void main(String[] args) {
		Function<String,Integer> lenFunc = (String str) -> {return str.length();};
		System.out.println(lenFunc.apply("HuHa"));
		
		sampleLambda();
	}
	
	public static void sampleLambda() {
		Runnable r = () -> System.out.println("Hello World");
		r.run();
	}
}
