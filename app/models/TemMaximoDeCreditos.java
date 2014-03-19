package models;

import java.util.List;

public class TemMaximoDeCreditos implements ValidadorDeAlocacao {

	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		return true;
	}

	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina) {
		boolean pode = false;
		if ((periodo.getTotalDeCreditos() + disciplina.getCreditos()) <= periodo.getMaximoDeCreditos()){
			pode = true;
		}
		return pode;
	}

	@Override
	public boolean podeRemoverVarias(Periodo periodo,
			List<Disciplina> disciplinas) {
		return true;
	}

}
