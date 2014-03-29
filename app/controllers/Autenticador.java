package controllers;

import models.*;
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

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

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
				erro = "Confirmação de senha incorreta!";
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
		
		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
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
			String erro = null;
			if(Usuario.authenticate(email, password) != null) {
                erro = "Usuário ou password inválido.";
            }
            return erro;
		}
	}

	static Form<Usuario> userForm = Form.form(Usuario.class);

	public static Result login() {
		try {
			criaUsuarios();
		} catch (TotalDeCreditosInvalidoException e) {
			flash(e.getMessage());
		}
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			flash("erro", "Usuário ou senha incorretos.");
			return redirect(routes.Autenticador.login());
//			return badRequest(login.render(loginForm));
		} else { 
			session().clear();
			session("email", loginForm.get().getEmail());
			return redirect(routes.Application.index());
		}
	}

	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out.");
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
			Usuario usuario = new Usuario(novoC.getEmail(), novoC.getNome(), novoC.getPassword()); 
			Usuario.create(usuario);

			//criando o plano do novo usuario
			//TODO este metodo vai receber tbm o tipo de plano q o usuario escolher no cadastro
			try {
				criaPlanoDoUsuario(usuario);
			} catch (TotalDeCreditosInvalidoException e) {
				
				
				flash(e.getMessage());
			}
		}
		flash("success", "Cadastro realizado com sucesso.");
		return redirect(routes.Autenticador.login());
	}
	
	private static void criaUsuarios() throws TotalDeCreditosInvalidoException{
		
		if (Usuario.find.all().isEmpty()) {
			int num = 1;
			
			while (num < 31){
				String email = "usuario" + num + "@email.com"; 
				String nome = "Usuário " + num;
				String password = "usuario" + num;
				Usuario user = new Usuario(email, nome, password);
				Usuario.create(user);
				criaPlanoDoUsuario(user);
				num ++;
			}
		}
	}
	
	private static void criaPlanoDoUsuario(Usuario usuario) throws TotalDeCreditosInvalidoException{
		
		Grade grade = new GradeAntiga();
		grade.configuraGrade("g_" + usuario.getEmail());
		PlanoDeCurso plano = new PlanoDeCurso("p_" + usuario.getEmail(), grade);
		plano.reset();
		plano.save();
	}
}
