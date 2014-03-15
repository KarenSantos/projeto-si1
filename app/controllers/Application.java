package controllers;

import java.util.List;

import models.Usuario;
import exceptions.AlocacaoInvalidaException;
import exceptions.RemocaoInvalidaException;
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
	public static Result adicionar(long disciplinaId, int periodo) {
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
	public static Result remover(long disciplinaId, int periodo) {
		try{
			planejador.removeDisciplinaPeriodo(disciplinaId, periodo);
		}catch(RemocaoInvalidaException e){
			return badRequest();
		}
		return redirect((routes.Application).editar(periodo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result mover(long disciplinaId, int periodoFuturo, int periodoAtual) {
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
