package br.edu.uepb.escolaDeIngles.modelo;


import junit.framework.Assert;

import org.junit.Test;

public class TesteParaEstagio {

	@Test
	public void verificaEquivalencia(){
		Estagio estagio1 = new Estagio(1);
		Estagio estagio2 = new Estagio(2);
		
		Estagio estagio3 = new Estagio(1);
		
		Assert.assertEquals(estagio1, estagio3);
		Assert.assertFalse(estagio1.equals(estagio2));
	}

}
