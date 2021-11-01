package republica.servico;

import republica.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.io.File;
import java.io.FileReader;


public class AlunoServico{

    public boolean cadastrar(Aluno pessoa) {

        File Alunofile = null;
		FileWriter writeAluno = null;
		BufferedWriter bufferAluno = null;        

        try{
            Alunofile = new File("src/republica/dados/aluno.txt");
            writeAluno = new FileWriter(Alunofile, true);
            bufferAluno = new BufferedWriter(writeAluno);

            bufferAluno.append (pessoa.getId() + ",");

            bufferAluno.append (pessoa.getNome() + ",");

            bufferAluno.append (pessoa.getEmail() + ",");

            bufferAluno.append (pessoa.getRenda() + "\n");

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
    
    public List<Aluno> listar() {
        List<Aluno> Alunos;
        Alunos = new ArrayList<Aluno>();
        File path = new File("src/republica/dados/aluno.txt");

        try (BufferedReader RAluno = new BufferedReader(new FileReader(path))) {
            String linha = RAluno.readLine();
            while(linha != null){
                //int i = 0;
                Aluno tmp = new Aluno();
                
                String[] Info = linha.split(",");
                System.out.println(Info[0] + "/" + Info[1]);

                int id = Integer.parseInt(Info[0]);
                tmp.setId(id);

                System.out.println(id);

                tmp.setNome(Info[1]);

                tmp.setEmail(Info[2]);

                float renda = Float.parseFloat(Info[3]);
                tmp.setRenda(renda);

                //Alunos.add(i, tmp);
                //i++;
                Alunos.add(tmp);
                linha = RAluno.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
            Alunos = null;            
        }           
        
        

        return Alunos;
    }

    public boolean removerPorId(int id) {
        File path = new File("src/republica/dados/aluno.txt");
        FileReader fr = null;
        BufferedReader leitorAluno = null;

        FileWriter fw = null;
        BufferedWriter escreveAluno = null;

        try{
            fr = new FileReader(path);
            leitorAluno = new BufferedReader(fr);
            
            List<String> save = new ArrayList<String>();
            String linha = leitorAluno.readLine();
            
            while(linha != null){
                String[] inf = linha.split(",");
                String strId = ("" + id);
                if (inf[0].equals(strId) == false){
                    save.add(linha);
                }
                linha = leitorAluno.readLine();
            }

            fw = new FileWriter(path);
            escreveAluno = new BufferedWriter(fw);

            for(int i = 0 ; i < save.size(); i++){
                escreveAluno.write(save.get(i));
                escreveAluno.newLine();
            }
            
            return true;
        }
        catch(IOException e){ 
            e.printStackTrace();  
            return false;        
        }
        finally{
            try{
                leitorAluno.close();
                
                escreveAluno.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }

    public Optional<Aluno> buscarPorId(int id) {
        return null;
    }

    
}
