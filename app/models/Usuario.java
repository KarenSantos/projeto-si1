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
	public String email;
	public String nome;
	public String password;

	public Usuario() {
	}

	public Usuario(String email, String nome, String password) {
		this.email = email;
		this.nome = nome;
		this.password = password;
	}

	public static Finder<String, Usuario> find = new Finder<String, Usuario>(
			String.class, Usuario.class);

	public static List<Usuario> all() {
		return Usuario.find.all();
	}

	/**
	 * Salva o usuário no BD.
	 * 
	 * @param usuario
	 *            O usuário a ser salvo no BD.
	 */
	public static String create(Usuario usuario) {
		String resposta = null;
		if (find.where().eq("email", usuario.email).findUnique() == null) {
			usuario.save();
		} else {
			resposta = "Usuário já cadastrado.";
		}
		return resposta;
	}

	public static String authenticate(String email, String password) {
		String resp = null;
		Usuario user = find.where().eq("email", email).findUnique();
		if (user == null) {
			return "Usuario não encontrado";
		}
		if (!user.password.equals(password)) {
			resp = "Senha incorreta";
		}
		return resp;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario compara = (Usuario) obj;
			if (email.equals(compara.email))
				return true;
		}
		return false;
	}
}
