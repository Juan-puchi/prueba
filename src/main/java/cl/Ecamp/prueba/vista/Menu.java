package cl.Ecamp.prueba.vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.Ecamp.prueba.modelo.CategoriaEnum;
import cl.Ecamp.prueba.modelo.Cliente;
import cl.Ecamp.prueba.servicio.ClienteServicio;

public class Menu {

	// archivoServicio, instancia de ArchivoServicio.
	// exportadorCsv, instancia de ExportarCsv.
	// exportarTxt, instancia de ExportarTxt.

	ClienteServicio cs = new ClienteServicio();
	Scanner sc = new Scanner(System.in);
	String opcion = "";
	int numeroMenu;
	boolean salir = false;
	String run, nombre, apellido;
	int anios, numero, numero2;
	Cliente cliente;
	String dato;

	public void mostrarMenu() {

		do {
			System.out.println("1.- Listar Clientes\n" + "2.- Agregar Cliente\n" + "3.- Editar Cliente\n"
					+ "4.- Importar Datos\n" + "5.- Exportar Datos\n" + "6.- Salir\n" + "Ingrese una opción:");

			opcion = sc.nextLine();
			numeroMenu = Integer.parseInt(opcion);

			// System.out.println("");
			switch (numeroMenu) {
			case 1:
				listarClientes();
				break;

			case 2:
				agregarCliente();
				break;

			case 3:
				editarCliente();
				break;

			case 4:
				importarDatos();

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

	public void listarClientes() {
		cs.listarClientes().forEach(clienteI -> System.out.println(clienteI));
	}

	public void agregarCliente() {
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente:");
		run = sc.nextLine();
		System.out.println("Ingresa Nombre del Cliente:");
		nombre = sc.nextLine();
		System.out.println("Ingresa Apellido del Cliente:");
		apellido = sc.nextLine();
		System.out.println("Ingresa años como Cliente:");
		anios = Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------------------");
		cliente = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		cs.agregarCliente(cliente);
	}

	public void editarCliente() {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion:");
		System.out.println("----------------------------------------");
		numero = Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese RUN del Cliente a editar:");
		run = sc.nextLine();
		cliente = cs.buscarCliente(run);

		if (numero == 1) {
			System.out.println("-----Actualizando estado del Cliente----");
			System.out.println("El estado actual es:" + cliente.getNombreCategoria());
			System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
			System.out.println("2.-Si desea mantener el estado del cliente Activo");
			System.out.println("Ingrese opcion:");
			System.out.println("----------------------------------------");
			numero = Integer.parseInt(sc.nextLine());
			if (numero == 1)
				cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
			else if (numero == 2)
				cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
			else
				System.out.println("Parámetro ingresado no corresponde");

		} else if (numero == 2) {
			cs.mostrarCliente(run);
			System.out.println("Ingrese opcion a editar de los datos del cliente:");
			System.out.println("----------------------------------------");
			numero = Integer.parseInt(sc.nextLine());
			cliente = cs.buscarCliente(run);

			switch (numero) {
			case 1:
				System.out.println("Ingrese el nuevo run del cliente: ");
				dato = sc.nextLine();

				break;
			case 2:
				System.out.println("Ingrese el nuevo nombre del cliente: ");
				dato = sc.nextLine();

				break;
			case 3:
				System.out.println("Ingrese el nuevo apellido del cliente: ");
				dato = sc.nextLine();

				break;
			case 4:
				System.out.println("Ingrese los años del cliente: ");
				dato = (sc.nextLine());

				break;
			default:
				System.out.println("La opción ingresada no es correcta. Volverá al Menú.\n");
				break;
			}
			cs.editarCliente(numero, dato);
		}

	}

	public void importarDatos() {
		System.out.println("Ingresa la ruta donde se encuentra el archivo DBClientes.csv");
		String ruta = sc.nextLine();
		File archivo = new File(ruta + "/DBClientes.csv");
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			ArrayList<Cliente> clientesImportados = new ArrayList<Cliente>();

			while (linea != null) {
				linea.split(",");
				String[] datos = linea.split(",");

				if (datos[4].equals("Activo"))

					cliente = new Cliente(datos[0], datos[1], datos[2], Integer.parseInt(datos[3].substring(0, 1)),
							CategoriaEnum.ACTIVO);

				else
					cliente = new Cliente(datos[0], datos[1], datos[2], Integer.parseInt(datos[3].substring(0, 1)),
							CategoriaEnum.INACTIVO);
				
				clientesImportados.add(cliente);
				
				linea= br.readLine();
				
			}
			
			cs.agregarCliente(clientesImportados);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Datos cargados correctamente en la lista.\n");

	}

}
