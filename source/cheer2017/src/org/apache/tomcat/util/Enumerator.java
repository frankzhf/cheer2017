package org.apache.tomcat.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public final class Enumerator<E> implements Enumeration<E> {
	
	private Iterator<E> iterator = null;
	
	public Enumerator(Collection<E> collection){
		this(collection.iterator());
	}
	
	public Enumerator(Iterator<E> iterator){
		this.iterator = iterator;
	}
	
	public Enumerator(Map<String,E> map) {
		this(map.values().iterator());
	}
	
	
	@Override
	public boolean hasMoreElements() {
		return (iterator.hasNext());
	}

	@Override
	public E nextElement() {
		return (iterator.next());
	}

}
