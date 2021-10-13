package republica.servico;

import republica.modelo.Despesa;

import java.util.List;
import java.util.Optional;

public class DespesaServico {

    public boolean cadastrar(Despesa despesa) {
        return true;
    }

    public boolean removerPorId(int id) {
        return true;
    }

    public Optional<Despesa> buscarPorId(int id) {
        return null;
    }

    public List<Despesa> listar() {
        return null;
    }
}
