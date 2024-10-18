package entidades;

import interfaces.Filme_IF;

public class Node {
    private Filme_IF filme;
    private Node prev;
    private Node next;

    public Node(){}

    public Node(Filme_IF filme) {
        this.filme = filme;
        prev = null;
        next = null;
    }

    public Filme_IF getFilme() {
        return filme;
    }

    public void setFilme(Filme_IF filme) {
        this.filme = filme;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
