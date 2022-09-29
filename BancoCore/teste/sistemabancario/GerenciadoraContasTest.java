package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {

	@Test
	public void testePesquisaConta() {
		// criando contas
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 3022, true);
		ContaCorrente conta01 = new ContaCorrente(3022,2000.00,true); 

		
	}

}
