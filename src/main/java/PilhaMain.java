import entidades.Filme;
import entidades.Pilha;
import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class PilhaMain {
    public static void main(String[] args) {
        try {
            Pilha_IF pilha = new Pilha();

            // Inserir filmes na pilha
            pilha.push(new Filme(1, "Inception", 9, 2010));
            pilha.push(new Filme(2, "The Matrix", 10, 1999));
            pilha.push(new Filme(3, "Interstellar", 8, 2014));

            // Verificar o topo da pilha
            System.out.println("Topo da pilha: " + pilha.top());

            // Remover o topo da pilha
            Filme_IF removido = pilha.pop();
            System.out.println("Filme removido: " + removido);

            // Verificar o novo topo
            System.out.println("Novo topo da pilha: " + pilha.top());

            // Remover outro filme
            pilha.pop();
            System.out.println("Novo topo após segundo pop: " + pilha.top());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
