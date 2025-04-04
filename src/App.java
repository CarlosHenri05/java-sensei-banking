import model.ContaCorrente;
import model.ContaPoupanca;
import service.ClienteService;
import model.Cliente;
import model.Conta;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ContaPoupanca contaPoupanca = null;
        ContaCorrente contaCorrente = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Criar Cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = ClienteService.criarCliente(nome, cpf, email);
        
        System.out.println("Deseja uma conta corrente ou poupança? (c/p)");
        String tipoConta = scanner.nextLine().toLowerCase();

        if (tipoConta.equals("c")){
            System.out.print("Digite o saldo inicial: ");
            double saldo = scanner.nextDouble();
            System.out.print("Digite o ID da conta: ");
            int id = scanner.nextInt();
            System.out.print("Digite a agência: ");
            String agencia = scanner.next();
            System.out.print("Digite o limite: ");
            double limite = scanner.nextDouble();

            contaCorrente = new ContaCorrente(saldo, id, agencia, limite);

        } else if (tipoConta.equals("p")) {
            System.out.print("Digite o saldo inicial: ");
            double saldo = scanner.nextDouble();
            System.out.print("Digite o ID da conta: ");
            int id = scanner.nextInt();
            System.out.print("Digite a agência: ");
            String agencia = scanner.next();

            contaPoupanca = new ContaPoupanca(saldo, id, agencia);
           
        } else {
            System.out.println("Tipo de conta inválido.");
        }

        System.out.println("O que deseja fazer, senhor(a) " + cliente.getNome() + "?");
        System.out.println("1. Sacar\n2. Depositar\n3. Transferir\n4. Sair");

        int opcao = scanner.nextInt();

        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (contaCorrente != null) {
                        contaCorrente.sacar(valorSaque);
                    } else if (contaPoupanca != null) {
                        contaPoupanca.sacar(valorSaque);
                    }
                    break;
                case 2:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    if (contaCorrente != null) {
                        contaCorrente.depositar(valorDeposito);
                    } else if (contaPoupanca != null) {
                        contaPoupanca.depositar(valorDeposito);
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor a transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    System.out.print("Digite o ID da conta de destino: ");
                    int idDestino = scanner.nextInt();
                    
                    Conta contaDestino = null;
                    
                    if (contaCorrente != null && contaCorrente.getId() == idDestino) {
                        contaDestino = contaCorrente;
                    } else if (contaPoupanca != null && contaPoupanca.getId() == idDestino) {
                        contaDestino = contaPoupanca;
                    }

                    if (contaDestino != null) {
                        if (contaCorrente != null) {
                            contaCorrente.transferir(contaDestino, valorTransferencia);
                        } else if (contaPoupanca != null) {
                            contaPoupanca.transferir(contaDestino, valorTransferencia);
                        }
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("O que deseja fazer, senhor(a) " + cliente.getNome() + "?");
            System.out.println("1. Sacar\n2. Depositar\n3. Transferir\n4. Sair");
            opcao = scanner.nextInt();

        }
    }
}
