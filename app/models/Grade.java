package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import play.db.ebean.Model;

/**
 * Classe da grade curricular do curso de computação 
 * 
 * @author
 *
 */
public class Grade extends Model{

	private static final long serialVersionUID = 1L;

	private static List<Disciplina> disciplinas;
	
	/**
	 * Cria uma grade curricular com uma lista de disciplinas.
	 */
	public Grade(){
		disciplinas = new ArrayList<Disciplina>();
		if (Disciplina.find.all().isEmpty()) {
			criaDisciplinas();
		} else {
			disciplinas.addAll(Disciplina.find.all());
		}
	}
	
	public static Finder<String, Grade> find = new Finder<String, Grade>(
			String.class, Grade.class);

	/**
	 * Retorna a lista com todas as disciplinas da grade.
	 * 
	 * @return A lista com todas as disciplinas da grade.
	 */
	public List<Disciplina> getDisciplinas(){
		return Collections.unmodifiableList(disciplinas);
	}
	
	/**
	 * Retorna uma disciplina da grade curricular.
	 * 
	 * @param id 
	 * 			   O id da disciplina que vai ser retornada.
	 * @return A disciplina com o id ou null se não existir.
	 */
	public Disciplina getDisciplina(long id){
		Disciplina aDisciplina = null;
		for (Disciplina disc : disciplinas) {
			if (disc.getId() ==id) {
				aDisciplina = disc;
			}
		}
		return aDisciplina;
	}
	
