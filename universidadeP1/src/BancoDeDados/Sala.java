//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;
import java.util.Arrays;

public class Sala implements Serializable, Excluivel {
	private String			numero;
	private String			bloco;
	private Disciplina[][]	horario	= new Disciplina[6][5];

	public Sala(String numero, String bloco) {
		super();
		this.numero = numero;
		this.bloco = bloco;
	}

	@Override
	public boolean hasId(String id) {
		return hasName(id);
	}

	// REVER SE ESTE MÉTODO RESERVA A SALA ESPECIFICA PARA O HORARIO
	public boolean reservaSala(Disciplina x, int dia, int hora, String numero) {
		if (this.horario[hora][dia] != null) {
			if (this.numero != null) {
				return false;
			}
		}
		this.horario[hora][dia] = x;
		return true;
	}

	public void imprimeMatriz() {
		for (int i = 0; i < horario.length; i++) {
			for (int j = 0; j < horario[0].length; j++) {
				System.out.print(horario[i][j] + "     ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean hasName(String numero) {
		return this.getNumero().equals(numero);
	}

	// EXCLUI SALA
	@Override
	public void excluir() {
		this.numero = null;
		this.bloco = null;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	@Override
	public String toString() {
		return "\nSala [numero=" + numero + ", horario=" + Arrays.toString(horario) + "]";
	}

}