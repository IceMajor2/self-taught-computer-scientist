import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LinkedListTest {

	private LinkedList<Integer> emptyLinkedList;

	private LinkedList<Integer> linkedListWithNumbers;

	// 12 items
	private int[] testNumbers = { 10, -5, 0, 19, 21, -24, 222, -194, -1, 120, 9230, 102 };

	@BeforeEach
	public void setup() {
		this.emptyLinkedList = new LinkedList<>();
		this.linkedListWithNumbers = new LinkedList<>();
		for (int num : testNumbers) linkedListWithNumbers.add(num);
	}

	@Test
	void addTest() {
		for (int num : testNumbers) emptyLinkedList.add(num);
		assertThat(emptyLinkedList.size())
				.isEqualTo(testNumbers.length);
	}

	@Test
	void addFirstTest() {
		// when
		for (int num : testNumbers) emptyLinkedList.addFirst(num);
		// then
		List<Integer> expected = convertIntArrayToList(testNumbers);
		Collections.reverse(expected);

		assertThat(emptyLinkedList.size()).isEqualTo(testNumbers.length);
		assertThat(emptyLinkedList.toList())
				.containsExactlyElementsOf(expected);
	}

	@ParameterizedTest
	@ValueSource(ints = { 5, 7, 11, 0, 2, 3, 4, 1, 8, 6, 9, 10 })
	void getIndexTest(int index) {
		assertThat(linkedListWithNumbers.get(index)).isEqualTo(testNumbers[index]);
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, -5, -523498, 12, 13, 12409 })
	void getIndexOutOfBoundsTest(int index) {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> linkedListWithNumbers.get(index));
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, 0, 1, 2, 3, 4, 491, -510})
	void getIndexWhenListEmptyTest(int index) {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> emptyLinkedList.get(index));
	}

	@Test
	void toListTest() {
		assertThat(linkedListWithNumbers.toList())
				.containsExactlyElementsOf(convertIntArrayToList(testNumbers));
	}

	private List<Integer> convertIntArrayToList(int[] intArray) {
		return Arrays.stream(intArray).boxed().collect(Collectors.toList());
	}
}