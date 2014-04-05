package models;

public class CurriculoAntigoFactory implements CurriculoFactoryIF {

	@Override
	public void criaDisciplina(Grade g) {
		//Se as disciplinas desta grade ainda nao existirem, cria disciplinas
				Disciplina discBD = Disciplina.find.byId("a01");
				if (discBD == null) {

					// Disciplinas obrigatórias
					g.createDisciplina("a01", "Cálculo Diferencial e Integral 1", 4, 4);
					g.createDisciplina("a02", "Álgebra Vetorial e Geometria Analítica", 4,3);
					g.createDisciplina("a03", "Leitura e Produção de Texto", 4, 2);
					g.createDisciplina("a04", "Programação 1", 4, 3);
					g.createDisciplina("a05", "Laboratório de Programação 1", 4, 3);
					g.createDisciplina("a06", "Introdução a Computação", 4, 3);
			
					g.createDisciplina("a07", "Cálculo Diferencial e Integral 2", 4,new String[] { "a01" }, 5);
					g.createDisciplina("a08", "Matematica Discreta", 4, 4);
					g.createDisciplina("a09", "Metodologia Científica", 4, 3);
					g.createDisciplina("a10", "Programação 2", 4, new String[] { "a04", "a05","a06" }, 3);
					g.createDisciplina("a11", "Laboratório de Programação 2", 4, new String[] {"a04", "a05", "a06" }, 3);
					g.createDisciplina("a12", "Teoria dos Grafos", 2, new String[] { "a04","a05" }, 3);
					g.createDisciplina("a13", "Fundamentos de Física Clássica", 4,new String[] { "a01", "a02" }, 4);
			
					g.createDisciplina("a14", "Álgebra Linear", 4, new String[] { "a02" }, 4);
					g.createDisciplina("a15", "Probabilidade e Estatística", 4,new String[] { "a07" }, 4);
					g.createDisciplina("a16", "Teoria da Computação", 4, new String[] { "a06","a08", "a12" }, 3);
					g.createDisciplina("a17", "Estruturas de Dados e Algoritmos", 4,new String[] { "a10", "a11", "a12" }, 4);
					g.createDisciplina("a18", "Lab de Estruturas de Dados e Algoritmos", 4,new String[] { "a10", "a11", "a12" }, 4);
					g.createDisciplina("a19", "Fundamentos de Física Moderna", 4,new String[] { "a07", "a13" }, 4);
					g.createDisciplina("a20", "Gerência da Informação", 4, 2);
			
					g.createDisciplina("a21", "Métodos Estatísticos", 4, new String[] { "a14","a15" }, 3);
					g.createDisciplina("a22", "Paradigmas de Linguagens de Prog", 2,new String[] { "a16", "a17", "a18" }, 3);
					g.createDisciplina("a23", "Lógica Matemática", 4, new String[] { "a16" }, 3);
					g.createDisciplina("a24", "Org. e Arquitetura de Computadores", 4,new String[] { "a17", "a18", "a19" }, 3);
					g.createDisciplina("a25", "Lab de Org. e Arquitetura de Computadores", 4,new String[] { "a17", "a18", "a19" }, 3);
					g.createDisciplina("a26", "Engenharia de Software 1", 4, new String[] {"a10", "a11", "a15" }, 3);
					g.createDisciplina("a27", "Sistemas de Informação 1", 4,new String[] { "a20" }, 3);
			
					g.createDisciplina("a28", "Informática e Sociedade", 2, 3);
					g.createDisciplina("a29", "Análise e Técnicas de Algoritmos", 4,new String[] { "a07", "a17", "a18", "a23" }, 3);
					g.createDisciplina("a30", "Compiladores", 4, new String[] { "a22", "a24","a25" }, 3);
					g.createDisciplina("a31", "Redes de Computadores", 4, new String[] { "a24","a25" }, 3);
					g.createDisciplina("a32", "Bancos de Dados 1", 4, new String[] { "a27" }, 3);
					g.createDisciplina("a33", "Sistemas de Informação 2", 4,new String[] { "a27" }, 3);
					g.createDisciplina("a34", "Laboratório de Engenharia de Software", 2,new String[] { "a26" }, 3);
			
					g.createDisciplina("a35", "Direito e Cidadania", 4, 3);
					g.createDisciplina("a36", "Sistemas Operacionais", 4, new String[] { "a24","a25" }, 3);
					g.createDisciplina("a37", "Interconexão de Redes de Comp.", 2,new String[] { "a31" }, 3);
					g.createDisciplina("a38", "Lab de Interconexão de Redes de Comp.", 2,new String[] { "a31" }, 3);
					g.createDisciplina("a39", "Banco de Dados 2", 4,new String[] { "a32", "a33" }, 3);
					g.createDisciplina("a40", "Inteligência Artificial 1", 4, new String[] {"a21", "a22", "a29" }, 3);
			
					g.createDisciplina("a41", "Métodos e Software Numéricos", 4, new String[] {"a14", "a29" }, 3);
					g.createDisciplina("a42", "Av. de Desempenho de Sistemas Discretos", 4, new String[] { "a15" }, 3);
					g.createDisciplina("a43", "Projeto em Computação 1", 4, new String[] {"a09", "a34" }, 3);
			
					g.createDisciplina("a44", "Projeto em Computação 2", 6,new String[] { "a43" }, 3);
			
					// Optativas TECC
					g.createDisciplina("a100", "Administração Financeira", 4, 3);
					g.createDisciplina("a101", "Realidade Virtual", 4, new String[] { "a27" }, 3);
					g.createDisciplina("a102", "Administração de Sistemas", 4, 3);
					g.createDisciplina("a103", "Análise de Dados 1", 4, new String[] { "a15" }, 3);
					g.createDisciplina("a104", "Arquitetura de Software", 4, new String[] {"a26", "a27" }, 3);
					g.createDisciplina("a105", "Desenvolvimento Dirigido a Modelos", 4,new String[] { "a26" }, 3);
					g.createDisciplina("a106", "Desenvolvimento de App Corporativas", 4,new String[] { "a27", "a32" }, 3);
					g.createDisciplina("a107", "Didática em Ciência da Computação", 2, 3);
					g.createDisciplina("a108", "Economia de TI", 4, 3);
					g.createDisciplina("a109", "Empreendedorismo em Software 1", 4, 3);
					g.createDisciplina("a110", "Estágio 2", 4, 3);
					g.createDisciplina("a111", "Fluxo de Trabalho Informatizado", 4, 3);
					g.createDisciplina("a112", "Fundamentos de Programação Concorrente", 4, new String[] { "a24", "a25" }, 3);
					g.createDisciplina("a113", "Int. ao Desenv. de Software para Disp. Móveis", 4, new String[] { "a11" }, 3);
					g.createDisciplina("a114", "Métodos Estatísticos e de Previsão", 4, new String[] { "a15" }, 3);
					g.createDisciplina("a115", "Metodologia Científica para Pesquisa", 4, 3);
					g.createDisciplina("a116", "Métodos Formais", 4, new String[] { "a17" }, 3);
					g.createDisciplina("a117", "Modelagem de Ambientes Virtuais", 4, new String[] { "a26", "a27" }, 3);
					g.createDisciplina("a118", "Programação em Banco de Dados", 4, new String[] { "a10", "a32" }, 3);
					g.createDisciplina("a119", "Programação 3", 4, new String[] { "a10", "a11" }, 3);
					g.createDisciplina("a120", "Redes Ad Hoc Sem Fio", 4, new String[] { "a31" }, 3);
					g.createDisciplina("a121", "Segurança em Redes de Computadores", 4, new String[] { "a31", "a37" }, 3);
					g.createDisciplina("a122", "Sistemas Cooperativos", 4, new String[] { "a26" }, 3);
					g.createDisciplina("a123", "Sistema de Recuperação da Informação", 4, new String[] { "a08", "a32" }, 3);
					g.createDisciplina("a124", "Visão Computacional", 4, new String[] { "a21", "a23" }, 3);
					g.createDisciplina("a125", "Mineração de Dados", 4, new String[] { "a32" }, 3);
					g.createDisciplina("a126", "Redes Sem Fio", 4, new String[] { "a31" }, 3);
					g.createDisciplina("a127", "Análise de Dados 2", 4, new String[] { "a103" }, 3);
					g.createDisciplina("a128", "Jogos Digitais", 4, new String[] { "a17" }, 3);
					g.createDisciplina("a129", "Progeto em Computação Gráfica", 4, new String[] { "a07", "a14", "a18" }, 3);
					
					// Optativas Outros Departamentos
					g.createDisciplina("a200", "Futsal", 2, 3);
					g.createDisciplina("a201", "Sociologia Industrial 1", 4, 3);
					g.createDisciplina("a202", "Basquete masc/fem", 2, 3);
					g.createDisciplina("a203", "Administração", 4, 3);
					g.createDisciplina("a204", "Economia", 4, 3);
					g.createDisciplina("a205", "Relações Humanas", 4, 3);
					g.createDisciplina("a206", "Cálculo Diferencial e Integral 3", 5, new String[] { "a07" }, 3);
					g.createDisciplina("a207", "Equações Diferenciais", 4, 3);
					g.createDisciplina("a208", "Ética", 4, 3);
					g.createDisciplina("a209", "Expressão Gráfica", 4, 3);
					g.createDisciplina("a210", "Futebol de Campo", 2, 3);
					g.createDisciplina("a220", "Gestão da Qualidade", 4, 3);
					g.createDisciplina("a221", "Ginástica Masc/Fem", 2, 3);
					g.createDisciplina("a222", "Inglês", 4, 3);
					g.createDisciplina("a223", "Introdução à Filosofia", 2, 3);
					g.createDisciplina("a224", "Processo Decisório", 4, 3);
			
					// Optativas Genericas
					g.createDisciplina("a80", "Optativa 1", 4, 3);
					g.createDisciplina("a81", "Optativa 2", 4, 3);
					g.createDisciplina("a82", "Optativa 3", 4, 3);
					g.createDisciplina("a83", "Optativa 4", 4, 3);
					g.createDisciplina("a84", "Optativa 5", 4, 3);
					g.createDisciplina("a85", "Optativa 6", 4, 3);
					g.createDisciplina("a86", "Optativa 7", 4, 3);
					g.createDisciplina("a87", "Optativa 8", 4, 3);
					g.createDisciplina("a88", "Optativa 9", 4, 3);
					g.createDisciplina("a89", "Optativa 10", 4, 3);
					g.createDisciplina("a90", "Optativa 11", 2, 3);
				}

	}

