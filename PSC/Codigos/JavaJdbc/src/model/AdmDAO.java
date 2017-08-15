package model;

import Entidades.Adm;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author josemar
 */
public class AdmDAO {
     public void Create(Adm adm) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into adm ( nome,senha,login) values (?,?,?)");
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getLogin());
            stmt.setString(3, adm.getSenha());
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Adm");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public boolean CheckLogin(String login ,String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("Select * from adm where login=? and senha=?");
                
            stmt.setString(1,login);
            stmt.setString(2,senha);
                
            rs = stmt.executeQuery();
            
            if(rs.next()){
               check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
        
    }
    
     public void  Update(Adm adm){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update adm Set nome=?,login=?,senha=? Where id = ?");
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getLogin());
            stmt.setString(3, adm.getSenha());
           
            stmt.setInt(4, adm.getId());
            
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso!");
             
            //seila
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    public void  Delete(Adm adm){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from adm where id = ?");
             stmt.setInt(1, adm.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Adm Excluido com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Avaliação!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
  
}
