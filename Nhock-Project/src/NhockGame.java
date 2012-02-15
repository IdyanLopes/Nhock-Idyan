
import javax.swing.JOptionPane;
import model.Cenario;
import model.Nhock;
import model.Nhock2;
import util.Util;
import view.JanelaPrincipal;
import view.Joystick;
import view.Joystick2;
import view.PainelCenario;

/**
 * Responsabilidade da Classe: Executar o loop do Jogo com os objetos principais.
 */
public class NhockGame {

	//Pontua��o
        Cenario contador     = new Cenario();
        private int pontuacao1;


        //Modelo
	Cenario cenario;
	Nhock nhock;
        Nhock2 nhock2;
        
	//Vis�o
	JanelaPrincipal janela;
	PainelCenario painel;
	Joystick joystick;
        Joystick2 joystick2;
        
	public NhockGame(){
		//Inicializa objetos b�sicos do modelo
		this.cenario = new Cenario();
		this.nhock = new Nhock();
                this.nhock2 = new Nhock2();
                
		//Iniciliza objetos b�sicos da vis�o. Lembrando que a vis�o pode usar os dados do modelo
		//Por isso passamos os objetos do cen�rio e do nhock para o painel cen�rio.
		this.painel = new PainelCenario(this.cenario, this.nhock, this.nhock2);
		//Inicializa respons�vel por capturar eventos do usu�rio.
		this.joystick = new Joystick();
                this.joystick2 = new Joystick2();

		this.janela = new JanelaPrincipal(); //Cira janela

		this.janela.add(this.painel); //Adiciona painel
		this.janela.addKeyListener(joystick); //Adiciona KeyListener
                this.janela.addKeyListener(joystick2);
		
		this.janela.setVisible(true); //Exibe
		this.painel.createBufferStrategy(2); //T�cnica para a janela parar de piscar
	}

	public void init(){
		while(true){		
			Util.sleep(160); //P�e o programa pra dormir por um tempo - mude akqui para aumentar ou diminuir a velocidade.

			//Pega eventos
			if(joystick.direitaPressionada()){ this.nhock.turnDIREITA(); }
			if(joystick.esquerdaPressionada()){ this.nhock.turnESQUERDA(); }
			if(joystick.cimaPressionada()){ this.nhock.turnCIMA(); }
			if(joystick.baixoPressionada()){ this.nhock.turnBAIXO(); }
                        
                        
                        if(joystick2.direita2Pressionada()){ this.nhock2.turnDIREITA2(); }
			if(joystick2.esquerda2Pressionada()){ this.nhock2.turnESQUERDA2(); }
			if(joystick2.cima2Pressionada()){ this.nhock2.turnCIMA2(); }
			if(joystick2.baixo2Pressionada()){ this.nhock2.turnBAIXO2(); }
                        
                        
                        

			//Processa			
			this.nhock.step();
                        this.nhock2.step();
                        

			//Controle de Colis�o

			//nhock bate no muro
			if(this.cenario.ehMuro(this.nhock.getCabeca())){                     
                                
                                JOptionPane.showMessageDialog(this.janela, "Perdeu otario!  Pontos: " + this.pontuacao);
				System.exit(0);
			}

			//nhock bate nele mesmo
			if(this.nhock.temColisao()){
				JOptionPane.showMessageDialog(this.janela, "Perdeu otario! Tentando da r� no kibe?  Pontos: " + this.pontuacao);
				System.exit(0);
			}

			//nhock pega a semente
			if(this.cenario.ehSemente(this.nhock.getCabeca())){
				this.nhock.addPonto();
				this.cenario.sorteiaSemente();
			}
                        
                        
                        
                        
                        
                        
                        //Controle de Colis�o

			//nhock bate no muro
			if(this.cenario.ehMuro(this.nhock2.getCabeca())){
                                JOptionPane.showMessageDialog(this.janela, "Perdeu otario!  Pontos: " + this.pontuacao);
				System.exit(0);
			}

			//nhock bate nele mesmo
			if(this.nhock2.temColisao()){
				JOptionPane.showMessageDialog(this.janela, "Perdeu otario! Tentando da r� no kibe?  Pontos: " + this.pontuacao);
				System.exit(0);
			}

			//nhock pega a semente
			if(this.cenario.ehSemente(this.nhock2.getCabeca())){
				this.nhock2.addPonto();
				this.cenario.sorteiaSemente();
			}

			//Desenha
			this.painel.renderGraphics();
			this.painel.desenha();
		}
			
	}
}
