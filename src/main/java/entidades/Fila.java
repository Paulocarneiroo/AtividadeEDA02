package entidades;

import interfaces.Fila_IF;
import interfaces.Filme_IF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    @Override
    public Filme_IF searchById(long id) throws Exception{
        if (isEmpty())
            throw new Exception("A fila está vazia.");

        try{
            return pilha1.lista.search(id);
        }catch (Exception e){
            try{
                return pilha2.lista.search(id);
            }catch (Exception e2){
                throw new Exception("Filme com ID " + id + " não encontrado.");
            }
        }
    }

    @Override
    public void print() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila Vazia!");
        }
        List<Filme_IF> filmes = new ArrayList<>();

        while (!pilha2.isEmpty()) {
            filmes.add(pilha2.pop());
        }

        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop());
        }
        while (!pilha2.isEmpty()) {
            filmes.add(pilha2.pop());
        }

        Collections.sort(filmes, Comparator.comparingLong(Filme_IF::getID));

        for (Filme_IF filme : filmes) {
            System.out.println(filme);
        }

        for (Filme_IF filme : filmes) {
            pilha1.push(filme);
        }
    }

}
