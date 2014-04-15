package pcom.fincatto.avaliacaocasa.componenteconstrucao;

import java.awt.Color;
import java.math.BigDecimal;
import java.security.InvalidParameterException;

import pcom.fincatto.avaliacaocasa.interfaces.ObserverFechavel;
import pcom.fincatto.avaliacaocasa.interfaces.SubjectFechavel;

/**
 * Representa a abstração de uma porta.
 * 
 * @author Danilo de Oliveira Araújo
 * 
 */
public class Porta extends SubjectFechavel {

    private BigDecimal alturaCm;
    private BigDecimal larguraCm;
    private BigDecimal profundidadeCm;
    private Color cor;

    /**
     * Construtor default que deixa os atributos da seguinte maneira:
     * 
     * <br>
     * this.isAberta == false <br>
     * this.larguraCm == new BigDecimal(100) <br>
     * this.alturaCm == new BigDecimal(100) <br>
     * this.larguraCm == new BigDecimal(2.5) <br>
     * this.cor == Color.WHITE
     * 
     */
    public Porta() {

	super();
	this.larguraCm = new BigDecimal(100);
	this.alturaCm = new BigDecimal(100);
	this.profundidadeCm = new BigDecimal(2.5);
	this.cor = Color.WHITE;

    }

    /**
     * Construtor que utiliza todos os atributos da porta
     * 
     * @param isAberta
     * @param alturaCm
     * @param larguraCm
     * @param profundidadeCm
     * @param cor
     */
    public Porta(Boolean isAberta, BigDecimal alturaCm, BigDecimal larguraCm, BigDecimal profundidadeCm, Color cor, ObserverFechavel... listenersFechaveis) {
	super(isAberta);
	this.alturaCm = alturaCm;
	this.larguraCm = larguraCm;
	this.profundidadeCm = profundidadeCm;
	this.cor = cor;
    }

    /**
     * Método auxiliar responsável por validar o valor atribuído à uma dimensão
     * 
     * @param nomeDimensao
     *            Nome da dimensão à ser validada, é impresso caso uma excessão
     *            ocorra
     * @param valorDimensao
     *            Valor à ser atribuído à uma dimensão
     * @throws InvalidParameterException
     *             Lançada quando uma dimensão é nula ou menor ou igual à 0.
     */
    private void validarDimensoes(String nomeDimensao, BigDecimal valorDimensao) throws InvalidParameterException {

	if (valorDimensao == null) {
	    throw new InvalidParameterException("Não é possível definir a " + nomeDimensao + " de uma porta como 'null'");
	}

	Integer comparacaoDimensaoZero = valorDimensao.compareTo(BigDecimal.ZERO);

	if (comparacaoDimensaoZero <= 0) {
	    throw new InvalidParameterException("A " + nomeDimensao + " de uma porta não pode ser menor ou igual à 0");
	}

    }

    /**
     * 
     * @return Altura da porta em centímetros
     */
    public BigDecimal getAlturaCm() {
	return alturaCm;
    }

    /**
     * Define a altura de uma porta em centímetros
     * 
     * @param alturaCm
     * @throws InvalidParameterException
     *             Lançada quando a altura informada é nula ou menor ou igual à
     *             0.
     */
    public void setAlturaCm(BigDecimal alturaCm) throws InvalidParameterException {
	validarDimensoes("altura", alturaCm);
	this.alturaCm = alturaCm;
    }

    /**
     * 
     * @return Largura da porta em centímetros
     */
    public BigDecimal getLarguraCm() {
	return larguraCm;
    }

    /**
     * Define a largura de uma porta em centímetros
     * 
     * @param larguraCm
     * @throws InvalidParameterException
     *             Lançada quando a largura informada é nula ou menor ou igual à
     *             0.
     */
    public void setLarguraCm(BigDecimal larguraCm) throws InvalidParameterException {
	validarDimensoes("largura", larguraCm);
	this.larguraCm = larguraCm;
    }

    /**
     * 
     * @return Profundidade da porta em centímetros
     */
    public BigDecimal getProfundidadeCm() {
	return profundidadeCm;
    }

    /**
     * Define a profundidade de uma porta em centímetros
     * 
     * @param profundidadeCm
     * @throws InvalidParameterException
     *             Lançada quando a profundidade informada é nula ou menor ou
     *             igual à 0.
     */
    public void setProfundidadeCm(BigDecimal profundidadeCm) throws InvalidParameterException {
	validarDimensoes("profundidade", profundidadeCm);
	this.profundidadeCm = profundidadeCm;
    }

    /**
     * Pinta a porta como cor especifíca.
     * 
     * @param cor
     * @throws InvalidParameterException
     *             Lançada quando a cor informada é nula.
     */
    public void pintar(Color cor) throws InvalidParameterException {

	if (cor == null) {
	    throw new InvalidParameterException("Impossível pintar uma porta com uma cor nula");
	}

	this.cor = cor;

    }

    /**
     * 
     * @return Cor atual da porta
     */
    public Color getCor() {
	return cor;
    }

}
