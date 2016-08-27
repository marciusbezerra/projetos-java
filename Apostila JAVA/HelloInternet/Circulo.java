
// Classe circulo, arquivo Circulo.java

public class Circulo extends Ponto {
	// só atributos entre chaves
	
	private int raio;   // atributo raio do Circulo
	//public int x;     // posições em cordenadas cartesianas
	//public int y;     // já foram herdadas da classe Ponto


	
	// C O N T R U T O R E S
	public Circulo(int x, int y, int raio) {
		super.setX(x);
		super.setY(y);
		this.raio=raio;
		System.out.println("Objeto Circulo instanciado!");
	}
	
	public Circulo() {
		System.out.println("Objeto Circulo instanciado!");
	}
	
	public void move(int dx, int dy) {
		super.setX(super.getX()+dx);
		super.setY(super.getY()+dy);
	}
	public void mostra() {
		System.out.println("("+super.getX()+","+super.getY()+","+this.raio+")");
	}
	public void setRaio(int raio) {
		this.raio=raio;
	}
	public int getRaio() {
		return this.raio;
	}
}