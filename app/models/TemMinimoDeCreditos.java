package models;

import java.util.List;

public class TemMinimoDeCreditos implements ValidadorDeAlocacao {

	/**
	 * Indica se uma disciplina pode ser removida de um periodo.
	 * 
	 * @param periodo
	 *            O periodo de onde se vai remover a disciplina.
	 * @param disciplina
	 *            A disciplina a ser removida do periodo.
	 * @return True se a disciplina pode ser removida ou false caso contrario.
	 */
	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		boolean pode = false;
		if ((periodo.getTotalDeCreditos() - disciplina.getCreditos()) >= periodo
				.getMinimoDeCreditos()) {
			pode = true;
		}
		return pode;
	}

	/**
	 * Indica se varias disciplinas podem ser removidas de um unico periodo.
	 * 
	 * @param periodo
	 *            O periodo de onde se vai remover as disciplinas.
	 * @param disciplinas
	 *            A lista de disciplinas a serem removidas do periodo.
	 * @return True se as disciplinas podem ser removida ou false caso
	 *         contrario.
	 */
	@Override
	public boolean podeRemoverVarias(Periodo periodo,
			List<Disciplina> disciplinas) {
		boolean pode = false;
		int numCreditos = 0;
		for (Disciplina disciplina : disciplinas) {
			numCreditos += disciplina.getCreditos();
		}
		if (periodo.getTotalDeCreditos() - numCreditos >= periodo
				.getMinimoDeCreditos()) {
			pode = true;
		}
		return pode;
	}

	/**
	 * Indica se uma disciplina pode ser adicionada em um periodo.
	 * 
	 * @param periodo
	 *            O periodo onde se vai adicionar a disciplina.
	 * @param disciplina
	 *            A disciplina a ser adicionada no periodo.
	 * @return True se a disciplina pode ser adicionada ou false caso contrario.
	 */
	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina) {
		return true;
	}
	
	/**
	 * Um validador TemMinimoDeCreditos eh igual a outro se for do mesmo tipo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TemMinimoDeCreditos) {
			return true;
		}
		return false;
	}
}
