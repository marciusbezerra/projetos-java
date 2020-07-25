import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// CLASSE Carta

// Define o objeto Carta, pois um Jogo da Memória 
// é feito de várias cartas.

// Ela herda de JPanel, pois, na verdade cada carta é
// JPanel.
public class Carta extends JPanel {
	private ImageIcon Imagem;
	private int indiceInicial, indiceImagem;
	private boolean jaJogada, estado;
	
	public Carta() {
		// O construtor: quando uma carta é inicia
		// deverá ficar como 0.GIF (a imagem de carta
		// oculta).
		indiceInicial = 0;
		Imagem = new ImageIcon(indiceInicial + ".gif");
	}
	
	public void paintComponent(Graphics g) {
		// Este método é herdado de JPanel e é
		// chamado todas a vezes que uma carta
		// precisa ser redesenhada
		int x, y;

		// Prepara para redesenhar a imagem da carta
		// pois talvez ela tenha mudado
		Imagem = null;
		Imagem = new ImageIcon(indiceInicial + ".gif");
		
		// Redesenha primeiro o JPainel
		super.paintComponent(g);
		
		// Põe a imagem da carta no meio do JPanel
		if (Imagem.getIconHeight() < getHeight())
		  y = (getHeight() - Imagem.getIconHeight()) / 2;
		else
			y = 0;
			
		if (Imagem.getIconWidth() < getWidth())
		  x = (getWidth() - Imagem.getIconWidth()) / 2;
		else
			x = 0;
		Imagem.paintIcon(this,g,x,y);
	}
	
	
	public void setIndiceImagem(int Indice) {
		// Seleciona um índice para a carta,
		// esse índice define qual imagem deverá
		// aparecer quando a carta for clicada
		indiceImagem = Indice;
	}
	
	public int getIndiceImagem() {
		// retorna o índice da imagem
		return indiceImagem;
	}
	
	public void setJaJogada(boolean jogada) {
		// Indica que a carta não pode mais ser mexida
		// pois ela pode ter sido parte de um acerto do
		// usuário
		jaJogada = jogada;
	}
	
	public boolean getJaJogada() {
		// retorna se a carta pode ou não ser mexida
		return jaJogada;
	}
	
	public void Mostrar() {
		// Mostra a imagem da carta utilizando
		// o índice que foi dado
		indiceInicial = indiceImagem;
		repaint();
		// Flag que indica se a imagem da carta está
		// sendo mostrada (true) ou não (false)
		estado = true;
	}
	
	public void Esconder() {
		// Esconde a imagem da carta utilizando
		// o índice 0 (de carta oculta)
		indiceInicial = 0;
		repaint();
		// Flag que indica se a imagem da carta está
		// sendo mostrada (true) ou não (false)
		estado = false;
	}
	
	public boolean Mostrando() {
		// Retorna se a carta está sendo mostra ou não
		// utilizando o Flag estado (descrito acima).
		return estado;
	}
}