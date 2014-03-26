package controllers;

import java.util.ArrayList;
import java.util.List;

import models.AlocacaoInvalidaException;
import models.Disciplina;
import models.Grade;
import models.Periodo;
import models.PlanoDeCurso;
import models.TotalDeCreditosInvalidoException;
import models.Usuario;

/**
 * Controlador do Plano de Curso.
 * 
 * @author
 * 
 */
public class Planejador {

	private PlanoDeCurso plano;
	private Usuario usuario;

	/**
	 * Cria um planejador que recebe um id como usuário.
	 * 
	 * @param id
	 *            O id para identificar o usuário.
	 */
	public Planejador(Usuario usuario) {
		this.usuario = usuario;

		plano = PlanoDeCurso.find.byId("p_" + usuario.getEmail());
		if (plano == null) {
			Grade grade = new Grade();
			plano = new PlanoDeCurso("p_" + usuario.getEmail(), grade);
			plano.reset();
			plano.save();
		} else {
			plano.setGrade(new Grade());
			plano.save();
		}
	}

	/**
	 * Retorna o usuario da seção atual.
	 * 
	 * @return O usuario da secão atual.
	 */
	public Usuario getUsuario() {
		return this.usuario;
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
	public void createPeriodo() throws AlocacaoInvalidaException,
			TotalDeCreditosInvalidoException {
		plano.createPeriodo();
		plano.update();
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
	 * Retorna todas as disciplinas do plano de curso.
	 * 
	 * @return A lista com todas as disciplinas do plano de curso.
	 */
	public List<Disciplina> getDisciplinas() {
		return plano.getDisciplinas();
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
	 * Retorna a lista das Disciplinas nao alocadas.
	 * 
	 * @return Uma lista com as Disciplinas nao alocadas.
	 */
	public List<Disciplina> getDisciplinasNaoAlocadas() {
		return plano.getDisciplinasNaoAlocadas();
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
	 * Retorna o numero do periodo atual do plano de curso.
	 * 
	 * @return O numero do periodo atual do plano de curso.
	 */
	public int getNumPeriodoAtual() {
		return plano.getNumPeriodoAtual();
	}

	/**
	 * Altera o periodo atual do plano do curso pelo numero.
	 * 
	 * @param numPeriodo
	 *            O numero do novo periodo atual do plano de curso.
	 */
	public void setPeriodoAtual(int numPeriodo) {
		plano.setPeriodoAtual(numPeriodo);
		plano.update();
	}

	/**
	 * Configura novamente o periodo atual como sendo o periodo atual guardado
	 * no BD.
	 */
	public void reSetPeriodoAtual() {
		plano.reSetPeriodoAtual();
	}

	/**
	 * Retorna o total de creditos dos periodos anteriores ao atual.
	 * 
	 * @return O total de creditos dos periodos anteriores ao atual.
	 */
	public int getTotalDeCreditosCursados() {
		return plano.getTotalDeCreditosCursados();
	}

	/**
	 * Retorna o total de creditos de todos os periodos.
	 * 
	 * @return O total de creditos de todos os periodos.
	 */
	public int getTotalDeCreditos() {
		return plano.getTotalDeCreditos();
	}

	/**
	 * Retorna o minimo de creditos necessarios para concluir o curso.
	 * 
	 * @return O minimo de creditos necessarios para concluir o curso.
	 */
	public int getMinimoDeCreditosDoCurso() {
		return plano.getMinimoDeCreditosDoCurso();
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
	 *             Se o numero total de creditos ficar acima do maximo de
	 *             creditos permitido neste periodo.
	 */
	public void addDisciplinaPeriodo(String id, int periodo)
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {
		plano.addDisciplinaPeriodo(id, periodo);
		plano.update();
	}

	/**
	 * Remove uma disciplina de um periodo.
	 * 
	 * @param id
	 *            O id da disciplina a ser removida.
	 * @param periodo
	 *            O periodo de onde vai ser removida a disciplina.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero total de creditos ficar abaixo do maximo de
	 *             creditos permitido neste periodo.
	 */
	public void removeDisciplinaPeriodo(String discId, int periodo)
			throws TotalDeCreditosInvalidoException {
		plano.removeDisciplinaPeriodo(discId, periodo);
		plano.update();
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
		plano.update();
	}

	/**
	 * Deleta o ultimo periodo criado se nao for um dos 8 periodos base e se
	 * estiver sem disciplinas.
	 */
	public void deletaUltimoPeriodoSeVazio() {
		plano.deletaUltimoPeriodoSeVazio();
		plano.update();
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
	 * Verifica se uma disciplina tem algum pre-requisito que ainda não foi
	 * alocado.
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
	 * Verifica se uma disciplina tem todos os seus pre requisitos alocados em
	 * periodos anteriores.
	 * 
	 * @param disc
	 *            A disciplina que se quer verificar.
	 * @param periodo
	 *            O numero do periodo da disciplina.
	 * @return True se todos os seus pre-requisitos estao alocados anteriormente
	 *         e false caso contrario.
	 */
	public boolean temPreRequisitosEmPeriodosAnteriores(Disciplina disc,
			int periodo) {
		return plano.temPreRequisitosEmPeriodosAnteriores(disc, periodo);
	}

	/**
	 * Retorna uma lista de todas as disciplinas que sao pre-requisitos desta
	 * que estao alocadas em periodos a frente.
	 * 
	 * @param disc
	 *            A disciplina que se quer verificar os pre-requisitos.
	 * @param periodo
	 *            O numero do periodo da disciplina.
	 * @return A lista dos pre-requisitos alocados a frente.
	 */
	public List<Disciplina> getPreRequisitosAlocadosEmPeriodosPosteriores(
			Disciplina disc, int periodo) {
		return plano.getPreRequisitosAlocadosEmPeriodosPosteriores(disc,
				periodo);
	}

	/**
	 * Inverte a ordem da lista dos periodos ficando com ordem decrescente.
	 */
	public void inverteOrdemDosPeriodos() {
		plano.inverteOrdemDosPeriodos();
		plano.update();
	}

	/**
	 * Ordena lista dos periodos pelo numero ficando em ordem crescente.
	 */
	public void ordenarPeriodos() {
		plano.ordenarPeriodos();
		plano.update();
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
