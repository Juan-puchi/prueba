package cl.Ecamp.prueba.vista;

import java.io.File;
import java.util.Scanner;

import cl.Ecamp.prueba.servicio.ArchivoServicio;
import cl.Ecamp.prueba.servicio.ClienteServicio;
import cl.Ecamp.prueba.modelo.CategoriaEnum;
import cl.Ecamp.prueba.modelo.Cliente;

public class MetodosMenu {
	ClienteServicio cs = new ClienteServicio();
	ArchivoServicio as = new ArchivoServicio(cs);
	Scanner sc = new Scanner(System.in);
	String run, nombre, apellido;
	int anios, numero;
	Cliente cliente;
	String dato;
	
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
		System.out.println(cliente);
		cs.agregarCliente(cliente);
		System.out.println(cs.getListaClientes().size());
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
		if (cs.buscarCliente(run)) {
			cliente = cs.getCliente(run);
	
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
				cs.editarCliente(run, numero, dato);
			}
		}else
			System.out.println("El run ingresado no es corresponde a un cliente.");
	}

	public void importarDatos() {
		System.out.println("Ingresa la ruta donde se encuentra el archivo DBClientes.csv");
		String ruta = sc.nextLine();
		File directorio = new File(ruta);
		File archivo = new File(ruta + "/DBClientes.csv");
		
		if(directorio.exists()) {
			if(archivo.exists()) {
				as.importarDatos(archivo);
			}else
				System.out.println("El archivo no existe");
		}
		else
			System.out.println("El directorio no existe");
	}
	
	public void exportarDatos() {
		System.out.println("Elija un tipo de datos a exportar:");
		System.out.println("1.- CSV");
		System.out.println("2.- TXT");
		numero = Integer.parseInt(sc.nextLine());
		
		if(numero == 1 | numero == 2)
			as.exportarDatos(numero, "Clientes");
		else
			System.out.println("El número ingresado no corresponde a una opción. \nRegresará al Menú.");
	}
	
	
	
}
