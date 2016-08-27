
import Geometria.*;

public class Principal {
	public static void main(String[] args) {
		Circulo acirc;
		//acirc.x=(float) 10; ERRO! x so eh visivel dentro do package
		Ponto apto;
		acirc = new Circulo((float) 0,(float) 0,(float) 1);
		acirc.mostra();
		apto= new Ponto((float) 4,(float) 3);
		apto.mostra();
		System.out.println ("Distancia: "+acirc.distancia(apto));
	}
}