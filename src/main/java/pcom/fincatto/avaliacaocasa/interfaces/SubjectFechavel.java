package pcom.fincatto.avaliacaocasa.interfaces;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstração de todos as classes que podem ser fechadas ou abertas. Trabalha em
 * conjunto com ObserverFechavel implementando o design pattern Observer
 * 
 * @author Danilo de Oliveira Araújo
 * 
 */
public abstract class SubjectFechavel {

    private Boolean isAberta;
    private Set<ObserverFechavel> observersFechaveis;

    /**
     * Construtor padrão que deixa o objeto fechado (isAberto = false)
     */
    public SubjectFechavel() {
	this.isAberta = false;
	this.observersFechaveis = new HashSet<ObserverFechavel>();
    }

    /**
     * Construtor que aceita a situação do fechável
     * 
     * @param isAberta
     *            situação do fechável, abertou==true ou fechado==false
     */
    public SubjectFechavel(Boolean isAberta) {
	this();
	this.isAberta = isAberta;
    }

    /**
     * Se a porta estiver fechada abre a porta, retorna true e avisa as
     * instâncias de ObserverFechavel que um evento foi disparado. Se a porta
     * estiver aberta retorna false e não realizada qualquer operação.
     * 
     * @return true caso a operação tenha ocorrido com sucesso ou false quando a
     *         porta já estava aberta.
     */
    public Boolean abrir() {

	if (this.isAberta) {
	    return false;
	}

	this.isAberta = true;

	notifyObserversFechaveis();

	return true;

    }

    /**
     * Retorna true quando a porta está aberta ou false quando ela está fechada.
     * 
     * @return true quando a porta está aberta ou false quando ela está fechada.
     */
    public Boolean isAberta() {
	return isAberta;
    }

    /**
     * Se a porta estiver aberta fecha a porta, retorna true e avisa as
     * instâncias de ObserverFechavel que um evento foi disparado. Se a porta
     * estiver fechada retorna false e não realizada qualquer operação.
     * 
     * @return true caso a operação tenha ocorrido com sucesso ou false quando a
     *         porta já estava fechada.
     */
    public Boolean fechar() {

	if (this.isAberta) {

	    this.isAberta = false;

	    notifyObserversFechaveis();

	    return true;

	}

	return false;
    }

    /**
     * Registro um ObserverFechavel para ouvir os eventos abrir e fechar
     * 
     * @param observerFechavel
     * @return Retorna true quando o ObserverFechavel é registrado com sucesso.
     *         Retorna false quando o ObserverFechavel já havia sido registrado
     *         previamente
     */
    public Boolean addObserverFechavel(ObserverFechavel observerFechavel) {

	return this.observersFechaveis.add(observerFechavel);

    }

    /**
     * Remove um ObserverFechavel
     * 
     * @param observerFechavel
     * @return Retorna true quando o ObserverFechavel é removido com sucesso.
     *         Retorna false quando o ObserverFechavel não estava registrado
     *         previamente
     */
    public Boolean removeObserverFechavel(ObserverFechavel observerFechavel) {

	return this.observersFechaveis.remove(observerFechavel);

    }

    /**
     * Método auxiliar que avisa todos as intâncias de ObserverFechavel quando
     * os eventos fechar e abrir são disparados
     */
    private void notifyObserversFechaveis() {

	for (ObserverFechavel listenerFechavel : observersFechaveis) {

	    listenerFechavel.ouvirSubjectFechavel(this);

	}

    }

}
