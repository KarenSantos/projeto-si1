package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe do plano de curso.
 * 
 * @author
 * 
 */
public class PlanoDeCurso {

	final private int MINIMO_DE_CREDITOS = 14;
	final private int PRIM_PERIODO = 1;
	final private int PERIODO_MAXIMO = 14;

	private List<Periodo> periodos;
	private Curriculo curriculo;
	private List<Disciplina> disciplinasNaoAlocadas;

	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura o primeiro periodo com as
	 * disciplinas obrigatorias.
	 */
	public PlanoDeCurso() {
		// CREATOR, o plano de curso inicializa os objetos abaixo
		periodos = new ArrayList<Periodo>();
		curriculo = new Curriculo();
		disciplinasNaoAlocadas = new ArrayList<Disciplina>();

		configuraPrimeiroPeriodo();

		disciplinasNaoAlocadas.addAll(curriculo.getDisciplinas());
		removeDiscPrimPeriodo();
	}

	/**
	 * Retorna uma lista com todos os períodos criados.
	 * 
	 * @return A lista com todos os períodos criados.
	 */
	public List<Periodo> getPeriodos() {
		return Collections.unmodifiableList(periodos);
	}

	/**
	 * Retorna o periodo indicado como parametro.
	 * 
	 * @param periodo
	 *            O periodo que deve ser retornado.
	 * @return o periodo.
	 */
	public Periodo getPeriodo(int periodo) {
		return periodos.get(periodo - 1);
	}

	/**
	 * Retorna o número de períodos já criados.
	 * 
	 * @return O número de períodos criados.
	 */
	public int getTotalPeriodos() {
		return getPeriodos().size();
	}

	/**
	 * Cria um novo periodo vazio.
	 * 
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero minimo de creditos do periodo anterior nao foi
	 *             alcancado.
	 * @throws AlocacaoInvalidaException
	 *             Se o numero maximo de periodos já foi alcançado.
	 */
	public void createPeriodo() throws TotalDeCreditosInvalidoException,
			AlocacaoInvalidaException {

		int ultimoPeriodo = getTotalPeriodos();
		if (ultimoPeriodo > PRIM_PERIODO) {
			if (getPeriodo(ultimoPeriodo).getTotalDeCreditos() < MINIMO_DE_CREDITOS) {
				throw new TotalDeCreditosInvalidoException(
						"O último período precisa de no mínimo 14 créditos.");
			}
		}
		if (ultimoPeriodo == PERIODO_MAXIMO) {
			throw new AlocacaoInvalidaException(
					"Você já alcançou o número máximo de períodos");
		}

		// CONTROLLER - nova operação de sistema
		// CREATOR - o planejamento de curso eh composto por periodos
		periodos.add(new Periodo(ultimoPeriodo + 1));
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

		/*
		 * INFORMATION EXPERT quem tem os periodos e o curriculo, que tem as
		 * informacoes das disciplinas e seus pre requisitos, é o Plano de curso
		 * então ele faz a verificação.
		 */
		Disciplina aDisciplina = getDisciplina(id);
		if (!aDisciplina.getPreRequisitos().isEmpty()) {
			for (Disciplina preRequisito : aDisciplina.getPreRequisitos()) {
				Boolean result = false;

				for (int i = 0; i < getPeriodos().size() - 1; i++) {
					if (periodos.get(i).getDisciplinas().contains(preRequisito)) {
						result = true;
						break;
					}
				}
				if (result == false) {
					throw new AlocacaoInvalidaException(
							"Esta disciplina tem pré-requisitos não concluídos.");
				}
			}
		}

		periodos.get(periodo - 1).addDisciplina(curriculo.getDisciplina(id));
		disciplinasNaoAlocadas.remove(curriculo.getDisciplina(id));
	}

