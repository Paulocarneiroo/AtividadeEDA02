import entidades.Filme;
import entidades.Lista;
import interfaces.Filme_IF;
import java.util.Locale;
import java.util.Scanner;

public class ListaMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();

        int op;
        do {
            showMenu();
            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Digite um filme");
                    Filme_IF filme = new Filme();
                    System.out.print("ID: ");
                    long id = sc.nextLong();
                    filme.setID(id);
                    System.out.print("Nome: ");
                    sc.next();
                    String nome = sc.nextLine();
                    filme.setNome(nome);
                    System.out.print("Nota: ");
                    int nota = sc.nextInt();
                    filme.setNota(nota);
                    System.out.println("Ano: ");
                    int ano = sc.nextInt();
                    filme.setAno(ano);
                    lista.insert(filme);
                    break;
                case 2:
                    System.out.println(lista);
                    break;
                case 3:
                    System.out.println("Fim do Programa!");
                    break;
                default:
                    System.out.println("Entrada Inválida");
            }
        }while (op != 3);
        sc.close();
    }
    private static void showMenu(){
        System.out.println("1 - Inserir elemento na Lista");
        System.out.println("2 - Mostrar Lista");
        System.out.println("3 - Sair");
    }
}
