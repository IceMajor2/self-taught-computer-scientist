import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinkedListTest {

	private LinkedList<String> SUT = new LinkedList<>();

	@Test
	void addFirst() {
		SUT.addFirst("Hello");

		assertThat(SUT.getFirst()).isEqualTo("Hello");
		assertThat(SUT.getLast()).isEqualTo("Hello");
	}

	@Test
	void addFirstMultipleElements() {
		SUT.addFirst("Hello");
		SUT.addFirst("world");
		SUT.addFirst("LinkedList");

		assertThat(SUT.getFirst()).isEqualTo("LinkedList");
		assertThat(SUT.getLast()).isEqualTo("Hello");
	}
}