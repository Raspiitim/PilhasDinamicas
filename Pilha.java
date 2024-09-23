package Dinamica;

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
            return elementoTopo.getElemento();
        }
        return null;
    }

    // Adiciona múltiplos elementos à pilha
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
    
    // Mostra o conteúdo da pilha
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

    // Encontra a posição do elemento
    public int encontrarPosicao(Object elemento) {
        int posicao = 0;
        No atual = this.topo;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }

        return -1; // Retorna -1 se o elemento não for encontrado
    }

    // Limpa a pilha
    public void limparPilha() {
        this.topo = null;
        this.tamanho = 0;
        System.out.println("A pilha foi esvaziada.");
    }

    // Inverte a pilha
    public void inverterPilha() {
        if (this.isEmpty()) return;

        No atual = this.topo;
        No anterior = null;
        No proximo = null;

        while (atual != null) {
            proximo = atual.getProximo();
            atual.setProximo(anterior);
            anterior = atual;
            atual = proximo;
        }
        this.topo = anterior;
        System.out.println("A pilha foi invertida.");
    }

    // Verifica se o elemento existe na pilha
public boolean contemElemento(Object elemento) {
    No atual = this.topo;
    while (atual != null) {
        if (atual.getElemento().equals(elemento)) {
            return true;
        }
        atual = atual.getProximo();
    }
    return false;
}

// Clona a pilha
public Pilha clonar() {
    Pilha pilhaClone = new Pilha();
    No atual = this.topo;
    Pilha pilhaAux = new Pilha();

    while (atual != null) {
        pilhaAux.push(atual.getElemento());
        atual = atual.getProximo();
    }
    
    while (!pilhaAux.isEmpty()) {
        pilhaClone.push(pilhaAux.pop());
    }
    
    return pilhaClone;
}

// Compara duas pilhas
public boolean compararPilha(Pilha outraPilha) {
    if (this.size() != outraPilha.size()) return false;
    
    No atual1 = this.topo;
    No atual2 = outraPilha.topo;
    
    while (atual1 != null && atual2 != null) {
        if (!atual1.getElemento().equals(atual2.getElemento())) {
            return false;
        }
        atual1 = atual1.getProximo();
        atual2 = atual2.getProximo();
    }
    
    return true;
}

// Troca o topo da pilha
public void trocarTopo(Object novoElemento) {
    if (!this.isEmpty()) {
        this.topo.setElemento(novoElemento);
    }
}

// Obter o elemento na base
public Object obterBase() {
    No atual = this.topo;
    while (atual != null && atual.getProximo() != null) {
        atual = atual.getProximo();
    }
    return atual != null ? atual.getElemento() : null;
}

// Remover o elemento na base
public void removerBase() {
    if (this.tamanho == 1) {
        pop();
        return;
    }

    No atual = this.topo;
    No anterior = null;
    
    while (atual.getProximo() != null) {
        anterior = atual;
        atual = atual.getProximo();
    }
    
    if (anterior != null) {
        anterior.setProximo(null);
        this.tamanho--;
    }
}

// Exibe o elemento da base sem removê-lo
public Object verBase() {
    No atual = this.topo;
    while (atual.getProximo() != null) {
        atual = atual.getProximo();
    }
    return atual.getElemento();
}


    // Métodos getters e setters
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
