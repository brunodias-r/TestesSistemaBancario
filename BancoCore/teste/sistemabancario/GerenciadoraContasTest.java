package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testePesquisaConta() {
		
		ContaCorrente conta01 = new ContaCorrente(1,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(2,2500.00,true);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		gerContas = new GerenciadoraContas(contas);

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
		assertThat(conta01.isAtiva(), is(true));

		gerContas.adicionaConta(conta02);
		assertThat(conta02.getId(), is(2));
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
		assertThat(conta01.isAtiva(), is(true));
		assertThat(conta01.getId(), is(3022));
		
		gerContas.contaAtiva(3023);
		assertThat(conta02.isAtiva(), is(true));
		assertThat(conta02.getId(), is(3023));

	}
	
	@Test
	public void testeTranfereValor() {
		
		/* Montagem do cenário */		
		ContaCorrente conta01 = new ContaCorrente(1,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(2,2500.00,true);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		/* Execução do negócio selecionado para teste */
		//gerContas.transfereValor(1,500.00,2);
		boolean sucesso = gerContas.transfereValor(1,500.00,2);
		
		/* Vrificação e Análise */
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(1500.00));
		assertThat(conta02.getSaldo(), is(3000.00));
	}

}
