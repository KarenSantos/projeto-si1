import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;
import models.CurriculoAntigoFactory;
import models.Grade;
import models.PlanoDeCurso;
import models.Usuario;

import org.junit.Before;
import org.junit.Test;

import play.mvc.*;
import controllers.Autenticador;
import controllers.Planejador;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		start(fakeApplication(inMemoryDatabase()));
		
		Grade grade = new Grade();
		grade.configuraGrade("Computacao grade antiga", new CurriculoAntigoFactory());
		grade.save();
		
		usuario = new Usuario("email@email.com", "meuNome", "senha");
		usuario.save();
		
		PlanoDeCurso plano = new PlanoDeCurso("p_" + usuario.getEmail(), grade);
		plano.save();
		
	}

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render(usuario);
//        assertThat(contentType(html)).isEqualTo("text/html");
//        assertThat(contentAsString(html)).contains("Planejamento de Curso");
    }
    
    @Test
    public void autenticadorTest(){
    	Autenticador.login();
    	Autenticador.efetuaCadastro();
    }


}
