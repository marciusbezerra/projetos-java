import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// CLASSE Memoria

// Classe que pede par�metros dos usu�rios,
// como o Nome e a Fase

// Herda de JFrame
public class Memoria extends JFrame {
	private JTextField Nome;
	private JButton OK, Cancelar;
	private JLabel L1, L2;
	private JComboBox Fase;
	
	// Cria o vetor que � a denomina��o das fases do programa
	private String Fases[] = {"Iniciante","Intermediaria","Avancada"};
	
	public Memoria() {
		
		// CONSTRUTOR:
		
		// P�e a mensagem de boas viandas como t�tulo
		// da janela
		super("Bem-Vindo ao Jogo da Memoria!");
		
		// Cria o container (janela que guardar� os componentes usados)
		// e atribue a ele FlowLayout como layout
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// Instancia todos os componentes que ser�o utilizados
		// que s�o 2 r�tulos, 1 caixa de edi��o, 2 bot�es
		// e uma ComboBox (caixa popup de listagem)
		L1 = new JLabel("Nome:");
		L2 = new JLabel("Fase:");
		Fase = new JComboBox(Fases);
		
		// Apenas tr�s itens dever�o ficar vis�veis na lista da
		// ComboBox (j� que o jogo s� usa tr�s fases)
		Fase.setMaximumRowCount(3);
		
		Nome = new JTextField(10);
		OK = new JButton("Jogar");
		Cancelar = new JButton("Fechar");
		
		// Instancia a classe que servir� para tratamento
		// de eventos dos bot�es de comando
		BotoesEvento BE = new BotoesEvento();
		
		// Adiciona os controles no container (JFrame)
		c.add(L1);
		c.add(Nome);
		c.add(L2);
		c.add(Fase);
		c.add(OK);
		c.add(Cancelar);
		
		// Atribue tratamento de evento aos dois bot�es de comando
		// OK e Cancelar
		OK.addActionListener(BE);
		Cancelar.addActionListener(BE);

		// Seta o tamanho da janela...
		setSize(500,200);		
		
		// e a mostra
		setVisible(true);
	}
	
	// Classe que far� o tratamento de evento dos bot�es de comando
	// ela implementa a interface ActionListener
	private class BotoesEvento implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			// Se o que sofreu a��o foi o bot�o OK...
			if (event.getSource() == OK) {
				
				// verifica se foi atribuido realmente um nome �
				// caixa de texto, se n�o, emite mensagem de lembran�a
				if (Nome.toString().trim()=="") {
					JOptionPane.showMessageDialog(null,"O nome deve ser digitado");
				}
				else {
					
					// Caso tenho sido atribu�do um nome � caixa de texto
					// instacia a classe Jogo entregando como parametros
					// ao seu contrutor o nome do usu�rio (caixa de texto)
					// e a fase a ser jogada (selecionada na ComboBox)
					Jogo jg;
					jg = new Jogo(Nome.getText(), Fase.getSelectedIndex());
				}
			}
			
			// Se o que sofreu a��o foi o bot�o Cancelar finaliza
			// todo o aplicativo
			if (event.getSource() == Cancelar)
				System.exit(0);
		}
	}
	
}