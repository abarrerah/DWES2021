package PruebaInicial;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Operations {
	public static ArrayList showAllEmployees() throws SQLException, ClassNotFoundException {
		Connection con=Singleton.getConnection();
		ArrayList myArray=new ArrayList();
		try {
			Statement statement=con.createStatement();
			statement.setQueryTimeout(150);
			ResultSet rs=statement.executeQuery("SELECT firstName,lastName,jobTitle FROM employees");
		
			
			while(rs.next()) {
			myArray.add(rs.getString("firstName"));
			myArray.add(rs.getString("lastName"));
			myArray.add(rs.getString("jobTitle"));
			}
			for (Object object : myArray) {
				System.out.println(object);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return myArray;
	}
	
	public static void showAllOrderFromAClientNumber() throws SQLException, ClassNotFoundException {
		Connection con=Singleton.getConnection();
		Scanner sc=new Scanner(System.in);
		int customerNumber=sc.nextInt();
		try {
			
            Statement statement=con.createStatement();
            statement.setQueryTimeout(30);

            ResultSet rs=statement.executeQuery("Select c.customerName, p.productName,o.orderNumber,o.orderDate,od.priceEach FROM customers c\n"
            		+ "Inner join orders o On c.customerNumber=o.customerNumber\n"
            		+ "Inner join orderdetails od ON o.orderNumber=od.orderNumber\n"
            		+ "Inner join products p ON od.productCode=p.productCode\n"
            		+ "Where c.customerNumber="+"'"+customerNumber+"'"+";");

            while (rs.next()){
                System.out.println("    ------------------------------------------------------------------");
                System.out.println("    Customer Name: "+rs.getString("customerName"));
                System.out.println("    Product Name: "+rs.getString("ProductName"));
                System.out.println("    Order Number: "+rs.getInt(3));
                System.out.println("    Order Date: "+rs.getDate(4));
                System.out.println("    Price each: "+rs.getInt(5));
                System.out.println("    ------------------------------------------------------------------");
		}
	            }catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}    public static  void getMostSaledProduct() throws SQLException, ClassNotFoundException{
		Connection con=Singleton.getConnection();
        try {
            Statement statement=con.createStatement();
            statement.setQueryTimeout(30);

            ResultSet rs=statement.executeQuery("Select p.productName,SUM(od.quantityOrdered) as 'Cantidad' from products p \n" +
                    "INNER JOIN orderdetails od ON p.productCode=od.productCode\n" +
                    "INNER JOIN orders o ON od.orderNumber=o.orderNumber\n" +
                    "WHERE year(o.orderDate)='2003'\n" +
                    "GROUP BY p.productName\n" +
                    "ORDER BY SUM(od.quantityOrdered) DESC\n" +
                    "Limit 1;");

            while (rs.next()){
                System.out.println("    ------------------------------------------------------------------");
                System.out.println("    | Product Name: "+rs.getString("productName")+"                      |");
                System.out.println("    | Quantity : "+rs.getInt(2)+"                                                 |");
                System.out.println("    ------------------------------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (con !=null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static  void getLessMotorBikeSold() throws SQLException, ClassNotFoundException{
    	Connection con=Singleton.getConnection();
        try {
            Statement statement=con.createStatement();
            statement.setQueryTimeout(30);

            ResultSet rs=statement.executeQuery("Select p.productName,SUM(od.quantityOrdered) as 'Cantidad' from products p \n" +
                    "INNER JOIN orderdetails od ON p.productCode=od.productCode\n" +
                    "INNER JOIN orders o ON od.orderNumber=o.orderNumber\n" +
                    "WHERE p.productLine=\"Motorcycles\"\n" +
                    "GROUP BY p.productName\n" +
                    "ORDER BY SUM(od.quantityOrdered) ASC\n" +
                    "Limit 1;");

            while (rs.next()){
                System.out.println("    ------------------------------------------------------------------");
                System.out.println("    | Product Name: "+rs.getString("productName")+"                      |");
                System.out.println("    | Quantity : "+rs.getInt(2)+"                                                 |");
                System.out.println("    ------------------------------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (con !=null){
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void insertCustomer() {
    	Scanner sc=new Scanner(System.in);
    	try {
    		Connection con=Singleton.getConnection();
    		PreparedStatement ps=con.prepareStatement("INSERT INTO customers VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		System.out.println("Please,insert the customer number");
    		int customerNumber=sc.nextInt();
    		ps.setInt(1, customerNumber);
    		System.out.println("Please, insert the customer name");
    		String cName=sc.next();
    		ps.setString(2, cName);
    		System.out.println("Please, insert the Last name");
    		String lName=sc.next();
    		ps.setString(3, lName);
    		System.out.println("Please, insert the first name");
    		String fName=sc.next();
    		ps.setString(4, fName);
    		System.out.println("Please, insert a phone number");
    		String pNumber=sc.next();
    		ps.setString(5, pNumber);
    		System.out.println("Please, insert a address");
    		String address1=sc.next();
    		ps.setString(6, address1);
    		System.out.println("Please, insert an optional secondary address");
    		String address2=sc.next();
    		ps.setString(7, address2);
    		System.out.println("Please, insert the city");
    		String city=sc.next();
    		ps.setString(8, city);
    		System.out.println("Please, insert the state");
    		String state=sc.next();
    		ps.setString(9, state);
    		System.out.println("Please, insert a postal code");
    		String postalCode=sc.next();
    		ps.setString(10,postalCode);
    		System.out.println("Please, insert the country");
    		String country=sc.next();
    		ps.setString(11, country);
    		System.out.println("Please, insert the employeer number");
    		int employeerNumber=sc.nextInt();
    		ps.setInt(12, employeerNumber);
    		System.out.println("Please, insert the credit limit");
    		double creditLimit=sc.nextDouble();
    		ps.setDouble(13, creditLimit);
    		
    		ps.execute();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public static void init() throws SQLException, ClassNotFoundException{
        Scanner sc=new Scanner(System.in);
        System.out.println("1-Show all invoice for a customers."+'\n'+
                "2-Show the best-selling item in 2003"+'\n'+
                "3-Show least sold motorcycle"+'\n'+
                "4-Show all employees"+'\n'+
                "5-Insert a new customer"+'\n'+
                "6-Quit");
        int k=sc.nextInt();
        while (k<6){
            switch (k){
                case 1:showAllOrderFromAClientNumber(); 
                break;
                case 2:getMostSaledProduct();
                    break;
                case 3:getLessMotorBikeSold();
                    break;
                case 4:showAllEmployees();
                    break;
                case 5:insertCustomer();
                break;

            }
            System.out.println("1-Show all invoice for a customers."+'\n'+
                    "2-Show the best-selling item in 2003"+'\n'+
                    "3-Show least sold motorcycle"+'\n'+
                    "4-Show all employees"+'\n'+
                    "5-Insert a new customer"+'\n'+
                    "6-Quit");
            k=sc.nextInt();
        }


}}
