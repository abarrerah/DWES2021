package PruebaInicial;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Operations.init();
		ArrayList myArray=new ArrayList();
		myArray.add(Operations.showAllEmployees());
		for(int i=0;i<myArray.size();i++) {
			System.out.print(myArray.get(i));
		}
	}

}
