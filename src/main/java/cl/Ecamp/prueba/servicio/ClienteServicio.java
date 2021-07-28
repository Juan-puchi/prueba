package cl.Ecamp.prueba.servicio;

import java.util.List;
import java.util.stream.Collectors;

import cl.Ecamp.prueba.modelo.Cliente;


public class ClienteServicio {

	List<Cliente> listaClientes;

	public ClienteServicio() {
	}	
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
	
	//Castear como buscar cliente
	public void mostrarCliente(String run) {
		listaClientes.stream().filter(cliente -> cliente.getRunCliente().equals(run)).map(cliente -> 
				"-------------Actualizando datos del Cliente-------------"
				+ "\n1.-El RUN del Cliente es: "+cliente.getRunCliente()
				+ "\n2.-El Nombre del Cliente es: "+cliente.getNombreCliente()
				+ "\n3.-El Apellido del Cliente es: "+cliente.getApellidoCliente()
				+ "\n4.-Los años como Cliente son: "+cliente.getAniosCliente()
				+ "\n-------------------------------------------").
				forEach(cliente ->System.out.println(cliente));
	}
	
	public Cliente buscarCliente(String run) {
		return (Cliente) listaClientes.stream().filter(cliente -> cliente.getRunCliente().equals(run));
	}
	

}
