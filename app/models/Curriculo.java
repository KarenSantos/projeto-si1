package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * Classe do curriculo do curso de ciencia da computacao.
 * 
 * @author
 * 
 */
@Entity
public class Curriculo extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private List<Disciplina> disciplinas;

	/**
	 * Inicia um curriculo com uma lista para as disciplinas do curso.
	 */
	public Curriculo() {
		disciplinas = new ArrayList<Disciplina>();

		// CREATOR o curriculo é formado por disciplinas
		criaDisciplinas();

	}

	/**
	 * Cria um curriculo com um id e uma lista para as disciplinas do curso.
	 * 
	 * @param id
	 *            O id do curriculo
	 */
	public Curriculo(String id) {
		this.id = id;
		disciplinas = new ArrayList<Disciplina>();
		criaDisciplinas();
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
	 * Retorna todas as disciplinado curriculo.
	 * 
	 * @return a lista de disciplinas do curriculo.
	 */
	public List<Disciplina> getDisciplinas() {
		return Collections.unmodifiableList(disciplinas);
	}

	/**
	 * Cria todas as disciplinas do curso.
	 */
	private void criaDisciplinas() {

		if (true) {
			
			// Disciplinas obrigatórias
			createDisciplina("01", "Cálculo Diferencial e Integral 1", 4, 1, 4);
			createDisciplina("02", "Álgebra Vetorial e Geometria Analítica", 4, 1,
					3);
			createDisciplina("03", "Leitura e Produção de Texto", 4, 1, 2);
			createDisciplina("04", "Programação 1", 4, 1, 3);
			createDisciplina("05", "Laboratório de Programação 1", 4, 1, 3);
			createDisciplina("06", "Introdução a Computação", 4, 1, 3);
	
			createDisciplina("07", "Cálculo Diferencial e Integral 2", 4,
					new String[] { "01" }, 2, 5);
			createDisciplina("08", "Matematica Discreta", 4, 2, 4);
			createDisciplina("09", "Metodologia Científica", 4, 2, 3);
			createDisciplina("10", "Programação 2", 4, new String[] { "04", "05",
					"06" }, 2, 3);
			createDisciplina("11", "Laboratório de Programação 2", 4, new String[] {
					"04", "05", "06" }, 2, 3);
			createDisciplina("12", "Teoria dos Grafos", 2, new String[] { "04",
					"05" }, 2, 3);
			createDisciplina("13", "Fundamentos de Física Clássica", 4,
					new String[] { "01", "02" }, 2, 4);
	
			createDisciplina("14", "Álgebra Linear", 4, new String[] { "02" }, 3, 4);
			createDisciplina("15", "Probabilidade e Estatística", 4,
					new String[] { "07" }, 3, 4);
			createDisciplina("16", "Teoria da Computação", 4, new String[] { "06",
					"08", "12" }, 3, 3);
			createDisciplina("17", "Estruturas de Dados e Algoritmos", 4,
					new String[] { "10", "11", "12" }, 3, 4);
			createDisciplina("18", "Lab de Estruturas de Dados e Algoritmos", 4,
					new String[] { "10", "11", "12" }, 3, 4);
			createDisciplina("19", "Fundamentos de Física Moderna", 4,
					new String[] { "07", "13" }, 3, 4);
			createDisciplina("20", "Gerência da Informação", 4, 3, 2);
	
			createDisciplina("21", "Métodos Estatísticos", 4, new String[] { "14",
					"15" }, 4, 3);
			createDisciplina("22", "Paradigmas de Linguagens de Prog", 2,
					new String[] { "16", "17", "18" }, 4, 3);
			createDisciplina("23", "Lógica Matemática", 4, new String[] { "16" },
					4, 3);
			createDisciplina("24", "Org. e Arquitetura de Computadores", 4,
					new String[] { "17", "18", "19" }, 4, 3);
			createDisciplina("25", "Lab de Org. e Arquitetura de Computadores", 4,
					new String[] { "17", "18", "19" }, 4, 3);
			createDisciplina("26", "Engenharia de Software 1", 4, new String[] {
					"10", "11", "15" }, 4, 3);
			createDisciplina("27", "Sistemas de Informação 1", 4,
					new String[] { "20" }, 4, 3);
	
			createDisciplina("28", "Informática e Sociedade", 2, 5, 3);
			createDisciplina("29", "Análise e Técnicas de Algoritmos", 4,
					new String[] { "07", "17", "18", "23" }, 5, 3);
			createDisciplina("30", "Compiladores", 4, new String[] { "22", "24",
					"25" }, 5, 3);
			createDisciplina("31", "Redes de Computadores", 4, new String[] { "24",
					"25" }, 5, 3);
			createDisciplina("32", "Bancos de Dados 1", 4, new String[] { "27" },
					5, 3);
			createDisciplina("33", "Sistemas de Informação 2", 4,
					new String[] { "27" }, 5, 3);
			createDisciplina("34", "Laboratório de Engenharia de Software", 2,
					new String[] { "26" }, 5, 3);
	
			createDisciplina("35", "Direito e Cidadania", 4, 6, 3);
			createDisciplina("36", "Sistemas Operacionais", 4, new String[] { "24",
					"25" }, 6, 3);
			createDisciplina("37", "Interconexão de Redes de Comp.", 2,
					new String[] { "31" }, 6, 3);
			createDisciplina("38", "Lab de Interconexão de Redes de Comp.", 2,
					new String[] { "31" }, 6, 3);
			createDisciplina("39", "Banco de Dados 2", 4,
					new String[] { "32", "33" }, 6, 3);
			createDisciplina("40", "Inteligência Artificial 1", 4, new String[] {
					"21", "22", "29" }, 6, 3);
	
			createDisciplina("41", "Métodos e Software Numéricos", 4, new String[] {
					"14", "29" }, 7, 3);
			createDisciplina("42", "Av. de Desempenho de Sistemas Discretos", 4,
					new String[] { "15" }, 7, 3);
			createDisciplina("43", "Projeto em Computação 1", 4, new String[] {
					"09", "34" }, 7, 3);
	
			createDisciplina("44", "Projeto em Computação 2", 6,
					new String[] { "43" }, 8, 3);
	
			// Optativas Outros Departamentos
			createDisciplina("45", "Futsal", 2, -1, 3);
			createDisciplina("46", "Sociologia Industrial 1", 4, -1, 3);
			createDisciplina("47", "Basquete masc/fem", 2, -1, 3);
			createDisciplina("48", "Administração", 4, -1, 3);
			createDisciplina("49", "Economia", 4, -1, 3);
			createDisciplina("50", "Relações Humanas", 4, -1, 3);
			createDisciplina("51", "Cálculo Diferencial e Integral 3", 5, -1, 3);
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
			createDisciplina("62", "Realidade Virtual", 4, new String[] { "27" },
					-2, 3);
			createDisciplina("63", "Administração de Sistemas", 4, -2, 3);
			createDisciplina("64", "Análise de Dados 1", 4, new String[] { "15" },
					-2, 3);
			createDisciplina("65", "Arquitetura de Software", 4, new String[] {
					"26", "27" }, -2, 3);
			createDisciplina("66", "Desenvolvimento Dirigido a Modelos", 4,
					new String[] { "26" }, -2, 3);
			createDisciplina("67", "Desenvolvimento de App Corporativas", 4,
					new String[] { "27", "32" }, -2, 3);
			createDisciplina("68", "Didática em Ciência da Computação", 2, -2, 3);
			createDisciplina("69", "Economia de TI", 4, -2, 3);
			createDisciplina("70", "Empreendedorismo em Software 1", 4, -2, 3);
			createDisciplina("71", "Estágio 2", 4, -2, 3);
			
			salvarDiscNoBD();

		}
	}

	private void salvarDiscNoBD() {
		for (Disciplina disc : getDisciplinas()){
			disc.save();
		}
	}
}
