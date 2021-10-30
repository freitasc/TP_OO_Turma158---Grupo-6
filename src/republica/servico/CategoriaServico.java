package republica.servico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;

import republica.modelo.Categoria;

public class CategoriaServico extends Categoria {

	public boolean cadastrar(Categoria categoria) {

		File f=null;
		FileWriter fw =null;
		BufferedWriter buffWrite = null;

		try {
			
			f = new File("./categorias.txt");
			fw = new FileWriter(f);
			buffWrite = new BufferedWriter(fw);

			categoria.descricao = JOptionPane.showInputDialog("Digite a descrição da categoria:");
			System.out.println(categoria.descricao);
			buffWrite.append(categoria.descricao + " | ");

			categoria.subcategoria = JOptionPane.showInputDialog("Digite a subcategoria:");
			System.out.println(categoria.subcategoria);
			buffWrite.append(categoria.subcategoria + " | ");

			String strId = JOptionPane.showInputDialog("Digite o id da categoria: ");
			categoria.id = Integer.parseInt(strId);
			System.out.println(categoria.id);
			buffWrite.append(categoria.id + " \n ");

			return true;

		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("oi pedro");
			return false;
		} finally {
			try {
				buffWrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
