package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.putIfAbsent(key, new SoftReference<>(value));
    }

    public V get(K key) {
        SoftReference<V> ref = cache.getOrDefault(key, new SoftReference<>(null));
        V rsl = ref.get();
        if (rsl == null) {
            rsl = load(key);
            put(key, rsl);
        }
        return rsl;
    }

    protected abstract V load(K key);
}
