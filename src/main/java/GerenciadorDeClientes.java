import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorDeClientes {

    private Scanner scanner;
    private ArrayList<Cliente> clientes;
    private int idAtual;

    public GerenciadorDeClientes() {
        idAtual = 1;
        clientes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void cadastrarCliente() {
        try {
            System.out.print("Por favor, insira o nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Por favor, insira o email do cliente: ");
            String email = scanner.nextLine();
            System.out.print("Por favor, insira o telefone do cliente: ");
            String telefone = scanner.nextLine();

            Cliente cliente = new Cliente(idAtual, nome, email, telefone);
            adicionarCliente(cliente);

            Thread.sleep(2000);
            limparConsole();
        } catch (InterruptedException e) {
            scanner.next();
            e.printStackTrace();
        }
    }

    public void buscarCliente() {
        try {
            System.out.print("Digite o ID do cliente que deseja buscar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = buscarPorId(id);
            if (cliente == null) {
                System.out.println("Não conseguimos encontrar um cliente com esse ID.");
            } else {
                System.out.println(cliente);
            }
        } catch (InputMismatchException ie) {
            System.out.println("Entrada inválida! Informe um ID numérico válido.");
            scanner.next();
            buscarCliente();
        }
    }

    public void atualizarCliente() {
        try {
            System.out.print("Por favor, digite o ID do cliente que deseja atualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = buscarPorId(id);
            if (cliente == null) {
                System.out.println("Cliente não encontrado com o ID fornecido.");
                return;
            }

            System.out.println("Caso deseje manter um campo como está, apenas pressione enter...\n");
            System.out.print("Novo nome (atual: " + cliente.getNome() + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo email (atual: " + cliente.getEmail() + "): ");
            String novoEmail = scanner.nextLine();
            System.out.print("Novo telefone (atual: " + cliente.getTelefone() + "): ");
            String novoTelefone = scanner.nextLine();

            if (!novoNome.isEmpty()) cliente.setNome(novoNome);
            if (!novoEmail.isEmpty()) cliente.setEmail(novoEmail);
            if (!novoTelefone.isEmpty()) cliente.setTelefone(novoTelefone);

            System.out.println("As informações do cliente foram atualizadas com sucesso!");
            System.out.println(cliente);

            Thread.sleep(2000);
            limparConsole();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removerCliente() {
        try {
            System.out.print("Digite o ID do cliente que você deseja remover: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = buscarPorId(id);
            if (cliente == null) {
                System.out.println("Não foi possível encontrar um cliente com esse ID.");
                return;
            }

            clientes.remove(cliente);
            System.out.println("O cliente foi removido com sucesso!");

            Thread.sleep(2000);
            limparConsole();
        } catch (InterruptedException e) {
            scanner.next();
            e.printStackTrace();
        }
    }

    public void listarClientes() {
        System.out.println("\n--- Lista de Clientes Registrados ---");
        if (clientes.isEmpty()) {
            System.out.println("Ainda não há clientes cadastrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        idAtual++;
        System.out.println("Cliente " + cliente.getNome() + " foi cadastrado com sucesso!");
    }

    private void limparConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                if (System.getenv("TERM") != null) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                } else {
                    System.out.println("\033[H\033[2J");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scanner obterScanner() {
        return scanner;
    }

}
