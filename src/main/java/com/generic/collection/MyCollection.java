package com.generic.collection;

public abstract class MyCollection<T> {

	protected Object[] array;
	protected int index;

	MyCollection() {
		this.array = new Object[2];
	}

	public boolean add(T e) {

		if (index < array.length) {
			array[index] = e;
			this.index++;
		} else {
			ensureCapacity(index + 1);
			array[index] = e;
			this.index++;
		}
		return true;
	}

	public void ensureCapacity(int n) {
		if (n > array.length) {
			Object[] newArray = new Object[n];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			this.array = newArray;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public T get(int n) {
		return (T) array[n];
	}

	public int getSize() {
		return index;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					removeItem(i);
					return true;
				}
			}
		} else {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(o)) {
					removeItem(i);
					return true;
				}
			}
		}

		return false;
	}

	protected void removeItem(int i) {
		int numMoved = index - i - 1;
		if (numMoved > 0)
			System.arraycopy(array, i + 1, array, i, numMoved);
		array[--index] = null;
	}

	public T remove(int n) {
		checkRange(n);
		T e = get(n);
		removeItem(n);
		return e;
	}

	protected void checkRange(int n) {
		if (n >= index || index < 0) {
			throw new IndexOutOfBoundsException("Index out of bound" + n);
		}

	}

	public boolean isEmpty() {
		return index > 0;
	}

	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		index = 0;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < index; i++) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < index; i++) {
				if (array[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public T set(int n, Object o) {
		checkRange(n);
		Object oldObject = array[n];
		array[n] = o;
		return (T) oldObject;
	}

}
