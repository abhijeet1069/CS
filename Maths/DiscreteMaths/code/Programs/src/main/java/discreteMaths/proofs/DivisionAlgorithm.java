package discreteMaths.proofs;

public class DivisionAlgorithm {
	
	public static Pair<Integer> divide(int a, int d){
		CommonUtilities.expectPositive(a);
		CommonUtilities.expectPositive(d);
		int q = 0;
		int r = a;
		while(r >= d) {
			r = r-d;
			q = q+1;
		}
		Pair<Integer> result = new Pair<>(q,r);
		return result;
	}
	
	
}

class Pair<T> {
    public final T quotient;
    public final T remainder;

    public Pair(T quotient, T remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }

	public T getQuotient() {
		return quotient;
	}

	public T getRemainder() {
		return remainder;
	}
}
