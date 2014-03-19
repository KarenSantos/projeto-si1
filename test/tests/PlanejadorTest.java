package tests;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import models.AlocacaoInvalidaException;
import models.Disciplina;
import models.Grade;
import models.TotalDeCreditosInvalidoException;
import models.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Planejador;

public class PlanejadorTest {

	private Planejador planejador;
	private Grade grade;
	private Usuario testador;

	@Before
	public void setUp() throws Exception {
		start(fakeApplication(inMemoryDatabase()));
		grade = new Grade();
		testador = new Usuario("testador@teste.teste", "Nome", "password");
		testador.save();
		planejador = new Planejador(testador);

	}

	@Test
	public void deveIniciarComTodasAsDisciplinasAlocadas() {
		Assert.assertEquals(8, planejador.getTotalDePeriodos());

		for (Disciplina disc : planejador.getDisciplinasNaoAlocadas()) {
			Assert.assertTrue(disc.getPeriodoSugerido() < 0); 
			// todas as disciplinas nao alocadas sao optativas
		}
	}

	@Test
	public void deveCalcularTotalDeCreditosDosPeriodos() {
		Assert.assertEquals(24, planejador.getPeriodo(1).getTotalDeCreditos());
		Assert.assertEquals(26, planejador.getPeriodo(2).getTotalDeCreditos());
		Assert.assertEquals(28, planejador.getPeriodo(3).getTotalDeCreditos());
		Assert.assertEquals(26, planejador.getPeriodo(4).getTotalDeCreditos());
		Assert.assertEquals(24, planejador.getPeriodo(5).getTotalDeCreditos());
		Assert.assertEquals(28, planejador.getPeriodo(6).getTotalDeCreditos());
		Assert.assertEquals(28, planejador.getPeriodo(7).getTotalDeCreditos());
		Assert.assertEquals(24, planejador.getPeriodo(8).getTotalDeCreditos());
	}

	@Test
	public void devePoderAdicionarDisciplina() {

		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas());
		
		try {
			planejador.addDisciplinaPeriodo("61", 1);
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
			planejador.removeDisciplinaPeriodo("03", 1); // liberando espaco para creditos
		} catch (TotalDeCreditosInvalidoException e){
			Assert.fail("Nao deveria ter lancado excecao.");
		}

