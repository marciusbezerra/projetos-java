
package Geometria;

public class Ponto {
	float x,y;// Nao foi especificado o nivel do escopo, entao package eh o
	          // padrao
	public Ponto(float ax, float ay) {
		this.x=ax; this.y=ay;
	}
	public float getX() {
		return this.x;
	}
	public void move(float dx, float dy) {
		this.x+=dx; this.y+=dy;
	}
	public void mostra() {
		System.out.println (this.x+","+this.y);
	}
}