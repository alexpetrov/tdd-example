package ru.iteco.tddexample.tdd;

import java.util.HashSet;
import java.util.Set;

public class Classifier {
	private int number;
	private int sumOfFactors;
	private Set<Integer> factors = new HashSet<Integer>();

	public Classifier(int number) {
		setNumber(number);
	}

	public void setNumber(int number) {
		if (number < 0)
			throw new InvalidNumberException();
		this.number = number;
		addFactor(1);
		addFactor(number);
		calculateFactors();
		calculateSumOfFactors();
	}

	public boolean isPerfect() {
		return sumOfFactors - number == number;
	}

	public boolean isDeficient() {
		return sumOfFactors - number < number;
	}

	public boolean isAbundant() {
		return sumOfFactors - number > number;
	}

	public Set<Integer> getFactors() {
		return factors;
	}

	void addPairFactors(int i) {
		if (isFactor(i)) {
			addFactor(i);
			addFactor(number / i);
		}
	}

	private boolean isFactor(int factor) {
		return number % factor == 0;
	}

	private void calculateFactors() {
		for (int i = 2; i < Math.sqrt(number); i++) {
			addPairFactors(i);
		}
	}

	private void calculateSumOfFactors() {
		int sum = 0;
		for (int i : factors) {
			sum += i;
		}
		this.sumOfFactors = sum;
	}

	void addFactor(int i) {
		factors.add(i);
	}

}
