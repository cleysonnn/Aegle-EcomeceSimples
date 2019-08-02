package EComeceSimples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LojaTest {

	Loja loja;

	@BeforeEach
	void setup() {
		loja = new Loja();
		loja.definirLimite(150);

	}

	@Test // Quando o valor recebido é 0 ou menor
	void testvendaErro() {
		Exception vendaEx = assertThrows(ValorInvalidoExecption.class, () -> loja.vender(0));
		assertEquals("valor a ser creditado é invalido", vendaEx.getMessage());
		 System.out.println(loja.mostarSaldo());

	}

	@Test
	void testvenda() throws ValorInvalidoExecption {
		assertEquals("venda efetuada com sucesso", loja.vender(10));
		System.out.println("saldo apos a venda : " + loja.mostarSaldo());

	}

	@Test
	void compraErro() {
		Exception compraEX = assertThrows(CreditoInsuficienteException.class, () -> loja.comprar(200));
		assertEquals("Nao possui credito a ser debitado", compraEX.getMessage());
		System.out.println(loja.mostarSaldo());
	}

	@Test
	void testcompra() throws CreditoInsuficienteException {
		assertEquals("compra efetuada com sucesso", loja.comprar(20));
		System.out.println("saldo apos a compra : " + loja.mostarSaldo());
	}

}
