package models;

import java.util.*;

public interface ValidadorDeAlocacao {

	public boolean podeRemover(Periodo periodo, Disciplina disciplina);
	
	public boolean podeRemoverVarias(Periodo periodo, List<Disciplina> disciplinas);
	
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina);

}
