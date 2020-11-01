
package persistenciadatos;

import static persistenciadatos.ManejoArchivos.*;

public class Main {

	public static void main(String[] args) {
		crearArchivo("archivo\\Hola.txt");
		//crearArchivo("C:\\JavaArchivos\\hola.txt");
		
		//escribirArchivo("archivo\\Hola.txt", "Hola desde Java");
		//escribirArchivo("archivo\\Hola.txt", "Hola Mundo");
		
		//leerArchivo("archivo\\Hola.txt");
		eliminarArchivo("archivo\\Hola.txt");
	}
	
}
