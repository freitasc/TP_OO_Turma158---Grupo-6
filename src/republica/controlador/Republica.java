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
						AlunoServico Pessoa = new AlunoServico();
						Pessoa.cadastrar();
						break;
					case 2: /*TODO: LISTA*/
						AlunoServico lista = new AlunoServico();
						for (Aluno a : lista.listar()){
							JOptionPane.showMessageDialog(null, a.getId() + " | " 
															+ a.getNome() + " | "
															+ a.getEmail() + " | " 
															+ a.getRenda() + " |\n");
						}						
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
