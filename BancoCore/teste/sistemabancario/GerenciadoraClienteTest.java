package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GerenciadoraClienteTest {
	@Test
	public void testePesquisarCliente(){
		//criando clientes
		Cliente cliente01 = new Cliente(1,"Clayton",47,"clayton@gmail.com",1, true);
		Cliente cliente02 = new Cliente(2,"Maria",10,"maria@gmail.com",2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
	}
}

/*
 	@Test
	public void testePesquisarCliente(){
		//criando clientes
		Cliente cliente01 = new Cliente(1,"Clayton",47,"clayton@gmail.com",1, true);
		Cliente cliente02 = new Cliente(2,"Maria",10,"maria@gmail.com",2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		
		GerenciadoraClientesTest gerClientes = new GerenciadoraClientes(clientes);
		
		Cliente cliente = gerClientes.testePesquisarCliente(1);
		
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
	}
 */