import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void iniciarSistema(GerenciadorDeClientes gerenciadorDeClientes, Scanner scanner) {
        boolean executando = true;
        while (executando) {
            exibirMenu();

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1:
                        gerenciadorDeClientes.cadastrarCliente();
                        break;
                    case 2:
                        gerenciadorDeClientes.listarClientes();
                        break;
                    case 3:
                        gerenciadorDeClientes.atualizarCliente();
                        break;
                    case 4:
                        gerenciadorDeClientes.removerCliente();
                        break;
                    case 5:
                        gerenciadorDeClientes.buscarCliente();
                        break;
                    case 6:
                        System.out.println("O sistema será encerrado, espero de ver em breve.");
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção não reconhecida. Selecione uma opção válida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada incorreta! Insira um número entre 1 e 6.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Adicionar um novo Cliente");
        System.out.println("2. Exibir lista de Clientes");
        System.out.println("3. Editar informações de um Cliente");
        System.out.println("4. Excluir um Cliente");
        System.out.println("5. Procurar Cliente");
        System.out.println("6. Encerrar o programa");
        System.out.print("Por favor, selecione uma das opções: ");
    }

    public static void main(String[] args) {
        GerenciadorDeClientes gerenciadorDeClientes = new GerenciadorDeClientes();
        Scanner scanner = gerenciadorDeClientes.obterScanner();
        iniciarSistema(gerenciadorDeClientes, scanner);
    }
}
