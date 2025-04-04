package model;

public class ContaPoupanca extends Conta {

    private String agencia;

    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

 
    public ContaPoupanca(double saldo, int id, String agencia) {
        super(saldo, id);
        this.agencia = agencia;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo()) {
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
      if (valor <= getSaldo()) {
        sacar(valor);
        contaDestino.depositar(valor);
      } else throw new IllegalArgumentException("Saldo insuficiente.");
    }
}
