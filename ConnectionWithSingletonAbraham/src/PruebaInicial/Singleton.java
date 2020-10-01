package PruebaInicial;
import java.sql.*;

public class Singleton {
	private static Connection singleton=null;
	
	private static String url="jdbc:mysql://172.17.0.2:3306/classicmodels";
	private static String driver="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String password="12345";
	
	private Singleton() {
		
	}
	public static  Connection getConnection() throws SQLException, ClassNotFoundException {
		if(singleton==null ) {
			Class.forName(driver);
			singleton=DriverManager.getConnection(url, user, password);
		}else {
			System.out.println("The user already have the connection established");
		}
		return singleton;
	}
	
	public static void closeConnection() {
		try {
			singleton.close();
		}catch(Exception e){
			
		}
	}
	
	

}
