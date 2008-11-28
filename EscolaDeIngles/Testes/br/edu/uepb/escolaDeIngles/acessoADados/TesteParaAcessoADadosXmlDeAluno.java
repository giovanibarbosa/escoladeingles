package br.edu.uepb.escolaDeIngles.acessoADados;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.uepb.escolaDeIngles.FabricaDeObjetos;
import br.edu.uepb.escolaDeIngles.modelo.Aluno;

public class TesteParaAcessoADadosXmlDeAluno {

	private static AcessoADadosDeAluno acessoADadosDeAluno;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		acessoADadosDeAluno = FabricaDeObjetos.GetInstance().criaAcessoADadosDeAluno();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		acessoADadosDeAluno.removeTodos();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSalva(){
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco("Rua 1");
		aluno.setTelefone("83 1234-1234");
		
		try {
			acessoADadosDeAluno.salva(aluno);
			Assert.assertNotNull(aluno.getId());
		} catch (Exception e) {
			fail("Falhou o teste");
		}
	}
	
	@Test
	public void testObtem(){
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco("Rua 1");
		aluno.setTelefone("83 1234-1234");
		
		try {
			acessoADadosDeAluno.salva(aluno);
		} catch (Exception e) {
			fail("Falhou o teste");
		}
		
		Aluno outro = acessoADadosDeAluno.obtem(aluno.getId());
		assertEquals("Aluno 1", outro.getNome());
		assertEquals("Rua 1"	, outro.getEndereco());
		assertEquals("83 1234-1234", outro.getTelefone());
	}
	
	@Test
	public void testRemove() throws IOException{
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco("Rua 1");
		aluno.setTelefone("83 1234-1234");
		
		try {
			acessoADadosDeAluno.salva(aluno);
		} catch (Exception e) {
			fail("Falhou o teste");
		}
		acessoADadosDeAluno.remove(aluno.getId());
		assertNull(acessoADadosDeAluno.obtem(aluno.getId()));
	}
}
