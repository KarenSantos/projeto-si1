package models;

import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe da grade antiga do curso de computacao.
 * 
 * @author
 *
 */
@Entity
@DiscriminatorValue("gAntiga")
public class GradeAntiga extends Grade{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Cria uma grade curricular antiga com uma lista de disciplinas e 
	 * periodos.
	 */
	public GradeAntiga(){
		super();
	}
	
	/**
	 * Configura os atributos da grade e recebe um id.
	 * 
	 * @param id
	 *            O id da grade.
	 */
	@Override
	public void configuraGrade(String id) {
		setId(id);

		disciplinas = new ArrayList<Disciplina>();
		criaDisciplinas();

		periodos = new ArrayList<Periodo>();
		configuraPeriodos();
	}
	
	/**
	 * Cria todas as disciplinas da grade antiga do curso de 
	 * computação.
	 */
	private void criaDisciplinas() {
		
		//Se as disciplinas desta grade ainda nao existirem, cria disciplinas
		Disciplina discBD = Disciplina.find.byId("a01");
		if (discBD == null) {

			// Disciplinas obrigatórias
			createDisciplina("a01", "Cálculo Diferencial e Integral 1", 4, 4);
			createDisciplina("a02", "Álgebra Vetorial e Geometria Analítica", 4,3);
			createDisciplina("a03", "Leitura e Produção de Texto", 4, 2);
			createDisciplina("a04", "Programação 1", 4, 3);
			createDisciplina("a05", "Laboratório de Programação 1", 4, 3);
			createDisciplina("a06", "Introdução a Computação", 4, 3);
	
			createDisciplina("a07", "Cálculo Diferencial e Integral 2", 4,new String[] { "a01" }, 5);
			createDisciplina("a08", "Matematica Discreta", 4, 4);
			createDisciplina("a09", "Metodologia Científica", 4, 3);
			createDisciplina("a10", "Programação 2", 4, new String[] { "a04", "a05","a06" }, 3);
			createDisciplina("a11", "Laboratório de Programação 2", 4, new String[] {"a04", "a05", "a06" }, 3);
			createDisciplina("a12", "Teoria dos Grafos", 2, new String[] { "a04","a05" }, 3);
			createDisciplina("a13", "Fundamentos de Física Clássica", 4,new String[] { "a01", "a02" }, 4);
	
			createDisciplina("a14", "Álgebra Linear", 4, new String[] { "a02" }, 4);
			createDisciplina("a15", "Probabilidade e Estatística", 4,new String[] { "a07" }, 4);
			createDisciplina("a16", "Teoria da Computação", 4, new String[] { "a06","a08", "a12" }, 3);
			createDisciplina("a17", "Estruturas de Dados e Algoritmos", 4,new String[] { "a10", "a11", "a12" }, 4);
			createDisciplina("a18", "Lab de Estruturas de Dados e Algoritmos", 4,new String[] { "a10", "a11", "a12" }, 4);
			createDisciplina("a19", "Fundamentos de Física Moderna", 4,new String[] { "a07", "a13" }, 4);
			createDisciplina("a20", "Gerência da Informação", 4, 2);
	
			createDisciplina("a21", "Métodos Estatísticos", 4, new String[] { "a14","a15" }, 3);
			createDisciplina("a22", "Paradigmas de Linguagens de Prog", 2,new String[] { "a16", "a17", "a18" }, 3);
			createDisciplina("a23", "Lógica Matemática", 4, new String[] { "a16" }, 3);
			createDisciplina("a24", "Org. e Arquitetura de Computadores", 4,new String[] { "a17", "a18", "a19" }, 3);
			createDisciplina("a25", "Lab de Org. e Arquitetura de Computadores", 4,new String[] { "a17", "a18", "a19" }, 3);
			createDisciplina("a26", "Engenharia de Software 1", 4, new String[] {"a10", "a11", "a15" }, 3);
			createDisciplina("a27", "Sistemas de Informação 1", 4,new String[] { "a20" }, 3);
	
			createDisciplina("a28", "Informática e Sociedade", 2, 3);
			createDisciplina("a29", "Análise e Técnicas de Algoritmos", 4,new String[] { "a07", "a17", "a18", "a23" }, 3);
			createDisciplina("a30", "Compiladores", 4, new String[] { "a22", "a24","a25" }, 3);
			createDisciplina("a31", "Redes de Computadores", 4, new String[] { "a24","a25" }, 3);
			createDisciplina("a32", "Bancos de Dados 1", 4, new String[] { "a27" }, 3);
			createDisciplina("a33", "Sistemas de Informação 2", 4,new String[] { "a27" }, 3);
			createDisciplina("a34", "Laboratório de Engenharia de Software", 2,new String[] { "a26" }, 3);
	
			createDisciplina("a35", "Direito e Cidadania", 4, 3);
			createDisciplina("a36", "Sistemas Operacionais", 4, new String[] { "a24","a25" }, 3);
			createDisciplina("a37", "Interconexão de Redes de Comp.", 2,new String[] { "a31" }, 3);
			createDisciplina("a38", "Lab de Interconexão de Redes de Comp.", 2,new String[] { "a31" }, 3);
			createDisciplina("a39", "Banco de Dados 2", 4,new String[] { "a32", "a33" }, 3);
			createDisciplina("a40", "Inteligência Artificial 1", 4, new String[] {"a21", "a22", "a29" }, 3);
	
			createDisciplina("a41", "Métodos e Software Numéricos", 4, new String[] {"a14", "a29" }, 3);
			createDisciplina("a42", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "a15" }, 3);
			createDisciplina("a43", "Projeto em Computação 1", 4, new String[] {"a09", "a34" }, 3);
	
			createDisciplina("a44", "Projeto em Computação 2", 6,new String[] { "a43" }, 3);
	
			// Optativas TECC
			createDisciplina("a100", "Administração Financeira", 4, 3);
			createDisciplina("a101", "Realidade Virtual", 4, new String[] { "a27" }, 3);
			createDisciplina("a102", "Administração de Sistemas", 4, 3);
			createDisciplina("a103", "Análise de Dados 1", 4, new String[] { "a15" }, 3);
			createDisciplina("a104", "Arquitetura de Software", 4, new String[] {"a26", "a27" }, 3);
			createDisciplina("a105", "Desenvolvimento Dirigido a Modelos", 4,new String[] { "a26" }, 3);
			createDisciplina("a106", "Desenvolvimento de App Corporativas", 4,new String[] { "a27", "a32" }, 3);
			createDisciplina("a107", "Didática em Ciência da Computação", 2, 3);
			createDisciplina("a108", "Economia de TI", 4, 3);
			createDisciplina("a109", "Empreendedorismo em Software 1", 4, 3);
			createDisciplina("a110", "Estágio 2", 4, 3);
			createDisciplina("a111", "Fluxo de Trabalho Informatizado", 4, 3);
			createDisciplina("a112", "Fundamentos de Programação Concorrente", 4, new String[] { "a24", "a25" }, 3);
			createDisciplina("a113", "Int. ao Desenv. de Software para Disp. Móveis", 4, new String[] { "a11" }, 3);
			createDisciplina("a114", "Métodos Estatísticos e de Previsão", 4, new String[] { "a15" }, 3);
			createDisciplina("a115", "Metodologia Científica para Pesquisa", 4, 3);
			createDisciplina("a116", "Métodos Formais", 4, new String[] { "a17" }, 3);
			createDisciplina("a117", "Modelagem de Ambientes Virtuais", 4, new String[] { "a26", "a27" }, 3);
			createDisciplina("a118", "Programação em Banco de Dados", 4, new String[] { "a10", "a32" }, 3);
			createDisciplina("a119", "Programação 3", 4, new String[] { "a10", "a11" }, 3);
			createDisciplina("a120", "Redes Ad Hoc Sem Fio", 4, new String[] { "a31" }, 3);
			createDisciplina("a121", "Segurança em Redes de Computadores", 4, new String[] { "a31", "a37" }, 3);
			createDisciplina("a122", "Sistemas Cooperativos", 4, new String[] { "a26" }, 3);
			createDisciplina("a123", "Sistema de Recuperação da Informação", 4, new String[] { "a08", "a32" }, 3);
			createDisciplina("a124", "Visão Computacional", 4, new String[] { "a21", "a23" }, 3);
			createDisciplina("a125", "Mineração de Dados", 4, new String[] { "a32" }, 3);
			createDisciplina("a126", "Redes Sem Fio", 4, new String[] { "a31" }, 3);
			createDisciplina("a127", "Análise de Dados 2", 4, new String[] { "a103" }, 3);
			createDisciplina("a128", "Jogos Digitais", 4, new String[] { "a17" }, 3);
			createDisciplina("a129", "Progeto em Computação Gráfica", 4, new String[] { "a07", "a14", "a18" }, 3);
			
			// Optativas Outros Departamentos
			createDisciplina("a200", "Futsal", 2, 3);
			createDisciplina("a201", "Sociologia Industrial 1", 4, 3);
			createDisciplina("a202", "Basquete masc/fem", 2, 3);
			createDisciplina("a203", "Administração", 4, 3);
			createDisciplina("a204", "Economia", 4, 3);
			createDisciplina("a205", "Relações Humanas", 4, 3);
			createDisciplina("a206", "Cálculo Diferencial e Integral 3", 5, new String[] { "a07" }, 3);
			createDisciplina("a207", "Equações Diferenciais", 4, 3);
			createDisciplina("a208", "Ética", 4, 3);
			createDisciplina("a209", "Expressão Gráfica", 4, 3);
			createDisciplina("a210", "Futebol de Campo", 2, 3);
			createDisciplina("a220", "Gestão da Qualidade", 4, 3);
			createDisciplina("a221", "Ginástica Masc/Fem", 2, 3);
			createDisciplina("a222", "Inglês", 4, 3);
			createDisciplina("a223", "Introdução à Filosofia", 2, 3);
			createDisciplina("a224", "Processo Decisório", 4, 3);
	
			// Optativas Genericas
			createDisciplina("a80", "Optativa 1", 4, 3);
			createDisciplina("a81", "Optativa 2", 4, 3);
			createDisciplina("a82", "Optativa 3", 4, 3);
			createDisciplina("a83", "Optativa 4", 4, 3);
			createDisciplina("a84", "Optativa 5", 4, 3);
			createDisciplina("a85", "Optativa 6", 4, 3);
			createDisciplina("a86", "Optativa 7", 4, 3);
			createDisciplina("a87", "Optativa 8", 4, 3);
			createDisciplina("a88", "Optativa 9", 4, 3);
			createDisciplina("a89", "Optativa 10", 4, 3);
			createDisciplina("a90", "Optativa 11", 2, 3);
		}
	}

	/**
	 * Configura todos os periodos da grade antiga de acordo com
	 * a alocacao padrao.
	 */
	private void configuraPeriodos() {
		
		//Se os periodos desta grade ainda nao existirem, cria periodos
		Periodo periodoBD = Periodo.find.byId(getId() + PRIMEIRO_PERIODO);
		if (periodoBD == null) {
			
			String[] primeiroPeriodo = new String[]{"a01", "a02", "a03", "a04", "a05", "a06"};
			String[] segundoPeriodo = new String[]{"a07", "a08", "a09", "a10", "a11", "a12", "a13"};
			String[] terceiroPeriodo = new String[]{"a14", "a15", "a16", "a17", "a18", "a19", "a20"};
			String[] quartoPeriodo = new String[]{"a21", "a22", "a23", "a24", "a25", "a26", "a27"};
			String[] quintoPeriodo = new String[]{"a28", "a29", "a30", "a31", "a32", "a33", "a34"};
			String[] sextoPeriodo = new String[]{"a35", "a36", "a37", "a38", "a39", "a40", "a80", "a81"};
			String[] setimoPeriodo = new String[]{"a41", "a42", "a43", "a82", "a83", "a84", "a85"};
			String[] oitavoPeriodo = new String[]{"a44", "a86", "a87", "a88", "a89", "a90"};
			
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
}
