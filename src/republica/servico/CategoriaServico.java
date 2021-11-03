package republica.servico;

import republica.exception.CategoriaNaoInformadaException;
import republica.modelo.Categoria;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;

import republica.modelo.Categoria;

public class CategoriaServico {

    private final String ARQUIVO = "src/republica/dados/categorias.txt";
    public boolean cadastrar(Categoria categoria) {
        if (categoria == null)
            throw new CategoriaNaoInformadaException();
        List<Categoria> categorias = lerDoArquivo();
        categoria.setId(categorias.isEmpty() ? 1 : categorias.get(categorias.size() - 1).getId() + 1);
        categorias.add(categoria);
        return escreverNoArquivo(categorias);
    }

    public boolean removerPorId(int id) {
        List<Categoria> categorias = lerDoArquivo();
        if (categorias.removeIf(categoria -> categoria.getId() == id)) {
            escreverNoArquivo(categorias);
            return true;
        }
        return false;
    }

    public Optional<Categoria> buscarPorId(int id) {
        List<Categoria> categorias = lerDoArquivo();
        return categorias.stream().filter(categoria -> categoria.getId() == id).findFirst();
    }

    public List<Categoria> listar() {
        return lerDoArquivo();
    }

    private boolean escreverNoArquivo(List<Categoria> categorias) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Categoria categoria : categorias) {
                escritor.append(Integer.toString(categoria.getId())).append(",")
                        .append(categoria.getDescricao()).append(",")
                        .append(categoria.getSubcategoria()).append("\n");
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao acessar arquivo. " + e.getMessage());
        }
    }

    private List<Categoria> lerDoArquivo() {
        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO))) {
            List<Categoria> categorias = new ArrayList<>();
            String categoriaString;
            do {
                categoriaString = leitor.readLine();
                if (categoriaString != null) {
                    String[] categoriaArray = categoriaString.split(",");
                    categorias.add(new Categoria(Integer.parseInt(categoriaArray[0]), categoriaArray[1], categoriaArray[2]));
                }
            } while (categoriaString != null);
            return categorias;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao acessar arquivo. " + e.getMessage());
        }
    }
}
