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

public class CalculoIgualitario {
	
	public float qtdPessoa() {
		
		File path = new File("src/republica/dados/aluno.txt");
        FileReader fr = null;
        BufferedReader leitorAluno = null;
        int qtrPessoa = 0;

        try {
            fr = new FileReader(path);
            leitorAluno = new BufferedReader(fr);

            String linha = leitorAluno.readLine();
            while(linha != null){
                qtrPessoa = qtrPessoa + 1;
                linha = leitorAluno.readLine();
            }

            return qtrPessoa;
        }catch(Exception e){
            e.printStackTrace();  
            return 0; 
        }
        finally{
            try{
                leitorAluno.close();
            }
            catch(Exception e){
                e.printStackTrace(); 
            }
            
        }
        
	}
	
}
