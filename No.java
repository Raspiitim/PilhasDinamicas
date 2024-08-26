package teste;

public class Pilha {
    private No topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    // Adiciona
    public void push(Object elemento) {
        No novo = new No(elemento, this.topo);
        this.topo = novo;
        this.tamanho++;
    }

    // Verifica se é vazia
    public Boolean isEmpty() {
        return this.topo == null;
    }

    // Verifica o tamanho
    public int size() {
        return this.tamanho;
    }

    // Retorna o topo
    public Object top() {
        return this.topo != null ? this.topo.getElemento() : null;
    }

    // Remove
    public Object pop() {
        if (!this.isEmpty()) {
            No elementoTopo = this.topo;
            this.topo = this.topo.getProximo();
            this.tamanho--;
            return elementoTopo.getElemento(); // Corrigido para retornar o elemento, não o nó
        }
        return null; // Corrigido para retornar null ao invés de false
    }

    // Adiciona múltiplos elementos à pilha
    // Para usar: Object[] elementos = {"A", "B", "C", "D"};
    public void pushMultiplos(Object[] elementos) {
        for (Object elemento : elementos) {
            push(elemento);
        }
    }

    // Retorna a ocorrência do elemento na pilha
    public int contarOcorrencias(Object elemento) {
        int contador = 0;
        No atual = this.topo;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                contador++;
            }
            atual = atual.getProximo();
        }

        return contador;
    }

    // Remove todos os elementos iguais
    public void removerTodos(Object elemento) {
        No anterior = null;
        No atual = this.topo;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                if (anterior == null) { // Removendo o topo
                    this.topo = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                this.tamanho--;
            } else {
                anterior = atual;
            }
            atual = atual.getProximo();
        }
    }

    // Retorna a profundidade de um elemento na pilha
    public int profundidadeElemento(Object elemento) {
        int profundidade = 0;
        No atual = this.topo;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return profundidade;
            }
            atual = atual.getProximo();
            profundidade++;
        }

        return -1;
    }
    
    public void mostrarPilha() {
        No atual = this.topo;
        if (atual == null) {
            System.out.println("A pilha está vazia.");
            return;
        }

        System.out.println("Conteúdo da pilha (do topo para a base):");
        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximo();
        }
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
