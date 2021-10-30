package republica.servico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import republica.modelo.Despesa;
import java.lang.String;



public class DespesaServico extends Despesa{

    public boolean cadastrar(Despesa despesa) {

		File bw = null;
		FileWriter fw = null;
		BufferedWriter buffWrite = null;

		try {

			bw = new File("./Despesa.txt");
			fw = new FileWriter(bw);
			buffWrite = new BufferedWriter(fw);
                        
                        String idDp = JOptionPane.showInputDialog("Id da despesa: ");
			despesa.id = Integer.parseInt(idDp);
			System.out.println(despesa.id);
			buffWrite.append(despesa.id + " \n ");

			despesa.descricao = JOptionPane.        showInputDialog("Digite a descrição da despesa: ");
			System.out.println(despesa.descricao);
			buffWrite.append(despesa.descricao + " | ");

                        String valorDp = JOptionPane.showInputDialog("Digite o valor da despesa:");
                        valor = Float.parseFloat(valorDp);
			System.out.println(despesa.valor);
			buffWrite.append(despesa.valor + " | ");

			                 JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");

			return true;

		} catch (Exception ecxp) {
			ecxp.printStackTrace(System.out);
			return false;
		} finally {
			try {
				buffWrite.close();
			} catch (IOException ecxp) {
				ecxp.printStackTrace();
			}
		}
			
		}
   
}


