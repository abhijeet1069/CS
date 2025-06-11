package hof;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class HigherOrderFunctions {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		processList(numbers,x->x*x);

	}

	static void processList(List<Integer> numbers, Function<Integer,Integer> operation) {
		for (Integer number : numbers) {
			Integer result = operation.apply(number);
			System.out.print(result + " ");
		}
		System.out.println();
	}
	
	public static Integer square(int x) {
		return x*x;
	}
}
