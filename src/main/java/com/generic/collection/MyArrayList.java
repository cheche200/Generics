package com.generic.collection;

public class MyArrayList<T> extends MyCollection<T> {
	
	
	@SuppressWarnings("unchecked")
	public T add(int n, Object o){
		checkRange(n);
		ensureCapacity(index+n);
		Object oldObject = array[n];
		System.arraycopy(array, n, array, n + 1, index - n);
		array[n]=o;
		return (T) oldObject;
	}

}
