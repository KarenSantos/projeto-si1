package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private List<Disciplina> disciplinas;
	private int totalDeCreditos;
	private int totalDeDificuldade;
	private int numero;

	/**
	 * Cria um periodo sem numero.
	 */
	public Periodo() {}
	
	/**
	 * Um periodo contem uma lista de disciplinas e o total de creditos do
	 * periodo.
	 */
	public Periodo(int numero) {
		disciplinas = new ArrayList<Disciplina>();
		totalDeCreditos = 0;
		this.numero = numero;
	}

	/**
	 * Retorna a lista de disciplinas do periodo.
	 * 
	 * @return A lista de disciplinas do periodo.
	 */
	public List<Disciplina> getDisciplinas() {
		return Collections.unmodifiableList(disciplinas);
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

}
