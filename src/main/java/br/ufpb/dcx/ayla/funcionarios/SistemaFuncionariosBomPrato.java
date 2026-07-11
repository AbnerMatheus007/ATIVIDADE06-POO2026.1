package br.ufpb.dcx.ayla.funcionarios;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {
    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<String, Funcionario>();
    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipo, double salario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(cpf)) {
            throw new FuncionarioJaExisteException("Já existe funcionário com o cpf " + cpf);
        } else {
            this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipo, salario));
        }
    }

    // Questão 6
    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        if (this.funcionarios.containsKey(funcionario.getCpf())) {
            throw new FuncionarioJaExisteException("Já existe funcionário com o cpf " + funcionario.getCpf());
        } else {
            this.funcionarios.put(funcionario.getCpf(), funcionario);
        }
    }

    // Questão 3
    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException {
        if (this.funcionarios.containsKey(cpfFuncionario)) {
            Funcionario f = this.funcionarios.get(cpfFuncionario);
            f.setSalario(novoSalario);
        } else {
            throw new FuncionarioInexistenteException("Funcionário com CPF " + cpfFuncionario + " não encontrado.");
        }
    }

    // Questão 2
    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int cont = 0;
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getTipo().equals(tipo)) {
                cont++;
            }
        }
        return cont;
    }

    // Questão 7
    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }

    // Questão 8
    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> lista = new ArrayList<>();
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getTipo().equals(tipo)) {
                lista.add(f);
            }
        }
        return lista;
    }

    // Questão 9
    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException {
        if (this.funcionarios.containsKey(cpfFuncionario)) {
            return this.funcionarios.get(cpfFuncionario);
        } else {
            throw new FuncionarioInexistenteException("Funcionário com CPF " + cpfFuncionario + " não encontrado.");
        }
    }

    // Questão 1
    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> lista = new ArrayList<>();
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getSalario() > valor) {
                lista.add(f);
            }
        }
        return lista;
    }
}