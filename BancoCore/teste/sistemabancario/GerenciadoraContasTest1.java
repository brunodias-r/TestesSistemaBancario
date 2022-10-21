package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {
	
	@Test
	public void testePesquisaConta() {
		
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(3023,2600.00,false);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		ContaCorrente conta;
		
		conta = gerContas.pesquisaConta(3022); 	
		assertThat(conta.getId(), is(3022));
		assertThat(conta.getSaldo(), is(2000.00));

		conta = gerContas.pesquisaConta(3023); 	
		assertThat(conta.getId(), is(3023));
		assertThat(conta.getSaldo(), is(2600.00));

	}
	
	@Test
	public void testeAdicionaConta() {
		
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(3023,2600.00,false);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);

		gerContas.adicionaConta(conta01);
		assertThat(conta01.getId(), is(3022));
		assertThat(conta01.getSaldo(), is(2000.00));
		assertThat(conta01.isAtiva(), is(true));

		gerContas.adicionaConta(conta02);
		assertThat(conta02.getId(), is(3023));
		assertThat(conta02.getSaldo(), is(2600.00));
		assertThat(conta02.isAtiva(), is(false));

	}
	
	@Test
	public void testeRemoveConta() {
		
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(3023,2600.00,false);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		boolean contaRemovida01 = gerContas.removeConta(3022);
		assertThat(contaRemovida01, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(1));
		assertNull(gerContas.pesquisaConta(3022));
		
		boolean contaRemovida02 = gerContas.removeConta(3023);
		assertThat(contaRemovida02, is(false));
		assertThat(gerContas.getContasDoBanco().size(), is(0));
		assertNull(gerContas.pesquisaConta(3023));
		
	}
	
	@Test
	public void testeContaAtiva() {
		
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(3023,2600.00,false);
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		gerContas.contaAtiva(3022);
		assertThat(conta01.isAtiva(), is(true));
		assertThat(conta01.getId(), is(3022));
		
		gerContas.contaAtiva(3023);
		assertThat(conta02.isAtiva(), is(false));
		assertThat(conta02.getId(), is(3023));

	}
	
	@Test
	public void testeTranfereValor() {
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 
		ContaCorrente conta02 = new ContaCorrente(3023,2500.00,false);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		boolean contaTransfere01 = gerContas.transfereValor(3022,500.00,3023);
		assertThat(contaTransfere01, is(true));
	}

}
