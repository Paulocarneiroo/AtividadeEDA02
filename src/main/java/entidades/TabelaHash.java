package entidades;

import interfaces.Filme_IF;
import interfaces.Lista_IF;
import interfaces.TabelaHash_IF;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TabelaHash implements TabelaHash_IF {
    private Lista_IF[] tabela;
    private int tamanhoTabela;


    public TabelaHash(int tamanhoTabela) {
        this.tamanhoTabela = tamanhoTabela;
        this.tabela = new Lista_IF[tamanhoTabela];
        for (int i = 0; i < tamanhoTabela; i++) {
            tabela[i] = new Lista();
        }
    }

    private int hash(long id) {
        return (int) (id % tamanhoTabela);
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        if (isEmpty())
            throw new Exception("Tabela Vazia, nada a ser removido!");

        int indice = hash(id);
        try{
            return tabela[indice].remove(id);
        }catch (Exception e){
            throw new Exception("Este filme não se encontra");
        }
    }

    @Override
    public void insert(Filme_IF elemento) {
        int indice = hash(elemento.getID());
        tabela[indice].insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < tamanhoTabela; i++) {
            if (!tabela[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (isEmpty())
            throw new Exception("Tabela Vazia, nada a ser procurado!");

        int indice = hash(id);
        try{
            return tabela[indice].search(id);
        }catch (Exception e){
            throw new Exception("Este filme não se encontra");
        }
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanhoTabela; i++) {
            sb.append(i).append(": ");
            Lista_IF lista = tabela[i];
            if (lista.isEmpty()) {
                sb.append("\n");
                continue;
            }
            sb.append(lista.toString()).append("\n");
        }
        return sb.toString();
    }

}
