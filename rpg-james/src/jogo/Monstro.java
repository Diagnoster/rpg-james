package jogo;

import java.util.Random;

public class Monstro { // uma classe só pode ter atributos e ações que ela faz.
	
	public Monstro(int vida) {
		this.vida = vida;
		this.danoVenenoso = 2;
		this.vidaInicial = vida; // salvando vida inicial do monstro
	}
	
	
	private int vida;
	private int danoVenenoso;
	private int vidaInicial;	
	
	private int ataqueMonstro() {
		Random aleatorio = new Random();
		return aleatorio.nextInt(3) + 1; // retorna numero entre 1 e 3
	}
	
	
	public void atacar(Heroi heroi) {
		switch (ataqueMonstro()) {
			case 1:
				System.out.println("Monstro avança e lhe morde");
				heroi.retirarVida(5);
				this.danoVenenoso++;
				if (this.danoVenenoso > 2) {
					System.out.println("Dano bonus devido ao veneno do Monstro");
					heroi.retirarVida(2); 
				} 
				break;
			case 2:
				System.out.println("Monstro usa investida");
				heroi.retirarVida(4);
				break;
			case 3:
				System.out.println("Monstro lhe chuta");
				heroi.retirarVida(3);
				break;
		}
		System.out.print("\n");
	}	
	
	
	
	public int getVidaInicial() {
		return vidaInicial;
	}


	public void retirarVida(int vida) {
		this.vida -= vida;
	}
	
	public int getVida() {
		return vida;
	}
	
	
}
