/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoRecemNascido;
import javax.swing.JOptionPane;
import modelo.RecemNascido;
import tela.manutencao.ManutencaoRecemNascido;
/**
 *
 * @author Administrador
 */
public class ControladorRecemNascidos {
    public static void inserir(ManutencaoRecemNascido man){
        RecemNascido objeto = new RecemNascido();
        objeto.setSexo((String) man.jtfSexo.getSelectedItem());
        objeto.setNome_da_mae(man.jtfNomedamae.getText());
        objeto.setNumero_do_quarto(Integer.parseInt(man.jtfNumerodoquarto.getText()));
        objeto.setPeso(Double.parseDouble(man.jtfPeso.getText()));
        
        boolean resultado = DaoRecemNascido.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    public static void alterar(ManutencaoRecemNascido man){
        RecemNascido objeto = new RecemNascido();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome_da_mae(man.jtfNomedamae.getText());
        objeto.setNumero_do_quarto(Integer.parseInt(man.jtfNumerodoquarto.getText()));
        objeto.setPeso(Double.parseDouble(man.jtfPeso.getText()));
        objeto.setSexo((String) man.jtfSexo.getSelectedItem());
        
        boolean resultado = DaoRecemNascido.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
     public static void excluir(ManutencaoRecemNascido man){
        RecemNascido objeto = new RecemNascido();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoRecemNascido.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
