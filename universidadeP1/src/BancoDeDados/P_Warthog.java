//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;

public class P_Warthog extends ProjetoExtensao implements Serializable {
	protected String listaMateriais;

	public P_Warthog() {

	}

	public P_Warthog(String nome, String area_de_estudos, String listaMateriais) {
		super(nome, area_de_estudos);
		this.listaMateriais = listaMateriais;
	}

	public String getListaMateriais() {
		return listaMateriais;
	}

	public void setListaMateriais(String listaMateriais) {
		this.listaMateriais = listaMateriais;
	}

	@Override
	public String toString() {
		return "\nP_Warthog [nome=" + nome + ", area_de_estudos=" + area_de_estudos + ", professorResponsavel="
		        + professorResponsavel + ", listaMateriais=" + listaMateriais + "]";
	}

	public String toStringFull() {
		return "\nP_Warthog [nome=" + nome + ", area_de_estudos=" + area_de_estudos + ", professorResponsavel="
		        + professorResponsavel + ", listaMateriais=" + listaMateriais + ", listaAluno=" + listaAluno + "]";
	}

	@Override
	public void excluir() {
		super.excluir();
		this.listaMateriais = null;
	}

	@Override
	public boolean hasId(String nome) {
		return hasName(nome);
	}

}
