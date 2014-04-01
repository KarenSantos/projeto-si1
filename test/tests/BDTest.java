package tests;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.List;

import models.Disciplina;
import models.Grade;
import models.GradeAntiga;
import models.Periodo;
import models.PlanoDeCurso;
import models.TotalDeCreditosInvalidoException;
import models.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BDTest {

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void deveConseguirRecuperarDisciplinasDoBD() {

		List<Disciplina> resultado = Disciplina.find.all();
		Assert.assertTrue(resultado.isEmpty());

		Disciplina umaDisciplina = new Disciplina("SI1", "SI1", 4, 3);
		umaDisciplina.save();
		resultado = Disciplina.find.all();
		Assert.assertEquals(1, resultado.size());
	}

	@Test
	public void deveConseguirRecuperarGradeDoBD() throws TotalDeCreditosInvalidoException {

		Grade grade = new GradeAntiga();
		grade.configuraGrade("id");
		grade.save();

		Assert.assertFalse(Grade.find.all().isEmpty());
		Assert.assertTrue(!grade.getDisciplinas().isEmpty());
		Assert.assertEquals(82, grade.getTotalDeDisciplinas());
		Assert.assertFalse(Disciplina.find.all().isEmpty());
	}

	@Test
	public void deveConseguirRecuperarPeriodosDoBD() {
		Periodo umPeriodo = new Periodo("id", 1);
		umPeriodo.save();
		Assert.assertTrue(!Periodo.find.all().isEmpty());
		Assert.assertNotNull(Periodo.find.byId("id"));
	}
	
	@Test
	public void deveConseguirRecuperarUsuariosDoBD() {
		Usuario usuario = new Usuario("email@email.com", "meuNome", "senha");
		usuario.save();
		Assert.assertTrue(!Usuario.find.all().isEmpty());
		Assert.assertEquals("meuNome", Usuario.find.byId("email@email.com").getNome());
	}
	
	@Test
	public void deveConseguirRecuperarPlanoDeCursoDoBD() {
		Grade grade = new GradeAntiga();
		grade.configuraGrade("grade antiga");
		grade.save();
		
		Usuario usuario = new Usuario("email2@email.com", "meuNome", "senha");
		usuario.save();
		
		PlanoDeCurso plano = new PlanoDeCurso("id", grade);
		plano.save();
		
		Assert.assertTrue(!PlanoDeCurso.find.all().isEmpty());
		Assert.assertNotNull(PlanoDeCurso.find.byId("id"));
		Assert.assertNotNull(PlanoDeCurso.find.byId("id").getPeriodos());
		
		//Disciplinas, grade e periodos foram criados ao criar um plano.
		Assert.assertFalse(Disciplina.find.all().isEmpty());
		Assert.assertFalse(Grade.find.all().isEmpty());
		Assert.assertFalse(Periodo.find.all().isEmpty());
	}
	
	
}