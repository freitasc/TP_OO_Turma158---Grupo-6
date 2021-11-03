package republica.controlador;
import java.io.IOException;
import republica.servico.DespesaServico;
import java.util.Optional;
import java.util.ArrayList;
import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;
import republica.modelo.Despesa;

public class Republica {

    public static void main(String[] args) throws IOException {
        String strOpcao;
        int opcao ;

        do {
        	strOpcao = JOptionPane.showInputDialog("Bem vindo ao app de divisao de despesas mensais!"
	                + "\n	Escolha uma opcao:"
	                + "\n	1 - Pessoas"
	                + "\n	2 - Despesas"
	                + "\n	3 - Categorias"
	                + "\n	4 - Sair");
	        opcao = Integer.parseInt(strOpcao);
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
                  case 1:	/*CADASTRA ALUNO EM aluno.txt*/
                    Aluno p = new Aluno();

                    String strID = JOptionPane.showInputDialog(null, "Id da pessoa: ");
                          int id = Integer.parseInt(strID);
                          p.setId (id);

                    String Nome = JOptionPane.showInputDialog(null, "Nome da pessoa: ");
                          p.setNome (Nome);

                    String Email = JOptionPane.showInputDialog(null, "Email da pessoa: ");;
                          p.setEmail (Email);

                    String strRenda = JOptionPane.showInputDialog(null, "Renda da pessoa: ");
                          float Renda = Float.parseFloat(strRenda);
                          p.setRenda(Renda);

                    AlunoServico Pessoa = new AlunoServico();
                    Pessoa.cadastrar(p);
                    break;
                  case 2: /*LISTA ALUNOS EM aluno.txt*/
                    AlunoServico lista = new AlunoServico();
                    String todos = "";
                    for (Aluno a : lista.listar()){
                      todos = (todos + a.getId() + " | " 
                          + a.getNome() + " | "
                          + a.getEmail() + " | " 
                          + a.getRenda() + " |\n");
                    }
                    JOptionPane.showMessageDialog(null, todos);						
                    break;
                  case 3: /*BUSCA POR ID ALUNO EM aluno.txt*/
                    String strIdent = JOptionPane.showInputDialog(null, "Insira o ID da pessoa");
                    int indent = Integer.parseInt(strIdent);
                    AlunoServico busca = new AlunoServico();
                    Aluno pesquisa = busca.buscarPorId(indent).orElse(null);
                    if (pesquisa.getNome() != null){
                      String achado = (pesquisa.getId() + " | " 
                              + pesquisa.getNome() + " | "
                              + pesquisa.getEmail() + " | " 
                              + pesquisa.getRenda() + " |\n");
                      JOptionPane.showMessageDialog(null, achado);
                    }
                    else{
                      JOptionPane.showMessageDialog(null, "Não foi possível encontrar o ID!");
                    }
                    break;
                  case 4: /*REMOVE POR ID ALUNO EM aluno.txt*/
                    String strId = JOptionPane.showInputDialog("Insira o ID da pessoa que será removida");
                    int Id = Integer.parseInt(strId);

                    AlunoServico remove = new AlunoServico();
                    if (remove.removerPorId(Id) == true){
                      JOptionPane.showMessageDialog(null, "Ação concluída com sucesso!");
                    }
                    else{
                      JOptionPane.showMessageDialog(null, "Ação falhou!");
                    }
                    break;
                }
                break;
	
	            case 2:
                String opDep;
                opDep = JOptionPane.showInputDialog("---DESPESAS---"
                        + "\n	O que deseja fazer:"
                        + "\n	1-Cadastrar despesa"
                        + "\n	2-Listar despesa"
                        + "\n	3-Buscar despesa por id"
                        + "\n	4-Remover despesa");
                int opCadDep = Integer.parseInt(opDep);

                switch (opCadDep) {
                    case 1:
                        Despesa d = new Despesa();

                        String strID = JOptionPane.showInputDialog(null, "Id da Despesa: ");
                        int id = Integer.parseInt(strID);
                        d.setId(id);

                        String Descricao = JOptionPane.showInputDialog(null, "Digite a descrição da despesa: ");
                        d.setDescricao(Descricao);

                        String valorDp = JOptionPane.showInputDialog(null, "Digite o valor da despesa: ");
                        float valor = Float.parseFloat(valorDp);
                        d.setValor(valor);
                        
                        String IdCatDp = JOptionPane.showInputDialog(null, "Digite o id da categoria da despesa: ");
                        int idcat = Integer.parseInt(IdCatDp);
                        d.setIdCategoria(idcat);

                        DespesaServico despesa = new DespesaServico();
                        despesa.cadastrar(d);
                        break;

                    case 2:
                        DespesaServico lista = new DespesaServico();
                        String listarDp = "";
                        for (Despesa dp : lista.listar()) {
                            listarDp = (listarDp 
                            		+ dp.getId() + " | "
                                    + dp.getDescricao() + " | "
                                    + dp.getValor() + " | "
                            		+ dp.getIdCategoria() + "\n");
                            
                        }
                        JOptionPane.showMessageDialog(null, listarDp);
                        break;
                        
                    case 3:
                    	String strIddes = JOptionPane.showInputDialog(null, "Insira o ID da despesa");
                        int iddes = Integer.parseInt(strIddes);
                        DespesaServico buscadespesa = new DespesaServico();
                        Despesa procuradespesa = buscadespesa.buscarPorId(iddes).orElse(null);
                        if (procuradespesa.getDescricao() != null){
                          String achado = (procuradespesa.getId() + " | " 
                                  + procuradespesa.getDescricao() + " | "
                                  + procuradespesa.getValor() + " | " 
                                  + procuradespesa.getIdCategoria() + " |\n");
                          JOptionPane.showMessageDialog(null, achado);
                        }
                        else{
                          JOptionPane.showMessageDialog(null, "Não foi possível encontrar o ID!");
                        }
                        break;
                        
                    case 4:
                    	String strId = JOptionPane.showInputDialog("Insira o ID da pessoa que será removida");
                        int Id = Integer.parseInt(strId);

                        DespesaServico remove = new DespesaServico();
                        if (remove.removerPorId(Id) == true){
                          JOptionPane.showMessageDialog(null, "Ação concluída com sucesso!");
                        }
                        else{
                          JOptionPane.showMessageDialog(null, "Ação falhou!");
                        }
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
	
	            /*TODO: OPCAO PARA O USUARIO PRINTAR REGRA IGUALITARIA -> calcularPagamentoRegraIgualitaria()*/
	            /*TODO: OPCAO PARA O USUARIO PRINTAR PRINT DE REGRA PROPORCIONAL -> calcularPagamentoRegraProporcional()*/
	
	        }
	    } while(opcao != 4);

    } 
}
