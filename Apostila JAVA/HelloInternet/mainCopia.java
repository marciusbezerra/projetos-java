
public class mainCopia {
	public static void main(String[] args) {
		// prepara as variáveis cópia de objetos
		Ponto pOriginal,pAlias,pCopia;
		pOriginal=new Ponto((int) 0,(int) 0);
		pAlias=pOriginal;
		pCopia=new Ponto(pOriginal.getX(),pOriginal.getY());
		
		// resultados
		
		System.out.println ("Original: "+pOriginal);
		System.out.println ("Alias: "+pAlias);
		System.out.println ("Modificando pAlias.x para 2");
		pAlias.setX(2);
		System.out.println ("Veja como o pOriginal ficou: "+pOriginal);
		System.out.println ("pCopia nao se modifica: "+pCopia);
		
		// comparando os objetos
		
		System.out.println ("pOriginal==pAlias: "+(pOriginal==pAlias));
		System.out.println ("pCopia==pOriginal: "+(pCopia==pOriginal));
		System.out.println ("Deixando os atributos de pCopia iguais aos de pOriginal");
		pCopia.setX(2);
		System.out.println ("pCopia==pOriginal: "+(pCopia==pOriginal));
		System.out.println ("pOriginal.x==pCopia.x: "+(pCopia.getX()==pOriginal.getX()));
		System.out.println ("pOriginal.y==pCopia.y: "+(pCopia.getY()==pOriginal.getY()));
	}
}