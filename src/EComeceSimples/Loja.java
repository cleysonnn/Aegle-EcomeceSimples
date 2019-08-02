package EComeceSimples;

public class Loja {
	private ContaCorrente conta;

	public Loja() {
		conta = new ContaCorrente();
	}

	public double definirLimite(double limite) {
		return conta.limite(limite);
	}

	public double mostarSaldo() {
		return conta.getSaldo();

	}

	public String vender(double valor) throws ValorInvalidoExecption {
		if (valor <= 0) {
			throw new ValorInvalidoExecption("valor a ser creditado é invalido");
		}
		conta.creditar(valor);
		return "venda efetuada com sucesso";

	}

	public String comprar(double valor) throws CreditoInsuficienteException {
		if (conta.getSaldo() < valor) {
			throw new CreditoInsuficienteException("Nao possui credito a ser debitado");
		}
		conta.debitar(valor);
		return "compra efetuada com sucesso";
	}

}
