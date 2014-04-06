package models;

/**
 * Interface de factory de curriculo
 * 
 *
 */
public interface CurriculoFactoryIF {

	/**
	 * Cria as disciplinas das grades
	 * @param grade
	 */
	void criaDisciplina(Grade grade);

	/**
	 * Cria e configura os periodos da grade
	 * @param grade
	 */
	void configuraPeriodo(Grade grade);

}
