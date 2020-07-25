import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* CLASSE JMemoria
 *
 * Classe inicial do jogo, que tem o método Main
 */
public class JMemoria {
	public static void main(String[] args) {
		// Instancia a classe memória, que pedirá parametros
		// do usuário
		Memoria mem = new Memoria();
		// Informa que quando a janela for fechada,
	    // jogo deverá terminar.
		mem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
