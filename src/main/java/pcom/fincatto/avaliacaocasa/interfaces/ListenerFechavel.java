package pcom.fincatto.avaliacaocasa.interfaces;

/**
 * 
 * Escuta os eventos disparados por um SubjectFechavel.
 * Juntamento com SubjectFechavel representa uma implementação do 
 * design pattern Observer
 * 
 * @author Danilo de Oliveira Araújo
 *
 */
public interface ListenerFechavel {

    void ouvirSubjectFechavel(SubjectFechavel subjectFechavel);

}
