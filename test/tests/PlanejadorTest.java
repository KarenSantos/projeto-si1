package tests;

import models.Disciplina;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Planejador;
import exceptions.AlocacaoInvalidaException;
import exceptions.TotalDeCreditosInvalidoException;

public class PlanejadorTest {

	private Planejador planejador;
	
	@Before
	public void setUp() throws Exception {
		
		planejador = new Planejador();
		
	}

	@Test
	public void deveIniciarComTodasAsDisciplinasAlocadas() {
		Assert.assertEquals(8, planejador.getTotalDePeriodos());
		
		for (Disciplina disc : planejador.getDisciplinasNaoAlocadas()) {
			Assert.assertTrue(disc.getPeriodoSugerido() < 0); //todas as disciplinas nao alocadas sao optativas
		}
	}
	
	@Test
	public void deveCalcularTotalDeCreditos(){
				
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
	public void naoDevePermitirAdicionarNoPeriodoMaisDisciplinasApos28Creditos() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		try {
			planejador.addDisciplinaPeriodo("20", 3); // o terceiro periodo jah tem 28 creditos
			Assert.fail("Deveria ter lançado exceção");
		} catch (TotalDeCreditosInvalidoException e){
			Assert.assertEquals(e.getMessage(), "O número máximo de créditos por período é 28.");
		}
	}
	
	@Test
	public void aoMoverDisciplinaDeveAtualizarSeuStatusDeAlocacao() {
		planejador.moveDisciplina("01", 2, 1); // movendo calculo 1 para o segundo periodo
		Assert.assertFalse(planejador.getDisciplina("01").isAlocadaCorretamente());
		planejador.moveDisciplina("01", 1, 2); // movendo de volta para o lugar certo
		Assert.assertTrue(planejador.getDisciplina("01").isAlocadaCorretamente());
		
		planejador.moveDisciplina("17", 1, 3); // movendo EDA para o primeiro periodo 
		Assert.assertFalse(planejador.getDisciplina("10").isAlocadaCorretamente());  // todos que são pre requisitos ficam alocados incorretamente
		Assert.assertFalse(planejador.getDisciplina("11").isAlocadaCorretamente());
		Assert.assertFalse(planejador.getDisciplina("12").isAlocadaCorretamente());
		
		planejador.moveDisciplina("17", 5, 1); //movendo EDA para o quinto periodo
		Assert.assertFalse(planejador.getDisciplina("17").isAlocadaCorretamente()); // ela fica a frente de quem ela é pre-requisito, nao alocada corretamente
		Assert.assertTrue(planejador.getDisciplina("10").isAlocadaCorretamente());
		Assert.assertTrue(planejador.getDisciplina("11").isAlocadaCorretamente());
		Assert.assertTrue(planejador.getDisciplina("12").isAlocadaCorretamente());
		
		planejador.moveDisciplina("17", 3, 5); //voltando EDA para o periodo correto
		Assert.assertTrue(planejador.getDisciplina("17").isAlocadaCorretamente()); //está alocada corretamente
	}
	
	@Test
	public void devePoderRemoverDisciplinas() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		planejador.removeDisciplinaPeriodo("40", 6); // removendo IA que nao é pre-requisito
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("40")); // a disciplina IA não está mais alocada
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(planejador.getDisciplina("40"))); 
		
		planejador.removeDisciplinaPeriodo("03", 1); // removendo LPT que não é pre-requisito
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("03")); // a disciplina LPT não está mais alocada
		Assert.assertTrue(planejador.getDisciplinasNaoAlocadas().contains(planejador.getDisciplina("03")));
		
	}
	
	@Test
	public void deveRetirarDisciplinaSePreRequisitoFoiRetirado() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{

		planejador.removeDisciplinaPeriodo("01", 1); // removendo calculo 1
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("07")); // calculo 2 foi removido também
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("15")); // probabilidade que depende de calculo 2 também foi removido
		Assert.assertEquals(0, planejador.getPeriodoDaDisciplina("21")); // metodos que depende de prob também foi removido e por ai vai...
	}
	
	@Test
	public void deveIndicarSeDisciplinaEhPreRequisitoDeOutraAlocada() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertTrue(planejador.ehPreRequisito(planejador.getDisciplina("10"), 2)); // prog 2 é pre requisito de outra(s) alocada(s) a frente
		Assert.assertFalse(planejador.ehPreRequisito(planejador.getDisciplina("09"), 2)); // Metodologia cientifica não é
		
	}
	
	@Test
	public void deveIndicarSeDisciplinaTemPreRequisitoNaoAlocado() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Assert.assertFalse(planejador.temPreRequisitoNaoAlocado(planejador.getDisciplina("20"))); //Gerencia da informação nao tem pre-requisitos
		Assert.assertFalse(planejador.temPreRequisitoNaoAlocado(planejador.getDisciplina("14"))); //Algebra Linear tem pre-requisito que já está no periodo 1
		
		planejador.removeDisciplinaPeriodo("10", 2); // removendo prog 2 removemos também EDA
				
		Assert.assertTrue(planejador.temPreRequisitoNaoAlocado(planejador.getDisciplina("17"))); //EDA tem prog2 como pre-requisito que nao foi alocado
		
	}

}
