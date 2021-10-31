package republica.controlador;

import java.io.IOException;
import java.util.Optional;

import javax.swing.JOptionPane;

import republica.modelo.Categoria;
import republica.servico.CategoriaServico;
import republica.modelo.Aluno;
import republica.servico.AlunoServico;
import republica.modelo.Despesa;
import republica.servico.DespesaServico;

public class Republica {

    public static void main(String[] args) throws IOException {

        String strOpcao;

        strOpcao = JOptionPane.showInputDialog("Bem vindo ao app de divisao de despesas mensais!"
                + "\n	Escolha uma opcao:"
                + "\n	1 - Pessoas"
                + "\n	2 - Despesas"
                + "\n	3 - Categorias");
        int opcao = Integer.parseInt(strOpcao);
        System.out.println(opcao);
        switch(opcao) {
            case 1: /*Case com cada um dos servicos de Alunos*/
                String strOpcaoAln;
                strOpcaoAln = JOptionPane.showInputDialog("|PESSOAS|"
                        + "\n	O que deseja fazer:"
                        + "\n	1 - Cadastrar pessoa"
                        + "\n	2 - Listar pessoa"
                        + "\n	3 - Buscar pessoa por id"
                        + "\n	4 - Remover pessoa");
                int opcaoAln = Integer.parseInt(strOpcaoAln);

                switch(opcaoAln) {
                    case 1:	/*TODO: CADASTRA*/
                        break;
                    case 2: /*TODO: LISTA*/
                        break;
                    case 3: /*TODO: BUSCA*/
                        break;
                    case 4: /*TODO: REMOVE*/
                        break;
                }
                break;

            case 2: /*Case com cada um dos servicos de Despesas*/
                String strOpcaoDes;
                strOpcaoDes = JOptionPane.showInputDialog("|DESPESAS|"
                        + "\n	O que deseja fazer:"
                        + "\n	1 - Cadastrar despesa"
                        + "\n	2 - Listar despesa"
                        + "\n	3 - Buscar despesa por id"
                        + "\n	4 - Remover despesa");
                int opcaoDes = Integer.parseInt(strOpcaoDes);
                switch(opcaoDes) {
                    case 1:	/*TODO: CADASTRA*/
                        break;
                    case 2: /*TODO: LISTA*/
                        break;
                    case 3: /*TODO: BUSCA*/
                        break;
                    case 4: /*TODO: REMOVE*/
                        break;
                }
                break;

            case 3: /*Case com cada um dos servicos de Categorias*/
                CategoriaServico categoriaServico = new CategoriaServico();
                String strOpcaoCat;
                strOpcaoCat = JOptionPane.showInputDialog("|CATEGORIAS|"
                        + "\n	O que deseja fazer:"
                        + "\n	1 - Cadastrar categoria"
                        + "\n	2 - Listar categorias"
                        + "\n	3 - Buscar categoria por id"
                        + "\n	4 - Remover categoria");
                int opcaoCat = Integer.parseInt(strOpcaoCat);
                switch(opcaoCat) {
                    case 1:
                        String descricao = JOptionPane.showInputDialog("Informe a descricao categoria");
                        String subcategoria = JOptionPane.showInputDialog("Informe a subcategoria");
                        if (categoriaServico.cadastrar(new Categoria(descricao, subcategoria))) {
                            JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao cadastrar categoria");
                        }
                        break;
                    case 2:
                        StringBuilder listaResultado = new StringBuilder();
                        categoriaServico.listar().forEach(categoria -> {
                            listaResultado.append("id: ").append(categoria.getId()).append(", ")
                                    .append("descricao: ").append(categoria.getDescricao()).append(", ")
                                    .append("subcategoria: ").append(categoria.getSubcategoria()).append("\n");
                        });
                        JOptionPane.showMessageDialog(null, listaResultado);
                        break;
                    case 3:
                        int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da categoria"));
                        Optional<Categoria> categoria = categoriaServico.buscarPorId(idBusca);
                        StringBuilder buscaResultado = new StringBuilder();
                        if (categoria.isPresent()) {
                            buscaResultado.append("id: ").append(categoria.get().getId()).append(", ")
                                    .append("descricao: ").append(categoria.get().getDescricao()).append(", ")
                                    .append("subcategoria: ").append(categoria.get().getSubcategoria()).append("\n");
                        } else {
                            buscaResultado.append("Categoria nao encontrada");
                        }
                        JOptionPane.showMessageDialog(null, buscaResultado);
                        break;
                    case 4:
                        int idRemove = Integer.parseInt(JOptionPane.showInputDialog("Informe o id da categoria"));
                        StringBuilder removeResultado = new StringBuilder();
                        if (categoriaServico.removerPorId(idRemove)) {
                            removeResultado.append("Categoria ").append(idRemove).append(" removida com sucesso");
                        } else {
                            removeResultado.append("Categoria nao encontrada");
                        }
                        JOptionPane.showMessageDialog(null, removeResultado);
                        break;
                }
                break;

            /*TODO: OPCAO PARA O USUARIO PRINTAR REGRA IGUALITARIA -> calcularPagamentoRegraIgualitaria()*/
            /*TODO: OPCAO PARA O USUARIO PRINTAR PRINT DE REGRA PROPORCIONAL -> calcularPagamentoRegraProporcional()*/

        }
    }
}
