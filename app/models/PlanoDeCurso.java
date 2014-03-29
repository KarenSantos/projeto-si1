package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

/**
 * Classe do plano de curso.
 * 
 * @author
 * 
 */
@Entity
public class PlanoDeCurso extends Model {

	private static final long serialVersionUID = 1L;

	private final int PERIODOS_BASE = 8;
	private final int PERIODO_MAXIMO = 14;
	private final int PRIMEIRO_PERIODO = 1;
	private final int MINIMI_DE_CREDITOS_DO_CURSO = 208;

	@Id
	private String id;

	@ManyToOne
	private Grade grade;

	@ManyToMany
	@JoinTable(name = "plano_disc_nao_alocadas", joinColumns = @JoinColumn(name = "plano"), inverseJoinColumns = @JoinColumn(name = "disciplina"))
	private List<Disciplina> disciplinasNaoAlocadas;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "plano_periodos", joinColumns = @JoinColumn(name = "plano"), inverseJoinColumns = @JoinColumn(name = "periodo"))
	private List<Periodo> periodos;

	private int periodoAtual;

	public static Finder<String, PlanoDeCurso> find = new Finder<String, PlanoDeCurso>(
			String.class, PlanoDeCurso.class);

	public PlanoDeCurso() {
	}

	/**
	 * Plano de curso recebe uma grade de disciplinas e um usuario, e tem uma
	 * lista de periodos e uma lista de disciplinas não alocadas.
	 */
	public PlanoDeCurso(String id, Grade grade) {
		this.id = id;
		this.grade = grade;
		this.periodos = new ArrayList<Periodo>();
		this.disciplinasNaoAlocadas = new ArrayList<Disciplina>();

		this.periodos.addAll(grade.getPeriodos());
		this.disciplinasNaoAlocadas.addAll(grade.getDisciplinasOptativas());
		setPeriodoAtual(PRIMEIRO_PERIODO);
	}

	/**
	 * Salva um plano no BD.
	 * 
	 * @param plano
	 */
	public static void create(PlanoDeCurso plano) {
		plano.save();
	}

	/**
	 * Reseta o plano e volta ao formato inicial de periodos e disciplinas.
	 */
	public void reset() {
		this.periodos.clear();
		this.disciplinasNaoAlocadas.clear();

		this.periodos.addAll(grade.getPeriodos());
		this.disciplinasNaoAlocadas.addAll(grade.getDisciplinasOptativas());
		setPeriodoAtual(PRIMEIRO_PERIODO);
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
	 * Altera a grade do plano de curso.
	 * 
	 * @param grade
	 *            A nova grade do plano de curso.
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * Recupera a grade do plano de curso.
	 * 
	 * @return A grade do plano de curso.
	 */
	public Grade getGrade() {
		return this.grade;
	}

	/**
	 * Retorna uma disciplina pelo seu id.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @return A disciplina que tem o id.
	 */
	public Disciplina getDisciplina(String id) {
		return grade.getDisciplina(id);
	}

	/**
	 * Retorna todas as disciplinas do grade do plano de curso.
	 * 
	 * @return A lista com todas as disciplinas da grade do plano de curso.
	 */
	public List<Disciplina> getDisciplinas() {
		return grade.getDisciplinas();
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
	 * Retorna o numero do periodo da disciplina alocada na grade do curso.
	 * 
	 * @param disc
	 *            A disciplina que se quer saber o periodo.
	 * @return O numero do periodo desta disciplina na grade do curso.
	 */
	public int getPeriodoDaDisciplinaNaGrade(Disciplina disc) {
		return grade.getPeriodoDaDisciplina(disc);
	}

	/**
	 * /** Retorna a lista das Disciplinas nao alocadas.
	 * 
	 * @return Uma lista com as Disciplinas nao alocadas.
	 */
	public List<Disciplina> getDisciplinasNaoAlocadas() {
		return Collections.unmodifiableList(disciplinasNaoAlocadas);
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
	 * Retorna o periodo indicado como parametro ou null se ele nao existir.
	 * 
	 * @param periodo
	 *            O número do periodo que deve ser retornado.
	 * @return o periodo.
	 */
	public Periodo getPeriodo(int periodo) {
		Periodo oPeriodo = null;
		for (Periodo per : getPeriodos()) {
			if (per.getNumero() == periodo)
				oPeriodo = per;
		}
		return oPeriodo;
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
	 * Retorna o numero do periodo cursado atualmente no plano de curso.
	 * 
	 * @return O numero do periodo atual.
	 */
	public int getNumPeriodoAtual() {
		return this.periodoAtual;
	}

	/**
	 * Altera o periodo atual do plano de curso pelo numero.
	 * 
	 * @param numPeriodo
	 *            O numero do novo periodo atual.
	 */
	public void setPeriodoAtual(int numPeriodo) {
		this.periodoAtual = numPeriodo;
		for (int j = 1; j < numPeriodo; j++) {
			Periodo periodoConcluido = getPeriodo(j);
			periodoConcluido.setValidadorDeAlocacao(new TemMaximoDeCreditos());
		}
		for (int i = numPeriodo; i < getTotalDePeriodos(); i++) {
			Periodo periodoFuturo = getPeriodo(i);
			periodoFuturo
					.setValidadorDeAlocacao(new TemMinimoEMaximoDeCreditos());
		}
		getPeriodo(getTotalDePeriodos()).setValidadorDeAlocacao(
				new TemMinimoDeCreditos());
	}

	/**
	 * Configura novamente o periodo atual como sendo o periodo atual guardado
	 * no BD.
	 */
	public void reSetPeriodoAtual() {
		setPeriodoAtual(getNumPeriodoAtual());
	}

	/**
	 * Retorna o minimo de creditos necessarios para concluir o curso.
	 * 
	 * @return O minimo de creditos necessarios para concluir o curso.
	 */
	public int getMinimoDeCreditosDoCurso() {
		return MINIMI_DE_CREDITOS_DO_CURSO;
	}

	/**
	 * Cria um novo periodo vazio.
	 * 
	 * @throws AlocacaoInvalidaException
	 *             Se o numero maximo de periodos já foi alcançado.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o ultimo periodo tem mais creditos que o maximo de
	 *             creditos padrão.
	 */
	public void createPeriodo() throws AlocacaoInvalidaException,
			TotalDeCreditosInvalidoException {

		int ultimoPeriodo = getTotalDePeriodos();

		if (ultimoPeriodo == PERIODO_MAXIMO) {
			throw new AlocacaoInvalidaException(
					"Você já alcançou o número máximo de períodos");
		}
		if (ultimoPeriodo > PERIODOS_BASE) { // se eh um periodo acima dos
												// periodos normais
			if (getPeriodo(ultimoPeriodo).getTotalDeCreditos() > getPeriodo(
					ultimoPeriodo).getMaximoDeCreditos()
					|| getPeriodo(ultimoPeriodo).getTotalDeCreditos() < getPeriodo(
							ultimoPeriodo).getMinimoDeCreditos()) {
				throw new TotalDeCreditosInvalidoException(
						"Numero de creditos do ultimo periodo impede criaçao de um novo.");
			}
		}

		int novoNumero = ultimoPeriodo + 1;
		Periodo novoPeriodo = new Periodo(this.id + novoNumero, novoNumero);
		novoPeriodo.save();

		if (isInvertido()) {
			periodos.add(0, novoPeriodo);
		} else {
			periodos.add(novoPeriodo);
		}
	}

	/**
	 * Retorna a lista das disciplinas optativas genericas.
	 * 
	 * @return A lista das disciplinas optativas genericas.
	 */
	public List<Disciplina> getDisciplinasOptativasGenericas() {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Disciplina disc : grade.getDisciplinas()) {
			if (disc.getNome().contains("Optativa")) {
				disciplinas.add(disc);
			}
		}
		return disciplinas;
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

		Disciplina aDisciplina = getDisciplina(id);

		// checando se tem pre-requisitos nao alocados nos periodos anteriores
		if (!aDisciplina.getPreRequisitos().isEmpty()) {
			for (Disciplina preRequisito : aDisciplina.getPreRequisitos()) {
				Boolean result = false;

				for (int i = 1; i < periodo; i++) {
					if (getPeriodo(i).getDisciplinas().contains(preRequisito)) {
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

		getPeriodo(periodo).addDisciplina(aDisciplina);
		disciplinasNaoAlocadas.remove(aDisciplina);
	}

	/**
	 * Remove uma disciplina de um periodo.
	 * 
	 * @param id
	 *            O id da disciplina a ser removida.
	 * @param periodo
	 *            O periodo de onde vai ser removida a disciplina.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o numero total de creditos ficar abaixo do minimo de
	 *             creditos permitido neste periodo.
	 */
	public void removeDisciplinaPeriodo(String id, int periodo)
			throws TotalDeCreditosInvalidoException {

		Disciplina aDisciplina = getDisciplina(id);
		Periodo oPeriodo = getPeriodo(periodo);

		Map<Integer, List<Disciplina>> aRemover = new HashMap<Integer, List<Disciplina>>();
		identificaDependentes(aDisciplina, periodo, aRemover);

		if (!oPeriodo.podeRemover(aDisciplina)) {
			throw new TotalDeCreditosInvalidoException(
					"O número mínimo de créditos neste período é 14.");
		}

		verificaRemocaoDeDependentes(aRemover);

		oPeriodo.removeDisciplina(aDisciplina);
		for (Integer key : aRemover.keySet()) {
			for (Disciplina secundaria : aRemover.get(key)) {
				getPeriodo(key).removeDisciplina(secundaria);
				disciplinasNaoAlocadas.add(secundaria);
			}
		}
		if (!getDisciplinasOptativasGenericas().contains(aDisciplina)) {
			disciplinasNaoAlocadas.add(aDisciplina);
		}

	}

	/**
	 * Move uma disciplina de um periodo para outro.
	 * 
	 * @param disciplinaId
	 *            A disciplina que vai ser movida.
	 * @param periodoFuturo
	 *            O periodo para onde vai ser movida a disciplina.
	 * @param periodoAtual
	 *            O periodo onde está a disciplina que vai ser movida.
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o total de créditos fosse ultrapassar 28 ao mover a
	 *             disciplina.
	 */
	public void moveDisciplina(String disciplinaId, int periodoFuturo,
			int periodoAtual) throws TotalDeCreditosInvalidoException {

		Disciplina aDisciplina = getDisciplina(disciplinaId);

		// se ela nao é uma optativa generica podemos mover
		if (!getDisciplinasOptativasGenericas().contains(aDisciplina)) {

			Periodo oPeriodo = getPeriodo(periodoFuturo);
			Periodo perAtual = getPeriodo(periodoAtual);

			if (!perAtual.podeRemover(aDisciplina)) {
				throw new TotalDeCreditosInvalidoException(
						"Esta disciplina não pode sair do seu periodo atual pois o mínimo de créditos do período seria violado.");
			}

			oPeriodo.addDisciplina(aDisciplina); // pode lancar excecao
			perAtual.removeDisciplina(aDisciplina);
		}
	}

	/**
	 * Deleta o ultimo periodo criado se nao for um dos 8 periodos base e se
	 * estiver sem disciplinas.
	 */
	public void deletaUltimoPeriodoSeVazio() {

		if (getTotalDePeriodos() > PERIODOS_BASE) {
			int ultimoPeriodo = getTotalDePeriodos();
			if (getPeriodo(ultimoPeriodo).getTotalDeDisciplinas() == 0) {
				Periodo oPeriodo = getPeriodo(ultimoPeriodo);
				periodos.remove(oPeriodo);
				this.update();
				Periodo.deletar(oPeriodo.getId());
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

		Map<Integer, List<Disciplina>> dependentes = new HashMap<Integer, List<Disciplina>>();
		identificaDependentes(disc, periodo, dependentes);

		if (!dependentes.isEmpty()) {
			resp = true;
		}
		return resp;
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
		boolean resp = true;
		if (!disc.getPreRequisitos().isEmpty()) {
			for (Disciplina pre : disc.getPreRequisitos()) {
				resp = false;
				for (int i = 1; i < periodo; i++) {
					if (getPeriodo(i).getDisciplinas().contains(pre)) {
						resp = true;
					}
				}
				if (resp == false)
					break;
			}
		}
		return resp;
	}

	/**
	 * Verifica se a disciplina eh uma disciplina optativa do TECC.
	 * 
	 * @param disc
	 *            A disciplina que se quer verificar.
	 * @return True se a disciplina for optativa TECC ou false caso contrario.
	 */
	public boolean ehOptativaTECC(Disciplina disc) {
		return grade.ehOptativaTECC(disc);
	}

	/**
	 * Verifica se a disciplina eh uma disciplina optativa de outros cursos.
	 * 
	 * @param disc
	 *            A disciplina que se quer verificar.
	 * @return True se a disciplina for optativa de outros cursos ou false caso
	 *         contrario.
	 */
	public boolean ehOptativaDeOutrosCursos(Disciplina disc) {
		return grade.ehOptativaDeOutrosCursos(disc);
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
		List<Disciplina> preRequisitos = new ArrayList<Disciplina>();

		if (!disc.getPreRequisitos().isEmpty()) {
			for (Disciplina pre : disc.getPreRequisitos()) {
				for (int i = periodo; i < getTotalDePeriodos(); i++) {
					if (getPeriodo(i).getDisciplinas().contains(pre)) {
						preRequisitos.add(pre);
						break;
					}
				}
			}
		}
		return preRequisitos;
	}

	/**
	 * Inverte a ordem da lista dos periodos ficando decrescente.
	 */
	public void inverteOrdemDosPeriodos() {
		Collections.reverse(this.periodos);
	}

	/**
	 * Ordena a lista de periodos pelo numero do periodo.
	 */
	public void ordenarPeriodos() {
		Collections.sort(this.periodos);
		;
	}

	/**
	 * Indica se os periodos estão em ordem invertida ou nao.
	 * 
	 * @return True se os periodos estao invertidos e false caso contrario.
	 */
	public boolean isInvertido() {
		boolean resp = false;
		if (getTotalDePeriodos() > 0) {
			if (periodos.get(0).getNumero() != 1) {
				resp = true;
			}
		}
		return resp;
	}

	/**
	 * Retorna o total de creditos dos periodos anteriores ao atual.
	 * 
	 * @return O total de creditos dos periodos anteriores ao atual.
	 */
	public int getTotalDeCreditosCursados() {
		int resp = 0;
		for (int i = 1; i < getNumPeriodoAtual(); i++) {
			resp += getPeriodo(i).getTotalDeCreditos();
		}
		return resp;
	}

	/**
	 * Retorna o total de creditos de todos os periodos.
	 * 
	 * @return O total de creditos de todos os periodos.
	 */
	public int getTotalDeCreditos() {
		int resp = 0;
		for (Periodo periodo : getPeriodos()) {
			resp += periodo.getTotalDeCreditos();
		}
		return resp;
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
	 *            pre-requisito e seu respectivo periodo.
	 */
	private void identificaDependentes(Disciplina disciplina, int periodo,
			Map<Integer, List<Disciplina>> dependentes) {
		periodo++;
		if (getPeriodos().size() >= periodo) {

			for (Disciplina disciplinaAcima : getPeriodo(periodo)
					.getDisciplinas()) {

				for (Disciplina preRequito : disciplinaAcima.getPreRequisitos()) {

					if (disciplina.equals(preRequito)) {
						if (dependentes.containsKey(periodo)) {
							boolean contem = false;
							for (Disciplina d : dependentes.get(periodo)) {
								if (d.equals(disciplinaAcima))
									contem = true;
							}
							if (!contem)
								dependentes.get(periodo).add(disciplinaAcima);
						} else {
							dependentes.put(periodo,
									new ArrayList<Disciplina>());
							dependentes.get(periodo).add(disciplinaAcima);
						}
						identificaDependentes(disciplinaAcima, periodo,
								dependentes);
					}
				}
			}
		}
	}

	/**
	 * Verifica se disciplinas dependetes podem ser removidas
	 * 
	 * @param aRemover
	 *            Contem as disciplinas a serem removidas
	 * 
	 * @throws TotalDeCreditosInvalidoException
	 *             Se o total de creditos de algum periodo dor menor que o
	 *             minimo.
	 */
	private void verificaRemocaoDeDependentes(
			Map<Integer, List<Disciplina>> aRemover)
			throws TotalDeCreditosInvalidoException {
		// se alguma das disciplinas dependentes desta a frente nao puder ser
		// removida
		for (Integer key : aRemover.keySet()) {
			if (!getPeriodo(key).podeRemoverVarias(aRemover.get(key))) {
				throw new TotalDeCreditosInvalidoException("Remoção "
						+ " fará o " + key
						+ "º periodo ficar com menos que o mínimo de créditos.");
			}

		}
	}

	// /**
	// * Cria todos os periodos do plano de curso e aloca suas disciplinas.
	// */
	// private void alocacaoBaseDeDisciplinas() {
	//
	// for (int i = 0; i < PERIODOS_BASE; i++) {
	// try {
	// createPeriodo();
	// } catch (AlocacaoInvalidaException e) {
	// e.printStackTrace();
	// } catch (TotalDeCreditosInvalidoException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// disciplinasNaoAlocadas.addAll(getGrade().getDisciplinas());
	//
	// for (Disciplina disc : getGrade().getDisciplinas()) {
	// int numPeriodo = disc.getPeriodoSugerido();
	// if (numPeriodo > 0) {
	// try {
	// getPeriodo(numPeriodo).addDisciplina(disc);
	// } catch (TotalDeCreditosInvalidoException e) {
	// }
	// disciplinasNaoAlocadas.remove(disc);
	// }
	//
	// }
	// }
}