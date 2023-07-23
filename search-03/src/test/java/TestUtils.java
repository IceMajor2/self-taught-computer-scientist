import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestUtils {

	public static Integer[] getUniqueRandomArray(int size) {
		Set<Integer> set = new HashSet<>();
		Integer[] array = new Integer[size];

		Random random = new Random();
		int i = 0;
		while(set.size() != size) {
			int range = Integer.MAX_VALUE;
			int num = random.nextInt(range) - range / 2;
			if(set.add(num)) {
				array[i] = num;
				i++;
			}
		}
		return array;
	}
}
