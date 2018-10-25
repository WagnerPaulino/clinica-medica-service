package com.clinicaMedica.utils;

import java.util.HashMap;
import java.util.Map;

public class CacheUtil<K, V> {	
	
	private Map<K, V> mapCache;
	
	public CacheUtil() {
		if(mapCache == null) {
			mapCache = new HashMap<K, V>();
		}
	}
	
	public void setCacheValue(K key, V value) {
		this.mapCache.put(key, value);
	}
	
	public V getCacheValue(K key) {
		return this.mapCache.get(key);
	}
	
	public void clearCacheValue(K key) {
		this.mapCache.remove(key);
	}
	
}
