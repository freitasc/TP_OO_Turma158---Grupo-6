package republica.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import republica.modelo.Despesa;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DespesaServico extends Despesa {

    public boolean cadastrar(Despesa despesa) {

        File bw = null;
        FileWriter fw = null;
        BufferedWriter buffWrite = null;

        try {

            bw = new File("./Despesa.txt");
            fw = new FileWriter(bw, true);
            buffWrite = new BufferedWriter(fw);

            String idDp = JOptionPane.showInputDialog("Id da despesa: ");
            despesa.id = Integer.parseInt(idDp);
            System.out.println(despesa.id);
            buffWrite.append(despesa.id + ";");

            despesa.descricao = JOptionPane.showInputDialog("Digite a descrição da despesa: ");
            System.out.println(despesa.descricao);
            buffWrite.append(despesa.descricao + ";");

            String valorDp = JOptionPane.showInputDialog("Digite o valor da despesa:");
            valor = Float.parseFloat(valorDp);
            System.out.println(despesa.valor);
            buffWrite.append(despesa.valor + ".\n");

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

    public void listar() {
        List<String[]> lista = new ArrayList<>();
        try {

            FileReader fr = new FileReader("./Despesa.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null) {
                lista.add(str.split(";"));
            }
            lista.forEach(a -> System.out.println(Arrays.toString(a)));

            String textoArquivo = "";
            for (String[] nome : lista) {
                textoArquivo += nome + "\n";
            }
            JOptionPane.showMessageDialog(null, textoArquivo);

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");

        }
    }

}

