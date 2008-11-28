package br.edu.uepb.escolaDeIngles.acessoADados;

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

import br.edu.uepb.escolaDeIngles.modelo.Aluno;

public class AcessoADadosXml {

	public final String CAMINHO_ARQUIVO = "dados.xml";

	protected Map<String, Aluno> alunos;

	@SuppressWarnings("unchecked")
	protected AcessoADadosXml() {
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
			try {
				stream.close();
			} catch (IOException e) {
				throw new EntradaESaidaException(e);
			}
		}
	}

	protected void reiniciaBase() {
		alunos = new TreeMap<String, Aluno>();
		salvaParaDisco(alunos);
	}

	protected void salvaParaDisco(Map<String, Aluno> alunos) {
		OutputStream stream = null;
		XMLEncoder xmlEncoder = null;
		try {
			stream = new FileOutputStream(CAMINHO_ARQUIVO);
			xmlEncoder = new XMLEncoder(stream);
			xmlEncoder.writeObject(alunos);
		} catch (IOException ex) {
			throw new EntradaESaidaException(ex);
		} finally {
			xmlEncoder.close();
			try {
				stream.close();
			} catch (IOException e) {
				throw new EntradaESaidaException(e);
			}
		}

	}
}
