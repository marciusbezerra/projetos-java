import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// CLASSE Jogo

// Respons�vel pela atribui��o das imagens, gerenciamento 
// dos cliques, pelas regras do jogo, etc.

// Ela herda de JFrame, pois toda a tela do jogo em si �
// um JFrame, e implementa a interface para eventos do mouse
// MouseListener, isso foi feito para que n�o fosse necess�ria
// a cria��o de uma outra classe s� para eventos, pois a
// pr�pria classe Jogo vai gerenciar seus eventos e de os seus
// componentes.
public class Jogo extends JFrame implements MouseListener {
	private Carta[] cartasSelecionadas;
	
	// Declara��o da vari�vel importante numErros que � privada
	// para fora da classe, por�m � vis�vel por toda ela.
	// Essa vari�vel � o Score do jogo, que ser� dado em n�mero
	// de erros.
	private int numErros;
	public Jogo(String nome, int fase) {
		
		// CONTRUTOR:
		// Apresenta o texto na barra de t�tulo indicando a fase
		// e a pessoa que est� jogando (que recebeu como par�metro).
		super("Jogando " + nome + " - Fase: " + (fase+1));
		
		// Zera o n�mero de erros
		numErros = 0;
		
		// Cria o container (a janela)
		Container c = getContentPane();
		
		// Baseado na fase indicada, calcula o n�mero
		// de colunas e linhas que aparecer�o na tela,
		// e seta o Layout para o formato em grade.
		int colLin = (fase + 1) * 2;
		c.setLayout(new GridLayout(colLin, colLin));

		// Calcula o n�mero de quadros que o jogo apresentar� 
		// na tela (o n�mero de cartas)
		int contImagens = (int) (colLin * colLin);
		
		// Dimensiona o JFrame com o tamanho m�ximo da
		// tela do computador
		Dimension d = c.getMaximumSize();
		setSize(d);

		// Calcula o tanto de imagens que ser�o necess�rias
		// para o jogo.
		int numCartas = (contImagens / 2);
		
		// Baseado no n�mero de quadros, cria um vetor
		// de objetos Carta
		Carta ct[] = new Carta[contImagens];
		
		// Cria um vetor com um n�meros aleat�rios
		// que servir� para embaralhar metade da
		// cartas
		int[] aleatorio = numAleatorios(numCartas);
		
		// Atribui uma nova carta a cada �ndice
		// do vetor (para a metade das cartas)
		for (int i = 0; i < numCartas; i++) {
			ct[i] = new Carta();
			
			// Pega o �ndice de cada imagem sorteada
			// e atribue � carta ct
			ct[i].setIndiceImagem(aleatorio[i]);
			
			// Ativa os eventos Clique do Mouse para 
			// cada carta ct
			ct[i].addMouseListener(this);
			
			// Adciona cada carta ao JPanel
			c.add(ct[i]);
			}

		// Criar um vetor com um n�meros aleat�rios
		// que servir� para embaralhar a outra metade
		// (os pares) das cartas
		aleatorio = numAleatorios(numCartas);
			
		// Atribui uma nova carta a cada �ndice
		// do vetor para a outra metade
		// das cartas (os pares das j� posicionadas)
		for (int i = 0; i < numCartas; i++) {
			ct[i+numCartas] = new Carta();

			// Pega o �ndice de cada imagem sorteada
			// e atribue � carta ct
			ct[i+numCartas].setIndiceImagem(aleatorio[i]);

			// Ativa os eventos Clique do Mouse para 
			// cada carta ct
			ct[i+numCartas].addMouseListener(this);
			
			// Adciona cada carta ao JPanel
			c.add(ct[i+numCartas]);
			}
		
		// Atribue todo o vetor de cartas criado acima,
		// que � privado apenas ao m�todo construtor, ao
		// vetor cartasSelecionadas, que � p�blico para
		// toda a classe. Isso ser� necess�rio para tratar
		// o evento clique do mouse.
		cartasSelecionadas = ct;
		
		// mostra o JPanel
		setVisible(true);
	}
	
