
public class Reta {
	private Ponto ponto1;
	private Ponto ponto2;
	
	public Reta() {
		ponto1=new Ponto();
		ponto2=new Ponto();
	}
	
	public void desenhaReta(int x1, int y1, int x2, int y2) {
		ponto1.setX(x1);
		ponto1.setY(y1);
		ponto2.setX(x2);
		ponto2.setY(y2);
	}
	public void mostra() {
		ponto1.mostra();
		ponto2.mostra();
	}
}