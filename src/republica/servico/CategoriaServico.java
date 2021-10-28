package republica.servico;

import republica.modelo.Categoria;

import java.util.List;
import java.util.Optional;

public class CategoriaServico extends Categoria {

    public boolean cadastrar(Categoria categoria) {
        return true;
    }

    public boolean removerPorId(int id) {
        return true;
    }

    public Optional<Categoria> buscarPorId(int id) {
        return null;
    }

    public List<Categoria> listar() {
        return null;
    }
}
