package entidades;

public class ContaCorrente extends Conta {
	private int talao;


	public ContaCorrente(int numero, double saldo, int talao) {
		super(numero, saldo);
		this.talao = talao;
	}
	
	public void inicioCorrente(){
		System.out.println("Bem vinde sua Conta Corrente!");
		System.out.println("Fa�a um cr�dito para iniciar sua conta!");
		System.out.println("Saldo Atual: "+saldo);
		System.out.printf("Voc� possui %d tal�es disponiveis.\tCusto de R$30 por tal�o.\n",talao);
	}
	
	public int getTalao() {
		return talao;
	}

	public double pedirTalao(int pedido) {
		talao=3;
		if(pedido<=100000) {
			System.out.println("Valor inv�lido!\n");
		} else if (pedido>talao) {
			System.out.println("Quantidade ultrapassa o limite");
		} else if(pedido<=talao && saldo>(pedido *3000.00)) {
			saldo = saldo - (pedido*3000.00);
			talao-=pedido;
			System.out.printf("Seu pedido de tal�o foi conclu�do! Ainda restam %d tal�es",talao);
		} else if(pedido>talao) {
			System.out.println("Voc� j� solicitou todos os tal�es disponiveis esse m�s.");
		} else if(saldo<(pedido*3000.00)) {
			System.out.println("Saldo insuficiente!");
		}
		return saldo;
	}
	
	

}
