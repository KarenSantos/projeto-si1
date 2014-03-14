package tests;

import static play.test.Helpers.*;

import java.util.List;

import models.Disciplina;
import models.Usuario;

import org.junit.*;

import controllers.Planejador;

public class DisciplinaBDTest {
	
	@Before
	public void setUp(){
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
	 public void deveConseguirRecuperarAsDisciplinasDoPlanoDoBD() {
		 
		 Usuario user = new Usuario("email", "nome", "password");
		 
		 Assert.assertTrue(Disciplina.find.all().isEmpty());
		 
	 }

}