	@Override
	public void configuraPeriodo(Grade g) {
		// TODO Auto-generated method stub
		
		//Se os periodos desta grade ainda nao existirem, cria periodos
		//Periodo periodoBD = Periodo.find.byId(getId() + PRIMEIRO_PERIODO);
		if (Periodo.find.all().size() == 0) {
			
			String[] primeiroPeriodo = new String[]{"a01", "a02", "a03", "a04", "a05", "a06"};
			String[] segundoPeriodo = new String[]{"a07", "a08", "a09", "a10", "a11", "a12", "a13"};
			String[] terceiroPeriodo = new String[]{"a14", "a15", "a16", "a17", "a18", "a19", "a20"};
			String[] quartoPeriodo = new String[]{"a21", "a22", "a23", "a24", "a25", "a26", "a27"};
			String[] quintoPeriodo = new String[]{"a28", "a29", "a30", "a31", "a32", "a33", "a34"};
			String[] sextoPeriodo = new String[]{"a35", "a36", "a37", "a38", "a39", "a40", "a80", "a81"};
			String[] setimoPeriodo = new String[]{"a41", "a42", "a43", "a82", "a83", "a84", "a85"};
			String[] oitavoPeriodo = new String[]{"a44", "a86", "a87", "a88", "a89", "a90"};
			
			try {
				g.createPeriodo(1, primeiroPeriodo);
				g.createPeriodo(2, segundoPeriodo);
				g.createPeriodo(3, terceiroPeriodo);
				g.createPeriodo(4, quartoPeriodo);
				g.createPeriodo(5, quintoPeriodo);
				g.createPeriodo(6, sextoPeriodo);
				g.createPeriodo(7, setimoPeriodo);
				g.createPeriodo(8, oitavoPeriodo);
			} catch (TotalDeCreditosInvalidoException e){
				e.printStackTrace();
			}
		}

	}

}
