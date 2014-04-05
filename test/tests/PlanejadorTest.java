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

	private Grade gradeAntiga;
	private Grade gradeComum;
	private Grade gradeNova;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private PlanoDeCurso plano1;
	private PlanoDeCurso plano2;
	private PlanoDeCurso plano3;
	private Planejador planejador1;
	private Planejador planejador2;
	private Planejador planejador3;

	@Before
	public void setUp() throws Exception {
		start(fakeApplication(inMemoryDatabase()));
		
		gradeAntiga = new GradeAntiga();
		gradeAntiga.configuraGrade("grade antiga");
		gradeAntiga.save();
		
		gradeComum = new GradeComum();
		gradeComum.configuraGrade("grade comum");
		gradeComum.save();
		
		gradeNova = new GradeNova();
		gradeNova.configuraGrade("grade nova");
		gradeNova.save();
		
		usuario1 = new Usuario("email1@email.com", "meuNome", "senha");
		usuario1.save();
		
		usuario2 = new Usuario("email2@email.com", "meuNome2", "senha2");
		usuario2.save();
		
		usuario3 = new Usuario("email3@email.com", "meuNome3", "senha3");
		usuario3.save();
		
		plano1 = new PlanoDeCurso(usuario1.getIdDoPlano(), gradeAntiga);
		plano1.save();
		
		plano2 = new PlanoDeCurso(usuario2.getIdDoPlano(), gradeComum);
		plano2.save();
		
		plano3 = new PlanoDeCurso(usuario3.getIdDoPlano(), gradeNova);
		plano3.save();
		
		planejador1 = new Planejador(usuario1);
		planejador2 = new Planejador(usuario2);
		planejador3 = new Planejador(usuario3);
	}

	@Test
	public void deveIniciarComAlocacaoPadraoDaGradeDoPlano() {
		
		// grade antiga
		Assert.assertEquals(8, planejador1.getTotalDePeriodos()); // 8 periodos base
		Assert.assertEquals(208, planejador1.getMinimoDeCreditosDoCurso()); //208 minimo de creditos
		
		// grade comum
		Assert.assertEquals(9, planejador2.getTotalDePeriodos()); // 8 periodos base
		Assert.assertEquals(208, planejador2.getMinimoDeCreditosDoCurso()); //208 minimo de creditos
		
		// grade comum
		Assert.assertEquals(9, planejador3.getTotalDePeriodos()); // 9 periodos base
		Assert.assertEquals(196, planejador3.getMinimoDeCreditosDoCurso()); //196 minimo de creditos
	}
	
	@Test
	public void deveIniciarComPeriodoAtual1() {

		Assert.assertEquals(1, planejador1.getNumPeriodoAtual());
		Assert.assertEquals(1, planejador2.getNumPeriodoAtual());
		Assert.assertEquals(1, planejador3.getNumPeriodoAtual());
	}

	@Test
	public void deveCalcularTotalDeCreditosDosPeriodos() {
		Assert.assertEquals(24, planejador1.getPeriodo(1).getTotalDeCreditos());
		Assert.assertEquals(26, planejador1.getPeriodo(2).getTotalDeCreditos());
		Assert.assertEquals(28, planejador1.getPeriodo(3).getTotalDeCreditos());
		Assert.assertEquals(26, planejador1.getPeriodo(4).getTotalDeCreditos());
		Assert.assertEquals(24, planejador1.getPeriodo(5).getTotalDeCreditos());
		Assert.assertEquals(28, planejador1.getPeriodo(6).getTotalDeCreditos());
		Assert.assertEquals(28, planejador1.getPeriodo(7).getTotalDeCreditos());
		Assert.assertEquals(24, planejador1.getPeriodo(8).getTotalDeCreditos());
	}
	
	@Test
	public void deveCalcularTotalDeCreditosCursados() {
		
		planejador1.setPeriodoAtual(1);
		Assert.assertEquals(0, planejador1.getTotalDeCreditosCursados());		
		planejador1.setPeriodoAtual(2);
		Assert.assertEquals(24, planejador1.getTotalDeCreditosCursados());		
		planejador1.setPeriodoAtual(3);
		Assert.assertEquals(50, planejador1.getTotalDeCreditosCursados());		
		planejador1.setPeriodoAtual(4);
		Assert.assertEquals(78, planejador1.getTotalDeCreditosCursados());	
		planejador1.setPeriodoAtual(5);
		Assert.assertEquals(104, planejador1.getTotalDeCreditosCursados());		
		planejador1.setPeriodoAtual(6);
		Assert.assertEquals(128, planejador1.getTotalDeCreditosCursados());		
		planejador1.setPeriodoAtual(7);
		Assert.assertEquals(156, planejador1.getTotalDeCreditosCursados());
		planejador1.setPeriodoAtual(8);
		Assert.assertEquals(184, planejador1.getTotalDeCreditosCursados());
	}
	
	@Test
	public void deveRetornarDificuldadeDaDisciplina() {
		Assert.assertEquals(4, planejador1.getDisciplina("a01").getDificuldade());
		Assert.assertEquals(3, planejador1.getDisciplina("a02").getDificuldade());
		Assert.assertEquals(2, planejador1.getDisciplina("a03").getDificuldade());
		
		Assert.assertEquals(3, planejador1.getDisciplina("a10").getDificuldade());
		Assert.assertEquals(2, planejador1.getDisciplina("a20").getDificuldade());
		Assert.assertEquals(3, planejador1.getDisciplina("a30").getDificuldade());
	}
	
	@Test
	public void deveRetornarTotalDeDificuldadeDosPeriodos() {
		Assert.assertEquals(18, planejador1.getPeriodo(1).getTotalDeDificuldade());
		Assert.assertEquals(25, planejador1.getPeriodo(2).getTotalDeDificuldade());
		Assert.assertEquals(25, planejador1.getPeriodo(3).getTotalDeDificuldade());
		Assert.assertEquals(21, planejador1.getPeriodo(4).getTotalDeDificuldade());
		Assert.assertEquals(21, planejador1.getPeriodo(5).getTotalDeDificuldade());
		Assert.assertEquals(24, planejador1.getPeriodo(6).getTotalDeDificuldade());
		Assert.assertEquals(21, planejador1.getPeriodo(7).getTotalDeDificuldade());
		Assert.assertEquals(18, planejador1.getPeriodo(8).getTotalDeDificuldade());
	}

	@Test
	public void devePoderMudarPeriodoAtual() {

		planejador1.setPeriodoAtual(2);
		Assert.assertEquals(2, planejador1.getNumPeriodoAtual());
		
		//periodos anteriores soh tem maximo de creditos
		Assert.assertEquals(new TemMaximoDeCreditos(), planejador1.getPeriodo(1).getValidadorDeAlocacao());
		// do atual ao penultimo tem maximo e minimo
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador1.getPeriodo(2).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador1.getPeriodo(3).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador1.getPeriodo(7).getValidadorDeAlocacao());
		// ultimo periodo soh tem minimo de creditos
		Assert.assertEquals(new TemMinimoDeCreditos(), planejador1.getPeriodo(8).getValidadorDeAlocacao());
		
		planejador1.setPeriodoAtual(7);
		Assert.assertEquals(7, planejador1.getNumPeriodoAtual());
		
		planejador1.setPeriodoAtual(5);
		Assert.assertEquals(5, planejador1.getNumPeriodoAtual());
		
		planejador1.setPeriodoAtual(1);
		Assert.assertEquals(1, planejador1.getNumPeriodoAtual());
		
		planejador1.setPeriodoAtual(4);
		Assert.assertEquals(4, planejador1.getNumPeriodoAtual());
		
		//periodos anteriores soh tem maximo de creditos
		Assert.assertEquals(new TemMaximoDeCreditos(), planejador1.getPeriodo(1).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMaximoDeCreditos(), planejador1.getPeriodo(3).getValidadorDeAlocacao());
		// do atual ao penultimo tem maximo e minimo
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador1.getPeriodo(4).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador1.getPeriodo(6).getValidadorDeAlocacao());
		Assert.assertEquals(new TemMinimoEMaximoDeCreditos(), planejador1.getPeriodo(7).getValidadorDeAlocacao());
		// ultimo periodo soh tem minimo de creditos
		Assert.assertEquals(new TemMinimoDeCreditos(), planejador1.getPeriodo(8).getValidadorDeAlocacao());
		
		planejador1.setPeriodoAtual(8);
		Assert.assertEquals(8, planejador1.getNumPeriodoAtual());
		
		planejador1.setPeriodoAtual(3);
		Assert.assertEquals(3, planejador1.getNumPeriodoAtual());
		
		planejador1.setPeriodoAtual(6);
		Assert.assertEquals(6, planejador1.getNumPeriodoAtual());
	}

	@Test
	public void devePoderCriarNovosPeriodos(){
		Assert.assertEquals(8, planejador1.getTotalDePeriodos());
		
		try{
			planejador1.createPeriodo();
		} catch (Exception e){
			Assert.fail("Não deveria ter lançado exceção");
		}
		
		Assert.assertEquals(9, planejador1.getTotalDePeriodos());
	}
	
	@Test
	public void naoDevePoderCriarNovoPeriodoSeOAnteriorNaoTiverMinimoDeCreditos(){
		
		Assert.assertEquals(8, planejador1.getTotalDePeriodos());
		
		try{
			planejador1.createPeriodo();
		} catch (Exception e){
			Assert.fail("Não deveria ter lançado exceção");
		}
		
		Assert.assertEquals(9, planejador1.getTotalDePeriodos());
		Assert.assertEquals(0, planejador1.getPeriodo(9).getTotalDeCreditos());
		
		try{
			planejador1.createPeriodo();
			Assert.fail("Deveria ter lançado exceção");
		} catch (Exception e){
			Assert.assertEquals("Numero de creditos do ultimo periodo impede criaçao de um novo.", e.getMessage());
		}
	}
	
	@Test
	public void naoDevePoderCriarNovoPeriodoSeUltimoTemMaisQueMaximoDeCreditos(){
		
		try {
			planejador1.addDisciplinaPeriodo("a201", planejador1.getTotalDePeriodos());
			planejador1.addDisciplinaPeriodo("a203", planejador1.getTotalDePeriodos());
			Assert.assertEquals(32, planejador1.getPeriodo(8).getTotalDeCreditos());
			
			planejador1.createPeriodo();
			
		} catch (AlocacaoInvalidaException e) {
			Assert.assertEquals(e.getMessage(), "Numero de creditos do ultimo periodo impede criaçao de um novo.");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.fail("Nao deveria ter lançado excessao");
		} 
	}
	
	@Test
	public void devePoderInverterOrdemDosPeriodos() {

		Assert.assertEquals(1, planejador1.getPeriodos().get(0).getNumero()); // periodo de numero 1 é o primeiro
		Assert.assertEquals(2, planejador1.getPeriodos().get(1).getNumero()); // periodo de numero 2 é o segundo
		Assert.assertEquals(3, planejador1.getPeriodos().get(2).getNumero()); // periodo de numero 3 é o terceiro e assim por diante
		Assert.assertEquals(4, planejador1.getPeriodos().get(3).getNumero());
		Assert.assertEquals(5, planejador1.getPeriodos().get(4).getNumero());
		Assert.assertEquals(6, planejador1.getPeriodos().get(5).getNumero());
		Assert.assertEquals(7, planejador1.getPeriodos().get(6).getNumero());
		Assert.assertEquals(8, planejador1.getPeriodos().get(7).getNumero());

		planejador1.inverteOrdemDosPeriodos();

		Assert.assertEquals(8, planejador1.getPeriodos().get(0).getNumero()); // periodo de numero 8 é o primeiro
		Assert.assertEquals(7, planejador1.getPeriodos().get(1).getNumero()); // periodo de numero 7 é o segundo
		Assert.assertEquals(6, planejador1.getPeriodos().get(2).getNumero()); // periodo de numero 6 é o terceiro e assim por diante
		Assert.assertEquals(5, planejador1.getPeriodos().get(3).getNumero());
		Assert.assertEquals(4, planejador1.getPeriodos().get(4).getNumero());
		Assert.assertEquals(3, planejador1.getPeriodos().get(5).getNumero());
		Assert.assertEquals(2, planejador1.getPeriodos().get(6).getNumero());
		Assert.assertEquals(1, planejador1.getPeriodos().get(7).getNumero());
	}
	
	@Test
	public void deveIndicarSeEhDisciplinaOptativaTECC(){
		
		Assert.assertTrue(planejador1.ehOptativaTECC(planejador1.getDisciplina("a104"))); //Arquitetura de software
		Assert.assertTrue(planejador1.ehOptativaTECC(planejador1.getDisciplina("a108"))); //Economia de TI
		
		Assert.assertFalse(planejador1.ehOptativaTECC(planejador1.getDisciplina("a01"))); //Calculo 1
		Assert.assertFalse(planejador1.ehOptativaTECC(planejador1.getDisciplina("a30"))); //Compiladores
		
		Assert.assertFalse(planejador1.ehOptativaTECC(planejador1.getDisciplina("a200"))); //Futsal
		
	}

	@Test
	public void deveIndicarSeDisciplinaEhPreRequisitoDeOutraAlocadaAFrente()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertTrue(planejador1.ehPreRequisito(
				planejador1.getDisciplina("a01"), 1)); // Calc1 eh pre requisito de outra disciplina a frente
		Assert.assertTrue(planejador1.ehPreRequisito(
				planejador1.getDisciplina("a10"), 2)); // prog 2 é pre requisito de outra(s) alocada(s) a frente
		Assert.assertFalse(planejador1.ehPreRequisito(
				planejador1.getDisciplina("a09"), 2)); // Metodologia cientifica não é
		Assert.assertFalse(planejador1.ehPreRequisito(planejador1.getDisciplina("a28"), 5));

	}

	@Test
	public void deveIndicarSeDisciplinaTemPreRequisitoNaoAlocado()
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertFalse(planejador1.temPreRequisitoNaoAlocado(planejador1
				.getDisciplina("a20"))); // Gerencia da informação nao tem pre-requisitos
		Assert.assertFalse(planejador1.temPreRequisitoNaoAlocado(planejador1
				.getDisciplina("a14"))); // Algebra Linear tem pre-requisito que já está no periodo 1

		planejador1.removeDisciplinaPeriodo("a10", 2); // removendo prog 2 removemos também EDA

		Assert.assertTrue(planejador1.temPreRequisitoNaoAlocado(planejador1
				.getDisciplina("a17"))); // EDA tem prog2 como pre-requisito que nao foi alocado

	}

	@Test
	public void deveVerificarSePreRequisitosEstaoAlocadosAnteriormente()
			throws TotalDeCreditosInvalidoException, AlocacaoInvalidaException {

		planejador1.setPeriodoAtual(2);
		planejador1.removeDisciplinaPeriodo("a09", 2); // liberando espaço no segundo periodo

		planejador1.moveDisciplina("a01", 2, 1); // movendo calculo 1 para o segundo periodo
		
		// quem tem calculo 1 como pre-requisito nao tem mais os pre-requisitos em periodos anteriores
		// fica vermelha na interface
		Assert.assertFalse(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a07"), 2)); 
		Assert.assertFalse(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a13"), 2));
		
		planejador1.moveDisciplina("a01", 1, 2); // movendo de volta para o lugar certo
		
		Assert.assertTrue(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a07"), 2)); 
		Assert.assertTrue(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a13"), 2));

		planejador1.moveDisciplina("a17", 1, 3); // movendo EDA para o primeiro periodo
		
		// EDA nao tem seus preRequisitos satisfeitos
		// fica vermelha na interface
		Assert.assertFalse(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a17"), 1));

		planejador1.moveDisciplina("a17", 5, 1); // movendo EDA para o quinto periodo
		
		// EDA fica ok
		Assert.assertTrue(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a17"), 5)); 
		
		// aquelas que tem EDA como pre-requisito nao tem pre-requisitos satisfeitos
		// ficam vermelhas na interface
		Assert.assertFalse(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a22"), 4));
		Assert.assertFalse(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a24"), 4));
		Assert.assertFalse(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a25"), 4));

		planejador1.moveDisciplina("a17", 3, 5); // voltando EDA para o periodo correto
		
		// aquelas que tem EDA como pre-requisito tem seus pre-requisitos satisfeitos
		Assert.assertTrue(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a22"), 4));
		Assert.assertTrue(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a24"), 4));
		Assert.assertTrue(planejador1.temPreRequisitosEmPeriodosAnteriores(planejador1.getDisciplina("a25"), 4));
	}
	
	@Test
	public void devePoderCriarPlanosDeOutrosUsuariosComAMesmaGrade() {
		
		Usuario usuario11 = new Usuario("email11@email.com", "meuNome1", "senha1");
		usuario11.save();
		
		Usuario usuario22 = new Usuario("email22@email.com", "meuNome22", "senha22");
		usuario22.save();
		
		Usuario usuario33 = new Usuario("email33@email.com", "meuNome33", "senha33");
		usuario33.save();
		
		// Planos de usuarios diferentes com as mesmas grades ja criadas
		PlanoDeCurso plano11 = new PlanoDeCurso(usuario11.getIdDoPlano(), gradeAntiga);
		plano11.save();
		Assert.assertNotNull(PlanoDeCurso.find.byId(usuario11.getIdDoPlano()));
		
		PlanoDeCurso plano22 = new PlanoDeCurso(usuario22.getIdDoPlano(), gradeComum);
		plano22.save();
		
		PlanoDeCurso plano33 = new PlanoDeCurso(usuario33.getIdDoPlano(), gradeNova);
		plano33.save();
		
		//TODO O ERRO ESTA  AQUI
		Planejador planejador11 = new Planejador(usuario11);
		Planejador planejador22 = new Planejador(usuario22);
		Planejador planejador33 = new Planejador(usuario33);
		
		Assert.assertEquals(8, planejador11.getTotalDePeriodos()); // 8 periodos base
		Assert.assertEquals(208, planejador11.getMinimoDeCreditosDoCurso()); //208 minimo de creditos
		
		Assert.assertEquals(9, planejador22.getTotalDePeriodos()); // 8 periodos base
		Assert.assertEquals(208, planejador22.getMinimoDeCreditosDoCurso()); //208 minimo de creditos
		
		Assert.assertEquals(9, planejador33.getTotalDePeriodos()); // 9 periodos base
		Assert.assertEquals(196, planejador33.getMinimoDeCreditosDoCurso()); //196 minimo de creditos
		
	}
}
