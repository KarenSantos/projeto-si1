package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

/**
 * Classe da grade curricular do curso de computação
 * 
 * @author
 * 
 */
@Entity
@Inheritance
public abstract class Grade extends Model {

	private static final long serialVersionUID = 1L;

	private final int INICIO_OPTATIVA_TECC = 100;
	private final int FIM_OPTATIVA_TECC = 199;
	private final int INICIO_OPTATIVA_OUTROS = 200;

	@Id
	private String id;

	@ManyToMany
	@JoinTable(name = "grade_disciplina", joinColumns = @JoinColumn(name = "grade"), inverseJoinColumns = @JoinColumn(name = "disciplina"))
	private List<Disciplina> disciplinas;

	@ManyToMany
	protected List<Periodo> periodos;

	public static Finder<String, Grade> find = new Finder<String, Grade>(
			String.class, Grade.class);

	/**
	 * Cria uma grade curricular com uma lista de disciplinas.
	 */
	public Grade() {
	}

	/**
	 * Configura os atributos da grade e recebe um id.
	 * 
	 * @param id
	 *            O id da grade.
	 */
	public void configuraGrade(String id) {
		this.id = id;
		disciplinas = new ArrayList<Disciplina>();

		if (Disciplina.find.all().isEmpty()) {
			criaDisciplinas();
		}

		periodos = new ArrayList<Periodo>();
		if (Periodo.find.all().isEmpty()) {
			configuraPeriodos();
		}
	}

	/**
	 * Retorna o id da grade.
	 * 
	 * @return O id da grade.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Altera o id da grade.
	 * 
	 * @param id
	 *            O novo id da grade.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retorna a lista com todas as disciplinas da grade.
	 * 
	 * @return A lista com todas as disciplinas da grade.
	 */
	public List<Disciplina> getDisciplinas() {
		return Collections.unmodifiableList(this.disciplinas);
	}

	/**
	 * Altera a lista de disciplinas da grade do curso.
	 * 
	 * @param disciplinas
	 *            A nova lista de disciplinas da grade.
	 */
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/**
	 * Retorna uma disciplina da grade curricular.
	 * 
	 * @param id
	 *            O id da disciplina que vai ser retornada.
	 * @return A disciplina com o id ou null se não existir.
	 */
	public Disciplina getDisciplina(String id) {
		Disciplina aDisciplina = null;
		for (Disciplina disc : disciplinas) {
			if (disc.getId().equals(id)) {
				aDisciplina = disc;
			}
		}
		return aDisciplina;
	}

	/**
	 * Retorna o periodo que a disciplina esta na grade do curso.
	 * 
	 * @param disc
	 *            A disciplina que se quer saber o numero do periodo.
	 * @return O numero do periodo da disciplina ou zero se a disciplina for
	 *         optativa.
	 */
	public int getPeriodoDaDisciplina(Disciplina disc) {
		int numPeriodo = 0;
		for (Periodo periodo : getPeriodos()) {
			if (periodo.getDisciplinas().contains(disc)) {
				numPeriodo = periodo.getNumero();
			}
		}
		return numPeriodo;
	}

	/**
	 * Retorna o total de disciplinas da grade curricular.
	 * 
	 * @return O total de disciplinas.
	 */
	public int getTotalDeDisciplinas() {
		return getDisciplinas().size();
	}

	/**
	 * Retorna uma lista com todas as disciplinas optativas, ou seja, todas as
	 * disciplinas que nao estao em nenhum periodo.
	 * 
	 * @return A lista de disciplinas optativas.
	 */
	public List<Disciplina> getDisciplinasOptativas() {
		List<Disciplina> optativas = new ArrayList<Disciplina>();
		optativas.addAll(getDisciplinas());
		for (Periodo periodo : getPeriodos()) {
			for (Disciplina disc : periodo.getDisciplinas()) {
				if (optativas.contains(disc)) {
					optativas.remove(disc);
				}
			}
		}
		return optativas;
	}

	/**
	 * Retorna a lista de periodos da grade.
	 * 
	 * @return A lista de periodos da grade.
	 */
	public List<Periodo> getPeriodos() {
		return Collections.unmodifiableList(this.periodos);
	}

