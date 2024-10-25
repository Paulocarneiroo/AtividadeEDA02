package entidades;
import interfaces.Filme_IF;
import interfaces.Lista_IF;

public class Lista implements Lista_IF {
    protected Node head;
    protected Node tail;
    private int size;

    public Lista(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista está vazia.");
        }
        Node atual = head;
        while (atual != null){
            if (atual.getFilme().getID() == id){
                // Se for o único elemento na lista
                if (head == tail) {
                    head = null;
                    tail = null;
                }
                // Se for o primeiro elemento
                else if (atual == head) {
                    head = head.getNext();
                    head.setPrev(null);
                }
                // Se for o último elemento
                else if (atual == tail) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                }
                // Elemento no meio
                else {
                    Node anterior = atual.getPrev();
                    Node proximo = atual.getNext();
                    anterior.setNext(proximo);
                    proximo.setPrev(anterior);
                }
                size--;
                return atual.getFilme();
            }
            atual = atual.getNext();
        }
        throw new Exception("Filme com ID " + id + " não encontrado.");
    }

    @Override
    public void insert(Filme_IF elemento) {
        Node novoNode = new Node(elemento);
        if (isEmpty()) {
            head = novoNode;
            tail = novoNode;
        } else {
            tail.setNext(novoNode);
            novoNode.setPrev(tail);
            tail = novoNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista está vazia.");
        }

        Node atual = head;
        while (atual != null) {
            if (atual.getFilme().getID() == id) {
                return atual.getFilme();
            }
            atual = atual.getNext();
        }

        throw new Exception("Filme com ID " + id + " não encontrado.");
    }

    @Override
    public Filme_IF head() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista está vazia.");
        }
        return head.getFilme();
    }

    @Override
    public Filme_IF tail() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista está vazia.");
        }
        return tail.getFilme();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node atual = head;
        while (atual != null) {
            sb.append(atual.getFilme().getID());
            if (atual.getNext() != null) {
                sb.append(", ");
            }
            atual = atual.getPrev();
        }
        return sb.toString();
    }
    public void displayForward() {
        Node atual = head;
        while (atual != null) {
            System.out.println(atual.getFilme());
            atual = atual.getNext();
        }
    }

    public void displayBackward() {
        Node atual = tail;
        while (atual != null) {
            System.out.println(atual.getFilme());
            atual = atual.getPrev();
        }
    }
}
