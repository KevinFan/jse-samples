package com.kevinfan.sample.java8.algo;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Kevin Fan
 */
public class ConsistentHashing<T> {
    public static final int DEFAULT_REPLICAS = 150;

    /**
     * number of virtual node
     */
    private int             replicas         = DEFAULT_REPLICAS;
    private Map<Integer, T> circle           = new TreeMap<Integer, T>();
    private Hash            hash;

    public ConsistentHashing(Hash hash) {
        this(DEFAULT_REPLICAS, hash);
    }

    public ConsistentHashing(int replicas, Hash hash) {
        this(replicas, hash, null);
    }

    public ConsistentHashing(int replicas, Hash hash, Collection<T> nodes) {
        this.replicas = replicas;
        this.hash = hash;
        if (nodes != null) {
            for (T node : nodes) {
                addNode(node);
            }
        }
    }

    public void addNode(T node) {
        for (int i = 0; i < replicas; ++i) {
            circle.put(hash.hash(node), node);
        }
    }

    public void removeNode(T node) {
    }

    @FunctionalInterface
    public static interface Hash {
        int hash(Object obj);
    }
}
