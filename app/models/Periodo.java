package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import exceptions.NumeroInvalidoException;
import exceptions.TotalDeCreditosInvalidoException;
import play.db.ebean.Model;

/**
 * Classe de periodos academicos.
 * 
 * @author
 * 
 */
@Entity
public class Periodo extends Model {

	private static final long serialVersionUID = 1L;
	private final int MENOR_NUM_PERIODO = 1;
	private final int MAIOR_NUM_PERIODO = 14;

	@Id
	private String id;
//	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "periodo_disciplina", joinColumns = {@JoinColumn (name = "periodo")}, inverseJoinColumns = {@JoinColumn(name = "disciplina")})
	private List<Disciplina> disciplinas;
	private int totalDeCreditos;
	private int totalDeDificuldade;
	private int numero;
	
	 public static Finder<String, Periodo> find = new Finder<String, Periodo>(String.class, Periodo.class);

	/**
	 * Cria um periodo sem id e sem numero.
	 */
	public Periodo() {}
	
	/**
	 * Um periodo contem uma lista de disciplinas e o total de creditos do
	 * periodo.
	 */
	public Periodo(String id, int numero) {
		this.id = id;
		this.numero = numero;
		disciplinas = new ArrayList<Disciplina>();
		totalDeCreditos = 0;
	}

	/**
	 * Retorna a lista de disciplinas do periodo.
	 * 
	 * @return A lista de disciplinas do periodo.
	 */
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * Retorna o id do periodo.
	 * 
	 * @return O id do periodo.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Altera o id do periodo.
	 * 
	 * @param id
	 *            O novo id do periodo.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Retorna o numero do periodo.
	 * 
	 * @return O numero do periodo.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Altera o número de um período.
	 * 
	 * @param numero
	 *            O novo número de período.
	 * @throws NumeroInvalidoException
	 *             Se for um número abaixo de zero ou acima do numero máximo de
	 *             periodos.
	 */
	public void setNumero(int numero) throws NumeroInvalidoException {
		if (numero < MENOR_NUM_PERIODO || numero > MAIOR_NUM_PERIODO) {
			throw new NumeroInvalidoException("Número de período inválido.");
		}
		this.numero = numero;
	}
	
	/**
	 * Adiciona uma disciplina a lista de disciplinas do periodo.
	 * 
	 * @param disciplina
	 *            A disciplina a ser adicionada.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero total de creditos ficaria acima do maximo de
	 *             creditos por periodo.
	 */
	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
		this.totalDeCreditos += disciplina.getCreditos();
		this.totalDeDificuldade += disciplina.getDificuldade();
	}

	/**
	 * Retorna o numero total de creditos do periodo.
	 * 
	 * @return O numero total de creditos do periodo.
	 */
	public int getTotalDeCreditos() {
		return totalDeCreditos;
	}

	/**
	 * Retorna o numero total de disciplinas do periodo.
	 * 
	 * @return O numero total de disciplinas do periodo.
	 */
	public int getTotalDeDisciplinas() {
		return getDisciplinas().size();
	}
	
	public int getTotalDeDificuldade() {
		return totalDeDificuldade;
	}

	/**
	 * Remove uma disciplina da lista de disciplinas do periodo.
	 * 
	 * @param disciplina
	 *            A disciplina a ser removida.
	 */
	public void removeDisciplina(Disciplina disciplina) {
		disciplinas.remove(disciplina);
		this.totalDeCreditos -= disciplina.getCreditos();
		this.totalDeDificuldade -= disciplina.getDificuldade();
	}
	
	/**
	 * Salva o periodo no banco de dados.
	 * 
	 * @param periodo
	 *            O periodo a ser salvo.
	 */
	public void salvar(Periodo periodo) {
		periodo.save();
	}

	/**
	 * Atualiza o periodo no banco de dados.
	 * 
	 * @param periodoId
	 *            O Id do periodo a ser atualizado.
	 */
	public void atualizar(String periodoId) {
		find.ref(periodoId).update();
	}
	
	public void deletar(String periodoId) {
		find.ref(periodoId).delete();
	}
	
	@Override
	public String toString() {
		return "[Periodo " + getNumero() + "]";
	}
	

}
