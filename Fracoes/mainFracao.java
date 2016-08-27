/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Class1'
 * created in the main() method.
 */
public class mainFracao
{
	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	private static void imprime(String texto, boolean pulalinha) {
		if (pulalinha) System.out.println(texto);
		else System.out.print(texto);
	}
	public static void main (String[] args)	{
		Fracao a,b,c;
		a=new Fracao(5,3);
		b=new Fracao(2,6);
		imprime("Fracao A..: ",false);
		a.mostra();
		imprime("Fracao B..: ",false);
		b.mostra();
		c=a.soma(b);
		imprime("A + B.....: ",false);
		c.mostra();
		imprime("A * B.....: ",false);
		c=a.multiplicacao(b);
		c.mostra();
		imprime("A >= B....: "+a.maiorOuIgual(b),true);
		imprime("A == B....: "+a.igual(b),true);
		imprime("A != B....: "+a.diferente(b),true);
		imprime("(int) A...: "+a.converteParInteiro(),true);
		imprime("(double) A: "+a.converteParaDouble(),true);
	}
}
