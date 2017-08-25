package com.generic.collection;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class MySetTest {

	private MySet<String> target;

	@Before
	public void setup() {
		target = new MySet<String>();
	}

	@Test
	public void test_add_duplictated() {
		target.add("1");
		target.add("2");
		target.add("3");
		
		assertFalse(target.add("3"));

	}

}
