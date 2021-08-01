package cl.Ecamp.prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cl.Ecamp.prueba.modelo.CategoriaEnum;
import cl.Ecamp.prueba.modelo.Cliente;
import cl.Ecamp.prueba.servicio.ClienteServicio;

public class ClienteServicioTest {

	@Test
	public void agregarClienteTest() {

		ClienteServicio cs = new ClienteServicio();
		Cliente cliente = new Cliente("11111111-1", "pepito", "perez", 30, CategoriaEnum.ACTIVO);
		String run = "11111111-1";
		cs.agregarCliente(cliente);
		assertTrue(cs.buscarCliente(run));

	}

	@Test
	public void agregarClienteNullTest() {
		ClienteServicio cs = new ClienteServicio();
		Cliente cliente = new Cliente();
		String run = null;
		Boolean clienteNull = cs.buscarCliente(run);
		cs.agregarCliente(cliente);
		assertTrue(clienteNull = true);
	}

}
