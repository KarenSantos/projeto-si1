package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de disciplinas.
 * 
 * @author
 * 
 */
public class Disciplina {

	private String id, nome;
	private int creditos;
	private List<Disciplina> preRequisitos;
	private int periodoSugerido;
	private int dificuldade;

	/**
	 * Cria uma disciplina com um id, um nome, a quantidade de creditos, uma
	 * lista de disciplinas de pre requisitos, o periodo sugerido para cursar a
	 * disciplina e a dificuldade indicada da disciplina.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @param nome
	 *            O nome da disciplina.
	 * @param creditos
	 *            A quantidade de creditos da disciplina.
	 * @param preRequisitos
	 *            As disciplinas que sao pre requisitos desta disciplina.
	 * @param periodoSugerido
	 *            O periodo sugerido para cursar esta disciplina.
	 * @param dificuldade
	 *            A dificuldade indicada para a disciplina
	 * 
	 */
	public Disciplina(String id, String nome, int creditos,
			List<Disciplina> preRequisitos, int periodoSugerido, int dificuldade) {
		this.id = id;
		this.nome = nome;
		this.creditos = creditos;
		this.preRequisitos = preRequisitos;
		this.periodoSugerido = periodoSugerido;
		this.dificuldade = dificuldade;
	}

	/**
	 * Cria uma disciplina com um id, um nome, a quantidade de creditos, o
	 * periodo sugerido para cursar a disciplina e a dificuldade indicada da
	 * disciplina.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @param nome
	 *            O nome da disciplina.
	 * @param creditos
	 *            A quantidade de creditos da disciplina.
	 * @param periodoSugerido
	 *            O periodo sugerido para cursar esta disciplina.
	 * @param dificuldade
	 *            A dificuldade indicada para a disciplina
	 * 
	 */
	public Disciplina(String id, String nome, int creditos,
			int periodoSugerido, int dificuldade) {
		this.id = id;
		this.nome = nome;
		this.creditos = creditos;
		this.preRequisitos = new ArrayList<Disciplina>();
		this.periodoSugerido = periodoSugerido;
		this.dificuldade = dificuldade;
	}

	/**
	 * Retorna o id da disciplina.
	 * 
	 * @return O id da disciplina.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Retorna o nome da disciplina.
	 * 
	 * @return O nome da disciplina.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o total de creditos da disciplina.
	 * 
	 * @return O total de creditos da disciplina.
	 */
	public int getCreditos() {
		return creditos;
	}

	/**
	 * Retorna a lista de pre requisitos da disciplina.
	 * 
	 * @return A lista de pre requisitos da disciplina.
	 */
	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	/**
	 * Retorna o periodo sugerido para cursar a disciplina.
	 * 
	 * @return O periodo sugerido para cursar a disciplina.
	 */
	public int getPeriodoSugerido() {
		return periodoSugerido;
	}

	/**
	 * Retorna a dificuldade indicada para a disciplina.
	 * 
	 * @return A dificuldade da disciplina.
	 */
	public int getDificuldade() {
		return dificuldade;
	}

	/**
	 * Uma disciplina eh igual a outra se tem o mesmo id.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Disciplina) {
			Disciplina dis = (Disciplina) obj;
			if (dis.getId().equals(getId())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "[" + nome + ", " + creditos + " créditos]";
	}

}
