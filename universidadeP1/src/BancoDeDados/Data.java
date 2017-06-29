package BancoDeDados;

//Thais Lima de Oliveira Nobre 7163822
import java.io.Serializable;

public class Data implements Serializable {

	protected int dia, mes, ano;

	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	@Override
	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}

}