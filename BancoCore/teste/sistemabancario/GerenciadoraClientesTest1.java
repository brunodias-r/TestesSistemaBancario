package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GerenciadoraClientesTest1 {
	
	@Test
	public void testePesquisaCliente() {
		/* ========== Montagem do cenário ========== */
		int idCliente01 = 1;
		int idCliente02 = 2;
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		Cliente cliente;
		
		cliente = gerClientes.pesquisaCliente(1);

		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("joaodasilva@gmail.com"));
		assertThat(cliente.getNome(), is("Joao da Silva"));
		
		cliente = gerClientes.pesquisaCliente(2);

		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getEmail(), is("mariadasilva@gmail.com"));
		assertThat(cliente.getNome(), is("Maria da Silva"));
	}

	@Test
	public void testeAdicionaCliente() {
		Cliente cliente03 = new Cliente(3, "João", 47, "joao@gmail.com", 3, true);
		Cliente cliente04 = new Cliente(4, "Gustavo", 10, "gustavo@gmail.com", 4, false);

		List<Cliente> clientes = new ArrayList<>();

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		gerClientes.adicionaCliente(cliente03);
		gerClientes.adicionaCliente(cliente04);
		
		assertThat(cliente03.getId(), is(3));
		assertThat(cliente03.getEmail(), is("joao@gmail.com"));
		assertThat(cliente03.getNome(), is("João"));
		
		assertThat(cliente04.getId(), is(4));
		assertThat(cliente04.getEmail(), is("gustavo@gmail.com"));
		assertThat(cliente04.getNome(), is("Gustavo"));
	}
	
	@Test
	public void testeRemoveCliente() {
		/* ========== Montagem do cenário ========== */
		int idCliente01 = 1;
		int idCliente02 = 2;
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		gerClientes = new GerenciadoraClientes(clientes);
		
		/* ========== Execução ========== */
		boolean clienteRemovido1 = gerClientes.removeCliente(idCliente01);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido1, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente01));
		
		boolean clienteRemovido2 = gerClientes.removeCliente(idCliente02);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido2, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));
		assertNull(gerClientes.pesquisaCliente(idCliente02));	
	}
	

	@Test
	public void testeClienteAtivo() {
		/* ========== Montagem do cenário ========== */
		int idCliente01 = 1;
		int idCliente02 = 2;
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, false);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		boolean clienteAtivo1 = gerClientes.clienteAtivo(idCliente01);

		assertThat(clienteAtivo1, is(true));
		assertThat(gerClientes.clienteAtivo(idCliente01), is(true));
		
		boolean clienteAtivo2 = gerClientes.clienteAtivo(idCliente02);

		assertThat(clienteAtivo2, is(false));
		assertThat(gerClientes.clienteAtivo(idCliente02), is(false));

	}
	
	@Test
	public void testeValidade() throws IdadeNaoPermitidaException {
		/* ========== Montagem do cen�rio ========== */
		int idCliente01 = 1;
		int idCliente02 = 2;
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		gerClientes.validaIdade(cliente01.getIdade());
		
		assertThat(cliente01.getId(), is(1));
		assertThat(cliente01.getEmail(), is("joaodasilva@gmail.com"));
		assertThat(cliente01.getNome(), is("Joao da Silva"));
		assertThat(cliente01.getIdade(), is(47));
				
	}
		
}
