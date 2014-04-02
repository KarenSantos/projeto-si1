package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe da grade nova do curso de computacao.
 * 
 * @author
 *
 */
@Entity
@DiscriminatorValue("gNova")
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
		createDisciplina("n01", "Matematica Discreta 1", 4, 4);
		createDisciplina("n02", "Programação 1", 4, 3);
		createDisciplina("n03", "Laboratório de Programação 1", 4, 3);
		createDisciplina("n04", "Introdução a Computação", 4, 3);

		createDisciplina("n05", "Matematica Discreta 2", 4, new String[] { "n01"}, 4);
		createDisciplina("n06", "Cálculo Diferencial e Integral 1", 4, 4);
		createDisciplina("n07", "Programação 2", 4, new String[] { "n02", "n03"}, 3);
		createDisciplina("n08", "Laboratório de Programação 2", 4, new String[] { "n02", "n03"}, 3);
		
		createDisciplina("n09", "Álgebra Linear", 4, new String[] { "n01" }, 4);
		createDisciplina("n10", "Teoria dos Grafos", 4, 3);
		createDisciplina("n11", "Cálculo Diferencial e Integral 2", 4, new String[] { "n06" }, 5);
		createDisciplina("n12", "Estrutura de Dados", 4, new String[] { "n07", "n08" }, 4);
		createDisciplina("n13", "Laboratório de Estrutura de Dados", 4,new String[] { "n07", "n08" }, 4);
		createDisciplina("n14", "Lógica para Computação", 4, new String[] { "n01" }, 3);
		
		createDisciplina("n15", "Introdução à Probabilidade", 4,new String[] { "n06", "n11" }, 4);
		createDisciplina("n16", "Projeto de Software", 4, 3);
		createDisciplina("n17", "Paradigmas de Linguagens de Prog", 4, 3);
		createDisciplina("n18", "Bancos de Dados 1", 4, new String[] { "n12" }, 3);
		createDisciplina("n19", "Org. e Arquitetura de Computadores", 4, 3);
		createDisciplina("n20", "Lab de Org. e Arquitetura de Computadores", 4, 3);
		
		createDisciplina("n21", "Estatística Aplicada", 4,new String[] { "n15" }, 4);
		createDisciplina("n22", "Análise de Sistemas", 4, 4);
		createDisciplina("n23", "Engenharia de Software", 4, 3);
		createDisciplina("n24", "Redes de Computadores", 4, 3);
		createDisciplina("n25", "Sistemas Operacionais", 4, 3);
		createDisciplina("n26", "Teoria da Computação", 4, new String[] { "n17" }, 3);
		
		createDisciplina("n27", "Metodologia Científica", 4, 3);
		createDisciplina("n28", "Programação Concorrente", 4,new String[] { "n25" }, 4);
		createDisciplina("n29", "Inteligência Artificial", 4, new String[] { "n26" }, 3);
		
		createDisciplina("n30", "Análise e Técnicas de Algoritmos", 4, 3);
		createDisciplina("n31", "Compiladores", 4, 3);
		
		createDisciplina("n32", "Projeto em Computação 1", 4, new String[] { "n23" }, 3);
		createDisciplina("n33", "Trabalho de Conclusão de Curso 1", 4, 3);
		
		createDisciplina("n34", "Projeto em Computação 2", 4, new String[] { "n32" }, 3);
		createDisciplina("n35", "Trabalho de Conclusão de Curso 2", 4, new String[] { "n33" }, 3);
		
		
		// Optativas TECC
		createDisciplina("n100", "Administração de Sistemas", 4, new String[] { "n18" }, 3);
		createDisciplina("n101", "Algorítmos Avançados 1", 4, 3);
		createDisciplina("n102", "Algorítmos Avançados 2", 4, 3);
		createDisciplina("n103", "Algorítmos Avançados 3", 4, 3);
		createDisciplina("n104", "Algorítmos Avançados 4", 4, 3);
		createDisciplina("n105", "Arquitetura de Software", 4, new String[] { "n16" }, 3);
		createDisciplina("n106", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "n15" }, 3);
		createDisciplina("n107", "Banco de Dados 2", 4, new String[] { "n18" }, 3);
		
		//parei aqui
		
		
		
		createDisciplina("02", "Álgebra Vetorial e Geometria Analítica", 4,3);
		createDisciplina("03", "Leitura e Produção de Texto", 4, 2);

		createDisciplina("13", "Fundamentos de Física Clássica", 4,new String[] { "01", "02" }, 4);

		createDisciplina("19", "Fundamentos de Física Moderna", 4,new String[] { "07", "13" }, 4);
		createDisciplina("20", "Gerência da Informação", 4, 2);

		createDisciplina("21", "Métodos Estatísticos", 4, new String[] { "14","15" }, 3);
		createDisciplina("27", "Sistemas de Informação 1", 4,new String[] { "20" }, 3);

		createDisciplina("28", "Informática e Sociedade", 2, 3);
		createDisciplina("33", "Sistemas de Informação 2", 4,new String[] { "27" }, 3);
		createDisciplina("34", "Laboratório de Engenharia de Software", 2,new String[] { "26" }, 3);

		createDisciplina("35", "Direito e Cidadania", 4, 3);
		createDisciplina("37", "Interconexão de Redes de Comp.", 2,new String[] { "31" }, 3);
		createDisciplina("38", "Lab de Interconexão de Redes de Comp.", 2,new String[] { "31" }, 3);

		createDisciplina("41", "Métodos e Software Numéricos", 4, new String[] {"14", "29" }, 3);
		createDisciplina("43", "Projeto em Computação 1", 4, new String[] {"09", "34" }, 3);

		createDisciplina("44", "Projeto em Computação 2", 6,new String[] { "43" }, 3);

		createDisciplina("100", "Administração Financeira", 4, 3);
		createDisciplina("101", "Realidade Virtual", 4, new String[] { "27" }, 3);
		createDisciplina("103", "Análise de Dados 1", 4, new String[] { "15" }, 3);
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
		createDisciplina("n80", "Optativa Geral 1", 4, 3);
		createDisciplina("n81", "Optativa Geral 2", 4, 3);
		createDisciplina("n82", "Optativa Específica 1", 4, 3);
		createDisciplina("n83", "Optativa Específica 2", 4, 3);
		createDisciplina("n84", "Optativa Específica 3", 4, 3);
		createDisciplina("n85", "Optativa Específica 4", 4, 3);
		createDisciplina("n86", "Optativa Geral 3", 4, 3);
		createDisciplina("n87", "Optativa Específica 5", 4, 3);
		createDisciplina("n88", "Optativa Específica 6", 4, 3);
		createDisciplina("n89", "Optativa Geral 4", 4, 3);
		createDisciplina("n90", "Optativa Específica 7", 4, 3);
		createDisciplina("n91", "Optativa Específica 8", 4, 3);
		createDisciplina("n92", "Optativa Específica 9", 4, 3);
		createDisciplina("n93", "Optativa Específica 10", 4, 3);
		
		
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
		String[] nonoPeriodo = new String[]{"44", "86", "87", "88", "89", "90"};
		
		try {
			createPeriodo(1, primeiroPeriodo);
			createPeriodo(2, segundoPeriodo);
			createPeriodo(3, terceiroPeriodo);
			createPeriodo(4, quartoPeriodo);
			createPeriodo(5, quintoPeriodo);
			createPeriodo(6, sextoPeriodo);
			createPeriodo(7, setimoPeriodo);
			createPeriodo(8, oitavoPeriodo);
			createPeriodo(9, nonoPeriodo);
		} catch (TotalDeCreditosInvalidoException e){
			e.printStackTrace();
		}
	}
}