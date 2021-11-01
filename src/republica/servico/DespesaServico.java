package republica.servico;

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



public class DespesaServico {

public  boolean cadastrar(Despesa despesa) {

        File bw = null;
	FileWriter fw = null;
	BufferedWriter buffWrite = null;   

        try{
            
            bw = new File("src/republica/dados/Despesas.txt");
            fw = new FileWriter(bw, true);
            buffWrite = new BufferedWriter(fw);

            buffWrite.append (despesa.getId() + ",");

            buffWrite.append (despesa.getDescricao() + ",");

            buffWrite.append (despesa.getValor() + "\n");

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
        File path = new File("src/republica/dados/Despesas.txt");

        try (BufferedReader lerDep = new BufferedReader(new FileReader(path))) {
            String linha = lerDep.readLine();
            while(linha != null){
               
                Despesa temp = new Despesa();
                
                String[] Info = linha.split(",");
                System.out.println(Info[0] + "/" + Info[1]);

                int id = Integer.parseInt(Info[0]);
                temp.setId(id);

                System.out.println(id);

                temp.setDescricao(Info[1]);

                float valorDp = Float.parseFloat(Info[2]);
                temp.setValor(valorDp);

                Despesas.add(temp);
                linha = lerDep.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
                     
        }           
        
        return Despesas;
    }
    public boolean removerPorId(int id) {
   

    return false;
   

    }
    public Optional<Despesa> buscarPorId(int id) {
        
    return null;
    }
    
}
        
