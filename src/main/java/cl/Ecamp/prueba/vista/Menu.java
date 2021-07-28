package cl.Ecamp.prueba.vista;

import java.util.List;
import java.util.Scanner;

import cl.Ecamp.prueba.modelo.CategoriaEnum;
import cl.Ecamp.prueba.modelo.Cliente;
import cl.Ecamp.prueba.servicio.ClienteServicio;

public class Menu {

	// clienteServicio, instancia de ClienteServicio.
	// archivoServicio, instancia de ArchivoServicio.
	// exportadorCsv, instancia de ExportarCsv.
	// exportarTxt, instancia de ExportarTxt.
//	List<String> lista = cs.listarClientes();
//	lista.forEach(clienteI -> System.out.println(clienteI));
//		
//	cs.agregarCliente(c1);
//	cs.agregarCliente(c2);

	public void mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		ClienteServicio cs = new ClienteServicio();
		String opcion = "";
		int numeroMenu;
		boolean salir = false;
		String run, nombre, apellido;
		int anios, numero, numero2;
		Cliente cliente;

		do {
			System.out.println("1.- Listar Clientes\n" +
								"2.- Agregar Cliente\n" +
								"3.- Editar Cliente\n"+
								"4.- Cargar Datos\n" +
								"5.- Exportar Datos\n" +
								"6.- Salir\n" + 
								"Ingrese una opción:");
			
			opcion = sc.nextLine();
			numeroMenu = Integer.parseInt(opcion);

			switch (numeroMenu) {
			
			case 1:
				cs.listarClientes().forEach(clienteI -> System.out.println(clienteI));
				break;

			case 2:
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
				break;
				// System.out.println("");
			
			case 3:
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
						run = sc.nextLine();
						cliente.setRunCliente(run);
						break;
					case 2:
						System.out.println("Ingrese el nuevo nombre del cliente: ");
						nombre = sc.nextLine();
						cliente.setNombreCliente(nombre);
						break;
					case 3:
						System.out.println("Ingrese el nuevo apellido del cliente: ");
						apellido = sc.nextLine();
						cliente.setApellidoCliente(apellido);
						break;
					case 4:
						System.out.println("Ingrese los años del cliente: ");
						anios = Integer.parseInt(sc.nextLine());
						cliente.setAniosCliente(anios);
						break;
					default:
						System.out.println("La opción ingresada no es correcta. Volverá al Menú.\n");
						break;
					}

				}
				

			case 4:
				System.out.println("Ingresa la ruta en donde desea exportar el archivo");
				String ruta = sc.nextLine();

				System.out.println("Datos cargados correctamente en la lista.\n");
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
