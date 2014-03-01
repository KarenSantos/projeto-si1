package controllers;

import exceptions.AlocacaoInvalidaException;
import exceptions.TotalDeCreditosInvalidoException;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Classe Application para a aplicacao web Planejamento de Curso.
 * @author 
 *
 */
public class Application extends Controller {

	private static Planejador planejador = new Planejador("Usuario");
	
	public static Result index() {
		return redirect((routes.Application).periodos());
	}

	public static Result periodos() {
		planejador.removePeriodosVazios();
		return ok(views.html.index.render(planejador.getPeriodos(), 
				planejador.getDisciplinasNaoAlocadas(), planejador));
	}
	
	public static Result novoPeriodo(int periodo) {
		try {
			planejador.createPeriodo("Usuario" + periodo);
		} catch (TotalDeCreditosInvalidoException e) {
			
		} catch (AlocacaoInvalidaException e) {
			
		}
		int ultimoPeriodo = planejador.getPeriodos().size();
		return redirect((routes.Application).editar(ultimoPeriodo));
	}
	
	public static Result editar(int periodo) {
		return ok(views.html.editar.render(planejador.getPeriodos(), 
				planejador.getDisciplinasNaoAlocadas(), periodo, planejador));
	}
	
	public static Result adicionar(String disciplinaId, int periodo) {
		try {
			planejador.addDisciplinaPeriodo(disciplinaId, periodo);
		} catch (TotalDeCreditosInvalidoException e) {
		} catch (AlocacaoInvalidaException e) {
		}
		return redirect((routes.Application).editar(periodo));
	}
	
	public static Result remover(String disciplinaId, int periodo) {
		try {
			planejador.removeDisciplinaPeriodo(disciplinaId, periodo);
		} catch (AlocacaoInvalidaException e) {
		}
		return redirect((routes.Application).editar(periodo));
	}
	
	public static Result mover(String disciplinaId, int periodoFuturo, int periodoAtual) {
		planejador.moveDisciplina(disciplinaId, periodoFuturo, periodoAtual);
		return redirect((routes.Application).editar(periodoFuturo));
	}
	
	public static Result deletarPeriodo(int periodo){
		try {
			planejador.deletarPeriodo(periodo);
		} catch (AlocacaoInvalidaException e) {
			e.printStackTrace();
		}
		return redirect((routes.Application).periodos());
	}
}
