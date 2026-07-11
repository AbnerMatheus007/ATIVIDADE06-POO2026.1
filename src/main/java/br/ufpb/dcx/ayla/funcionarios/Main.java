package br.ufpb.dcx.ayla.funcionarios;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando o sistema do Bom Prato...");

        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();

        try {
            // Cadastrando um funcionário para testar
            sistema.cadastrarFuncionario("111.111.111-11", "Abner Silva", TipoFuncionario.GERENTE, 4500.0);

            // Verificando se ele existe
            if (sistema.funcionarioJaExiste("111.111.111-11")) {
                System.out.println("Funcionário cadastrado com sucesso!");
                Funcionario f = sistema.pesquisarFuncionario("111.111.111-11");
                System.out.println("Nome do funcionário: " + f.getNome());
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}