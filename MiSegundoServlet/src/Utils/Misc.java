package Utils;

import org.apache.log4j.Logger;


public class Misc {
	
	final static Logger logger = Logger.getLogger(Misc.class);
	
	public static int addition(int operator1, int operator2) {
		
		logger.info("Before Misc.addition method invokation [Misc.class]");
		
		int result = operator1 + operator2; 
				
		logger.info("After Misc.addition method invokation [Misc.class]");
				
		return result;
	}

	public static int subtraction(int operator1, int operator2) {
		
		logger.info("Before Misc.subtraction method invokation [Misc.class]");
		
		int result = operator1-operator2;
		
		logger.info("After Misc.subtraction method invokation [Misc.class]");
		
		return result;
	}

}
