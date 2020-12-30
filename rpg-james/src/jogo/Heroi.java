package jogo;


import java.util.Random;

public class Heroi {
	
	private int vida = 100;
	private int pocao = 5;
		
	private int golpeCritico() { // se definiu o heroi não pode ser estatico
		Random critico = new Random();
		return critico.nextInt(10) + 1; // retorna numero entre 1 e 10;
	}
	
			
	public void executarAcao (int acaoEscolhida, Monstro monstro) {
		System.out.print("\n");
		switch (acaoEscolhida) {
			case 1: // Golpe de espada
				System.out.println("Você desfere um golpe de espada");
				monstro.retirarVida(4); // set vida para pegar a vida e alterar com get - 4 
				golpeCritico();
				if (golpeCritico() >= 8) {
					System.out.println("Número " + golpeCritico() + " Dano Crítico!!");
					monstro.retirarVida(3); // tem q ser positivo se pegar e retirar vida, se colocar positivo - com - = +;
				}
				break;
			case 2: // Arco e flecha
				System.out.println("Você atira uma flecha");
				monstro.retirarVida(6);
				break;
			case 3: // Poção de vida
				if (this.vida < 80 && this.pocao > 1) { // criar metodo para curar vida e chamar metodo
					System.out.println("Você toma uma poção de vida");
					this.vida += 20;
					this.pocao -= 1;
				} else if (this.vida > 80 && this.pocao > 1){
					System.out.println("Você não pode se curar");
				}  else {
					System.out.println("Você não tem mais poções de vida");
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
				
		} 
	
	} 

	
	public void retirarVida(int vida) {
		this.vida -= vida;
	}

	public int getVida() {
		return vida;
	}


	public int getPocao() {
		return pocao;
	}
	
	
	
	
}



