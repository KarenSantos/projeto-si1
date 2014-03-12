package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.AlocacaoInvalidaException;
import exceptions.TotalDeCreditosInvalidoException;
import play.db.ebean.*;

import javax.persistence.*;

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
	private final int PERIODOS_BASE = 8;

	@Id
	private String id;

	@ManyToOne
	private Grade grade;
	private List<Disciplina> disciplinasNaoAlocadas;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "plano_periodo", joinColumns = { @JoinColumn(name = "p_plano") }, inverseJoinColumns = { @JoinColumn(name = "p_periodo") })
	private List<Periodo> periodos;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Usuario user;

	public static Finder<String, PlanoDeCurso> find = new Finder<String, PlanoDeCurso>(String.class, PlanoDeCurso.class);
	
	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura os periodos com as
	 * disciplinas obrigatorias.
	 */
	public PlanoDeCurso(){
		grade = new Grade();
		disciplinasNaoAlocadas = new ArrayList<Disciplina>();
		periodos = new ArrayList<Periodo>();
		alocaDisciplinas();
		configuraDisciplinasNaoAlocadas();
	}
	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura os periodos com as
	 * disciplinas obrigatorias.
	 * @param user, dono do Plano de Curso
	 */
	public PlanoDeCurso(Usuario user){
		grade = new Grade();
		disciplinasNaoAlocadas = new ArrayList<Disciplina>();
		periodos = new ArrayList<Periodo>();
		this.user = user;
		alocaDisciplinas();
		configuraDisciplinasNaoAlocadas();
	}
	
	
	public void create(PlanoDeCurso plano){
		plano.save();
	}
	
	
	
	/**
	 * Atualiza a grade curricular com as disciplinas salvas no BD.
	 */
	public void atualizaGrade(){
		grade.atualizar();
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
	 * Retorna todas as disciplinas da grade de computação.
	 * 
	 * @return a lista de disciplinas da grade.
	 */
	public List<Disciplina> getDisciplinas() {
		return grade.getDisciplinas();
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

		int novoNumero = ultimoPeriodo + 1;
		Periodo novoPeriodo = new Periodo(id + novoNumero, novoNumero);
		if (isInvertido()){
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
		for (Disciplina disc : getDisciplinas()) {
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
	 *             Caso o periodo ja tenha o total maximo de creditos alocado.
	 */
	public void addDisciplinaPeriodo(String id, int periodo)
			throws AlocacaoInvalidaException, TotalDeCreditosInvalidoException {

		Disciplina aDisciplina = getDisciplina(id);

		removeDisciplinaOptativaGenerica(periodo); // caso tenha

		if (periodo != getTotalDePeriodos()) { // se nao for o ultimo periodo
			if ((getPeriodo(periodo).getTotalDeCreditos() + aDisciplina
					.getCreditos()) > MAXIMO_DE_CREDITOS) {
					adicionaDisciplinaOptativaGenerica(periodo); // caso ela tenha sido removida
					throw new TotalDeCreditosInvalidoException(
							"O número máximo de créditos por período é 28.");
			}
		}

		if (!aDisciplina.getPreRequisitos().isEmpty()) { // checando se tem pre-requisitos nao alocados nos periodos anteriores
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
	 */
	public void removeDisciplinaPeriodo(String id, int periodo) {

		Disciplina aDisciplina = getDisciplina(id);
		
		Map<Disciplina, Integer> aRemover = new HashMap<Disciplina, Integer>();
		identificaDependentes(aDisciplina, periodo, aRemover);

		for (Map.Entry<Disciplina, Integer> entry : aRemover.entrySet()) {
			getPeriodo(entry.getValue()).removeDisciplina(entry.getKey());
			disciplinasNaoAlocadas.add(entry.getKey());
		}

		getPeriodo(periodo).removeDisciplina(aDisciplina);
		
		if (!getDisciplinasOptativasGenericas().contains(aDisciplina)) {
			disciplinasNaoAlocadas.add(aDisciplina);
		}

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
	 * 			  Se o total de créditos fosse ultrapassar 28 ao mover a disciplina.
	 */
	public void moveDisciplina(String disciplinaId, int periodoFuturo,
			int periodoAtual) throws TotalDeCreditosInvalidoException {
		Disciplina aDisciplina = getDisciplina(disciplinaId);
		
		if (!getDisciplinasOptativasGenericas().contains(aDisciplina)) { //se ela nao é uma optativa generica podemos mover
			
			removeDisciplinaOptativaGenerica(periodoFuturo); // caso tenha optativas genericas no periodo futuro
	
			if (periodoFuturo != getTotalDePeriodos()) { // se nao for o ultimo periodo
				if ((getPeriodo(periodoFuturo).getTotalDeCreditos() + aDisciplina
						.getCreditos()) > MAXIMO_DE_CREDITOS) {
						adicionaDisciplinaOptativaGenerica(periodoFuturo); // caso ela tenha sido removida coloca de volta
						throw new TotalDeCreditosInvalidoException(
								"O número máximo de créditos por período é 28.");
				}
			}
	
				
			getPeriodo(periodoAtual).removeDisciplina(aDisciplina);
			adicionaDisciplinaOptativaGenerica(periodoAtual); //caso a remoção da disciplina tenha deixado lugar
			
			getPeriodo(periodoFuturo).addDisciplina(aDisciplina);
	
			List<Disciplina> temComoPreRequisito = temComoPreRequisito(aDisciplina);
			List<Disciplina> saoPreRequisitos = aDisciplina.getPreRequisitos();
	
			for (Disciplina temComo : temComoPreRequisito) { //pra cada disciplina que tem esta como pre-requisito
				if (getPeriodoDaDisciplina(aDisciplina) >= getPeriodoDaDisciplina(temComo)) { //se a disciplina tiver a frente
					temComo.setNotAlocadaCorretamente();
				} else {
					temComo.setIsAlocadaCorretamente();
				}
			}
	
			for (Disciplina ehPreRequisito : saoPreRequisitos) { //para cada um dos seus pre-requisitos
				if (getPeriodoDaDisciplina(ehPreRequisito) >= getPeriodoDaDisciplina(aDisciplina)) { // se eles estiverem a frente
					aDisciplina.setNotAlocadaCorretamente();
					break;
				} else {
					aDisciplina.setIsAlocadaCorretamente();
				}
			}
		}
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
	 * Deleta o ultimo periodo criado se nao for um dos 8 periodos base
	 * e se estiver sem disciplinas.
	 */
	public void deletaUltimoPeriodoSeVazio(){
		
		if (getTotalDePeriodos() > PERIODOS_BASE) {
			int ultimoPeriodo = getTotalDePeriodos(); 
			if (getPeriodo(ultimoPeriodo).getTotalDeDisciplinas() == 0) {
				Periodo oPeriodo = getPeriodo(ultimoPeriodo);
				periodos.remove(oPeriodo);
//				oPeriodo.deletar(oPeriodo.getId());
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
	public boolean temPreRequisitoNaoAlocado(Disciplina disc) {
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
	 * Inverte a ordem da lista dos periodos. Se está crescente fica
	 * decrescente, se está decrescente fica crescente.
	 */
	public void inverteOrdemDosPeriodos() {
		int indice = getTotalDePeriodos();
		for (int i = 0; i < getTotalDePeriodos(); i ++) {
			Periodo periodo = periodos.get(indice-1);
			periodos.remove(periodo);
			periodos.add(i, periodo);
		}
	}
	
	/**
	 * Indica se os periodos estão em ordem invertida ou nao.
	 * 
	 * @return True se os periodos estao invertidos e false caso contrario.
	 */
	public boolean isInvertido(){
		boolean resp = false;
		if (getTotalDePeriodos() > 0) {
			if (periodos.get(0).getNumero() != 1){
				resp = true;
			}
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

		for (Disciplina disc : getDisciplinas()) {
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
	 * Cria todos os periodos do plano de curso e aloca suas disciplinas.
	 */
	private void alocaDisciplinas() {

//		if (Periodo.find.all().isEmpty()) {
			for (Disciplina disc : getDisciplinas()) {
				int periodo = disc.getPeriodoSugerido();
				if (periodo > 0) {
					if (getTotalDePeriodos() < periodo) {
						try {
							createPeriodo("Usuario");
						} catch (Exception e) {
						}
					}
					getPeriodo(periodo).addDisciplina(disc);
				}
			}
//		} else {
//			periodos.addAll(Periodo.find.all());
//		}
	}
	
	private void configuraDisciplinasNaoAlocadas() {
		disciplinasNaoAlocadas.addAll(getDisciplinas());
		for (Periodo periodo : getPeriodos()){
			for (Disciplina disc : periodo.getDisciplinas()){
				disciplinasNaoAlocadas.remove(disc);
			}
		}
	}
	
	/**
	 * Remove uma unica disciplina optativa generica se o periodo a contem.
	 * 
	 * @param periodo
	 *            O periodo de onde pode ser removida a disciplina generica.
	 */
	private void removeDisciplinaOptativaGenerica(int periodo) {

		List<Disciplina> genericas = getDisciplinasOptativasGenericas();

		for (Disciplina disc : getPeriodo(periodo).getDisciplinas()) {
			if (genericas.contains(disc)) {
				getPeriodo(periodo).removeDisciplina(disc);
				break;
			}
		}
	}

	/**
	 * Adiciona uma unica disciplina optativa generica se o periodo nao a
	 * contem e se o maximo de creditos nao for ultrapassado.
	 * 
	 * @param periodo
	 *            O periodo onde pode ser adicionada a disciplina generica.
	 */
	private void adicionaDisciplinaOptativaGenerica(int periodo) {

		List<Disciplina> genericas = getDisciplinasOptativasGenericas();

		for (Disciplina disc : genericas) {
			if (disc.getPeriodoSugerido() == periodo) {
				if (!getPeriodo(periodo).getDisciplinas().contains(disc)) {
					if ((getPeriodo(periodo).getTotalDeCreditos() + disc.getCreditos()) <= MAXIMO_DE_CREDITOS) {
						getPeriodo(periodo).addDisciplina(disc);
						break;
					}
				}
			}
		}
	}
}