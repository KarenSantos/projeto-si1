package models;

import java.util.*;

import javax.persistence.*;

import org.mindrot.jbcrypt.BCrypt;

import play.db.ebean.*;

/**
 * Classe de usuário.
 * 
 * @author
 * 
 */
@Entity
@Table(name = "usuario")
public class Usuario extends Model implements Comparable<Usuario> {

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
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());

	}

	public static Finder<String, Usuario> find = new Finder<String, Usuario>(
			String.class, Usuario.class);

	public static List<Usuario> all() {
		return Usuario.find.all();
	}

	/**
	 * Retorna o Id do usuario.
	 * 
	 * @return O Id do usuario.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Altera o id do usuario.
	 * 
	 * @param id
	 *            O novo Id do usuario.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retorna o nome do usuario.
	 * 
	 * @return O nome do usuario.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Altera o nome do usuario.
	 * 
	 * @param nome
	 *            O novo nome do usuario.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o email do usuario.
	 * 
	 * @return O email do usuario.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Altera o email do usuario.
	 * 
	 * @param email
	 *            O novo email do usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o password do usuario.
	 * 
	 * @return O password do usuario.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Altera o password do usuario.
	 * 
	 * @param password
	 *            O novo password do usuario.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Compara os usuarios de acordo com seu nome.
	 */
	@Override
	public int compareTo(Usuario usuario) {
		return getNome().compareTo(usuario.getNome());
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
	public static String authenticate(String email, String password) {
		Usuario usuario = find.where().eq("email", email).findUnique();
		if (usuario == null) {
			return "Usuario não encontrado";
		}
		if (BCrypt.checkpw(password, usuario.getPassword())) {
			return null;
		} else {
			return "Senha incorreta";
		}
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
