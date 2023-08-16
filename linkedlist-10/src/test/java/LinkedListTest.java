import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinkedListTest {

	private LinkedList<Integer> emptyLinkedList;
	private LinkedList<Integer> linkedListWithNumbers;
	private int[] testNumbers = {10, -5, 0, 19, 21, -24, 222, -194, -1, 120, 9230, 102};

	@BeforeEach
	public void setup() {
		this.emptyLinkedList = new LinkedList<>();
		this.linkedListWithNumbers = new LinkedList<>();
		for(int num : testNumbers) linkedListWithNumbers.add(num);
	}

	@Test
	void addTest() {
		for(int num : testNumbers) emptyLinkedList.add(num);
		assertThat(emptyLinkedList.size())
				.isEqualTo(testNumbers.length);
	}

	@Test
	void toListTest() {
		assertThat(linkedListWithNumbers.toList())
				.containsExactlyElementsOf(convertIntArrayToList(testNumbers));
	}

	private List<Integer> convertIntArrayToList(int[] intArray) {
		return Arrays.stream(intArray).boxed().toList();
	}
}