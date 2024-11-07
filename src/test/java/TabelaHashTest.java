import entidades.Filme;
import entidades.TabelaHash;
import interfaces.Filme_IF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TabelaHashTest {
    private TabelaHash tabela;
    private Filme_IF filme1, filme2, filme3;

    @BeforeEach
    void setUp() {
        tabela = new TabelaHash(10);
        filme1 = new Filme(1, "Filme A", 8, 2020);
        filme2 = new Filme(2, "Filme B", 9, 2021);
        filme3 = new Filme(3, "Filme C", 7, 2019);
    }

    @Test
    void testInsertAndSearch() throws Exception {
        tabela.insert(filme1);
        tabela.insert(filme2);

        assertEquals(filme1, tabela.search(1));
        assertEquals(filme2, tabela.search(2));
        
        Exception exception = assertThrows(Exception.class, () -> {
            tabela.search(3);
        });
        assertEquals("Este filme não se encontra", exception.getMessage());
    }

    @Test
    void testRemove() throws Exception {
        tabela.insert(filme1);
        tabela.insert(filme2);

        assertEquals(filme1, tabela.remove(1));

        Exception exception = assertThrows(Exception.class, () -> {
            tabela.search(1);
        });
        assertEquals("Este filme não se encontra", exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            tabela.remove(3);
        });
        assertEquals("Este filme não se encontra", exception.getMessage());
    }
}
