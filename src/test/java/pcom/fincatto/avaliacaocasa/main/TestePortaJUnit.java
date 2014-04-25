package pcom.fincatto.avaliacaocasa.main;


import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Dimension;
import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

import pcom.fincatto.avaliacaocasa.bean.Porta;

/**
* Classe responsável por executar testes da classe Porta
* 
* @author Edson Filho
* @version 1.0
* 
*/
public class TestePortaJUnit {

	private Porta porta;
	
	@Before
	public void inicializarPorta() {
		porta = new Porta(Color.WHITE, Porta.ABERTA, 80, 200);
	}

	@Test(expected = InvalidParameterException.class)
	public void validarAlturaDaPorta() {
		porta = new Porta(Color.WHITE, Porta.ABERTA, 80, -1);
	}

	@Test(expected = InvalidParameterException.class)
	public void validarLarguraDaPorta() {
		porta = new Porta(Color.WHITE, Porta.ABERTA, -1, 200);
	}
	
	@Test(expected = NullPointerException.class)
	public void pintar() {
		porta.pintar(null);
	}

	@Test
	public void isPortaFechada() {
		porta.fechar();
		assertEquals("A porta está fechada", Porta.FECHADA, porta.isAberta());
	}
	
	@Test
	public void isPortaAberta() {
		porta.abrir();
		assertEquals("A porta está aberta", Porta.ABERTA, porta.isAberta());
	}
	
	@Test
	public void pintarPortaDeRosa() {
		porta.pintar(Color.PINK);
		assertEquals("A porta é rosa", Color.PINK, porta.getCor());
	}
	
	@Test
	public void testMain() {
		
		porta.fechar();
		
		porta.pintar(Color.RED);
		porta.pintar(Color.YELLOW);
		porta.pintar(Color.GREEN);
		
		porta.setDimensao(new Dimension(200, 300));
		
		if(porta.isAberta()){
			System.out.println("Porta esta aberta.");
		}else{
			System.out.println("Porta esta fechada.");	
		}
		
		assertEquals("Teste main finalizado.", Porta.FECHADA, porta.isAberta());
		
	}

}
