
package com.oregoom.mensajes;

import java.sql.*;

public class Main {
	public static void main(String[] args) throws SQLException {
		listarRegistros();
		//insertarRegistros("Hola des Java", "Roel");
		//editarRegistros("Hola desde Java", "Java", 4);
		eliminarRegistros(5);
		listarRegistros();
	}
	
	static void listarRegistros() throws SQLException{
		Connection conectar = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"123456"
		);
		
		System.out.println("Conexion Exitosa");
		
		String sql = "SELECT * FROM mensajes";
		PreparedStatement ps = conectar.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {			
			int id = rs.getInt("id_mensaje");
			String memsaje = rs.getString("mensaje");
			String autor = rs.getString("autor");
			String fecha = rs.getString("fecha");
			
			System.out.printf("%d %s %s %s\n", id, memsaje,autor,fecha);
		}
		
		rs.close();
		ps.close();
		conectar.close();
	}
	
	static void insertarRegistros(String mensaje, String autor) throws SQLException{
		Connection conectar = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"123456"
		);
		
		System.out.println("Conexion Exitosa");
		
		String sql = "INSERT INTO mensajes(mensaje,autor,fecha) VALUES (?,?, CURRENT_TIME())";
		PreparedStatement ps = conectar.prepareStatement(sql);
		ps.setString(1, mensaje);
		ps.setString(2, autor);
		ps.executeUpdate();
		
		
		ps.close();
		conectar.close();
	}

	static void editarRegistros(String mensaje, String autor, int id) throws SQLException{
		Connection conectar = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"123456"
		);
		
		//System.out.println("Conexion Exitosa");
		
		String sql = "UPDATE mensajes SET mensaje=?, autor=? WHERE id_mensaje = ?";
		PreparedStatement ps = conectar.prepareStatement(sql);
		ps.setString(1, mensaje);
		ps.setString(2, autor);
		ps.setInt(3, id);
		ps.executeUpdate();
		
		
		ps.close();
		conectar.close();
	}

	static void eliminarRegistros(int id) throws SQLException{
		Connection conectar = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"123456"
		);
		
		//System.out.println("Conexion Exitosa");
		
		String sql = "DELETE FROM mensajes WHERE id_mensaje = ?";
		PreparedStatement ps = conectar.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
		ps.close();
		conectar.close();
	}
}
