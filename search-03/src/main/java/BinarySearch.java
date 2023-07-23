import java.util.Comparator;

public class BinarySearch {

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

	private static <T> int determineMonotonicity(T[] array, Comparator<T> comparator) {
		return comparator.compare(array[array.length - 1], array[0]);
	}
}
