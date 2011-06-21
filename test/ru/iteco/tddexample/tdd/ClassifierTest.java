package ru.iteco.tddexample.tdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ClassifierTest {
	@Test
	public void factors_for_1() {
		Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1));
		Classifier c = new Classifier(1);
		assertThat(c.getFactors(), is(expected));
	}

	@Test
	public void factors_for_6() {
		Set<Integer> expected = new HashSet<Integer>(Arrays.asList(1, 2, 3, 6));
		Classifier c = new Classifier(6);
		assertThat(c.getFactors(), is(expected));
	}

	@Test
	public void is_perfect() {
		assertTrue((new Classifier(6)).isPerfect());
		assertTrue((new Classifier(28)).isPerfect());
		assertFalse((new Classifier(27)).isPerfect());
	}

	@Test
	public void is_deficient() {
		assertTrue((new Classifier(8)).isDeficient());
		assertFalse((new Classifier(28)).isDeficient());
		assertFalse((new Classifier(30)).isDeficient());
	}

	@Test
	public void is_abundant() {
		assertTrue((new Classifier(30)).isAbundant());
		assertFalse((new Classifier(28)).isAbundant());
		assertFalse((new Classifier(8)).isAbundant());
	}

	@Test
	public void is_factor() {
		assertTrue(isFactor(1, 10));
		assertTrue(isFactor(5, 25));
		assertFalse(isFactor(6, 25));
	}

	@Test
	public void add_factors() {
		Classifier c = new Classifier(20);
		c.addFactor(2);
		c.addFactor(4);
		c.addFactor(5);
		c.addFactor(10);
		Set<Integer> expectation = new HashSet<Integer>(Arrays.asList(1, 2, 4,
				5, 10, 20));
		assertThat(c.getFactors(), is(expectation));

	}

	@Test
	public void classifier_for_negative_not_allowed() {
		try {
			new Classifier(-1);
			fail("It should fail for negative numbers!");
		} catch (Exception e) {
			assertTrue(e instanceof InvalidNumberException);
		}
	}

	private boolean isFactor(int factor, int number) {
		Method m;
		try {
			m = Classifier.class.getDeclaredMethod("isFactor", int.class);
			m.setAccessible(true);
			return (Boolean) m.invoke(new Classifier(number), factor);
		} catch (Throwable t) {
			fail();
		}
		return false;
	}
}
