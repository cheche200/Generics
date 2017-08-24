package com.generic.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

class MyListTest<T> extends MyCollection<T>{

	MyListTest() {
		super();
	}	
}

public class MyCollectionTest {
	
	private MyListTest<String> target;
	
	
	@Before
	public void setup() {		
		target = new MyListTest<String>();	    
	}
	
	@Test
	public void test_add_success(){	
		assertTrue(target.add("1"));
		assertEquals(1, target.getSize());
	}
	
	@Test
	public void test_add_fullArray(){		
		target.add("1");
		target.add("2");
		target.add("3");
		target.add("4");
		assertEquals("4", target.get(3));
		assertEquals(4, target.getSize());
	}
	
	@Test
	public void test_get_success(){		
		target.add("1");
		assertEquals("1",target.get(0));
	}
	
	@Test 
	public void test_removeObject_success(){
		target.add("1");
		target.add("2");
		target.add("3");
		target.add("4");
		assertTrue(target.remove("3"));
		assertEquals(3, target.getSize());
		assertEquals("4", target.get(2));
	}
	

	@Test 
	public void test_removeObject_notFound(){
		target.add("1");
		target.add("2");
		target.add("3");
		target.add("4");
		assertFalse(target.remove("6"));
	}
	
	@Test 
	public void test_removeObject_addRemoveNull(){
		target.add(null);
		target.add("2");
		target.add(null);
		target.add("4");
		assertTrue(target.remove(null));
		assertEquals(3, target.getSize());
	}
	
	@Test 
	public void test_removeByIndex_success(){
		target.add(null);
		target.add("2");
		target.add(null);
		target.add("4");
		assertEquals("2",target.remove(1));
		assertEquals(3, target.getSize());
	}
	
	@Test
	public void test_contains_success(){
		target.add("1");
		target.add("2");
		target.add("3");
		target.add("4");
		assertTrue(target.contains("3"));
	}
	
	@Test
	public void test_contains_notFound(){
		target.add("1");
		target.add("2");
		target.add("3");
		target.add("4");
		assertFalse(target.contains("6"));
	}
	
	@Test
	public void test_set_success(){
		target.add("1");
		target.add("2");
		target.add("3");
		target.add("4");
		assertEquals("2",target.set(1,"6"));
	}

}
