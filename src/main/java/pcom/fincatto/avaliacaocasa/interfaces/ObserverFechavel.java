package pcom.fincatto.avaliacaocasa.interfaces;

/**
 * 
 * Escuta os eventos disparados por um SubjectFechavel. Juntamento com
 * SubjectFechavel representa uma implementação do design pattern Observer.
 * 
 * @author Danilo de Oliveira Araújo
 * 
 */
public interface ObserverFechavel {

    /**
     * Método à ser executado sempre que um SubjectFechavel onde esse
     * observer estiver registrado disparar um evento fechar ou abrir
     * 
     * @param subjectFechavel
     *            SubjectFechavel que disparou um evento fechar ou abrir
     */

    void ouvirSubjectFechavel(SubjectFechavel subjectFechavel);

}
