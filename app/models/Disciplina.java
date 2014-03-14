package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

/**
 * Classe de disciplinas.
 * 
 * @author
 * 
 */
@Entity
@Table(name="disciplina") 
public class Disciplina extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Required
	@Column(unique = true, nullable = false)
	private String nome;
	
	@ManyToMany
    @JoinTable(name = "disciplina_preRequisito", joinColumns = {@JoinColumn (name = "di_disciplina")}, inverseJoinColumns = {@JoinColumn(name = "pr_preRequisito")})
	private List<Disciplina> preRequisitos;
	
	@ManyToOne
//  @JoinTable(name = "disciplina_preRequisito", joinColumns = {@JoinColumn (name = "di_disciplina")}, inverseJoinColumns = {@JoinColumn(name = "pr_preRequisito")})
	private Periodo periodoAtual;
	@ManyToOne
//  @JoinTable(name = "disciplina_preRequisito", joinColumns = {@JoinColumn (name = "di_disciplina")}, inverseJoinColumns = {@JoinColumn(name = "pr_preRequisito")})
	private PlanoDeCurso planoAtual;
	
	
	@Column
	private int creditos;
	@Column
	private int periodoSugerido;
	@Column
	private int dificuldade;
	@Column
	private boolean alocadaCorretamente;

	public static Finder<String, Disciplina> find = new Finder<String, Disciplina>(
			String.class, Disciplina.class);

	/**
	 * Cria uma disciplina com tudo null.
	 */
	public Disciplina() {
	};

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

		if (dificuldade < 0) {
			this.dificuldade = 0;
		} else if (dificuldade > 5) {
			this.dificuldade = 5;
		} else {
			this.dificuldade = dificuldade;
		}

		this.alocadaCorretamente = true;
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

		if (dificuldade < 0) {
			this.dificuldade = 0;
		} else if (dificuldade > 5) {
			this.dificuldade = 5;
		} else {
			this.dificuldade = dificuldade;
		}

		this.alocadaCorretamente = true;
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
	 * Altera o id da disciplina.
	 * 
	 * @param id
	 *            O novo id.
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Altera o nome da disciplina.
	 * 
	 * @param nome
	 *            O novo nome da disciplina.
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * Altera o numero de creditos da disciplina.
	 * 
	 * @param cred
	 *            O novo numero de creditos da disciplina.
	 */
	public void setCreditos(int cred) {
		this.creditos = cred;
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
	 * Altera a lista de pre-requisitos da disciplina.
	 * 
	 * @param preRequisitos
	 *            A nova lista de pre-requisitos da disciplina.
	 */
	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
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
	 * Altera o periodo sugerido da disciplina.
	 * 
	 * @param periodo
	 *            O novo periodo sugerido da disciplina.
	 */
	public void setPeriodoSugerido(int periodo) {
		this.periodoSugerido = periodo;
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
	 * Altera a dificuldade da disciplina.
	 * 
	 * @param dif
	 *            A nova dificuldade da disciplina.
	 */
	public void setDificuldade(int dif) {
		if (dif < 0) {
			this.dificuldade = 0;
		} else if (dif > 5) {
			this.dificuldade = 5;
		} else {
			this.dificuldade = dif;
		}
	}

	/**
	 * Retorna se a disciplina está ou não alocada corretamente.
	 * 
	 * @return True se a disciplina esta alocada corretamente, e false caso
	 *         contrario.
	 */
	public boolean isAlocadaCorretamente() {
		return alocadaCorretamente;
	}

	/**
	 * Altera o status da disciplina se esta alocada corretamente ou nao.
	 * 
	 * @param alocada
	 *            O novo status da disciplina.
	 */
	public void setAlocadaCorretamente(boolean alocada) {
		this.alocadaCorretamente = alocada;
	}

	/**
	 * Altera o status da disciplina para esta alocada corretamente.
	 */
	public void setIsAlocadaCorretamente() {
		this.alocadaCorretamente = true;
	}

	/**
	 * Altera o status da disciplina para não alocada corretamente.
	 */
	public void setNotAlocadaCorretamente() {
		this.alocadaCorretamente = false;
	}

	/**
	 * Salva a disciplina no banco de dados.
	 * 
	 * @param disc
	 *            A disciplina a ser salva.
	 */
	public static void create(Disciplina disc) {
		disc.save();
	}
	
	/**
	 * Deleta disciplina do banco de dados
	 * @param disc
	 * 			Disciplina a ser deletada
	 */
	 
	public static void remove(Disciplina disc) {
		disc.delete();
	}
	
	/**
	 * Atualiza a disciplina no banco de dados.
	 * 
	 * @param discId
	 *            O Id da disciplina a ser atualizada.
	 */
	public static void atualizar(String discId) {
		find.ref(discId).update();
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
	 * Retorna uma string contendo o nome e quantidade de créditos da
	 * disciplina.
	 */
	@Override
	public String toString() {
		return "[" + nome + ", " + creditos + " créditos]";
	}

}
