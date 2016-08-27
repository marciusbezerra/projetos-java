
import java.io.DataInputStream;
import Listas.*;

class Principal {
	public static void main(String[] args) {
		Lista ml = new Lista();
		char o, e; //o=opcao e=temporario
		DataInputStream meuDataInputStream = new DataInputStream(System.in);
		System.out.println("SELECIONE A OPCAO");
		System.out.println();
		System.out.println("i - Inserir (Ex.: ia insere a letra 'a', ou, ibia insere as letras 'b' e 'a')");
		System.out.println("r - Remover (Ex.: rrr remove tres itens)");
		System.out.println("m - Mostrar (Ex.: m)");
		System.out.println("q - Sair    (Ex.: q");
		System.out.println("Digite o comandos abaixo ----------------------");
		System.out.println();
		try {
			do {
				o = (char) meuDataInputStream.read();
				switch (o) {
				case 'i':
					//System.out.print("Inserir: ");
					e = (char) meuDataInputStream.read();
					ml.insere(e);
					break;
				case 'r':
					e=ml.remove();
					System.out.println(e);
					//System.out.flush();
					break;
				case 'm':
					ml.mostra();
					System.out.println();
					//System.out.flush();
				default:;
				}
			} while (o!='q');
		} catch (Exception erro) {
			/* nao faz nada! */
		}
	}
}
								  