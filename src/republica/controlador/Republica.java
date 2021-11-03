package republica.controlador;

import java.io.IOException;
import republica.servico.DespesaServico;
import javax.swing.JOptionPane;
import republica.modelo.Despesa;

public class Republica {

    public static void main(String[] args) throws IOException {
        String strOpcao;

        strOpcao = JOptionPane.showInputDialog("Bem vindo ao app de divisão de despesas mensais!!!"
                + "\nEscolha uma opção:"
                + "\n	1-Pessoas"
                + "\n	2-Despesas"
                + "\n	3-Categorias");

        int opcao = Integer.parseInt(strOpcao);

        System.out.println(opcao);

        switch (opcao) {

            case 1:

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

            case 3:
                
                        break;
                }
               
        }

    }




