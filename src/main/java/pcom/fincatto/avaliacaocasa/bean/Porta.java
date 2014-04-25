package pcom.fincatto.avaliacaocasa.bean;

import java.awt.Color;
import java.awt.Dimension;
import java.security.InvalidParameterException;


/**
 * Classe que representa uma porta.
 * 
 * @author Edson Filho
 * @version 1.0
 * 
 */
public class Porta {

	public final static boolean ABERTA = true;
	public final static boolean FECHADA = false;

	private Color cor;
	private Dimension dimensao;
	private boolean aberta;

	/**
	 * Construtor padr�o que instancia uma porta na cor branca, aberta e com dimens�o de 80x200
	 * @author Edson Filho
	 * @since 1.0
	 */
	public Porta(){
		this(Color.WHITE, ABERTA, 80, 200);
	}

	/**
	 * Construtor que define cor, abertura e dimens�o da porta
	 * @param cor
	 * @param aberta Caso passado true como valor inicial, a porta est� aberta, sen�o est� fechada
	 * @param largura
	 * @param altura
	 * @author Edson Filho
	 * @since 1.0
	 * @see Color
	 */
	public Porta(Color cor, boolean aberta, int largura, int altura) {
		this.cor = cor;
		setAberta(aberta);
		setDimensao(new Dimension(largura, altura));
	}

	/**
	 * Altera estado da porta para aberta.
	 * @author Edson Filho
	 * @since 1.0
	 */
	public void abrir() {
		this.aberta = ABERTA;
	}

	/**
	 * Altera estado da porta para fechada.
	 * @author Edson Filho
	 * @since 1.0
	 */
	public void fechar() {
		this.aberta = FECHADA;
	}

	/**
	 * Verifica se a porta esta aberta.
	 * @return Retorna um booleano verdadeiro se estiver aberta, falso caso contr�rio
	 */
	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
	
	/**
	 * Altera a cor da porta.
	 * @param cor
	 * @author Edson Filho
	 * @since 1.0
	 * @see Color
	 */
	public void pintar(Color cor) {
		if(cor == null) {
			throw new NullPointerException("N�o � poss�vel pintar uma porta sem cor");
		}
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}
	
	/**
	 * Altera as dimens�es da porta.
	 * @param dimensao
	 * @author Edson Filho
	 * @since 1.0
	 * @see Dimension
	 * @throws InvalidParameterException � lan�ada se a largura ou a altura da porta for menor ou igual a zero
	 */
	public void setDimensao(Dimension dimensao) {
		if(dimensao.getWidth() < 0){
			throw new InvalidParameterException("A largura da porta deve ser maior que zero");
		}else if(dimensao.getHeight() < 0){
			throw new InvalidParameterException("A altura da porta deve ser maior que zero");
		}
		this.dimensao = dimensao;
	}

	/**
	 * Retorna a dimens�o da porta.
	 * 
	 * @return dimensao
	 * @author Edson Filho
	 * @since 1.0
	 * @see Dimension
	 */
	public Dimension getDimensao() {
		return dimensao;
	}

}
