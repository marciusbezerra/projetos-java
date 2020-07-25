import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// CLASSE Memoria

// Classe que pede parâmetros dos usuários,
// como o Nome e a Fase

// Herda de JFrame
public class Memoria extends JFrame {
	private JTextField Nome;
	private JButton OK, Cancelar;
	private JLabel L1, L2;
	private JComboBox Fase;
	
	// Cria o vetor que é a denominação das fases do programa
	private String Fases[] = {"Iniciante","Intermediaria","Avancada"};
	
	public Memoria() {
		
		// CONSTRUTOR:
		
		// Põe a mensagem de boas viandas como título
		// da janela
		super("Bem-Vindo ao Jogo da Memoria!");
		
		// Cria o container (janela que guardará os componentes usados)
		// e atribue a ele FlowLayout como layout
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// Instancia todos os componentes que serão utilizados
		// que são 2 rótulos, 1 caixa de edição, 2 botões
		// e uma ComboBox (caixa popup de listagem)
		L1 = new JLabel("Nome:");
		L2 = new JLabel("Fase:");
		Fase = new JComboBox(Fases);
		
		// Apenas três itens deverão ficar visíveis na lista da
		// ComboBox (já que o jogo só usa três fases)
		Fase.setMaximumRowCount(3);
		
		Nome = new JTextField(10);
		OK = new JButton("Jogar");
		Cancelar = new JButton("Fechar");
		
		// Instancia a classe que servirá para tratamento
		// de eventos dos botões de comando
		BotoesEvento BE = new BotoesEvento();
		
		// Adiciona os controles no container (JFrame)
		c.add(L1);
		c.add(Nome);
		c.add(L2);
		c.add(Fase);
		c.add(OK);
		c.add(Cancelar);
		
		// Atribue tratamento de evento aos dois botões de comando
		// OK e Cancelar
		OK.addActionListener(BE);
		Cancelar.addActionListener(BE);

		// Seta o tamanho da janela...
		setSize(500,200);		
		
		// e a mostra
		setVisible(true);
	}
	
	// Classe que fará o tratamento de evento dos botões de comando
	// ela implementa a interface ActionListener
	private class BotoesEvento implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			// Se o que sofreu ação foi o botão OK...
			if (event.getSource() == OK) {
				
				// verifica se foi atribuido realmente um nome à
				// caixa de texto, se não, emite mensagem de lembrança
				if (Nome.toString().trim()=="") {
					JOptionPane.showMessageDialog(null,"O nome deve ser digitado");
				}
				else {
					
					// Caso tenho sido atribuído um nome à caixa de texto
					// instacia a classe Jogo entregando como parametros
					// ao seu contrutor o nome do usuário (caixa de texto)
					// e a fase a ser jogada (selecionada na ComboBox)
					Jogo jg;
					jg = new Jogo(Nome.getText(), Fase.getSelectedIndex());
				}
			}
			
			// Se o que sofreu ação foi o botão Cancelar finaliza
			// todo o aplicativo
			if (event.getSource() == Cancelar)
				System.exit(0);
		}
	}
	
}