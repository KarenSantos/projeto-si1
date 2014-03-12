package controllers;

import java.sql.Connection;

import javax.sql.DataSource;

import views.html.*;
import java.sql.Connection;
import java.sql.Date;
import javax.sql.DataSource;
import play.db.*;
import models.*;
import play.mvc.*;
import play.data.*;
import play.data.Form.*;
import play.db.DB;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Classe de autenticação e cadastro do usuário
 * 
 * @author
 * 
 */
public class Autenticador extends Controller {

	/**
	 * Classe de cadastro do usuário com nome, email e senha.
	 * 
	 * @author
	 * 
	 */
	public static class Cadastro {
		public String email;
		public String password;
		public String repassword;
		public String nome;

		/**
		 * Validação dos dados inseridos para o cadastro.
		 * 
		 * @return Null se o cadastro foi concluído com sucesso ou string de
		 *         erro caso contrário.
		 */
		public String validate() {
			String erro = null;
			if (!password.equals(repassword)) {
				erro = "Senha incorreta";
			}
			if (password.length() < 8) {
				erro = "Senha deve ter no mínimo 8 caracteres";
			}
			if (email == null || email.trim().equals("")) {
				return "Insira um email";
			} else if (Usuario.find.where().eq("email", this.email)
					.findUnique() != null) {
				erro = "Usuario já cadastrado";
			}
			if (erro != null) {
				flash("erro", erro);
			}
			return erro;
		}
	}

	/**
	 * Classe de login.
	 * 
	 * @author
	 *
	 */
	public static class Login {
		public String email;
		public String password;

		/**
		 * Valida o login do usuário.
		 * 
		 * @return Null se os dados para login foram validos ou mensagem de erro caso contrário.
		 */
		public String validate() {
			String erro = Usuario.authenticate(email, password);
			if (erro != null) {
				flash("erro", erro);
			}
			return erro;
		}
	}

	static Form<Usuario> userForm = Form.form(Usuario.class);

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}

	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.Autenticador.login());
	}

	public static Result cadastro() {
		return ok(cadastro.render(Form.form(Cadastro.class)));
	}

	public static Result efetuaCadastro(){
		Form<Cadastro> cadastroForm = Form.form(Cadastro.class).bindFromRequest();
		Cadastro novoC = cadastroForm.get();
		if (cadastroForm.hasErrors()) {
			return badRequest(cadastro.render(Form.form(Cadastro.class)));
		} else if(cadastroForm.get().validate() == null) {
				Usuario.create(new Usuario(novoC.email, novoC.nome,
				novoC.password));
		}else{
			return redirect(routes.Autenticador.cadastro());
		}
		return redirect(routes.Autenticador.login());
	}
}
