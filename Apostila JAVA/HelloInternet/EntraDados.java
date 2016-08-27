
import java.io.*;

class EntraDados {
	public static void main(String[] args) {
		byte vetortexto[]=new byte[200];
		int byteslidos=0;
		System.out.print ("Escreva algo: ");
		try {
			byteslidos=System.in.read(vetortexto);
			System.out.print ("Voce escreveu: ");
			System.out.write(vetortexto,0,byteslidos);
		}
		catch (IOException e) {
			// alguma acao de recuperacao da falha
		}
	}
}