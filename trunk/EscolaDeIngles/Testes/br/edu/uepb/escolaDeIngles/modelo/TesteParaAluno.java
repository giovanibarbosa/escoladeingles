package br.edu.uepb.escolaDeIngles.modelo;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import br.edu.uepb.escolaDeIngles.gerenciadores.ImpossivelExecutarMetodoException;

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
	
	@Test(expected=ImpossivelExecutarMetodoException.class)
	public void verificaMaximoDeEstagios(){
		Aluno aluno = new Aluno();
		for (int i = 0; i < 9; i++) {
			aluno.promoveAluno();
		}
	}
}
