package republica.servico;

import republica.modelo.Aluno;

import java.util.List;
import java.util.Optional;

public class AlunoServico {

    public boolean cadastrar(Aluno aluno) {
        return true;
    }

    public boolean removerPorId(int id) {
        return true;
    }

    public Optional<Aluno> buscarPorId(int id) {
        return null;
    }

    public List<Aluno> listar() {
        return null;
    }
}
