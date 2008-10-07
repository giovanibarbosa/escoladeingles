package acessoADados;

import static org.junit.Assert.*;

import java.io.IOException;

import modelo.Aluno;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlunoDaoXmlTest {

	private static AlunoDao alunoDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		alunoDao = DaoFactory.GetInstance().criaAlunoDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		alunoDao.removeTodos();
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
		aluno.setEndereco("Endereço");
		aluno.setTelefone("83 1234-1234");
		
		try {
			alunoDao.salva(aluno);
		} catch (IOException e) {
			fail("Falhou o teste");
		}
	}
	
	@Test
	public void testObtem(){
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco("Endereço");
		aluno.setTelefone("83 1234-1234");
		
		try {
			alunoDao.salva(aluno);
		} catch (IOException e) {
			fail("Falhou o teste");
		}
		
		Aluno outro = alunoDao.obtem(aluno.getId());
		assertEquals("Aluno 1", outro.getNome());
		assertEquals("Endereço"	, outro.getEndereco());
		assertEquals("83 1234-1234", outro.getTelefone());
	}
	
	@Test
	public void testRemove() throws IOException{
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno 1");
		aluno.setEndereco("Endereço");
		aluno.setTelefone("83 1234-1234");
		
		try {
			alunoDao.salva(aluno);
		} catch (IOException e) {
			fail("Falhou o teste");
		}
		
		alunoDao.remove(aluno.getId());
		
		assertNull(alunoDao.obtem(aluno.getId()));
	}
}
