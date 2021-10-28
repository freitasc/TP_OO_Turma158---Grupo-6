package republica.controlador;

import republica.servico.CategoriaServico;

import javax.swing.JOptionPane;

import republica.modelo.Categoria;

public class Republica {

	public static void main(String[] args) {

		String strOpcao;
    	
		strOpcao = JOptionPane.showInputDialog("Bem vindo ao app de divisão de despesas mensais!!!"
    			+ "\nEscolha uma opção:"
    			+ "\n	1-Pessoas"
    			+ "\n	2-Despesas"
    			+ "\n	3-Categorias");
		
		int opcao = Integer.parseInt(strOpcao);
		
		System.out.println(opcao);
    	
    	
		switch(opcao) {
		
		case 1: 
				
			break;
		case 2:
				
			break;
		case 3:
			String strOpcaoCat;
			
			strOpcaoCat = JOptionPane.showInputDialog("|CATEGORIAS|"
					+ "\n	O que deseja fazer:"
					+ "\n	1-Cadastrar categoria"
					+ "\n	2-Listar categorias"
					+ "\n	3-Buscar categoria por id"
					+ "\n	4-Remover categoria");
			 
			int opcaoCat = Integer.parseInt(strOpcaoCat);
			
			switch(opcaoCat) {
				
			case 1:
				Categoria cat = new CategoriaServico();    	
				CategoriaServico a = (CategoriaServico) cat;
				a.cadastrar(a);
				break;	
			}
			break;
		}
		    	
    
    	
    }
}
