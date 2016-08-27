
public class Trava {
	private String quem;
	private boolean travado;
	
	public void travar(String quem) {
		this.travado=true;
		this.quem=quem;
	}
	public void destravar(String quem) {
		this.travado=false;
		this.quem=quem;
	}
	public void alternaTrava(String quem) {
		this.quem=quem;
		this.travado=!this.travado;
	}
	public boolean estado() {
		return this.travado;
	}
}