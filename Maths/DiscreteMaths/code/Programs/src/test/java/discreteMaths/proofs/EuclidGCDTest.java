package discreteMaths.proofs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EuclidGCDTest {

	@Test
	void testGcd1() {
		assertEquals(2,EuclidGCD.gcd(10,2));
	}

	@Test
	void testGcd2() {
		assertEquals(1,EuclidGCD.gcd(3,7));
	}
	
	@Test
	void testGcd3() {
		assertEquals(14,EuclidGCD.gcd(42,28));
	}
	
	@Test
	void testGcd4() {
		try {
			EuclidGCD.gcd(-42,28);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().contains("is expected to be positive or zero"));
		}
	}
	
	@Test
	void testGcd5() {
		assertEquals(28,EuclidGCD.gcd(0,28));
	}
}
