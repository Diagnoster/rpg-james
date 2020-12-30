package jogo;


import java.util.Random;

public class Heroi {
	
	private int vida = 100;
	private int pocao = 5;
		
	private int golpeCritico() { // se definiu o heroi n�o pode ser estatico
		Random critico = new Random();
		return critico.nextInt(10) + 1; // retorna numero entre 1 e 10;
	}
	
			
	public void executarAcao (int acaoEscolhida, Monstro monstro) {
		System.out.print("\n");
		switch (acaoEscolhida) {
			case 1: // Golpe de espada
				System.out.println("Voc� desfere um golpe de espada");
				monstro.retirarVida(4); // set vida para pegar a vida e alterar com get - 4 
				golpeCritico();
				if (golpeCritico() >= 8) {
					System.out.println("N�mero " + golpeCritico() + " Dano Cr�tico!!");
					monstro.retirarVida(3); // tem q ser positivo se pegar e retirar vida, se colocar positivo - com - = +;
				}
				break;
			case 2: // Arco e flecha
				System.out.println("Voc� atira uma flecha");
				monstro.retirarVida(6);
				break;
			case 3: // Po��o de vida
				if (this.vida < 80 && this.pocao > 1) { // criar metodo para curar vida e chamar metodo
					System.out.println("Voc� toma uma po��o de vida");
					this.vida += 20;
					this.pocao -= 1;
				} else if (this.vida > 80 && this.pocao > 1){
					System.out.println("Voc� n�o pode se curar");
				}  else {
					System.out.println("Voc� n�o tem mais po��es de vida");
				}
				break;
			default:
				System.out.println("Op��o inv�lida!");
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



