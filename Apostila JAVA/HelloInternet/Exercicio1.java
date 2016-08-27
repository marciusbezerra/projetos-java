

public class Exercicio1 {
	public static void main(String[] args) {
		Circulo acirc;
		acirc = new Circulo();
		System.out.println("(" + acirc.getX() + ", " + 
			acirc.getY() + ", " + acirc.getRaio() + ")");
		acirc.setX(1);
		acirc.setY(1);
		System.out.println("(" + acirc.getX() + ", " + acirc.getY() + ", " + acirc.getRaio() + ")");
	}
}