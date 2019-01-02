/**
 * 
 */
package org.hanamant.util.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hguggari
 *
 */
public class ContactValidationUtil {
	private ContactValidationUtil() {
	}
	
	/**
	 * Validates the emailId again the email pattern
	 * Pattern : considers (^, a-z, A-Z, 0-9, _-., @, a-z, A-Z, [.], then a-z, A-Z{2,3})$
	 * @param emailId
	 * @return boolean flag indicating validation of mail id against pattern
	 * @throws Exception
	 */
	public static boolean validateEmailId(String emailId) throws Exception {
		String emailRegEx = "^[a-zA-Z_0-9.-]+@[a-zA-Z]+[.][a-zA-Z]{2,3}$";
		try {
			return Pattern.matches(emailRegEx, emailId);
		} catch(Exception ex) {
			throw ex;
		} 
	}
	
	/**
	 * Method parses the message against regex and list the result into list and returns the same
	 * @param regEx
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static List<String> retrieveMailId(String message) throws Exception {
		String emailRegEx = "(\\S[a-zA-Z_0-9.-]+@[a-zA-Z]+[.][a-zA-Z]{2,3})";
		List<String> mailList = new ArrayList<String>();
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			pattern = Pattern.compile(emailRegEx);
			matcher = pattern.matcher(message);
			while(matcher.find()) {
				mailList.add(matcher.group());
			}
		} catch(Exception ex) {
			throw ex;
		}
		return mailList;
	}
	
	/**
	 * Validated the given emailId against the given regEx pattern
	 * @param regEx
	 * @param emailId
	 * @return boolean flag indicating validation of mail id against pattern
	 * @throws Exception
	 */
	public static boolean validateEmailId(String regEx, String emailId) throws Exception {
		try {
			return Pattern.matches(regEx, emailId);
		} catch(Exception ex) {
			throw ex;
		} 
	}
	
	/**
	 * Method parses the message against regex and list the result into list and returns the same
	 * @param regEx
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static List<String> retrieveMailId(String regEx, String message) throws Exception {
		List<String> mailList = new ArrayList<String>();
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			pattern = Pattern.compile(regEx);
			matcher = pattern.matcher(message);
			while(matcher.find()) {
				mailList.add(matcher.group());
			}
		} catch(Exception ex) {
			throw ex;
		}
		return mailList;
	}
	
	
	/**
	 * Validate the Indian mobile number, checks to see that mobile numbe should start with 6 to 9
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static boolean validateMobile(String mobile) throws Exception {
		String mobileRegEx = "^((\\+91)?[6-9][0-9]{9})$";
		try {
			return Pattern.matches(mobileRegEx, mobile);
		} catch(Exception ex) {
			throw ex;
		}
	}
	/**
	 * Method parses the message against regex and list the result into list and returns the same
	 * @param regEx
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static List<String> retrieveMobile(String message) throws Exception {
//		String mobileRegEx = "((91)?[6-9][0-9]{9})";
		String mobileRegEx = "((\\+*)((0[-]+)*|(91)*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}";
		List<String> mobileList = new ArrayList<String>();
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			pattern = Pattern.compile(mobileRegEx);
			matcher = pattern.matcher(message);
			while(matcher.find()) {
				mobileList.add(matcher.group());
			}
		} catch(Exception ex) {
			throw ex;
		}
		return mobileList;
	}
	
	
	/**
	 * Validates the mobile number against given regex 
	 * @param regEx
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static boolean validateMobile(String regEx, String mobile) throws Exception {
		try {
			return Pattern.matches(regEx, mobile);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * Method parses the message against regex and list the result into list and returns the same
	 * @param regEx
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static List<String> retrieveMobile(String regEx, String message) throws Exception {
		List<String> mobileList = new ArrayList<String>();
		Pattern pattern = null;
		Matcher matcher = null;
		try {
			pattern = Pattern.compile(regEx);
			matcher = pattern.matcher(message);
			while(matcher.find()) {
				mobileList.add(matcher.group());
			}
		} catch(Exception ex) {
			throw ex;
		}
		return mobileList;
	}
	

	public static void main(String[] args) throws Exception {
		List<String> list = retrieveMobile("I have a weir numbers +9111133338  and 43335566, these may not be considered");
		System.out.println(list.size());
	}
}
