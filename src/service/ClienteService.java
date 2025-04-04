package service;
import model.Cliente;

public class ClienteService {

  public static Cliente criarCliente(String nome, String cpf, String email) {
    if (nome == null || nome.isEmpty()) {
      throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
    }
    if (cpf == null || cpf.isEmpty()) {
      throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
    }
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email não pode ser nulo ou vazio.");
    }

    return new Cliente(nome, cpf, email);
  }

}
