package cs.intro.time.complexity;

import java.awt.EventQueue;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import cs.intro.BinarySearch;

import utils.TestUtils;

public class BinarySearchTimeComplexityTest {

	public static void main(String[] args) {
		var data = conductExperiment();
		EventQueue.invokeLater(() -> {
			var ex = new TimeComplexityComponent(data);
			ex.setVisible(true);
		});
	}

	public static Map<Long, Long> conductExperiment() {
		Map<Long, Long> results = new LinkedHashMap<>();
		Integer[] numbers = TestUtils.getNumbersFromTo(-50000000, 50000000);

		System.out.println("Experiment is in progress. Please wait.");

		int iterationsToDo = numbers.length - 10000;
		double previousPercent = 0;
		for (int i = 0; i < numbers.length; i += 100) {
			// logging logic
			double percent = ((i - 10000) / (double) iterationsToDo) * 100;
			if (percent - 10 >= previousPercent) {
				System.out.println((int) percent + "%");
				previousPercent = percent;
			}

			Integer toFind = numbers[i];
			long start = System.nanoTime();
			BinarySearch.get(numbers, toFind, Comparator.comparing(Integer::intValue));
			long end = System.nanoTime();
			long timeElapsed = (end - start);

			results.put(Long.valueOf(i), timeElapsed);
		}
		System.out.println("100%");
		return results;
	}
}
