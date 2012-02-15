package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import model.Cenario;
import model.Nhock;
import model.Nhock2;

/**
 * Responsabilidade da Classe: Gerencia e desenha os elementos do jogo.
 */
public class PainelCenario extends Canvas{

	Cenario cenario;
	Nhock nhock;
        Nhock2 nhock2;

	//Constr�i painel Cen�rio.
	//O painel � sempre composto por estes dois objetos que devem ser enviados do NhockGame.
	//Lembre-se: S� pode existir apenas um objeto nhock e um objeto cen�rio no jogo inteiro.
	public PainelCenario(Cenario cenario, Nhock nhock, Nhock2 nhock2){
		this.cenario = cenario;
		this.nhock = nhock;
                this.nhock2 = nhock2;
                
		this.setSize(400,200);

		this.setIgnoreRepaint(true);
	}

	public void desenha(){
		if (!getBufferStrategy().contentsLost()){
			getBufferStrategy().show();
		}
	}

	public void renderGraphics() {
		Graphics g = getBufferStrategy().getDrawGraphics();

		//Criamos um contexto gr�fico que n�o leva em conta as bordas
		Graphics g2 = g.create();
		//Limpamos a tela
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		this.cenario.desenha(g2);
		this.nhock.desenha(g2);
                this.nhock2.desenha(g2);
                
		//Liberamos os contextos criados.
		g.dispose();
		g2.dispose();
	}
}
