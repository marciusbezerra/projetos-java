
// Classe Contador, arquivo Contador.java

public class Contador {
	public int num;
	
	public void incrementa() {
		num++;
		if (this.num > 59) num = 0;
	}
	public void decrementa() {
		num--;
		if (this.num < 0) this.num = 59;
	}
	public void comeca(int n) {
		num = n;
	}
	public void mostra() {
		System.out.println(this.num);
	}
	
}