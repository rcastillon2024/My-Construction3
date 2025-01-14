package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	Connection con;
	public Connection conectar() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myconstruction","root","samy2023");
		System.out.print("Conectado a DB ");
	}catch(Exception e) {}
	
	return con;

	}
	
	
	
	public void desconectar() {
		
	try {
		con.close();
	}
	catch (SQLException e){
		e.printStackTrace();
	}
		
	}
	
	
}
