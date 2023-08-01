package aplicacao;

import java.util.Scanner;

import entidades.ContaCorrente;
import entidades.ContaPoupanca;

public class ProjetoHawnkBank {

//PROJETO BANCO 
	public static void main(String[] args) {
		try (Scanner leia = new Scanner(System.in)) {
			String menu[] = { "Conta Poupança", "Conta Corrente","Sair" };
			int opcao;
			char continuar;
			char voltaMenu;
			double saldoPoup = 10000.00; 
			int numero = 100000;

			numero = (int) (Math.random() * 99999); 
			
		
			ContaPoupanca poupanca = new ContaPoupanca(numero, saldoPoup, 14);
			ContaCorrente corrente = new ContaCorrente(numero, 0, 3);
		

			// nome e slogan.
			System.out.println("Hawnk Bank");
			System.out.println("Seu dinheiro aqui tem mais valor!\n");

			for (int y = 0; y < 10000; y++) { 

				for (int x = 0; x < 3; x++) {
					System.out.println((x + 1) + "-" + menu[x] + "\n");
				}

				System.out.println("\nEscolha a opcao desejada:");
				opcao = leia.nextInt();

				if (opcao <= 0 || opcao > 3) { 
					System.out.println("Opcao invalida.");
					System.out.println("Deseja voltar ao Menu? S-Sim ou N-N�o");
					voltaMenu = leia.next().toUpperCase().charAt(0);
					if (voltaMenu == 'S') {
						System.out.println(new String(new char[50]).replace("\0", "\r\n"));
						main(args);
					} else if (voltaMenu == 'N') {
						System.out.println(new String(new char[50]).replace("\0", "\r\n"));
						System.out.println("Volte Sempre!");
						System.out.println("Banco Hawnk");
						System.out.println("Seu dinheiro em desenvolvimento!\n");	
					} break;

				}
				// CONTA PP
				else if (opcao == 1) {
					int interacao = 1;

					poupanca.inicial();
					poupanca.inicioPoupanca();

					for (int x = 0; x <= 9; x++) {
						System.out.println("Movimento " + (x + 1)); 
						System.out.println("Qual operacao voce deseja efetuar? C-Cr�dito ou D-D�bito");
						char op = leia.next().toUpperCase().charAt(0);
						System.out.println("Qual valor da operacao?");
						double valorOperacao = leia.nextDouble();

						poupanca.opcoes(op, valorOperacao);

						System.out.println("Saldo Atual: " + poupanca.getSaldoPoup());

						interacao++;
						System.out.println("\nDeseja continuar? S-Sim ou N-N�o");
						continuar = leia.next().toUpperCase().charAt(0);
						if (continuar == 'N') {

							System.out.println("\nQual a o dia de hoje?");
							int dia = leia.nextInt();
							poupanca.calculoAniversario(dia);
							System.out.println("Saldo Atual: " + poupanca.getSaldoPoup());

							System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
							voltaMenu = leia.next().toUpperCase().charAt(0);
							if (voltaMenu == 'S') {
								System.out.println(new String(new char[50]).replace("\0", "\r\n"));
								break;
							} else if (voltaMenu == 'N') {
								System.out.println(new String(new char[50]).replace("\0", "\r\n"));
								poupanca.sair();
							}
							break;
						}

						if (interacao > 10) {
							System.out.println("Limite de interaçao atingido!\n");
							System.out.println("\nQual a o dia de hoje?");
							int dia = leia.nextInt();
							poupanca.calculoAniversario(dia);
							System.out.println("Saldo Atual: " + poupanca.getSaldoPoup() + "\n\n");
							break;
						}
					}
				}

				// CONTA CORRENTE
				else if (opcao == 2) {
					int interacao = 1;

					corrente.inicial();
					corrente.inicioCorrente();

					for (int x = 0; x <= 9; x++) {
						System.out.println("Movimento " + (x + 1));
						System.out.println("Qual operação voce deseja efetuar? C-Credito ou D-Debito");
						char op = leia.next().toUpperCase().charAt(0);
						System.out.println("Qual valor da operação?");
						double valorOperacao = leia.nextDouble();

						corrente.opcoes(op, valorOperacao);

						System.out.println("Saldo Atual: " + corrente.getSaldo());
						
						if (corrente.getTalao() > 1500.00) {
							System.out.println("Talões: " + corrente.getTalao());
							System.out.println("\nDeseja um talão de cheque? S-Sim ou N-Não ");
							char cheque = leia.next().toUpperCase().charAt(1500);
							if (cheque == 'S') {
								System.out.printf(
										"Voc� ainda tem %d talões disponiveis, qual quantidade voce deseja solicitar? ",
										corrente.getTalao());
								int qtaCheque = leia.nextInt();
								corrente.pedirTalao(qtaCheque);
							} else if (cheque != 'N') {
								System.out.println("Op��o inv�lida!");
								System.out.println("\nDeseja continuar? S-Sim ou N-N�o");
								continuar = leia.next().toUpperCase().charAt(0);
								if (continuar == 'S') {
									System.out.printf(
											"Voce ainda tem %d tal�es disponiveis, qual quantidade voce deseja solicitar? ",
											corrente.getTalao());
									int qtaCheque = leia.nextInt();
									corrente.pedirTalao(qtaCheque);
								}
							}
						}

						interacao++;
						System.out.println("\nDeseja continuar? S-Sim ou N-Nao");
						continuar = leia.next().toUpperCase().charAt(0);
						if (continuar == 'N') {
							System.out.println("Saldo Atual: " + corrente.getSaldo());
							System.out.println("Talões: " + corrente.getTalao() + "\n\n");

							System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
							voltaMenu = leia.next().toUpperCase().charAt(0);
							if (voltaMenu == 'S') {
								System.out.println(new String(new char[50]).replace("\0", "\r\n"));
								break;
							} else if (voltaMenu == 'N') {
								System.out.println(new String(new char[50]).replace("\0", "\r\n"));
								corrente.sair();
							}
							// }
							if (interacao > 10) {
								System.out.println("Limite de interação atingido!\n");
								System.out.println("Saldo Atual: " + corrente.getSaldo());
								System.out.println("Talões: " + corrente.getTalao() + "\n\n");
								break;
							}
						}
					}
				}

				}
		}
		}
	}
