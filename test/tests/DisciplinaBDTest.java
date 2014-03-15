package tests;

import controllers.*;
import static play.test.Helpers.*;

import java.util.List;

import models.Disciplina;
import models.Grade;
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
	public void deveConseguirRecuperarAsDisciplinasDoPlanoDoBD() {
		PlanoDeCurso plano = new PlanoDeCurso("asd", "asd", "asd");
		plano.save();
		Assert.assertFalse(Disciplina.find.all().isEmpty());

	}

}