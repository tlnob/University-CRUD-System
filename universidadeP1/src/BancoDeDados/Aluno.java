package BancoDeDados;

import java.util.ArrayList;

//Thais Lima de Oliveira Nobre 7163822
public class Aluno extends Pessoa {
	protected String						nUSP;
	protected String						senhaAluno;
	protected ArrayList<Disciplina>			listaDisciplina	= new ArrayList<Disciplina>();
	protected ArrayList<ProjetoExtensao>	listaProjeto	= new ArrayList<ProjetoExtensao>();

	public Aluno() {
	}

	public Aluno(String nome, String cPF, Data dataDeNascimento, Endereco endereco, String nUSP, String senhaAluno) {
		super(nome, cPF, dataDeNascimento, endereco);
		this.nUSP = nUSP;
		this.senhaAluno = senhaAluno;
	}

	public String getnUSP() {
		return nUSP;
	}

	public void setnUSP(String nUSP) {
		this.nUSP = nUSP;
	}

	public String getSenhaAluno() {
		return senhaAluno;
	}

	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
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

	public void setListaProjeto(ArrayList<ProjetoExtensao> listaProjetos) {
		this.listaProjeto = listaProjetos;
	}

	public void add(Disciplina disciplina) {
		listaDisciplina.add(disciplina);
	}

	public void add(ProjetoExtensao projeto) {
		listaProjeto.add(projeto);
	}

	// EXCLUIR ALUNO
	@Override
	public void excluir() {
		super.excluir();
		this.nUSP = null;
		this.senhaAluno = null;
		for (Disciplina d : this.getListaDisciplina()) {
			// EXCLUI ALUNO DE DISCIPLINAS
			d.excluirAluno(this);
		}
		for (ProjetoExtensao p : this.getListaProjeto()) {
			// EXCLUI ALUNO DE PROJETO
			p.excluir(this);
		}
	}

	public void excluirDisciplina(Disciplina disciplina) {
		listaDisciplina.remove(disciplina);
	}

	public void excluirProjeto(ProjetoExtensao projeto) {
		listaProjeto.remove(projeto);
	}

	@Override
	public String toString() {
		return "\nAluno [nome=" + nome + ", cPF=" + cPF + ", dataDeNascimento=" + dataDeNascimento + " Endereco: "
		        + this.endereco.logradouro + ", " + this.endereco.numero + ", " + this.endereco.bairro + ". CEP: "
		        + this.endereco.cep + ", " + this.endereco.cidade + "-" + this.endereco.estado + ".\n"
		        + this.endereco.pais + ". nUSP=" + nUSP + ", senhaAluno=" + senhaAluno + "]";
	}

	public String toStringFull() {
		return "\nAluno [nome=" + nome + ", cPF=" + cPF + ", dataDeNascimento=" + dataDeNascimento + " Endereco: "
		        + this.endereco.logradouro + ", " + this.endereco.numero + ", " + this.endereco.bairro + ". CEP: "
		        + this.endereco.cep + ", " + this.endereco.cidade + "-" + this.endereco.estado + ".\n"
		        + this.endereco.pais + ", nUSP=" + nUSP + ", senhaAluno=" + senhaAluno + ", listaDisciplina="
		        + listaDisciplina + ", listaProjetos=" + listaProjeto + "]";
	}

}