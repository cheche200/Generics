package com.generic.collection;

public class MySet<T> extends MyCollection<T> {

	@Override
	public boolean add(T e) {
		if (!contains(e)) {
			return super.add(e);
		}else{
			return false;
		}
	}
}
