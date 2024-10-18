import entidades.Filme;
import entidades.TabelaHash;
import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

public class MainTabelaHash {
    public static void main(String[] args) {
        try {
            TabelaHash_IF tabelaHash = new TabelaHash(8);
            // Inserir filmes na tabela hash
            tabelaHash.insert(new Filme(24, "Filme24", 8, 2020));
            tabelaHash.insert(new Filme(16, "Filme16", 7, 2019));
            tabelaHash.insert(new Filme(10, "Filme10", 9, 2021));
            tabelaHash.insert(new Filme(19, "Filme19", 6, 2018));
            tabelaHash.insert(new Filme(11, "Filme11", 7, 2019));
            tabelaHash.insert(new Filme(3, "Filme3", 8, 2020));
            tabelaHash.insert(new Filme(12, "Filme12", 9, 2021));
            tabelaHash.insert(new Filme(4, "Filme4", 5, 2017));
            tabelaHash.insert(new Filme(22, "Filme22", 6, 2018));
            tabelaHash.insert(new Filme(14, "Filme14", 7, 2019));
            tabelaHash.insert(new Filme(6, "Filme6", 8, 2020));
            tabelaHash.insert(new Filme(15, "Filme15", 9, 2021));

            // Imprimir a tabela hash
            System.out.println("Tabela Hash após inserções:");
            System.out.println(tabelaHash.print());

            // Buscar um filme
            Filme_IF filmeBuscado = tabelaHash.search(10);
            System.out.println("Filme buscado com ID 10: " + filmeBuscado);

            // Remover um filme
            Filme_IF filmeRemovido = tabelaHash.remove(19);
            System.out.println("Filme removido com ID 19: " + filmeRemovido);

            // Imprimir a tabela hash após remoção
            System.out.println("Tabela Hash após remoção:");
            System.out.println(tabelaHash.print());

            // Verificar se a tabela está vazia
            System.out.println("A tabela está vazia? " + tabelaHash.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
