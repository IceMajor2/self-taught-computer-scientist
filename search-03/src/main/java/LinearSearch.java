/**
 * Class with linear search implementation.
 * <p>
 * Linear search is best used on a relatively
 * small data sets that are unsorted.
 * @author IceMajor
 */
public class LinearSearch {

	/**
	 * Call this method to search for a desired element.
	 * Implementation: <b>linear search</b>.
	 * @param array data set as array
	 * @param object element to look for
	 * @return {@code object} if it was found, {@code null} if not
	 */
	public static <T> T get(T[] array, T object) {
		for(T element : array) {
			if(element.equals(object)) {
				return object;
			}
		}
		return null;
	}
}
