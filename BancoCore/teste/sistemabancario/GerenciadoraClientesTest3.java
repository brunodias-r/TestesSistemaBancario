package sistemabancario;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest3 {

	private GerenciadoraClientes gerClientes;

	private int idCliente01 = 1;
	private int idCliente02 = 2;

	@Before
	public void setUp() {
		// ************* Montagem do cenário global **********//
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		// ************* Desmontagem do cenário global **********//
		gerClientes.limpa();
	}

	@Test
	public void testPesquisaCliente() {

		/* Criando clientes */
		// Definição e inicialização do cenário.
		// Cliente cliente01 = new Cliente(idCliente01, "Guilherme", 30,
		// "guilherme@gmail.com", 1, true);
		// Cliente cliente02 = new Cliente(idCliente02, "Gabriel", 23,
		// "gabriel@gmail.com", 2, true);

		// inserindo os clientes criados na lista de clientes do banco
		// List<Cliente> clientes = new ArrayList<>();
		// clientes.add(cliente01);
		// clientes.add(cliente02);

		// GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		// Fim do cenário

		// Execução
		Cliente cliente01 = gerClientes.pesquisaCliente(idCliente01);
		Cliente cliente02 = gerClientes.pesquisaCliente(idCliente02);

		// Análise do resultado esperado
		assertThat(cliente01.getId(), is(idCliente01));
		assertThat(cliente01.getEmail(), is("joaodasilva@gmail.com"));
		assertThat(cliente01.getNome(), is("Joao da Silva"));


		assertThat(cliente02.getId(), is(idCliente02));
		assertThat(cliente02.getEmail(), is("mariadasilva@gmail.com"));
		assertThat(cliente02.getNome(), is("Maria da Silva"));


	}

	@Test
	public void testPesquisaClienteInexistente() {

		/* ========== Execução ========== */
		Cliente cliente = gerClientes.pesquisaCliente(10);

		/* ========== Verificações ========== */
		assertNull(cliente);
	}
	
	@Test
	public void testeAdicionaCliente() {
		// cenario customizado para esse teste
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);

//		List<Cliente> clientesDoBanco = new ArrayList<>();
//		clientesDoBanco.add(cliente01);
//		clientesDoBanco.add(cliente02);
//
//		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		gerClientes.adicionaCliente(cliente01);
		gerClientes.adicionaCliente(cliente02);
		
		assertThat(cliente01.getId(), is(1));
		assertThat(cliente01.getEmail(), is("joaodasilva@gmail.com"));
		assertThat(cliente01.getNome(), is("Joao da Silva"));
		
		assertThat(cliente02.getId(), is(2));
		assertThat(cliente02.getEmail(), is("mariadasilva@gmail.com"));
		assertThat(cliente02.getNome(), is("Maria da Silva"));
	}

	@Test
	public void testeRemoveCliente() {
//		int idCliente01 = 1;
//		int idCliente02 = 2;
//		/*Montagem do cenário*/
//		Cliente cliente05 = new Cliente(idCliente01, "Pedro", 40, "pedroC@gmail.com", 3, true);
//		Cliente cliente06 = new Cliente(idCliente02, "Katarina", 41, "katarinaP@gmail.com", 4, true);
//		
//		List<Cliente> clientes = new ArrayList<>();
//		clientes.add(cliente05);
//		clientes.add(cliente06);
//		
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		// Fase de execução
		boolean clienteRemovido01 = gerClientes.removeCliente(idCliente01);

		// Análise do resultado esperado
		assertThat(clienteRemovido01, is(true));// Retorna que o cliente foi remvido.
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));// Esse método verifica o tamanho da lista e se o
																	// cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente01));// Esse método verifica se o cliente excluído está na
																// lista.

		// Fase de execução
		boolean clienteRemovido02 = gerClientes.removeCliente(idCliente02);

		// Análise do resultado esperado
		assertThat(clienteRemovido02, is(true));// Retorna que o cliente foi remvido.
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));// Esse método verifica o tamanho da lista e se o
																	// cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente02));// Esse método verifica se o cliente excluído está na
																// lista.
	}

	@Test
	public void testRemoveClienteInexistente() {

		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(10);

		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(false));
		assertFalse(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		
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

	// Validação quando o cliente está no intervalo de idade permitido
	@Test
	public void testClienteIdadePermitida1() throws IdadeNaoPermitidaException {
		// cenario customizado para esse teste
		Cliente cliente = new Cliente(3, "Yuri", 26, "yuri@yuri.com", 1, true);
		// Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		// Verificação
		assertTrue(idadeValida);
	}

	// Validação quando o cliente está no intervalo de idade permitido na borda
	// inferior
	@Test
	public void testClienteIdadePermitida2() throws IdadeNaoPermitidaException {
		// cenario customizado para esse teste
		Cliente cliente = new Cliente(4, "Miguel", 18, "miguel@miguel.com", 1, true);
		// Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		// Verificação
		assertTrue(idadeValida);
	}

	// Validação quando o cliente está no intervalo de idade permitido na borda
	// superior
	@Test
	public void testClienteIdadePermitida3() throws IdadeNaoPermitidaException {
		// cenario customizado para esse teste
		Cliente cliente = new Cliente(5, "Victor", 65, "victor@victor.com", 1, true);
		// Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		// Verificação
		assertTrue(idadeValida);
	}

	// Validação quando o cliente está fora dp intervalo de idade permitido na borda
	// inferior
	@Test
	public void testClienteIdadePermitida4() throws IdadeNaoPermitidaException {
		// cenario customizado para esse teste
		Cliente cliente = new Cliente(6, "Fellipe", 17, "fellipe@fellipe.com", 1, true);
		// Execução
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}

	// Validação quando o cliente está fora dp intervalo de idade permitido na borda
	// superior
	@Test
	public void testClienteIdadePermitida5() throws IdadeNaoPermitidaException {
		// cenario customizado para esse teste
		Cliente cliente = new Cliente(7, "Clayton", 66, "clayton@gmail.com", 1, true);
		// Execução
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}
}
