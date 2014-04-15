package pcom.fincatto.avaliacaocasa.materialconstrucao;

import java.awt.Color;
import java.math.BigDecimal;
import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;

import pcom.fincatto.avaliacaocasa.componenteconstrucao.Porta;

public class TestPorta {

    @Test
    public void testPortaAbrir() {

	Porta porta = new Porta();
	Boolean retornoAbrir = porta.abrir();
	Assert.assertTrue("Porta não foi aberta como esperado", retornoAbrir);
	Boolean isAberta = porta.isAberta();
	Assert.assertTrue("Porta não foi aberta como esperado", isAberta);

    }

    @Test
    public void testPortaFechar() {

	Porta porta = new Porta();
	Boolean retornoFechar = porta.fechar();
	Assert.assertFalse("Porta fechada quando não poderia ser", retornoFechar);

	porta.abrir();
	retornoFechar = porta.fechar();
	Assert.assertTrue("Porta não foi fechada como esperado", retornoFechar);

	porta.abrir();
	porta.fechar();
	Boolean isAberta = porta.isAberta();
	Assert.assertFalse("Porta não foi fechada como esperado", isAberta);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetAlturaCm_null() {

	Porta porta = new Porta();
	porta.setAlturaCm(null);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetAlturaCm_igualZero() {

	Porta porta = new Porta();
	porta.setAlturaCm(BigDecimal.ZERO);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetAlturaCm3_menorZero() {

	Porta porta = new Porta();
	porta.setAlturaCm(new BigDecimal(-1));

    }

    public void testPortaSetAlturaCm() {

	BigDecimal alturaCm = new BigDecimal(200);
	Porta porta = new Porta();
	porta.setAlturaCm(alturaCm);
	Assert.assertEquals("Altura não foi definida corretamente", alturaCm, porta.getAlturaCm());

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetLarguraCm_null() {

	Porta porta = new Porta();
	porta.setAlturaCm(null);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetLarguraCm_zero() {

	Porta porta = new Porta();
	porta.setLarguraCm(BigDecimal.ZERO);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetLarguraCm_menorZero() {

	Porta porta = new Porta();
	porta.setLarguraCm(new BigDecimal(-1));

    }

    public void testPortaSetLarguraCm() {

	BigDecimal larguraCm = new BigDecimal(200);
	Porta porta = new Porta();
	porta.setLarguraCm(larguraCm);
	Assert.assertEquals("Largura não foi definida corretamente", larguraCm, porta.getLarguraCm());

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetProfundidadeCm_null() {

	Porta porta = new Porta();
	porta.setAlturaCm(null);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetProfundidadeCm_zero() {

	Porta porta = new Porta();
	porta.setProfundidadeCm(BigDecimal.ZERO);

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaSetProfundidadeCm_menorZero() {

	Porta porta = new Porta();
	porta.setProfundidadeCm(new BigDecimal(-1));

    }

    @Test
    public void testPortaSetProfundidadeCm() {

	BigDecimal profundidadeCm = new BigDecimal(200);
	Porta porta = new Porta();
	porta.setProfundidadeCm(profundidadeCm);
	Assert.assertEquals("Profundidade não foi definida corretamente", profundidadeCm, porta.getProfundidadeCm());

    }

    @Test(expected = InvalidParameterException.class)
    public void testPortaPintar_null() {

	Porta porta = new Porta();
	porta.pintar(null);

    }

    @Test
    public void testPortaPintar() {

	Porta porta = new Porta();
	porta.pintar(Color.BLUE);
	Assert.assertEquals("A porta não foi pintada corretamente", Color.BLUE, porta.getCor());

    }

    @Test
    public void testPortaDefaultConstructor() {

	Boolean isAberta = false;
	BigDecimal larguraCm = new BigDecimal(100);
	BigDecimal alturaCm = new BigDecimal(100);
	BigDecimal profundidade = new BigDecimal(2.5);
	Color cor = Color.WHITE;

	Porta porta = new Porta();

	Assert.assertEquals("Porta deveria estar fechada", isAberta, porta.isAberta());
	Assert.assertEquals("A largura não definida corretamente", larguraCm, porta.getLarguraCm());
	Assert.assertEquals("A altura não definida corretamente", alturaCm, porta.getAlturaCm());
	Assert.assertEquals("A profundidade não foi definida corretamente", profundidade, porta.getProfundidadeCm());
	Assert.assertEquals("A cor não foi definida corretemente", cor, porta.getCor());

    }

    @Test
    public void testPortaAllFieldsConstructor() {

	Boolean isAberta = true;
	BigDecimal larguraCm = new BigDecimal(105);
	BigDecimal alturaCm = new BigDecimal(105);
	BigDecimal profundidade = new BigDecimal(5);
	Color cor = Color.BLACK;

	Porta porta = new Porta(isAberta, alturaCm, larguraCm, profundidade, cor);

	Assert.assertEquals("Porta deveria estar fechada", isAberta, porta.isAberta());
	Assert.assertEquals("A largura não definida corretamente", larguraCm, porta.getLarguraCm());
	Assert.assertEquals("A altura não definida corretamente", alturaCm, porta.getAlturaCm());
	Assert.assertEquals("A profundidade não foi definida corretamente", profundidade, porta.getProfundidadeCm());
	Assert.assertEquals("A cor não foi definida corretemente", cor, porta.getCor());

    }

}
