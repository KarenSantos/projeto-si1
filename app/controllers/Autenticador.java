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
	 * Classe de cadastro do usuário com nome, email e senha e grade.
	 * 
	 * @author
	 * 
	 */
	public static class Cadastro {
		private String nome;
		private String email;
		private String password;
		private String repassword;
		public String grade;

		public String getNome(){
			return this.nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail(){
			return this.email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getPassword(){
			return this.password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getRepassword(){
			return this.repassword;
		}
		
		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}
		
		public String getGrade(){
			return this.grade;
		}
		
		public void setCodigoGrade(String grade){
			this.grade = grade;
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
                erro = "Usuário ou senha inválidos.";
            }
            return erro;
		}
	}

	static Form<Usuario> userForm = Form.form(Usuario.class);

	public static Result login() {
		if (Usuario.find.all().isEmpty()){
			criaUsuariosAleatorios();
		}
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			flash("erro", "Usuário ou senha incorretos.");
			return redirect(routes.Autenticador.login());
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
			usuario.save();
			Grade grade = criaGrade(novoC.getGrade());
			criaPlanoDoUsuario(usuario, grade);
		}
		flash("success", "Cadastro realizado com sucesso.");
		return redirect(routes.Autenticador.login());
	}
	
	private static void criaPlanoDoUsuario(Usuario usuario, Grade grade){
		PlanoDeCurso plano = new PlanoDeCurso("p_" + usuario.getEmail(), grade);
		plano.save();
	}
	
	private static Grade criaGrade(String codigo){
		Grade grade = null;
			grade = Grade.find.byId(codigo);
			if (grade == null){
				if(codigo.equals("Computacao grade antiga")){
					grade = new GradeAntiga();
				}else if(codigo.equals("Computacao grade comum")){
					grade = new GradeComum();
				}else if(codigo.equals("Computacao grade nova")){
					grade = new GradeNova();
				}
				grade.configuraGrade(codigo);
				grade.save();
			}
		return grade;
	}

	private static void criaUsuariosAleatorios() {
		
		Grade grade = Grade.find.byId("Computacao grade antiga");
		if (grade == null){
			grade = new GradeAntiga();
			grade.configuraGrade("Computacao grade antiga");
			grade.save();
		}
		
		int num = 1;
		while (num < 31){
			String email = "usuario" + num + "@email.com"; 
			String nome = "Usuário " + num;
			String password = "usuario" + num;
			Usuario user = new Usuario(email, nome, password);
			user.save();		

			criaPlanoDoUsuario(user, grade);
			num ++;
		}
	}
}
