//Thais Lima de Oliveira Nobre 7163822
package Exemplos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import BancoDeDados.Aluno;
import BancoDeDados.Data;
import BancoDeDados.Disciplina;
import BancoDeDados.Endereco;
import BancoDeDados.Excluivel;
import BancoDeDados.P_FOG;
import BancoDeDados.P_ICMC_Jr;
import BancoDeDados.P_Warthog;
import BancoDeDados.Professor;
import BancoDeDados.ProjetoExtensao;
import BancoDeDados.Sala;

public class Teste {

	protected static ArrayList<Aluno>		listaAluno		= new ArrayList<Aluno>();
	protected static ArrayList<Sala>		listaSala		= new ArrayList<Sala>();
	protected static ArrayList<Disciplina>	listaDisciplina	= new ArrayList<Disciplina>();
	protected static ArrayList<Professor>	listaProfessor	= new ArrayList<Professor>();

	protected static ArrayList<P_Warthog>	listaWarthog	= new ArrayList<P_Warthog>();
	protected static ArrayList<P_ICMC_Jr>	listaICMCJR		= new ArrayList<P_ICMC_Jr>();
	protected static ArrayList<P_FOG>		listaFOG		= new ArrayList<P_FOG>();

	protected static Teste					teste;

	private static int opcaoMenu(int min, int max, Scanner scannr) {
		// FUNCAO PARA RECEBER OS POSSIVEIS ERROS DO MENU E TAMBEM DEFINIR AS
		// OPCOES POSSIVEIS
		// PARA CADA SUBMENU
		// parâmetro min e max de acordo com o minimo e maximo de opcoes do
		// submenu
		int numeroEscolhido = -1;
		String oDigitado = scannr.next();
		try {
			numeroEscolhido = Integer.parseInt(oDigitado); // CONVERTE NUMERO
			                                               // DIGITADO PARA
			                                               // INTEIRO
		} catch (NumberFormatException e) { // ERRO DE FORMATO
		}
		while ((numeroEscolhido < min) || (numeroEscolhido > max)) {
			// CASO ESTEJA FORA DO NÚMERO
			// DE INDICES DO MENU: ERRO!
			System.out.printf("Escolha um numero entre %d e %d, ou ZERO para terminar ", min, max);
			oDigitado = scannr.next();
			try {
				numeroEscolhido = Integer.parseInt(oDigitado);
			} catch (NumberFormatException e) {
				numeroEscolhido = 999;
			}
		}
		return numeroEscolhido;
	}

	private static int mostraMenu(Scanner scannr) {
		System.out.println();
		System.out.println("* Digite um dos numeros abaixo: ");
		// MENU PRINCIPAL
		System.out.println(" 1: Cadastrar");
		System.out.println(" 2: Visualizar");
		System.out.println(" 3: Excluir");
		System.out.println(" 4: Matricular alunos");
		System.out.println(" 5: Matricular professores");
		System.out.println(" 6: Reservar salas para disciplina");
		System.out.println(" 0:  para SAIR");

		System.out.print("> ");
		int opcaoMenuPrincipal = opcaoMenu(0, 6, scannr);

		int opcaoSubMenu = -1;
		// SUBMENUS
		if (opcaoMenuPrincipal == 1) {
			System.out.println("1: Cadastrar Professor");
			System.out.println("2: Cadastrar Aluno");
			System.out.println("3: Cadastrar Disciplina");
			System.out.println("4: Cadastrar Sala");
			System.out.println("5: Cadastrar projeto Warthog");
			System.out.println("6: Cadastrar projeto ICMC Jr");
			System.out.println("7: Cadastrar projeto FOG");
			System.out.println("0:  para VOLTAR AO MENU PRINCIPAL");
			opcaoSubMenu = opcaoMenu(0, 7, scannr);
		} else if (opcaoMenuPrincipal == 2) {
			System.out.println("1: Mostrar Professor");
			System.out.println("2: Mostrar Aluno");
			System.out.println("3: Mostrar Disciplina");
			System.out.println("4: Mostrar Sala");
			System.out.println("5: Mostrar projeto Warthog");
			System.out.println("6: Mostrar projeto ICMC Jr");
			System.out.println("7: Mostrar projeto FOG");
			System.out.println("0:  para VOLTAR AO MENU PRINCIPAL");
			opcaoSubMenu = opcaoMenu(0, 7, scannr);
		} else if (opcaoMenuPrincipal == 3) {
			System.out.println("1: Excluir Professor");
			System.out.println("2: Excluir Aluno");
			System.out.println("3: Excluir Disciplina");
			System.out.println("4: Excluir Sala");
			System.out.println("5: Excluir projeto Warthog");
			System.out.println("6: Excluir projeto ICMC Jr");
			System.out.println("7: Excluir projeto FOG");
			System.out.println("0:  para VOLTAR AO MENU PRINCIPAL");
			opcaoSubMenu = opcaoMenu(0, 7, scannr);
		} else if (opcaoMenuPrincipal == 4) {
			System.out.println("1. Matricular aluno em disciplina");
			System.out.println("2. Matricular aluno em projeto Warthog");
			System.out.println("3. Matricular aluno em projeto ICMC Jr");
			System.out.println("4. Matricular aluno em projeto FOG");
			System.out.println("0:  para VOLTAR AO MENU PRINCIPAL");
			opcaoSubMenu = opcaoMenu(0, 4, scannr);
		} else if (opcaoMenuPrincipal == 5) {
			System.out.println("1. Matricular professor em disciplina(Digite 1)");
			System.out.println("0:  para VOLTAR AO MENU PRINCIPAL");
			opcaoSubMenu = opcaoMenu(0, 1, scannr);
		} else if (opcaoMenuPrincipal == 6) {
			System.out.println("1. Reservar uma sala para disciplina(Digite 1)");
			System.out.println("0:  para VOLTAR AO MENU PRINCIPAL");
			opcaoSubMenu = opcaoMenu(0, 1, scannr);
		} else if (opcaoMenuPrincipal == 0) {
			teste.exit(1);
		}
		return opcaoMenuPrincipal * 10 + opcaoSubMenu;
		// para facilitar a escolha de opcao de menu na main optei por
		// multiplicar a opcao do menu principal *10 somando com a de submenu
	}

