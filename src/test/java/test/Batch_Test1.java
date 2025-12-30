package test;

import org.testng.annotations.Test;

import generic_libraries.BaseClass;


public class Batch_Test1 {
	@Test(groups = "Smoke")
	public void display1() {
//		Assert.fail("Testing");
		System.out.println("display1() from Parallel_Test1 - Smoke");
	}
	
	@Test(groups = "Regression",retryAnalyzer = generic_libraries.RetryImplementationClass.class)
	public void display2() {
//		Assert.fail();
		System.out.println("display2() from Parallel_Test1 - Regression");
	}
}
