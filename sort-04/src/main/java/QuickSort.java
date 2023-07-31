import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 8, 3, 5, 7, 6 };
		sort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int begin, int end) {
		if (begin < end) {
			int res = partition(array, begin, end);

			sort(array, begin, res - 1);
			sort(array, res + 1, end);
		}
	}

	private static int partition(int[] array, int begin, int end) {
		int j = begin - 1;
		int pivot = array[end];
		for (int i = begin; i <= end - 1; i++) {
			int num = array[i];
			if (num < pivot) {
				j++;
				swap(array, i, j);
			}
		}
		swap(array, end, j + 1);
		return j + 1;
	}

	private static void swap(int[] array, int swap, int swapWith) {
		int helper = array[swapWith];
		array[swapWith] = array[swap];
		array[swap] = helper;
	}
}
