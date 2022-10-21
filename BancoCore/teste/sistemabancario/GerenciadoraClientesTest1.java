package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GerenciadoraClienteTest {
	
	@Test
	public void testePesquisaCliente() {
		// criando clientes
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 2, true);

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);

		Cliente cliente;
		
		cliente = gerClientes.pesquisaCliente(1);

		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
		assertThat(cliente.getNome(), is("Clayton"));
		
		cliente = gerClientes.pesquisaCliente(2);

		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getEmail(), is("maria@gmail.com"));
		assertThat(cliente.getNome(), is("Maria"));
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
		//Montagem do cenário
		Cliente cliente05 = new Cliente(5, "Pedro", 40, "pedroC@gmail.com", 3, true);
		Cliente cliente06 = new Cliente(6, "Katarina", 41, "katarinaP@gmail.com", 4, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente05);
		clientes.add(cliente06);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//Fase de execução
		boolean clienteRemovido01 = gerClientes.removeCliente(5);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido01, is(true));//Retorna que o cliente foi removido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(5));//Esse método verifica se o cliente excluído está na lista.
		
		//Fase de execução
		boolean clienteRemovido02 = gerClientes.removeCliente(6);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido02, is(true));//Retorna que o cliente foi removido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(6));//Esse método verifica se o cliente excluído está na lista.
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