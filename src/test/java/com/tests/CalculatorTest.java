package com.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import NgWebDriverExample.CalculatePage;

public class CalculatorTest {

	CalculatePage calPage;
	
	@BeforeTest
	public void setup() {
		calPage = new CalculatePage();
	}
	
	@Test(priority =1)
	public void sumTest() {
		String result = calPage.doSum("100", "80");
		Assert.assertEquals(result, "180");
	}
	
	@Test(priority =2)
	public void subTest() {
		String result = calPage.doSub("100", "80");
		Assert.assertEquals(result, "20");
	}
	

	@Test(priority =3)
	public void divTest() {
		String result = calPage.doDivision("100", "10");
		Assert.assertEquals(result, "10");
	}
	
}
