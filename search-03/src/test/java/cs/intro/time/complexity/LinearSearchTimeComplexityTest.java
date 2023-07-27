package cs.intro.time.complexity;

import java.awt.EventQueue;
import java.util.LinkedHashMap;
import java.util.Map;

import cs.intro.LinearSearch;

import static cs.intro.TestUtils.getNumbersFromTo;

public class LinearSearchTimeComplexityTest {

	public static void main(String[] args) {
		var data = conductExperiment();
		EventQueue.invokeLater(() -> {
			var ex = new TimeComplexityComponent(data);
			ex.setVisible(true);
		});
	}

	public static Map<Long, Long> conductExperiment() {
		Map<Long, Long> results = new LinkedHashMap<>();
		Integer[] numbers = getNumbersFromTo(-87500, 87500);

		System.out.println("Experiment is in progress. Please wait.");

		int iterationsToDo = numbers.length - 10000;
		double previousPercent = 0;
		for (int i = 10000; i < numbers.length; i++) {
			// logging logic
			double percent = ((i - 10000) / (double) iterationsToDo) * 100;
			if (percent - 10 >= previousPercent) {
				System.out.println((int) percent + "%");
				previousPercent = percent;
			}

			Integer toFind = numbers[i];
			long start = System.nanoTime();
			LinearSearch.get(numbers, toFind);
			long end = System.nanoTime();
			long timeElapsed = (end - start);
			// do not register first 500 elements
			// no idea why, but they tend to skew the results
			if (i <= 10500) {
				continue;
			}
			results.put(Long.valueOf(i), timeElapsed);
		}
		System.out.println("100%");
		return results;
	}
}
