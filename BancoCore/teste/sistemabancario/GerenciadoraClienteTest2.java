package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClienteTest2 {
	
	private GerenciadoraClientes gerClientes; 
	private int idCliente01= 1;
	private int idCliente02= 2;
	
	@Before
	public void setUp() {
		/* Montagem de cenário global */
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
	}
	
	@After
	public void tearDown() {
		/* Desmontagem do cenário global */
		gerClientes.limpa();
	}
	
	@Test
	public void testePesquisaCliente() {
		
		/* Montagem do cenário */
		//int idCliente01 = 1;
		//int idCliente02 = 2;
		
		/* Criando clientes */
//		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1, true);
//		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 2, true);

//		List<Cliente> clientes = new ArrayList<>();
//		clientes.add(cliente01);
//		clientes.add(cliente02);

//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		Cliente cliente;
		
		cliente = gerClientes.pesquisaCliente(idCliente01);

		assertThat(cliente.getId(), is(idCliente01));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
		assertThat(cliente.getNome(), is("Clayton"));
		
		cliente = gerClientes.pesquisaCliente(idCliente02);

		assertThat(cliente.getId(), is(idCliente02));
		assertThat(cliente.getEmail(), is("maria@gmail.com"));
		assertThat(cliente.getNome(), is("Maria"));
	}

	@Test
	public void testeAdicionaCliente() {
		Cliente cliente01 = new Cliente(3, "João", 47, "joao@gmail.com", 3, true);
		Cliente cliente02 = new Cliente(4, "Gustavo", 10, "gustavo@gmail.com", 4, false);
//
//		List<Cliente> clientes = new ArrayList<>();
//
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
//
//		gerClientes.adicionaCliente(cliente03);
//		gerClientes.adicionaCliente(cliente04);
		
		assertThat(cliente01.getId(), is(3));
		assertThat(cliente01.getEmail(), is("joao@gmail.com"));
		assertThat(cliente01.getNome(), is("João"));
		
		assertThat(cliente02.getId(), is(4));
		assertThat(cliente02.getEmail(), is("gustavo@gmail.com"));
		assertThat(cliente02.getNome(), is("Gustavo"));
	}
	
	@Test
	public void testeRemoveCliente() {
		
		/* Montagem do cenário */
		int idCliente01 = 1;
		int idCliente02 = 2;
		
		/* Clientes */
		Cliente cliente05 = new Cliente(idCliente01, "Pedro", 40, "pedroC@gmail.com", 3, true);
		Cliente cliente06 = new Cliente(idCliente02, "Katarina", 41, "katarinaP@gmail.com", 4, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente05);
		clientes.add(cliente06);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//Fase de execução
		boolean clienteRemovido01 = gerClientes.removeCliente(idCliente01);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido01, is(true));//Retorna que o cliente foi removido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente01));//Esse método verifica se o cliente excluído está na lista.
		
		//Fase de execução
		boolean clienteRemovido02 = gerClientes.removeCliente(idCliente02);
		//Análise do resultado esperado
		assertThat(clienteRemovido02, is(true));//Retorna que o cliente foi removido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente02));//Esse método verifica se o cliente excluído está na lista.
	
	}

	@Test
	public void testeClienteAtivo() {
		Cliente cliente05 = new Cliente(5, "Pedro", 47, "pedro@gmail.com", 5, true);
		Cliente cliente06 = new Cliente(6, "Guilherme", 20, "guilherme@gmail.com", 6, false);

		List<Cliente> clientes = new ArrayList<>();

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		gerClientes.clienteAtivo(5);
		
		assertThat(cliente05.getId(), is(5));
		assertThat(cliente05.getEmail(), is("pedro@gmail.com"));
		assertThat(cliente05.getNome(), is("Pedro"));
		
		gerClientes.clienteAtivo(6);
		
		assertThat(cliente06.getId(), is(6));
		assertThat(cliente06.getEmail(), is("guilherme@gmail.com"));
		assertThat(cliente06.getNome(), is("Guilherme"));
	}
	
	@Test
	public void testeValidade() throws IdadeNaoPermitidaException {
		Cliente cliente05 = new Cliente(5, "Pedro", 47, "pedro@gmail.com", 5, true);
		Cliente cliente06 = new Cliente(6, "Guilherme", 20, "guilherme@gmail.com", 6, false);
		
		List<Cliente> clientes = new ArrayList<>();

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		gerClientes.validaIdade(cliente05.getIdade());
		gerClientes.validaIdade(cliente06.getIdade());
		
		assertThat(cliente05.getId(), is(5));
		assertThat(cliente05.getEmail(), is("pedro@gmail.com"));
		assertThat(cliente05.getNome(), is("Pedro"));
		assertThat(cliente05.getIdade(), is(47));
				
		assertThat(cliente06.getId(), is(6));
		assertThat(cliente06.getEmail(), is("guilherme@gmail.com"));
		assertThat(cliente06.getNome(), is("Guilherme"));
		assertThat(cliente06.getIdade(), is(20));
	}
	
	
}
