package EComeceSimples;

public class ContaCorrente {
	private double saldo;

	public double limite(double limite) {
		return saldo = limite;
	}

	public void creditar(double valor) {
		this.saldo += valor;
	}

	public void debitar(double valor) {
		this.saldo -= valor;
	}

	public double getSaldo() {
		return saldo;
	}

}
