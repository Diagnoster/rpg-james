package jogo;

import java.util.Scanner;

public class game {
	
	static Monstro monstro = new Monstro(10); // monstro definido
	static Heroi heroi = new Heroi();
	static int quantidadeMonstros = 1;
	
	public static int escolherAcao() {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escolha um ataque: ");
		System.out.println("(1) - Golpe de espada");
		System.out.println("(2) - Arco e flecha");
		System.out.println("(3) - Po��o de vida"); // pode ser usado 5 vezes 
		return entrada.nextInt();
		
	}
	
	static void imprimirVida() {
		System.out.println("*************************");
		System.out.println("HP JOGADOR " + heroi.getVida()); // como foi definido o heroi, conseguimos chamar os atributos da classe dele
		System.out.println("PO��O JOGADOR " + heroi.getPocao());
		System.out.println("-------------------------");
		System.out.println("MONSTRO N�MERO " + quantidadeMonstros);
		System.out.println("HP MONSTRO " + monstro.getVida());
		System.out.println("*************************\n");
	}
	
	
	static void batalhar() { 
				
		while ( heroi.getVida() > 0 && monstro.getVida() > 0) {
			imprimirVida();
			heroi.executarAcao(escolherAcao(), monstro); // chamando heroi para executar a��o (atacar monstro ou curar )	
			monstro.atacar(heroi); // chamando monstro para atacar heroi
		}
	}	
	
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int continuar = 1;
		while (continuar == 1) {
			batalhar();
			if (monstro.getVida() <= 0) {
				System.out.println("Monstro morto");
				quantidadeMonstros++;
				monstro = new Monstro(monstro.getVidaInicial() + 2); // criando monstro novo
				
			} else {
				System.out.println("Fim do jogo, continuar? (1) Sim (2) N�o");
				continuar = entrada.nextInt();
			}
			
		}
		
		entrada.close();
	}
	
}
