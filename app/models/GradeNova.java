package models;

/**
 * 
 * @author
 *
 */
public class GradeNova extends Grade {

	private static final long serialVersionUID = 1L;

	/**
	 * Cria uma grade curricular nova com uma lista de disciplinas e 
	 * periodos.
	 */
	public GradeNova(){
		super();
	}
	
	/**
	 * Cria todas as disciplinas da grade antiga do curso de 
	 * computação.
	 */
	protected void criaDisciplinas() {

		// Disciplinas obrigatórias
		createDisciplina("01", "Cálculo Diferencial e Integral 1", 4, 4);
		createDisciplina("02", "Álgebra Vetorial e Geometria Analítica", 4,3);
		createDisciplina("03", "Leitura e Produção de Texto", 4, 2);
		createDisciplina("04", "Programação 1", 4, 3);
		createDisciplina("05", "Laboratório de Programação 1", 4, 3);
		createDisciplina("06", "Introdução a Computação", 4, 3);

		createDisciplina("07", "Cálculo Diferencial e Integral 2", 4,new String[] { "01" }, 5);
		createDisciplina("08", "Matematica Discreta", 4, 4);
		createDisciplina("09", "Metodologia Científica", 4, 3);
		createDisciplina("10", "Programação 2", 4, new String[] { "04", "05","06" }, 3);
		createDisciplina("11", "Laboratório de Programação 2", 4, new String[] {"04", "05", "06" }, 3);
		createDisciplina("12", "Teoria dos Grafos", 2, new String[] { "04","05" }, 3);
		createDisciplina("13", "Fundamentos de Física Clássica", 4,new String[] { "01", "02" }, 4);

		createDisciplina("14", "Álgebra Linear", 4, new String[] { "02" }, 4);
		createDisciplina("15", "Probabilidade e Estatística", 4,new String[] { "07" }, 4);
		createDisciplina("16", "Teoria da Computação", 4, new String[] { "06","08", "12" }, 3);
		createDisciplina("17", "Estruturas de Dados e Algoritmos", 4,new String[] { "10", "11", "12" }, 4);
		createDisciplina("18", "Lab de Estruturas de Dados e Algoritmos", 4,new String[] { "10", "11", "12" }, 4);
		createDisciplina("19", "Fundamentos de Física Moderna", 4,new String[] { "07", "13" }, 4);
		createDisciplina("20", "Gerência da Informação", 4, 2);

		createDisciplina("21", "Métodos Estatísticos", 4, new String[] { "14","15" }, 3);
		createDisciplina("22", "Paradigmas de Linguagens de Prog", 2,new String[] { "16", "17", "18" }, 3);
		createDisciplina("23", "Lógica Matemática", 4, new String[] { "16" }, 3);
		createDisciplina("24", "Org. e Arquitetura de Computadores", 4,new String[] { "17", "18", "19" }, 3);
		createDisciplina("25", "Lab de Org. e Arquitetura de Computadores", 4,new String[] { "17", "18", "19" }, 3);
		createDisciplina("26", "Engenharia de Software 1", 4, new String[] {"10", "11", "15" }, 3);
		createDisciplina("27", "Sistemas de Informação 1", 4,new String[] { "20" }, 3);

		createDisciplina("28", "Informática e Sociedade", 2, 3);
		createDisciplina("29", "Análise e Técnicas de Algoritmos", 4,new String[] { "07", "17", "18", "23" }, 3);
		createDisciplina("30", "Compiladores", 4, new String[] { "22", "24","25" }, 3);
		createDisciplina("31", "Redes de Computadores", 4, new String[] { "24","25" }, 3);
		createDisciplina("32", "Bancos de Dados 1", 4, new String[] { "27" }, 3);
		createDisciplina("33", "Sistemas de Informação 2", 4,new String[] { "27" }, 3);
		createDisciplina("34", "Laboratório de Engenharia de Software", 2,new String[] { "26" }, 3);

		createDisciplina("35", "Direito e Cidadania", 4, 3);
		createDisciplina("36", "Sistemas Operacionais", 4, new String[] { "24","25" }, 3);
		createDisciplina("37", "Interconexão de Redes de Comp.", 2,new String[] { "31" }, 3);
		createDisciplina("38", "Lab de Interconexão de Redes de Comp.", 2,new String[] { "31" }, 3);
		createDisciplina("39", "Banco de Dados 2", 4,new String[] { "32", "33" }, 3);
		createDisciplina("40", "Inteligência Artificial 1", 4, new String[] {"21", "22", "29" }, 3);

		createDisciplina("41", "Métodos e Software Numéricos", 4, new String[] {"14", "29" }, 3);
		createDisciplina("42", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "15" }, 3);
		createDisciplina("43", "Projeto em Computação 1", 4, new String[] {"09", "34" }, 3);

