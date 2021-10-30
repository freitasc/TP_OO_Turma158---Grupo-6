package republica.servico;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import republica.modelo.Despesa;
import java.lang.String;

public class DespesaServico extends Despesa{

    List<Despesa> despesas;
    String nomeArquivo = "Despesas1.txt";

    public DespesaServico() {
        despesas = new LinkedList<Despesa>();
        }
    

    public void cadastrar(republica.modelo.Despesa despesa){
        descricao = JOptionPane.showInputDialog("Informe a descrição da             despesa: ");
        String valorDp = JOptionPane.showInputDialog("Informe o valor da            despesa: ");
        valor = Float.parseFloat(valorDp);
        
        /*Despesa d = new Despesa(descricao, valor); erro nesta linha*/

        boolean resposta = despesas.add(d);
        if (resposta)
                  JOptionPane.showMessageDialog (null, "Despesa cadastrada com sucesso");
        return;
	 }
    public void gravarAlunos() {
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		try {
			out = new FileWriter(nomeArquivo);
			buffer = new BufferedWriter(out);
			
			for (Despesa d : despesas) {
				buffer.write(d.toString());
				buffer.write('\n');
			}
			
			buffer.close();
		} catch (IOException e) {
			
		}
    }
			
			buffer.close();
		} catch (IOException e) {
			
		}
    }
}
