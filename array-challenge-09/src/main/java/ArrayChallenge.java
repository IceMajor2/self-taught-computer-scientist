/**
 * Class includes a solution to challenge from the 9th chapter.
 */
public class ArrayChallenge {

	public static int[] sort(int[] array) {
		int[] sorted = new int[array.length];
		int right = array.length - 1;
		int left = 0;
		for (int i = 0; i < array.length; i++) {
			if (isEven(array[i])) {
				sorted[left] = array[i];
				left++;
			}
			else {
				sorted[right] = array[i];
				right--;
			}
		}
		partReverse(sorted, right + 1, array.length - 1);
		return sorted;
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void partReverse(int[] array, int from, int to) {
		while (from < to) {
			swap(array, to, from);
			to--;
			from++;
		}
	}

	private static void swap(int[] array, int index1, int index2) {
		int helper = array[index1];
		array[index1] = array[index2];
		array[index2] = helper;
	}
}
