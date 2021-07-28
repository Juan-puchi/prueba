package cl.Ecamp.prueba.main;

import java.util.ArrayList;
import java.util.List;

import cl.Ecamp.prueba.modelo.CategoriaEnum;
import cl.Ecamp.prueba.modelo.Cliente;
import cl.Ecamp.prueba.servicio.ClienteServicio;
import cl.Ecamp.prueba.vista.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente c1 = new Cliente("1.111.111-1", "Goku", "Son", 102, CategoriaEnum.ACTIVO);
		Cliente c2 = new Cliente("1.111.111-2", "Son", "Goku", 103, CategoriaEnum.ACTIVO);
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteServicio cs = new ClienteServicio(clientes);
		cs.agregarCliente(c1);
		cs.agregarCliente(c2);
		List<String> lista = cs.listarClientes();
		lista.forEach(clienteI -> System.out.println(clienteI));
		
		cs.mostrarCliente("1.111.111-2");
		
		
		Menu menu = new Menu();
		menu.mostrarMenu();
		
		
	}

}
