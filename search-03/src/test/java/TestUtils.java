import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TestUtils {

	/**
	 * Method returns an {@code Integer} array from specified number
	 * marked as {@code lowerBound} parameter (inclusively) to a
	 * {@code upperBound} parameter (exclusively).
	 */
	public static Integer[] getNumbersFromTo(int lowerBound, int upperBound) {
		int size = upperBound - lowerBound;

		Integer[] nums = new Integer[size];
		for (int i = 0, num = lowerBound; i < size; i++, num++) {
			nums[i] = num;
		}
		return nums;
	}

	public static Integer[] getUniqueRandomArray(int size) {
		Set<Integer> set = new HashSet<>();
		Integer[] array = new Integer[size];

		Random random = new Random();
		int i = 0;
		while (set.size() != size) {
			int range = Integer.MAX_VALUE;
			int num = random.nextInt(range) - range / 2;
			if (set.add(num)) {
				array[i] = num;
				i++;
			}
		}
		return array;
	}

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

			Collections.shuffle(names);
			String[] strarray = names.toArray(new String[0]);
			return strarray;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
