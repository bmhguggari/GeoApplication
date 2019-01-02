/**
 * 
 */
package org.hanamant.util.regex.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hanamant.util.regex.ContactValidationUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author hguggari
 *
 */
public class ContactValidationUtilTest {

	/**
	 * 
	 */
	public ContactValidationUtilTest() {
	}
	
	@BeforeClass
	public static void setUp() {
		
	}
	
	@AfterClass
	public static void tearDown() {
		
	}
	
	@Test
	public void testValidateEmail() {
		String mailRegEx = "^([a-zA-Z0-9_.-]+@[a-zA-Z]+[.][a-zA-Z]{2,3})$";
		String rightMail =null, wrongMail = null;
		try {
			assertNotNull(mailRegEx);
			
			rightMail = "testing@testing.com";
			assertTrue(ContactValidationUtil.validateEmailId(rightMail));
			assertTrue(ContactValidationUtil.validateEmailId(mailRegEx, rightMail));
			
			rightMail = "_testing_test@test.com";
			assertTrue(ContactValidationUtil.validateEmailId(rightMail));
			assertTrue(ContactValidationUtil.validateEmailId(mailRegEx, rightMail));
			
			rightMail = ".testing-test@test.com";
			assertTrue(ContactValidationUtil.validateEmailId(rightMail));
			assertTrue(ContactValidationUtil.validateEmailId(mailRegEx, rightMail));
			
			rightMail = "testing.test.@test.in";
			assertTrue(ContactValidationUtil.validateEmailId(rightMail));
			assertTrue(ContactValidationUtil.validateEmailId(mailRegEx, rightMail));
			
			rightMail = "test_one-two.three009@test.com";
			assertTrue(ContactValidationUtil.validateEmailId(rightMail));
			assertTrue(ContactValidationUtil.validateEmailId(mailRegEx, rightMail));
			
			wrongMail = "test;mail@gmail.com";
			assertFalse(ContactValidationUtil.validateEmailId(wrongMail));
			assertFalse(ContactValidationUtil.validateEmailId(mailRegEx, wrongMail));
			
			wrongMail = "test;mail@hh55.com";
			assertFalse(ContactValidationUtil.validateEmailId(wrongMail));
			assertFalse(ContactValidationUtil.validateEmailId(mailRegEx, wrongMail));
			
			wrongMail = "test;mail@hh55.44";
			assertFalse(ContactValidationUtil.validateEmailId(wrongMail));
			assertFalse(ContactValidationUtil.validateEmailId(mailRegEx, wrongMail));
			
			wrongMail = "test-;mail@hh55.sfsdf";
			assertFalse(ContactValidationUtil.validateEmailId(wrongMail));
			assertFalse(ContactValidationUtil.validateEmailId(mailRegEx, wrongMail));
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testValidateMobile() {
		String mobileRegEx = "^((\\+91)?[6-9][0-9]{9})$";
		String rightMobile =null, wrongMobile = null;
		try {
			rightMobile = "8000000000";
			assertTrue(ContactValidationUtil.validateMobile(rightMobile));
			assertTrue(ContactValidationUtil.validateMobile(mobileRegEx, rightMobile));
			
			rightMobile = "+918000000000";
			assertTrue(ContactValidationUtil.validateMobile(rightMobile));
			assertTrue(ContactValidationUtil.validateMobile(mobileRegEx, rightMobile));
			
			rightMobile = "+916000000000";
			assertTrue(ContactValidationUtil.validateMobile(rightMobile));
			assertTrue(ContactValidationUtil.validateMobile(mobileRegEx, rightMobile));
			
			
			wrongMobile = "5000000000";
			assertFalse(ContactValidationUtil.validateMobile(wrongMobile));
			assertFalse(ContactValidationUtil.validateMobile(mobileRegEx, wrongMobile));
			
			wrongMobile = "+997000000000";
			assertFalse(ContactValidationUtil.validateMobile(wrongMobile));
			assertFalse(ContactValidationUtil.validateMobile(mobileRegEx, wrongMobile));
			
			wrongMobile = "+912200000000";
			assertFalse(ContactValidationUtil.validateMobile(wrongMobile));
			assertFalse(ContactValidationUtil.validateMobile(mobileRegEx, wrongMobile));
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	
	@Test
	public void testMailParse() {
		String mailRegEx = "(\\S[a-zA-Z0-9_.-]+@[a-zA-Z]+[.][a-zA-Z]{2,3})";
		String message =null;
		List<String> mails = null;
		try {
			assertNotNull(mailRegEx);
			assertNull(mails);
			
			message = "I have a single mail id as testing.test@testing.com";
			mails = ContactValidationUtil.retrieveMailId(message);
			assertNotNull(mails);
			assertEquals(1,mails.size());
			mails = null;

			message = "I have couple of mail id, test.testing@test.com and testing_t@t.in and these both can be used";
			mails = ContactValidationUtil.retrieveMailId(message);
			assertNotNull(mails);
			assertEquals(2,mails.size());
			mails = null;
			
			message = "I have a weir mail id as test@mail., this may not be considered";
			mails = ContactValidationUtil.retrieveMailId(message);
			assertNotNull(mails);
			assertEquals(0,mails.size());
			mails = null;
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testMobileParse() {
		String mailRegEx = "((\\+91)?[6-9][0-9]{9})";
		String message =null;
		List<String> mails = null;
		try {
			assertNotNull(mailRegEx);
			assertNull(mails);
			
			message = "I have a single mobile number as +917878787878 which is really nice";
			mails = ContactValidationUtil.retrieveMobile(message);
			assertNotNull(mails);
			assertEquals(1,mails.size());
			mails = null;

			message = "I have couple of mobile numbers, 7865665544 and +917889776655 and these can be used";
			mails = ContactValidationUtil.retrieveMobile(message);
			assertNotNull(mails);
			assertEquals(2,mails.size());
			
			mails = null;
			message = "I have a weired numbers +911113333 and 43335566, these may not be considered";
			mails = ContactValidationUtil.retrieveMobile(message);
			assertNotNull(mails);
			assertEquals(0,mails.size());
			mails = null;
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
