package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest1 {

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

		boolean succeso = gerContas.transfereValor(idConta01, 100, idConta02);

		// ************* Verificações e Análise *************//
		assertTrue(succeso);
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(100.0));

	}

	@Test
	public void testeAdicionaConta() {
		
		// ************* Montar o cenário *************//
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
		assertThat(conta01.isAtiva(), is(true));

		gerContas.adicionaConta(conta02);
		assertThat(conta02.getId(), is(2));
		assertThat(conta02.getSaldo(), is(0.00));
		assertThat(conta02.isAtiva(), is(true));

	}

	@Test
	public void testeRemoveConta() {
		
		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		boolean contaRemovida01 = gerContas.removeConta(conta01.getId());
		assertThat(contaRemovida01, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(1));
		assertNull(gerContas.pesquisaConta(conta01.getId()));

		boolean contaRemovida02 = gerContas.removeConta(conta02.getId());
		assertThat(contaRemovida02, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(0));
		assertNull(gerContas.pesquisaConta(conta02.getId()));

	}

	@Test
	public void testeContaAtiva() {
		
		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		gerContas.contaAtiva(conta01.getId());
		assertThat(conta01.isAtiva(), is(true));
		assertThat(conta01.getId(), is(conta01.getId()));

		gerContas.contaAtiva(conta02.getId());
		assertThat(conta02.isAtiva(), is(true));
		assertThat(conta02.getId(), is(conta02.getId()));

	}

	@Test
	public void testeTranfereValor1() {
		
		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		//************* Execução do negócio selecionado para o Teste *************//
		boolean succeso = gerContas.transfereValor(idConta01, 100, idConta02);
		
		//************* Verificações e Análise *************//
		assertTrue(succeso);
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(100.0));	
		
	}

	@Test
	public void testTransfereValor2() {
		
		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);

		//************* Execução do negócio selecionado para o Teste *************//
		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		//************* Verificações e Análise *************//
		assertTrue(succeso);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
		
	}
	
	@Test
	public void testTransfereValor3() {
		
		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);

		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);
		
		//************* Execução do negócio selecionado para o Teste *************//
		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		//************* Verificações e Análise *************//
		assertTrue(succeso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(200.0));
		
	}

	@Test
	public void testTransfereValor4() {
		
		// ************* Montar o cenário *************//
		int idConta01 = 1;
		int idConta02 = 2;

		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);

		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contaDoBanco);
		
		//************* Execução do negócio selecionado para o Teste *************//
		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		//************* Verificações e Análise *************//
		assertTrue(succeso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(100.0));
		
	}
}
