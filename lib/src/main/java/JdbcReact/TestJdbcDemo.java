package JdbcReact;

import java.sql.Connection;
import java.sql.DriverManager;

class Employee {
	
	public void display() {
		System.out.println("Welcome");
	}
}

public class TestJdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException {
	try {
 Class.forName("org.postgresql.Driver");
 
  System.out.println("ok");
  Connection connection = 
  DriverManager.getConnection("jdbc:postgresql://localhost:5432/JdbcDemo_tb1", "postgres", "Srini#123");
      System.out.println(connection);
	}
	catch(Exception e) {
		System.out.println("Linking problem");
	}
  }

}
