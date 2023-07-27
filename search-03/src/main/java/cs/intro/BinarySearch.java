package cs.intro;

import java.util.Comparator;

/**
 * Binary search is significantly faster than
 * linear search, but its drawback is its requirement.
 * Namely, each array must be sorted according to
 * some logic (i.e. comparator). Otherwise, it may very
 * likely return a wrong answer.
 */
public class BinarySearch {

	/**
	 * Perform a binary search on a sorted (no matter whether
	 * in ascending or descending order) array. You provide
	 * sorting logic by specifying a {@code Comparator} object.
	 * Result is an index of the object of interest or {@code null},
	 * if it hasn't been found in the array.
	 * <p>
	 * <b>Note:</b> method does not throw any exception on receiving
	 * an unsorted array, however it is very likely that the result
	 * will be wrong.
	 * @param array sorted array of objects
	 * @param searchFor object to search for
	 * @param comparator sorting logic
	 * @return index of found object, or null if object hasn't been found
	 */
	public static <T> Integer get(T[] array, T searchFor, Comparator<T> comparator) {
		int monotonicity = determineMonotonicity(array, comparator);
		int left = 0;
		int right = array.length - 1;
		int middle = (left + right) / 2;

		T currElement = array[middle];
		int result = comparator.compare(currElement, searchFor);
		while (result != 0) {
			if (result > 0) {
				if (monotonicity >= 1) right = middle - 1;
				else left = middle + 1;
				if((left + right) / 2 == middle) return null;
				middle = (left + right) / 2;
			}
			if (result < 0) {
				if (monotonicity >= 1) left = middle + 1;
				else right = middle - 1;
				if((left + right) / 2 == middle) return null;
				middle = (left + right) / 2;
			}
			currElement = array[middle];
			result = comparator.compare(currElement, searchFor);
		}
		return middle;
	}

	/**
	 * Method compares only the first and last object according to
	 * logic defined by {@code Comparator}.
	 * <p>
	 * Assuming the array <i>is</i> sorted, the method returns a negative
	 * number if its monotonicity is descending, positive number if
	 * it is ascending and 0 if all the values in an array are the same.
	 */
	private static <T> int determineMonotonicity(T[] array, Comparator<T> comparator) {
		return comparator.compare(array[array.length - 1], array[0]);
	}
}