	/**
	 * Retorna a disciplina com o id indicado.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @return A disciplina com o id indicado.
	 */
	public Disciplina getDisciplina(String id) {
		return curriculo.getDisciplina(id);
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
	public void removeDisciplinaPeriodo(String id, int periodo)
			throws AlocacaoInvalidaException {

		/*
		 * INFORMATION EXPERT quem tem os periodos e as disciplinas em cada
		 * período pode remover alguma disciplina verificando corretamente as
		 * disciplinas que vao ser afetadas pelos pre-requisitos.
		 */
		if (getDisciplina(id).getPeriodoSugerido() == 1) {
			throw new AlocacaoInvalidaException(
					"Disciplinas do primeiro período são obrigatórias.");
		}

		Disciplina aDisciplina = curriculo.getDisciplina(id);

		Map<Disciplina, Integer> aRemover = new HashMap<Disciplina, Integer>();
		identificaDependentes(aDisciplina, periodo, aRemover);

		for (Map.Entry<Disciplina, Integer> entry : aRemover.entrySet()) {
			getPeriodo(entry.getValue()).removeDisciplina(entry.getKey());
			disciplinasNaoAlocadas.add(entry.getKey());
		}

		getPeriodo(periodo).removeDisciplina(aDisciplina);
		disciplinasNaoAlocadas.add(aDisciplina);

	}

	/**
	 * Retorna a lista das Disciplinas nao alocadas.
	 * 
	 * @return Uma lista com as Disciplinas nao alocadas.
	 */
	public List<Disciplina> getDisciplinasNaoAlocadas() {
		return Collections.unmodifiableList(disciplinasNaoAlocadas);
	}

	/**
	 * Verifica se há algum período sem disciplinas e remove-o da lista de
	 * períodos.
	 */
	public void removePeriodosVazios() {
		for (int i = 0; i < periodos.size(); i++) {
			int periodo = i + 1;
			if (getPeriodo(periodo).getTotalDeDisciplinas() == 0) {
				renumeraPeriodos(periodo + 1);
				periodos.remove(i);
			}
		}
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
		boolean resp = false;

		Map<Disciplina, Integer> dependentes = new HashMap<Disciplina, Integer>();
		identificaDependentes(disc, periodo, dependentes);

		if (!dependentes.isEmpty()) {
			resp = true;
		}
		return resp;
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
		boolean resp = false;
		if (!disc.getPreRequisitos().isEmpty()){
			for (Disciplina pre : disc.getPreRequisitos()){
				for (Disciplina discNaoAlocada : disciplinasNaoAlocadas){
					if (pre.equals(discNaoAlocada)) {
						resp = true;
						break;
					}
				}
			}
		}
		return resp;
	}

	/**
	 * Deleta um periodo da lista de periodos com todas as suas disciplinas.
	 * 
	 * @param periodo
	 *            O periodo que vai ser deletado.
	 * @throws AlocacaoInvalidaException
	 *             Se o período a ser deletado for o primeiro período.
	 */
	public void deletarPeriodo(int periodo) throws AlocacaoInvalidaException {

		if (periodo == 1) {
			throw new AlocacaoInvalidaException(
					"Disciplinas do primeiro período são obrigatórias.");
		}

		while (getPeriodo(periodo).getTotalDeDisciplinas() != 0) {
			Disciplina disc = getPeriodo(periodo).getDisciplinas().get(0);
			removeDisciplinaPeriodo(disc.getId(), periodo);
		}
		renumeraPeriodos(periodo + 1);
		periodos.remove(getPeriodo(periodo));
	}

	/**
	 * Renumera os periodos acima do periodo que vai ser deletado.
	 * 
	 * @param periodo
	 *            O periodo que vai ser renumerado.
	 */
	private void renumeraPeriodos(int periodo) {
		if (periodo < getTotalPeriodos() + 1) {
			try {
				getPeriodo(periodo).setNumero(periodo - 1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			renumeraPeriodos(periodo + 1);
		}
	}

	/**
	 * Identifica as disciplinas que tem esta disciplina como pre requisito nos
	 * periodos acima desta.
	 * 
	 * @param disciplina
	 *            A disciplina que é pre-requisito.
	 * @param periodoAcima
	 *            O periodo acima do periodo da disciplina.
	 * @param dependentes
	 *            A lista de disciplinas tem esta disciplina como pre-requisito.
	 */
	private void identificaDependentes(Disciplina disciplina, int periodoAcima,
			Map<Disciplina, Integer> dependentes) {
		periodoAcima++;
		if (getPeriodos().size() >= periodoAcima) {

			for (Disciplina disciplinaAcima : getPeriodo(periodoAcima)
					.getDisciplinas()) {

				for (Disciplina preRequito : disciplinaAcima.getPreRequisitos()) {

					if (disciplina.equals(preRequito)) {
						dependentes.put(disciplinaAcima, periodoAcima);
						identificaDependentes(disciplinaAcima, periodoAcima,
								dependentes);
					}
				}
			}
		}
	}

	/**
	 * Cria o primeiro periodo e aloca suas disciplinas que sao imutaveis.
	 */
	private void configuraPrimeiroPeriodo() {

		try {
			createPeriodo();
		} catch (Exception e) {
		}

		try {
			addDisciplinaPeriodo("01", 1);
			addDisciplinaPeriodo("02", 1);
			addDisciplinaPeriodo("03", 1);
			addDisciplinaPeriodo("04", 1);
			addDisciplinaPeriodo("05", 1);
			addDisciplinaPeriodo("06", 1);
		} catch (Exception e) {
		}
	}

	private void removeDiscPrimPeriodo() {

		disciplinasNaoAlocadas.remove(getDisciplina("01"));
		disciplinasNaoAlocadas.remove(getDisciplina("02"));
		disciplinasNaoAlocadas.remove(getDisciplina("03"));
		disciplinasNaoAlocadas.remove(getDisciplina("04"));
		disciplinasNaoAlocadas.remove(getDisciplina("05"));
		disciplinasNaoAlocadas.remove(getDisciplina("06"));
	}

}
