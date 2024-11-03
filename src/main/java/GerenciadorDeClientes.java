import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorDeClientes {

    // Scanner para entrada de dados e lista de clientes
    private Scanner scanner;
    private ArrayList<Cliente> clientes;
    private int idAtual;

    // Construtor inicializa a lista de clientes e o scanner
    public GerenciadorDeClientes() {
        idAtual = 1;
        clientes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Método para cadastrar um novo cliente
    public void cadastrarCliente() {
        try {
            // Entrada de dados do cliente
            System.out.print("Por favor, insira o nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Por favor, insira o email do cliente: ");
            String email = scanner.nextLine();
            System.out.print("Por favor, insira o telefone do cliente: ");
            String telefone = scanner.nextLine();

            // Criação do objeto Cliente e adição à lista
            Cliente cliente = new Cliente(idAtual, nome, email, telefone);
            adicionarCliente(cliente);

            // Pausa para o usuário visualizar a mensagem
            Thread.sleep(5000);
            limparConsole(); // Limpa o console após o cadastro
        } catch (InterruptedException e) {
            scanner.next(); // Corrige possíveis problemas de entrada
            e.printStackTrace();
        }
    }

    // Método para buscar um cliente pelo ID
    public void buscarCliente() {
        try {
            System.out.print("Digite o ID do cliente que deseja buscar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            // Busca o cliente e exibe o resultado
            Cliente cliente = buscarPorId(id);
            if (cliente == null) {
                System.out.println("Não conseguimos encontrar um cliente com esse ID.");
            } else {
                System.out.println(cliente);
            }
        } catch (InputMismatchException ie) {
            // Trata entradas inválidas
            System.out.println("Entrada inválida! Informe um ID numérico válido.");
            scanner.next(); // Limpa a entrada incorreta
            buscarCliente(); // Recomeça a busca
        }
    }

    // Método para atualizar as informações de um cliente
    public void atualizarCliente() {
        try {
            System.out.print("Por favor, digite o ID do cliente que deseja atualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            // Busca o cliente pelo ID fornecido
            Cliente cliente = buscarPorId(id);
            if (cliente == null) {
                System.out.println("Cliente não encontrado com o ID fornecido.");
                return; // Sai do método se o cliente não for encontrado
            }

            // Permite atualizar cada campo, mantendo os antigos caso a entrada seja vazia
            System.out.println("Caso deseje manter um campo como está, apenas pressione enter...\n");
            System.out.print("Novo nome (atual: " + cliente.getNome() + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo email (atual: " + cliente.getEmail() + "): ");
            String novoEmail = scanner.nextLine();
            System.out.print("Novo telefone (atual: " + cliente.getTelefone() + "): ");
            String novoTelefone = scanner.nextLine();

            // Atualiza os campos apenas se o novo valor não estiver vazio
            if (!novoNome.isEmpty()) cliente.setNome(novoNome);
            if (!novoEmail.isEmpty()) cliente.setEmail(novoEmail);
            if (!novoTelefone.isEmpty()) cliente.setTelefone(novoTelefone);

            System.out.println("As informações do cliente foram atualizadas com sucesso!");
            System.out.println(cliente);

            Thread.sleep(5000);
            limparConsole(); // Limpa o console após atualização
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para remover um cliente pelo ID
    public void removerCliente() {
        try {
            System.out.print("Digite o ID do cliente que você deseja remover: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            // Busca o cliente e, se encontrado, remove da lista
            Cliente cliente = buscarPorId(id);
            if (cliente == null) {
                System.out.println("Não foi possível encontrar um cliente com esse ID.");
                return;
            }

            clientes.remove(cliente);
            System.out.println("O cliente foi removido com sucesso!");

            Thread.sleep(5000);
            limparConsole(); // Limpa o console após remoção
        } catch (InterruptedException e) {
            scanner.next();
            e.printStackTrace();
        }
    }

    // Método para listar todos os clientes cadastrados
    public void listarClientes() {
        System.out.println("\n--- Lista de Clientes Registrados ---");
        if (clientes.isEmpty()) {
            System.out.println("Ainda não há clientes cadastrados."); // Caso a lista esteja vazia
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente); // Exibe cada cliente
            }
        }
    }

    // Método para buscar um cliente pelo ID na lista
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Retorna null caso não encontre o cliente
    }

    // Adiciona um novo cliente ao ArrayList e incrementa o ID para o próximo
    private void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        idAtual++;
        System.out.println("Cliente " + cliente.getNome() + " foi cadastrado com sucesso!");
    }

    // Método para limpar o console de acordo com o sistema operacional
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

    // Método para obter o scanner usado no sistema
    public Scanner obterScanner() {
        return scanner;
    }
}
