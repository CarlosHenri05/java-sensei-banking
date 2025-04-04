package model;

public abstract class Conta {

  private double saldo;
  private int id;

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public Conta(double saldo, int id) {
    this.saldo = saldo;
    this.id = id;
  }

  public abstract void sacar(double valor);
  public abstract void depositar(double valor);
  public abstract void transferir(Conta contaDestino, double valor);

}
