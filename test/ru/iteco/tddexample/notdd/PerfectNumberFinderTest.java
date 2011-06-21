package ru.iteco.tddexample.notdd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PerfectNumberFinderTest {
	@Test
	public void test_6_is_perfect() {
		assertThat("Чисдо 6 должно быть совершенным: ",
				PerfectNumberFinder.isPerfect(6));
	}

	@Test
	public void test_28_is_perfect() {
		assertTrue("Чисдо 28 должно быть совершенным: ",
				PerfectNumberFinder.isPerfect(28));
	}
}
