package entidades;

import interfaces.Fila_IF;
import interfaces.Filme_IF;

public class Fila implements Fila_IF {
    private Pilha pilha1;
    private Pilha pilha2;

    public Fila() {
        this.pilha1 = new Pilha();
        this.pilha2 = new Pilha();
    }

    @Override
    public Filme_IF dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        if (pilha2.isEmpty()) {
            while (!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop());
            }
        }
        // Remover da segunda pilha equivale a remover da frente da fila
        return pilha2.pop();
    }

    @Override
    public void enqueue(Filme_IF elemento) {
        pilha1.push(elemento);
    }

    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty() && pilha2.isEmpty();
    }

    @Override
    public Filme_IF head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        if (pilha2.isEmpty()) {
            while (!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop());
            }
        }
        return pilha2.top();
    }
}
