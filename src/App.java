import model.ContaCorrente;
import model.ContaPoupanca;
import service.ClienteService;
import service.ContaService;
import model.Cliente;
import model.Conta;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Conta c1;
        Conta c2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Criar Cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = ClienteService.criarCliente(nome, cpf, email);

        System.out.println("Qual seu saldo?");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Qual seu ID?");
        int ID = scanner.nextInt();
        
        System.out.println("Deseja uma conta corrente ou poupança? (c/p)");
        String tipoConta = scanner.nextLine().toLowerCase();


        Conta conta = tipoConta.equals("c") ? ContaService.criarContaCorrente(saldo, ID, "1234", 1000) : ContaService.criarContaPoupanca(saldo, ID, "01/01/2023");

        System.out.println("O que deseja fazer, senhor(a) " + cliente.getNome() + "?");
        System.out.println("1. Sacar\n2. Depositar\n3. Transferir\n4. Sair");

        int opcao = scanner.nextInt();

        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.println("Qual valor deseja sacar?");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Saque realizado com sucesso! Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("Qual valor deseja depositar?");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso! Saldo atual: " + conta.getSaldo());
                    break;
                case 3:
                    System.out.println("Qual valor deseja transferir?");
                    double valorTransferencia = scanner.nextDouble();
                    System.out.println("Para qual ID deseja transferir?");
                    int idDestino = scanner.nextInt();
                    // Para simplificar, vamos criar uma nova conta de destino, também pode ser titularizada como uma conta "dummy".
                    Conta contaDestino = new ContaCorrente(0, idDestino, "1234", 1000);
                    conta.transferir(contaDestino, valorTransferencia);
                    System.out.println("Transferência realizada com sucesso! Saldo atual: " + conta.getSaldo());
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println("O que deseja fazer, senhor(a) " + cliente.getNome() + "?");
            System.out.println("1. Sacar\n2. Depositar\n3. Transferir\n4. Sair");
            opcao = scanner.nextInt();

        }
    }
}
