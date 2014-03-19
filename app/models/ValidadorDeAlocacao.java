package models;

public interface ValidadorDeAlocacao {

	public boolean podeRemover(Periodo periodo, Disciplina disciplina);
	
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina);

}
