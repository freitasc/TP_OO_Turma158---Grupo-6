package republica.servico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import republica.modelo.Aluno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileReader;


public class CalculoProporcional {
	
	public float rendaTotal() {
		
		File path = new File("src/republica/dados/aluno.txt");
        FileReader fr = null;
        BufferedReader leitorAluno = null;
        float rendaT = 0;

        try {
            fr = new FileReader(path);
            leitorAluno = new BufferedReader(fr);

            String linha = leitorAluno.readLine();
            while(linha != null){
            	String[] strId = linha.split(",");
                float renda = Float.parseFloat(strId[3]);
                
                rendaT = rendaT + renda;
                linha = leitorAluno.readLine();
                
            }

            return rendaT;
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
	public void porcentagem(float rendaT) {
		
		File path = new File("src/republica/dados/aluno.txt");
        FileReader fr = null;
        BufferedReader leitorAluno = null;
        float por = 0;
        float resultado = 0;

        try {
            fr = new FileReader(path);
            leitorAluno = new BufferedReader(fr);

            String linha = leitorAluno.readLine();
            while(linha != null){
            	String[] strId = linha.split(",");
            	String nome = strId[1];
                float renda = Float.parseFloat(strId[3]);
                
                por = (renda*100)/rendaT;
                
                resultado = Math.round((despesaTotal() * por)/100);
                
                JOptionPane.showMessageDialog(null, nome + " deve pagar R$" + resultado);
                
                linha = leitorAluno.readLine();
                
            }
        }catch(Exception e){
            e.printStackTrace();   
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
	public float despesaTotal() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM_yyyy");
		Date date = new Date();
		File path = new File("src/republica/dados/despesas_" + formatter.format(date) + ".txt");
        FileReader fr = null;
        BufferedReader leitorDespesa = null;
        float despesaT = 0;

        try {
            fr = new FileReader(path);
            leitorDespesa = new BufferedReader(fr);

            String linha = leitorDespesa.readLine();
            while(linha != null){
            	String[] strId = linha.split(",");
                float despesa = Float.parseFloat(strId[2]);
                             
                despesaT = despesaT + despesa;
                              
                linha = leitorDespesa.readLine();
                
            }
            return despesaT;
        }catch(Exception e){
            e.printStackTrace();   
            return 0;
        }
        finally{
            try{
                leitorDespesa.close();
            }
            catch(Exception e){
                e.printStackTrace(); 
            }
            
        }
		
        
	}
	
	

}
