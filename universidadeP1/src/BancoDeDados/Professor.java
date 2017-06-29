//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.util.ArrayList;

public class Professor extends Pessoa {
	protected String						salario;
	protected String						senhaProfessor;
	protected ArrayList<Disciplina>			listaDisciplina	= new ArrayList<Disciplina>();
	protected ArrayList<ProjetoExtensao>	listaProjeto	= new ArrayList<ProjetoExtensao>();

	public Professor(String nome, String cPF, Data dataDeNascimento, Endereco endereco, String salario,
	        String senhaProfessor) {
		super(nome, cPF, dataDeNascimento, endereco);
		this.salario = salario;
		this.senhaProfessor = senhaProfessor;
	}

	@Override
	public String toString() {
		return "\nProfessor [nome=" + nome + ", cPF=" + cPF + ", dataDeNascimento=" + dataDeNascimento + ", endereco="
		        + " Endereco: " + this.endereco.logradouro + ", " + this.endereco.numero + ", " + this.endereco.bairro
		        + ". CEP: " + this.endereco.cep + ", " + this.endereco.cidade + "-" + this.endereco.estado + ".\n"
		        + this.endereco.pais + ", salario=" + salario + ", senhaProfessor=" + senhaProfessor + "]";
	}

	public String toStringFull() {
		return "\nProfessor [nome=" + nome + ", cPF=" + cPF + ", dataDeNascimento=" + dataDeNascimento + " Endereco: "
		        + this.endereco.logradouro + ", " + this.endereco.numero + ", " + this.endereco.bairro + ". CEP: "
		        + this.endereco.cep + ", " + this.endereco.cidade + "-" + this.endereco.estado + ".\n"
		        + this.endereco.pais + ", salario=" + salario + ", senhaProfessor=" + senhaProfessor
		        + ", listaDisciplina=" + listaDisciplina + ", listaProjetos=" + listaProjeto + "]";
	}

	@Override
	public void excluir() {
		super.excluir();
		this.salario = null;
		this.senhaProfessor = null;
		for (Disciplina d : this.getListaDisciplina()) { // EXCLUI PROFESSOR
		                                                 // DA DISCIPLINA
			d.excluirProfessor(this);
		}
		for (ProjetoExtensao p : this.getListaProjeto()) { // EXCLUI PROFESSOR
		                                                   // DO PROJETO DE
		                                                   // EXTENSAO
			p.excluir(this);
		}
	}

	public void add(Disciplina disciplina) {
		listaDisciplina.add(disciplina);
	}

	public void add(ProjetoExtensao projeto) {
		listaProjeto.add(projeto);
	}

	public void excluirDisciplina(Disciplina disciplina) {
		listaDisciplina.remove(disciplina);
	}

	public void excluirProjeto(ProjetoExtensao projeto) {
		listaProjeto.remove(projeto);
	}
	// SETTLERS E GETTERS

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getSenhaProfessor() {
		return senhaProfessor;
	}

	public void setSenhaProfessor(String senhaProfessor) {
		this.senhaProfessor = senhaProfessor;
	}

	public ArrayList<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(ArrayList<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public ArrayList<ProjetoExtensao> getListaProjeto() {
		return listaProjeto;
	}

	public void setListaProjeto(ArrayList<ProjetoExtensao> listaProjeto) {
		this.listaProjeto = listaProjeto;
	}

}