package cs.intro.time.complexity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import cs.intro.LinearSearch;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static cs.intro.TestUtils.*;

public class TimeComplexityComponent extends JFrame {

	public TimeComplexityComponent() {
		initUI();
	}

	private void initUI() {
		Map<Long, Long> expResults = conductLinearSearchExperiment();
		XYDataset dataset = createDataset(expResults);
		JFreeChart chart = createChart(dataset);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		add(chartPanel);

		pack();
		setTitle("Time Complexity | Linear Search");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Map<Long, Long> conductLinearSearchExperiment() {
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

	private XYDataset createDataset(Map<Long, Long> results) {
		var series = new XYSeries("Time");

		for (var entry : results.entrySet()) {
			Long index = entry.getKey();
			Long timeTaken = entry.getValue();
			series.add(index, timeTaken);
		}

		var dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		return dataset;
	}

	private JFreeChart createChart(XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart(
				"",
				"Index",
				"Time taken (ms)",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
		);

		XYPlot plot = chart.getXYPlot();

		var renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Time complexity of linear search confronted with an array of 175 000 elements",
						new Font("Serif", java.awt.Font.BOLD, 16)
				)
		);

		return chart;
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			var ex = new TimeComplexityComponent();
			ex.setVisible(true);
		});
	}
}
