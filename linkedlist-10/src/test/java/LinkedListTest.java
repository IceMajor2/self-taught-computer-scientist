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

	@Test
	public void iteratorTest() {
		LinkedList<String> dq = new LinkedList<>();
		dq.addFirst("Ala");
		dq.addLast("ma");
		dq.addLast("psa!");
		dq.addFirst("kota");
		dq.addFirst("Nie");

		var iterator = dq.iterator();

		int index = 0;
		for (String str : dq) {
			String next = iterator.next();
			boolean hasNext = iterator.hasNext();
			assertThat(str).isEqualTo(next);
			index++;
			if(index == dq.size()) {
				assertThat(hasNext).isFalse();
			} else {
				assertThat(hasNext).isTrue();
			}
		}
	}

	@Test
	public void equalsTest() {
		LinkedList<String> dq1 = new LinkedList<>();
		LinkedList<String> dq2 = new LinkedList<>();

		dq1.addFirst("Ala");
		dq1.addLast("ma");
		dq1.addLast("psa!");
		dq1.addFirst("kota");
		dq1.addFirst("Nie");

		dq2.addLast("Nie");
		dq2.addLast("kota");
		dq2.addLast("Ala");
		dq2.addLast("ma");
		dq2.addLast("psa!");

		assertThat(dq1).isEqualTo(dq2);

		dq2.addLast("KONIEC.");

		assertThat(dq1).isNotEqualTo(dq2);
	}

	@Test
	public void toStringTest() {
		LinkedList<Double> dq = new LinkedList<>();
		dq.addLast(5.05);
		dq.addFirst(5.43);
		dq.removeLast();
		dq.addFirst(9.0);
		dq.addFirst(4.323859234);

		String toString = dq.toString();

		assertThat(toString).isEqualTo("[4.323859234, 9.0, 5.43]");
	}
}