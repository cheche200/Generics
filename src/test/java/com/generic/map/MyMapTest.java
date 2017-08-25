package com.generic.map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyMapTest {
	
	private MyMap<String,String> target;
	
	@Before
	public void setup(){
		target = new MyMap<String,String>();
	}
	
	@Test
	public void test_put_success(){		
		
		assertEquals("Hello", target.put("1","Hello"));
		
	}
	
	@Test
	public void test_get_success(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertEquals("Bye", target.get("2"));
	}

	@Test
	public void test_get_notFound(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertEquals(null, target.get("3"));
	}
	
	@Test
	public void test_get_nullKey(){
		target.put(null,"Hello");
		target.put("2", "Bye");
		assertEquals("Hello", target.get(null));
	}
	
	@Test
	public void test_containsKey_success(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertTrue(target.containsKey("1"));
	}
	
	@Test
	public void test_containsKey_notFound(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertFalse(target.containsKey("3"));
	}
	
	@Test
	public void test_containsKey_nullValue(){
		target.put(null,"Hello");
		target.put("2", "Bye");
		assertTrue(target.containsKey(null));
	}
	
	@Test
	public void test_containsValue_success(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertTrue(target.containsValue("Hello"));
	}
	
	@Test
	public void test_containsValue_notFound(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertFalse(target.containsValue("Hey"));
	}
	
	@Test
	public void test_containsValue_nullValue(){
		target.put(null,"Hello");
		target.put("2", null);
		assertTrue(target.containsValue(null));
	}
	
	@Test
	public void test_size_success(){
		target.put("1","Hello");
		target.put("2", "Bye");
		assertEquals(2, target.size());
	}
	
	@Test
	public void test_remove_success(){
		target.put("1","Hello");
		target.put("2", "Bye");
		String actual = target.remove("1");
		assertEquals("Hello", actual);
		assertEquals(1, target.size());
	}
	
	@Test
	public void test_remove_notFound(){
		target.put("1","Hello");
		target.put("2", "Bye");
		String actual = target.remove("3");
		assertEquals(null, actual);
		assertEquals(2, target.size());
	}
	
	@Test
	public void test_remove_null(){
		target.put(null,"Hello");
		target.put("2", "Bye");
		String actual = target.remove(null);
		assertEquals("Hello", actual);
		assertEquals(1, target.size());
	}
	
	
	
	
	
}
