import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");
            switch (opcao) {
                case 1:
                    executarExercicio01();
                    break;
                case 2:
                    executarExercicio02();
                    break;
                case 3:
                    executarExercicio03(scanner);
                    break;
                case 4:
                    executarExercicio04(scanner);
                    break;
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Fila ===");
        System.out.println("1 - Fila com valores fixos");
        System.out.println("2 - Fila de nomes");
        System.out.println("3 - Remover 10 numeros da fila");
        System.out.println("4 - Fila de atendimento");
        System.out.println("5 - Fila de impressao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }
            System.out.println("Inválido! Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

    // ex1
    private static void executarExercicio01() {
        Queue<Integer> fila = criarFilaValoresFixos();
        System.out.println("Fila completa: " + fila);
        fila.poll();
        System.out.println("Fila depois de remover o primeiro elemento: " + fila);
    }

    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50);
        return fila;
    }

    // ex2
    private static void executarExercicio02() {
        Queue<String> fila = criarFilaNomes();
        System.out.println("Primeiro elemento da fila: " + fila.peek());
        System.out.println("Quantidade de elementos: " + fila.size());
    }

    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Pedro");
        fila.add("Juliana");
        return fila;
    }

    // ex3
   
    private static void executarExercicio03(Scanner scanner) {
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            int valor = lerInteiro(scanner, "Numero " + i + ": ");
            fila.add(valor);
        }
        System.out.println("Removendo elementos em comportamento FIFO:");
        List<Integer> removidos = removerTodosElementos(fila);
        for (Integer elemento : removidos) {
            System.out.println("Removido: " + elemento);
        }
    }

    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> removidos = new ArrayList<>();
        while (!fila.isEmpty()) {
            removidos.add(fila.poll());
        }
        return removidos;
    }

    // ex4!!
    private static void executarExercicio04(Scanner scanner) {
    Queue<String> fila = new LinkedList<>();
    int opcao;
    do {
        System.out.println("\n=== Fila de Atendimento ===");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Atender primeiro cliente da fila");
        System.out.println("3 - Mostrar proximo cliente");
        System.out.println("4 - Exibir fila completa");
        System.out.println("0 - Voltar");
        opcao = lerInteiro(scanner, "Opcao: ");
        switch (opcao) {
            case 1:
                System.out.print("Nome do cliente: ");
                String nome = scanner.nextLine().trim();
                while (nome.isEmpty()) {
                    System.out.print("Nome invalido. Digite novamente: ");
                    nome = scanner.nextLine().trim();
                }
                fila.add(nome);
                break;
            case 2:
                System.out.println("Atender: " + fila.poll());
                break;
            case 3:
                System.out.println("Proximo cliente: " + fila.peek());
                break;
            case 4:
                System.out.println("Fila completa: " + fila);
                break;
            case 0:
                break;
            default:
                System.out.println("Opcao invalida.");
        }
            } while (opcao != 0);
        }

        public static List<String> atenderClientes(Queue<String> fila) {
            List<String> atendidos = new ArrayList<>();
            while (!fila.isEmpty()) {
                atendidos.add(fila.poll());
            }
            return atendidos;
        }

    // ex5
  
    private static void executarExercicio05(Scanner scanner) {
        Queue<String> fila = new LinkedList<>();
        int opcao;
        do {
            System.out.println("--- Fila de Impressao ---");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Imprimir proximo documento");
            System.out.println("3 - Mostrar proximo documento");
            System.out.println("4 - Exibir documentos pendentes");
            System.out.println("0 - Voltar");
            opcao = lerInteiro(scanner, "Escolha: ");
            switch (opcao) {
                case 1:
                    System.out.print("Nome do documento: ");
                    String doc = scanner.nextLine().trim();
                    while (doc.isEmpty()) {
                        System.out.print("Nome invalido. Digite novamente: ");
                        doc = scanner.nextLine().trim();
                    }
                    adicionarDocumento(fila, doc);
                    break;
                case 2:
                    String impresso = imprimirDocumento(fila);
                    System.out.println(impresso);
                    break;
                case 3:
                    String proximo = proximoDocumento(fila);
                    System.out.println(proximo);
                    break;
                case 4:
                    System.out.println(fila);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    public static void adicionarDocumento(Queue<String> fila, String documento) {
        fila.add(documento);
    }

    public static String imprimirDocumento(Queue<String> fila) {
        return fila.poll();
    }

    public static String proximoDocumento(Queue<String> fila) {
        return fila.peek();
    }
}