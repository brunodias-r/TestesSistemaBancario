package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest2 {
			
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
		//************* Montagem do cenário global **********//
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
	
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
	
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}
	
	@After
	public void tearDown() {
		//************* Desmontagem do cenário global **********//
		gerClientes.limpa();
	}

	@Test
	public void testpesquisaCliente(){
	
		/*Criando clientes*/
		//Definição e inicialização do cenário.
		//Cliente cliente01 = new Cliente(idCliente01, "Guilherme", 30, "guilherme@gmail.com", 1, true);
		//Cliente cliente02 = new Cliente(idCliente02, "Gabriel", 23, "gabriel@gmail.com", 2, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		//List<Cliente> clientes = new ArrayList<>();
		//clientes.add(cliente01);
		//clientes.add(cliente02);
		
		//GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		//Fim do cenário
		
		//Execução
		Cliente cliente1 = gerClientes.pesquisaCliente(idCliente01);
		Cliente cliente2 = gerClientes.pesquisaCliente(idCliente02);

		//Análise do resultado esperado
		assertThat(cliente1.getId(), is(idCliente01));
		assertThat(cliente1.getEmail(), is("joaodasilva@gmail.com"));
		assertThat(cliente1.getNome(), is("Joao da Silva"));
		
		assertThat(cliente2.getId(), is(idCliente02));
		assertThat(cliente2.getEmail(), is("mariadasilva@gmail.com"));
		assertThat(cliente2.getNome(), is("Maria da Silva"));
		
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
		
		//int idCliente01 = 1;
		//int idCliente02 = 2;
		//Montagem do cenário
//		Cliente cliente05 = new Cliente(idCliente01, "Pedro", 40, "pedroC@gmail.com", 3, true);
//		Cliente cliente06 = new Cliente(idCliente02, "Katarina", 41, "katarinaP@gmail.com", 4, true);
//		
//		List<Cliente> clientes = new ArrayList<>();
//		clientes.add(cliente05);
//		clientes.add(cliente06);
//		
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//Fase de execução
		boolean clienteRemovido01 = gerClientes.removeCliente(idCliente01);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido01, is(true));//Retorna que o cliente foi remvido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente01));//Esse método verifica se o cliente excluído está na lista.
		
		//Fase de execução
		boolean clienteRemovido02 = gerClientes.removeCliente(idCliente02);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido02, is(true));//Retorna que o cliente foi remvido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente02));//Esse método verifica se o cliente excluído está na lista.
	}

	@Test
	public void testeClienteAtivo() {
//		Cliente cliente05 = new Cliente(5, "Pedro", 47, "pedro@gmail.com", 5, true);
//		Cliente cliente06 = new Cliente(6, "Guilherme", 20, "guilherme@gmail.com", 6, false);
//
//		List<Cliente> clientes = new ArrayList<>();
//
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		boolean clienteAtivo1 = gerClientes.clienteAtivo(idCliente01);

		assertThat(clienteAtivo1, is(true));
		assertThat(gerClientes.clienteAtivo(idCliente01), is(true));
		
		boolean clienteAtivo2 = gerClientes.clienteAtivo(idCliente02);

		assertThat(clienteAtivo2, is(true));
		assertThat(gerClientes.clienteAtivo(idCliente02), is(true));
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
		
		//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente01.getIdade());
		//Verificação
		assertTrue(idadeValida);
		
//		assertThat(cliente01.getId(), is(1));
//		assertThat(cliente01.getEmail(), is("joaodasilva@gmail.com"));
//		assertThat(cliente01.getNome(), is("Joao da Silva"));
//		assertThat(cliente01.getIdade(), is(47));
		
	}
	
	
}
