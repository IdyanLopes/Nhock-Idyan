package model;

import util.Util;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Responsabilidade da Classe: Controla opera��es exclusivas do cen�rio.
 */
public class Cenario {

        //Pontua��o
        private int contador;

	/*
	 * Constantes, cada constante representa um elemento do cen�rio
	*/
	static int VAZIO = 0;
	static int MURO = 1;
	static int NHOCK = 2;

	//A Matriz � um vetor bidimensional que armazena todos os blocos da tela do jogador.
	private int[][] matriz;

	//A semente � a comida do Nhock. Ela � representada por um ponto.
	private Ponto semente;

	public Cenario(){
		//Cria cen�rio b�sico.
		//Cada n�mero representa alguma coisa na Matriz
		//O n�mero 1 � uma parede
		//O n�mero zero � casa vazia.
		this.matriz = new int[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};

		this.sorteiaSemente();
	}

	/**
	 * Verifica se um detrminado ponto no cen�rio � um muro.
	 */
	public boolean ehMuro(Ponto p){
		int valueOfMatrix = this.matriz[p.getY()][p.getX()];
		return valueOfMatrix == Cenario.MURO;
	}

	/**
	 * Verifica se um determinado ponto do cen�rio � uma semente
	 */
	public boolean ehSemente(Ponto p){
		return this.semente.equals(p);
	}

	/**
	 * Desenha o cen�rio de acordo com a matriz.
	 * Cada n�mero da matriz � representado por um quadrado.
	 */
	public void desenha(Graphics g) {
		g.setColor(Color.black); //pincel � preto
		for(int i = 0; i < 19; i++ ){
			for(int j = 0; j < 20; j++){
				if(this.matriz[i][j] == Cenario.MURO){
					g.fillRect(j*20, i*20, 20, 20); //Pinta todos os muros
				}
			}
		}
		//Desenha semente
		g.setColor(Color.red); //pincel � vermelho
		g.fillRect(this.semente.getX()*20, this.semente.getY()*20, 20, 20);
	}

	public void sorteiaSemente() {
		do {
			this.semente = new Ponto(Util.random(20),Util.random(20));
		}while(this.ehMuro(this.semente)); //Enquanto o ponto sorteado for muro, continua sorteando.
                this.contador = contador+1;

	}


        public int getContador(){
            return contador;
        }
}
