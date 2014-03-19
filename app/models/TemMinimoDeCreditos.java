package models;

import java.util.List;

public class TemMinimoDeCreditos implements ValidadorDeAlocacao {

	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		boolean pode = false;
		if ((periodo.getTotalDeCreditos() - disciplina.getCreditos()) >= periodo.getMinimoDeCreditos()){
			pode = true;
		}
		return pode;
	}

	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina) {
		return true;
	}

	@Override
	public boolean podeRemoverVarias(Periodo periodo,
			List<Disciplina> disciplinas) {
		boolean pode = false;
		int numCreditos = 0;
		for (Disciplina disciplina : disciplinas) {
			numCreditos += disciplina.getCreditos();
		}
		if(periodo.getTotalDeCreditos() - numCreditos >= periodo.getMinimoDeCreditos()){
			pode = true;
		}
		return pode;
	}

	
}
