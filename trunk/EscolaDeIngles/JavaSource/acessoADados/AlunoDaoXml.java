/**
 * 
 */
package acessoADados;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import modelo.Aluno;

/**
 * 
 * Implementação de persistência em XML para acesso a dados de aluno
 * 
 */
public class AlunoDaoXml implements AlunoDao {

	public final String CAMINHO_ARQUIVO = "dados.xml";

	public Map<String, Aluno> alunos;

	@SuppressWarnings("unchecked")
	public AlunoDaoXml() throws IOException {
		InputStream stream = null;
		XMLDecoder xmlDecoder = null;
		try {
			stream = new FileInputStream(CAMINHO_ARQUIVO);
			xmlDecoder = new XMLDecoder(stream);
			alunos = (Map<String, Aluno>) xmlDecoder.readObject();
		} catch (FileNotFoundException ex) {
			reiniciaBase();
		} finally {
			if (xmlDecoder != null) {
				xmlDecoder.close();
			}
			stream.close();
		}
	}

	private void reiniciaBase() throws IOException {
		alunos = new TreeMap<String, Aluno>();
		salvaParaDisco(alunos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#obtem(int)
	 */
	@Override
	public Aluno obtem(String id) {
		return alunos.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#remove(int)
	 */
	@Override
	public void remove(String id) throws IOException {
		alunos.remove(id);
		salvaParaDisco(alunos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see acessoADados.AlunoDao#salva(modelo.Aluno)
	 */
	@Override
	public void salva(Aluno aluno) throws IOException {
		aluno.setId(UUID.randomUUID().toString());
		alunos.put(aluno.getId(), aluno);
		salvaParaDisco(alunos);
	}

	private void salvaParaDisco(Map<String, Aluno> alunos) throws IOException {
		OutputStream stream = null;
		XMLEncoder xmlEncoder = null;
		try {
			stream = new FileOutputStream(CAMINHO_ARQUIVO);
			xmlEncoder = new XMLEncoder(stream);
			xmlEncoder.writeObject(alunos);
		} finally {
			xmlEncoder.close();
			stream.close();
		}

	}

	@Override
	public void removeTodos() throws IOException {
		reiniciaBase();
	}

}
