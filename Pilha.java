package atividadePilhas;

public class Pilha {
	private No topo;
	private int tamanho;
	
	public Pilha(No topo, int tamanho) {
		this.topo = null;
		this.tamanho = 0;
	}

	//adiciona
	public void push(Object elemento) {
		No novo = new No(elemento, this.topo);
		this.topo = novo;
		this.tamanho++;
	}
	
	//verifica se é vazia
	public Boolean isEmpty() {
		return this.topo == null;
	}
	
	//verifica o tamanho
	public int size() {
		return this.tamanho;
	}
	
	//retorna o topo
	public Object top() {
		return this.getTopo();
	}
	
	//remove
	public Object pop() {
		if(!(this.isEmpty())) {
			No elementoTopo = this.topo;
			this.topo = this.topo.getProximo();
			this.tamanho--;
			return elementoTopo;
		}
		return false;
	}
	
	public No getTopo() {
		return topo;
	}

	public void setTopo(No topo) {
		this.topo = topo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}	
}