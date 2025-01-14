package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.Conexion;

public class daoUsuario {

public static int validar(String usuario, String password) {
		
		Connection con;
		Conexion cn = new Conexion();
		
		PreparedStatement ps;
		ResultSet rs;
		String us = "";
		int valido = 0;
		
		try {
			
			con = cn.conectar();
			ps = con.prepareStatement("Select * from usuario where nombreUsuario = ?");
			ps.setString(1,usuario);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = rs.getString("nombreUsuario");
			}
			if(us.equals(usuario)) {
				valido = 1;
				cn.desconectar();
			}else {
				valido = 0;
				cn.desconectar();
			}
		}catch(Exception e) {}
		
		return valido;
		
	}

}
