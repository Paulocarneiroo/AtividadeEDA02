import entidades.Filme;
import entidades.TabelaHash;
import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

public class MainTabelaHash {
    public static void main(String[] args) {
        TabelaHash_IF tabelaHash = new TabelaHash(7);


        System.out.println("fkmisdjfsu9df");
        Filme_IF filme1 = new Filme(1, "Filme 1", 1, 2021);
        Filme_IF filme2 = new Filme(2, "Filme 2", 2, 2022);
        Filme_IF filme3 = new Filme(11, "Filme 11", 2, 2022);

        tabelaHash.insert(filme1);
        tabelaHash.insert(filme2);
        tabelaHash.insert(filme3);

        String resultado = tabelaHash.print();
        System.out.println(resultado);
    }
}
