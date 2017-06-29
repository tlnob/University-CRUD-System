//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;

public class P_FOG extends ProjetoExtensao implements Serializable {
	protected String licencaSoftware;

	public P_FOG() {

	}

	public P_FOG(String nome, String area_de_estudos, String licencaSoftware) {
		super(nome, area_de_estudos);
		this.licencaSoftware = licencaSoftware;
	}

	@Override
	public String toString() {
		return "\nP_FOG [nome=" + nome + ", area_de_estudos=" + area_de_estudos + ", professorResponsavel="
		        + professorResponsavel + "licencaSoftware=" + licencaSoftware + "]";
	}

	public String toStringFull() {
		return "\nP_FOG [nome=" + nome + ", area_de_estudos=" + area_de_estudos + ", professorResponsavel="
		        + professorResponsavel + ", licenca_software=" + licencaSoftware + ", listaAluno=" + listaAluno + "]";
	}

	public String getLicencaSoftware() {
		return licencaSoftware;
	}

	public void setLicencaSoftware(String licencaSoftware) {
		this.licencaSoftware = licencaSoftware;
	}

	@Override
	public void excluir() {
		super.excluir();
		this.licencaSoftware = null;
	}

	@Override
	public boolean hasId(String nome) {
		return hasName(nome);
	}

}
