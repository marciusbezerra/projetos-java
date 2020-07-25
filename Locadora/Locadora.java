class Locadora extends Produto {
	
	private String nome, endereco;
	private int quantidade;
	private Produto[] prod;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setTamanhoProduto(int n) {
		int i;
		quantidade = 0;
		prod[] = new Produto[n];
		for (i=0;i<=n;i++)
			prod[i] = new Produto();
	}
	
	public void addProduto(Produto prod) {
		
	}
}
