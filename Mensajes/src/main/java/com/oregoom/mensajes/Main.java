

package com.oregoom.mensajes;

import java.sql.SQLException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Conexion.getConexion();
		//System.out.println("Conexion exitosa");
		MensajeDao mensajeDao = new MensajeDao();
		
		//Mensaje msm = new Mensaje("Hola desde Main", "Main");
		//int registro = mensajeDao.inserta(msm);
		//System.out.println("Se inserto "+ registro+" registro");
		
		//Mensaje msm = new Mensaje(1, "Hola desde Java Web", "Java Web");
		//int registro = mensajeDao.editar(msm);
		//System.out.println("Se edito "+ registro+" registro");
		
		//Mensaje msm = new Mensaje(6);
		//int registro = mensajeDao.eliminar(msm);
		//System.out.println("Se elimino "+ registro+" registro");
		
		List<Mensaje> mensajes = mensajeDao.seleccionar();
		
		for (Mensaje mensaje : mensajes) {
			System.out.println(mensaje);
		}
		
	}
}
