package tests;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import models.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Planejador;

public class RemoveDisciplinasTest {

	private Planejador planejador;
	private Usuario usuario;
	private Grade gradeAntiga;
	private PlanoDeCurso plano;

	@Before
	public void setUp() throws Exception {
		start(fakeApplication(inMemoryDatabase()));
		
		gradeAntiga = new GradeAntiga();
		gradeAntiga.configuraGrade("grade antiga");
		gradeAntiga.save();
		
		usuario = new Usuario("email@email.com", "meuNome", "senha");
		usuario.save();
		
		plano = new PlanoDeCurso("p_" + usuario.getEmail(), gradeAntiga);
		plano.save();
		
		planejador = new Planejador(usuario);
	}

	@Test
	public void devePoderRemoverDisciplinasDoPeriodoAtual()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		planejador.setPeriodoAtual(6);
		planejador.removeDisciplinaPeriodo("a40", 6); // removendo IA
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a40")); // IA nao esta mais alocada
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a40")));

		planejador.setPeriodoAtual(1);
		planejador.removeDisciplinaPeriodo("a03", 1); // removendo LPT
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a03")); // LPT nao esta mais alocada
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a03")));

	}

	@Test
	public void devePoderRemoverDePeriodosAnterioresAoAtualSemMinimoDeCreditos()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		planejador.setPeriodoAtual(6);
		planejador.removeDisciplinaPeriodo("a01", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a01"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a01")));
		
		planejador.removeDisciplinaPeriodo("a02", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a02"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a02")));
		
		planejador.removeDisciplinaPeriodo("a03", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a03"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a03")));
		
		planejador.removeDisciplinaPeriodo("a04", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a04"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a04")));
		
		planejador.removeDisciplinaPeriodo("a05", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a05"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a05")));
		
		planejador.removeDisciplinaPeriodo("a06", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("06"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("a06")));

		// primeiro periodo nao tem nenhuma disciplina (o cara perdeu todas!!)
		Assert.assertEquals(0, planejador.getPeriodo(1).getTotalDeCreditos());

	}

	@Test
	public void naoDevePoderRemoverDePeriodoAtualMenosQueMinimo()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		planejador.setPeriodoAtual(8);
		Assert.assertEquals(24, planejador.getPeriodo(8).getTotalDeCreditos());
		
		planejador.removeDisciplinaPeriodo("a86", 8);
		planejador.removeDisciplinaPeriodo("a87", 8);
		
		Assert.assertEquals(16, planejador.getPeriodo(8).getTotalDeCreditos());
		
		try {
			planejador.removeDisciplinaPeriodo("a88", 8);
			Assert.fail("Deveria ter lançado excecao.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals("O número mínimo de créditos neste período é 14.", e.getMessage());
		}

	}

	@Test
	public void naoDeveRemoverDisciplinaSeDependentesUltrapassamMinimoDeCred()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{
		
		planejador.setPeriodoAtual(2);
		try{
			planejador.removeDisciplinaPeriodo("a01", 1); // removendo calculo 1 consequentemente os seus dependentes
			Assert.fail("Deveria ter lançado excecao");
		}
		catch(TotalDeCreditosInvalidoException e){
			Assert.assertEquals(e.getMessage(), "Esta remoção fará o 4º periodo ficar com menos que o mínimo de créditos.");
		}
		
	}
	
	@Test
	public void deveRemoverDisciplinaSePreRequisitoFoiRemovido()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{
		
		planejador.setPeriodoAtual(3);
		Assert.assertEquals(7, planejador.getPeriodo(3).getTotalDeDisciplinas());
		planejador.removeDisciplinaPeriodo("a20", 3); // removendo gi
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a27")); // si1 foi removido tambem
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a33")); // si2 foi removido tambem
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a32")); // bd1 foi removido tambem
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("a39")); // bd2 foi removido tambem
	}
}
