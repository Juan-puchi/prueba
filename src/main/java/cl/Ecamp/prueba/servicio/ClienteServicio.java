package cl.Ecamp.prueba.servicio;

import java.util.List;
import java.util.stream.Collectors;

import cl.Ecamp.prueba.modelo.Cliente;


public class ClienteServicio {

	List<Cliente> listaClientes;

	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}
	
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	public List<String> listarClientes() {
		List<String> lista = listaClientes.stream().map(cliente -> 
				"-------------Datos del Cliente-------------"
				+ "\n     RUN del Cliente: "+cliente.getRunCliente()
				+ "\n     Nombre del Cliente: "+cliente.getNombreCliente()
				+ "\n     Apellido del Cliente: "+cliente.getApellidoCliente()
				+ "\n     Años como Cliente: "+cliente.getAniosCliente()
				+ "\n     Categoría del Cliente: "+cliente.getNombreCategoria()
				+ "\n-------------------------------------------").collect(Collectors.toList());	
		return lista;
	}
	
	
	


	
	
//	-------------Datos del Cliente-------------
//	RUN del Cliente: 12.123.412-2
//	Nombre del Cliente: Nicolas
//	Apellido del Cliente: Cake
//	Años como Cliente: 7 años
//	Categoría del Cliente: Activo
//	-------------------------------------------
//	-------------Datos del Cliente-------------
//	RUN del Cliente: 25.673.022-2
//	Nombre del Cliente: Taylor
//	Apellido del Cliente: Shift S.
//	Años como Cliente: 1 día
//	Categoría del Cliente: Activo
//	-------------------------------------------
	
}
