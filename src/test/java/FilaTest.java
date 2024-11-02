import entidades.Fila;
import entidades.Filme;
import interfaces.Filme_IF;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {
    private Fila fila = new Fila();

    @Test
    void testInsercao(){
        Filme_IF filme1 = new Filme(10, "Filme 10", 1, 2021);
        Filme_IF filme2 = new Filme(5, "Filme 5", 2, 2022);

        fila.enqueue(filme1);
        fila.enqueue(filme2);

        assertFalse(fila.isEmpty(), "A fila não deve estar vazia após a inserção de elementos.");
    }

    @Test
    void testBuscaPorId() throws Exception {
        Filme_IF filme1 = new Filme(10, "Filme 10", 1, 2021);
        Filme_IF filme2 = new Filme(5, "Filme 5", 2, 2022);
        fila.enqueue(filme1);
        fila.enqueue(filme2);

        Filme_IF resultado = fila.searchById(10);
        assertEquals(filme1, resultado, "A busca deve retornar o filme com ID 1");

        Exception exception = assertThrows(Exception.class, () -> fila.searchById(3));
        assertEquals("Filme com ID 3 não encontrado.", exception.getMessage(), "Deve lançar exceção ao buscar um ID inexistente.");
    }

    @Test
    void testRemocao() throws Exception{
        Filme_IF filme1 = new Filme(1, "Filme 1", 1, 2021);
        Filme_IF filme2 = new Filme(2, "Filme 2", 2, 2022);

        fila.enqueue(filme1);
        fila.enqueue(filme2);

        Filme_IF removido = fila.dequeue();
        assertEquals(filme1, removido, "A remoção deve retornar o primeiro filme enfileirado.");

        removido = fila.dequeue();
        assertEquals(filme2, removido, "A remoção deve retornar o segundo filme enfileirado.");

        assertTrue(fila.isEmpty(), "A fila deve estar vazia após remover todos os elementos.");

        Exception exception = assertThrows(Exception.class, () -> fila.dequeue());
        assertEquals("A fila está vazia.", exception.getMessage(), "Deve lançar exceção ao tentar remover de uma fila vazia.");
    }

    @Test
    void testPrint() throws Exception {
        Filme_IF filme1 = new Filme(1, "1", 1, 1);
        Filme_IF filme2 = new Filme(2, "2", 2, 2);
        Filme_IF filme3 = new Filme(3, "3", 3, 3);

        fila.enqueue(filme2); // ID 2
        fila.enqueue(filme1); // ID 1
        fila.enqueue(filme3); // ID 3

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        fila.print();

        String expectedOutput = "Filme{ID=1, nome='1', nota=1, ano=1}" + "\n" +
                "Filme{ID=2, nome='2', nota=2, ano=2}" + "\n" +
                "Filme{ID=3, nome='3', nota=3, ano=3}" + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
