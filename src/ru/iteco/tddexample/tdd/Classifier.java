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
		return sumOfFactors() - number == number;
	}

	public boolean isDeficient() {
		return sumOfFactors() - number < number;
	}

	public boolean isAbundant() {
		return sumOfFactors() - number > number;
	}

	public Set<Integer> getFactors() {
		return factors;
	}

	void addPairFactors(int i) {
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
			addPairFactors(i);
		}
	}

	private int sumOfFactors() {
		int sum = 0;
		for (int i : factors) {
			sum += i;
		}
		return sum;
	}

}
