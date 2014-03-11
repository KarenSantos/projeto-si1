package models;

import exceptions.*;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
@Entity
public class Usuario extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public String email;
	
	public String name;
	
	public String password;
	
	public Usuario(){
		
	}
	public Usuario(String email, String nome, String password){
		this.email = email; this.password = password;
	}
	
	
	
	public static Finder<String, Usuario> find = new Finder<String, Usuario>(String.class, Usuario.class);
	
	
	public static List<Usuario> all() {
		 return Usuario.find.all();
	}

	/**
	 * Metodo para salvar usuario no BD
	 * @param usuario Usuario a ser salvo no BD
	 * @throws UsuarioJaExisteException se o Usuario já está cadastrado no BD
	 */
	public static void create(Usuario usuario) throws UsuarioJaExisteException{
		if(find.where().eq("email", usuario.email).findUnique() == null){
			usuario.save();
		}else throw new UsuarioJaExisteException("");
	 }
	
	
	public static String authenticate(String email, String password) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        Usuario x = find.where().eq("email", email).findUnique();
        if(x == null){
        	return "Usuario não encontrado";
        }
		if(x.password.equals(password)) return null;
		else{
			return "Senha incorreta";
		}
		

	}
	
	
	
	public boolean equals(Object obj){ 
	       if(obj instanceof Usuario){ 
	           Usuario compara = (Usuario)obj; 
	           if(email.equals(compara.email)) 
	               return true; 
	       } 
	       return false; 
	}
}

