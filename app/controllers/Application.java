package controllers;

//import models.AlocacaoInvalidaException;
//import models.TotalDeCreditosInvalidoException;
import models.AlocacaoInvalidaException;
import models.TotalDeCreditosInvalidoException;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.editar;

/**
 * Classe Application para a aplicacao web Planejamento de Curso.
 * @author 
 *
 */
public class Application extends Controller {
	
	private static Planejador planejador;
	
	@Security.Authenticated(Secured.class)
	public static Result index() {
		Usuario user = Usuario.find.byId(request().username());
		planejador = new Planejador(user);
		
		return ok(views.html.index.render(user));
	}

	@Security.Authenticated(Secured.class)
	public static Result plano() {
		planejador.deletaUltimoPeriodoSeVazio();
		return ok(views.html.plano.render(planejador.getPeriodos(), 
				planejador.getDisciplinasNaoAlocadas(), planejador));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result novoPeriodo() {
		try {
			planejador.createPeriodo();
		} catch (AlocacaoInvalidaException e) {
			return badRequest();
		}
		int ultimoPeriodo = planejador.getPeriodos().size();
		return redirect((routes.Application).editar(ultimoPeriodo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result editar(int periodo) {
		return ok(editar.render(planejador.getPeriodos(), 
				planejador.getDisciplinasNaoAlocadas(), periodo, planejador));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result adicionar(String disciplinaId, int periodo) {
		try {
			planejador.addDisciplinaPeriodo(disciplinaId, periodo);
		} catch (TotalDeCreditosInvalidoException e) {
			return ok(e.getMessage());
		} catch (AlocacaoInvalidaException e) {
			return ok(e.getMessage());
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result remover(String disciplinaId, int periodo) {
		try{
			planejador.removeDisciplinaPeriodo(disciplinaId, periodo);
		}catch(TotalDeCreditosInvalidoException e){
			return ok(e.getMessage());
		}
		return redirect((routes.Application).editar(periodo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result mover(String disciplinaId, int periodoFuturo, int periodoAtual) {
		try {
			planejador.moveDisciplina(disciplinaId, periodoFuturo, periodoAtual);
		} catch (TotalDeCreditosInvalidoException e) {
			return ok(e.getMessage());
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result inverter() {
		planejador.inverteOrdemDosPeriodos();
		return ok("invertido");
	}
	
	@Security.Authenticated(Secured.class)
	public static Result disciplinas(String disciplinaId) {
		return ok(views.html.disciplinas.render(planejador.getDisciplinas(), planejador.getDisciplina(disciplinaId)));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result marcarComoAtual(int periodo){
		planejador.setPeriodoAtual(periodo);
		return redirect((routes.Application).plano());
	}
}
