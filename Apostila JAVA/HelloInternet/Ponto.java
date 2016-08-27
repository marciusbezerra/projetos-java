
// Ponto circulo, arquivo Ponto.java

public class Ponto {
	// só atributos entre chaves
	
	private int x;    // posições em cordenadas cartesianas
	private int y;
	
	public Ponto() {
		System.out.println("Objeto Ponto instanciado!");
	}
	
	public Ponto(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("Objeto Ponto instanciado!");
	}
	
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void multiplicaX(int x) {
		this.x*=x;
	}
	public void multiplicaY(int y) {
		this.y*=y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void mostra() {
		System.out.println(this.x + "," + this.y);
	}
	public void move(int dx, int dy) {
		this.x=dx;
		this.y=dy;
	}
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}
