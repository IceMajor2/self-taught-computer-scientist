package cs.intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	 * Method requires a file of {@code 'first-names.txt'} signature
	 * located in {@code resources} folder under {@code test} directory
	 * ({@code /src/test/resources}). It will try to fetch all the strings
	 * specified in the file (if their number is less than
	 * {@code Integer.MAX_VALUE}). If you want to limit it to a certain number,
	 * refer to {@link #getNames(int)}
	 */
	public static String[] getNames() {
		return getNames(Integer.MAX_VALUE);
	}

	/**
	 * Same as {@link #getNames()} but providing it with a number
	 * limits the returned array size.
	 */
	public static String[] getNames(int howMany) {
		File namesTxt = new File(Paths.get("src\\test\\resources\\first-names.txt").toUri());

		try (Scanner scanner = new Scanner(namesTxt)) {

			List<String> names = new ArrayList<>();
			int index = 0;
			while (scanner.hasNext() && index < howMany) {
				String nextName = scanner.next();
				names.add(nextName);
				index++;
			}

			String[] strarray = names.toArray(new String[0]);
			return strarray;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
