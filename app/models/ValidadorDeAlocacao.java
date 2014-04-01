package models;

import java.util.*;

/**
 * Interface de validação de alocação de disciplinas em periodos.
 * 
 * @author
 * 
 */
public interface ValidadorDeAlocacao {

	/**
	 * Indica se uma disciplina pode ser removida de um periodo.
	 * 
	 * @param periodo
	 *            O periodo de onde se vai remover a disciplina.
	 * @param disciplina
	 *            A disciplina a ser removida do periodo.
	 * @return True se a disciplina pode ser removida ou false caso contrario.
	 */
	public boolean podeRemover(Periodo periodo, Disciplina disciplina);

	/**
	 * Indica se varias disciplinas podem ser removidas de um unico periodo.
	 * 
	 * @param periodo
	 *            O periodo de onde se vai remover as disciplinas.
	 * @param disciplinas
	 *            A lista de disciplinas a serem removidas do periodo.
	 * @return True se as disciplinas podem ser removida ou false caso
	 *         contrario.
	 */
	public boolean podeRemoverVarias(Periodo periodo,
			List<Disciplina> disciplinas);

	/**
	 * Indica se uma disciplina pode ser adicionada em um periodo.
	 * 
	 * @param periodo
	 *            O periodo onde se vai adicionar a disciplina.
	 * @param disciplina
	 *            A disciplina a ser adicionada no periodo.
	 * @return True se a disciplina pode ser adicionada ou false caso contrario.
	 */
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina);

}
