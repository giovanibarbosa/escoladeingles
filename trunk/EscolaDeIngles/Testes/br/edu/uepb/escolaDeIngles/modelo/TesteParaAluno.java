package br.edu.uepb.escolaDeIngles.modelo;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class TesteParaAluno {

	@Test
	public void verificaAlunoMatriculado() {
		Aluno aluno = new Aluno();
		aluno.getMatricula().setDataDeMatricula(new Date());
		Assert.assertTrue(aluno.isMatriculado());
	}
	
	@Test
	public void verificaAlunoNaoMatriculado1(){
		Aluno aluno = new Aluno();
		Assert.assertFalse(aluno.isMatriculado());
	}
	
	@Test
	public void verificaAlunoNaoMatriculado2(){
		Aluno aluno = new Aluno();
		aluno.getMatricula().setDataDeConclusao(new Date());
		Assert.assertFalse(aluno.isMatriculado());
	}

	@Test
	public void verificaAlunoNaoMatriculado3(){
		Aluno aluno = new Aluno();
		aluno.getMatricula().setDataDeMatricula(new Date());
		aluno.getMatricula().setDataDeConclusao(new Date());
		Assert.assertFalse(aluno.isMatriculado());
	}
	
	@Test
	public void verificaEstagioDoAlunoRecemCriado(){
		Aluno aluno = new Aluno();
		Assert.assertEquals(1, aluno.getEstagioAtual());
	}
}
