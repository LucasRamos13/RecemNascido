/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.RecemNascido;
/**
 *
 * @author Administrador
 */
public class DaoRecemNascido {
     public static boolean inserir(RecemNascido objeto) {
        String sql = "INSERT INTO recemnascido (sexo, numero_do_quarto, peso, nome_da_mae) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSexo());
            ps.setInt(2, objeto.getNumero_do_quarto());
            ps.setDouble(3, objeto.getPeso());
            ps.setString(4, objeto.getNome_da_mae());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
      public static void main(String[] args) {
        RecemNascido objeto = new RecemNascido();
        objeto.setSexo("M");
        objeto.setNumero_do_quarto(1);
        objeto.setPeso(8.00);
        objeto.setNome_da_mae("Jocelina");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
        public static boolean alterar(RecemNascido objeto) {
        String sql = "UPDATE recemnascido SET sexo = ?, numero_do_quarto = ?, peso = ?, nome_da_mae = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSexo()); 
            ps.setInt(2, objeto.getNumero_do_quarto());
            ps.setDouble(3, objeto.getPeso());
            ps.setString(4, objeto.getNome_da_mae());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
          public static boolean excluir(RecemNascido objeto) {
        String sql = "DELETE FROM recemnascido WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
