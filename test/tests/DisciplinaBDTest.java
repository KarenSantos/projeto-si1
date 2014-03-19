package tests;

import controllers.*;
import static play.test.Helpers.*;

import java.util.List;

import models.Disciplina;
import models.Grade;
import models.Periodo;
import models.PlanoDeCurso;
import models.Usuario;

import org.junit.*;

import controllers.Planejador;

public class DisciplinaBDTest {

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void deveConseguirRecuperarDoBD() {

		List<Disciplina> resultado = Disciplina.find.all();
		Assert.assertTrue(resultado.isEmpty());

		Disciplina umaDisciplina = new Disciplina("SI1", "SI1", 4, 4, 1);
		umaDisciplina.save();
		resultado = Disciplina.find.all();
		Assert.assertEquals(1, resultado.size());
	}

	@Test
	public void deveCriarGradePopulada() {

		Grade grade = new Grade();
		Assert.assertTrue(!grade.getDisciplinas().isEmpty());
		Assert.assertEquals(82, grade.getTotalDeDisciplinas());
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
		Grade grade = new Grade();
		Usuario usuario = new Usuario("email2@email.com", "meuNome", "senha");
		usuario.save();
		
		PlanoDeCurso plano = new PlanoDeCurso("id", grade, usuario);
		plano.save();
		Assert.assertTrue(!PlanoDeCurso.find.all().isEmpty());
		Assert.assertNotNull(PlanoDeCurso.find.byId("id"));
		Assert.assertNotNull(PlanoDeCurso.find.byId("id").getPeriodos());
		
//		plano.reset();
	}
	
	@Test
	public void deveConseguir() {
		Grade grade = new Grade();
		Usuario usuario = new Usuario("email2@email.com", "meuNome", "senha");
		usuario.save();
		
		Planejador planejador = new Planejador(usuario);
		//PlanoDeCurso plano = new PlanoDeCurso("id", grade, usuario);
		//plano.save();
		Assert.assertTrue(!PlanoDeCurso.find.all().isEmpty());
		//Assert.assertNotNull(PlanoDeCurso.find.byId("id"));
		//Assert.assertNotNull(PlanoDeCurso.find.byId("id").getPeriodos());
		
//		plano.reset();
	}
}