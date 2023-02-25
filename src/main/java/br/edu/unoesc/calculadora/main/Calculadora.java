package br.edu.unoesc.calculadora.main;

import br.edu.unoesc.calculadora.conversor.ConversorNumerico;
import br.edu.unoesc.calculadora.excecoes.DivisaoPorZeroException;
import br.edu.unoesc.calculadora.excecoes.NumeroNegativoException;

public class Calculadora {
	public static Double somar(String numero1, String numero2) {
		return ConversorNumerico.converterParaDouble(numero1) +
				ConversorNumerico.converterParaDouble(numero2);		
	}
	
	public static Double subtrair(String numero1, String numero2) {
		return ConversorNumerico.converterParaDouble(numero1) -
				ConversorNumerico.converterParaDouble(numero2);		
	}
	
	public static Double multiplicar(String numero1, String numero2) {
		return ConversorNumerico.converterParaDouble(numero1) *
				ConversorNumerico.converterParaDouble(numero2);		
	}
	
	public static Double dividir(String numero1, String numero2) throws DivisaoPorZeroException {
		if (ConversorNumerico.converterParaDouble(numero2).equals(0D)) {
			throw new DivisaoPorZeroException("Não pode ser dividido por zero!");
		}
		return ConversorNumerico.converterParaDouble(numero1) /
				ConversorNumerico.converterParaDouble(numero2);		
	}
	
	public static Double media(String numero1, String numero2) {
		return (ConversorNumerico.converterParaDouble(numero1) +
				ConversorNumerico.converterParaDouble(numero2)) / 2;		
	}
	
	public static Double potencia(String numero1, String numero2) {
		return Math.pow(ConversorNumerico.converterParaDouble(numero1), 
				ConversorNumerico.converterParaDouble(numero2));
	}
	
	public static Double raiz(String numero1) throws NumeroNegativoException {
		if (ConversorNumerico.converterParaDouble(numero1) <= 0) {
			throw new NumeroNegativoException("Número informado não pode ser negativo!");
		}
		return Math.sqrt(ConversorNumerico.converterParaDouble(numero1));
	}
}
