package model;

public class ContaCorrente extends Conta{

  private String agencia;
  private double limite;

  public String getAgencia() {
    return agencia;
  }
  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }
  public double getLimite() {
    return limite;
  }
  public void setLimite(double limite) {
    this.limite = limite;
  }
  public ContaCorrente(double saldo, int id, String agencia, double limite) {
    super(saldo, id);
    this.agencia = agencia;
    this.limite = limite;
  }

  @Override
  public void sacar(double valor) {
    if (valor <= getSaldo() + limite) {
      setSaldo(getSaldo() - valor);
    } else {
      System.out.println("Saldo insuficiente.");
    }
  }
  @Override
  public void depositar(double valor) {
    setSaldo(getSaldo() + valor);
  }

  @Override
  public void transferir(Conta contaDestino, double valor) {
    if (valor <= getSaldo() + limite) {
      sacar(valor);
      contaDestino.depositar(valor);
    } else throw new IllegalArgumentException("Saldo insuficiente.");
 
  }
}
