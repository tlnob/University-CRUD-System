package BancoDeDados;

/**
 * Interface para objetos que podem ser excluídos de uma Lista.
 * 
 * @author thais
 */

public interface Excluivel {

	/**
	 * @param id
	 *            identificador do objeto (p.ex. nome)
	 * @return true se o objeto tem o id igual ao dado.
	 */
	public boolean hasId(String id);

	/**
	 * Apaga o objeto de outros relacionamentos, p.ex. aluno --- projeto.
	 */
	public void excluir();

}
