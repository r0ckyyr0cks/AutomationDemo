package com.letskodeit.anil.tomar;

import org.testng.annotations.Test;

public class TestNG_Demo {
	
	@Test
	public void testMethod() {
		SomeClassToTest obj = new SomeClassToTest();
		obj.sumNumbers(10, 20);
		System.out.println("Running Test => Test Method1");
		
	}

}
