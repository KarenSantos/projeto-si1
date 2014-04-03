package tests;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.List;

import models.*;

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
	public void deveConseguirRecuperarGradesDoBD() throws TotalDeCreditosInvalidoException {

		Grade gradeAntiga = new GradeAntiga();
		gradeAntiga.configuraGrade("antiga");
		gradeAntiga.save();

		Assert.assertEquals(1, Grade.find.all().size());
		Assert.assertTrue(!gradeAntiga.getDisciplinas().isEmpty());
		Assert.assertEquals(101, gradeAntiga.getTotalDeDisciplinas());
		Assert.assertEquals(101, Disciplina.find.all().size());
		
		Grade gradeComum = new GradeComum();
		gradeComum.configuraGrade("comum");
		gradeComum.save();

		Assert.assertEquals(2, Grade.find.all().size());
		Assert.assertTrue(!gradeComum.getDisciplinas().isEmpty());
		Assert.assertEquals(101, gradeComum.getTotalDeDisciplinas());
		Assert.assertEquals(202, Disciplina.find.all().size());
		
		Grade gradeNova = new GradeNova();
		gradeNova.configuraGrade("nova");
		gradeNova.save();

		Assert.assertEquals(3, Grade.find.all().size());
		Assert.assertTrue(!gradeNova.getDisciplinas().isEmpty());
		Assert.assertEquals(99, gradeNova.getTotalDeDisciplinas());
		Assert.assertEquals(301, Disciplina.find.all().size());
		
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
	public void deveConseguirCriaPlanoComGradeDuasVezes() {
		Grade grade = new GradeAntiga();
		grade.configuraGrade("grade antiga");
		grade.save();
		
		Usuario usuario = new Usuario("email2@email.com", "meuNome", "senha");
		usuario.save();
		
		PlanoDeCurso plano = new PlanoDeCurso("id", grade);
		plano.save();
		
		Usuario usuario2 = new Usuario("email12@email.com", "meuNome", "senha");
		usuario.save();
		
		PlanoDeCurso plano2 = new PlanoDeCurso("id2", grade);
		plano.save();
		
		Assert.assertTrue(!PlanoDeCurso.find.all().isEmpty());
		Assert.assertNotNull(PlanoDeCurso.find.byId("id2"));
		Assert.assertNotNull(PlanoDeCurso.find.byId("id2").getPeriodos());
		
		//Disciplinas, grade e periodos foram criados ao criar um plano.
		Assert.assertFalse(Disciplina.find.all().isEmpty());
		Assert.assertFalse(Grade.find.all().isEmpty());
		Assert.assertFalse(Periodo.find.all().isEmpty());
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