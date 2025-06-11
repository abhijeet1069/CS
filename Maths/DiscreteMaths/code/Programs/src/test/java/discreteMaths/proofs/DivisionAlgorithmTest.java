package discreteMaths.proofs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionAlgorithmTest {

	@Test
	void testDivide1() {
		Pair<Integer> result = DivisionAlgorithm.divide(10, 2);
		assertEquals(5, result.getQuotient());
		assertEquals(0, result.getRemainder());
	}
	
	@Test
	void testDivide2() {	
		try {
			Pair<Integer> result = DivisionAlgorithm.divide(10, -2);
			assertEquals(-5, result.getQuotient());
			assertEquals(0, result.getRemainder());
		}
		catch(Exception e) {
			assertTrue(e.getMessage().contains("is expected to be positive"));
		}
	}
	
	@Test
	void testDivide3() {	
		try {
			Pair<Integer> result = DivisionAlgorithm.divide(53, 32);
			assertEquals(1, result.getQuotient());
			assertEquals(21, result.getRemainder());
		}
		catch(Exception e) {
			assertTrue(e.getMessage().contains("is expected to be positive"));
		}
	}

}
