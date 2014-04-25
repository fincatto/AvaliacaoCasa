package pcom.fincatto.avaliacaocasa.main;


import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import pcom.fincatto.avaliacaocasa.bean.Casa;
import pcom.fincatto.avaliacaocasa.bean.Porta;


/**
* Classe responsável por executar testes da classe Casa
* 
* @author Edson Filho
* @version 1.0
* 
*/
public class TesteCasaJUnit {

	private Casa casa;
	
	@Before
	public void inicializar() {
		casa = new Casa();
	}

	@Test(expected = NullPointerException.class)
	public void pintar() {
		casa.pintar(null);
	}
	
	@Test
	public void nenhumaPortaAberta() {
		Porta portaBranca = new Porta(Color.WHITE, Porta.FECHADA, 100, 100);
		Porta portaAzul = new Porta(Color.BLUE, Porta.FECHADA, 100, 100);
		Porta portaVerde = new Porta(Color.GREEN, Porta.FECHADA, 100, 100);
		
		casa.adicionarPorta(portaBranca);
		casa.adicionarPorta(portaAzul);
		casa.adicionarPorta(portaVerde);
		
		assertEquals("Não há porta aberta.", casa.quantasPortasEstaoAbertas());
	}
	
	@Test
	public void umaPortaAberta() {
		Porta portaBranca = new Porta(Color.WHITE, Porta.ABERTA, 100, 100);

		casa.adicionarPorta(portaBranca);
		
		assertEquals("Existe uma porta aberta.", casa.quantasPortasEstaoAbertas());
	}
	
	@Test
	public void variasPortasAbertas() {
		Porta portaBranca = new Porta(Color.WHITE, Porta.ABERTA, 100, 100);
		Porta portaAzul = new Porta(Color.BLUE, Porta.ABERTA, 200, 100);
		Porta portaVerde = new Porta(Color.GREEN, Porta.ABERTA, 300, 100);
		
		casa.adicionarPorta(portaBranca);
		casa.adicionarPorta(portaAzul);
		casa.adicionarPorta(portaVerde);
		
		assertEquals("Existem 3 portas abertas.", casa.quantasPortasEstaoAbertas());
	}
	
	
	@Test(expected = NullPointerException.class)
	public void adicionarPorta() {
		casa.adicionarPorta(null);
	}
	
	@Test
	public void testMain() {
		
		casa.pintar(Color.BLUE);
		
		Porta portaBranca = new Porta(Color.WHITE, Porta.FECHADA, 80, 200);
		casa.adicionarPorta(portaBranca);
		
		Porta portaLaranja = new Porta(Color.ORANGE, Porta.FECHADA, 800, 200);
		casa.adicionarPorta(portaLaranja);
		
		Porta portaVerde = new Porta(Color.GREEN, Porta.FECHADA, 500, 950);
		casa.adicionarPorta(portaVerde);
		
		casa.getPortas().get(0).abrir();
		casa.getPortas().get(1).fechar();
		casa.getPortas().get(2).abrir();
		
		assertEquals("Teste realizado com sucesso.", "Existem 2 portas abertas.", casa.quantasPortasEstaoAbertas());
		
	}

}
