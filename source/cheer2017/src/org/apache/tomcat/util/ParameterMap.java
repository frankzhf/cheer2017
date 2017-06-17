package org.apache.tomcat.util;

import java.util.HashMap;
import java.util.Map;

public class ParameterMap<K, V> extends HashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6259327217332909092L;
	private boolean locked = false;

	public ParameterMap() {
		super();
	}

	public ParameterMap(int initialCapacity) {
		super(initialCapacity);
	}

	public ParameterMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public ParameterMap(Map<K, V> map) {
		super(map);
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	private static final StringManager sm = StringManager.getManager("org.apache.catalina.util");

	public void clear() {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		super.clear();
	}

	public V put(K key, V value) {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		return (super.put(key, value));
	}

	public void putAll(Map<? extends K, ? extends V> map) {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		super.putAll(map);
	}

	public V remove(Object key) {
		if (locked)
			throw new IllegalStateException(sm.getString("parameterMap.locked"));
		return (super.remove(key));
	}

}
