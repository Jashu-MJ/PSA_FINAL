/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dsa;

/**
 *
 * @author srushtyr
 */

/**
 * A class of priority queues implemented using a doubly linked list.
 * The elements are ordered based on their priority.
 */
public class DoublyLinkedListPriorityQueue<T extends Comparable<T>> {

    // Node representing an element in the doubly linked list
    private class Node {
        private T data;
        private Node prev;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Creates an empty priority queue.
     */
    public DoublyLinkedListPriorityQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the priority queue based on its priority.
     * The queue maintains elements in order of decreasing priority.
     * @param element The element to add.
     * @return True if the addition is successful.
     */
    public boolean add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            // If the queue is empty, the new node becomes both the head and tail
            head = newNode;
            tail = newNode;
        } else if (head.data.compareTo(element) < 0) {
            // Insert new element at the front if it has higher priority than the head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            // Find the correct position to insert the new element
            Node current = head;
            while (current.next != null && current.next.data.compareTo(element) >= 0) {
                current = current.next;
            }
            // Insert new element after current
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                // If inserting at the end, update the tail
                tail = newNode;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes and returns the element with the highest priority (the head of the list).
     * @return The element with the highest priority, or null if the queue is empty.
     */
    public T remove() {
        if (head == null) {
            return null; // Priority queue is empty
        }
        T highestPriority = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            // If the list becomes empty, reset the tail as well
            tail = null;
        }
        size--;
        return highestPriority;
    }

    /**
     * Returns true if the priority queue is empty.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of elements in the priority queue.
     * @return The number of elements in the queue.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a string representation of the priority queue.
     * @return A string representation of the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PriorityQueue[ ");
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

