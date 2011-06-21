package ru.iteco.tddexample.tdd;

import java.util.HashSet;
import java.util.Set;

public class Classifier {
	private int number;
	private Set<Integer> factors;

	public Classifier(int number) {
		setNumber(number);
	}

	public boolean isPerfect() {
		return sumOfFactorsFor(number) - number == number;
	}

	public boolean isDeficient() {
		return sumOfFactorsFor(number) - number < number;
	}

	public boolean isAbundant() {
		return sumOfFactorsFor(number) - number > number;
	}

	Set<Integer> getFactors() {
		return factors;
	}

	void addFactor(int i) {
		if (isFactor(i)) {
			factors.add(i);
			factors.add(number / i);
		}
	}

	private boolean isFactor(int factor) {
		return number % factor == 0;
	}

	public void setNumber(int number) {
		if (number < 0)
			throw new InvalidNumberException();
		this.number = number;
		factors = new HashSet<Integer>();
		factors.add(1);
		factors.add(number);
		calculateFactors();
	}

	private void calculateFactors() {
		for (int i = 2; i < Math.sqrt(number); i++) {
			addFactor(i);
		}
	}

	private int sumOfFactorsFor(int number2) {
		int sum = 0;
		for (int i : factors) {
			sum += i;
		}
		return sum;
	}

}
