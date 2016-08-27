// Classe principal, arquivo Principal.java

public class Principal {
	public static void main(String args[]) {
		Circulo umcirc;
		umcirc = new Circulo(0,0,12);
		umcirc.mostra();
		umcirc.move(-10,-10);
		umcirc.mostra();
		umcirc.setX(100);
		umcirc.multiplicaY(10);
		umcirc.mostra();
	}
}