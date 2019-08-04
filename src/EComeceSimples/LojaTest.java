package br.com.cleyson.EComeceSimples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LojaTest {

	private Loja loja;

	@BeforeEach
	void setup() {
		loja = new Loja();
		loja.definirLimite(150);

	}

	
	/*
	 * deve lançar um erro após receber um valor invalido, visto que não se pode vender 
	 * algo de valor menor ou igual à 0
	 * Caso isto aconteça deve avisar que o valor é invalido
	 * E depois mostra que nao foi alterado o valor da conta corrente
	 */
	 
	@Test 
	void testComValorInvalidoNaVenda() {
		Exception vendaEx = assertThrows(ValorInvalidoExecption.class, () -> loja.vender(0));
		assertEquals("Valor digitado não é valido", vendaEx.getMessage());
		 System.out.println(loja.mostarSaldo());

	}

	
	/*
	 * recebe um valor tipo double referente a um valor da venda
	 * Deve efetivar a venda pela loja e acrescentar o valor na conta corrente
	 * E apos isto deve mostrar o novo saldo
	 */
	@Test
	void testDeveAdicionarOValorDaVendaNaContaCorrente() throws ValorInvalidoExecption {
		assertEquals("venda efetuada com sucesso", loja.vender(10));
		System.out.println("saldo apos a venda : " + loja.mostarSaldo());

	}

	/*
	 * Deve lançar um Erro quando o valor da compra for maior que o dinheiro na conta corrente
	 * Caso isto aconteça deve avisar que nao possui credito suficiente na conta
	 * E depois mostra que nao foi alterado a conta corrente
	 */
	
	@Test
	void TestCompraComValoresMaioresQueContaCorrente() {
		Exception compraEX = assertThrows(CreditoInsuficienteException.class, () -> loja.comprar(200));
		assertEquals("Credito insuficiente", compraEX.getMessage());
		System.out.println(loja.mostarSaldo());
	}
	/*
	 *Recebe  um double referente a um valor da compra
	 * Deve efetivar uma compra , subtraindo o valor da conta corrente
	 * apos isto deve mostrar o novo saldo da conta
	 */

	@Test
	void testDeveSubtrarirOValorDaCompraDaContaCorrente() throws CreditoInsuficienteException {
		assertEquals("compra efetuada com sucesso", loja.comprar(20));
		System.out.println("saldo apos a compra : " + loja.mostarSaldo());
	}

}

