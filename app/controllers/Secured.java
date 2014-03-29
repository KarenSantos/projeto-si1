package controllers;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Classe para autenticar o acesso do usuário às páginas.
 * 
 * @author 
 *
 */
public class Secured extends Security.Authenticator {

	/**
	 * Recupera o email do usuário da sessão atual.
	 */
	@Override
	public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }

	/**
	 * Se o usuário não estiver autorizado retorna para a página de login.
	 */
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Autenticador.login());
    }
}
