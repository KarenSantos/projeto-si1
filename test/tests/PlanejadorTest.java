package tests;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import models.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Planejador;

public class PlanejadorTest {

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
	public void deveIniciarComAlocacaoPadraoDaGradeDoPlano() {
		
		Assert.assertFalse(gradeAntiga.getPeriodos().isEmpty()); // a grade tem periodos
		Assert.assertFalse(plano.getPeriodos().isEmpty()); // o plano tem periodos
		
		Assert.assertFalse(gradeAntiga.getPeriodo(1).getDisciplinas().isEmpty()); // os periodos da grade tem disciplinas
		Assert.assertFalse(plano.getPeriodo(1).getDisciplinas().isEmpty()); // os periodos do plano tem disciplinas
		Assert.assertFalse(Periodo.find.all().get(0).getDisciplinas().isEmpty()); // o periodo do banco de dados tem disciplinas
		
		Assert.assertFalse(gradeAntiga.getDisciplinas().isEmpty()); // a grade tem disciplinas
		Assert.assertFalse(plano.getDisciplinas().isEmpty()); // o plano tem disciplinas
		Assert.assertFalse(Disciplina.find.all().isEmpty()); // o BD tem disciplinas
		
		Assert.assertNotNull(PlanoDeCurso.find.byId("p_email@email.com"));
		
		Assert.assertEquals(8, planejador.getTotalDePeriodos());
		
		Assert.assertFalse(planejador.getDisciplinas().isEmpty());
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
	public void deveRetornarDificuldadeDaDisciplina() {
		Assert.assertEquals(4, planejador.getDisciplina("a01").getDificuldade());
		Assert.assertEquals(3, planejador.getDisciplina("a02").getDificuldade());
		Assert.assertEquals(2, planejador.getDisciplina("a03").getDificuldade());
		
		Assert.assertEquals(3, planejador.getDisciplina("a10").getDificuldade());
		Assert.assertEquals(2, planejador.getDisciplina("a20").getDificuldade());
		Assert.assertEquals(3, planejador.getDisciplina("a30").getDificuldade());
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

	@Test
	public void deveVerificarSePreRequisitosEstaoAlocadosAnteriormente()
			throws TotalDeCreditosInvalidoException, AlocacaoInvalidaException {

		planejador.setPeriodoAtual(2);
		planejador.removeDisciplinaPeriodo("a09", 2); // liberando espaço no segundo periodo

		planejador.moveDisciplina("a01", 2, 1); // movendo calculo 1 para o segundo periodo
		
		// quem tem calculo 1 como pre-requisito nao tem mais os pre-requisitos em periodos anteriores
		// fica vermelha na interface
		Assert.assertFalse(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a07"), 2)); 
		Assert.assertFalse(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a13"), 2));
		
		planejador.moveDisciplina("a01", 1, 2); // movendo de volta para o lugar certo
		
		Assert.assertTrue(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a07"), 2)); 
		Assert.assertTrue(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a13"), 2));

		planejador.moveDisciplina("a17", 1, 3); // movendo EDA para o primeiro periodo
		
		// EDA nao tem seus preRequisitos satisfeitos
		// fica vermelha na interface
		Assert.assertFalse(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a17"), 1));

		planejador.moveDisciplina("a17", 5, 1); // movendo EDA para o quinto periodo
		
		// EDA fica ok
		Assert.assertTrue(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a17"), 5)); 
		
		// aquelas que tem EDA como pre-requisito nao tem pre-requisitos satisfeitos
		// ficam vermelhas na interface
		Assert.assertFalse(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a22"), 4));
		Assert.assertFalse(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a24"), 4));
		Assert.assertFalse(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a25"), 4));

		planejador.moveDisciplina("a17", 3, 5); // voltando EDA para o periodo correto
		
		// aquelas que tem EDA como pre-requisito tem seus pre-requisitos satisfeitos
		Assert.assertTrue(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a22"), 4));
		Assert.assertTrue(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a24"), 4));
		Assert.assertTrue(planejador.temPreRequisitosEmPeriodosAnteriores(planejador.getDisciplina("a25"), 4));
	}

	@Test
	public void deveIniciarComPeriodoAtual1() {

		Assert.assertEquals(1, planejador.getNumPeriodoAtual());
	}

	@Test
	public void devePoderMudarPeriodoAtual() {

		planejador.setPeriodoAtual(2);
		Assert.assertEquals(2, planejador.getNumPeriodoAtual());
		
		//periodos anteriores soh tem maximo de creditos
		Assert.assertEquals(new TemMaximoDeCreditos(), planejador.getPeriodo(1).getValidadorDeAlocacao());
		// do atual ao penultimo tem maximo e minimo
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador.getPeriodo(2).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador.getPeriodo(3).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador.getPeriodo(7).getValidadorDeAlocacao());
		// ultimo periodo soh tem minimo de creditos
		Assert.assertEquals(new TemMinimoDeCreditos(), planejador.getPeriodo(8).getValidadorDeAlocacao());
		
		planejador.setPeriodoAtual(7);
		Assert.assertEquals(7, planejador.getNumPeriodoAtual());
		
		planejador.setPeriodoAtual(5);
		Assert.assertEquals(5, planejador.getNumPeriodoAtual());
		
		planejador.setPeriodoAtual(1);
		Assert.assertEquals(1, planejador.getNumPeriodoAtual());
		
		planejador.setPeriodoAtual(4);
		Assert.assertEquals(4, planejador.getNumPeriodoAtual());
		
		//periodos anteriores soh tem maximo de creditos
		Assert.assertEquals(new TemMaximoDeCreditos(), planejador.getPeriodo(1).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMaximoDeCreditos(), planejador.getPeriodo(3).getValidadorDeAlocacao());
		// do atual ao penultimo tem maximo e minimo
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador.getPeriodo(4).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador.getPeriodo(6).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador.getPeriodo(7).getValidadorDeAlocacao());
		// ultimo periodo soh tem minimo de creditos
		Assert.assertEquals(new TemMinimoDeCreditos(), planejador.getPeriodo(8).getValidadorDeAlocacao());
		
		planejador.setPeriodoAtual(8);
		Assert.assertEquals(8, planejador.getNumPeriodoAtual());
		
		planejador.setPeriodoAtual(3);
		Assert.assertEquals(3, planejador.getNumPeriodoAtual());
		
		planejador.setPeriodoAtual(6);
		Assert.assertEquals(6, planejador.getNumPeriodoAtual());
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
	public void devePoderCriarNovosPeriodos(){
		Assert.assertEquals(8, planejador.getTotalDePeriodos());
		
		try{
			planejador.createPeriodo();
		} catch (Exception e){
			Assert.fail("Não deveria ter lançado exceção");
		}
		
		Assert.assertEquals(9, planejador.getTotalDePeriodos());
	}
	
	@Test
	public void naoDevePoderCriarNovoPeriodoSeOAnteriorNaoTiverMinimoDeCreditos(){
		
		Assert.assertEquals(8, planejador.getTotalDePeriodos());
		
		try{
			planejador.createPeriodo();
		} catch (Exception e){
			Assert.fail("Não deveria ter lançado exceção");
		}
		
		Assert.assertEquals(9, planejador.getTotalDePeriodos());
		Assert.assertEquals(0, planejador.getPeriodo(9).getTotalDeCreditos());
		
		try{
			planejador.createPeriodo();
			Assert.fail("Deveria ter lançado exceção");
		} catch (Exception e){
			Assert.assertEquals("Numero de creditos do ultimo periodo impede criaçao de um novo.", e.getMessage());
		}
	}
	
	@Test
	public void naoDevePoderCriarNovoPeriodoSeUltimoTemMaisQueMaximoDeCreditos(){
		
		try {
			planejador.addDisciplinaPeriodo("a201", planejador.getTotalDePeriodos());
			planejador.addDisciplinaPeriodo("a203", planejador.getTotalDePeriodos());
			Assert.assertEquals(32, planejador.getPeriodo(8).getTotalDeCreditos());
			
			planejador.createPeriodo();
			
		} catch (AlocacaoInvalidaException e) {
			Assert.assertEquals(e.getMessage(), "Numero de creditos do ultimo periodo impede criaçao de um novo.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Nao deveria ter lançado excessao");
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

	@Test
	public void deveIndicarSeDisciplinaEhPreRequisitoDeOutraAlocadaAFrente()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertTrue(planejador.ehPreRequisito(
				planejador.getDisciplina("a01"), 1)); // Calc1 eh pre requisito de outra disciplina a frente
		Assert.assertTrue(planejador.ehPreRequisito(
				planejador.getDisciplina("a10"), 2)); // prog 2 é pre requisito de outra(s) alocada(s) a frente
		Assert.assertFalse(planejador.ehPreRequisito(
				planejador.getDisciplina("a09"), 2)); // Metodologia cientifica não é
		Assert.assertFalse(planejador.ehPreRequisito(planejador.getDisciplina("a28"), 5));

	}

	@Test
	public void deveIndicarSeDisciplinaTemPreRequisitoNaoAlocado()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertFalse(planejador.temPreRequisitoNaoAlocado(planejador
				.getDisciplina("a20"))); // Gerencia da informação nao tem pre-requisitos
		Assert.assertFalse(planejador.temPreRequisitoNaoAlocado(planejador
				.getDisciplina("a14"))); // Algebra Linear tem pre-requisito que já está no periodo 1

		planejador.removeDisciplinaPeriodo("a10", 2); // removendo prog 2 removemos também EDA

		Assert.assertTrue(planejador.temPreRequisitoNaoAlocado(planejador
				.getDisciplina("a17"))); // EDA tem prog2 como pre-requisito que nao foi alocado

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
