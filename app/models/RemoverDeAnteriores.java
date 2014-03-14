package models;

public class RemoverDeAnteriores implements ValidadorRemocao {

	@Override
	public boolean podeRemover(Periodo p, Disciplina d) {
		return true;
	}

}
