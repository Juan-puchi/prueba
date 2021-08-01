package cl.Ecamp.prueba.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import cl.Ecamp.prueba.modelo.Cliente;

public class ExportadorCsv extends Exportador {

	public void exportar(String fileName, List<Cliente> listaClientes) {

		try {
			File fichero = new File("src/main/java/datos/" + fileName + ".csv");
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Cliente cliente : listaClientes) {
				bw.write(cliente.toString());
				bw.newLine();
			}

			System.out.println("Datos de clientes exportados correctamente en formato csv.\n");

			bw.close();

		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}
}
