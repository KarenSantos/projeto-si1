package controllers;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cadastro;
import views.html.login;

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
		private String email;
		private String password;
		private String repassword;
		private String nome;

		public String getEmail(){
			return this.email;
		}
		
		public String getPassword(){
			return this.password;
		}
		
		public String getRepassword(){
			return this.repassword;
		}
		
		public String getNome(){
			return this.nome;
		}
		
		/**
		 * Validação dos dados inseridos para o cadastro.
		 * 
		 * @return Null se o cadastro foi concluído com sucesso ou string de
		 *         erro caso contrário.
		 */
		public String validate() {
			String erro = null;
			if (!getPassword().equals(getRepassword())) {
				erro = "Senha incorreta";
			}
			if (getPassword().length() < 8) {
				erro = "Senha deve ter no mínimo 8 caracteres";
			}
			if (getEmail() == null || getEmail().trim().equals("")) {
				return "Insira um email";
			} else if (Usuario.find.where().eq("email", getEmail()).findUnique() != null) {
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
		private String email;
		private String password;

		public String getEmail(){
			return this.email;
		}
		
		public String getPassword(){
			return this.password;
		}
		
		/**
		 * Valida o login do usuário.
		 * 
		 * @return Null se os dados para login foram validos ou mensagem de erro caso contrário.
		 */
		public String validate() {
			if(Usuario.authenticate(email, password) == null) {
                flash("Usuário ou password inválido.");
            }
            return null;
		}
	}

	static Form<Usuario> userForm = Form.form(Usuario.class);

	public static Result login() {
		criaUsuarios();
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().getEmail());
			return redirect(routes.Application.index(loginForm.get().getEmail()));
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
		if (cadastroForm.hasErrors()) {
			return badRequest(cadastro.render(cadastroForm));
		} else if(cadastroForm.get().validate() == null) {
			Cadastro novoC = cadastroForm.get();
			Usuario.create(new Usuario(novoC.getEmail(), novoC.getNome(),
			novoC.getPassword()));
		}else{
			return redirect(routes.Autenticador.cadastro());
		}
		return redirect(routes.Autenticador.login());
	}
	
	private static void criaUsuarios(){
		
		if (Usuario.find.all().isEmpty()) {
			int num = 1;
			
			while (num < 31){
				String email = "usuario" + num + "@email.com"; 
				String nome = "Usuário " + num;
				String password = "usuario" + num;
				
				Usuario.create(new Usuario(email, nome, password));
				num ++;
			}
		}
		
	}
}
