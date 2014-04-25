package pcom.fincatto.avaliacaocasa.bean;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma casa.
 * 
 * @author Edson Filho
 * @version 1.0
 */
public class Casa {

	@SuppressWarnings("unused")
	private Color cor;
	private List<Porta> portas;

	/**
	 * Construtor padrão que instancia uma casa na cor branca sem nenhuma porta
	 * @author Edson Filho
	 * @since 1.0
	 */
	public Casa() {
		this(Color.WHITE, new ArrayList<Porta>(0));
	}

	/**
	 * Construtor que instancia uma casa com uma cor especifica sem nenhuma porta
	 * @param cor
	 * @author Edson Filho
	 * @since 1.0
	 * @see Color
	 */
	public Casa(Color cor) {
		this(cor, new ArrayList<Porta>(0));
	}

	/**
	 * Construtor que instancia uma casa com uma cor especifica e com nenhuma ou muitas portas
	 * @param cor
	 * @param portas
	 * @author Edson Filho
	 * @since 1.0
	 * @see Color Porta
	 */
	public Casa(Color cor, List<Porta> portas) {
		this.cor = cor;
		this.portas = portas;
	}

	/**
	 * Altera a cor de uma casa		
	 * @param cor
	 * @author Edson Filho
	 * @since 1.0
	 * @see Color
	 */
	public void pintar(Color cor) {
		if(cor == null) {
			throw new NullPointerException("Não é possível pintar uma casa sem cor");
		}
		this.cor = cor;
	}

	/**
	 * Retorna uma mensagem informando a quantidade de portas abertas.		
	 * @return mensagem de portas abertas
	 * @author Edson Filho
	 * @since 1.0
	 * @see String
	 */
	public String quantasPortasEstaoAbertas() {
		int contador = 0;
		for(Porta p : portas){
			if(p.isAberta())
				contador++;
		}
		return montarMensagemPorta(contador);
	}

	private String montarMensagemPorta(int contador) {
		switch(contador) {
		case 0:
			return "Não há porta aberta.";
		case 1:
			return "Existe uma porta aberta.";
		default:
			return "Existem "+ contador +" portas abertas.";
		}
	}

	/**
	 * Adiciona uma porta a casa	
	 * @param porta
	 * @author Edson Filho
	 * @since 1.0
	 * @see Porta
	 */
	public void adicionarPorta(Porta porta) {
		if(porta == null) {
			throw new NullPointerException("Porta inexistente");
		}
		portas.add(porta);
	}

	/**
	 * Retorna as portas da casa
	 * @return portas
	 * @author Edson Filho
	 * @since 1.0
	 * @see List Porta
	 */
	public List<Porta> getPortas() {
		return portas;
	}

}
