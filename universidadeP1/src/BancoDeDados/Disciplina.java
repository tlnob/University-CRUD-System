//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable, Excluivel {
	private String					nomeDisciplina;
	private String					numeroCreditos;
	private ArrayList<Aluno>		alunos		= new ArrayList<Aluno>();
	private ArrayList<Professor>	professores	= new ArrayList<Professor>();

	public Disciplina(String nomeDisciplina, String numeroCreditos) {
		this.nomeDisciplina = nomeDisciplina;
		this.numeroCreditos = numeroCreditos;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public void add(Aluno aluno) {
		alunos.add(aluno);
	}

	public void matricular(Aluno aluno) {
		this.add(aluno);
		aluno.add(this);
	}

	public void add(Professor professor) {
		professores.add(professor);
	}

	public void matricular(Professor professor) {
		this.add(professor);
		professor.add(this);
	}

	public String getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(String numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public boolean hasName(String nome) {
		return this.getNomeDisciplina().equals(nome);
	}

	// método da interface, para realizar a busca pelo id
	@Override
	public boolean hasId(String nome) {
		return hasName(nome);
	}

	@Override
	public void excluir() {
		this.nomeDisciplina = null;
		this.numeroCreditos = null;
		for (Aluno a : this.getAlunos()) { // EXCLUI DISCIPLINA NAS QUAIS ALUNO
		                                   // ESTA MATRICULADO
			a.excluirDisciplina(this);
		}
		for (Professor p : this.getProfessores()) { // EXCLUI DISCIPLINA NAS
		                                            // QUAIS PROFESSOR ESTA
		                                            // MATRICULADO
			p.excluirDisciplina(this);
		}
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public void excluirProfessor(Professor professor) {
		professores.remove(professor);
	}

	public void excluirAluno(Aluno aluno) {
		alunos.remove(aluno);
	}

	@Override
	public String toString() {
		return "\nDisciplina [nomeDisciplina=" + nomeDisciplina + ", numeroCreditos=" + numeroCreditos + "]";
	}

	public String toStringFull() {
		return "\nDisciplina [nomeDisciplina=" + nomeDisciplina + ", numeroCreditos=" + numeroCreditos + ", listaAluno="
		        + alunos + "]";
	}
}