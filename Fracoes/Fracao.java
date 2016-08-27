class Fracao {
	private int numerador, denominador;
	
	private int mdc(int numerador, int denominador) { //maximo divisor comum 
		if (numerador<0) numerador=-numerador;
		if (denominador<0) denominador=-denominador;
		while (denominador!=0) {
			int r = numerador%denominador; //% = MOD = Resto da divisao inteira
			numerador=denominador;
			denominador=r;
		}
		return numerador;
	}
	public Fracao(int numerador,int denominador) {
		this.numerador=numerador;
		this.denominador=denominador;
		this.simplifica();
	}
	public void simplifica() {
		int commd = mdc(this.numerador,this.denominador);
		this.numerador=this.numerador/commd;
		this.denominador=this.denominador/commd;
		if (this.denominador<0) {
			this.denominador=-this.denominador;
			this.numerador=-this.numerador;
		}
	}
	//operacoes matematicas basicas
	public Fracao soma(Fracao frac) {
		Fracao frac_ret = new Fracao((numerador*frac.denominador)+
									   (frac.numerador*denominador),
									   denominador*frac.denominador);
		return frac_ret;
	}
	public Fracao multiplicacao(Fracao frac) {
		Fracao frac_ret = new Fracao(numerador*frac.numerador,
									   denominador*frac.denominador);
		return frac_ret;
	}
	//operacoes de comparacoes
	public boolean igual(Fracao frac) {
		return ((numerador*frac.denominador)==(denominador*frac.numerador));
	}
	public boolean diferente(Fracao frac) {
		return ((numerador*frac.denominador)!=(denominador*frac.denominador));
	}
	public boolean maiorOuIgual(Fracao frac) {
		return ((numerador*frac.denominador)>=(frac.numerador*denominador));
	}
	//operacoes de OutPut
	public void mostra() {
		System.out.println("("+numerador+"/"+denominador+")");
	}
	//operacoes de conversao de tipos
	public int converteParInteiro(Fracao frac) {
		int ret = frac.numerador/frac.denominador;
		return ret;
	}
	public int converteParInteiro() {
		int ret = numerador/denominador;
		return ret;
	}
	public double converteParaDouble(Fracao frac) {
		double ret = ((double) frac.numerador/(double) frac.denominador);
		return ret;
	}
	public double converteParaDouble() {
		double ret = ((double) numerador/(double) denominador);
		return ret;
	}
	public void setNumerador(int novo_numerador) {
		numerador = novo_numerador;
	}
	public void setDenominador(int novo_denominador) {
		denominador=novo_denominador;
	}
	public int getNumerador() {
		return numerador;
	}
	public int getDenominador() {
		return denominador;
	}
}
