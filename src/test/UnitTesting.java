package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import extras.Checker;

public class UnitTesting {

	@Test
	public void checkStringTest() {
		assertTrue("[ OK ]", Checker.checkString("I am a string"));
		assertFalse("[ OK ]",Checker.checkString("I am not a string 1234"));
	}
	
	@Test
	public void checkNumberTest(){
		
		assertTrue("[ OK ]", Checker.checkNumber("99123465376498"));
		assertFalse("[ OK ]",Checker.checkNumber("I am not number"));
	}
	
	@Test
	public void checkEmailTest(){
		
		assertTrue("[ OK ]", Checker.checkEmailAddress("theodoros@gmail.com"));
		assertFalse("[ OK ]",Checker.checkEmailAddress("I am not email"));
		
	}
	
	
	
	@Test
	public void checkClearStringTest(){
		
		String goodString = "Theodoros Charalambous";
		String badString ="       Theodoros Charalambous     ";
		
		assertTrue("[ OK ]",Checker.clearString(goodString).equals(goodString));
		assertTrue("[ OK ]",Checker.clearString(badString).equals(goodString));
	}
	
	@Test
	public void checkRemoveStringID(){
		
		String goodString = "15 Theodoros Charalambous";
		String result = "Theodoros Charalambous";
		assertTrue("[ OK ]",Checker.removeStringID(goodString).equals(result));
	}
	


}
