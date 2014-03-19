package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
	private final int MAXIMO_DE_CREDITOS = 28;
	private final int MINIMO_DE_CREDITOS = 14;
	private final int MENOR_NUM_PERIODO = 1;
	private final int MAIOR_NUM_PERIODO = 14;

	@Id
	private String id;

	private int numero;
	private int totalDeCreditos;
	private int totalDeDificuldade;

	@ManyToMany
	private List<Disciplina> disciplinas;

	private ValidadorDeAlocacao validador;

	public static Finder<String, Periodo> find = new Finder<String, Periodo>(
			String.class, Periodo.class);

	/**
	 * Cria um periodo sem id e sem numero.
	 */
	public Periodo() {
	}

	/**
	 * Um periodo contem uma lista de disciplinas e o total de creditos do
	 * periodo.
	 */
	public Periodo(String id, int numero) {
		this.id = id;
		this.numero = numero;
		disciplinas = new ArrayList<Disciplina>();
		totalDeCreditos = 0;
		setValidadorDeAlocacao(new TemMinimoDeCreditos());
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
		return this.numero;
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
	 * Retorna a lista de disciplinas do periodo.
	 * 
	 * @return A lista de disciplinas do periodo.
	 */
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * Recupera o tipo de validador de alocacao do periodo.
	 * 
	 * @return O validador de alocacao do periodo.
	 */
	public ValidadorDeAlocacao getValidadorDeAlocacao() {
		return this.validador;
	}

	/**
	 * Altera o tipo de validador de alocacao do periodo.
	 * 
	 * @param validador
	 *            O novo validador de alocacao do periodo.
	 */
	public void setValidadorDeAlocacao(ValidadorDeAlocacao validador) {
		this.validador = validador;
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
	 * Recupera o maximo de creditos possivel no periodo.
	 * 
	 * @return O maximo de creditos possivel no periodo.
	 */
	public int getMaximoDeCreditos() {
		return this.MAXIMO_DE_CREDITOS;
	}

	/**
	 * Retorna o numero minimo de creditos de um periodo.
	 * 
	 * @return O minimo de creditos de um periodo.
	 */
	public int getMinimoDeCreditos() {
		return MINIMO_DE_CREDITOS;
	}

	/**
	 * Retorna se a disciplina pode ser ou nao removida do periodo.
	 * 
	 * @param disciplina
	 *            A disciplina a ser removida.
	 * @return True se pode ser removida ou false caso contrario.
	 */
	public boolean podeRemover(Disciplina disciplina) {
		return validador.podeRemover(this, disciplina);
	}

	/**
	 * Adiciona uma disciplina a lista de disciplinas do periodo.
	 * 
	 * @param disciplina
	 *            A disciplina a ser adicionada.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero total de creditos ficar acima do maximo de
	 *             creditos por periodo.
	 */
	public void addDisciplina(Disciplina disciplina)
			throws TotalDeCreditosInvalidoException {
		if (!validador.podeAdicionar(this, disciplina)) {
			throw new TotalDeCreditosInvalidoException(
					"O número máximo de créditos neste período é 28.");
		}
		disciplinas.add(disciplina);
		this.totalDeCreditos += disciplina.getCreditos();
		this.totalDeDificuldade += disciplina.getDificuldade();
	}

	/**
	 * Remove uma disciplina da lista de disciplinas do periodo.
	 * 
	 * @param disciplina
	 *            A disciplina a ser removida.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero total de creditos ficar abaixo do minimo de
	 *             creditos por periodo.
	 */
	public void removeDisciplina(Disciplina disciplina)
			throws TotalDeCreditosInvalidoException {
		if (!validador.podeRemover(this, disciplina)) {
			throw new TotalDeCreditosInvalidoException(
					"O número mínimo de créditos neste período é 14.");
		}
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
