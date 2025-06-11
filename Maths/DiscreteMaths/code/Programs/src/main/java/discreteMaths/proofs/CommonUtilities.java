package discreteMaths.proofs;

public class CommonUtilities {
	
	public static void expectPositive(int a) {
		if(a <= 0)
			throw new IllegalArgumentException(a+" is expected to be positive");
	}
	
	public static void expectPositiveOrZero(int a) {
		if(a < 0)
			throw new IllegalArgumentException(a+" is expected to be positive or zero");
	}
}
