import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SieveOfAtkinTest {

	private static final int[] PRIMES_7 = new int[] { 2, 3, 5, 7 };

	@Test
	// TODO: split assertions into other test cases
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

	@ParameterizedTest
	@ValueSource(ints = { -12, 0 })
	void findPrimes_whenNis0Test(int n) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> SieveOfAtkin.findPrimes(n));
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7 })
	void findPrimes_whenNisNotBiggerThan7Test(int n) {
		List<Integer> primeTemp = new ArrayList<>();
		for (int prime : PRIMES_7) {
			if(prime <= n) {
				primeTemp.add(prime);
			}
		}
		int[] expected = primeTemp.stream().mapToInt(i -> i).toArray();
		int[] actual = SieveOfAtkin.findPrimes(n);
		assertThat(actual).containsExactly(expected);
	}
}