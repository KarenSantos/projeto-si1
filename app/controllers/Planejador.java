package controllers;

import java.util.List;

import exceptions.AlocacaoInvalidaException;
import exceptions.TotalDeCreditosInvalidoException;
import play.db.ebean.*;
import models.Disciplina;
import models.Periodo;
import models.PlanoDeCurso;

/**
 * Controlador do Plano de Curso.
 * 
 * @author
 * 
 */
public class Planejador {

	private PlanoDeCurso plano;

	// public static Finder<String, PlanoDeCurso> find = new
	// Finder(String.class, PlanoDeCurso.class);

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
	public void createPeriodo(String id) throws AlocacaoInvalidaException {
		plano.createPeriodo(id);
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
	 *             Caso adicionando a disciplina o periodo ultrapasse o maximo
	 *             de creditos.
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
	 * Retorna em qual periodo está a disciplina.
	 * 
	 * @param disc
	 *            A disciplina que se quer saber em que periodo está.
	 * @return O número do periodo em que está a disciplina ou zero se não está
	 *         em nenhum periodo.
	 */
	public int getPeriodoDaDisciplina(String discId) {
		return plano.getPeriodoDaDisciplina(getDisciplina(discId));
	}

	/**
	 * Remove uma disciplina de um periodo.
	 * 
	 * @param id
	 *            O id da disciplina a ser removida.
	 * @param periodo
	 *            O periodo de onde vai ser removida a disciplina.
	 */
	public void removeDisciplinaPeriodo(String discId, int periodo) {
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
	 * Deleta o ultimo periodo criado se nao for um dos 8 periodos base
	 * e se estiver sem disciplinas.
	 */
	public void deletaUltimoPeriodoSeVazio(){
		plano.deletaUltimoPeriodoSeVazio();
	}

	/**
	 * Retorna o total de períodos criados.
	 * 
	 * @return O total de períodos.
	 */
	public int getTotalDePeriodos() {
		return plano.getTotalDePeriodos();
	}

	/**
	 * Move uma disciplina de um periodo para outro.
	 * 
	 * @param disciplinaId
	 *            A disciplina que vai ser movida.
	 * @param periodoFuturu
	 *            O periodo para onde vai ser movida a disciplina.
	 * @param periodoAtual
	 *            O periodo onde está a disciplina que vai ser movida.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o total de créditos fosse ultrapassar 28 ao mover a
	 *             disciplina.
	 */
	public void moveDisciplina(String disciplinaId, int periodoFuturo,
			int periodoAtual) throws TotalDeCreditosInvalidoException {
		plano.moveDisciplina(disciplinaId, periodoFuturo, periodoAtual);
	}

	/**
	 * Diz se uma disciplina é pre-requisito de outra disciplina já alocada.
	 * 
	 * @param discId
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
	public boolean temPreRequisitoNaoAlocado(Disciplina disc) {
		return plano.temPreRequisitoNaoAlocado(disc);
	}

	/**
	 * Inverte a ordem da lista dos periodos. Se está crescente fica
	 * decrescente, se está decrescente fica crescente.
	 */
	public void inverteOrdemDosPeriodos() {
		plano.inverteOrdemDosPeriodos();
	}

	/**
	 * Indica se os periodos estão em ordem invertida ou nao.
	 * 
	 * @return True se os periodos estao invertidos e false caso contrario.
	 */
	public boolean isInvertido() {
		return plano.isInvertido();
	}

	/**
	 * Retorna se uma disciplina é uma optativa generica.
	 * 
	 * @param disc
	 *            A disciplina que se quer saber se é optativa generica ou nao.
	 * @return True se a disciplina for uma optativa generica e false caso
	 *         contrario.
	 */
	public boolean ehDisciplinaOptativaGenerica(Disciplina disc) {
		boolean resp = false;
		if (plano.getDisciplinasOptativasGenericas().contains(disc)) {
			resp = true;
		}
		return resp;
	}

}
