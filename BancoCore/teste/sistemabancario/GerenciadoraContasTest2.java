package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
<<<<<<< HEAD
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
=======
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
>>>>>>> refs/remotes/origin/main

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraContasTest2 {

	private GerenciadoraContas gerContas;

	private int idConta01 = 1;
	private int idConta02 = 2;

	@Before
	public void setUp() {
		// ************* Montagem do cenário global **********//
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

=======
import org.junit.Test;

public class GerenciadoraContasTest2 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testePesquisaConta() {
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente conta01 = new ContaCorrente(1,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(2,2500.00,true);
>>>>>>> refs/remotes/origin/main
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		gerContas = new GerenciadoraContas(contas);
<<<<<<< HEAD
	}

	@After
	public void tearDown() {
		// ************* Desmontagem do cenário global **********//
		gerContas.limpa();
	}

	@Test
	public void testePesquisaConta() {

//		// ************* Montar o cenário *************//
//		int idConta01 = 1;
//		int idConta02 = 2;
//
//		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
//		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
//
//		List<ContaCorrente> contas = new ArrayList<>();
//		contas.add(conta01);
//		contas.add(conta02);
//
//		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		// Execução
		ContaCorrente conta01 = gerContas.pesquisaConta(idConta01);
		ContaCorrente conta02 = gerContas.pesquisaConta(idConta02);

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
		assertThat(conta01.getId(), is(1));
		assertThat(conta01.getSaldo(), is(200.00));
=======

		ContaCorrente conta;
		
		conta = gerContas.pesquisaConta(1); 	
		assertThat(conta.getId(), is(1));
		assertThat(conta.getSaldo(), is(2000.00));

		conta = gerContas.pesquisaConta(2); 	
		assertThat(conta.getId(), is(2));
		assertThat(conta.getSaldo(), is(2500.00));

	}
	
	@Test
	public void testeAdicionaConta() {
		
		ContaCorrente conta01 = new ContaCorrente(1,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(2,2500.00,true);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		gerContas = new GerenciadoraContas(contas);

		gerContas.adicionaConta(conta01);
		assertThat(conta01.getId(), is(1));
		assertThat(conta01.getSaldo(), is(2000.00));
>>>>>>> refs/remotes/origin/main
		assertThat(conta01.isAtiva(), is(true));

		gerContas.adicionaConta(conta02);
		assertThat(conta02.getId(), is(2));
<<<<<<< HEAD
		assertThat(conta02.getSaldo(), is(0.00));
		assertThat(conta02.isAtiva(), is(true));

	}

	@Test
	public void testeRemoveConta() {

//		/* cenario customizado para esse teste */
//		int idConta01 = 1;
//		int idConta02 = 2;
//
//		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
//		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
//
//		List<ContaCorrente> contas = new ArrayList<>();
//		contas.add(conta01);
//		contas.add(conta02);
//
//		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

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
//		int idConta01 = 1;
//		int idConta02 = 2;
//
//		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
//		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
//
//		List<ContaCorrente> contas = new ArrayList<>();
//		contas.add(conta01);
//		contas.add(conta02);
//
//		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		boolean contaAtivo01 = gerContas.contaAtiva(idConta01);

		assertThat(contaAtivo01, is(true));
		assertThat(gerContas.contaAtiva(idConta01), is(true));

		boolean contaAtivo02 = gerContas.contaAtiva(idConta02);

		assertThat(contaAtivo02, is(true));
		assertThat(gerContas.contaAtiva(idConta02), is(true));

	}

	@Test
	public void testeTranfereValor1() {

		/* cenario customizado para esse teste */
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

=======
		assertThat(conta02.getSaldo(), is(2500.00));
		assertThat(conta02.isAtiva(), is(true));

	}
	
	@Test
	public void testeRemoveConta() {
		
		ContaCorrente conta01 = new ContaCorrente(1,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(2,2600.00,true);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		gerContas = new GerenciadoraContas(contas);
		
		boolean contaRemovida01 = gerContas.removeConta(1);
		assertThat(contaRemovida01, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(1));
		assertNull(gerContas.pesquisaConta(1));
		
		boolean contaRemovida02 = gerContas.removeConta(2);
		assertThat(contaRemovida02, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(0));
		assertNull(gerContas.pesquisaConta(2));
		
	}
	
	@Test
	public void testeContaAtiva() {
		
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(3023,2600.00,true);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		gerContas = new GerenciadoraContas(contas);
		
		gerContas.contaAtiva(3022);
		assertThat(conta01.isAtiva(), is(true));//* Teste de integridade *//
		assertThat(conta01.getId(), is(3022));//* Teste de integridade *//
		
		gerContas.contaAtiva(3023);
		assertThat(conta02.isAtiva(), is(true));//* Teste de integridade *//
		assertThat(conta02.getId(), is(3023));//* Teste de integridade *//

	}
	
	@Test
	public void testeTranfereValor1() {
		/* Teste quando o saldo é suficiente */
		//*************** Montagem do senário ***************//
		int idConta01 = 1;
		int idConta02 = 2;
		
		/* Montagem do cenário */		
		ContaCorrente conta01 = new ContaCorrente(idConta01,200.00,true); 
		ContaCorrente conta02 = new ContaCorrente(idConta02,0.00,true);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/* Execução do negócio selecionado para teste */
		//gerContas.transfereValor(1,500.00,2);
		boolean sucesso = gerContas.transfereValor(idConta01,100.00,idConta02);
		
		/* Vrificação e Análise */
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(100.00));//* Teste de integridade *//
		assertThat(conta02.getSaldo(), is(100.00));//* Teste de integridade *//
	}
	
	@Test
	public void testeTranfereValor2() {
		/* Teste quando o saldo é insuficiente */
		//*************** Montagem do senário ***************//

		int idConta01 = 1;
		int idConta02 = 2;
		
		/* Montagem do cenário */		
		ContaCorrente conta01 = new ContaCorrente(idConta01,100.00,true); 
		ContaCorrente conta02 = new ContaCorrente(idConta02,0.00,true);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/* Execução do negócio selecionado para teste */
		//gerContas.transfereValor(1,500.00,2);
		boolean sucesso = gerContas.transfereValor(idConta01,200.00,idConta02);
		
		/* Vrificação e Análise */
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-100.00));//* Teste de integridade *//
		assertThat(conta02.getSaldo(), is(200.00));//* Teste de integridade *//
	}
	
	@Test
	public void testeTranfereValor3() {
		/* Teste quando o saldo é insuficiente */
		//*************** Montagem do senário ***************//

		int idConta01 = 1;
		int idConta02 = 2;
		
		/* Montagem do cenário */		
		ContaCorrente conta01 = new ContaCorrente(idConta01,-100.00,true); 
		ContaCorrente conta02 = new ContaCorrente(idConta02,0.00,true);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/* Execução do negócio selecionado para teste */
		//gerContas.transfereValor(1,500.00,2);
		boolean sucesso = gerContas.transfereValor(idConta01,200.00,idConta02);
		
		/* Vrificação e Análise */
		assertTrue(sucesso);//* Teste de completude *//
		assertThat(conta01.getSaldo(), is(-300.00));//* Teste de integridade *//
		assertThat(conta02.getSaldo(), is(200.00));//* Teste de integridade *//
	}
	
	@Test
	public void testeTranfereValor4() {
		/* Teste quando o saldo é insuficiente */
		//*************** Montagem do senário ***************//

		int idConta01 = 1;
		int idConta02 = 2;
		
		/* Montagem do cenário */		
		ContaCorrente conta01 = new ContaCorrente(idConta01,-100.00,true); 
		ContaCorrente conta02 = new ContaCorrente(idConta02,-100.00,true);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/* Execução do negócio selecionado para teste */
		//gerContas.transfereValor(1,500.00,2);
		boolean sucesso = gerContas.transfereValor(idConta01,200.00,idConta02);
		
		/* Vrificação e Análise */
		assertTrue(sucesso);//* Teste de completude *//
		assertThat(conta01.getSaldo(), is(-300.00));//* Teste de integridade *//
		assertThat(conta02.getSaldo(), is(100.00));//* Teste de integridade *//
	}
	
	@Test
	public void testeTranfereValor5() {
		/* Teste quando o saldo é insuficiente */
		//*************** Montagem do senário ***************//

		int idConta01 = 1;
		int idConta02 = 2;
		
		/* Montagem do cenário */		
		ContaCorrente conta01 = new ContaCorrente(idConta01,-100.00,true); 
		ContaCorrente conta02 = new ContaCorrente(idConta02,-100.00,true);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/* Execução do negócio selecionado para teste */
		//gerContas.transfereValor(1,500.00,2);
		boolean sucesso = gerContas.transfereValor(idConta01,200.00,idConta02);
		
		/* Vrificação e Análise */
		assertTrue(sucesso);//* Teste de completude *//
		assertThat(conta01.getSaldo(), is(-300.00));//* Teste de integridade *//
		assertThat(conta02.getSaldo(), is(100.00));//* Teste de integridade *//
>>>>>>> refs/remotes/origin/main
	}

}
