//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;
import java.util.ArrayList;

abstract public class ProjetoExtensao implements Serializable, Excluivel {
	protected String			nome;
	protected String			area_de_estudos;
	protected Professor			professorResponsavel;
	protected ArrayList<Aluno>	listaAluno	= new ArrayList<Aluno>();

	public ProjetoExtensao() {

	}

	public ProjetoExtensao(String nome, String area_de_estudos) {
		super();
		this.nome = nome;
		this.area_de_estudos = area_de_estudos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea_de_estudos() {
		return area_de_estudos;
	}

	public void setArea_de_estudos(String area_de_estudos) {
		this.area_de_estudos = area_de_estudos;
	}

	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	public ArrayList<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(ArrayList<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public void add(Aluno aluno) {
		listaAluno.add(aluno);
	}

	public void matricular(Aluno aluno) {
		this.add(aluno);
		aluno.add(this);
	}

	public void matricular(Professor professor) {
		setProfessorResponsavel(professor);
		getProfessorResponsavel().add(this);
	}

	public void excluir(Aluno aluno) { // quando é excluido, projeto retira o
	                                   // nome
		listaAluno.remove(aluno);
	}

	public void excluir(Professor professor) { // quando é excluido, projeto
	                                           // retira o nome
		setProfessorResponsavel(null);
	}

	@Override
	public void excluir() { // exclui o projeto
		this.nome = null;
		this.area_de_estudos = null;
		this.getProfessorResponsavel().excluirProjeto(this);
		for (Aluno a : getListaAluno()) {
			a.excluirProjeto(this);
		}
	}

	public boolean hasName(String nome) {
		return this.getNome().equals(nome);
	}

}