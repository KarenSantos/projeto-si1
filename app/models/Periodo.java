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

	public static final long serialVersionUID = 1L;
	private final int MENOR_NUM_PERIODO = 1;
	private final int MAIOR_NUM_PERIODO = 14;
	private final int MINIMO_CREDITOS = 14;

	public int getMinimoCreditos() {
		return MINIMO_CREDITOS;
	}

	@Id
	public String id;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Disciplina> disciplinas;
	
	private int totalDeCreditos;
	private int totalDeDificuldade;
	private int numero;
	//private ValidadorRemocao validaRemocao;
	
	// public ValidadorRemocao getValidaRemocao() {
		//return validaRemocao;
//	}

	public void setValidaRemocao(ValidadorRemocao validaRemocao) {
		//this.validaRemocao = validaRemocao;
	}

	public static Finder<String, Periodo> find = new Finder<String, Periodo>(String.class, Periodo.class);

	/**
	 * Cria um periodo sem id e sem numero.
	 */
	public Periodo() {}
	
	/**
	 * Um periodo contem uma lista de disciplinas e o total de creditos do
	 * periodo.
	 */
	public Periodo(int numero) {
		this.numero = numero;
		disciplinas = new ArrayList<Disciplina>();
		totalDeCreditos = 0;
		setValidaRemocao(new RemoverNormalmente());
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
	
	public boolean podeRemover(Disciplina disciplina) {
		return true;
		//return validaRemocao.podeRemover(this, disciplina);
	}
	
	
	/**
	 * Salva o periodo no banco de dados.
	 * 
	 * @param periodo
	 *            O periodo a ser salvo.
	 */
	public static void create(Periodo periodo) {
		periodo.save();
	}

	/**
	 * Atualiza o periodo no banco de dados.
	 * 
	 * @param periodoId
	 *            O Id do periodo a ser atualizado.
	 */
	public static void atualizar(String periodoId) {
		find.ref(periodoId).update();
	}
	
	public static void deletar(String periodoId) {
		find.ref(periodoId).delete();
	}
	
	@Override
	public String toString() {
		return "[Periodo " + getNumero() + "]";
	}

}
