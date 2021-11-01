package republica.controlador;

import java.util.ArrayList;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

import republica.modelo.Categoria;
import republica.servico.CategoriaServico;
import republica.modelo.Aluno;
import republica.servico.AlunoServico;
import republica.modelo.Despesa;
import republica.servico.DespesaServico;

public class Republica {

	public static void main(String[] args) {

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
					case 1:	/*Cadastra em aluno.txt*/
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
					case 2: /*Lista os dados de aluno.txt*/
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
					case 3: /*TODO: BUSCA*/
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
					case 4: /*TODO: REMOVE*/
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
				String strOpcaoCat;
				strOpcaoCat = JOptionPane.showInputDialog("|CATEGORIAS|"
						+ "\n	O que deseja fazer:"
						+ "\n	1 - Cadastrar categoria"
						+ "\n	2 - Listar categorias"
						+ "\n	3 - Buscar categoria por id"
						+ "\n	4 - Remover categoria");
				int opcaoCat = Integer.parseInt(strOpcaoCat);
				switch(opcaoCat) {
					case 1: /*TODO: CADASTRA*/
						Categoria cat = new CategoriaServico();    	
						CategoriaServico a = (CategoriaServico) cat;
						a.cadastrar(a);
						break;	
					case 2: /*TODO: LISTA*/
						break;
					case 3: /*TODO: BUSCA*/
						break;
					case 4: /*TODO: REMOVE*/
						break;
				}
				break;
				
		/*TODO: OPCAO PARA O USUARIO PRINTAR REGRA IGUALITARIA -> calcularPagamentoRegraIgualitaria()*/
		/*TODO: OPCAO PARA O USUARIO PRINTAR PRINT DE REGRA PROPORCIONAL -> calcularPagamentoRegraProporcional()*/
				
		}
    }
}
