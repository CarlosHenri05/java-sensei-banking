package service;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class ContaService {

  public Conta criarContaCorrente(double saldo, int id, String agencia, double limite) {
    Conta contaCorrente = new ContaCorrente(saldo, id, agencia, limite);
    // Accessing superclass attributes using getters (assuming they exist in Conta)
    System.out.println("Saldo: " + contaCorrente.getSaldo());
    System.out.println("ID: " + contaCorrente.getId());
    System.out.println("Agência: " + contaCorrente.getAgencia());
    return contaCorrente;
  }
  
  public Conta criarContaPoupanca(double saldo, int id, String agencia) {
    Conta contaPoupanca = new ContaPoupanca(saldo, id, agencia);
    // Accessing superclass attributes using getters (assuming they exist in Conta)
    System.out.println("Saldo: " + contaPoupanca.getSaldo());
    System.out.println("ID: " + contaPoupanca.getId());
    System.out.println("Agência: " + contaPoupanca.getAgencia());
    return contaPoupanca;
  }

}