		try {
			planejador.addDisciplinaPeriodo("51", 1); // calculo 3 no primeiro periodo
			Assert.fail("Deveria ter lançado exceção.");
		} catch (AlocacaoInvalidaException e) {
			Assert.assertEquals("Esta disciplina tem pré-requisitos não concluídos.", e.getMessage());
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lançado esse tipo de exceção.");
		}

	}

	@Test
	public void naoDevePermitirAdicionarSePeriodoNaoForOUltimoEPassarMaximoDeCreditos() {

		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());
		Assert.assertEquals(26, planejador.getPeriodo(2).getTotalDeCreditos());
		
		try {
			planejador.addDisciplinaPeriodo("61", 2); // segundo periodo ja tem 26 creditos
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
			planejador.addDisciplinaPeriodo("61", 8);
			planejador.addDisciplinaPeriodo("62", 8);
		} catch (AlocacaoInvalidaException e) {
			Assert.fail("Não deveria ter lancado excecao");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lancado excecao");		
		}
		Assert.assertEquals(8, planejador.getPeriodo(8).getTotalDeDisciplinas());
		Assert.assertEquals(32, planejador.getPeriodo(8).getTotalDeCreditos());
		
	}

	@Test
	public void devePermitirMoverDisciplinas() {

		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas()); // 6 disc no primeiro periodo
		Assert.assertEquals(7, planejador.getPeriodo(5).getTotalDeDisciplinas()); // 7 disc no quinto periodo

		try {
			planejador.moveDisciplina("03", 5, 1); // movendo LPT para o quinto periodo
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Não deveria ter lançado exceção.");
		}

		Assert.assertEquals(5, planejador.getPeriodo(1).getTotalDeDisciplinas()); // 5 disc no primeiro periodo
		Assert.assertEquals(8, planejador.getPeriodo(5).getTotalDeDisciplinas()); // 8 disc no quinto periodo
	}

	@Test
	public void naoDevePermitirMoverSeMaximoDeCreditosAtingido() {

		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas());
		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());

		try {
			planejador.moveDisciplina("03", 2, 1); // movendo LPT para o segundo
			Assert.fail("Não deveria ter lançado exceção.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals(
					"O número máximo de créditos por período é 28.",
					e.getMessage());
		}
	}

	@Test
	public void aoMoverDisciplinaDeveAtualizarSeuStatusDeAlocacao()
			throws TotalDeCreditosInvalidoException, AlocacaoInvalidaException {

		planejador.setPeriodoAtual(2);
		planejador.removeDisciplinaPeriodo("09", 2); // liberando espaço no segundo periodo

		planejador.moveDisciplina("01", 2, 1); // movendo calculo 1 para o segundo periodo
		Assert.assertFalse(planejador.getDisciplina("07")
				.isAlocadaCorretamente()); // quem tem calculo 1 como pre-requisito fica alocado incorretamente
		Assert.assertFalse(planejador.getDisciplina("13").isAlocadaCorretamente());
		planejador.moveDisciplina("01", 1, 2); // movendo de volta para o lugar certo
		Assert.assertTrue(planejador.getDisciplina("01").isAlocadaCorretamente());

		planejador.moveDisciplina("17", 1, 3); // movendo EDA para o primeiro periodo
		Assert.assertFalse(planejador.getDisciplina("17")
				.isAlocadaCorretamente()); // EDA fica alocada incorretamente, seus preRequisitos nao foram satisfeitos

		planejador.moveDisciplina("17", 5, 1); // movendo EDA para o quinto periodo
		Assert.assertTrue(planejador.getDisciplina("17")
				.isAlocadaCorretamente()); // EDA fica ok
		Assert.assertFalse(planejador.getDisciplina("22")
				.isAlocadaCorretamente()); // aquelas que tem EDA como pre-requisito nao estao ok
		Assert.assertFalse(planejador.getDisciplina("24").isAlocadaCorretamente());
		Assert.assertFalse(planejador.getDisciplina("25").isAlocadaCorretamente());

		planejador.moveDisciplina("17", 3, 5); // voltando EDA para o periodo correto
		Assert.assertTrue(planejador.getDisciplina("22")
				.isAlocadaCorretamente()); // aquelas que tem EDA como pre-requisito ficam ok
		Assert.assertTrue(planejador.getDisciplina("24").isAlocadaCorretamente());
		Assert.assertTrue(planejador.getDisciplina("25").isAlocadaCorretamente());
	}

	@Test
	public void deveIniciarComPeriodoAtual1() {

		Assert.assertEquals(1, planejador.getNumPeriodoAtual());
	}

	@Test
	public void devePoderMudarPeriodoAtual() {

		planejador.setPeriodoAtual(2);
		Assert.assertEquals(2, planejador.getNumPeriodoAtual());
		
		planejador.setPeriodoAtual(7);
		Assert.assertEquals(7, planejador.getNumPeriodoAtual());
	}

	@Test
	public void devePoderRemoverDisciplinasDoPeriodoAtual()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		planejador.setPeriodoAtual(6);
		planejador.removeDisciplinaPeriodo("40", 6); // removendo IA
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("40")); // IA nao esta mais alocada
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("40")));

		planejador.setPeriodoAtual(1);
		planejador.removeDisciplinaPeriodo("03", 1); // removendo LPT
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("03")); // LPT nao esta mais alocada
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("03")));

	}

	@Test
	public void devePoderRemoverDePeriodosAnterioresAoAtualSemMinimoDeCreditos()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		planejador.setPeriodoAtual(6);
		planejador.removeDisciplinaPeriodo("01", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("01"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("01")));
		
		planejador.removeDisciplinaPeriodo("02", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("02"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("02")));
		
		planejador.removeDisciplinaPeriodo("03", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("03"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("03")));
		
		planejador.removeDisciplinaPeriodo("04", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("04"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("04")));
		
		planejador.removeDisciplinaPeriodo("05", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("05"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("05")));
		
		planejador.removeDisciplinaPeriodo("06", 1);
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("06"));
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(
				planejador.getDisciplina("06")));

		Assert.assertEquals(0, planejador.getPeriodo(1).getTotalDeCreditos());

	}

	@Test
	public void naoDevePoderRemoverDePeriodoAtualMenosQueMinimo()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		//TODO ajeitar isso

		planejador.setPeriodoAtual(planejador.getTotalDePeriodos());
		planejador.removeDisciplinaPeriodo("86", planejador.getTotalDePeriodos());
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("86"));
		
		planejador.removeDisciplinaPeriodo("87", planejador.getTotalDePeriodos());
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("87"));

		try {
			planejador.removeDisciplinaPeriodo("88", planejador.getTotalDePeriodos());
			Assert.fail("Deveria ter lançado excecao.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals("O número mínimo de créditos neste período é 14.", e.getMessage());
		}

	}

	@Test
	public void naoDeveRetirarDisciplinaSePreRequisitoFoiRetiradoEConsomeMinimoDosOutros()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{
		
		planejador.setPeriodoAtual(2);
		try{
			planejador.removeDisciplinaPeriodo("01", 1); // removendo calculo 1
			Assert.fail("Deveria ter pego exception.");
		}
		catch(TotalDeCreditosInvalidoException e){
			//Devia mudar essa mensagem de erro, n?
			Assert.assertEquals(e.getMessage(), "Removendo Cálculo Diferencial e Integral 1 fará o 4º periodo ficar com menos que o mínimo de créditos.");
		}
		
	}

	@Test
	public void deveRetirarDisciplinaSePreRequisitoFoiRetirado()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{
		
		planejador.setPeriodoAtual(3);
		Assert.assertEquals(7, planejador.getPeriodo(3).getTotalDeDisciplinas());
		planejador.removeDisciplinaPeriodo("20", 3); // removendo gi
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("27")); // si1 foi removido tambem
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("33")); // si2 foi removido tambem
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("32")); // bd1 foi removido tambem
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("39")); // bd2 foi removido tambem
	}

	@Test
	public void deveIndicarSeDisciplinaEhPreRequisitoDeOutraAlocada()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertTrue(planejador.ehPreRequisito(
				planejador.getDisciplina("10"), 2)); // prog 2 é pre requisito de outra(s) alocada(s) a frente
		Assert.assertFalse(planejador.ehPreRequisito(
				planejador.getDisciplina("09"), 2)); // Metodologia cientifica não é

	}

	@Test
	public void deveIndicarSeDisciplinaTemPreRequisitoNaoAlocado()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertFalse(planejador.temPreRequisitoNaoAlocado(planejador
				.getDisciplina("20"))); // Gerencia da informação nao tem pre-requisitos
		Assert.assertFalse(planejador.temPreRequisitoNaoAlocado(planejador
				.getDisciplina("14"))); // Algebra Linear tem pre-requisito que já está no periodo 1

		planejador.removeDisciplinaPeriodo("10", 2); // removendo prog 2 removemos também EDA

		Assert.assertTrue(planejador.temPreRequisitoNaoAlocado(planejador
				.getDisciplina("17"))); // EDA tem prog2 como pre-requisito que nao foi alocado

	}

	@Test
	public void devePoderInverterOrdemDosPeriodos() {

		Assert.assertEquals(1, planejador.getPeriodos().get(0).getNumero()); // periodo de numero 1 é o primeiro
		Assert.assertEquals(2, planejador.getPeriodos().get(1).getNumero()); // periodo de numero 2 é o segundo
		Assert.assertEquals(3, planejador.getPeriodos().get(2).getNumero()); // periodo de numero 3 é o terceiro e assim por diante
		Assert.assertEquals(4, planejador.getPeriodos().get(3).getNumero());
		Assert.assertEquals(5, planejador.getPeriodos().get(4).getNumero());
		Assert.assertEquals(6, planejador.getPeriodos().get(5).getNumero());
		Assert.assertEquals(7, planejador.getPeriodos().get(6).getNumero());
		Assert.assertEquals(8, planejador.getPeriodos().get(7).getNumero());

		planejador.inverteOrdemDosPeriodos();

		Assert.assertEquals(8, planejador.getPeriodos().get(0).getNumero()); // periodo de numero 8 é o primeiro
		Assert.assertEquals(7, planejador.getPeriodos().get(1).getNumero()); // periodo de numero 7 é o segundo
		Assert.assertEquals(6, planejador.getPeriodos().get(2).getNumero()); // periodo de numero 6 é o terceiro e assim por diante
		Assert.assertEquals(5, planejador.getPeriodos().get(3).getNumero());
		Assert.assertEquals(4, planejador.getPeriodos().get(4).getNumero());
		Assert.assertEquals(3, planejador.getPeriodos().get(5).getNumero());
		Assert.assertEquals(2, planejador.getPeriodos().get(6).getNumero());
		Assert.assertEquals(1, planejador.getPeriodos().get(7).getNumero());
	}

}
