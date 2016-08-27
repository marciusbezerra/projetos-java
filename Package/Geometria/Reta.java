
package Geometria;

public class Reta {
	Ponto a,b; //visiveis dentro do package
	
	public Reta(float ax, float ay, float bx, float by) {
		a=new Ponto(ax,ay);
		b=new Ponto(bx,by);
	}
	public float distancia(Ponto ap) {
		// metodo nao implementado
		return 0.0f; //converte para float
	}
	public void mostra() {
		a.mostra();
		b.mostra();
	}
}
