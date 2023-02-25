package br.edu.unoesc.calculadora.conversor;

import java.util.logging.Logger;

public class ConversorNumerico {
	static Logger logger = Logger.getLogger(ConversorNumerico.class.getName());
	
	static public boolean ehNumerico(String strNumero) {
		if (strNumero == null) {
			logger.info("Valor ausente!");
			return false;
		}
		
		String numero = strNumero.replaceAll("," , ".");
		
		// Utilizando tratamento de exceções
		try {
			Double.parseDouble(numero);
			return true; // Significa que a string contém um Double válido.
		} catch (NumberFormatException e) {
			return false;
		}
		
		// Utilizando expressões regulares
		//return numero.matches("[-+]?\\d*\\.?\\d*");
	}
	
	static public Double converterParaDouble(String strNumero) {
		if (strNumero == null) {
			return 0D;
		}
		
		String numero = strNumero.replaceAll(",", ".");
		if (ehNumerico(numero)) {
			return Double.parseDouble(numero);
		}
		
		return 0D;
	}

}
