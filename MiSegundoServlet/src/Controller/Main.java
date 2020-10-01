package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import Utils.Misc;

public class Main {
	final static Logger logger=Logger.getLogger(Main.class);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("Before methods invokation [Main.class]");
		Operations.init();
		int result = Misc.addition(5,7);
		result = Misc.subtraction(result,3);
		
		logger.info("After methods invokation [Main.class]");
	}

}
