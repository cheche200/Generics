package com.generic.collection;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
	
	private MyArrayList<String> target;
	
	@Before
	public void setup(){
		target = new MyArrayList<String>();
	}
	
	@Test
	public void test_add_especificPosition_success(){
		target.add("1");
		target.add("2");
		target.add("3");
	    assertEquals("2", target.add(1, "New 2"));
	    assertEquals(3, target.getSize());
		
	}
	

}
