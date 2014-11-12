package br.com.gymtraining.database;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseFactory {

	private static Connection connection;

	public static Connection getConnection() throws SQLException, InstantiationException, 
											IllegalAccessException, ClassNotFoundException{
		return getConnection("localhost", "gymtraining");
	}
	
	public static Connection getConnection(String dbAddress, String dbName)
			throws SQLException, InstantiationException, IllegalAccessException, 
					ClassNotFoundException {
		
		String url = "jdbc:mysql://"+ dbAddress + "/" + dbName;
		
		Class.forName ("com.mysql.jdbc.Driver").newInstance ();

		if(connection == null){
			
			connection = DriverManager.getConnection(url, "root", "");
		}
		
		System.out.println("Conectado!");
		
		return connection;
	}
	
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DataBaseFactory.getConnection("localhost", "gymtraining");
	}

}
