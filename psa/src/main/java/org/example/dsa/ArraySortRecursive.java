package org.example.dsa;

/**
   A class of static, recursive methods for sorting an array of
   Comparable objects from smallest to largest (includes only the 
   recursive merge sort and quick sort here, plus insertion sort
   as part of the quick sort algorithm).
 */

public class ArraySortRecursive
{
	public static final int MIN_SIZE = 5; // For quick sort

	// -------------------------------------------------------------------------------

	// MERGE SORT
	/** Sorts a given array into ascending order. 
		@param a  The given array.
		@param n  The number of entries in the array to be sorted. */
	public static <T extends Comparable<? super T>>
			void mergeSort(T[] a, int n)
	{
		mergeSort(a, 0, n - 1);
	} // end mergeSort

	public static <T extends Comparable<? super T>>
			void mergeSort(T[] a, int first, int last)
	{
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[])new Comparable<?>[a.length]; // Unchecked cast
		mergeSort(a, tempArray, first, last);
	} // end mergeSort

	private static <T extends Comparable<? super T>>
			void mergeSort(T[] a, T[] tempArray, int first, int last)
	{
		if (first < last)
		{  // Sort each half
			int mid = first + (last - first) / 2;  // Index of midpoint
			mergeSort(a, first, mid);		// Sort left half array[first..mid]
			mergeSort(a, mid + 1, last);	// Sort right half array[mid+1..last]

			merge(a, tempArray, first, mid, last);  // Merge the two halves
		}  // end if
	}  // end mergeSort

	private static <T extends Comparable<? super T>> 
			void merge(T[] a, T[] tempArray, int first, int mid, int last)
	{
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both subarrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{  // Invariant: tempArray[beginHalf1..index-1] is in order

			if (a[beginHalf1].compareTo(a[beginHalf2]) < 0)
			{  
				tempArray[index] = a[beginHalf1];
				beginHalf1++;
			}
			else
			{  
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			}  // end if
		}  // end for

		// Finish off the nonempty subarray

		// Finish off the first subarray, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = a[beginHalf1];

		// Finish off the second subarray, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = a[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++)
			a[index] = tempArray[index];
	}  // end merge

} // end ArraySortRecursive
