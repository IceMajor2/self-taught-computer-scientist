import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
	@ValueSource(ints = { -1, 0, 1, 2, 3, 4, 491, -510 })
	void getIndexWhenListEmptyTest(int index) {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> emptyLinkedList.get(index));
	}

	@Test
	void getFirstTest() {
		emptyLinkedList.add(5);
		emptyLinkedList.add(10);

		assertThat(emptyLinkedList.getFirst()).isEqualTo(5);

		emptyLinkedList.removeFirst();

		assertThat(emptyLinkedList.getFirst()).isEqualTo(10);
	}

	@Test
	void getFirstWhenListEmptyTest() {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> emptyLinkedList.getFirst());
	}

	@Test
	void getLastTest() {
		emptyLinkedList.add(-5);
		emptyLinkedList.add(213);

		assertThat(emptyLinkedList.getLast()).isEqualTo(213);

		emptyLinkedList.removeFirst();

		assertThat(emptyLinkedList.getLast()).isEqualTo(213);

		emptyLinkedList.add(30);

		assertThat(emptyLinkedList.getLast()).isEqualTo(30);
	}

	@Test
	void getLastWhenListEmptyTest() {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> emptyLinkedList.getLast());
	}

	@Test
	void containsWhenListEmptyTest() {
		assertThat(emptyLinkedList.contains(30)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, -5, 0, 19, 21, -24, 222, -194, -1, 120, 9230, 102 })
	void containsWhenListHasElementTest(int element) {
		assertThat(linkedListWithNumbers.contains(element)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = { -195, 9342, -1895, 239, 193, 43, 55, 11 })
	void containsWhenListDoesNotHaveElementTest(int element) {
		assertThat(linkedListWithNumbers.contains(element)).isFalse();
	}

	@Test
	void containsWhenObjectIsOfDifferentTypeTest() {
		assertThat(linkedListWithNumbers.contains(0.0)).isFalse();
		assertThat(linkedListWithNumbers.contains("10")).isFalse();
		assertThat(linkedListWithNumbers.contains(-5l)).isFalse();
		assertThat(linkedListWithNumbers.contains(120f)).isFalse();
		assertThat(linkedListWithNumbers.contains(-1.1)).isFalse();
	}

	@Test
	void containsAllWhenListEmptyTest() {
		assertThat(emptyLinkedList.containsAll(Set.of(5, 10, 15))).isFalse();
	}

	@ParameterizedTest
	@CsvSource({
			"[10;0;-29;55;-1]",
			"[111;19;9230;-194;491;333]",
			"[201;21;-24;101;94]"
	})
	void containsAllWhenOnlyPartOfElementsAreFoundTest(String s) {
		Integer[] array = TestUtils.parseCsvSourceToIntegerArray(s);
		List<Integer> list = Arrays.asList(array);
		Deque<Integer> deque = new ArrayDeque(list);
		Set<Integer> set = new HashSet(list);

		assertThat(linkedListWithNumbers.containsAll(list)).isFalse();
		assertThat(linkedListWithNumbers.containsAll(deque)).isFalse();
		assertThat(linkedListWithNumbers.containsAll(set)).isFalse();
	}

	@ParameterizedTest
	@CsvSource({
			"[10;222;-1]",
			"[120;9230;-24]",
			"[19;21;222]"
	})
	void containsAllWhenElementsInListButDoubleTypeTest(String s) {
		Integer[] array = TestUtils.parseCsvSourceToIntegerArray(s);
		List<Double> list = Arrays.stream(array)
				.flatMapToDouble(DoubleStream::of)
				.boxed()
				.toList();
		Set<Double> set = new HashSet<>(list);
		Deque<Integer> deque = new ArrayDeque(list);

		assertThat(linkedListWithNumbers.containsAll(list)).isFalse();
		assertThat(linkedListWithNumbers.containsAll(deque)).isFalse();
		assertThat(linkedListWithNumbers.containsAll(set)).isFalse();
	}

	@ParameterizedTest
	@CsvSource({
			"[-5;19;-1]",
			"[-1]",
			"[120;9230;102;-24;-194;19;0]",
			"[10;-5;0;19;21;-24;222;-194;-1;120;9230;102]",
			"[19;-24;-1;10;222;21;102;9230;120;-194;0;-5]"
	})
	void containsAllWhenElementsInListTest(String s) {
		Integer[] array = TestUtils.parseCsvSourceToIntegerArray(s);
		List<Integer> list = Arrays.asList(array);
		Deque<Integer> deque = new ArrayDeque(list);
		Set<Integer> set = new HashSet(list);

		assertThat(linkedListWithNumbers.containsAll(list)).isTrue();
		assertThat(linkedListWithNumbers.containsAll(deque)).isTrue();
		assertThat(linkedListWithNumbers.containsAll(set)).isTrue();
	}

	@Test
	void removeLastTest() {
		for (int i = 0; i < 12; i++) {
			int toRemove = linkedListWithNumbers.getLast();
			assertThat(linkedListWithNumbers.removeLast())
					.isEqualTo(toRemove);
		}
		assertThat(linkedListWithNumbers.size()).isEqualTo(0);
	}

	@Test
	void removeLastWhenListEmptyTest() {
		assertThatExceptionOfType(IllegalStateException.class)
				.isThrownBy(() -> emptyLinkedList.removeLast());
	}

	@Test
	void removeFirstTest() {
		for (int i = 0; i < 12; i++) {
			int toRemove = linkedListWithNumbers.getFirst();
			assertThat(linkedListWithNumbers.removeFirst())
					.isEqualTo(toRemove);
		}
		assertThat(linkedListWithNumbers.size()).isEqualTo(0);
	}

	@Test
	void removeFirstWhenListEmptyTest() {
		assertThatExceptionOfType(IllegalStateException.class)
				.isThrownBy(() -> emptyLinkedList.removeFirst());
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, -5, 0, 19, 21, -24, 222, -194, -1, 120, 9230, 102 })
	void removeObjectTest(int element) {
		assertThat(linkedListWithNumbers.remove(element)).isTrue();
	}

	@Test
	void removeObjectWhenListEmptyTest() {
		assertThatExceptionOfType(IllegalStateException.class)
				.isThrownBy(() -> emptyLinkedList.remove(0));
	}

	@ParameterizedTest
	@ValueSource(ints = {-654239, 912, 5892, 1824, -523})
	void removeObjectWhenListDoesNotContainItTest(int element) {
		assertThat(linkedListWithNumbers.remove(element)).isFalse();
	}

	@Test
	void sizeTest() {
		assertThat(emptyLinkedList.size()).isEqualTo(0);

		emptyLinkedList.add(20);

		assertThat(emptyLinkedList.size()).isEqualTo(1);

		emptyLinkedList.addFirst(20);
		emptyLinkedList.add(90);

		assertThat(emptyLinkedList.size()).isEqualTo(3);

		emptyLinkedList.remove(20);

		assertThat(emptyLinkedList.size()).isEqualTo(2);

		emptyLinkedList.removeLast();
		emptyLinkedList.removeFirst();

		assertThat(emptyLinkedList.size()).isEqualTo(0);
	}

	@Test
	void isEmptyTest() {
		assertThat(emptyLinkedList.isEmpty()).isTrue();

		emptyLinkedList.addFirst(9);

		assertThat(emptyLinkedList.isEmpty()).isFalse();

		emptyLinkedList.add(10);
		emptyLinkedList.add(10);
		emptyLinkedList.remove(10);

		assertThat(emptyLinkedList.isEmpty()).isFalse();

		emptyLinkedList.removeLast();
		emptyLinkedList.removeFirst();

		assertThat(emptyLinkedList.isEmpty()).isTrue();
	}

	@Test
	void clearTest() {
		emptyLinkedList.clear();
		assertThat(emptyLinkedList.toList()).isEqualTo(new LinkedList<Integer>().toList());

		linkedListWithNumbers.clear();
		assertThat(linkedListWithNumbers.toList()).isEqualTo(emptyLinkedList.toList());
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