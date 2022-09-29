package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaBancario {

	static GerenciadoraClientes gerClientes;// Vari�vel global que � referencia e ajuda a gera��o de cada cliente.
	static GerenciadoraContas gerContas;// Vari�vel global que � referencia e ajuda a gera��o de cada cliente.

	public static void main(String[] args) {
		inicialiazarSistemaBancario(); // Inicializar dados de contas de clientes

		Scanner sc = new Scanner(System.in);
		boolean continua = true;

		while (continua) {
			printMenu();

			int opcao = sc.nextInt();

			switch (opcao) {
				case 1: {
					System.out.println("Digite o Id do cliente: ");
					int idCliente = sc.nextInt();
					Cliente cliente = gerClientes.pesquisaCliente(idCliente);

					if (cliente != null) {
						System.out.println(cliente.toString());
					} else {
						System.out.println("Cliente n�o encontrado!");
					}
					break;
				}
				case 2: {
					System.out.println("Digite o Id da conta: ");
					int idConta = sc.nextInt();
					ContaCorrente conta = gerContas.pesquisaConta(idConta);

					if (conta != null) {
						System.out.println(conta.toString());
					} else {
						System.out.println("Conta n�o encontrada!");
					}
					break;
				}
				case 3: {
					System.out.println("Digite o Id do cliente: ");
					int idCliente2 = sc.nextInt();
					Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);

					if (cliente2 != null) {
						cliente2.setAtivo(true);
						System.out.println("cliente ativado com sucesso!");
					} else {
						System.out.println("Cliente n�o encontrado.");
					}
					break;
				}
				case 4: {
					System.out.println("Digite o Id do cliente: ");
					int idCliente3 = sc.nextInt();
					Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);

					if (cliente3 != null) {
						cliente3.setAtivo(false);
						System.out.println("cliente desativado com sucesso!");
					} else {
						System.out.println("Cliente não encontrado.");
					}
					break;
				}
				case 5: {
					continua = false;
					System.out.println("Saindo.");
					break;
				}
				default: {
					System.out.println("Opção inválida.");
					break;
				}
			}
		}
		sc.close();
	}

	private static void printMenu() {
		System.out.println("Qual operação você deseja executar?");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Sair");
		System.out.print("Insira uma opção: ");
	}

	private static void inicialiazarSistemaBancario() {
		// Criar lista vazia vazia de contas e clientes:
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();

		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);

		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		// Criar e inserir dois clientes no banco
		Cliente cliente01 = new Cliente(1, "Guilherme", 30, "guilhermeS@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Gabirel", 23, "gabrielS@gmail.com", conta02.getId(), true);
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);

	}
}
