package br.ufpb.dcx.ayla.funcionarios;

public class FuncionarioInexistenteException extends Exception {
    public FuncionarioInexistenteException(String msg) {
        super(msg);
    }
}