package gerenciadores;

import entidades.Filme;
import entidades.TabelaHash;
import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

import java.util.Scanner;

public class GerenciadorTabelaHash {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n--- Gerenciador de Filmes ---");
            System.out.print("1. Informe qual a Estrutura de Dados você " +
                    "deseja armazenar seus filmes: ");
            System.out.println("1. BST");
            System.out.println("2. Tabela Hash");
            System.out.println("3. Fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op){
                case 1:
                    BST();
                    break;
                case 2:
                    TabelaHash();
                    break;
                case 3:
                    Fila();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while (op != 0);
        sc.close();
    }

    private static void BST(){}
    private static void Fila(){}

    private static void TabelaHash(){
        TabelaHash_IF tabela = new TabelaHash(7);
        int op;
        do {
            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Remover Filme por ID");
            System.out.println("4. Exibir Filmes Ordenados por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    System.out.print("Informe o ID do Filme: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpar buffer
                    System.out.print("Informe o Nome do Filme: ");
                    String nome = sc.nextLine();
                    System.out.print("Informe a Nota do Filme: ");
                    int nota = sc.nextInt();
                    System.out.print("Informe o Ano do Filme: ");
                    int ano = sc.nextInt();

                    tabela.insert(new Filme(id, nome, nota, ano));
                    System.out.println("Filme inserido com sucesso na fila!");
                    break;
                case 2:
                    System.out.print("Informe o ID do Filme a ser buscado: ");
                    long idBusca = sc.nextLong();
                    try {
                        Filme_IF filmeBuscado = tabela.search(idBusca);
                        System.out.println(filmeBuscado);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Informe o ID do Filme a ser removido: ");
                    long idRemocao = sc.nextLong();
                    try {
                        Filme_IF filmeRemovido = tabela.remove(idRemocao);
                        System.out.println("Filme: " + filmeRemovido + " removido com sucesso!");
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(tabela.print());
                    break;
                case 0:
                    System.out.println("Encerrando Gerenciador de Filmes...");
                    break;
                default:
                    System.out.println("Entrada Inválida");
                    break;
            }
        }while (op != 0);
    }
}
