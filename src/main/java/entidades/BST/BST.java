package entidades.BST;

import interfaces.BST_IF;
import interfaces.Filme_IF;

import java.util.ArrayList;

public class BST implements BST_IF {
    private No root;
    private int size;

    @Override
    public Filme_IF remove(long id) throws Exception {
        No[] removido = new No[1];  // Usar um array para capturar o nó removido
        this.root = removerRecursivo(this.root, id, removido);
        if (removido[0] != null) {
            size--;
            return removido[0].getFilme();
        }
        throw new Exception("Filme não encontrado");
    }

    private No removerRecursivo(No atual, long id, No[] removido) {
        if (atual == null) {
            return null;
        }
        if (id < atual.getFilme().getID()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), id, removido));
        } else if (id > atual.getFilme().getID()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), id, removido));
        } else {
            // Nó encontrado
            removido[0] = atual;  // Captura o nó removido
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }
            // Nó com dois filhos: encontra o menor nó da subárvore direita
            No menor = encontrarMenor(atual.getDireita());
            atual.setFilme(menor.getFilme());
            atual.setDireita(removerRecursivo(atual.getDireita(), menor.getFilme().getID(), removido));
        }
        return atual;
    }

    private No encontrarMenor(No atual) {
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }


    @Override
    public void insert(Filme_IF elemento) {
        this.root = inserirRecursivo(this.root, elemento);
    }
    private No inserirRecursivo(No atual, Filme_IF elemento) {
        if (atual == null) {
            size++;
            return new No(elemento);
        }
        if (elemento.getID() < atual.getFilme().getID()) {
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(),
                    elemento));
        } else if (elemento.getID() > atual.getFilme().getID()) {
            atual.setDireita(inserirRecursivo(atual.getDireita(),
                    elemento));
        }
        return atual;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        No resultado = buscarRecursivo(this.root, id);
        if (resultado == null) {
            throw new Exception("Filme não encontrado");
        }
        return resultado.getFilme();
    }
    private No buscarRecursivo(No atual, long id) {
        if (atual == null || atual.getFilme().getID() == id) {
            return atual;
        }
        if (id < atual.getFilme().getID()) {
            return buscarRecursivo(atual.getEsquerda(), id);
        } else {
            return buscarRecursivo(atual.getDireita(), id);
        }
    }

    @Override
    public Filme_IF root() throws Exception {
        if (this.root == null) {
            throw new Exception("Árvore vazia");
        }
        return this.root.getFilme();
    }

    @Override
    public int height() {
        return calcularAltura(this.root);
    }
    private int calcularAltura(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = calcularAltura(atual.getEsquerda());
        int alturaDireita = calcularAltura(atual.getDireita());
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isComplete() {
        return isComplete(this.root, 0, this.size());
    }
    private boolean isComplete(No atual, int index, int tamanho) {
        if (atual == null) {
            return true;
        }
        if (index >= tamanho) {
            return false;
        }
        return isComplete(atual.getEsquerda(),
                2 * index + 1, tamanho) &&
                isComplete(atual.getDireita(),
                        2 * index + 2, tamanho);
    }


    @Override
    public Filme_IF[] preOrder() {
        ArrayList<Filme_IF> lista = new ArrayList<>();
        preOrderRecursivo(this.root, lista);
        return lista.toArray(new Filme_IF[0]);
    }
    private void preOrderRecursivo(No atual, ArrayList<Filme_IF> lista) {
        if (atual != null) {
            lista.add(atual.getFilme());
            preOrderRecursivo(atual.getEsquerda(), lista);
            preOrderRecursivo(atual.getDireita(), lista);
        }
    }

    @Override
    public Filme_IF[] order() {
        ArrayList<Filme_IF> lista = new ArrayList<>();
        orderRecursivo(this.root, lista);
        return lista.toArray(new Filme_IF[0]);
    }
    private void orderRecursivo(No atual, ArrayList<Filme_IF> lista) {
        if (atual != null) {
            orderRecursivo(atual.getEsquerda(), lista);
            lista.add(atual.getFilme());
            orderRecursivo(atual.getDireita(), lista);
        }
    }

    @Override
    public Filme_IF[] postOrder() {
        ArrayList<Filme_IF> lista = new ArrayList<>();
        postOrderRecursivo(this.root, lista);
        return lista.toArray(new Filme_IF[0]);
    }
    private void postOrderRecursivo(No atual, ArrayList<Filme_IF> lista) {
        if (atual != null) {
            postOrderRecursivo(atual.getEsquerda(), lista);
            postOrderRecursivo(atual.getDireita(), lista);
            lista.add(atual.getFilme());
        }
    }
}
