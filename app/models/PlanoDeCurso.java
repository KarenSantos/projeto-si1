package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import exceptions.AlocacaoInvalidaException;
import exceptions.TotalDeCreditosInvalidoException;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Classe do plano de curso.
 * 
 * @author
 * 
 */
@Entity
public class PlanoDeCurso extends Model {

	private static final long serialVersionUID = 1L;
	final private int PERIODO_MAXIMO = 14;
	private final int MAXIMO_DE_CREDITOS = 28;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private List<Periodo> periodos;
	private Curriculo curriculo;
	private List<Disciplina> disciplinasNaoAlocadas;

//	public static Finder<String, Periodo> findPeriodo = new Finder<String, Periodo>(String.class, Periodo.class);
//	public static Finder<String, Curriculo> findCurriculo = new Finder<String, Curriculo>(String.class, Curriculo.class);

	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura os periodos com as
	 * disciplinas obrigatorias.
	 */
	public PlanoDeCurso() {
		// CREATOR, o plano de curso inicializa os objetos abaixo
		periodos = new ArrayList<Periodo>();

//		if (findCurriculo.ref("SC") == null) {
			curriculo = new Curriculo("SC");
			// curriculo.save();
//		}

		disciplinasNaoAlocadas = new ArrayList<Disciplina>();
		disciplinasNaoAlocadas.addAll(curriculo.getDisciplinas());

		alocaDisciplinas();
	}

	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura os periodos com as
	 * disciplinas obrigatorias.
	 */
	public PlanoDeCurso(String id) {
		this.id = id;
		periodos = new ArrayList<Periodo>();

//		if (findCurriculo.ref("SC") == null) {
			curriculo = new Curriculo("SC");
			// curriculo.save();
//		}

		disciplinasNaoAlocadas = new ArrayList<Disciplina>();
		disciplinasNaoAlocadas.addAll(curriculo.getDisciplinas());

		alocaDisciplinas();
	}

