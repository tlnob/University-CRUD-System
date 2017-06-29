//Thais Lima de Oliveira Nobre 7163822
package BancoDeDados;

import java.io.Serializable;

abstract public class Pessoa implements Serializable, Excluivel {

	protected String	nome;
	protected String	cPF;
	protected Data		dataDeNascimento;
	protected Endereco	endereco;

	public Pessoa() {
	}

	public Pessoa(String nome, String cPF, Data dataDeNascimento, Endereco endereco) {
		this.nome = nome;
		this.cPF = cPF;
		Data data = new Data(dataDeNascimento.dia, dataDeNascimento.mes, dataDeNascimento.ano);
		this.dataDeNascimento = data;
		this.endereco = new Endereco(endereco.logradouro, endereco.bairro, endereco.numero, endereco.cep,
		        endereco.cidade, endereco.estado, endereco.pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getcPF() {
		return cPF;
	}

	public void setcPF(String cPF) {
		this.cPF = cPF;
	}

	public Data getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Data dataDeNascimento) {
		this.dataDeNascimento.dia = dataDeNascimento.dia;
		this.dataDeNascimento.mes = dataDeNascimento.mes;
		this.dataDeNascimento.ano = dataDeNascimento.ano;
	}

	public void setDia(int dia) {
		this.dataDeNascimento.dia = dia;
	}

	public void setMes(int mes) {
		this.dataDeNascimento.mes = mes;
	}

	public void setAno(int ano) {
		this.dataDeNascimento.ano = ano;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco.logradouro = endereco.logradouro;
		this.endereco.bairro = endereco.bairro;
		this.endereco.numero = endereco.numero;
		this.endereco.cep = endereco.cep;
		this.endereco.cidade = endereco.cidade;
		this.endereco.estado = endereco.estado;
		this.endereco.pais = endereco.pais;
	}

	public void setLogradouro(String logradouro) {
		this.endereco.logradouro = logradouro;
	}

	public void setBairro(String bairro) {
		this.endereco.bairro = bairro;
	}

	public void setNumero(String numero) {
		this.endereco.numero = numero;
	}

	public void setCep(String cep) {
		this.endereco.cep = cep;
	}

	public void setCidade(String cidade) {
		this.endereco.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.endereco.estado = estado;
	}

	public void setPais(String pais) {
		this.endereco.pais = pais;
	}

	public boolean hasName(String nome) {
		return this.getNome().equals(nome);
	}

	@Override
	public void excluir() {
		this.nome = null;
		this.cPF = null;
		this.dataDeNascimento = null;
		this.endereco = null;
	}

	@Override
	public boolean hasId(String id) {
		return hasName(id);
	}

}
