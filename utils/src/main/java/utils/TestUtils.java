package utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import org.joda.convert.StringConvert;

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
	 * {@link #org.junit.jupiter.params.provider.CsvSource} into a provided class
	 * array.
	 * <p>
	 * Example of "CSV array writing":
	 * <br>{@code @CsvSource("[3;9;8;2;0]")} <-- CORRECT
	 * <br>{@code @CsvSource("[3,9,8,2,0]")} <-- WRONG
	 * <br>{@code @CsvSource("[3, 9, 8, 2, 0]")} <-- WRONG
	 * <br>{@code @CsvSource("{3;9;8;2;0}")} <-- WRONG
	 * <p>
	 * Notice the <b>';'</b> as delimiter inside the array.
	 */
	public static <T> T[] parseCsvSourceToArray(String csvSource, Class<T> arrClass) {
		csvSource = csvSource.replace("[", "").replace("]", "");
		String[] numStrs = csvSource.split(";");
		T[] array = (T[]) Array.newInstance(arrClass, numStrs.length);

		int index = 0;
		for(String numStr : numStrs) {
			array[index] = StringConvert.INSTANCE.convertFromString(arrClass, numStr);
			index++;
		}
		return array;
	}
}
