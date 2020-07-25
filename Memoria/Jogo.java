import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// CLASSE Jogo

// Responsável pela atribuição das imagens, gerenciamento 
// dos cliques, pelas regras do jogo, etc.

// Ela herda de JFrame, pois toda a tela do jogo em si é
// um JFrame, e implementa a interface para eventos do mouse
// MouseListener, isso foi feito para que não fosse necessária
// a criação de uma outra classe só para eventos, pois a
// própria classe Jogo vai gerenciar seus eventos e de os seus
// componentes.
public class Jogo extends JFrame implements MouseListener {
	private Carta[] cartasSelecionadas;
	
	// Declaração da variável importante numErros que é privada
	// para fora da classe, porém é visível por toda ela.
	// Essa variável é o Score do jogo, que será dado em número
	// de erros.
	private int numErros;
	public Jogo(String nome, int fase) {
		
		// CONTRUTOR:
		// Apresenta o texto na barra de título indicando a fase
		// e a pessoa que está jogando (que recebeu como parêmetro).
		super("Jogando " + nome + " - Fase: " + (fase+1));
		
		// Zera o número de erros
		numErros = 0;
		
		// Cria o container (a janela)
		Container c = getContentPane();
		
		// Baseado na fase indicada, calcula o número
		// de colunas e linhas que aparecerão na tela,
		// e seta o Layout para o formato em grade.
		int colLin = (fase + 1) * 2;
		c.setLayout(new GridLayout(colLin, colLin));

		// Calcula o número de quadros que o jogo apresentará 
		// na tela (o número de cartas)
		int contImagens = (int) (colLin * colLin);
		
		// Dimensiona o JFrame com o tamanho máximo da
		// tela do computador
		Dimension d = c.getMaximumSize();
		setSize(d);

		// Calcula o tanto de imagens que serão necessárias
		// para o jogo.
		int numCartas = (contImagens / 2);
		
		// Baseado no número de quadros, cria um vetor
		// de objetos Carta
		Carta ct[] = new Carta[contImagens];
		
		// Cria um vetor com um números aleatórios
		// que servirá para embaralhar metade da
		// cartas
		int[] aleatorio = numAleatorios(numCartas);
		
		// Atribui uma nova carta a cada índice
		// do vetor (para a metade das cartas)
		for (int i = 0; i < numCartas; i++) {
			ct[i] = new Carta();
			
			// Pega o índice de cada imagem sorteada
			// e atribue à carta ct
			ct[i].setIndiceImagem(aleatorio[i]);
			
			// Ativa os eventos Clique do Mouse para 
			// cada carta ct
			ct[i].addMouseListener(this);
			
			// Adciona cada carta ao JPanel
			c.add(ct[i]);
			}

		// Criar um vetor com um números aleatórios
		// que servirá para embaralhar a outra metade
		// (os pares) das cartas
		aleatorio = numAleatorios(numCartas);
			
		// Atribui uma nova carta a cada índice
		// do vetor para a outra metade
		// das cartas (os pares das já posicionadas)
		for (int i = 0; i < numCartas; i++) {
			ct[i+numCartas] = new Carta();

			// Pega o índice de cada imagem sorteada
			// e atribue à carta ct
			ct[i+numCartas].setIndiceImagem(aleatorio[i]);

			// Ativa os eventos Clique do Mouse para 
			// cada carta ct
			ct[i+numCartas].addMouseListener(this);
			
			// Adciona cada carta ao JPanel
			c.add(ct[i+numCartas]);
			}
		
		// Atribue todo o vetor de cartas criado acima,
		// que é privado apenas ao método construtor, ao
		// vetor cartasSelecionadas, que é público para
		// toda a classe. Isso será necessário para tratar
		// o evento clique do mouse.
		cartasSelecionadas = ct;
		
		// mostra o JPanel
		setVisible(true);
	}
	
