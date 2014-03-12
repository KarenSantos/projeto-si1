package controllers;

import models.Usuario;
import exceptions.AlocacaoInvalidaException;
import exceptions.TotalDeCreditosInvalidoException;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

/**
 * Classe Application para a aplicacao web Planejamento de Curso.
 * @author 
 *
 */
public class Application extends Controller {
	
	
	private static Planejador planejador = new Planejador("Usuário");
	
	@Security.Authenticated(Secured.class)
	public static Result index() {
		return redirect((routes.Application).periodos());
	}

	@Security.Authenticated(Secured.class)
	public static Result periodos() {
		planejador.deletaUltimoPeriodoSeVazio();
		return ok(index.render(planejador.getPeriodos(), 
				planejador.getDisciplinasNaoAlocadas(), planejador));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result novoPeriodo() {
		try {
			planejador.createPeriodo("Usuario");
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
			return badRequest();
		} catch (AlocacaoInvalidaException e) {
			return forbidden();
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result remover(String disciplinaId, int periodo) {
		planejador.removeDisciplinaPeriodo(disciplinaId, periodo);
		return redirect((routes.Application).editar(periodo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result mover(String disciplinaId, int periodoFuturo, int periodoAtual) {
		try {
			planejador.moveDisciplina(disciplinaId, periodoFuturo, periodoAtual);
		} catch (TotalDeCreditosInvalidoException e) {
			return badRequest();
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result inverter() {
		planejador.inverteOrdemDosPeriodos();
		return ok("invertido");
	}
}
