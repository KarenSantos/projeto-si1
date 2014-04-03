package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe da grade comum do curso de computacao.
 * 
 * @author
 *
 */
@Entity
@DiscriminatorValue("gComum")
public class GradeComum extends Grade{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Cria uma grade curricular comum com uma lista de disciplinas e 
	 * periodos.
	 */
	public GradeComum(){
		super();
	}
	
	/**
	 * Cria todas as disciplinas da grade comum do curso de 
	 * computação.
	 */
	protected void criaDisciplinas() {
		//TODO essa ainda eh a antiga
		// Disciplinas obrigatórias
		createDisciplina("c01", "Cálculo Diferencial e Integral 1", 4, 4);
		createDisciplina("c02", "Álgebra Vetorial e Geometria Analítica", 4,3);
		createDisciplina("c03", "Leitura e Produção de Texto", 4, 2);
		createDisciplina("c04", "Programação 1", 4, 3);
		createDisciplina("c05", "Laboratório de Programação 1", 4, 3);
		createDisciplina("c06", "Introdução a Computação", 4, 3);

		createDisciplina("c07", "Cálculo Diferencial e Integral 2", 4,new String[] { "a01" }, 5);
		createDisciplina("c08", "Matematica Discreta", 4, 4);
		createDisciplina("c09", "Metodologia Científica", 4, 3);
		createDisciplina("c10", "Programação 2", 4, new String[] { "a04", "a05","a06" }, 3);
		createDisciplina("c11", "Laboratório de Programação 2", 4, new String[] {"a04", "a05", "a06" }, 3);
		createDisciplina("c12", "Teoria dos Grafos", 2, new String[] { "a04","a05" }, 3);
		createDisciplina("c13", "Fundamentos de Física Clássica", 4,new String[] { "a01", "a02" }, 4);

		createDisciplina("c14", "Álgebra Linear", 4, new String[] { "a02" }, 4);
		createDisciplina("c15", "Probabilidade e Estatística", 4,new String[] { "a07" }, 4);
		createDisciplina("c16", "Teoria da Computação", 4, new String[] { "a06","a08", "a12" }, 3);
		createDisciplina("c17", "Estruturas de Dados e Algoritmos", 4,new String[] { "a10", "a11", "a12" }, 4);
		createDisciplina("c18", "Lab de Estruturas de Dados e Algoritmos", 4,new String[] { "a10", "a11", "a12" }, 4);
		createDisciplina("c19", "Fundamentos de Física Moderna", 4,new String[] { "a07", "a13" }, 4);
		createDisciplina("c20", "Gerência da Informação", 4, 2);

		createDisciplina("c21", "Métodos Estatísticos", 4, new String[] { "a14","a15" }, 3);
		createDisciplina("c22", "Paradigmas de Linguagens de Prog", 2,new String[] { "a16", "a17", "a18" }, 3);
		createDisciplina("c23", "Lógica Matemática", 4, new String[] { "a16" }, 3);
		createDisciplina("c24", "Org. e Arquitetura de Computadores", 4,new String[] { "a17", "a18", "a19" }, 3);
		createDisciplina("c25", "Lab de Org. e Arquitetura de Computadores", 4,new String[] { "a17", "a18", "a19" }, 3);
		createDisciplina("c26", "Engenharia de Software 1", 4, new String[] {"a10", "a11", "a15" }, 3);
		createDisciplina("c27", "Sistemas de Informação 1", 4,new String[] { "a20" }, 3);

		createDisciplina("c28", "Informática e Sociedade", 2, 3);
		createDisciplina("c29", "Análise e Técnicas de Algoritmos", 4,new String[] { "a07", "a17", "a18", "a23" }, 3);
		createDisciplina("c30", "Compiladores", 4, new String[] { "a22", "a24","a25" }, 3);
		createDisciplina("c31", "Redes de Computadores", 4, new String[] { "a24","a25" }, 3);
		createDisciplina("c32", "Bancos de Dados 1", 4, new String[] { "a27" }, 3);
		createDisciplina("c33", "Sistemas de Informação 2", 4,new String[] { "a27" }, 3);
		createDisciplina("c34", "Laboratório de Engenharia de Software", 2,new String[] { "a26" }, 3);

		createDisciplina("c35", "Direito e Cidadania", 4, 3);
		createDisciplina("c36", "Sistemas Operacionais", 4, new String[] { "a24","a25" }, 3);
		createDisciplina("c37", "Interconexão de Redes de Comp.", 2,new String[] { "a31" }, 3);
		createDisciplina("c38", "Lab de Interconexão de Redes de Comp.", 2,new String[] { "a31" }, 3);
		createDisciplina("c39", "Banco de Dados 2", 4,new String[] { "a32", "a33" }, 3);
		createDisciplina("c40", "Inteligência Artificial 1", 4, new String[] {"a21", "a22", "a29" }, 3);

		createDisciplina("c41", "Métodos e Software Numéricos", 4, new String[] {"a14", "a29" }, 3);
		createDisciplina("c42", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "a15" }, 3);
		createDisciplina("c43", "Projeto em Computação 1", 4, new String[] {"a09", "a34" }, 3);

