package gerenciadores;

import entidades.BST.BST;
import entidades.Fila;
import entidades.Filme;
import entidades.TabelaHash;
import interfaces.Fila_IF;
import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

import java.util.Scanner;

public class Gerenciador {

    private static final Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        int op;
        do {
            System.out.println(ANSI_YELLOW + "\n--- GERENCIADOR DE FILMES ---" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Informe qual a estrutura de dados você deseja armazenar seus filmes" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1. BST" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "2. Tabela Hash" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "3. Fila" + ANSI_RESET);
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println();
                    BST();
                    break;
                case 2:
                    System.out.println();
                    TabelaHash();
                    break;
                case 3:
                    System.out.println();
                    Fila();
                    break;
                case 0:
                    System.out.println("Encerrando Gerenciador de Filmes...");
                    break;
                default:
                    System.err.println("Opção Inválida");
                    System.out.println();
                    break;
            }
        }while (op != 0);
        sc.close();
    }

    private static void BST(){
        BST bst = new BST();
        int op;
        do {
            System.out.println(ANSI_BLUE + "ÁRVORE DE BUSCA BINÁRIA" + ANSI_RESET);
            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Remover Filme por ID");
            System.out.println("4. Exibir Filmes Ordenados por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Entrada Inválida");
                    System.out.println();
                    break;
            }
        } while (op != 0);
    }

    private static void Fila() {
        Fila_IF fila = new Fila();
        int op;
        do {
            System.out.println(ANSI_PURPLE + "FILA" + ANSI_RESET);
            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Remover Filme por ID");
            System.out.println("4. Exibir Filmes Ordenados por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Entrada Inválida");
                    System.out.println();
                    break;
            }
        } while (op != 0);
    }

    private static void TabelaHash(){
        TabelaHash_IF tabela = new TabelaHash(7);
        int op;
        do {
            System.out.println(ANSI_GREEN + "TABELA HASH" + ANSI_RESET);
            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Remover Filme por ID");
            System.out.println("4. Exibir Filmes Ordenados por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            switch (op){
                case 0:
                    break;
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
                    System.out.println();
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
                        System.out.println();
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(tabela.print());
                    break;
                default:
                    System.err.println("Entrada Inválida");
                    System.out.println();
                    break;
            }
        }while (op != 0);
    }
}
