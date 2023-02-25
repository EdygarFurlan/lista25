package br.edu.unoesc.calculadora.excecoes;

public class DivisaoPorZeroException extends ArithmeticException {
	public DivisaoPorZeroException(String mensagem) {
		super(mensagem);
	}
}
