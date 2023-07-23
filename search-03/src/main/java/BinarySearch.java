

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] reverted = new int[] { 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 7; i >= 0; i--) {
			System.out.println("Znajdź %d-kę".formatted(array[i]));
			System.out.println("Znalazłem. Indeks szukanej liczby to: %d"
					.formatted(get(array, array[i])));
		}

		for (int i = 7; i >= 0; i--) {
			System.out.println("Znajdź %d-kę".formatted(reverted[i]));
			System.out.println("Znalazłem. Indeks szukanej liczby to: %d"
					.formatted(get(reverted, reverted[i])));
		}
	}

	public static int get(int[] array, int searchFor) {
		int monotonicity = determineMonotonicity(array);
		int left = 0;
		int right = array.length - 1;
		int middle = (left + right) / 2;

		int currElement = array[middle];
		while (currElement != searchFor) {
			if (currElement > searchFor) {
				if (monotonicity == 1) right = middle - 1;
				else left = middle + 1;
				middle = (left + right) / 2;
			}
			if (currElement < searchFor) {
				if (monotonicity == 1) left = middle + 1;
				else right = middle - 1;
				middle = (left + right) / 2;
			}
			currElement = array[middle];
		}
		return middle;
	}

	private static int determineMonotonicity(int[] array) {
		if (array[0] < array[array.length - 1]) return 1;
		if (array[0] > array[array.length - 1]) return -1;
		return 0;
	}
}
