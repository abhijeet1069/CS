package discreteMaths.proofs;

public class EuclidGCD {
	public static int gcd(int a, int b) {
		CommonUtilities.expectPositiveOrZero(a);
		CommonUtilities.expectPositiveOrZero(b);
		int r = b;
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
