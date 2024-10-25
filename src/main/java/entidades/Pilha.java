package entidades;

import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class Pilha implements Pilha_IF {
    protected Lista lista;

    public Pilha(){
        lista = new Lista();
    }

    @Override
    public Filme_IF pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        Filme_IF topo = lista.tail();
        lista.remove(topo.getID());
        return topo;
    }

    @Override
    public void push(Filme_IF elemento) {
        lista.insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public Filme_IF top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        return lista.tail();
    }

}
