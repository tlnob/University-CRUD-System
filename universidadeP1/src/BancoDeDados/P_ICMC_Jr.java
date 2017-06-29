//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;

public class P_ICMC_Jr extends ProjetoExtensao implements Serializable {
	protected String CNPJ_contratos;

	public P_ICMC_Jr() {

	}

	public P_ICMC_Jr(String nome, String area_de_estudos, String cNPJ_contratos) {
		super(nome, area_de_estudos);
		CNPJ_contratos = cNPJ_contratos;
	}

	public String getCNPJ_contratos() {
		return CNPJ_contratos;
	}

	public void setCNPJ_contratos(String cNPJ_contratos) {
		CNPJ_contratos = cNPJ_contratos;
	}

	@Override
	public String toString() {
		return "\nP_ICMC_Jr [nome=" + nome + ", area_de_estudos=" + area_de_estudos + ", professorResponsavel="
		        + professorResponsavel + ", CNPJ_contratos=" + CNPJ_contratos + "]";
	}

	public String toStringFull() {
		return "\nP_ICMC_Jr [nome=" + nome + ", area_de_estudos=" + area_de_estudos + ", professorResponsavel="
		        + professorResponsavel + ", CNPJ_contratos=" + CNPJ_contratos + ", listaAluno=" + listaAluno + "]";
	}

	@Override
	public void excluir() {
		super.excluir();
		this.CNPJ_contratos = null;
	}

	@Override
	public boolean hasId(String nome) {
		return hasName(nome);
	}

}
