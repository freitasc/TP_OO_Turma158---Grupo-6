package republica.servico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import republica.modelo.Despesa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DespesaServico {
	
    SimpleDateFormat formatter = new SimpleDateFormat("MM_yyyy");
	Date date = new Date();       /* Pega a data atual e gera um arquivo novo a cada mes*/
    File path = new File("src/republica/dados/despesas_" + formatter.format(date) + ".txt"); 

public  boolean cadastrar(Despesa despesa) {
    File bw = null;
	FileWriter fw = null;
	BufferedWriter buffWrite = null;   

        try{
            
            bw = new File("src/republica/dados/despesas_" + formatter.format(date) + ".txt");
            fw = new FileWriter(bw, true);
            buffWrite = new BufferedWriter(fw);

            buffWrite.append (despesa.getId() + ",");

            buffWrite.append (despesa.getDescricao() + ",");

            buffWrite.append (despesa.getValor() + ",");
            
            buffWrite.append (despesa.getIdCategoria() + "\n");

            return true;
            
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
        finally{
            try{
                buffWrite.close();
            }
            catch(IOException exception){
                exception.printStackTrace();
            }
        }
    }

   public List<Despesa> listar() {
        List<Despesa> Despesas;
        Despesas = new ArrayList<Despesa>();

        try (BufferedReader lerDep = new BufferedReader(new FileReader(path))) {
            String linha = lerDep.readLine();
            while(linha != null){
               
                Despesa temp = new Despesa();
                
                String[] Info = linha.split(",");
                
                int id = Integer.parseInt(Info[0]);
                temp.setId(id);

                System.out.println(Info[3]);

                temp.setDescricao(Info[1]);

                float valorDp = Float.parseFloat(Info[2]);
                temp.setValor(valorDp);
                
                int idcat = Integer.parseInt(Info[3]);
                temp.setIdCategoria(idcat);

                Despesas.add(temp);
                linha = lerDep.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
            Despesas = null;
        }           
 
        return Despesas;
    }
   
   
   
   public boolean removerPorId(int id) {
       FileReader fr = null;
       BufferedReader leitorDespesa = null;

       FileWriter fw = null;
       BufferedWriter escreveDespesa = null;

       try{
           fr = new FileReader(path);
           leitorDespesa = new BufferedReader(fr);
           
           List<String> save = new ArrayList<String>();
           String linha = leitorDespesa.readLine();
           
           while(linha != null){
               String[] inf = linha.split(",");
               String strId = ("" + id);
               if (inf[0].equals(strId) == false){
                   save.add(linha);
               }
               linha = leitorDespesa.readLine();
           }

           fw = new FileWriter(path);
           escreveDespesa = new BufferedWriter(fw);

           for(int i = 0 ; i < save.size(); i++){
        	   escreveDespesa.write(save.get(i));
        	   escreveDespesa.newLine();
           }
           
           return true;
       }
       catch(IOException e){ 
           e.printStackTrace();  
           return false;        
       }
       finally{
           try{
        	   leitorDespesa.close();
               
               escreveDespesa.close();
           }
           catch(IOException e){
               e.printStackTrace();
           }
       }
       
   }
   
    
    public Optional<Despesa> buscarPorId(int id) {
        FileReader fr = null;
        BufferedReader leitorDespesa = null;

        Despesa save = new Despesa();
        try {
            fr = new FileReader(path);
            leitorDespesa = new BufferedReader(fr);

            String linha = leitorDespesa.readLine();
            while(linha != null){
                String[] strId = linha.split(",");
                int ID = Integer.parseInt(strId[0]);
                if (id == ID){
                	
                    save.setId(id);
                    
                    save.setDescricao(strId[1]);
                    
                    float valor = Float.parseFloat(strId[2]);
                    save.setValor(valor);
                    
                    int idcat = Integer.parseInt(strId[3]);
                    save.setIdCategoria(idcat);
                    break;
                    
                }
                linha = leitorDespesa.readLine();
            }

            return Optional.of(save);
        }catch(Exception e){
            e.printStackTrace();  
            return Optional.empty(); 
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
        