	// Este evento é disparado quando você clica em uma classe
    public void mouseClicked(MouseEvent e) {
    	
    	// Se o objeto que recebeu o que é uma instancia de uma Carta...
    	if (e.getSource() instanceof Carta) {
    		
    		// Converte o objeto que recebeu o clique em uma variável
    		// temporária da classe Carta
    		Carta atual = ((Carta) (e.getSource()));
    		
    		// Se a carta pode ser mexida, ou seja, não foi
    		// resultado de um acerto do usuário...
	    	if (atual.getJaJogada() == false) {
	    		
	    		// Se a carta já estava sendo mostrada, não
	    		// pode ser mais ocultada novamente!
	    		// Caso o jogo aceite isso, bastaria usar
	    		// Atual.Esconder()
				if (atual.Mostrando())
					JOptionPane.showMessageDialog(null,
						"Carta ja vista nao pode mais ser escondida.");
				else {
					// Se a carta já não estava sendo mostrada,
					// mostra ela (sua imagem)...
					atual.Mostrar();	
					
					// Usa o método que para procurar por uma carta
					// igual já exibida e apesentar as devidas mensagem
					// (explicado abaixo)...
					procuraCartaIgual(atual);
					
					// Sempre verifica se o jogo já terminou,
					// se sim, exibe a mensagem abaixo indicando
					// o número de erros
					if (terminou()) {
						JOptionPane.showMessageDialog(null,
							"O Jogo terminou!!! Voce errou " + 
							numErros + " veze(s)");
						this.dispose();
					}
				}
			}
		}
    }

	// Como a classe Jogo (essa) implementou a interface de tratamentos
	// de eventos do mouse MouseListener, todos os métodos de
	// MouseListener devem ser declarados, mesmo os que não serão
	// utilizados, como abaixo:
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    private boolean terminou() {
    	
    	// Este método verifica se alguma carta ainda pode ser
    	// mexida, para saber se o jogo já terminou, em caso
    	// afirmativo. retorna false (não terminou), do contrário,
    	// retrna true.
    	boolean ret = true;
    	for (int i=0; i<cartasSelecionadas.length; i++) {
    		
    		// Para fazer a verificação teve que ser usado o
    		// vetor público cartasSelecionadas
    		if (! (cartasSelecionadas[i].getJaJogada())) {
    			ret = false;
    			// Se encontrou uma que ainda pode ser mexida
    			// para o laço
    			break;
    		}
    	}
    	return ret;
    }
    
    // Esse método irá procurar por uma carta igual, que já havia
    // sido exibida, cada vez que uma nova carta seja exibida (clicada)
  	private void procuraCartaIgual(Carta ct) {
  		
  		// Faz um loop por todas as cartas do jogo...
    	for (int i=0; i < cartasSelecionadas.length; i++) {
    		
    		// Se a carta anterior estiver sendo mostrada e ...
    		if ((cartasSelecionadas[i].Mostrando() == true) && 
    		
    			// se ela não for a atual e ...
    			(! (cartasSelecionadas[i].equals(ct))) && 
    			
    			// se ela não foi resultado de uma acerto (se
    			// pode ser mexida)...
    			(cartasSelecionadas[i].getJaJogada() == false)) {
    			
    			// Se a imagem da carta anterior for igual a imagem da
    			// carta atual...	
	    		if (cartasSelecionadas[i].getIndiceImagem() == ct.getIndiceImagem()) {
	    			
	    			// é porque houve um acerto, então indica que as duas cartas
	    			// não podem mais ser mexidas, e mostra a mensagem de acerto
	    			// parando a busca
					cartasSelecionadas[i].setJaJogada(true);
					ct.setJaJogada(true);
					JOptionPane.showMessageDialog(null,"Voce acertou!!");
					break;
				}
				else {
					// Já se as imagens da cartas não forem iguais,
					// mostra a mensagem de erro, as esconde, e incrementa o
					// número de erros, parando a busca
					JOptionPane.showMessageDialog(null,"Voce errou!!");
					cartasSelecionadas[i].Esconder();
					ct.Esconder();
					numErros += 1;
					break;
				}
    		}
    	}
    }
	
	
	private boolean procuraNumero(int[] vetor, int num) {
		// Esse método faz um loop para saber se um número
		// já pertence ao vetor que ele recebeu como parâmetro (true)
		// ou não (false).
		// O próximo método irá utilizá-lo
		for (int i=0;i < vetor.length; i++) {
			if (vetor[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	private int[] numAleatorios(int max) {
		// Este método cria um vetor de números randômicos
		// que servirá para embaralhar as cartas
		int numeros[] = new int[max];
		int n;
		for (int i = 0; i < max; i++) {
			// Atribue um número aleatório à variável n
			// e inclui esse n ao vetor numeros[] apenas
			// se esse vetor não já guardar esse número n
			// (para isso, usa o método anteior).
			n = 1 + (int) (Math.random() * max);
			while (procuraNumero(numeros, n)) { 
				n = 1 + (int) (Math.random() * max);
			}
			numeros[i] = n;
		}
		return numeros;
	}
}
