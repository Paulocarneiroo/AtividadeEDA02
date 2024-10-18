package entidades;

import interfaces.Filme_IF;

public class Filme implements Filme_IF {
    private long ID;
    private String nome;
    private int nota;
    private int ano;

    public Filme(){}

    public Filme(long ID, String nome, int nota, int ano) {
        this.ID = ID;
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF outro_filme) {
        // Primeiro critério: Nota (decrescente) return x < y ? -1 : (x == y ? 0 : 1);
        int notaComparacao = Integer.compare(outro_filme.getNota(), this.nota);
        if (notaComparacao != 0) {
            return notaComparacao;
        }
        // Segundo critério: Ano (crescente)
        int anoComparacao = Integer.compare(this.ano, outro_filme.getAno());
        if (anoComparacao != 0) {
            return anoComparacao;
        }
        // Terceiro critério: Nome (crescente)
        return this.nome.compareTo(outro_filme.getNome());
    }

    @Override
    public String toString() {
        return "Filme{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }
}
