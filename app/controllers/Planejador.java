package controllers;

import java.util.List;

import models.AlocacaoInvalidaException;
import models.Disciplina;
import models.Periodo;
import models.PlanoDeCurso;
import models.TotalDeCreditosInvalidoException;

/**
 * Controlador do Plano de Curso.
 * 
 * @author
 * 
 */
public class Planejador {

	private PlanoDeCurso plano;

	public Planejador() {
		plano = new PlanoDeCurso();
	}

	/**
	 * Retorna uma lista com todos os períodos criados no plano de curso.
	 * 
	 * @return A lista com todos os períodos criados.
	 */
	public List<Periodo> getPeriodos() {
		return plano.getPeriodos();
	}

	/**
	 * Retorna o periodo indicado como parametro.
	 * 
	 * @param periodo
	 *            O periodo que deve ser retornado.
	 * @return o periodo.
	 */
	public Periodo getPeriodo(int periodo) {
		return plano.getPeriodo(periodo);
	}

	/**
	 * Cria um novo periodo vazio.
	 * 
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero minimo de creditos do periodo anterior nao foi
	 *             alcancado.
	 * @throws AlocacaoInvalidaException
	 *             Se o número máximo de períodos já foi alcançado.
	 */
	public void createPeriodo() throws TotalDeCreditosInvalidoException,
			AlocacaoInvalidaException {
		plano.createPeriodo();
	}

	/**
	 * Adiciona uma disciplina a um periodo.
	 * 
	 * @param id
	 *            O id da disciplina a ser adicionada.
	 * @param periodo
	 *            O periodo em que vai ser adicionada a disciplina.
	 * @throws AlocacaoInvalidaException
	 *             Caso a disciplina que vai ser adicionada tenha pre requisitos
	 *             que ainda nao foram alocados.
	 * @throws TotalDeCreditosInvalidoException
	 *             Caso o periodo ja tenha o total maximo de creditos alocado.
	 */
	public void addDisciplinaPeriodo(String id, int periodo)
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		plano.addDisciplinaPeriodo(id, periodo);
	}

	/**
	 * Retorna a disciplina com o id indicado.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @return A disciplina com o id indicado.
	 */
	public Disciplina getDisciplina(String id) {
		return plano.getDisciplina(id);
	}

	/**
	 * Remove uma disciplina de um periodo.
	 * 
	 * @param id
	 *            O id da disciplina a ser removida.
	 * @param periodo
	 *            O periodo de onde vai ser removida a disciplina.
	 * @throws AlocacaoInvalidaException
	 *             Se a disciplina a ser removida for do primeiro periodo.
	 */
	public void removeDisciplinaPeriodo(String discId, int periodo)
			throws AlocacaoInvalidaException {
		plano.removeDisciplinaPeriodo(discId, periodo);
	}

	/**
	 * Retorna a lista das Disciplinas nao alocadas.
	 * 
	 * @return Uma lista com as Disciplinas nao alocadas.
	 */
	public List<Disciplina> getDisciplinasNaoAlocadas() {
		return plano.getDisciplinasNaoAlocadas();
	}

	/**
	 * Remove periodos da lista de periodos que não tem disciplinas.
	 */
	public void removePeriodosVazios() {
		plano.removePeriodosVazios();
	}

	/**
	 * Deleta um periodo da lista de periodos.
	 * 
	 * @param periodo
	 *            O período que vai ser deletado.
	 * @throws AlocacaoInvalidaException
	 *             Se o período a ser deletado for o primeiro período.
	 */
	public void deletarPeriodo(int periodo) throws AlocacaoInvalidaException {
		plano.deletarPeriodo(periodo);
	}

	/**
	 * Diz se uma disciplina é pre-requisito de outra disciplina já alocada.
	 * 
	 * @param disc
	 *            A disciplina que pode ser pre-requisito ou nao de outra já
	 *            alocada.
	 * @return True se a disciplina é pre-requisito e false se não é.
	 */
	public boolean ehPreRequisito(Disciplina disc, int periodo) {
		return plano.ehPreRequisito(disc, periodo);
	}
	
	/**
	 * Diz se uma disciplina tem um pre-requisito que ainda não foi alocado.
	 * 
	 * @param disc
	 *            A disciplina que pode ter um pre-requisito não alocado.
	 * @param periodo
	 *            O periodo da disciplina.
	 * @return True se a disciplina tem pre-requisito não alocado e false se não
	 *         tem.
	 */
	public boolean temPreRequisito(Disciplina disc) {
		return plano.temPreRequisito(disc);
	}

}
