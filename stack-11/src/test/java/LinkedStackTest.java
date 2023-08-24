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

class LinkedStackTest {

	private LinkedStack<Double> emptyLinkedStack;

	private LinkedStack<Double> linkedStackWithNumbers;

	// 12 items
	private double[] testNumbers = { -5d, 0d, 291.21, 2.201859430328, 3.14, 93.12, 2d, -6.1023 };

	@BeforeEach
	public void setup() {
		this.emptyLinkedStack = new LinkedStack<>();
		this.linkedStackWithNumbers = new LinkedStack<>();
		for (double num : testNumbers) linkedStackWithNumbers.add(num);
	}

	@Test
	void addTest() {
		for (double num : testNumbers) emptyLinkedStack.push(num);
		assertThat(emptyLinkedStack.size())
				.isEqualTo(testNumbers.length);
	}

	@Test
	void getTest() {
		emptyLinkedStack.push(5d);
		emptyLinkedStack.push(10.31);

		assertThat(emptyLinkedStack.get()).isEqualTo(10.31);

		emptyLinkedStack.pop();

		assertThat(emptyLinkedStack.get()).isEqualTo(5d);
	}

	@Test
	void getWhenListEmptyTest() {
		assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
				.isThrownBy(() -> emptyLinkedStack.get());
	}

