package designpatterns;

import java.util.Arrays;

public class StrategyPattern {

	public static void main(String[] args) {

		int numbers[] = { 20, 50, 15, 6, 80, 93 };

		SortingContext context = new SortingContext();
		context.setSortingMethod(new InsertionSort());
		context.sortNumbers(numbers);

		System.out.println("***********");
		context.setSortingMethod(new SelectionSort());
		context.sortNumbers(numbers);

		System.out.println("***********");
		context.setSortingMethod(new BubbleSort());
		context.sortNumbers(numbers);

	}

}

interface SortingStrategy {
	public void sort(int[] numbers);
}

class SelectionSort implements SortingStrategy {

	@Override
	public void sort(int[] numbers) {
		System.out.println("Selection Sort!");

		int i, j, first, temp;
		for (i = numbers.length - 1; i > 0; i--) {
			first = 0;
			for (j = 1; j <= i; j++) {
				if (numbers[j] > numbers[first])
					first = j;
			}
			temp = numbers[first];
			numbers[first] = numbers[i];
			numbers[i] = temp;
		}

		System.out.println(Arrays.toString(numbers));
	}
}

class InsertionSort implements SortingStrategy {

	@Override
	public void sort(int[] numbers) {
		System.out.println("Insertion Sort!");

		for (int i = 1; i < numbers.length; i++) {
			int temp = numbers[i];
			int j;
			for (j = i - 1; (j >= 0) && (numbers[j] > temp); j--) {
				numbers[j + 1] = numbers[j];
			}
			numbers[j + 1] = temp;
		}

		System.out.println(Arrays.toString(numbers));
	}
}

class BubbleSort implements SortingStrategy {

	@Override
	public void sort(int[] numbers) {
		System.out.println("Insertion Sort!");

		for (int i = 0; i < numbers.length; i++) {

			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j + 1];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}

		}

		System.out.println(Arrays.toString(numbers));
	}
}

class SortingContext {

	private SortingStrategy strategy;

	public void setSortingMethod(SortingStrategy strategy) {
		this.strategy = strategy;
	}

	public SortingStrategy getStrategy() {
		return strategy;
	}

	public void sortNumbers(int[] numbers) {
		strategy.sort(numbers);
	}
}