	// Este evento � disparado quando voc� clica em uma classe
    public void mouseClicked(MouseEvent e) {
    	
    	// Se o objeto que recebeu o que � uma instancia de uma Carta...
    	if (e.getSource() instanceof Carta) {
    		
    		// Converte o objeto que recebeu o clique em uma vari�vel
    		// tempor�ria da classe Carta
    		Carta atual = ((Carta) (e.getSource()));
    		
    		// Se a carta pode ser mexida, ou seja, n�o foi
    		// resultado de um acerto do usu�rio...
	    	if (atual.getJaJogada() == false) {
	    		
	    		// Se a carta j� estava sendo mostrada, n�o
	    		// pode ser mais ocultada novamente!
	    		// Caso o jogo aceite isso, bastaria usar
	    		// Atual.Esconder()
				if (atual.Mostrando())
					JOptionPane.showMessageDialog(null,
						"Carta ja vista nao pode mais ser escondida.");
				else {
					// Se a carta j� n�o estava sendo mostrada,
					// mostra ela (sua imagem)...
					atual.Mostrar();	
					
					// Usa o m�todo que para procurar por uma carta
					// igual j� exibida e apesentar as devidas mensagem
					// (explicado abaixo)...
					procuraCartaIgual(atual);
					
					// Sempre verifica se o jogo j� terminou,
					// se sim, exibe a mensagem abaixo indicando
					// o n�mero de erros
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
	// de eventos do mouse MouseListener, todos os m�todos de
	// MouseListener devem ser declarados, mesmo os que n�o ser�o
	// utilizados, como abaixo:
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    private boolean terminou() {
    	
    	// Este m�todo verifica se alguma carta ainda pode ser
    	// mexida, para saber se o jogo j� terminou, em caso
    	// afirmativo. retorna false (n�o terminou), do contr�rio,
    	// retrna true.
    	boolean ret = true;
    	for (int i=0; i<cartasSelecionadas.length; i++) {
    		
    		// Para fazer a verifica��o teve que ser usado o
    		// vetor p�blico cartasSelecionadas
    		if (! (cartasSelecionadas[i].getJaJogada())) {
    			ret = false;
    			// Se encontrou uma que ainda pode ser mexida
    			// para o la�o
    			break;
    		}
    	}
    	return ret;
    }
    
    // Esse m�todo ir� procurar por uma carta igual, que j� havia
    // sido exibida, cada vez que uma nova carta seja exibida (clicada)
  	private void procuraCartaIgual(Carta ct) {
  		
  		// Faz um loop por todas as cartas do jogo...
    	for (int i=0; i < cartasSelecionadas.length; i++) {
    		
    		// Se a carta anterior estiver sendo mostrada e ...
    		if ((cartasSelecionadas[i].Mostrando() == true) && 
    		
    			// se ela n�o for a atual e ...
    			(! (cartasSelecionadas[i].equals(ct))) && 
    			
    			// se ela n�o foi resultado de uma acerto (se
    			// pode ser mexida)...
    			(cartasSelecionadas[i].getJaJogada() == false)) {
    			
    			// Se a imagem da carta anterior for igual a imagem da
    			// carta atual...	
	    		if (cartasSelecionadas[i].getIndiceImagem() == ct.getIndiceImagem()) {
	    			
	    			// � porque houve um acerto, ent�o indica que as duas cartas
	    			// n�o podem mais ser mexidas, e mostra a mensagem de acerto
	    			// parando a busca
					cartasSelecionadas[i].setJaJogada(true);
					ct.setJaJogada(true);
					JOptionPane.showMessageDialog(null,"Voce acertou!!");
					break;
				}
				else {
					// J� se as imagens da cartas n�o forem iguais,
					// mostra a mensagem de erro, as esconde, e incrementa o
					// n�mero de erros, parando a busca
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
		// Esse m�todo faz um loop para saber se um n�mero
		// j� pertence ao vetor que ele recebeu como par�metro (true)
		// ou n�o (false).
		// O pr�ximo m�todo ir� utiliz�-lo
		for (int i=0;i < vetor.length; i++) {
			if (vetor[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	private int[] numAleatorios(int max) {
		// Este m�todo cria um vetor de n�meros rand�micos
		// que servir� para embaralhar as cartas
		int numeros[] = new int[max];
		int n;
		for (int i = 0; i < max; i++) {
			// Atribue um n�mero aleat�rio � vari�vel n
			// e inclui esse n ao vetor numeros[] apenas
			// se esse vetor n�o j� guardar esse n�mero n
			// (para isso, usa o m�todo anteior).
			n = 1 + (int) (Math.random() * max);
			while (procuraNumero(numeros, n)) { 
				n = 1 + (int) (Math.random() * max);
			}
			numeros[i] = n;
		}
		return numeros;
	}
}