	/**
	 * Retorna o id do plano de curso.
	 * 
	 * @return O id do plano de curso.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Altera o id do plano de curso.
	 * 
	 * @param id
	 *            O novo id do plano de curso.
	 */
	public void setId(String id) {
		this.id = id;
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
	public int getTotalDePeriodos() {
		return getPeriodos().size();
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
	 * Retorna a lista das Disciplinas nao alocadas.
	 * 
	 * @return Uma lista com as Disciplinas nao alocadas.
	 */
	public List<Disciplina> getDisciplinasNaoAlocadas() {
		return Collections.unmodifiableList(disciplinasNaoAlocadas);
	}

	/**
	 * Cria um novo periodo vazio.
	 * 
	 * @throws AlocacaoInvalidaException
	 *             Se o numero maximo de periodos já foi alcançado.
	 */
	public void createPeriodo(String id) throws AlocacaoInvalidaException {

		int ultimoPeriodo = getTotalDePeriodos();

		if (ultimoPeriodo == PERIODO_MAXIMO) {
			throw new AlocacaoInvalidaException(
					"Você já alcançou o número máximo de períodos");
		}

		// CONTROLLER - nova operação de sistema
		// CREATOR - o planejamento de curso eh composto por periodos
		Periodo novoPeriodo = new Periodo(id + ultimoPeriodo + 1, ultimoPeriodo + 1);
		// novoPeriodo.save();
		periodos.add(novoPeriodo);
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
		if (periodo != getTotalDePeriodos()) { // se for o ultimo periodo pode
												// ter mais de 28 creditos
			if ((getPeriodo(periodo).getTotalDeCreditos() + aDisciplina
					.getCreditos()) > MAXIMO_DE_CREDITOS) {
				throw new TotalDeCreditosInvalidoException(
						"O número máximo de créditos por período é 28.");
			}
		}

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

		getPeriodo(periodo).addDisciplina(curriculo.getDisciplina(id));
		disciplinasNaoAlocadas.remove(curriculo.getDisciplina(id));
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
	 * Move uma disciplina de um periodo para outro.
	 * 
	 * @param disciplinaId
	 *            A disciplina que vai ser movida.
	 * @param periodoFuturu
	 *            O periodo para onde vai ser movida a disciplina.
	 * @param periodoAtual
	 *            O periodo onde está a disciplina que vai ser movida.
	 */
	public void moveDisciplina(String disciplinaId, int periodoFuturo,
			int periodoAtual) {
		Disciplina aDisciplina = getDisciplina(disciplinaId);

		getPeriodo(periodoAtual).removeDisciplina(aDisciplina);
		getPeriodo(periodoFuturo).addDisciplina(aDisciplina);
		
		List<Disciplina> temComoPreRequisito = temComoPreRequisito(aDisciplina);
		List<Disciplina> saoPreRequisitos = aDisciplina.getPreRequisitos();

		for (Disciplina temComo : temComoPreRequisito) {
			if (getPeriodoDaDisciplina(aDisciplina) >= getPeriodoDaDisciplina(temComo)) {
				aDisciplina.setNotAlocadaCorretamente();
				break;
			} else {
				aDisciplina.setIsAlocadaCorretamente();
			}
		}
		
		for (Disciplina ehPreRequisito : saoPreRequisitos){
			if (getPeriodoDaDisciplina(ehPreRequisito) >= getPeriodoDaDisciplina(aDisciplina)) {
				ehPreRequisito.setNotAlocadaCorretamente();
			} else {
				ehPreRequisito.setIsAlocadaCorretamente();
			}
		}
		

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
		if (!disc.getPreRequisitos().isEmpty()) {
			for (Disciplina pre : disc.getPreRequisitos()) {
				for (Disciplina discNaoAlocada : disciplinasNaoAlocadas) {
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
	 * Retorna em qual periodo está a disciplina.
	 * 
	 * @param disc
	 *            A disciplina que se quer saber em que periodo está.
	 * @return O número do periodo em que está a disciplina ou zero se não está
	 *         em nenhum periodo.
	 */
	public int getPeriodoDaDisciplina(Disciplina disc) {
		int periodo = 0;
		for (Periodo per : getPeriodos()) {
			if (per.getDisciplinas().contains(disc)) {
				periodo = per.getNumero();
				break;
			}
		}
		return periodo;
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
		if (periodo < getTotalDePeriodos() + 1) {
			try {
				getPeriodo(periodo).setNumero(periodo - 1);
			} catch (Exception e) {
				e.printStackTrace();
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
	 * @param periodo
	 *            O periodo da disciplina.
	 * @param dependentes
	 *            A lista de disciplinas que tem esta disciplina como
	 *            pre-requisito.
	 */
	private void identificaDependentes(Disciplina disciplina, int periodo,
			Map<Disciplina, Integer> dependentes) {
		periodo++;
		if (getPeriodos().size() >= periodo) {

			for (Disciplina disciplinaAcima : getPeriodo(periodo)
					.getDisciplinas()) {

				for (Disciplina preRequito : disciplinaAcima.getPreRequisitos()) {

					if (disciplina.equals(preRequito)) {
						dependentes.put(disciplinaAcima, periodo);
						identificaDependentes(disciplinaAcima, periodo,
								dependentes);
					}
				}
			}
		}
	}

	/**
	 * Retorna uma lista de disciplinas da qual esta é pre-requisito.
	 * 
	 * @param discId
	 *            A disciplina que pode ser pre-requisito ou nao de outras.
	 * @return A lista de disciplinas da qual esta é pre-requisito.
	 */
	private List<Disciplina> temComoPreRequisito(Disciplina aDisciplina) {

		List<Disciplina> resp = new ArrayList<Disciplina>();

		for (Disciplina disc : curriculo.getDisciplinas()) {
			if (disc.getPeriodoSugerido() > aDisciplina.getPeriodoSugerido()) {
				for (Disciplina preRequisito : disc.getPreRequisitos()) {
					if (aDisciplina == preRequisito) {
						resp.add(disc);
					}
				}
			}
		}

		return resp;
	}

	/**
	 * Cria o primeiro periodo e aloca suas disciplinas que sao imutaveis.
	 */
	private void alocaDisciplinas() {

//		if (findPeriodo.findRowCount() == 0) {

			for (Disciplina disc : curriculo.getDisciplinas()) {
				int periodo = disc.getPeriodoSugerido();
				if (periodo > 0) {
					if (getTotalDePeriodos() < periodo) {
						try {
							createPeriodo("Usuario" + periodo);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					try {
						addDisciplinaPeriodo(disc.getId(), periodo);
						disciplinasNaoAlocadas.remove(disc);
					} catch (AlocacaoInvalidaException e) {
						e.printStackTrace();
					} catch (TotalDeCreditosInvalidoException e) {
						e.printStackTrace();
					}
				}
			}
//		}
	}
}