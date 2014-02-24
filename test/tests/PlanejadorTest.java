package tests;

import java.util.ArrayList;
import java.util.List;

import models.AlocacaoInvalidaException;
import models.Disciplina;
import models.TotalDeCreditosInvalidoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Planejador;

public class PlanejadorTest {

	private Planejador planejador;
	private List<Disciplina> asDisciplinas;
	
	@Before
	public void setUp() throws Exception {
		
		planejador = new Planejador();
		
		asDisciplinas = new ArrayList<Disciplina>();
		asDisciplinas.add(planejador.getDisciplina("01"));
		asDisciplinas.add(planejador.getDisciplina("02"));
		asDisciplinas.add(planejador.getDisciplina("03"));
		asDisciplinas.add(planejador.getDisciplina("04"));
		asDisciplinas.add(planejador.getDisciplina("05"));
		asDisciplinas.add(planejador.getDisciplina("06"));
		
	}

	@Test
	public void deveIniciarComAsDisciplinasDoPrimeiroPeriodo() {
				
		Assert.assertEquals(6, planejador.getPeriodo(1).getTotalDeDisciplinas());
		Assert.assertTrue(planejador.getPeriodo(1).getDisciplinas().containsAll(asDisciplinas));    // verificando as disciplinas do 1º período
	}
	
	@Test
	public void deveCalcularTotalDeCreditos(){
				
		Assert.assertEquals(24, planejador.getPeriodo(1).getTotalDeCreditos());
	}
	
	@Test
	public void devePoderAdicionarDisciplinasSeTiverCursadoOsPreRequisitos() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		planejador.createPeriodo();
		
		planejador.addDisciplinaPeriodo("07", 2);   // Disciplina que foi cumprido os pre-requisitos adiciona ok
		