	// se o dado informado retornar true, ele obriga o usuário a digitar
	// novamente um dado válido
	private static boolean checaDadoInvalido(String dado) {
		try {
			Float.parseFloat(dado);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	// Remove o primeiro elemento da {lista} de excluíveis cujo identificador
	// (p.ex. nome) seja igual ao parâmetro {id} informado.
	// lista: lista de objetos que implementam a interface Excluível
	// id: identificador para encontrar o objeto a ser removido
	private static void excluirObjeto(Collection<? extends Excluivel> lista, String id) {
		Excluivel excluido = null;
		for (Excluivel p : lista) {
			// procura um objeto pelo id e o exclui
			if (p.hasId(id)) {
				excluido = p;
				break;
			}
		}
		if (excluido != null) {
			excluido.excluir();
			lista.remove(excluido);
			System.out.println("Removido com sucesso\n");
		} else {
			System.out.println("Não encontrou " + id);
		}
	}

	public int processarOpcao(Scanner info, int op) { // MENU SWITCH / CASE
		if (op == 0) {
			System.out.println("\n*** FINAL DE EXECUÇÃO ***\n");
			exit(0);
		}

		switch (op) { // VER OPÇAO DE SAIR DO CASE E VOLTAR PARA O MENU GERAL
		// cases com valores de menu principal * 10 + submenu
		case 11: // CADASTRA PROFESSOR
			System.out.println("\nEntrar dados de Professores:\n");
			Professor um_professor = incluiNovoProfessor(info); // INSERE NOVO
			                                                    // PROFESSOR
			listaProfessor.add(um_professor); // ADICIONA NOVO PROFESSOR AO
			                                  // VETOR DE ALUNOS
			System.out.println("Incluido com sucesso");
			break;

		case 12: // CADASTRA ALUNO
			System.out.println("\nEntrar dados de Aluno:\n");
			Aluno um_aluno = incluiNovoAluno(info); // INSERE NOVO ALUNO
			listaAluno.add(um_aluno); // ADICIONA NOVO ALUNO AO VETOR DE ALUNOS
			System.out.println("Incluido com sucesso");
			break;

		case 13: // CADASTRA DISCIPLINA
			System.out.println("\nEntrar dados de Disciplinas:\n");
			Disciplina uma_disciplina = incluiNovaDisciplina(info); // INSERE
			                                                        // NOVA
			                                                        // DISCIPLINA
			listaDisciplina.add(uma_disciplina); // ADICIONA NOVA DISCIPLINA AO
			                                     // VETOR DE ALUNOS
			System.out.println("Incluido com sucesso");
			break;

		case 14: // CADASTRA SALA
			System.out.println("\nEntrar dados de Salas:");
			Sala sala = incluiNovaSala(info);
			listaSala.add(sala);
			System.out.println("Incluido com sucesso");
			break;

		case 15: // CADASTRA NOVO PROJETO WARTHOG
			System.out.println("\nEntrar dados de Warthog:");
			P_Warthog warthog = incluiNovoProjetoWarthog(info);

			System.out.println(listaProfessor.toString());
			System.out.println("Nome do professor responsável: ");
			String warthogInputProfessor = info.useDelimiter("\\n").next();
			int i;
			// PROCURA O NOME DO PROFESSOR DIGITADO NA LISTA DE PROFESSOR
			for (Professor p : listaProfessor) {
				// procura um professor pelo nome e o exclui
				if (p.hasName(warthogInputProfessor)) {
					warthog.matricular(p);
					listaWarthog.add(warthog);
					System.out.println("Incluido com sucesso");
					break;
				}
			}

			break;

		case 16: // CADASTRA NOVO PROJETO ICMC_JR
			System.out.println("\nEntrar dados de ICMC_Jr:");
			P_ICMC_Jr icmc = incluiNovoProjetoICMCJr(info);
			System.out.println(listaProfessor.toString());
			System.out.println("Nome professor responsável: ");
			String icmcInputProfessor = info.useDelimiter("\\n").next();
			// PROCURA O NOME DO PROFESSOR DIGITADO NA LISTA DE PROFESSOR
			for (Professor p : listaProfessor) {
				if (p.hasName(icmcInputProfessor)) {
					icmc.setProfessorResponsavel(p);
					icmc.matricular(p);
					listaICMCJR.add(icmc);
					System.out.println("Incluido com sucesso");
					break;
				}
			}

			break;

		case 17: // CADASTRA NOVO PROJETO FOG
			System.out.println("\nEntrar dados de FOG:");
			P_FOG fog = incluiNovoProjetoFOG(info);
			System.out.println(listaProfessor.toString());
			System.out.println("Nome professor responsável: ");
			String fogInputProfessor = info.useDelimiter("\\n").next();
			// PROCURA O NOME DO PROFESSOR DIGITADO NA LISTA DE PROFESSOR
			for (Professor p : listaProfessor) {
				if (p.hasName(fogInputProfessor)) {
					fog.setProfessorResponsavel(p);
					fog.matricular(p);
					listaFOG.add(fog);
					System.out.println("Incluido com sucesso");
				}
			}

			break;

		case 21: // MOSTRA PROFESSOR
			System.out.println("\n1. Para lista completa. 2. Para busca por nome:\n");
			int opM = info.nextInt();
			while (opM > 2 || opM < 1) {
				System.out.println("Opcao inválida. 1. Para lista completa. 2. Para busca por nome:\n");
				opM = info.nextInt();
			}
			if (opM == 1) {
				for (Professor d : listaProfessor) {
					System.out.println(d.toStringFull());
				}
			} else if (opM == 2) {
				System.out.println("\nDigite o nome do professor a ser mostrado:\n");
				String nomeProfessor = info.useDelimiter("\\n").next();
				for (Professor p : listaProfessor) {
					// procura um professor pelo nome e o exclui
					if (p.hasName(nomeProfessor)) {
						System.out.println(p.toStringFull());
						break;
					}
				}
			}
			break;

		case 22: // MOSTRA ALUNO
			System.out.println("1. Para lista completa. 2. Para busca por nome:\n");
			int opM1 = info.nextInt();
			while (opM1 > 2 || opM1 < 1) {
				System.out.println("Opcao inválida. 1. Para lista completa. 2. Para busca por nome:\n");
				opM1 = info.nextInt();
			}
			if (opM1 == 1) {
				for (Aluno d : listaAluno) {
					System.out.println(d.toStringFull());
				}
			} else if (opM1 == 2) {
				System.out.println("\nDigite o nome do aluno a ser mostrado:\n");
				String nomeAluno = info.useDelimiter("\\n").next();
				for (Aluno a : listaAluno) {
					// procura um professor pelo nome e o exclui
					if (a.hasName(nomeAluno)) {
						System.out.println(a.toStringFull());
						break;
					}
				}
			}
			break;

		case 23: // MOSTRA DISCIPLINA
			System.out.println("\n1. Para lista completa. 2. Para busca por nome:\n");
			int opM2 = info.nextInt();
			while (opM2 < 1 || opM2 > 2) {
				System.out.println("Opcao inválida. 1. Para lista completa. 2. Para busca por nome:\n");
				opM2 = info.nextInt();
			}
			if (opM2 == 1) {
				for (Disciplina d : listaDisciplina) {
					System.out.println(d.toStringFull());
				}
			} else if (opM2 == 2) {
				System.out.println("\nDigite o nome da disciplina a ser mostrada:\n");
				String nomeDisciplina = info.useDelimiter("\\n").next();
				for (Disciplina d : listaDisciplina) {
					// procura
					if (d.hasName(nomeDisciplina)) {
						System.out.println(d.toStringFull());
						break;
					}
				}
			}
			break;

		case 24: // MOSTRA SALA
			System.out.println("\n1. Para lista completa. 2. Para busca por nome:\n");
			int opM3 = info.nextInt();
			while (opM3 > 2 || opM3 < 1) {
				System.out.println("Opcao inválida. 1. Para lista completa. 2. Para busca por nome:\n");
				opM3 = info.nextInt();
			}
			if (opM3 == 1) {
				System.out.println(listaSala.toString());
			} else if (opM3 == 2) {
				System.out.println("\nDigite o numero da sala a ser mostrada:\n");
				String numero = info.useDelimiter("\\n").next();
				for (Sala s : listaSala) {
					if (s.hasName(numero)) {
						System.out.println(s.toString());
						break;
					}
				}
			}
			break;

		case 25: // MOSTRA WARTHOG
			System.out.println("Lista de projetos cadastrados Warthog:");
			for (P_Warthog d : listaWarthog) {
				System.out.println(d.toStringFull());
			}
			break;

		case 26: // MOSTRA ICMC_JR
			System.out.println("Lista de projetos cadastrados ICMC Jr:");
			for (P_ICMC_Jr d : listaICMCJR) {
				System.out.println(d.toStringFull());
			}

			break;

		case 27: // MOSTRA FOG
			System.out.println("Lista de projetos cadastrados Warthog:");
			for (P_FOG d : listaFOG) {
				System.out.println(d.toStringFull());
			}
			break;

		case 31: // EXCLUI PROFESSOR
			System.out.println("Professores cadastrados:\n");
			System.out.println(listaProfessor.toString());
			System.out.println("\nNome do professor a ser excluído:\n");
			String nomeProfessor1 = info.useDelimiter("\\n").next();
			excluirObjeto(listaProfessor, nomeProfessor1);
			break;

		case 32: // EXCLUI ALUNO
			System.out.println("Alunos cadastrados:\n");
			System.out.println(listaAluno.toString());
			System.out.println("\nNome do aluno a ser excluído:\n");
			String nomeAluno1 = info.useDelimiter("\\n").next();
			excluirObjeto(listaAluno, nomeAluno1);
			break;

		case 33: // EXCLUI DISCIPLINA
			System.out.println("Disciplinas cadastradas:\n");
			System.out.println(listaDisciplina.toString());
			System.out.println("\nNome da disciplina a ser excluída:\n");
			String nomeDisciplina1 = info.useDelimiter("\\n").next();
			excluirObjeto(listaDisciplina, nomeDisciplina1);

			System.out.printf("Lista sem %s:", nomeDisciplina1 + "\n" + listaDisciplina.toString());
			break;

		case 34: // EXCLUI SALA
			System.out.println("Salas cadastradas:\n");
			System.out.println(listaSala.toString());
			System.out.println("\nNúmero da sala ser excluída:\n");
			String numero1 = info.useDelimiter("\\n").next();
			excluirObjeto(listaSala, numero1);
			break;

		case 35: // EXCLUI WARTHOG
			System.out.println("Projetos cadastrados:\n");
			System.out.println(listaWarthog.toString());
			System.out.println("\nNome do projeto do Warthog a ser excluído:\n");
			String nomePWarthog = info.useDelimiter("\\n").next();
			ProjetoExtensao projetoExcluido = null;
			excluirObjeto(listaWarthog, nomePWarthog);

			break;
		case 36: // EXCLUI ICMC_JR
			System.out.println("Projetos cadastrados:\n");
			System.out.println(listaICMCJR.toString());
			System.out.println("\nNome do projeto do ICMC Jr a ser excluído:\n");
			String nomePjr = info.useDelimiter("\\n").next();
			excluirObjeto(listaICMCJR, nomePjr);
			break;

		case 37: // EXCLUI FOG
			System.out.println("Projetos cadastrados:\n");
			System.out.println(listaFOG.toString());
			System.out.println("\nNome do projeto FOG a ser excluído:\n");
			String nomePFog = info.useDelimiter("\\n").next();
			excluirObjeto(listaFOG, nomePFog);
			break;

		case 41: // MATRICULAR ALUNOS EM DISCIPLINA
			System.out.println("Alunos cadastrados:\n");
			System.out.println(listaAluno.toString());
			System.out.println("\nNome do aluno:\n");
			String nomeAluno2 = info.useDelimiter("\\n").next();

			System.out.println("Disciplinas cadastradas:\n");
			System.out.println(listaDisciplina.toString());
			System.out.println("\nNome da disciplina:\n");
			String nomeDisciplina2 = info.useDelimiter("\\n").next();

			for (Aluno a : listaAluno) {
				for (Disciplina d : listaDisciplina) {
					if (a.hasName(nomeAluno2) && d.hasName(nomeDisciplina2)) {
						d.matricular(a);
						System.out.println("Matriculado com sucesso\n");
						break;
					}
				}
			}
			for (Disciplina a : listaDisciplina) {
				System.out.println(a.toStringFull());
			}

			break;

		case 42: // MATRICULAR ALUNOS EM PROJETO WARTHOG
			System.out.println("Alunos cadastrados:\n");
			System.out.println(listaAluno.toString());

			System.out.println("\nNome do aluno:\n");
			String nomeAluno3 = info.useDelimiter("\\n").next();

			System.out.println("\nProjetos cadastrados:\n");
			System.out.println(listaWarthog.toString());

			System.out.println("Nome do projeto warthog:\n");
			String nomeP = info.useDelimiter("\\n").next();

			// PROCURA O INPUT DO USUARIO E MATRICULA
			for (Aluno a : listaAluno) {
				for (P_Warthog d : listaWarthog) {
					if (a.hasName(nomeAluno3) && d.hasName(nomeP)) {
						d.matricular(a);
						System.out.println("Matriculado com sucesso\n");
						break;
					}
				}
			}

			for (P_Warthog d : listaWarthog) {
				System.out.println(d.toStringFull());
			}
			break;

		case 43: // MATRICULAR ALUNO EM PROJETO ICMC JR
			System.out.println("Alunos cadastrados:\n");
			System.out.println(listaAluno.toString());
			System.out.println("Digite um aluno cadastrado:\n");
			String nomeAluno4 = info.useDelimiter("\\n").next();

			System.out.println("Projetos cadastrados:\n");
			System.out.println(listaICMCJR.toString());
			System.out.println("Digite um projeto cadastrado:\n");
			String nomeICMC = info.useDelimiter("\\n").next();

			// PROCURA O INPUT DO USUARIO E MATRICULA
			for (Aluno a : listaAluno) {
				for (P_ICMC_Jr d : listaICMCJR) {
					if (a.hasName(nomeAluno4) && d.hasName(nomeICMC)) {
						d.matricular(a);
						System.out.println("Matriculado com sucesso\n");
						break;
					}
				}
			}
			for (P_ICMC_Jr d : listaICMCJR) {
				System.out.println(d.toStringFull());
			}
			break;

		case 44: // MATRICULAR ALUNOS EM PROJETO FOG
			System.out.println("Alunos cadastrados:\n");
			System.out.println(listaAluno.toString());
			System.out.println("Nome do aluno:\n");
			String nomeAluno5 = info.useDelimiter("\\n").next();

			System.out.println("Projetos cadastrados:\n");
			System.out.println(listaFOG.toString());
			System.out.println("Nome do projeto FOG:\n");
			String nomeFOG = info.useDelimiter("\\n").next();

			// PROCURA O INPUT DO USUARIO E MATRICULA
			for (Aluno a : listaAluno) {
				for (P_FOG d : listaFOG) {
					if (a.hasName(nomeAluno5) && d.hasName(nomeFOG)) {
						d.matricular(a);
						System.out.println("Matriculado com sucesso\n");
						break;
					}
				}
			}

			for (P_FOG d : listaFOG) {
				System.out.println(d.toStringFull());
			}
			break;

		case 51: // MATRICULAR PROFESSORES
			System.out.println("Professores cadastrados:\n");
			System.out.println(listaProfessor.toString());
			System.out.println("Nome do professor:\n");
			String nomeProfessor3 = info.useDelimiter("\\n").next();

			System.out.println("Disciplinas cadastradas:\n");
			System.out.println(listaDisciplina.toString());
			System.out.println("Nome da disciplina:\n");
			String nomeDisciplina3 = info.useDelimiter("\\n").next();

			// PROCURA O INPUT DO USUARIO E MATRICULA
			for (Professor p : listaProfessor) {
				for (Disciplina d : listaDisciplina) {
					if (p.hasName(nomeProfessor3) && d.hasName(nomeDisciplina3)) {
						d.matricular(p);
						System.out.println("Matriculado com sucesso\n");
						break;
					}
				}
			}

			for (Professor a : listaProfessor) {
				System.out.println(a.toStringFull());
			}
			break;

		case 61: // RESERVAR SALAS PARA DISCIPLINAS
			System.out.println(listaSala.toString());
			System.out.println("Digite o numero da sala");
			String numSala = info.useDelimiter("\\n").next();
			System.out.println("Digite o nome da disciplina");
			String nomeDisciplina4 = info.useDelimiter("\\n").next();
			System.out.println("Salas podem ser reservadas em dias da semana" + " em seis horarios");
			System.out.println("1.Segunda-feira");
			System.out.println("2.Terça-feira");
			System.out.println("3.Quarta-feira");
			System.out.println("4.Quinta-feira");
			System.out.println("5.Sexta-feira");
			System.out.println("Digite uma opcão válida de 1 a 5");
			int opDia = info.nextInt();

			while (opDia < 1 || opDia > 5) {
				System.out.println("Digite uma opcão válida de 1 a 5");
			}

			System.out.println("Horarios: ");
			System.out.println("1. 8h às 10h");
			System.out.println("2. 10h às 12h");
			System.out.println("3. 14h às 16h");
			System.out.println("4. 16h às 18h");
			System.out.println("5. 18h às 20h");
			System.out.println("6. 20h às 22h");
			System.out.println("Digite uma opcão válida de 1 a 6");
			int opHora = info.nextInt();

			while (opHora < 1 || opHora > 6) {
				System.out.println("Digite uma opcão válida de 1 a 6");
			}

			for (Sala s : listaSala) {
				for (Disciplina d : listaDisciplina) {
					if (s.hasName(numSala) && d.hasName(nomeDisciplina4)) {
						if (!s.reservaSala(d, opDia, opHora, numSala)) {
							System.out.println("Não foi possível reservar. Sala cheia!");
						} else {
							System.out.println("Sala reservada com sucesso");
						}
					}
				}
			}
			break;
		}
		return op;
	}

	// ---------------INICIALIZA DISCIPLINA, ALUNO E PROFESSOR

	private static void iniciaListaDeDisciplinas() {
		Disciplina disciplina1 = new Disciplina("Calculo", "6");
		listaDisciplina.add(disciplina1);

		Disciplina disciplina2 = new Disciplina("Português", "4");
		listaDisciplina.add(disciplina2);

		Disciplina disciplina3 = new Disciplina("Ingles", "2");
		listaDisciplina.add(disciplina3);

		Disciplina disciplina4 = new Disciplina("Física", "4");
		listaDisciplina.add(disciplina4);

		Disciplina disciplina5 = new Disciplina("Quimica", "4");
		listaDisciplina.add(disciplina5);

	}

	private static void iniciaListaDeProfessores() {
		Professor um_professor = null;

		um_professor = new Professor("Carla", "9999", new Data(01, 01, 1956),
		        new Endereco("Rua Trabalhador São Carlense", "Centro", "400", "0123-000", "São Carlos", "SP", "Brasil"),
		        "8500", "senha");
		listaProfessor.add(um_professor);

		um_professor = new Professor("Rubens", "234.302.392-25", new Data(01, 01, 1970),
		        new Endereco("Rua da Glória", "Jardim Luzia", "20", "2222-222", "São Carlos", "SP", "Brasil"), "15000",
		        "1234");
		listaProfessor.add(um_professor);
	}

	private static void iniciaListaDeAluno() {
		Aluno um_aluno = null;

		um_aluno = new Aluno("Rafaela", "392.232.456-19", new Data(03, 04, 1994),
		        new Endereco("Rua México", "Gloria", "2", "00000-000", "São Paulo", "SP", "Brasil"), "123456", "senha");

		listaAluno.add(um_aluno); // inclui aluno na arraylist de Alunos
		listaDisciplina.get(0).matricular(um_aluno); // matricula professor na
		                                             // disciplina 0

		um_aluno = new Aluno("Bruno", "455.234.564-20", new Data(30, 02, 1990),
		        new Endereco("Rua Colômbia", "Bela Vista", "45", "99999-999", "Bauru", "SP", "Brasil"), "222222",
		        "senha1");
		listaAluno.add(um_aluno);
		listaDisciplina.get(1).matricular(um_aluno); // matricula professor na
		                                             // disciplina 1
	}

	private static void inicializaSala() {
		Sala uma_sala = null;

		uma_sala = new Sala("1-301", "3");

		listaSala.add(uma_sala); // inclui aluno na arraylist de Alunos

		uma_sala = new Sala("2-400", "4");
		listaSala.add(uma_sala); // inclui aluno na arraylist de Alunos
	}

	// ------------------------------------CADASTRA ALUNO, PROFESSOR,DISCIPLINA
	// E SALA

	public Professor incluiNovoProfessor(Scanner scanner) {

		System.out.println("Nome: ");
		String professorInputNome = scanner.useDelimiter("\\n").next();

		System.out.println("CPF: ");
		String ProfessorInputcPF = scanner.next();

		System.out.println("Data de nascimento: ");
		System.out.println("Dia entre 1 e 30: ");
		String dia = scanner.next();

		System.out.println("Mes entre 1 e 12: ");
		String mes = scanner.next();

		System.out.println("Ano entre 1920 e 2010: ");
		String ano = scanner.next();

		int professorInputDia = -1; // inicializa valor
		int professorInputMes = -1;
		int professorInputAno = -1;

		try { // converte String recebida para int
			professorInputDia = Integer.parseInt(dia);
			professorInputMes = Integer.parseInt(mes);
			professorInputAno = Integer.parseInt(ano);
		} catch (NumberFormatException e) { // ERRO DE VARIAVEL
		}

		while (professorInputDia < 1 || professorInputDia > 30) {
			System.out.println("Digite um dia válido de 1 a 30: ");
			professorInputDia = scanner.nextInt();
		}

		while (professorInputMes < 1 || professorInputMes > 12) {
			System.out.println("Digite um mês válido de 1 a 12: ");
			professorInputMes = scanner.nextInt();
		}

		while (professorInputAno < 1920 || professorInputAno > 2010) {
			System.out.println("Digite um ano válido de 1920 a 2010: ");
			professorInputAno = scanner.nextInt();
		}
		// scanner.useDelimiter foi utilizado para que a funcao scanner leia
		// toda a linha digitada
		// até o enter(\n)
		System.out.println("Endereco: ");
		System.out.println("Rua: ");
		String professorInputLogradouro = scanner.useDelimiter("\\n").next();
		System.out.println("Bairro: ");
		String professorInputBairro = scanner.useDelimiter("\\n").next();
		System.out.println("numero: ");
		String professorInputNumero = scanner.useDelimiter("\\n").next();

		while (checaDadoInvalido(professorInputNumero)) {
			System.out.println("Digite um número válido para numero...");
			professorInputNumero = scanner.next();
		}

		System.out.println("CEP: ");
		String professorInputCep = scanner.useDelimiter("\\n").next();
		System.out.println("Cidade: ");
		String professorInputCidade = scanner.useDelimiter("\\n").next();
		System.out.println("Estado: ");
		String professorInputEstado = scanner.useDelimiter("\\n").next();
		System.out.println("País: ");
		String professorInputPais = scanner.useDelimiter("\\n").next();

		System.out.println("Salário: ");
		String professorInputSalario = scanner.next();

		while (checaDadoInvalido(professorInputSalario)) {
			System.out.println("Digite um número válido para salário...");
			professorInputSalario = scanner.next();
		}

		System.out.println("Senha: ");
		String professorInputSenha = scanner.useDelimiter("\\n").next();

		Data data = new Data(professorInputDia, professorInputMes, professorInputAno);
		Endereco endereco = new Endereco(professorInputLogradouro, professorInputBairro, professorInputNumero,
		        professorInputCep, professorInputCidade, professorInputEstado, professorInputPais);

		Professor professorInput = new Professor(professorInputNome, ProfessorInputcPF, data, endereco,
		        professorInputSalario, professorInputSenha);

		return professorInput;

	}

	public Aluno incluiNovoAluno(Scanner scanner) {

		System.out.println("Nome: ");
		String alunoInputNome = scanner.useDelimiter("\\n").next();

		System.out.println("CPF: ");
		String alunoInputcPF = scanner.next();

		System.out.println("Data de nascimento: ");
		System.out.println("Dia entre 1 e 30: ");
		String dia = scanner.next();

		System.out.println("Mes entre 1 e 12: ");
		String mes = scanner.next();

		System.out.println("Ano entre 1920 e 2010: ");
		String ano = scanner.next();

		int alunoInputDia = -1;
		int alunoInputMes = -1;
		int alunoInputAno = -1;

		try {
			alunoInputDia = Integer.parseInt(dia);
			alunoInputMes = Integer.parseInt(mes);
			alunoInputAno = Integer.parseInt(ano);
		} catch (NumberFormatException e) { // ERRO DE VARIAVEL
		}

		while (alunoInputDia < 1 || alunoInputDia > 30) {
			System.out.println("Digite um dia válido de 1 a 30: ");
			alunoInputDia = scanner.nextInt();
		}

		while (alunoInputMes < 1 || alunoInputMes > 12) {
			System.out.println("Digite um mês válido de 1 a 12: ");
			alunoInputMes = scanner.nextInt();
		}

		while (alunoInputAno < 1920 || alunoInputAno > 2010) {
			System.out.println("Digite um ano válido de 1920 a 2010: ");
			alunoInputAno = scanner.nextInt();
		}

		System.out.println("Endereco: ");
		System.out.println("Rua: ");
		String alunoInputLogradouro = scanner.useDelimiter("\\n").next();
		System.out.println("Bairro: ");
		String alunoInputBairro = scanner.useDelimiter("\\n").next();
		System.out.println("numero: ");
		String alunoInputNumero = scanner.next();

		while (checaDadoInvalido(alunoInputNumero)) {
			System.out.println("Digite um número válido para salário...");
			alunoInputNumero = scanner.next();
		}

		System.out.println("CEP: ");
		String alunoInputCep = scanner.useDelimiter("\\n").next();
		System.out.println("Cidade: ");
		String alunoInputCidade = scanner.useDelimiter("\\n").next();
		System.out.println("Estado: ");
		String alunoInputEstado = scanner.useDelimiter("\\n").next();
		System.out.println("País: ");
		String alunoInputPais = scanner.useDelimiter("\\n").next();

		System.out.println("NUSP: ");
		String alunoInputnUSP = scanner.next();

		while (checaDadoInvalido(alunoInputNumero)) {
			System.out.println("Digite um número válido para salário...");
			alunoInputNumero = scanner.next();
		}

		System.out.println("Senha: ");
		String alunoInputSenhaAluno = scanner.next();

		Data data = new Data(alunoInputDia, alunoInputMes, alunoInputAno);
		Endereco endereco = new Endereco(alunoInputLogradouro, alunoInputBairro, alunoInputNumero, alunoInputCep,
		        alunoInputCidade, alunoInputEstado, alunoInputPais);

		Aluno alunoInput = new Aluno(alunoInputNome, alunoInputcPF, data, endereco, alunoInputnUSP,
		        alunoInputSenhaAluno);

		return alunoInput;

	}

	public Disciplina incluiNovaDisciplina(Scanner scanner) {

		System.out.println("Nome: ");
		String disciplinaNome = scanner.useDelimiter("\\n").next();

		System.out.println("Número de créditos: ");
		String disciplinaCreditos = scanner.next();

		Disciplina disciplinaInput = new Disciplina(disciplinaNome, disciplinaCreditos);

		return disciplinaInput;

	}

	public Sala incluiNovaSala(Scanner scanner) {

		System.out.println("Numero: ");
		String salaNumero = scanner.useDelimiter("\\n").next();

		System.out.println("Bloco: ");
		String salaBloco = scanner.useDelimiter("\\n").next();

		Sala salaInput = new Sala(salaNumero, salaBloco);

		return salaInput;
	}

	private static void iniciaWarthog() {
		P_Warthog warthog = null;

		warthog = new P_Warthog("Robotica", "Robotica", "Robos");
		warthog.matricular(listaProfessor.get(0));
		listaWarthog.add(warthog);
	}

	private static void iniciaICMC_Jr() {
		P_ICMC_Jr icmc = null;

		icmc = new P_ICMC_Jr("web", "Computacao", "01234567");
		icmc.matricular(listaProfessor.get(1));
		listaICMCJR.add(icmc);
	}

	private static void iniciaFOG() {
		P_FOG fog = null;

		fog = new P_FOG("Atari", "Jogos", "01234567");
		fog.matricular(listaProfessor.get(1));
		listaFOG.add(fog);
	}

	public P_Warthog incluiNovoProjetoWarthog(Scanner scanner) {

		System.out.println("Nome: ");
		String warthogInputNome = scanner.useDelimiter("\\n").next();

		System.out.println("Area: ");
		String warthogInputarea = scanner.useDelimiter("\\n").next();

		System.out.println("Materiais: ");
		String warthogInputMateriais = scanner.useDelimiter("\\n").next();

		P_Warthog warthog = new P_Warthog(warthogInputNome, warthogInputarea, warthogInputMateriais);

		return warthog;

	}

	public P_ICMC_Jr incluiNovoProjetoICMCJr(Scanner scanner) {

		System.out.println("Nome: ");
		String icmcInputNome = scanner.useDelimiter("\\n").next();

		System.out.println("Area: ");
		String icmcInputarea = scanner.useDelimiter("\\n").next();

		System.out.println("CNPJ do contratante: ");
		String icmcInputcnpj = scanner.useDelimiter("\\n").next();

		while (checaDadoInvalido(icmcInputcnpj)) {
			System.out.println("Digite um número válido para salário...");
			icmcInputcnpj = scanner.next();
		}

		P_ICMC_Jr icmc = new P_ICMC_Jr(icmcInputNome, icmcInputarea, icmcInputcnpj);
		icmc.setProfessorResponsavel(listaProfessor.get(0));

		return icmc;

	}

	public P_FOG incluiNovoProjetoFOG(Scanner scanner) {

		System.out.println("Nome: ");
		String fogInputNome = scanner.useDelimiter("\\n").next();

		System.out.println("Area: ");
		String fogInputarea = scanner.useDelimiter("\\n").next();

		System.out.println("Licenca Software : ");
		String fogInputLicencaSoftware = scanner.useDelimiter("\\n").next();

		P_FOG fog = new P_FOG(fogInputNome, fogInputarea, fogInputLicencaSoftware);
		fog.setProfessorResponsavel(listaProfessor.get(0));

		return fog;

	}

	public static void main(String[] args) throws IOException {
		Scanner info = new Scanner(System.in);
		teste = new Teste();

		// INICIALIZA DISCIPLINA, PROFESSORES, ALUNOS E SALA CRIADAS PREVIAMENTE
		iniciaListaDeDisciplinas();
		iniciaListaDeProfessores();
		iniciaListaDeAluno();
		inicializaSala();
		// INICIALIZA PROJETOS FOG, ICMCJR E WARTHOG CRIADOS PREVIAMENTE
		iniciaFOG();
		iniciaICMC_Jr();
		iniciaWarthog();
		// RESERVA A SALA PARA ALGUMAS DISCIPLINAS
		for (Sala sala : listaSala) {
			if (!sala.reservaSala(listaDisciplina.get(0), 0, 0, "4")) {
				System.out.println("Horario não disponivel");
			}

			if (!sala.reservaSala(listaDisciplina.get(1), 3, 4, "1")) {
				System.out.println("Horario não disponivel");
			}

			if (!sala.reservaSala(listaDisciplina.get(2), 1, 4, "6")) {
				System.out.println("Horario não disponivel");
			}

			if (!sala.reservaSala(listaDisciplina.get(3), 4, 4, "10")) {
				System.out.println("Horario não disponivel");
			}
		}

		teste.carregar();

		int continuar = 99;
		int op = -1;
		while (continuar != 0) {
			op = mostraMenu(info);
			try {
				continuar = teste.processarOpcao(info, op); // MENU SWITCH CASE
			} catch (Exception e) {
				System.err.println("[ERRO] Ocorreu uma exceção: " + e.getMessage());
				e.printStackTrace();
			}
		}

		info.close();
		teste.salvar();
	}

	private void carregar() {
		// DESSERIALIZAÇÃO
		try {
			FileInputStream arqLeituraAluno = new FileInputStream("alunos.txt");
			FileInputStream arqLeituraProfessor = new FileInputStream("professor.txt");
			FileInputStream arqLeituraDisciplina = new FileInputStream("disciplina.txt");
			FileInputStream arqLeituraSala = new FileInputStream("sala.txt");

			ObjectInputStream objLeituraAluno = new ObjectInputStream(arqLeituraAluno);
			ObjectInputStream objLeituraProfessor = new ObjectInputStream(arqLeituraProfessor);
			ObjectInputStream objLeituraDisciplina = new ObjectInputStream(arqLeituraDisciplina);
			ObjectInputStream objLeituraSala = new ObjectInputStream(arqLeituraSala);

			listaAluno = (ArrayList<Aluno>) objLeituraAluno.readObject();
			listaProfessor = (ArrayList<Professor>) objLeituraProfessor.readObject();
			listaDisciplina = (ArrayList<Disciplina>) objLeituraDisciplina.readObject();
			listaSala = (ArrayList<Sala>) objLeituraSala.readObject();

			objLeituraAluno.close();
			objLeituraProfessor.close();
			objLeituraDisciplina.close();
			objLeituraSala.close();

			FileInputStream arquivoW = new FileInputStream("warthog.txt");
			FileInputStream arquivoJR = new FileInputStream("icmcjr.txt");
			FileInputStream arquivoF = new FileInputStream("fog.txt");

			ObjectInputStream objlerW = new ObjectInputStream(arquivoW);
			ObjectInputStream objlerJR = new ObjectInputStream(arquivoJR);
			ObjectInputStream objlerF = new ObjectInputStream(arquivoF);

			listaWarthog = (ArrayList<P_Warthog>) objlerW.readObject();
			listaICMCJR = (ArrayList<P_ICMC_Jr>) objlerJR.readObject();
			listaFOG = (ArrayList<P_FOG>) objlerF.readObject();

			objlerW.close();
			objlerJR.close();
			objlerF.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void salvar() {
		try {
			FileOutputStream arquivoAluno = new FileOutputStream(new File("alunos.txt"));
			FileOutputStream arquivoProfessor = new FileOutputStream("professor.txt");
			FileOutputStream arquivoDisciplina = new FileOutputStream("disciplina.txt");
			FileOutputStream arquivoSala = new FileOutputStream("sala.txt");

			ObjectOutputStream objGravarAluno = new ObjectOutputStream(arquivoAluno);
			ObjectOutputStream objGravarProfessor = new ObjectOutputStream(arquivoProfessor);
			ObjectOutputStream objGravarDisciplina = new ObjectOutputStream(arquivoDisciplina);
			ObjectOutputStream objGravarSala = new ObjectOutputStream(arquivoSala);

			objGravarAluno.writeObject(listaAluno);
			objGravarProfessor.writeObject(listaProfessor);
			objGravarDisciplina.writeObject(listaDisciplina);
			objGravarSala.writeObject(listaSala);

			objGravarAluno.close();
			objGravarProfessor.close();
			objGravarDisciplina.close();
			objGravarSala.close();

			FileOutputStream arquivoW = new FileOutputStream("warthog.txt");
			FileOutputStream arquivoJR = new FileOutputStream("icmcjr.txt");
			FileOutputStream arquivoF = new FileOutputStream("fog.txt");

			ObjectOutputStream objGravarW = new ObjectOutputStream(arquivoW);
			ObjectOutputStream objGravarJR = new ObjectOutputStream(arquivoJR);
			ObjectOutputStream objGravarF = new ObjectOutputStream(arquivoF);

			objGravarW.writeObject(listaWarthog);
			objGravarJR.writeObject(listaICMCJR);
			objGravarF.writeObject(listaFOG);

			objGravarW.close();
			objGravarJR.close();
			objGravarF.close();

			// System.out.println("Objeto gravado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void exit(int err) {
		salvar();
		System.exit(err);
	}

}