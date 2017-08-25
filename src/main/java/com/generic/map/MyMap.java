package com.generic.map;

import com.generic.collection.*;

public class MyMap<K, V> {

	MyArrayList<Entry<K, V>> map;

	class Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		private MyMap getOuterType() {
			return MyMap.this;
		}

	}

	MyMap() {
		map = new MyArrayList<Entry<K, V>>();
	}

	public V put(K k, V v) {
		Entry<K, V> newEntry = new Entry<K, V>(k, v);
		map.add(newEntry);
		return v;
	}

	public V get(K k) {
		if (k == null) {
			for (int i = 0; i < map.getSize(); i++) {
				if (map.get(i).key == null) {
					return map.get(i).value;
				}
			}
		} else {
			for (int i = 0; i < map.getSize(); i++) {
				if (map.get(i).key.equals(k)) {
					return map.get(i).value;
				}
			}
		}
		return null;
	}

	public boolean containsKey(K k) {
		if (k == null) {
			for (int i = 0; i < map.getSize(); i++) {
				if (map.get(i).key == null) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < map.getSize(); i++) {
				if (map.get(i).key.equals(k)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsValue(V v) {
		if (v == null) {
			for (int i = 0; i < map.getSize(); i++) {
				if (map.get(i).value == null) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < map.getSize(); i++) {
				if (map.get(i).value.equals(v)) {
					return true;
				}
			}
		}
		return false;
	}

	public int size() {
		return map.getSize();
	}

	public V remove(K k) {
		if (containsKey(k)) {
			V oldValue = get(k);
			if (k == null) {
				for (int i = 0; i < map.getSize(); i++) {
					if (map.get(i).key == null) {
						map.remove(i);
						return oldValue;
					}
				}
			} else {
				for (int i = 0; i < map.getSize(); i++) {
					if (map.get(i).key.equals(k)) {
						map.remove(i);
						return oldValue;
					}
				}
			}
			return null;
		}else{
			return null;
		}

	}

}
