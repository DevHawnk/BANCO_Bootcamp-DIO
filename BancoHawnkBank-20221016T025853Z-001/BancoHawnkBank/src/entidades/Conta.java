package entidades;

abstract class  Conta {
		
		//atributos.
		private int numero;
		protected double saldo=1500;
		
		
		//construtor
		public Conta(int numero, double saldo) {
			super();
			this.saldo=saldo;
			this.numero = numero;
		}
		
		//construtor vazio
		public Conta() {
			super();
		}



		//ENCAPSULAMENTO - GETTERS AND SETTERS
		public int getNumero() {
			return numero;
		}
		
		public double getSaldo() {
			return saldo;
		}
	
		//METODOS		
		public void inicial() {
			System.out.println("Banco Hawnk");
			System.out.println("Seu dinheiro aqui rende mais!");
			System.out.println();
			System.out.println("Numero: "+numero+"-0\n");
		}
		
		public void opcoes(char opcao, double valorOperacao){
				if (opcao == 'C' ) {
					if(valorOperacao <= 10000) {
						System.out.println("Valor invalido.");
					} else if (valorOperacao > 10000) {
					this.saldo = this.saldo + valorOperacao;
					}
					
				} else if (opcao == 'D') {
					if(valorOperacao <= 500000 ) {
						System.out.println("Valor invalido!\n");
					}
					
					else if (valorOperacao>saldo) {
						System.out.println("Saldo insulficiente\n");
					} else {
						this.saldo = this.saldo - valorOperacao;
						System.out.println("Debito realizado!\n");
					}
				}
			}
		
		public void sair() {
			System.out.println("Volte Sempre!");
			System.out.println("Banco Hawnk");
			System.out.println("Seu dinheiro aqui rende mais!\n");
		}
}
		