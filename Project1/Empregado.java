public class Empregado
{
	private String nome;
	private int idade;
	private int tempoDeServico;
	private int numeroDeDependentes;
	private double salarioBase;
	private double salarioFinal;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setTempoDeServico(int tempoDeServico) {
		this.tempoDeServico = tempoDeServico;
	}
	public void setNumeroDeDependentes(int numeroDeDependentes) {
		this.numeroDeDependentes = numeroDeDependentes;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	private String getNome() {
		return this.nome;
	}
	private int getIdade() {
		return this.idade;
	}
	private int getTempoDeServico() {
		return this.tempoDeServico;
	}
	private int getNumeroDeDependentes() {
		return this.numeroDeDependentes;
	}
	private double getSalarioBase() {
		return this.salarioBase;
	}
	private double getSalarioFinal() {
		switch (this.numeroDeDependentes) {
		case 0: {
					if (this.tempoDeServico >= 0 && this.tempoDeServico<=2)
						return (this.salarioBase + (this.salarioBase*0.10));
					if (this.tempoDeServico > 2 && this.tempoDeServico<=5)
						return (this.salarioBase + (this.salarioBase*0.15));
					if (this.tempoDeServico > 5 && this.tempoDeServico<=10)
						return (this.salarioBase + (this.salarioBase*0.20));
					if (this.tempoDeServico > 10)
						return (this.salarioBase + (this.salarioBase*0.30));
					break;
				}
		case 1: case 2: case 3: {
					if (this.tempoDeServico >= 0 && this.tempoDeServico<=2)
						return (this.salarioBase + (this.salarioBase*0.20));
					if (this.tempoDeServico > 2 && this.tempoDeServico<=5)
						return (this.salarioBase + (this.salarioBase*0.25));
					if (this.tempoDeServico > 5 && this.tempoDeServico<=10)
						return (this.salarioBase + (this.salarioBase*0.30));
					if (this.tempoDeServico > 10)
						return (this.salarioBase + (this.salarioBase*0.40));
					break;
							  }
		default: {
					 if (this.numeroDeDependentes>3) {
						if (this.tempoDeServico >= 0 && this.tempoDeServico<=2)
							return (this.salarioBase + (this.salarioBase*0.30));
						if (this.tempoDeServico > 2 && this.tempoDeServico<=5)
							return (this.salarioBase + (this.salarioBase*0.35));
						if (this.tempoDeServico > 5 && this.tempoDeServico<=10)
							return (this.salarioBase + (this.salarioBase*0.40));
						if (this.tempoDeServico > 10)
							return (this.salarioBase + (this.salarioBase*0.50));
						break;
					 }
					 else return(0);
		}
		}
		return this.salarioFinal;
	}

}

/*

import java.io.DataInputStream; // classe DataInputStream para entrada de dados

public class ReadString {
	public static void main(String[] args) {
		String linha="";
		DataInputStream meuDataInputStream;
		meuDataInputStream =new DataInputStream(System.in);
		try {
			linha=meuDataInputStream.readLine();
		}
		catch (Exception e) {
			System.out.println ("Erro de leitura.");
		}
		System.out.println (linha);
	}
}

import java.io.DataInputStream;

public class ReadInt {
	public static void main(String[] args) {
		String linha;
		DataInputStream in = new DataInputStream(System.in);
		try {
			linha = in.readLine();
			int i = Integer.valueOf(linha).intValue();
			System.out.println (i);
		}
		catch (Exception e) {
			System.out.println ("ERRO!!");
		}
	}
}

*/
