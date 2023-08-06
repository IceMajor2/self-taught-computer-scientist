import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SieveOfAtkinTest {

	@Test
	void findPrimesTest() {
		int[] expected = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
				53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
		int[] actual = SieveOfAtkin.findPrimes(100);

		assertThat(actual)
				.withFailMessage("Output was null")
				.isNotNull()
				.withFailMessage("Output is not sorted in ascending order")
				.isSorted()
				.withFailMessage("Output does not match expected numbers")
				.containsExactly(expected);
	}

	// edge cases: n is less than 0; n = 0, n = 1, n = 2
	@Test
	void findPrimes_whenNis0Test() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> SieveOfAtkin.findPrimes(0));
	}
}