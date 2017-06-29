//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;

public class Endereco implements Serializable {
	protected String	logradouro;
	protected String	bairro;
	protected String	numero;
	protected String	cep;
	protected String	cidade, estado, pais;

	public Endereco(String logradouro, String bairro, String numero, String cep, String cidade, String estado,
	        String pais) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

}