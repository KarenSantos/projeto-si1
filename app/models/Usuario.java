package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

/**
 * Classe de usuário.
 * 
 * @author
 * 
 */
@Entity
public class Usuario extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String email;
	private String nome;
	private String password;
	
	/**
	 * Cria um usuário.
	 */
	public Usuario() {
	}

	/**
	 * Cria um usuário com um email, um nome e um password.
	 * 
	 * @param email
	 *            O email do usuário.
	 * @param nome
	 *            O nome do usuário.
	 * @param password
	 *            O password do usuário.
	 */
	public Usuario(String email, String nome, String password) {
		this.id = email;
		this.email = email;
		this.nome = nome;
		this.password = password;
		
	}
	
	public static Finder<String, Usuario> find = new Finder<String, Usuario>(
			String.class, Usuario.class);

	public static List<Usuario> all() {return Usuario.find.all();	}

	public String getId(){
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * Salva o usuário no BD.
	 * 
	 * @param usuario
	 *            O usuário a ser salvo no BD.
	 */
	public static void create(Usuario usuario) {
		usuario.save();
	}

	/**
	 * Autentica o usuário ao fazer o login.
	 * 
	 * @param email
	 *            O email do usuário no login.
	 * @param password
	 *            O password do usuário no login.
	 * @return Null se a autenticação é feita com sucesso ou uma string de erro
	 *         se não.
	 */
	public static Usuario authenticate(String email, String password) {
		return find.where()
	            .eq("email", email)
	            .eq("password", password)
	            .findUnique();
	}

	/**
	 * Um usuário é igual a outro se tiver o mesmo email.
	 */
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof Usuario) {
			Usuario user = (Usuario) obj;
			if (email.equals(user.email))
				resp = true;
		}
		return resp;
	}
}
