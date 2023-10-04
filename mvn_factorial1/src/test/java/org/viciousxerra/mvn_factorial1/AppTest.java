package org.viciousxerra.mvn_factorial1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest extends Assert {
		
	@DataProvider(name = "LegalArgs_&_expectedOutput")
	private Object[][] getLegalInput() {
		return new Object[][] {
			{1, 1L},
			{5, 120L},
			{9, 362880L},
			{13, 6227020800L}
		};
	}
	
	@DataProvider(name = "IllegalArgs_&_expectedOutput")
	private Object[][] getIllegalInput() {
		return new Object[][] {
			{0, IllegalArgumentException.class},
			{-1, IllegalArgumentException.class},
			{-5, IllegalArgumentException.class}
		};
	}
	
	@Test(dataProvider = "LegalArgs_&_expectedOutput")
	void testFactorialMethodWithLegalArgs(Integer passingArg, Long expected) {
		System.out.printf("Passed: %d;\nExpected: %d\n", passingArg, expected);
		assertEquals(App.factorial(passingArg), expected);
		System.out.println("Accepted");
	}
	
	@Test(dataProvider = "IllegalArgs_&_expectedOutput")
	void testFactorialMethodWithIllegalArgs(Integer passingArg, Class<? extends IllegalArgumentException> expected) {
		assertThrows(expected, () -> App.factorial(passingArg));
	}
	
}
