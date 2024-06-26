package org.example.dsa;


/**
 * A class of bags whose entries are stored in a fixed-size array.
 */

public class ArrayBag<E> implements BagInterface<E> {



    private final E[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;

    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given initial capacity.
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            E[] tempBag = (E[]) new Object[desiredCapacity]; // Unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end constructor

    /** Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not. 
     */
    public boolean add(E newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else { // Assertion: result is true here
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } // end if
        return result;
    } // end add

    /** Throws an exception if this object is not initialized.
     */
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("ArrayBag object is not initialized properly.");
    }
    
    /** Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag. 
     */

    public final E[] toArray() {


        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        E[] result = (E[]) new Object[numberOfEntries]; // unchecked cast
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        } // end for
        return result;
    } // end toArray
/*
    public T[] toArray() {
    @SuppressWarnings("unchecked")
    T[] result = (T[]) java.lang.reflect.Array.newInstance(bag.getClass().getComponentType(), numberOfEntries);
    System.arraycopy(bag, 0, result, 0, numberOfEntries);
    return result;
}
    */

    /** Sees whether this bag is full.
     * @return True if the bag is full, or false if not. 
     */
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    } // end isArrayFull

    /** Sees whether this bag is empty.
     * @return True if the bag is empty, or false if not. 
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    /** Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag. 
     */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

    /** Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag. 
     */
    public int getFrequencyOf(E anEntry) {
        checkInitialization();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            } // end if
        } // end for
        return counter;
    } // end getFrequencyOf

    /** Tests whether this bag contains a given entry.
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not. 
     */
    public boolean contains(E anEntry) {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
    } // end contains

    /** Removes all entries from this bag. */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    } // end clear

    /** Removes one unspecified entry from this bag, if possible.
     * @return Either the removed entry, if the removal was successful, or null if otherwise. 
     */
    public E remove() {
        checkInitialization();
        E result = removeEntry(numberOfEntries - 1);

        return result;
    } // end remove

    /** Removes one occurrence of a given entry from this bag.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not. 
     */
    public boolean remove(E anEntry) {
        checkInitialization();
        int index = getIndexOf(anEntry);
        E result = removeEntry(index);
        return anEntry.equals(result);
    } // end remove

    /** Removes and returns the entry at a given array index within the array bag.
     * If no such entry exists, returns null.
     * Preconditions: 0 <= givenIndex < numberOfEntries;
     *                  checkInitialization has been called.
     */
    private E removeEntry(int givenIndex) {
        E result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];                   // entry to remove
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
            bag[numberOfEntries - 1] = null;            // remove last entry
           numberOfEntries--;
         } // end if
        return result;
    } // end removeEntry

    /** Locates a given entry within the array bag.
     * Returns the index of the entry, if located, or -1 otherwise.
     * Precondition: checkInitialization has been called.
     */
    private int getIndexOf(E anEntry) {
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while ( stillLooking && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                stillLooking = false;
                where = index;
            } // end if
            index++;
        } // end for
        // Assertion: If where > -1, anEntry is in the array bag, and it
        // equals bag[where]; otherwise, anEntry is not in the array
        return where;
    } // end getIndexOf
    
    
    /** Override the toString() method so that we get a more useful display of
     *  the contents in the bag.
     * @return a string representation of the contents of the bag 
     */
    public String toString() {
        String result = "Bag[ ";
        for (int index = 0; index < numberOfEntries; index++) {
            result += bag[index] + " ";
        } // end for
        result += "]";
        return result;
    } // end toString
    
    
    /**
 * Sets the entry at a specific index in the bag to a new entry.
 * @param index The index at which to set the new entry.
 * @param newEntry The new entry to set at the specified index.
 * @return True if the update was successful, or false if the index is invalid.
 */
public boolean set(int index, E newEntry) {
    checkInitialization();
    
    // Check if the index is within the bounds of the array
    if (index >= 0 && index < numberOfEntries) {
        // Update the entry at the specified index
        bag[index] = newEntry;
        return true;
    } else {
        // Return false if the index is invalid
        return false;
    }
}

} // end ArrayBag
