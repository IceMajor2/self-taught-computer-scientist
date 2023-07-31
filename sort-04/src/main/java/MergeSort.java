public class MergeSort {

	public static Integer[] sort(Integer[] input) {
		if (input.length > 1) {
			int midIndex = input.length / 2;
			Integer[] leftHalf = createLeftHalfArray(input, midIndex);
			Integer[] rightHalf = createRightHalfArray(input, midIndex);
			sort(leftHalf);
			sort(rightHalf);

			int leftIndex = 0;
			int rightIndex = 0;
			int sortedIndex = 0;
			while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
				if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
					input[sortedIndex] = leftHalf[leftIndex];
					leftIndex++;
				}
				else {
					input[sortedIndex] = rightHalf[rightIndex];
					rightIndex++;
				}
				sortedIndex++;
			}
			while (leftIndex < leftHalf.length) {
				input[sortedIndex] = leftHalf[leftIndex];
				leftIndex++;
				sortedIndex++;
			}
			while (rightIndex < rightHalf.length) {
				input[sortedIndex] = rightHalf[rightIndex];
				rightIndex++;
				sortedIndex++;
			}
		}
		return input;
	}

	private static Integer[] createRightHalfArray(Integer[] input, int midIndex) {
		Integer[] rightHalf = new Integer[input.length - midIndex];
		System.arraycopy(input, midIndex, rightHalf, 0, input.length - midIndex);
		return rightHalf;
	}

	private static Integer[] createLeftHalfArray(Integer[] input, int midIndex) {
		Integer[] leftHalf = new Integer[midIndex];
		System.arraycopy(input, 0, leftHalf, 0, midIndex);
		return leftHalf;
	}
}
