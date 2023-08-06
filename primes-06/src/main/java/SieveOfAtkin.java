public class SieveOfAtkin {

	public static int[] findPrimes(int n) {
		if(n == 0) {
			throw new IllegalArgumentException("The parameter must be a positive number");
		}
		boolean[] markedPrimes = calculatePrimes(n);
		return booleanPrimeToIntPrime(markedPrimes);
	}

	private static boolean[] calculatePrimes(int n) {
		boolean[] array = new boolean[n + 1];
		array[2] = true;
		array[3] = true;
		int sqrtN = (int) Math.ceil(Math.sqrt(n));

		for (int i = 1; i < sqrtN; i++) {
			for (int y = 1; y < sqrtN; y++) {
				// 4i^2 + y^2
				int m = (4 * i * i) + (y * y);
				if (m <= n && (m % 12 == 1 || m % 12 == 5)) {
					array[m] = !array[m];
				}
				// 3i^2 + y^2
				m = (3 * i * i) + (y * y);
				if (m <= n && m % 12 == 7) {
					array[m] = !array[m];
				}
				// 3i^2 - y^2
				m = (3 * i * i) - (y * y);
				if (m <= n && i > y && m % 12 == 11) {
					array[m] = !array[m];
				}
			}
		}
		for (int i = 5; i <= sqrtN; i++) {
			if (array[i]) {
				for (int y = i * i; y < n; y += i * i) {
					array[y] = false;
				}
			}
		}
		return array;
	}

	private static int[] booleanPrimeToIntPrime(boolean[] boolArr) {
		int size = 0;
		int[] tempArray = new int[boolArr.length];
		for (int boolIndex = 0, primeIndex = 0; boolIndex < boolArr.length; boolIndex++) {
			if (boolArr[boolIndex]) {
				tempArray[primeIndex] = boolIndex;
				size++;
				primeIndex++;
			}
		}
		int[] primes = new int[size];
		System.arraycopy(tempArray, 0, primes, 0, size);
		return primes;
	}
}
