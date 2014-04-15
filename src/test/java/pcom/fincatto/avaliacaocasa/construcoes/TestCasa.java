package pcom.fincatto.avaliacaocasa.construcoes;

import java.awt.Color;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import pcom.fincatto.avaliacaocasa.componenteconstrucao.Porta;

public class TestCasa {

    @Test(expected = InvalidParameterException.class)
    public void testCasaPintar_null() {

	Casa casa = new Casa();
	casa.pintar(null);

    }

    @Test
    public void testCasaPintar() {

	Casa casa = new Casa();
	casa.pintar(Color.BLACK);
	Assert.assertEquals("A casa não foi pintada corretamente", Color.BLACK, casa.getCor());

    }

    @Test(expected = InvalidParameterException.class)
    public void testCasaAddPorta_null() {

	Casa casa = new Casa();
	casa.addPorta(null);

    }

    @Test
    public void testCasaAddPorta() {

	Casa casa = new Casa();
	casa.addPorta(new Porta());

	Assert.assertEquals("A porta não foi adicionada corretamente", new Integer(1), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(0), casa.getQuantasPortasEstaoAbertas());

	Porta portaAberta = new Porta();
	portaAberta.abrir();
	casa.addPorta(portaAberta);

	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(1), casa.getQuantasPortasEstaoAbertas());

	casa.addPorta(portaAberta);
	Assert.assertEquals("A mesma porta foi adicionada 2 vezes a casa", new Integer(2), casa.getQuantidadePortas());

    }

    @Test(expected = InvalidParameterException.class)
    public void testCasaRemovePorta_null() {

	Casa casa = new Casa();
	casa.removePorta(null);

    }

    @Test
    public void testCasaRemovePorta() {

	Casa casa = new Casa();

	Porta portaFechada = new Porta();
	portaFechada.fechar();
	casa.addPorta(portaFechada);

	Porta portaAberta = new Porta();
	portaAberta.abrir();
	casa.addPorta(portaAberta);

	casa.removePorta(portaFechada);
	Assert.assertEquals("A porta não foi removida corretamente", new Integer(1), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(1), casa.getQuantasPortasEstaoAbertas());

	casa.removePorta(portaAberta);
	Assert.assertEquals("A porta não foi removida corretamente", new Integer(0), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(0), casa.getQuantasPortasEstaoAbertas());

    }

    @Test
    public void testCasaAbrirFecharPortas() {

	Casa casa = new Casa();

	Porta portaFechada1 = new Porta();

	Porta portaAberta1 = new Porta();
	portaAberta1.abrir();

	Porta portaAberta2 = new Porta();
	portaAberta2.abrir();

	// 2 portas abertas e 1 fechada
	casa.addPorta(portaAberta1);
	casa.addPorta(portaAberta2);
	casa.addPorta(portaFechada1);
	Assert.assertEquals("As portas não foram adicionadas corretamente", new Integer(3), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(2), casa.getQuantasPortasEstaoAbertas());

	// Todas as portas fechadas
	portaAberta1.fechar();
	portaAberta2.fechar();
	portaFechada1.fechar();
	Assert.assertEquals("As portas não foram fechadas corretamente", new Integer(3), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(0), casa.getQuantasPortasEstaoAbertas());

	// Todas as portas abertas
	portaAberta1.abrir();
	portaAberta2.abrir();
	portaFechada1.abrir();
	Assert.assertEquals("As portas não foram fechadas corretamente", new Integer(3), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(3), casa.getQuantasPortasEstaoAbertas());

	// Retirando uma porta que estava aberta e a fechando após a remoção sem
	// interferir no número correto de portas abertas
	casa.removePorta(portaAberta1);
	portaAberta1.fechar();
	Assert.assertEquals("As portas não foram fechadas corretamente", new Integer(2), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(2), casa.getQuantasPortasEstaoAbertas());

	// Abrindo a porta que foi removida sem interferir no número correto de
	// portas abertas
	portaAberta1.abrir();
	Assert.assertEquals("As portas não foram fechadas corretamente", new Integer(2), casa.getQuantidadePortas());
	Assert.assertEquals("O numero de portas abertas não está correto", new Integer(2), casa.getQuantasPortasEstaoAbertas());

    }

    @Test
    public void testCasaGetListPortas() {

	Casa casa = new Casa();

	Assert.assertEquals("Casa não está com o número correto de portas", new Integer(0), Integer.valueOf(casa.getListPortas().size()));

	Porta porta1 = new Porta();
	Porta porta2 = new Porta();
	casa.addPorta(porta1);
	casa.addPorta(porta2);
	
	Set<Porta> copiaListPortas = casa.getListPortas();
	copiaListPortas.remove(porta1);
	copiaListPortas.remove(porta2);

	Assert.assertEquals("O conjunto de portas da casa foi alterado por um objeto externo à casa", new Integer(2), casa.getQuantidadePortas());

    }
}
