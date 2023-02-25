package br.edu.unoesc.calculadora.excecoes;

public class NumeroNegativoException extends ArithmeticException {
	public NumeroNegativoException(String mensagem) {
		super(mensagem);
	}
}
