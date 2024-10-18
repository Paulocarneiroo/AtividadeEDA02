import entidades.Fila;
import entidades.Filme;
import interfaces.Fila_IF;
import interfaces.Filme_IF;

public class FilaMain {
    public static void main(String[] args) {
        try {
            Fila_IF fila = new Fila();

            // Inserir filmes na fila
            fila.enqueue(new Filme(1, "Inception", 9, 2010));
            fila.enqueue(new Filme(2, "The Matrix", 10, 1999));
            fila.enqueue(new Filme(3, "Interstellar", 8, 2014));

            // Verificar a cabeça da fila
            System.out.println("Cabeça da fila: " + fila.head());

            // Remover da fila
            Filme_IF removido = fila.dequeue();
            System.out.println("Filme removido: " + removido);

            // Verificar a nova cabeça
            System.out.println("Nova cabeça da fila: " + fila.head());

            // Remover outro filme
            fila.dequeue();
            System.out.println("Nova cabeça após segundo dequeue: " + fila.head());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
