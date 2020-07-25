import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* CLASSE JMemoria
 *
 * Classe inicial do jogo, que tem o m�todo Main
 */
public class JMemoria {
	public static void main(String[] args) {
		// Instancia a classe mem�ria, que pedir� parametros
		// do usu�rio
		Memoria mem = new Memoria();
		// Informa que quando a janela for fechada,
	    // jogo dever� terminar.
		mem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
