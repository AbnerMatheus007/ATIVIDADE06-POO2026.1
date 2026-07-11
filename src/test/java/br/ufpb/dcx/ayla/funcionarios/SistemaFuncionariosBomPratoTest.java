package br.ufpb.dcx.ayla.funcionarios;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFuncionariosBomPratoTest {

    // Questão 4
    @Test
    public void testaCadastroEPesquisa() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try {
            sistema.cadastrarFuncionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000);
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");

            // a) Cadastre mais um funcionário
            sistema.cadastrarFuncionario("222.222.222-22", "João Paulo Silva", TipoFuncionario.COZINHEIRO, 5000);

            // b) Pesquise a lista dos funcionários que ganham mais de R$ 2000
            List<Funcionario> ricos = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000);
            assertEquals(2, ricos.size());

            // c) Pesquise a quantidade de funcionários que são cozinheiros
            int qtdCozinheiros = sistema.contarFuncionariosDoTipo(TipoFuncionario.COZINHEIRO);
            assertEquals(1, qtdCozinheiros);

        } catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }

    // Questão 10
    @Test
    public void testaExcecoesLancadas() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();

        try {
            sistema.cadastrarFuncionario("111.111.111-11", "Carlos", TipoFuncionario.GARCON, 1500);
        } catch (FuncionarioJaExisteException e) {
            fail("Não deveria falhar no primeiro cadastro");
        }

        boolean lancouExcecaoJaExiste = false;
        try {
            sistema.cadastrarFuncionario("111.111.111-11", "Carlos Clone", TipoFuncionario.GARCON, 1500);
        } catch (FuncionarioJaExisteException e) {
            lancouExcecaoJaExiste = true;
        }
        assertTrue(lancouExcecaoJaExiste);

        boolean lancouExcecaoInexistente = false;
        try {
            sistema.pesquisarFuncionario("999.999.999-99");
        } catch (FuncionarioInexistenteException e) {
            lancouExcecaoInexistente = true;
        }
        assertTrue(lancouExcecaoInexistente);
    }
}