	/**
	 * Retorna o total de disciplinas da grade curricular.
	 * 
	 * @return O total de disciplinas.
	 */
	public int getTotalDeDisciplinas(){
		return getDisciplinas().size();
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
	 * 			  A dificuldade indicada para a disciplina
	 * 
	 */
	public void createDisciplina(long id, String nome, int creditos,
			long[] preRequisitosIds, int periodoSugerido, int dificuldade) {

		List<Disciplina> preRequisitos = new ArrayList<Disciplina>();

		for (Long preRequisitoId : preRequisitosIds) {
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
	 * 			  A dificuldade indicada para a disciplina
	 *             
	 */
	public void createDisciplina(long id, String nome, int creditos, int periodoSugerido, int dificuldade) {

		Disciplina aDisciplina = new Disciplina(id, nome, creditos, periodoSugerido, dificuldade);
		disciplinas.add(aDisciplina);
	}
	
	
	/**
	 * Cria todas as disciplinas do curso de computação.
	 */
	private void criaDisciplinas() {

		// Disciplinas obrigatórias
		createDisciplina(1, "Cálculo Diferencial e Integral 1", 4, 1, 4);
		createDisciplina(2, "Álgebra Vetorial e Geometria Analítica", 4, 1,3);
		createDisciplina(3, "Leitura e Produção de Texto", 4, 1, 2);
		createDisciplina(4, "Programação 1", 4, 1, 3);
		createDisciplina(5, "Laboratório de Programação 1", 4, 1, 3);
		createDisciplina(6, "Introdução a Computação", 4, 1, 3);

		createDisciplina(7, "Cálculo Diferencial e Integral 2", 4,new long[] { 1 }, 2, 5);
		createDisciplina(8, "Matematica Discreta", 4, 2, 4);
		createDisciplina(9, "Metodologia Científica", 4, 2, 3);
		createDisciplina(10, "Programação 2", 4, new long[] { 4, 5, 6 }, 2, 3);
		createDisciplina(11, "Laboratório de Programação 2", 4, new long[] {4, 5, 6 }, 2, 3);
		createDisciplina(12, "Teoria dos Grafos", 2, new long[] { 04, 05 }, 2, 3);
		createDisciplina(13, "Fundamentos de Física Clássica", 4,new long[] { 1, 2 }, 2, 4);

		createDisciplina(14, "Álgebra Linear", 4, new long[] { 2 }, 3, 4);
		createDisciplina(15, "Probabilidade e Estatística", 4,new long[] { 7 }, 3, 4);
		createDisciplina(16, "Teoria da Computação", 4, new long[] { 6, 8, 12 }, 3, 3);
		createDisciplina(17, "Estruturas de Dados e Algoritmos", 4,new long[] { 10, 11, 12 }, 3, 4);
		createDisciplina(18, "Lab de Estruturas de Dados e Algoritmos", 4,new long[] { 10, 11, 12 }, 3, 4);
		createDisciplina(19, "Fundamentos de Física Moderna", 4,new long[] { 7, 13 }, 3, 4);
		createDisciplina(20, "Gerência da Informação", 4, 3, 2);

		createDisciplina(21, "Métodos Estatísticos", 4, new long[] { 14,15 }, 4, 3);
		createDisciplina(22, "Paradigmas de Linguagens de Prog", 2,new long[] { 16, 17, 18 }, 4, 3);
		createDisciplina(23, "Lógica Matemática", 4, new long[] { 16 },4, 3);
		createDisciplina(24, "Org. e Arquitetura de Computadores", 4,new long[] { 17, 18, 19 }, 4, 3);
		createDisciplina(25, "Lab de Org. e Arquitetura de Computadores", 4,new long[] { 17, 18, 19 }, 4, 3);
		createDisciplina(26, "Engenharia de Software 1", 4, new long[] {10, 11, 15 }, 4, 3);
		createDisciplina(27, "Sistemas de Informação 1", 4,new long[] { 20 }, 4, 3);

		createDisciplina(28, "Informática e Sociedade", 2, 5, 3);
		createDisciplina(29, "Análise e Técnicas de Algoritmos", 4,new long[] { 07, 17, 18, 23 }, 5, 3);
		createDisciplina(30, "Compiladores", 4, new long[] { 22, 24, 25 }, 5, 3);
		createDisciplina(31, "Redes de Computadores", 4, new long[] { 24,25 }, 5, 3);
		createDisciplina(32, "Bancos de Dados 1", 4, new long[] { 27 },5, 3);
		createDisciplina(33, "Sistemas de Informação 2", 4,new long[] { 27 }, 5, 3);
		createDisciplina(34, "Laboratório de Engenharia de Software", 2,new long[] { 26 }, 5, 3);

		createDisciplina(35, "Direito e Cidadania", 4, 6, 3);
		createDisciplina(36, "Sistemas Operacionais", 4, new long[] { 24,25 }, 6, 3);
		createDisciplina(37, "Interconexão de Redes de Comp.", 2,new long[] { 31 }, 6, 3);
		createDisciplina(38, "Lab de Interconexão de Redes de Comp.", 2,new long[] { 31 }, 6, 3);
		createDisciplina(39, "Banco de Dados 2", 4,new long[] { 32, 33 }, 6, 3);
		createDisciplina(40, "Inteligência Artificial 1", 4, new long[] {21, 22, 29 }, 6, 3);

		createDisciplina(41, "Métodos e Software Numéricos", 4, new long[] {14, 29 }, 7, 3);
		createDisciplina(42, "Av. de Desempenho de Sistemas Discretos", 4, new long[] { 15 }, 7, 3);
		createDisciplina(43, "Projeto em Computação 1", 4, new long[] {9, 34 }, 7, 3);
		createDisciplina(44, "Projeto em Computação 2", 6,new long[] { 43 }, 8, 3);

		// Optativas Outros Departamentos
		createDisciplina(45, "Futsal", 2, -1, 3);
		createDisciplina(46, "Sociologia Industrial 1", 4, -1, 3);
		createDisciplina(47, "Basquete masc/fem", 2, -1, 3);
		createDisciplina(48, "Administração", 4, -1, 3);
		createDisciplina(49, "Economia", 4, -1, 3);
		createDisciplina(50, "Relações Humanas", 4, -1, 3);
		createDisciplina(51, "Cálculo Diferencial e Integral 3", 5, new long[] { 07 }, -1, 3);
		createDisciplina(52, "Equações Diferenciais", 4, -1, 3);
		createDisciplina(53, "Ética", 4, -1, 3);
		createDisciplina(54, "Expressão Gráfica", 4, -1, 3);
		createDisciplina(55, "Futebol de Campo", 2, -1, 3);
		createDisciplina(56, "Gestão da Qualidade", 4, -1, 3);
		createDisciplina(57, "Ginástica Masc/Fem", 2, -1, 3);
		createDisciplina(58, "Inglês", 4, -1, 3);
		createDisciplina(59, "Introdução à Filosofia", 2, -1, 3);
		createDisciplina(60, "Processo Decisório", 4, -1, 3);

		// Optativas TECC
		createDisciplina(61, "Administração Financeira", 4, -2, 3);
		createDisciplina(62, "Realidade Virtual", 4, new long[] { 27 },-2, 3);
		createDisciplina(63, "Administração de Sistemas", 4, -2, 3);
		createDisciplina(64, "Análise de Dados 1", 4, new long[] { 15 },-2, 3);
		createDisciplina(65, "Arquitetura de Software", 4, new long[] {26, 27 }, -2, 3);
		createDisciplina(66, "Desenvolvimento Dirigido a Modelos", 4,new long[] { 26 }, -2, 3);
		createDisciplina(67, "Desenvolvimento de App Corporativas", 4,new long[] { 27, 32 }, -2, 3);
		createDisciplina(68, "Didática em Ciência da Computação", 2, -2, 3);
		createDisciplina(69, "Economia de TI", 4, -2, 3);
		createDisciplina(70, "Empreendedorismo em Software 1", 4, -2, 3);
		createDisciplina(71, "Estágio 2", 4, -2, 3);

		createDisciplina(72, "Optativa 1", 4, 6, 3);
		createDisciplina(73, "Optativa 2", 4, 6, 3);
		createDisciplina(74, "Optativa 3", 4, 7, 3);
		createDisciplina(75, "Optativa 4", 4, 7, 3);
		createDisciplina(76, "Optativa 5", 4, 7, 3);
		createDisciplina(77, "Optativa 6", 4, 7, 3);
		createDisciplina(78, "Optativa 7", 4, 8, 3);
		createDisciplina(78, "Optativa 8", 4, 8, 3);
		createDisciplina(79, "Optativa 9", 4, 8, 3);
		createDisciplina(80, "Optativa 10", 4, 8, 3);
		createDisciplina(81, "Optativa 11", 2, 8, 3);
		
	}
}
