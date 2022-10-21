package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraContasTest2 {

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

	private GerenciadoraContas gerContas;


	@Test
	public void testePesquisaConta() {

		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		// Execução
		gerContas.pesquisaConta(idConta01);
		gerContas.pesquisaConta(idConta02);

		// Análise do resultado esperado
		assertThat(conta01.getId(), is(idConta01));
		assertThat(conta02.getId(), is(idConta02));

	}

	@Test
	public void testeAdicionaConta() {

		/* cenario customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		gerContas.adicionaConta(conta01);
		gerContas.adicionaConta(conta02);

		assertThat(conta01.getId(), is(1));
		assertThat(conta01.getSaldo(), is(200.00));

		assertThat(conta02.getId(), is(2));
		assertThat(conta02.getSaldo(), is(0.00));

	}


	@Test
	public void testeRemoveConta() {

		/* cenario customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		boolean contaRemovida01 = gerContas.removeConta(idConta01);
		assertThat(contaRemovida01, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(1));
		assertNull(gerContas.pesquisaConta(idConta01));

		boolean contaRemovida02 = gerContas.removeConta(idConta02);
		assertThat(contaRemovida02, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(0));
		assertNull(gerContas.pesquisaConta(idConta02));

	}

	@Test
	public void testeContaAtiva() {

//		/* cenario customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/*Execução*/
		boolean contaAtivo01 = gerContas.contaAtiva(idConta01);
		boolean contaAtivo02 = gerContas.contaAtiva(idConta02);

		/*Análise*/

		assertThat(contaAtivo01, is(true));
		assertThat(gerContas.contaAtiva(idConta01), is(true));

		assertThat(contaAtivo02, is(true));
		assertThat(gerContas.contaAtiva(idConta02), is(true));

	}

	@Test
	public void testeTranfereValor1() {

		/* cenário customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		// ************* Execução do negócio selecionado para o Teste *************//
		boolean succeso = gerContas.transfereValor(idConta01, 100, idConta02);

		// ************* Verificações e Análise *************//
		assertTrue(succeso);
		assertThat(conta01.getSaldo(), is(100.00));
		assertThat(conta02.getSaldo(), is(100.00));

	}

//	@Test
//	public void testTransfereValor2() {
//		
//		/* cenario customizado para esse teste */
//		int idConta01 = 1;
//		int idConta02 = 2;
//
//		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
//		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
//
//		List<ContaCorrente> contaDoBanco = new ArrayList<>();
//		contaDoBanco.add(conta01);
//		contaDoBanco.add(conta02);
//
//		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);
//
//		//************* Execução do negócio selecionado para o Teste *************//
//		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
//		
//		//************* Verificações e Análise *************//
//		assertFalse(succeso);
//		assertThat(conta01.getSaldo(), is(-100.0));
//		assertThat(conta02.getSaldo(), is(200.0));
//		
//	}

	@Test
	public void testTransfereValor2() {

		/* cenario customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);

		// ************* Execução do negócio selecionado para o Teste *************//
		try {
			boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
			assertFalse(succeso);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Saldo insuficiente para realizar a tranferência."));
		}
	}

//	@Test
//	public void testTransfereValor3() {
//
//		/* cenario customizado para esse teste */
//		int idConta01 = 1;
//		int idConta02 = 2;
//
//		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
//		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
//
//		List<ContaCorrente> contasDoBanco = new ArrayList<>();
//		contasDoBanco.add(conta01);
//		contasDoBanco.add(conta02);
//
//		GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);
//
//		// ************* Execução do negócio selecionado para o Teste *************//
//		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
//
//		// ************* Verificações e Análise *************//
//		assertFalse(succeso);
//		assertThat(conta01.getSaldo(), is(-300.0));
//		assertThat(conta02.getSaldo(), is(200.0));
//
//	}

	@Test
	public void testTransfereValor3() {

		/* cenario customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);

		// ************* Execução do negócio selecionado para o Teste *************//
		try {
			boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
			assertFalse(succeso);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Saldo insuficiente para realizar a tranferência."));
		}

	}

//	@Test
//	public void testTransfereValor4() {
//		
//		/* cenario customizado para esse teste */
//		int idConta01 = 1;
//		int idConta02 = 2;
//
//		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
//		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
//
//		List<ContaCorrente> contaDoBanco = new ArrayList<>();
//		contaDoBanco.add(conta01);
//		contaDoBanco.add(conta02);
//
//		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);
//		
//		//************* Execução do negócio selecionado para o Teste *************//
//		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
//		
//		//************* Verificações e Análise *************//
//		assertFalse(succeso);
//		assertThat(conta01.getSaldo(), is(-300.0));
//		assertThat(conta02.getSaldo(), is(100.0));
//		
//	}

	@Test
	public void testTransfereValor4() {

		/* cenario customizado para esse teste */
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);

		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);

		// ************* Execução do negócio selecionado para o Teste *************//
		try {
			boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
			assertFalse(succeso);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Saldo insuficiente para realizar a tranferência."));
		}

	}

//	@Test
//	public void testeRemoveConta() {
//
//		ContaCorrente conta01 = new ContaCorrente(1, 2000.00, true);
//		ContaCorrente conta02 = new ContaCorrente(2, 2600.00, true);
//		List<ContaCorrente> contas = new ArrayList<>();
//		contas.add(conta01);
//		contas.add(conta02);
//
//		gerContas = new GerenciadoraContas(contas);
//
//		boolean contaRemovida01 = gerContas.removeConta(1);
//		assertThat(contaRemovida01, is(false));
//		assertThat(gerContas.getContasDoBanco().size(), is(1));
//		assertNull(gerContas.pesquisaConta(1));
//
//		boolean contaRemovida02 = gerContas.removeConta(2);
//		assertThat(contaRemovida02, is(false));
//		assertThat(gerContas.getContasDoBanco().size(), is(0));
//		assertNull(gerContas.pesquisaConta(2));
//
//	}
//
//	@Test
//	public void testeContaAtiva() {
//
//		ContaCorrente conta01 = new ContaCorrente(3022, 2000.00, true);
//		ContaCorrente conta02 = new ContaCorrente(3023, 2600.00, true);
//		List<ContaCorrente> contas = new ArrayList<>();
//		contas.add(conta01);
//		contas.add(conta02);
//
//		gerContas = new GerenciadoraContas(contas);
//
//		gerContas.contaAtiva(3022);
//		assertThat(conta01.isAtiva(), is(true));// * Teste de integridade *//
//		assertThat(conta01.getId(), is(3022));// * Teste de integridade *//
//
//		gerContas.contaAtiva(3023);
//		assertThat(conta02.isAtiva(), is(true));// * Teste de integridade *//
//		assertThat(conta02.getId(), is(3023));// * Teste de integridade *//
//
//	}

}
