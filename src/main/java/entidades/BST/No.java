package entidades.BST;

import interfaces.Filme_IF;

public class No {
    Filme_IF filme;
    No left;
    No right;

    public No(){}

    public No(Filme_IF filme) {
        this.filme = filme;
        this.left = null;
        this.right = null;
    }

    public Filme_IF getFilme() {
        return filme;
    }

    public void setFilme(Filme_IF filme) {
        this.filme = filme;
    }

    public No getEsquerda() {
        return left;
    }

    public void setEsquerda(No left) {
        this.left = left;
    }

    public No getDireita() {
        return right;
    }

    public void setDireita(No right) {
        this.right = right;
    }
}
