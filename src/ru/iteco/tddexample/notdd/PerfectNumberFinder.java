package ru.iteco.tddexample.notdd;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumberFinder {
	public static boolean isPerfect(int number) {
		// Получить делители
		List<Integer> factors = new ArrayList<Integer>();
		factors.add(1);
		factors.add(number);
		for (int i = 2; i < Math.sqrt(number); i++)
			if (number % i == 0) {
				factors.add(i);
				if (number / i != i)
					factors.add(number / i);
			}

		// Вычислить сумму делителей
		int sum = 0;
		for (Integer i : factors)
			sum += i;
		// Проверить, является ли число совершенным
		return sum - number == number;
	}

	public static void main(String[] args) {
		System.out.println("Является ли число " + args[0] + " совершенным?");
		String answer = PerfectNumberFinder
				.isPerfect(Integer.parseInt(args[0])) ? "Является"
				: "Не является";
		System.out.println("Ответ: " + answer);
	}
}
