package tests;

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
	}
	
	@Test
	public void deveCalcularTotalDeCreditos(){
				
		Assert.assertEquals(24, planejador.getPeriodo(1).getTotalDeCreditos());
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
		planejador.moveDisciplina("01", 2, 1);
		Assert.assertFalse(planejador.getDisciplina("01").isAlocadaCorretamente());
		planejador.moveDisciplina("01", 1, 2);
		Assert.assertTrue(planejador.getDisciplina("01").isAlocadaCorretamente());
		
		planejador.moveDisciplina("17", 1, 3);
		Assert.assertFalse(planejador.getDisciplina("10").isAlocadaCorretamente());
		Assert.assertFalse(planejador.getDisciplina("11").isAlocadaCorretamente());
		Assert.assertFalse(planejador.getDisciplina("12").isAlocadaCorretamente());
		
		planejador.moveDisciplina("17", 5, 1);
		Assert.assertFalse(planejador.getDisciplina("17").isAlocadaCorretamente());
		Assert.assertTrue(planejador.getDisciplina("10").isAlocadaCorretamente());
		Assert.assertTrue(planejador.getDisciplina("11").isAlocadaCorretamente());
		Assert.assertTrue(planejador.getDisciplina("12").isAlocadaCorretamente());
		
		planejador.moveDisciplina("17", 3, 5);
		Assert.assertTrue(planejador.getDisciplina("17").isAlocadaCorretamente());
	}
	
	@Test
	public void devePoderRemoverDisciplinas() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		
	}
	
	@Test
	public void deveRetirarDisciplinaSePreRequisitoFoiRetirado() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException{

	}
	
	@Test
	public void devePoderDeletarUmPeriodo() throws TotalDeCreditosInvalidoException, AlocacaoInvalidaException {
			
	}
	
	@Test
	public void deveIndicarSeDisciplinaEhPreRequisitoDeOutraAlocada() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

	}
	
	@Test
	public void deveIndicarSeDisciplinaTemPreRequisitoNaoAlocado() throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

	}

}
