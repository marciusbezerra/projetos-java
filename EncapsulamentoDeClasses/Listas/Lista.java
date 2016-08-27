
package Listas;

class No { // pode ser acessada por todo o package
	private char info;
	private No prox;
	No(char i, No p) { // C O N S T R U T O R
		info=i;
		prox=p;
	}
	char getInfo() {
		return this.info;
	}
	void setInfo(char i) {
		this.info=i;
	}
	void setProx(No p) {
		this.prox=p;
	}
	No getProx() {
		return this.prox;
	}
	
}

public class Lista {
	private No cabeca;    // inicio da lista
	private int elementos; // numero de elementos
	
	public Lista() {
		cabeca=null;
		elementos=0;
	}
	public void insere(char a) {
		elementos++;
		No temp;
		if (cabeca==null) cabeca=new No(a,null);
		else {
			temp=new No(a,null);
			temp.setProx(cabeca);
			cabeca=temp;
		}
	}
	public char remove() {
		No removido;
		if (cabeca==null) return '0';
		else {
			elementos--;
			removido=cabeca;
			cabeca=cabeca.getProx();
			return cabeca.getInfo();
		}
	}
	public int getElementos() {
		return elementos;
	}
	public void mostra() {
		No temp=cabeca;
		while (temp!=null) {
			System.out.print("["+temp.getInfo()+"]-");
			temp=temp.getProx();
		}
		System.out.print ("Null");
		System.out.println ();
	}
}