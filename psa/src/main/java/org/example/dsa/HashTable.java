package org.example.dsa;

/**
 * A simple generic hash table implementation using separate chaining for collision resolution.
 */
public class HashTable<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V>[] table;
    private int capacity; // size of the table
    private int size; // number of key-value pairs in the hash table

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = (Node<K, V>[]) new Node[capacity];
        this.size = 0;
    }

    private int getHash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public V get(K key) {
        int index = getHash(key);
        for (Node<K, V> x = table[index]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        for (Node<K, V> x = table[index]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        table[index] = new Node<>(key, value, table[index]);
        size++;
    }

    public V remove(K key) {
        int index = getHash(key);
        Node<K, V> prev = null;
        for (Node<K, V> x = table[index]; x != null; prev = x, x = x.next) {
            if (key.equals(x.key)) {
                if (prev != null) {
                    prev.next = x.next;
                } else {
                    table[index] = x.next;
                }
                size--;
                return x.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
