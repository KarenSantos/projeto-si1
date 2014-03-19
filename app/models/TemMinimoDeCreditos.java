package models;

public class TemMinimoDeCreditos implements ValidadorDeAlocacao {

	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		boolean pode = false;
		if ((periodo.getTotalDeCreditos() - disciplina.getCreditos()) > periodo.getMinimoDeCreditos()){
			pode = true;
		}
		return pode;
	}

	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina) {
		return true;
	}

	
}
