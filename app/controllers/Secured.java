package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;


public class Secured extends Security.Authenticator {

	@Override
	public String getUsername(Context ctx) {
		System.out.println(ctx.session().get("email"));
        return ctx.session().get("email");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Autenticador.login());
    }
}
