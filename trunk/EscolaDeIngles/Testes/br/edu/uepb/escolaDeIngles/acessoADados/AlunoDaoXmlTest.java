package br.edu.uepb.escolaDeIngles.acessoADados;

import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.uepb.escolaDeIngles.modelo.Aluno;
import br.edu.uepb.escolaDeIngles.modelo.Endereco;
import br.edu.uepb.escolaDeIngles.modelo.Estado;

public class AlunoDaoXmlTest {

	private static AcessoADadosDeAluno acessoADadosDeAluno;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		acessoADadosDeAluno = FabricaDeAcessoADados.GetInstance().criaAlunoDao();
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
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Endereço");
		endereco.setCidade("Cidade");
		endereco.setEstado(Estado.PB);
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco(endereco);
		aluno.setTelefone("83 1234-1234");
		
		try {
			acessoADadosDeAluno.salva(aluno);
		} catch (IOException e) {
			fail("Falhou o teste");
		}
	}
	
	@Test
	public void testObtem(){
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Endereço");
		endereco.setCidade("Cidade");
		endereco.setEstado(Estado.PB);
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco(endereco);
		aluno.setTelefone("83 1234-1234");
		
		try {
			acessoADadosDeAluno.salva(aluno);
		} catch (IOException e) {
			fail("Falhou o teste");
		}
		
		Aluno outro = acessoADadosDeAluno.obtem(aluno.getId());
		assertEquals("Aluno 1", outro.getNome());
		assertEquals("Endereço"	, outro.getEndereco().getLogradouro());
		assertEquals("Cidade"	, outro.getEndereco().getCidade());
		assertEquals(Estado.PB	, outro.getEndereco().getEstado());
		assertEquals("83 1234-1234", outro.getTelefone());
	}
	
	@Test
	public void testRemove() throws IOException{
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Endereço");
		endereco.setCidade("Cidade");
		endereco.setEstado(Estado.PB);
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco(endereco);
		aluno.setTelefone("83 1234-1234");
		
		try {
			acessoADadosDeAluno.salva(aluno);
		} catch (IOException e) {
			fail("Falhou o teste");
		}
		
		acessoADadosDeAluno.remove(aluno.getId());
		
		assertNull(acessoADadosDeAluno.obtem(aluno.getId()));
	}
}
