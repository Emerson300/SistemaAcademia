/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entidades.Treino;
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
 * @author emerson
 */
public class TreinoDao {
     public void Create(Treino treino) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("insert into treino (nome,cronograma)values(?,?)");
            stmt.setString(1, treino.getNome());
            stmt.setString(2, treino.getCronograma());
            
            stmt.executeUpdate();
        
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Treino");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List <Treino> Read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Treino> treinos =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from treino");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Treino treino = new Treino();
                
                treino.setId(rs.getInt("id"));
                treino.setNome(rs.getString("nome"));
                treino.setCronograma(rs.getString("cronograma"));
                
                treinos.add(treino);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return treinos;
        
    }
    public List <Treino> ReadForName(String nome){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        
        List <Treino> treinos =new ArrayList();
        
        try {
            stmt = con.prepareStatement("Select * from treino where nome like ?");
            stmt.setString(1,"%"+nome+"%");
           
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Treino treino = new Treino();
                
                treino.setId(rs.getInt("id"));
                treino.setNome(rs.getString("nome"));
                treino.setCronograma(rs.getString("cronograma"));
                
                treinos.add(treino);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return treinos;
        
    }
    
     public void  Update(Treino treino){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
            stmt = con.prepareStatement("Update treino Set nome=?,cronograma=? Where id = ?");
            stmt.setString(1, treino.getNome());
            stmt.setString(2, treino.getCronograma());
            
            stmt.setInt(3, treino.getId());
            
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    public void  Delete(Treino treino){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
         
        try {
             stmt = con.prepareStatement("Delete from treino where id = ?");
             stmt.setInt(1, treino.getId());
             
             stmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Treino Excluido com Sucesso!");
             
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Erro ao Excluir Treino!"+e);
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
