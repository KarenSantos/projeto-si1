package models;

/**
 * Factory de curriculo novo
 * @author
 *
 */
public class CurriculoNovoFactory implements CurriculoFactoryIF {

	@Override
	public void criaDisciplina(Grade g) {

		//Se as disciplinas desta grade ainda nao existirem, cria disciplinas
		Disciplina discBD = Disciplina.find.byId("n01");
		if (discBD == null) {

			// Disciplinas obrigatórias
			g.createDisciplina("n01", "Matematica Discreta 1", 4, 4);
			g.createDisciplina("n02", "Programação 1", 4, 3);
			g.createDisciplina("n03", "Laboratório de Programação 1", 4, 3);
			g.createDisciplina("n04", "Introdução a Computação", 4, 3);

			g.createDisciplina("n05", "Matematica Discreta 2", 4, new String[] { "n01"}, 4);
			g.createDisciplina("n06", "Cálculo Diferencial e Integral 1", 4, 4);
			g.createDisciplina("n07", "Programação 2", 4, new String[] { "n02", "n03"}, 3);
			g.createDisciplina("n08", "Laboratório de Programação 2", 4, new String[] { "n02", "n03"}, 3);

			g.createDisciplina("n09", "Álgebra Linear", 4, new String[] { "n01" }, 4);
			g.createDisciplina("n10", "Teoria dos Grafos", 4, 3);
			g.createDisciplina("n11", "Cálculo Diferencial e Integral 2", 4, new String[] { "n06" }, 5);
			g.createDisciplina("n12", "Estrutura de Dados e Algoritmos", 4, new String[] { "n07", "n08" }, 4);
			g.createDisciplina("n13", "Lab. de Estrutura de Dados e Algoritmos", 4,new String[] { "n07", "n08" }, 4);
			g.createDisciplina("n14", "Lógica para Computação", 4, new String[] { "n01" }, 3);

			g.createDisciplina("n15", "Introdução à Probabilidade", 4,new String[] { "n06", "n11" }, 4);
			g.createDisciplina("n16", "Projeto de Software", 4, 3);
			g.createDisciplina("n17", "Paradigmas de Linguagens de Prog", 4, 3);
			g.createDisciplina("n18", "Bancos de Dados 1", 4, new String[] { "n12" }, 3);
			g.createDisciplina("n19", "Org. e Arquitetura de Computadores", 4, 3);
			g.createDisciplina("n20", "Lab de Org. e Arquitetura de Computadores", 4, 3);

			g.createDisciplina("n21", "Estatística Aplicada", 4,new String[] { "n15" }, 4);
			g.createDisciplina("n22", "Análise de Sistemas", 4, 4);
			g.createDisciplina("n23", "Engenharia de Software", 4, 3);
			g.createDisciplina("n24", "Redes de Computadores", 4, 3);
			g.createDisciplina("n25", "Sistemas Operacionais", 4, 3);
			g.createDisciplina("n26", "Teoria da Computação", 4, new String[] { "n17" }, 3);

			g.createDisciplina("n27", "Metodologia Científica", 4, 3);
			g.createDisciplina("n28", "Programação Concorrente", 4,new String[] { "n25" }, 4);
			g.createDisciplina("n29", "Inteligência Artificial", 4, new String[] { "n26" }, 3);

			g.createDisciplina("n30", "Análise e Técnicas de Algoritmos", 4, 3);
			g.createDisciplina("n31", "Compiladores", 4, 3);

			g.createDisciplina("n32", "Projeto em Computação 1", 4, new String[] { "n23" }, 3);
			g.createDisciplina("n33", "Trabalho de Conclusão de Curso 1", 4, 3);

			g.createDisciplina("n34", "Projeto em Computação 2", 4, new String[] { "n32" }, 3);
			g.createDisciplina("n35", "Trabalho de Conclusão de Curso 2", 4, new String[] { "n33" }, 3);


			// Optativas TECC
			g.createDisciplina("n100", "Administração de Sistemas", 4, new String[] { "n18" }, 3);
			g.createDisciplina("n101", "Algorítmos Avançados 1", 4, 3);
			g.createDisciplina("n102", "Algorítmos Avançados 2", 4, 3);
			g.createDisciplina("n103", "Algorítmos Avançados 3", 4, 3);
			g.createDisciplina("n104", "Algorítmos Avançados 4", 4, 3);
			g.createDisciplina("n105", "Arquitetura de Software", 4, new String[] { "n16" }, 3);
			g.createDisciplina("n106", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "n15" }, 3);
			g.createDisciplina("n107", "Banco de Dados 2", 4, new String[] { "n18" }, 3);
			g.createDisciplina("n108", "Computação Gráfica", 4, 3);
			g.createDisciplina("n109", "Computação e Música", 4, new String[] { "n12" }, 3);
			g.createDisciplina("n110", "Economia de Tecnologia da Informação", 4, 3);
			g.createDisciplina("n111", "Empreendedorismo em Software", 4, 3);
			g.createDisciplina("n112", "Gerência de Redes", 4, new String[] { "n24" }, 3);
			g.createDisciplina("n113", "Interconexão de Redes de Computadores", 4, new String[] { "n24" }, 3);
			g.createDisciplina("n114", "Interface Homem-Máquina", 4, 3);
			g.createDisciplina("n115", "Otimização", 4, 3);
			g.createDisciplina("n116", "Métodos e Software Numéricos", 4, 3);
			g.createDisciplina("n117", "Métodos Formais", 4, 3);
			g.createDisciplina("n118", "Prática de Ensino em Computação 1", 4, 3);
			g.createDisciplina("n119", "Prática de Ensino em Computação 2", 4, new String[] { "n118" }, 3);
			g.createDisciplina("n120", "Princípios de Desenvolvimento Web", 4, new String[] { "n07", "n08" }, 3);
			g.createDisciplina("n121", "Programação em Banco de Dados", 4, new String[] { "n18" }, 3);
			g.createDisciplina("n122", "Projeto de Redes de Computadores", 4, new String[] { "n24" }, 3);
			g.createDisciplina("n123", "Reconhecimento de Padrões e Redes Neurais", 4, new String[] { "n21", "n30" }, 3);
			g.createDisciplina("n124", "Recuperação da Informação e Busca na Web", 4, 3);
			g.createDisciplina("n125", "Segurança de Redes", 4, new String[] { "n24" }, 3);
			g.createDisciplina("n126", "Sistemas de Apoio à Decisão", 4, 3);
			g.createDisciplina("n127", "Sistemas de Informação Geográfica", 4, 3);
			g.createDisciplina("n128", "Sistemas Distribuídos", 4, 3);
			g.createDisciplina("n129", "Tópicos em Ciência da Computação 1", 4, 3);
			g.createDisciplina("n130", "Tópicos em Ciência da Computação 2", 4, 3);
			g.createDisciplina("n131", "Tópicos em Ciência da Computação 3", 4, 3);
			g.createDisciplina("n132", "Tópicos em Ciência da Computação 4", 4, 3);
			g.createDisciplina("n133", "Verificação e Validação de Software", 4, new String[] { "n23" }, 3);
			g.createDisciplina("n134", "Visão Computacional", 4, 3);


			// Optativas Outros Departamentos
			g.createDisciplina("n200", "Administração e Empreendedorismo", 4, 3);
			g.createDisciplina("n201", "Álgebra Vetorial e Geometria Analítica", 4, 3);
			g.createDisciplina("n202", "Cálculo Diferencial e Integral 3", 5, new String[] { "n05", "n11" }, 3);
			g.createDisciplina("n203", "Direito e Cidadania", 4, 3);
			g.createDisciplina("n204", "Economia", 4, 3);
			g.createDisciplina("n205", "Física Geral 1", 4, 4);
			g.createDisciplina("n206", "Física Geral 2", 4, new String[] { "n205", "n01", "n06" }, 4);
			g.createDisciplina("n207", "Física Geral 3", 4, new String[] { "n206", "n11" }, 4);
			g.createDisciplina("n208", "Física Geral 4", 4, new String[] { "n207", "n202"}, 5);
			g.createDisciplina("n209", "Informática e Sociedade", 2, 3);
			g.createDisciplina("n210", "Inglês", 4, 3);
			g.createDisciplina("n211", "Libras: Linguagem Brasileira de Sinais", 4, 3);
			g.createDisciplina("n212", "Língua Portuguesa", 4, 3);
			g.createDisciplina("n213", "Tópicos em Humanidades 1", 4, 3);
			g.createDisciplina("n214", "Tópicos em Humanidades 2", 4, 3);

			// Optativas Genericas
			g.createDisciplina("n80", "Optativa Geral 1", 4, 3);
			g.createDisciplina("n81", "Optativa Geral 2", 4, 3);
			g.createDisciplina("n82", "Optativa Específica 1", 4, 3);
			g.createDisciplina("n83", "Optativa Específica 2", 4, 3);
			g.createDisciplina("n84", "Optativa Específica 3", 4, 3);
			g.createDisciplina("n85", "Optativa Específica 4", 4, 3);
			g.createDisciplina("n86", "Optativa Geral 3", 4, 3);
			g.createDisciplina("n87", "Optativa Específica 5", 4, 3);
			g.createDisciplina("n88", "Optativa Específica 6", 4, 3);
			g.createDisciplina("n89", "Optativa Geral 4", 4, 3);
			g.createDisciplina("n90", "Optativa Específica 7", 4, 3);
			g.createDisciplina("n91", "Optativa Específica 8", 4, 3);
			g.createDisciplina("n92", "Optativa Específica 9", 4, 3);
			g.createDisciplina("n93", "Optativa Específica 10", 4, 3);
		}

	}

	@Override
	public void configuraPeriodo(Grade g) {
		//Se os periodos desta grade ainda nao existirem, cria periodos
		Periodo periodoBD = Periodo.find.byId(g.getId() + g.PRIMEIRO_PERIODO);
		if (periodoBD == null) {

			String[] primeiroPeriodo = new String[]{"n01", "n02", "n03", "n04", "n80"};
			String[] segundoPeriodo = new String[]{"n05", "n06", "n07", "n08", "n81"};
			String[] terceiroPeriodo = new String[]{"n09", "n10", "n11", "n12", "n13", "n14"};
			String[] quartoPeriodo = new String[]{"n15", "n16", "n17", "n18", "n19", "n20"};
			String[] quintoPeriodo = new String[]{"n21", "n22", "n23", "n24", "n25", "n26"};
			String[] sextoPeriodo = new String[]{"n27", "n28", "n29", "n82", "n83"};
			String[] setimoPeriodo = new String[]{"n30", "n31", "n84", "n85", "n86"};
			String[] oitavoPeriodo = new String[]{"n32", "n33", "n87", "n88", "n89"};
			String[] nonoPeriodo = new String[]{"n34", "n35", "n90", "n91", "n92", "n93"};

			try {
				g.createPeriodo(1, primeiroPeriodo);
				g.createPeriodo(2, segundoPeriodo);
				g.createPeriodo(3, terceiroPeriodo);
				g.createPeriodo(4, quartoPeriodo);
				g.createPeriodo(5, quintoPeriodo);
				g.createPeriodo(6, sextoPeriodo);
				g.createPeriodo(7, setimoPeriodo);
				g.createPeriodo(8, oitavoPeriodo);
				g.createPeriodo(9, nonoPeriodo);
			} catch (TotalDeCreditosInvalidoException e){
				e.printStackTrace();
			}
		}

	}

}