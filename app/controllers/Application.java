package controllers;

import java.util.Collections;
import java.util.List;

import models.AlocacaoInvalidaException;
import models.TotalDeCreditosInvalidoException;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
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
		planejador.ordenarPeriodos();
		
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
		} catch (TotalDeCreditosInvalidoException e) {
			return forbidden();
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
			return badRequest(e.getMessage());
		} catch (AlocacaoInvalidaException e) {
			return forbidden(e.getMessage());
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result remover(String disciplinaId, int periodo) {
		try{
			planejador.removeDisciplinaPeriodo(disciplinaId, periodo);
		}catch(TotalDeCreditosInvalidoException e){
			if (e.getMessage().equals("O número mínimo de créditos neste período é 14.")){
				return badRequest();
			} else {
				return forbidden();
			}
		}
		return redirect((routes.Application).editar(periodo));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result mover(String disciplinaId, int periodoFuturo, int periodoAtual) {
		try {
			planejador.moveDisciplina(disciplinaId, periodoFuturo, periodoAtual);
		} catch (TotalDeCreditosInvalidoException e) {
			return badRequest(e.getMessage());
		}
		return ok();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result inverter() {
		planejador.inverteOrdemDosPeriodos();
		return ok("invertido");
	}
	
	@Security.Authenticated(Secured.class)
	public static Result ordenar() {
		planejador.ordenarPeriodos();
		return ok("ordenado");
	}
	
	
	@Security.Authenticated(Secured.class)
	public static Result disciplinas(String disciplinaId) {
		if (disciplinaId.equals("id")){
			return ok(views.html.disciplinas.render(planejador.getDisciplinas(), planejador.getDisciplinas().get(1), planejador));
		}
		return ok(views.html.disciplinas.render(planejador.getDisciplinas(), planejador.getDisciplina(disciplinaId), planejador));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result marcarComoAtual(int periodo){
		planejador.setPeriodoAtual(periodo);
		return redirect((routes.Application).plano());
	}
	
	@Security.Authenticated(Secured.class)
	public static Result outroPlano(String usuarioId){
		List<Usuario> usuarios = Usuario.find.all();
		Collections.sort(usuarios);

		if (usuarioId.equals("id")){
			return ok(views.html.outrosPlanos.render(usuarios, null, planejador));
		} else {
			Usuario usuario = Usuario.find.byId(usuarioId);
			return ok(views.html.outrosPlanos.render(usuarios, usuario, planejador));
		}
	}
	
	@Security.Authenticated(Secured.class)
	public static Result outroPlanoBusca(String nomeProcurado){
		DynamicForm buscaForm = Form.form().bindFromRequest();
		List<Usuario> usuarios = planejador.buscaDeUsuarios(buscaForm.get("texto"));
		Collections.sort(usuarios);
		
		if (usuarios.isEmpty()){
			return ok(views.html.outrosPlanos.render(null, null, planejador));
		}else {
			return ok(views.html.outrosPlanos.render(usuarios, null, planejador));
		}
	}
}
