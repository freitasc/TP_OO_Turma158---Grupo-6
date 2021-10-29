package republica.servico;

import republica.modelo.Categoria;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

public class CategoriaServico extends Categoria {

    public boolean cadastrar(Categoria categoria) {
    	
    	categoria.descricao = JOptionPane.showInputDialog("Digite a descrição da categoria:");
    	
    	System.out.println(categoria.descricao);
    	
    	categoria.subcategoria = JOptionPane.showInputDialog("Digite a subcategoria:");
    	
    	System.out.println(categoria.subcategoria);
    	
    	String strId = JOptionPane.showInputDialog("Digite o id da categoria: ");
    	
    	categoria.id = Integer.parseInt(strId);
    	
    	System.out.println(categoria.id);
    	
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
