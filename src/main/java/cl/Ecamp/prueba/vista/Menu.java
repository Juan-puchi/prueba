package cl.Ecamp.prueba.vista;

import java.util.Scanner;

public class Menu {

	public void mostrarMenu() {
		int numeroMenu;
		String opcion = "";
		Scanner sc = new Scanner(System.in);
		MetodosMenu mn = new MetodosMenu();
		
		boolean salir = false;
		
		do {
			System.out.println("1.- Listar Clientes\n" + "2.- Agregar Cliente\n" + "3.- Editar Cliente\n"
					+ "4.- Importar Datos\n" + "5.- Exportar Datos\n" + "6.- Salir\n" + "Ingrese una opción:");

			opcion = sc.nextLine();
			numeroMenu = Integer.parseInt(opcion);

			// System.out.println("");
			switch (numeroMenu) {
			case 1:
				mn.listarClientes();
				break;

			case 2:
				mn.agregarCliente();
				break;

			case 3:
				mn.editarCliente();
				break;

			case 4:
				mn.importarDatos();
				break;

			case 5:
				mn.exportarDatos();
				break;
				
			case 6:
				salir = true;
				break;

			default:
				System.out.println("La opción ingresada no es correcta. Volverá al Menú.\n");
				break;
			}

		} while (!salir);

		sc.close();
	}	

}