		try{
			planejador.addDisciplinaPeriodo("16", 2);  // Disciplina que não foi cumprido os pre-requisitos não adiciona
			Assert.fail("Deveria ter lançado exceção");
		}
		catch(AlocacaoInvalidaException e){
			Assert.assertEquals(e.getMessage(), "Esta disciplina tem pré-requisitos não concluídos.");
		}
	}
	
	@Test
	public void naoDevePermitirCriarOutroPeriodoSemMinimoDeCreditos() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		planejador.createPeriodo();
		
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);   // apenas duas disciplinas, total de créditos 8
		
		try {
			planejador.createPeriodo();    // não permite criar outro período
			Assert.fail("Deveria ter lancado excecao minimo de creditos invalido");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals(e.getMessage(), "O último período precisa de no mínimo 14 créditos.");
		}
		
	}
	
	@Test
	public void naoDevePermitirAdicionarNoPeriodoMaisDisciplinasApos28Creditos() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		planejador.createPeriodo();
		
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);
		planejador.addDisciplinaPeriodo("09", 2);
		planejador.addDisciplinaPeriodo("10", 2);
		planejador.addDisciplinaPeriodo("11", 2);
		planejador.addDisciplinaPeriodo("12", 2);
		planejador.addDisciplinaPeriodo("13", 2);  // total de créditos perto de 28
		
		try {
			planejador.addDisciplinaPeriodo("20", 2); // não permite mais adicionar outra disciplina
			Assert.fail("Deveria ter lançado exceção2");
		} catch (TotalDeCreditosInvalidoException e){
			Assert.assertNotNull(e);
		}
	}
	
	@Test
	public void devePoderRemoverDisciplinas() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
		// 2o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);
		planejador.addDisciplinaPeriodo("09", 2);
		planejador.addDisciplinaPeriodo("10", 2);
		planejador.addDisciplinaPeriodo("11", 2);
		planejador.addDisciplinaPeriodo("12", 2);
		planejador.addDisciplinaPeriodo("13", 2);
		
		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());
		planejador.removeDisciplinaPeriodo("07", 2);
		Assert.assertEquals(6, planejador.getPeriodo(2).getTotalDeDisciplinas());
	}
	
	@Test
	public void naoDevePermitirRemoverDisciplinasDoPrimeiroPeriodo() {
		try {
			planejador.removeDisciplinaPeriodo("01", 1);
			Assert.fail("Deveria ter lancado excecao, nao pode remover disciplina do prim periodo.");
		} catch (AlocacaoInvalidaException e) {
			Assert.assertEquals(e.getMessage(), "Disciplinas do primeiro período são obrigatórias.");
		}
	}
	
	@Test
	public void deveRetirarDisciplinaSePreRequisitoFoiRetirado() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{

		// 2o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);
		planejador.addDisciplinaPeriodo("09", 2);
		planejador.addDisciplinaPeriodo("10", 2);
		planejador.addDisciplinaPeriodo("11", 2);
		planejador.addDisciplinaPeriodo("12", 2);
		planejador.addDisciplinaPeriodo("13", 2);
		
		// 3o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("14", 3);
		planejador.addDisciplinaPeriodo("15", 3);
		planejador.addDisciplinaPeriodo("16", 3);
		planejador.addDisciplinaPeriodo("17", 3);
		planejador.addDisciplinaPeriodo("18", 3);
		planejador.addDisciplinaPeriodo("19", 3);
		planejador.addDisciplinaPeriodo("20", 3);
		
		// 4o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("21", 4);
		planejador.addDisciplinaPeriodo("22", 4);
		planejador.addDisciplinaPeriodo("23", 4);
		planejador.addDisciplinaPeriodo("24", 4);
		planejador.addDisciplinaPeriodo("25", 4);
		planejador.addDisciplinaPeriodo("26", 4);
		planejador.addDisciplinaPeriodo("27", 4);
		
		Assert.assertEquals(7, planejador.getPeriodo(3).getTotalDeDisciplinas());
		Assert.assertEquals(7, planejador.getPeriodo(4).getTotalDeDisciplinas());  // terceiro e quarto periodos com 7 disciplinas
		
		planejador.removeDisciplinaPeriodo("10", 2); // retirada disciplina que é pre-requisitos de outras a frente
		
		Assert.assertEquals(5, planejador.getPeriodo(3).getTotalDeDisciplinas());  // terceiro periodo com 5 disciplinas
		Assert.assertEquals(4, planejador.getPeriodo(4).getTotalDeDisciplinas());  // quarto periodo com 4 disciplinas
	}
	
	@Test
	public void devePoderDeletarUmPeriodo() throws TotalDeCreditosInvalidoException, AlocacaoInvalidaException {
		
		// 2o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);
		planejador.addDisciplinaPeriodo("09", 2);
		planejador.addDisciplinaPeriodo("10", 2);
		planejador.addDisciplinaPeriodo("11", 2);
		planejador.addDisciplinaPeriodo("12", 2);
		planejador.addDisciplinaPeriodo("13", 2);
		
		// 3o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("14", 3);
		planejador.addDisciplinaPeriodo("15", 3);
		planejador.addDisciplinaPeriodo("16", 3);
		planejador.addDisciplinaPeriodo("17", 3);
		planejador.addDisciplinaPeriodo("18", 3);
		planejador.addDisciplinaPeriodo("19", 3);
		planejador.addDisciplinaPeriodo("20", 3);
		
		Assert.assertEquals(2, planejador.getPeriodo(2).getNumero()); // Periodo de numero 2 com 7 disciplinas.
		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());
		
		Assert.assertEquals(3, planejador.getPeriodo(3).getNumero()); // Periodo de numero 3 com 7 disciplinas.
		Assert.assertEquals(7, planejador.getPeriodo(2).getTotalDeDisciplinas());
		
		planejador.deletarPeriodo(2);
		
		// Periodo 3 passou a ser 2 com disciplinas cujos pre-requisitos nao foram deletados
		Assert.assertEquals(2, planejador.getPeriodo(2).getNumero());
		Assert.assertEquals(2, planejador.getPeriodo(2).getTotalDeDisciplinas());
		
	}
	
	@Test
	public void deveIndicarSeDisciplinaEhPreRequisitoDeOutraAlocada() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		// 2o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);
		planejador.addDisciplinaPeriodo("09", 2);
		planejador.addDisciplinaPeriodo("10", 2);
		planejador.addDisciplinaPeriodo("11", 2);
		planejador.addDisciplinaPeriodo("12", 2);
		planejador.addDisciplinaPeriodo("13", 2);
		
		// 3o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("14", 3);
		planejador.addDisciplinaPeriodo("15", 3);
		planejador.addDisciplinaPeriodo("16", 3);
		planejador.addDisciplinaPeriodo("17", 3);
		planejador.addDisciplinaPeriodo("18", 3);
		planejador.addDisciplinaPeriodo("19", 3);
		planejador.addDisciplinaPeriodo("20", 3);
		
		Assert.assertTrue(planejador.ehPreRequisito(planejador.getDisciplina("10"), 2));
		Assert.assertFalse(planejador.ehPreRequisito(planejador.getDisciplina("09"), 2));
	}
	
	@Test
	public void deveIndicarSeDisciplinaTemPreRequisitoNaoAlocado() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		// 2o. periodo
		planejador.createPeriodo();
		planejador.addDisciplinaPeriodo("07", 2);
		planejador.addDisciplinaPeriodo("08", 2);
		planejador.addDisciplinaPeriodo("09", 2);
		planejador.addDisciplinaPeriodo("11", 2);
		planejador.addDisciplinaPeriodo("12", 2);
		planejador.addDisciplinaPeriodo("13", 2); //segundo periodo sem Programação 2
		
		Assert.assertFalse(planejador.temPreRequisito(planejador.getDisciplina("20"))); //Gerencia da informação nao tem pre-requisitos
		Assert.assertFalse(planejador.temPreRequisito(planejador.getDisciplina("14"))); //Algebra Linear tem pre-requisito que já está no periodo 1
		Assert.assertFalse(planejador.ehPreRequisito(planejador.getDisciplina("10"), 2)); //EDA tem prog2 como pre-requisito que nao foi alocado
	}

}
