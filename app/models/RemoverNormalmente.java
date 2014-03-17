package models;

public class RemoverNormalmente implements ValidadorRemocao {

	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		
		return (periodo.getTotalDeCreditos() - disciplina.getCreditos() >= periodo.getMinimoDeCreditos());
	}

}
