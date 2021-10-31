package republica.servico;

import republica.modelo.Aluno;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class AlunoServico{

    public boolean cadastrar(Aluno aluno) {

        Aluno pessoa = new Aluno();

        File Alunofile = null;
		FileWriter writeAluno = null;
		BufferedWriter bufferAluno = null;        

        try{
            Alunofile = new File("./Aluno.txt");
            writeAluno = new FileWriter(Alunofile);
            bufferAluno = new BufferedWriter(writeAluno);

            String strID = JOptionPane.showInputDialog(null, "Id da pessoa: ");
            int id = Integer.parseInt(strID);
            pessoa.setId (id);
            bufferAluno.append (pessoa.getId() + "\n");

            String Nome = JOptionPane.showInputDialog(null, "Nome da pessoa: ");
            pessoa.setNome (Nome);
            bufferAluno.append (pessoa.getNome() + " | ");

            String Email = JOptionPane.showInputDialog(null, "Email da pessoa: ");;
            pessoa.setEmail (Email);
            bufferAluno.append (pessoa.getEmail() + " | ");

            String strRenda = JOptionPane.showInputDialog(null, "Renda da pessoa: ");
            float Renda = Float.parseFloat(strRenda);
            pessoa.setRenda(Renda);
            bufferAluno.append (pessoa.getRenda() + " | ");

            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
        finally{
            try{
                bufferAluno.close();
            }
            catch(IOException exception){
                exception.printStackTrace();
            }
        }
    }

    public boolean removerPorId(int id) {
        return true;
    }

    public Optional<Aluno> buscarPorId(int id) {
        return null;
    }

    public List<Aluno> listar() {
        return null;
    }
}
