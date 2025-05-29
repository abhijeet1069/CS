package ds.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DictionaryTest {

	@Test
	void testPut() {
		Dictionary<String,Integer> dict = new Dictionary<>();
		dict.put("One", 1);
		dict.put("Two", 2);
		dict.put("Three", 3);
		dict.remove("One");
		System.out.println(dict);
		assertTrue("{Two=2, Three=3}".equals(dict.toString()));
	}

	@Test
	void testGet() {
		Dictionary<String,Integer> dict = new Dictionary<>();
		dict.put("One", 1);
		dict.put("Two", 2);
		dict.put("Three", 3);
		assertEquals(3,dict.get("Three"));
	}

	@Test
	void testRemove() {
		Dictionary<String,Integer> dict = new Dictionary<>();
		assertEquals(null,dict.remove("One"));
	}

	@Test
	void testGetSize() {
		Dictionary<String,Integer> dict = new Dictionary<>();
		dict.put("One", 1);
		dict.put("Two", 2);
		dict.put("Three", 3);
		dict.remove("One");
		assertEquals(2,dict.getSize());
	}

}
