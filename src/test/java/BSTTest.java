import entidades.BST.BST;
import entidades.Filme;
import interfaces.Filme_IF;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    private BST bst = new BST();

    @Test
    void testInsercao() {
        Filme_IF filme1 = new Filme(1, "Filme 1", 1, 2021);
        Filme_IF filme2 = new Filme(2, "Filme 2", 2, 2022);
        Filme_IF filme3 = new Filme(3, "Filme 3", 3, 2023);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertEquals(3, bst.size(), "A árvore deve ter 3 elementos após a inserção");
    }

    @Test
    void testBusca() throws Exception {
        Filme_IF filme1 = new Filme(1, "Filme 1", 1, 2021);
        Filme_IF filme2 = new Filme(2, "Filme 2", 2, 2022);
        bst.insert(filme1);
        bst.insert(filme2);

        Filme_IF resultado = bst.search(1);
        assertEquals(filme1, resultado, "A busca deve retornar o filme com ID 1");

        Exception exception = assertThrows(Exception.class, () -> bst.search(20));
        assertEquals("Filme não encontrado", exception.getMessage(), "Deve lançar exceção ao buscar ID inexistente");
    }

    @Test
    void testRemocao() throws Exception {
        Filme_IF filme1 = new Filme(10, "Filme 10", 1, 2021);
        Filme_IF filme2 = new Filme(5, "Filme 5", 2, 2022);
        Filme_IF filme3 = new Filme(15, "Filme 15", 3, 2023);

        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        Filme_IF removido = bst.remove(5);
        assertEquals(filme2, removido, "A remoção deve retornar o filme com ID 5");
        assertEquals(2, bst.size(), "A árvore deve ter 2 elementos após a remoção");

        Exception exception = assertThrows(Exception.class, () -> bst.remove(20));
        assertEquals("Filme não encontrado", exception.getMessage(), "Deve lançar exceção ao tentar remover ID inexistente");
    }

    @Test
    void testOrdem() {
        Filme_IF filme1 = new Filme(10, "Filme 10", 1, 2021);
        Filme_IF filme2 = new Filme(5, "Filme 5", 2, 2022);
        Filme_IF filme3 = new Filme(15, "Filme 15", 3, 2023);
        Filme_IF filme4 = new Filme(20, "Filme 20", 4, 2024);
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);
        bst.insert(filme4);

        Filme_IF[] emOrdem = bst.order();
        assertEquals(filme2, emOrdem[0], "Primeiro filme na ordem deve ter o ID (5)");
        assertEquals(filme1, emOrdem[1], "Segundo filme na ordem deve ter o ID (10)");
        assertEquals(filme3, emOrdem[2], "Terceiro filme na ordem deve ter o ID (15)");
        assertEquals(filme4, emOrdem[3], "Quarto filme na ordem deve ter o ID (20)");
    }
}