	/**
	 * Retorna um periodo pelo seu numero.
	 * 
	 * @param numPeriodo
	 *            O numero do periodo a ser retornado
	 * @return O periodo do numero ou null se nao existir.
	 */
	public Periodo getPeriodo(int numPeriodo) {
		Periodo oPeriodo = null;
		for (Periodo periodo : getPeriodos()) {
			if (periodo.getNumero() == numPeriodo) {
				oPeriodo = periodo;
			}
		}
		return oPeriodo;
	}

	/**
	 * Retorna o numero total de periodos da grade.
	 * 
	 * @return O numero total de periodos da grade.
	 */
	public int getTotalDePeriodos() {
		return getPeriodos().size();
	}
	
	/**
	 * Retorna o numero minimo de creditos para completar a grade.
	 * 
	 * @return O numero minimo de creditos para completar a grade.
	 */
	public int getMinimoDeCreditos() {
		int minimo = 0;
		for (Periodo periodo : getPeriodos()){
			minimo += periodo.getTotalDeCreditos();
		}
		return minimo;
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
	 * @param dificuldade
	 *            A dificuldade indicada para a disciplina
	 * 
	 */
	public void createDisciplina(String id, String nome, int creditos,
			String[] preRequisitosIds, int dificuldade) {

		List<Disciplina> preRequisitos = new ArrayList<Disciplina>();

		for (String preRequisitoId : preRequisitosIds) {
			preRequisitos.add(getDisciplina(preRequisitoId));
		}

		Disciplina aDisciplina = new Disciplina(id, nome, creditos,
				preRequisitos, dificuldade);
		this.disciplinas.add(aDisciplina);
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
	 * @param dificuldade
	 *            A dificuldade indicada para a disciplina
	 * 
	 */
	public void createDisciplina(String id, String nome, int creditos,
			int dificuldade) {
		Disciplina aDisciplina = new Disciplina(id, nome, creditos, dificuldade);
		this.disciplinas.add(aDisciplina);
		aDisciplina.save();
	}

	/**
	 * Cria um periodo com o numero indicado com as disciplinas da lista caso o
	 * periodo ainda nao exista.
	 * 
	 * @param numPeriodo
	 *            O numero do periodo a ser criado.
	 * @param disciplinaIds
	 *            Os ids das disciplinas a serem inseridas no periodo criado.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o total de créditos do periodo for violado.
	 */
	public void createPeriodo(int numPeriodo, String[] disciplinasIds)
			throws TotalDeCreditosInvalidoException {
		if (getPeriodo(numPeriodo) == null) {
			Periodo oPeriodo = new Periodo(this.getId() + numPeriodo,
					numPeriodo);
			for (int i = 0; i < disciplinasIds.length; i++) {
				oPeriodo.addDisciplina(getDisciplina(disciplinasIds[i]));
			}
			this.periodos.add(oPeriodo);
			oPeriodo.save();
		}
	}

	/**
	 * Verifica se a disciplina eh uma disciplina optativa do TECC.
	 * 
	 * @param disc
	 *            A disciplina que se quer verificar.
	 * @return True se a disciplina for optativa TECC ou false caso contrario.
	 */
	public boolean ehOptativaTECC(Disciplina disc) {
		boolean resp = false;
		int id = Integer.parseInt(disc.getId());
		if (id >= INICIO_OPTATIVA_TECC && id <= FIM_OPTATIVA_TECC) {
			resp = true;
		}
		return resp;
	}

	/**
	 * Verifica se a disciplina eh uma disciplina optativa de outros cursos.
	 * 
	 * @param disc
	 *            A disciplina que se quer verificar.
	 * @return True se a disciplina for optativa de outros cursos ou false caso
	 *         contrario.
	 */
	public boolean ehOptativaDeOutrosCursos(Disciplina disc) {
		boolean resp = false;
		int id = Integer.parseInt(disc.getId());
		if (id >= INICIO_OPTATIVA_OUTROS) {
			resp = true;
		}
		return resp;
	}

	/**
	 * Cria todas as disciplinas do curso de computação.
	 */
	protected abstract void criaDisciplinas();

	/**
	 * Configura todos os periodos da grade de acordo com a alocacao padrao.
	 */
	protected abstract void configuraPeriodos();

}
