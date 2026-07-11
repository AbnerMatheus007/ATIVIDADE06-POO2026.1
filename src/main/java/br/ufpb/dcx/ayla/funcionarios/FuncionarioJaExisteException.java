package br.ufpb.dcx.ayla.funcionarios;

public class FuncionarioJaExisteException extends Exception {
    public FuncionarioJaExisteException(String msg) {
        super(msg);
    }
}