	@Test
	void containsWhenListEmptyTest() {
		assertThat(emptyLinkedStack.contains(30)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(doubles = { -5d, 0d, 291.21, 2.201859430328, 3.14, 93.12, 2d, -6.1023 })
	void containsWhenListHasElementTest(double element) {
		assertThat(linkedStackWithNumbers.contains(element)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(doubles = { -195.325, 9342, -1895.312, 239, 193, 43.639, 55.123, 11 })
	void containsWhenListDoesNotHaveElementTest(double element) {
		assertThat(linkedStackWithNumbers.contains(element)).isFalse();
	}

	@Test
	void containsWhenObjectIsOfDifferentTypeTest() {
		assertThat(linkedStackWithNumbers.contains(0)).isFalse();
		assertThat(linkedStackWithNumbers.contains("10")).isFalse();
		assertThat(linkedStackWithNumbers.contains(-5l)).isFalse();
		assertThat(linkedStackWithNumbers.contains(120f)).isFalse();
		assertThat(linkedStackWithNumbers.contains(5)).isFalse();
	}

	@Test
	void containsAllWhenListEmptyTest() {
		assertThat(emptyLinkedStack.containsAll(Set.of(5, 10, 15))).isFalse();
	}

	@ParameterizedTest
	@CsvSource({
			"[-5.0;291.21;541.2;55;1.93]",
			"[2.201859;3.14;93.12]",
			"[21.2;0;-5.22;3.14;2.0;3]"
	})
	void containsAllWhenOnlyPartOfElementsAreFoundTest(String s) {
		Double[] array = TestUtils.parseCsvSourceToArray(s, Double.class);
		List<Double> list = Arrays.asList(array);
		Deque<Double> deque = new ArrayDeque(list);
		Set<Double> set = new HashSet(list);

		assertThat(linkedStackWithNumbers.containsAll(list)).isFalse();
		assertThat(linkedStackWithNumbers.containsAll(deque)).isFalse();
		assertThat(linkedStackWithNumbers.containsAll(set)).isFalse();
	}

	@Test
	void containsAllWhenElementsInListButIntegerTypeTest() {
		Integer[] nums = {-5,2,0};
		List<Integer> list = List.of(nums);
		Set<Integer> set = new HashSet<>(list);
		Deque<Integer> deque = new ArrayDeque(list);

		assertThat(linkedStackWithNumbers.containsAll(list)).isFalse();
		assertThat(linkedStackWithNumbers.containsAll(deque)).isFalse();
		assertThat(linkedStackWithNumbers.containsAll(set)).isFalse();
	}

	@ParameterizedTest
	@CsvSource({
			"[3.14;2.201859430328;-5]",
			"[2.201859430328]",
			"[291.21;2.0;-6.1023;291.21]"
	})
	void containsAllWhenElementsInListTest(String s) {
		Double[] array = TestUtils.parseCsvSourceToArray(s, Double.class);
		List<Double> list = Arrays.asList(array);
		Deque<Double> deque = new ArrayDeque(list);
		Set<Double> set = new HashSet(list);

		assertThat(linkedStackWithNumbers.containsAll(list)).isTrue();
		assertThat(linkedStackWithNumbers.containsAll(deque)).isTrue();
		assertThat(linkedStackWithNumbers.containsAll(set)).isTrue();
	}


	@Test
	void sizeTest() {
		assertThat(emptyLinkedStack.size()).isEqualTo(0);

		emptyLinkedStack.push(20d);

		assertThat(emptyLinkedStack.size()).isEqualTo(1);

		emptyLinkedStack.push(21.21);
		emptyLinkedStack.push(-52348.5413851);

		assertThat(emptyLinkedStack.size()).isEqualTo(3);

		emptyLinkedStack.pop();

		assertThat(emptyLinkedStack.size()).isEqualTo(2);

		emptyLinkedStack.pop();

		assertThat(emptyLinkedStack.size()).isEqualTo(1);

		emptyLinkedStack.pop();

		assertThat(emptyLinkedStack.size()).isEqualTo(0);
	}

	@Test
	void isEmptyTest() {
		assertThat(emptyLinkedStack.isEmpty()).isTrue();

		emptyLinkedStack.push(9d);

		assertThat(emptyLinkedStack.isEmpty()).isFalse();

		emptyLinkedStack.push(321.3);
		emptyLinkedStack.push(5.21);
		emptyLinkedStack.pop();

		assertThat(emptyLinkedStack.isEmpty()).isFalse();

		emptyLinkedStack.pop();
		emptyLinkedStack.pop();

		assertThat(emptyLinkedStack.isEmpty()).isTrue();
	}

	@Test
	void clearTest() {
		emptyLinkedStack.clear();
		assertThat(emptyLinkedStack.toList()).isEqualTo(new LinkedStack<>().toList());

		linkedStackWithNumbers.clear();
		assertThat(linkedStackWithNumbers.toList()).isEqualTo(emptyLinkedStack.toList());
	}

	@Test
	void givenEqualLists_whenComparing_thenReturnTrueTest() {
		LinkedStack<Double> compare = new LinkedStack<>();
		assertThat(emptyLinkedStack).isEqualTo(compare);

		for (double num : testNumbers) compare.add(num);
		assertThat(linkedStackWithNumbers).isEqualTo(compare);
	}

	@Test
	void equalsWhenListsHaveSameElementsInDifferentOrderTest() {
		List<Double> nums = Arrays.stream(testNumbers)
				.boxed()
				.collect(Collectors.toList());
		Collections.shuffle(nums); // may return same list but probability is close to 0
		for (double num : nums) emptyLinkedStack.add(num);
		assertThat(linkedStackWithNumbers).isNotEqualTo(emptyLinkedStack);
	}

	@Test
	void equalsWhenListEmptyButDifferentTypeTest() {
		LinkedStack<Double> compare = new LinkedStack<>();
		assertThat(emptyLinkedStack).isEqualTo(compare);
	}

	@Test
	void toListTest() {
		assertThat(linkedStackWithNumbers.toList())
				.containsExactlyElementsOf(convertDoubleArrayToList(testNumbers));
	}

	@Test
	void toStringTest() {
		assertThat(emptyLinkedStack.toString()).isEqualTo("[]");
		assertThat(linkedStackWithNumbers.toString())
				.isEqualTo("[-5.0, 0.0, 291.21, 2.201859430328, 3.14, 93.12, 2.0, -6.1023]");
	}

	private List<Double> convertDoubleArrayToList(double[] doubleArray) {
		return Arrays.stream(doubleArray).boxed().collect(Collectors.toList());
	}
}