		createDisciplina("c44", "Projeto em Computação 2", 6,new String[] { "a43" }, 3);

		// Optativas TECC
		createDisciplina("c100", "Administração Financeira", 4, 3);
		createDisciplina("c101", "Realidade Virtual", 4, new String[] { "a27" }, 3);
		createDisciplina("c102", "Administração de Sistemas", 4, 3);
		createDisciplina("c103", "Análise de Dados 1", 4, new String[] { "a15" }, 3);
		createDisciplina("c104", "Arquitetura de Software", 4, new String[] {"a26", "a27" }, 3);
		createDisciplina("c105", "Desenvolvimento Dirigido a Modelos", 4,new String[] { "a26" }, 3);
		createDisciplina("c106", "Desenvolvimento de App Corporativas", 4,new String[] { "a27", "a32" }, 3);
		createDisciplina("c107", "Didática em Ciência da Computação", 2, 3);
		createDisciplina("c108", "Economia de TI", 4, 3);
		createDisciplina("c109", "Empreendedorismo em Software 1", 4, 3);
		createDisciplina("c110", "Estágio 2", 4, 3);
		
		// Optativas Outros Departamentos
		createDisciplina("c200", "Futsal", 2, 3);
		createDisciplina("c201", "Sociologia Industrial 1", 4, 3);
		createDisciplina("c202", "Basquete masc/fem", 2, 3);
		createDisciplina("c203", "Administração", 4, 3);
		createDisciplina("c204", "Economia", 4, 3);
		createDisciplina("c205", "Relações Humanas", 4, 3);
		createDisciplina("c206", "Cálculo Diferencial e Integral 3", 5, new String[] { "a07" }, 3);
		createDisciplina("c207", "Equações Diferenciais", 4, 3);
		createDisciplina("c208", "Ética", 4, 3);
		createDisciplina("c209", "Expressão Gráfica", 4, 3);
		createDisciplina("c210", "Futebol de Campo", 2, 3);
		createDisciplina("c220", "Gestão da Qualidade", 4, 3);
		createDisciplina("c221", "Ginástica Masc/Fem", 2, 3);
		createDisciplina("c222", "Inglês", 4, 3);
		createDisciplina("c223", "Introdução à Filosofia", 2, 3);
		createDisciplina("c224", "Processo Decisório", 4, 3);

		// Optativas Genericas
		createDisciplina("c80", "Optativa 1", 4, 3);
		createDisciplina("c81", "Optativa 2", 4, 3);
		createDisciplina("c82", "Optativa 3", 4, 3);
		createDisciplina("c83", "Optativa 4", 4, 3);
		createDisciplina("c84", "Optativa 5", 4, 3);
		createDisciplina("c85", "Optativa 6", 4, 3);
		createDisciplina("c86", "Optativa 7", 4, 3);
		createDisciplina("c87", "Optativa 8", 4, 3);
		createDisciplina("c88", "Optativa 9", 4, 3);
		createDisciplina("c89", "Optativa 10", 4, 3);
		createDisciplina("c90", "Optativa 11", 2, 3);
	}

	/**
	 * Configura todos os periodos da grade comum de acordo com
	 * a alocacao padrao.
	 */
	@Override
	protected void configuraPeriodos() {
		String[] primeiroPeriodo = new String[]{"c01", "c02", "c03", "c04", "c05", "c06"};
		String[] segundoPeriodo = new String[]{"c07", "c08", "c09", "c10", "c11", "c12", "c13"};
		String[] terceiroPeriodo = new String[]{"c14", "c15", "c16", "c17", "c18", "c19", "c20"};
		String[] quartoPeriodo = new String[]{"c21", "c22", "c23", "c24", "c25", "c26", "c27"};
		String[] quintoPeriodo = new String[]{"c28", "c29", "c30", "c31", "c32", "c33", "c34"};
		String[] sextoPeriodo = new String[]{"c35", "c36", "c37", "c38", "c39", "c40", "c80", "c81"};
		String[] setimoPeriodo = new String[]{"c41", "c42", "c43", "c82", "c83", "c84", "c85"};
		String[] oitavoPeriodo = new String[]{"c44", "c86", "c87", "c88", "c89", "c90"};
		
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
