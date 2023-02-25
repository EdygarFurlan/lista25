package br.edu.unoesc.calculadora.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.calculadora.conversor.ConversorNumerico;
import br.edu.unoesc.calculadora.excecoes.DivisaoPorZeroException;
import br.edu.unoesc.calculadora.excecoes.NumeroNegativoException;
import br.edu.unoesc.calculadora.main.Calculadora;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
	private Logger logger = Logger.getLogger(CalculadoraController.class.getName());
    
	//Somar
    @GetMapping("/somar-query")
    public Double somarQuery(@RequestParam(value="numero1", defaultValue = "0") Double numero1,
    		@RequestParam(value="numero2", defaultValue = "0") Double numero2) {
    	
    	logger.info("Calculando... " + numero1 + " + " + numero2);
    	Double resultado = Calculadora.somar(numero1.toString(), numero2.toString());

    	logger.info("O resultado é: " + resultado);
    	return resultado;
    }
    
    @RequestMapping(value = "/somar-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double somarPath(@PathVariable("numero1") String numero1, 
    		@PathVariable("numero2") String numero2) {
    	
    	logger.info("Calculando... " + numero1 + " + " + numero2);
    	
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0D;
    	}
    	
    	Double resultado = Calculadora.somar(numero1, numero2);
    	logger.info("O resultado é: " + resultado);
    	return resultado;
    }
    
    //Subtrair
    @GetMapping("/subtrair-query")
    public Double subtrairQuery(@RequestParam(value="numero1", defaultValue = "0") Double numero1,
    		@RequestParam(value="numero2", defaultValue = "0") Double numero2) {
    	
    	logger.info("Calculando... " + numero1 + " - " + numero2);
    	Double resultado = Calculadora.subtrair(numero1.toString(), numero2.toString());

    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    @RequestMapping(value = "/subtrair-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double subtrairPath(@PathVariable("numero1") String numero1, 
    		@PathVariable("numero2") String numero2) {
    	
    	logger.info("Calculando... " + numero1 + " - " + numero2);
    	
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0D;
    	}
    	
    	Double resultado = Calculadora.subtrair(numero1, numero2);
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    //Multiplicar
    @GetMapping("/multiplicar-query")
    public Double multiplicarQuery(@RequestParam(value="numero1", defaultValue = "0") Double numero1,
    		@RequestParam(value="numero2", defaultValue = "0") Double numero2) {
    	
    	logger.info("Calculando... " + numero1 + " * " + numero2);
    	Double resultado = Calculadora.multiplicar(numero1.toString(), numero2.toString());

    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    @RequestMapping(value = "/multiplicar-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double multiplicarPath(@PathVariable("numero1") String numero1, 
    		@PathVariable("numero2") String numero2) {
    	
    	logger.info("Calculando... " + numero1 + " * " + numero2);
    	
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0D;
    	}
    	
    	Double resultado = Calculadora.multiplicar(numero1, numero2);
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    //Dividir
    @GetMapping("/dividir-query")
    public Double dividirQuery(@RequestParam(value="numero1", defaultValue = "0") Double numero1,
    		@RequestParam(value="numero2", defaultValue = "0") Double numero2) {
    	logger.info("Calculando... " + numero1 + " / " + numero2);
    	
    	Double resultado = 0D;
    	try {
    		resultado = Calculadora.dividir(numero1.toString(), numero2.toString());
    	} catch (DivisaoPorZeroException e) {
    		logger.info(e.getMessage());
    	}
    	
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    @RequestMapping(value = "/dividir-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double dividirPath(@PathVariable("numero1") String numero1, 
    		@PathVariable("numero2") String numero2) {
    	
    	logger.info("Calculando... " + numero1 + " / " + numero2);
    	
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0D;
    	}
    	
    	Double resultado = 0D;
    	try {
    		resultado = Calculadora.dividir(numero1, numero2);
    	} catch (DivisaoPorZeroException e) {
    		logger.info(e.getMessage());
    	}
    	
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    //Média entre dois números
    @GetMapping("/media-query")
    public Double mediaQuery(@RequestParam(value="numero1", defaultValue = "0") Double numero1,
    		@RequestParam(value="numero2", defaultValue = "0") Double numero2) {
    	
    	logger.info("Calculando a média entre: " + numero1 + " e " + numero2);
    	Double resultado = Calculadora.media(numero1.toString(), numero2.toString());
    	
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    @RequestMapping(value = "/media-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double mediaPath(@PathVariable("numero1") String numero1, 
    		@PathVariable("numero2") String numero2) {
    	logger.info("Calculando a média entre: " + numero1 + " e " + numero2);
    	
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0D;
    	}
    	
    	Double resultado = Calculadora.media(numero1, numero2);
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    //Potenciação
    @GetMapping("/potencia-query")
    public Double potenciaQuery(@RequestParam(value="numero1", defaultValue = "0") Double numero1,
    		@RequestParam(value="numero2", defaultValue = "0") Double numero2) {
    	
    	logger.info("Calculando " + numero1 + " na " + numero2 + "ª potência...");
    	Double resultado = Calculadora.potencia(numero1.toString(), numero2.toString());

    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    @RequestMapping(value = "/potencia-path/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double potenciaPath(@PathVariable("numero1") String numero1, 
    		@PathVariable("numero2") String numero2) {
    	logger.info("Calculando " + numero1 + " na " + numero2 + "ª potência...");
    	
    	if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
    		return 0D;
    	}

    	Double resultado = Calculadora.potencia(numero1, numero2);

    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    //Raiz Quadrada
    @GetMapping("/raiz-query")
    public Double raizQuery(@RequestParam(value="numero1", 
    						defaultValue = "0") Double numero1) {
    	logger.info("Calculando raiz quadrada de: " + numero1);

    	Double resultado = 0D;
    	try {
    		resultado = Calculadora.raiz(numero1.toString());
    	} catch (NumeroNegativoException e) {
    		logger.info(e.getMessage());
    	}
    	
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
    
    @RequestMapping(value = "/raiz-path/{numero1}", method = RequestMethod.GET)
    public Double raizPath(@PathVariable("numero1") String numero1) {
    	logger.info("Calculando raiz quadrada de: " + numero1);
    	
    	if (!ConversorNumerico.ehNumerico(numero1)) {
    		return 0D;
    	}
    	
    	Double resultado = 0D;
    	try {
    		resultado = Calculadora.raiz(numero1);
    	} catch (NumeroNegativoException e) {
    		logger.info(e.getMessage());
    	}
    	
    	logger.info("O resultado é: " + resultado );
    	return resultado;
    }
}
