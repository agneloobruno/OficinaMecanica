package oficinamecanica.service;

import java.sql.SQLException;
import oficinamecanica.dao.FuncionarioDAO;
import oficinamecanica.model.Funcionario;

import java.util.List;

public class FuncionarioService {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public boolean cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        // Verificar se o funcionário possui os dados obrigatórios, como nome e cargo
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty() || funcionario.getCargo() == null || funcionario.getCargo().isEmpty()) {
            System.out.println("Erro: Nome e cargo do funcionário são obrigatórios.");
            return false;
        }

        funcionarioDAO.adicionarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        return true;
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        return funcionarioDAO.listarFuncionarios();
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioDAO.buscarPorId(id);
    }

    public boolean atualizarFuncionario(Funcionario funcionario) throws SQLException {
        // Verificar se o funcionário existe antes de atualizar
        if (funcionarioDAO.buscarPorId(funcionario.getId()) == null) {
            System.out.println("Erro: Funcionário não encontrado.");
            return false;
        }

        funcionarioDAO.atualizarFuncionario(funcionario);
        System.out.println("Funcionário atualizado com sucesso!");
        return true;
    }

    public boolean excluirFuncionario(int id) throws SQLException {
        // Verificar se o funcionário existe antes de excluir
        if (funcionarioDAO.buscarPorId(id) == null) {
            System.out.println("Erro: Funcionário não encontrado.");
            return false;
        }

        funcionarioDAO.excluirFuncionario(id);
        System.out.println("Funcionário excluído com sucesso!");
        return true;
    }
}
