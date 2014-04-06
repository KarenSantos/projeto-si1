package tests;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import models.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Planejador;

public class AddEMoveDisciplinasTest {

	private Planejador planejador;
	private Usuario usuario;
	private Grade grade;
	private PlanoDeCurso plano;

	@Before
	public void setUp() throws Exception {
		start(fakeApplication(inMemoryDatabase()));
		
		grade = new Grade();
		grade.configuraGrade("Computacao grade antiga", new CurriculoAntigoFactory());
		grade.save();
		
		usuario = new Usuario("email@email.com", "meuNome", "senha");
		usuario.save();
		
		plano = new PlanoDeCurso(usuario.getIdDoPlano(), grade);
		plano.save();
		
		planejador = new Planejador(usuario);
	}

	@Test
	public void devePoderAdicionarDisciplina() {

		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas());
		
		try {
			planejador.addDisciplinaPeriodo("a100", 1);
		} catch (AlocacaoInvalidaException e) {
			Assert.fail("Não deveria ter lançado exceção.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lançado exceção.");
		}
		Assert.assertEquals(7, planejador.getPeriodo(1).getTotalDeDisciplinas());
	}

	@Test
	public void naoDevePoderAdicionarDisciplinaSePreRequisitosNaoForamAlocadosEmPeriodosAnteriores() {

		try {
			planejador.removeDisciplinaPeriodo("a03", 1); // liberando espaco para creditos
		} catch (TotalDeCreditosInvalidoException e){
			Assert.fail("Nao deveria ter lancado excecao.");
		}

		try {
			planejador.addDisciplinaPeriodo("a206", 1); // calculo 3 no primeiro periodo
			Assert.fail("Deveria ter lançado exceção.");
		} catch (AlocacaoInvalidaException e) {
			Assert.assertEquals("Esta disciplina tem pré-requisitos não concluídos.", e.getMessage());
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lançado esse tipo de exceção.");
		}

	}

	@Test
	public void naoDevePoderAdicionarSePeriodoNaoForOUltimoEPassarMaximoDeCreditos() {

		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());
		Assert.assertEquals(26, planejador.getPeriodo(2).getTotalDeCreditos());
		
		try {
			planejador.addDisciplinaPeriodo("a100", 2); // segundo periodo ja tem 26 creditos
			Assert.fail("Deveria ter lançado exceção.");
		} catch (AlocacaoInvalidaException e) {
			Assert.fail("Não deveria ter lançado esse tipo de exceção.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals("O número máximo de créditos por período é 28.",
					e.getMessage());
		}
		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas());
		
		//ultimo periodo
		Assert.assertEquals(6, planejador.getPeriodo(8).getTotalDeDisciplinas());
		Assert.assertEquals(24, planejador.getPeriodo(8).getTotalDeCreditos());
		
		try {
			planejador.addDisciplinaPeriodo("a100", 8);
			planejador.addDisciplinaPeriodo("a101", 8);
		} catch (AlocacaoInvalidaException e) {
			Assert.fail("Não deveria ter lancado excecao");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lancado excecao");		
		}
		Assert.assertEquals(8, planejador.getPeriodo(8).getTotalDeDisciplinas());
		Assert.assertEquals(32, planejador.getPeriodo(8).getTotalDeCreditos());
		
	}

	@Test
	public void devePoderMoverDisciplinas() {

		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas()); // 6 disc no primeiro periodo
		Assert.assertEquals(7, planejador.getPeriodo(5).getTotalDeDisciplinas()); // 7 disc no quinto periodo

		try {
			planejador.moveDisciplina("a03", 5, 1); // movendo LPT para o quinto periodo
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lançado exceção.");
		}

		Assert.assertEquals(5, planejador.getPeriodo(1).getTotalDeDisciplinas()); // 5 disc no primeiro periodo
		Assert.assertEquals(8, planejador.getPeriodo(5).getTotalDeDisciplinas()); // 8 disc no quinto periodo
	}

	@Test
	public void naoDevePoderMoverSeMaximoDeCreditosAtingido() {

		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas());
		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());

		try {
			planejador.moveDisciplina("a03", 2, 1); // movendo LPT para o segundo
			Assert.fail("Não deveria ter lançado exceção.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals(
					"O número máximo de créditos por período é 28.",
					e.getMessage());
		}
	}
}