		createDisciplina("44", "Projeto em Computação 2", 6,new String[] { "43" }, 3);

		// Optativas TECC
		createDisciplina("100", "Administração Financeira", 4, 3);
		createDisciplina("101", "Realidade Virtual", 4, new String[] { "27" }, 3);
		createDisciplina("102", "Administração de Sistemas", 4, 3);
		createDisciplina("103", "Análise de Dados 1", 4, new String[] { "15" }, 3);
		createDisciplina("104", "Arquitetura de Software", 4, new String[] {"26", "27" }, 3);
		createDisciplina("105", "Desenvolvimento Dirigido a Modelos", 4,new String[] { "26" }, 3);
		createDisciplina("106", "Desenvolvimento de App Corporativas", 4,new String[] { "27", "32" }, 3);
		createDisciplina("107", "Didática em Ciência da Computação", 2, 3);
		createDisciplina("108", "Economia de TI", 4, 3);
		createDisciplina("109", "Empreendedorismo em Software 1", 4, 3);
		createDisciplina("110", "Estágio 2", 4, 3);
		
		// Optativas Outros Departamentos
		createDisciplina("200", "Futsal", 2, 3);
		createDisciplina("201", "Sociologia Industrial 1", 4, 3);
		createDisciplina("202", "Basquete masc/fem", 2, 3);
		createDisciplina("203", "Administração", 4, 3);
		createDisciplina("204", "Economia", 4, 3);
		createDisciplina("205", "Relações Humanas", 4, 3);
		createDisciplina("206", "Cálculo Diferencial e Integral 3", 5, new String[] { "07" }, 3);
		createDisciplina("207", "Equações Diferenciais", 4, 3);
		createDisciplina("208", "Ética", 4, 3);
		createDisciplina("209", "Expressão Gráfica", 4, 3);
		createDisciplina("210", "Futebol de Campo", 2, 3);
		createDisciplina("220", "Gestão da Qualidade", 4, 3);
		createDisciplina("221", "Ginástica Masc/Fem", 2, 3);
		createDisciplina("222", "Inglês", 4, 3);
		createDisciplina("223", "Introdução à Filosofia", 2, 3);
		createDisciplina("224", "Processo Decisório", 4, 3);

		// Optativas Genericas
		createDisciplina("80", "Optativa 1", 4, 3);
		createDisciplina("81", "Optativa 2", 4, 3);
		createDisciplina("82", "Optativa 3", 4, 3);
		createDisciplina("83", "Optativa 4", 4, 3);
		createDisciplina("84", "Optativa 5", 4, 3);
		createDisciplina("85", "Optativa 6", 4, 3);
		createDisciplina("86", "Optativa 7", 4, 3);
		createDisciplina("87", "Optativa 8", 4, 3);
		createDisciplina("88", "Optativa 9", 4, 3);
		createDisciplina("89", "Optativa 10", 4, 3);
		createDisciplina("90", "Optativa 11", 2, 3);
		
	}

	/**
	 * Configura todos os periodos da grade antiga de acordo com
	 * a alocacao padrao.
	 */
	@Override
	protected void configuraPeriodos() {
		String[] primeiroPeriodo = new String[]{"01", "02", "03", "04", "05", "06"};
		String[] segundoPeriodo = new String[]{"07", "08", "09", "10", "11", "12", "13"};
		String[] terceiroPeriodo = new String[]{"14", "15", "16", "17", "18", "19", "20"};
		String[] quartoPeriodo = new String[]{"21", "22", "23", "24", "25", "26", "27"};
		String[] quintoPeriodo = new String[]{"28", "29", "30", "31", "32", "33", "34"};
		String[] sextoPeriodo = new String[]{"35", "36", "37", "38", "39", "40", "80", "81"};
		String[] setimoPeriodo = new String[]{"41", "42", "43", "82", "83", "84", "85"};
		String[] oitavoPeriodo = new String[]{"44", "86", "87", "88", "89", "90"};
		
		try {
			createPeriodo(1, primeiroPeriodo);
			createPeriodo(2, segundoPeriodo);
			createPeriodo(3, terceiroPeriodo);
			createPeriodo(4, quartoPeriodo);
			createPeriodo(5, quintoPeriodo);
			createPeriodo(6, sextoPeriodo);
			createPeriodo(7, setimoPeriodo);
			createPeriodo(8, oitavoPeriodo);
		} catch (TotalDeCreditosInvalidoException e){
			e.printStackTrace();
		}
	}
}