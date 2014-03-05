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
public class PlanoDeCurso extends Model {

	private static final long serialVersionUID = 1L;
	final private int PERIODO_MAXIMO = 14;
	private final int MAXIMO_DE_CREDITOS = 28;
	private final int PERIODOS_BASE = 8;

	private String id;
	private List<Disciplina> disciplinas;
	private List<Disciplina> disciplinasNaoAlocadas;
	private List<Periodo> periodos;

	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura os periodos com as
	 * disciplinas obrigatorias.
	 */
	public PlanoDeCurso() {
		disciplinas = new ArrayList<Disciplina>();
		periodos = new ArrayList<Periodo>();

		criaDisciplinas();

		disciplinasNaoAlocadas = new ArrayList<Disciplina>();
		disciplinasNaoAlocadas.addAll(getDisciplinas());

		alocaDisciplinas();
	}

	/**
	 * Inicia um plano de curso com um lista de periodos, um curriculo e uma
	 * lista de disciplinas não alocadas. Configura os periodos com as
	 * disciplinas obrigatorias.
	 */
	public PlanoDeCurso(String id) {
		this.id = id;
		disciplinas = new ArrayList<Disciplina>();
		periodos = new ArrayList<Periodo>();

		criaDisciplinas();

		disciplinasNaoAlocadas = new ArrayList<Disciplina>();
		disciplinasNaoAlocadas.addAll(getDisciplinas());

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
	 * Retorna uma disciplina pelo seu id.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @return A disciplina que tem o id.
	 */
	public Disciplina getDisciplina(String id) {

		for (Disciplina disc : disciplinas) {
			if (disc.getId().equals(id)) {
				return disc;
			}
		}
		return null;
	}

	/**
	 * Retorna todas as disciplinas do plano de curso.
	 * 
	 * @return a lista de disciplinas do plano de curso.
	 */
	public List<Disciplina> getDisciplinas() {
		return Collections.unmodifiableList(disciplinas);
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
	 * Cria uma disciplina com um id, um nome, o total de creditos, uma lista de
	 * disciplinas que sao pre requisitos, o periodo sugerido para cursar a
	 * disciplina e a dificuldade indicada da disciplina.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @param nome
	 *            O nome da disciplina.
	 * @param creditos
	 *            O total de creditos da disciplina.
	 * @param preRequisitosIds
	 *            A lista de disciplinas que sao pre requisitos desta.
	 * @param periodoSugerido
	 *            O periodo sugerido para cursar esta disciplina.
	 * @param dificuldade
	 *            A dificuldade indicada para a disciplina
	 * 
	 */
	public void createDisciplina(String id, String nome, int creditos,
			String[] preRequisitosIds, int periodoSugerido, int dificuldade) {

		List<Disciplina> preRequisitos = new ArrayList<Disciplina>();

		for (String preRequisitoId : preRequisitosIds) {
			preRequisitos.add(getDisciplina(preRequisitoId));
		}

		Disciplina aDisciplina = new Disciplina(id, nome, creditos,
				preRequisitos, periodoSugerido, dificuldade);
		disciplinas.add(aDisciplina);
		aDisciplina.salvar(aDisciplina);
	}

	/**
	 * Cria uma disciplina com um id, um nome, o total de creditos, o periodo
	 * sugerido para cursar a disciplina e a dificuldade indicada da disciplina.
	 * 
	 * @param id
	 *            O id da disciplina.
	 * @param nome
	 *            O nome da disciplina.
	 * @param creditos
	 *            O total de creditos da disciplina.
	 * @param periodoSugerido
	 *            O periodo sugerido para cursar esta disciplina.
	 * @param dificuldade
	 *            A dificuldade indicada para a disciplina
	 * 
	 */
	public void createDisciplina(String id, String nome, int creditos,
			int periodoSugerido, int dificuldade) {

		Disciplina aDisciplina = new Disciplina(id, nome, creditos,
				periodoSugerido, dificuldade);
		disciplinas.add(aDisciplina);
		aDisciplina.salvar(aDisciplina);
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
	 *            O numero do periodo que deve ser retornado.
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
		novoPeriodo.salvar(novoPeriodo);
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
					break;
				} else {
					temComo.setIsAlocadaCorretamente();
				}
			}
	
			for (Disciplina ehPreRequisito : saoPreRequisitos) { //para cada um dos seus pre-requisitos
				if (getPeriodoDaDisciplina(ehPreRequisito) >= getPeriodoDaDisciplina(aDisciplina)) { // se eles estiverem a frente
					aDisciplina.setNotAlocadaCorretamente();
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
				oPeriodo.deletar(oPeriodo.getId());
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

		if (Periodo.find.all().isEmpty()) {
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
					;
					disciplinasNaoAlocadas.remove(disc);
				}
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

	/**
	 * Cria todas as disciplinas do curso.
	 */
	private void criaDisciplinas() {

		if (Disciplina.find.all().isEmpty()) {

		// Disciplinas obrigatórias
		createDisciplina("01", "Cálculo Diferencial e Integral 1", 4, 1, 4);
		createDisciplina("02", "Álgebra Vetorial e Geometria Analítica", 4, 1,3);
		createDisciplina("03", "Leitura e Produção de Texto", 4, 1, 2);
		createDisciplina("04", "Programação 1", 4, 1, 3);
		createDisciplina("05", "Laboratório de Programação 1", 4, 1, 3);
		createDisciplina("06", "Introdução a Computação", 4, 1, 3);

		createDisciplina("07", "Cálculo Diferencial e Integral 2", 4,new String[] { "01" }, 2, 5);
		createDisciplina("08", "Matematica Discreta", 4, 2, 4);
		createDisciplina("09", "Metodologia Científica", 4, 2, 3);
		createDisciplina("10", "Programação 2", 4, new String[] { "04", "05","06" }, 2, 3);
		createDisciplina("11", "Laboratório de Programação 2", 4, new String[] {"04", "05", "06" }, 2, 3);
		createDisciplina("12", "Teoria dos Grafos", 2, new String[] { "04","05" }, 2, 3);
		createDisciplina("13", "Fundamentos de Física Clássica", 4,new String[] { "01", "02" }, 2, 4);

		createDisciplina("14", "Álgebra Linear", 4, new String[] { "02" }, 3, 4);
		createDisciplina("15", "Probabilidade e Estatística", 4,new String[] { "07" }, 3, 4);
		createDisciplina("16", "Teoria da Computação", 4, new String[] { "06","08", "12" }, 3, 3);
		createDisciplina("17", "Estruturas de Dados e Algoritmos", 4,new String[] { "10", "11", "12" }, 3, 4);
		createDisciplina("18", "Lab de Estruturas de Dados e Algoritmos", 4,new String[] { "10", "11", "12" }, 3, 4);
		createDisciplina("19", "Fundamentos de Física Moderna", 4,new String[] { "07", "13" }, 3, 4);
		createDisciplina("20", "Gerência da Informação", 4, 3, 2);

		createDisciplina("21", "Métodos Estatísticos", 4, new String[] { "14","15" }, 4, 3);
		createDisciplina("22", "Paradigmas de Linguagens de Prog", 2,new String[] { "16", "17", "18" }, 4, 3);
		createDisciplina("23", "Lógica Matemática", 4, new String[] { "16" },4, 3);
		createDisciplina("24", "Org. e Arquitetura de Computadores", 4,new String[] { "17", "18", "19" }, 4, 3);
		createDisciplina("25", "Lab de Org. e Arquitetura de Computadores", 4,new String[] { "17", "18", "19" }, 4, 3);
		createDisciplina("26", "Engenharia de Software 1", 4, new String[] {"10", "11", "15" }, 4, 3);
		createDisciplina("27", "Sistemas de Informação 1", 4,new String[] { "20" }, 4, 3);

		createDisciplina("28", "Informática e Sociedade", 2, 5, 3);
		createDisciplina("29", "Análise e Técnicas de Algoritmos", 4,new String[] { "07", "17", "18", "23" }, 5, 3);
		createDisciplina("30", "Compiladores", 4, new String[] { "22", "24","25" }, 5, 3);
		createDisciplina("31", "Redes de Computadores", 4, new String[] { "24","25" }, 5, 3);
		createDisciplina("32", "Bancos de Dados 1", 4, new String[] { "27" },5, 3);
		createDisciplina("33", "Sistemas de Informação 2", 4,new String[] { "27" }, 5, 3);
		createDisciplina("34", "Laboratório de Engenharia de Software", 2,new String[] { "26" }, 5, 3);

		createDisciplina("35", "Direito e Cidadania", 4, 6, 3);
		createDisciplina("36", "Sistemas Operacionais", 4, new String[] { "24","25" }, 6, 3);
		createDisciplina("37", "Interconexão de Redes de Comp.", 2,new String[] { "31" }, 6, 3);
		createDisciplina("38", "Lab de Interconexão de Redes de Comp.", 2,new String[] { "31" }, 6, 3);
		createDisciplina("39", "Banco de Dados 2", 4,new String[] { "32", "33" }, 6, 3);
		createDisciplina("40", "Inteligência Artificial 1", 4, new String[] {"21", "22", "29" }, 6, 3);

		createDisciplina("41", "Métodos e Software Numéricos", 4, new String[] {"14", "29" }, 7, 3);
		createDisciplina("42", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "15" }, 7, 3);
		createDisciplina("43", "Projeto em Computação 1", 4, new String[] {"09", "34" }, 7, 3);

		createDisciplina("44", "Projeto em Computação 2", 6,new String[] { "43" }, 8, 3);

		// Optativas Outros Departamentos
		createDisciplina("45", "Futsal", 2, -1, 3);
		createDisciplina("46", "Sociologia Industrial 1", 4, -1, 3);
		createDisciplina("47", "Basquete masc/fem", 2, -1, 3);
		createDisciplina("48", "Administração", 4, -1, 3);
		createDisciplina("49", "Economia", 4, -1, 3);
		createDisciplina("50", "Relações Humanas", 4, -1, 3);
		createDisciplina("51", "Cálculo Diferencial e Integral 3", 5, new String[] { "07" }, -1, 3);
		createDisciplina("52", "Equações Diferenciais", 4, -1, 3);
		createDisciplina("53", "Ética", 4, -1, 3);
		createDisciplina("54", "Expressão Gráfica", 4, -1, 3);
		createDisciplina("55", "Futebol de Campo", 2, -1, 3);
		createDisciplina("56", "Gestão da Qualidade", 4, -1, 3);
		createDisciplina("57", "Ginástica Masc/Fem", 2, -1, 3);
		createDisciplina("58", "Inglês", 4, -1, 3);
		createDisciplina("59", "Introdução à Filosofia", 2, -1, 3);
		createDisciplina("60", "Processo Decisório", 4, -1, 3);

		// Optativas TECC
		createDisciplina("61", "Administração Financeira", 4, -2, 3);
		createDisciplina("62", "Realidade Virtual", 4, new String[] { "27" },-2, 3);
		createDisciplina("63", "Administração de Sistemas", 4, -2, 3);
		createDisciplina("64", "Análise de Dados 1", 4, new String[] { "15" },-2, 3);
		createDisciplina("65", "Arquitetura de Software", 4, new String[] {"26", "27" }, -2, 3);
		createDisciplina("66", "Desenvolvimento Dirigido a Modelos", 4,new String[] { "26" }, -2, 3);
		createDisciplina("67", "Desenvolvimento de App Corporativas", 4,new String[] { "27", "32" }, -2, 3);
		createDisciplina("68", "Didática em Ciência da Computação", 2, -2, 3);
		createDisciplina("69", "Economia de TI", 4, -2, 3);
		createDisciplina("70", "Empreendedorismo em Software 1", 4, -2, 3);
		createDisciplina("71", "Estágio 2", 4, -2, 3);

		createDisciplina("80", "Optativa 1", 4, 6, 3);
		createDisciplina("81", "Optativa 2", 4, 6, 3);
		createDisciplina("82", "Optativa 3", 4, 7, 3);
		createDisciplina("83", "Optativa 4", 4, 7, 3);
		createDisciplina("84", "Optativa 5", 4, 7, 3);
		createDisciplina("85", "Optativa 6", 4, 7, 3);
		createDisciplina("86", "Optativa 7", 4, 8, 3);
		createDisciplina("87", "Optativa 8", 4, 8, 3);
		createDisciplina("88", "Optativa 9", 4, 8, 3);
		createDisciplina("89", "Optativa 10", 4, 8, 3);
		createDisciplina("90", "Optativa 11", 2, 8, 3);
		
		}
	}
}