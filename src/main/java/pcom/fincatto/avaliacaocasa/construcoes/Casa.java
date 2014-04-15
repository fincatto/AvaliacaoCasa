package pcom.fincatto.avaliacaocasa.construcoes;

import java.awt.Color;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

import pcom.fincatto.avaliacaocasa.componenteconstrucao.Porta;
import pcom.fincatto.avaliacaocasa.interfaces.ObserverFechavel;
import pcom.fincatto.avaliacaocasa.interfaces.SubjectFechavel;

/**
 * 
 * Abstração de uma casa
 * 
 * @see ObserverFechavel
 * 
 * @author Danilo de Oliveira Araújo
 * 
 */
public class Casa implements ObserverFechavel {

    private Color cor;
    private Set<Porta> listPortas;
    private Integer quantasPortasEstaoAbertas;

    /**
     * 
     * Construtor padrão que pinta a casa de branco
     * 
     */
    public Casa() {
	this.listPortas = new HashSet<Porta>();
	this.cor = Color.WHITE;
	this.quantasPortasEstaoAbertas = 0;
    }

    /**
     * 
     * Pinta uma casa com uma determinada cor
     * 
     * @param Cor
     *            a ser usada para pintar a casa
     * 
     * @throws InvalidParameterException
     *             Lançada quando a exceção informada for nula
     */
    public void pintar(Color cor) throws InvalidParameterException {

	if (cor == null) {
	    throw new InvalidParameterException("A cor de uma casa não pode ser nula");
	}

	this.cor = cor;

    }

    /**
     * 
     * @return Cor atual da casa
     */
    public Color getCor() {
	return cor;
    }

    /**
     * Adiciona portas a casa contabilizando possíveis portas abertas e
     * registrando a casa na porta para ouvir os eventos porta.abrir() e
     * porta.fechar()
     * 
     * @param porta
     *            Porta a ser adicionada
     * @throws InvalidParameterException
     *             Lançada quando a porta informada é nula
     */
    public void addPorta(Porta porta) throws InvalidParameterException {

	if (porta == null) {
	    throw new InvalidParameterException();
	}

	if (porta.isAberta()) {
	    quantasPortasEstaoAbertas++;
	}

	porta.addObserverFechavel(this);

	listPortas.add(porta);
    }

    /**
     * Remove portas da casa contabilizando possíveis portas abertas e removendo
     * a casa da porta evitando assim audições errôneas dos eventos
     * porta.abrir() e porta.fechar()
     * 
     * @param porta
     *            Porta a ser removida
     * @throws InvalidParameterException
     *             Lançada quando a porta informada é nula
     */
    public void removePorta(Porta porta) throws InvalidParameterException {

	if (porta == null) {
	    throw new InvalidParameterException();
	}

	Boolean wasRemoved = listPortas.remove(porta);

	if (wasRemoved) {

	    porta.removeObserverFechavel(this);

	    if (porta.isAberta()) {
		quantasPortasEstaoAbertas--;
	    }
	}

    }

    /**
     * 
     * @return Cópia do conjunto de portas da casa
     */
    public Set<Porta> getListPortas() {

	return new HashSet<Porta>(this.listPortas);

    }

    /**
     * 
     * @return Número de portas que a casa possui
     */
    public Integer getQuantidadePortas() {

	return listPortas.size();

    }

    /**
     * Trata o evento porta.fechar() decrementando o número de portas abertas e
     * o evento porta.abrir() incrementando o número de portas abertas
     * 
     */
    public void ouvirSubjectFechavel(SubjectFechavel subjectFechavel) {

	if (subjectFechavel.isAberta() && (subjectFechavel instanceof Porta)) {
	    quantasPortasEstaoAbertas++;
	}

	if (!subjectFechavel.isAberta() && (subjectFechavel instanceof Porta)) {
	    quantasPortasEstaoAbertas--;
	}

    }

    public Integer getQuantasPortasEstaoAbertas() {
	return quantasPortasEstaoAbertas;
    }

}
