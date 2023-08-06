package utils;

import java.util.Arrays;
import java.util.Random;

public class TestUtils {

	/**
	 * Method returns an {@code Integer} array from specified number
	 * marked as {@code lowerBound} parameter (inclusively) to a
	 * {@code upperBound} parameter (exclusively).
	 * Numbers are returned in ascending order.
	 */
	public static Integer[] getNumbersFromTo(int lowerBound, int upperBound) {
		int size = upperBound - lowerBound;

		Integer[] nums = new Integer[size];
		for (int i = 0, num = lowerBound; i < size; i++, num++) {
			nums[i] = num;
		}
		return nums;
	}

	/**
	 * Produces an {@code Integer} array of {@code size} with
	 * random integers.
	 * <p>
	 * (based on: {@code random.nextInt(8232658) - 523980})
	 */
	public static Integer[] getBigArray(int size) {
		Integer[] ints = new Integer[size];
		for (int i = 0; i < ints.length; i++) {
			Random random = new Random();
			Integer randNum = random.nextInt(8232658) - 523980;
			ints[i] = randNum;
		}
		return ints;
	}

	/**
	 * Method will parse an array given in
	 * {@link #org.junit.jupiter.params.provider.CsvSource} into an {@code Integer}
	 * array.
	 * <p>
	 * Example:
	 * -@CsvSource("[3;9;8;2;0]") will be parsed into an int array.
	 * {@code {3, 9, 8, 2, 0}}.
	 * <p>
	 * <b>Note</b> the ';' as delimiter inside the array. It's required.
	 */
	public static Integer[] parseCsvSourceToIntegerArray(String csvSource) {
		csvSource = csvSource.replace("[", "").replace("]", "");
		String[] strNums = csvSource.split(";");
		Integer[] intArray = new Integer[strNums.length];
		int index = 0;
		for (String strNum : strNums) {
			intArray[index] = Integer.valueOf(strNum);
			index++;
		}
		return intArray;
	}

	public static int[] parseCsvSourceToIntArray(String csvSource) {
		Integer[] integers = parseCsvSourceToIntegerArray(csvSource);
		return Arrays.stream(integers).mapToInt(i -> i).toArray();
	}
}
