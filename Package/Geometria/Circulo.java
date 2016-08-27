
package Geometria;

public class Circulo {
	float raio, x,y;
	
	public Circulo(float ax, float ay, float ar) {
		this.x=ax; this.y=ay; this.raio=ar;
	}
	public void setRaio(float r) {
		this.raio=r;
	}
	public float getRaio() {
		return this.raio;
	}
	public void move(float dx, float dy) {
		this.x+=dx; this.y+=dy;
	}
	public float distancia(Ponto ap) {
		float dcp; //distancia do centro do circulo ao ponto
		// acesso direto aos atributos de ap pq as classes pertencem ao mesmo
		// package:
		dcp= (float) Math.sqrt((double) ((x-ap.x)*(x-ap.x)+(y-ap.y)*(y-ap.y)));
		if (dcp<this.raio) {
			return this.raio-dcp;
		}
		else {
			return dcp-this.raio;
		}
	}
	public void mostra() {
		System.out.println (this.x+","+this.y+","+this.raio);
	}
}