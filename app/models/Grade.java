package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import play.db.ebean.Model;

/**
 * Classe da grade curricular do curso de computação 
 * 
 * @author
 *
 */
@Entity
@Inheritance
public abstract class Grade extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@ManyToOne
	private List<Disciplina> disciplinas;
	
	public static Finder<String, Grade> find = new Finder<String, Grade>(
			String.class, Grade.class);
	
	/**
	 * Cria uma grade curricular com uma lista de disciplinas.
	 */
	public Grade(){
	}
	
	public void configuraGrade(String id){
		this.id = id;
		disciplinas = new ArrayList<Disciplina>();
		if (Disciplina.find.all().isEmpty()) {
			criaDisciplinas();
		} else {
			disciplinas.addAll(Disciplina.find.all());
		}
	}
	
	public String getId(){
		return this.id;
	}
	
	/**
	 * Retorna a lista com todas as disciplinas da grade.
	 * 
	 * @return A lista com todas as disciplinas da grade.
	 */
	public List<Disciplina> getDisciplinas(){
		return Collections.unmodifiableList(disciplinas);
	}
	
	/**
	 * Retorna uma disciplina da grade curricular.
	 * 
	 * @param id 
	 * 			   O id da disciplina que vai ser retornada.
	 * @return A disciplina com o id ou null se não existir.
	 */
	public Disciplina getDisciplina(String id){
		Disciplina aDisciplina = null;
		for (Disciplina disc : disciplinas) {
			if (disc.getId().equals(id)) {
				aDisciplina = disc;
			}
		}
		return aDisciplina;
	}
	
	/**
	 * Retorna o total de disciplinas da grade curricular.
	 * 
	 * @return O total de disciplinas.
	 */
	public int getTotalDeDisciplinas(){
		return getDisciplinas().size();
	}
	
	/**
	 * Cria uma disciplina com um id, um nome, o total de creditos, uma lista de
	 * disciplinas que sao pre requisitos, o periodo sugerido para cursar a
	 * disciplina e a dificuldade indicada da disciplina.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @param nome
	 *            O nome da disciplina.
	 * @param creditos
	 *            O total de creditos da disciplina.
	 * @param preRequisitosIds
	 *            A lista de disciplinas que sao pre requisitos desta.
	 * @param periodoSugerido
	 *            O periodo sugerido para cursar esta disciplina.
	 * @param dificuldade
	 * 			  A dificuldade indicada para a disciplina
	 * 
	 */
	public void createDisciplina(String id, String nome, int creditos,
			String[] preRequisitosIds, int periodoSugerido, int dificuldade) {

		List<Disciplina> preRequisitos = new ArrayList<Disciplina>();

		for (String preRequisitoId : preRequisitosIds) {
			preRequisitos.add(getDisciplina(preRequisitoId));
		}

		Disciplina aDisciplina = new Disciplina(id, nome, creditos,
				preRequisitos, periodoSugerido, dificuldade);
		disciplinas.add(aDisciplina);
		aDisciplina.save();
	}

	/**
	 * Cria uma disciplina com um id, um nome, o total de creditos, o periodo 
	 * sugerido para cursar a disciplina e a dificuldade indicada da disciplina.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @param nome
	 *            O nome da disciplina.
	 * @param creditos
	 *            O total de creditos da disciplina.
	 * @param periodoSugerido
	 *            O periodo sugerido para cursar esta disciplina.
	 * @param dificuldade
	 * 			  A dificuldade indicada para a disciplina
	 *             
	 */
	public void createDisciplina(String id, String nome, int creditos, int periodoSugerido, int dificuldade) {
		Disciplina aDisciplina = new Disciplina(id, nome, creditos, periodoSugerido, dificuldade);
		disciplinas.add(aDisciplina);
		aDisciplina.save();
	}
	
	
	/**
	 * Cria todas as disciplinas do curso de computação.
	 */
	protected abstract void criaDisciplinas();
	
	public static void create(Grade grade){
		grade.save();
	}

}
